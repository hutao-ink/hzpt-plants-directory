package hzpt.plants.directory.service.impl;

import cn.hutool.core.util.IdUtil;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.config.OssConfig;
import hzpt.plants.directory.entity.dto.PostUserDto;
import hzpt.plants.directory.entity.po.*;
import hzpt.plants.directory.entity.vo.GetAnimalsVo;
import hzpt.plants.directory.entity.vo.GetMessagesVo;
import hzpt.plants.directory.entity.vo.GetPlantsVo;
import hzpt.plants.directory.mapper.*;
import hzpt.plants.directory.service.AnimalsService;
import hzpt.plants.directory.service.PlantsService;
import hzpt.plants.directory.service.UserService;
import hzpt.plants.directory.config.WxConfig;
import hzpt.plants.directory.utils.BeansUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;



/**
 * <p></p>
 * @author tfj
 * @since 2021/6/8
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private PlantsService plantsService;
    @Resource
    private AnimalsService animalsService;
    @Resource
    private WxConfig wxConfig;
    @Resource
    private UserMapper userMapper;
    @Resource
    private PlantsMapper plantsMapper;
    @Resource
    private OssConfig ossConfig;
    @Resource
    private MessageMapper messageMapper;
    @Resource
    private UserPermissionMapper userPermissionMapper;
    @Resource
    private PermissionMapper permissionMapper;

    /**
     * <p>用户搜索动植物</p>
     * @author tfj
     * @since 2021/6/8
     */
    @Override
    public Result fuzzyQuery(String name,Integer currentPage, String path) {
        List<GetAnimalsVo> getAnimalsVos = animalsService.fuzzyQueryAnimals(name,currentPage);
        List<GetPlantsVo> getPlantsVos = plantsService.fuzzyQueryPlants(name,currentPage);
        if (getAnimalsVos.size()>0){
            return new Result().result200(getAnimalsVos,path);
        }else if (getPlantsVos.size()>0){
            return new Result().result200(getPlantsVos,path);
        }
        return new Result().result200("未找到",path);
    }

    /**
     * <p>微信用户获取登录凭证</p>
     * @author tfj
     * @since 2021/6/10
     */
    @Override
    public Result userLoginWx(String code, String path) {
        User user=new User();
        CustomUserState responseEntity = wxConfig.getResponseEntity(code);
        user.setId(IdUtil.simpleUUID());
        user.setOpenId(responseEntity.getOpenid());
        user.setCreateTime(new Date());
        User selectOne = userMapper.selectOne(new QueryWrapper<User>().eq("openId", user.getOpenId()));
        if (selectOne!=null){
            return new Result().result200(responseEntity,path);
        }else {
            Permission permission = permissionMapper.selectOne(new QueryWrapper<Permission>().eq("permissionName", "普通用户"));
            UserPermission userPermission=new UserPermission();
            userPermission.setId(IdUtil.simpleUUID());
            userPermission.setOpenId(user.getOpenId());
            userPermission.setCreateTime(new Date());
            userPermission.setPermissionId(permission.getId());
            userPermissionMapper.insert(userPermission);
            userMapper.insert(user);
        }
        return new Result().result200(responseEntity,path);
    }

    /**
     * <p>获取微信用户信息</p>
     * @author tfj
     * @since 2021/6/11
     */
    @Override
    public Result getUserInfo(PostUserDto postUserDto, String path) {
        User getUser = userMapper.selectOne(new QueryWrapper<User>().eq("openId",postUserDto.getOpenId()));
        getUser.setGender(postUserDto.getGender());
        getUser.setImageUrl(postUserDto.getImageUrl());
        getUser.setNickName(postUserDto.getNickName());
        getUser.setCity(postUserDto.getCity());
        getUser.setProvince(postUserDto.getProvince());
        getUser.setCountry(postUserDto.getCountry());
        getUser.setCreateTime(new Date());

        userMapper.update(getUser,new QueryWrapper<User>().eq("openId",postUserDto.getOpenId()));

        return new Result().result200(getUser.toString(),path);
    }

    /**
     * <p>获取最新的二十条添加记录</p>
     * @author tfj
     * @since 2021/6/10
     */
    @Override
    public Result getNewestTwentyBiological(String path) {
        List<Plants> plantsList = plantsMapper.selectList(new QueryWrapper<Plants>().orderByDesc("createTime").last("limit 20"));
        List<GetPlantsVo> getPlantsVoList = BeansUtils.listCopy(plantsList, GetPlantsVo.class);
        return new Result().result200(getPlantsVoList,path);
    }

    /**
     * <p>用户上传图片</p>
     * @author tfj
     * @since 2021/6/13
     */
    @Override
    public Result userAddImages(MultipartFile multipartFile,String openId, String path) {
        OSS ossClient=new OSSClientBuilder().build(ossConfig.getEndpoint(),ossConfig.getAccessKeyId(),ossConfig.getAccessKeySecret());
        if (multipartFile!=null){
            String originalFilename = multipartFile.getOriginalFilename();

            PutObjectRequest putObjectRequest = null;
            try {
                putObjectRequest = new PutObjectRequest(ossConfig.getBucketName(), originalFilename, new ByteArrayInputStream(multipartFile.getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            ossClient.putObject(putObjectRequest);
            ossClient.shutdown();

            String imagesUrl=ossConfig.getDomain()+originalFilename;

            Message addMessage=new Message();
            addMessage.setId(IdUtil.simpleUUID());
            addMessage.setImagesUrl(imagesUrl);
            addMessage.setOpenId(openId);
            addMessage.setCreateTime(new Date());

            messageMapper.insert(addMessage);

            Message message = messageMapper.selectOne(new QueryWrapper<Message>().eq("id", addMessage.getId()));
            if (message.getUserMessage()==null){
                messageMapper.delete(new QueryWrapper<Message>().eq("userMessage",null));
            }
            return new Result().result200(addMessage.getId(),path);
        }else {
            return new Result().result200("请选择图片:",path);
        }
    }
    /**
     * <p>用户留言</p>
     * @author tfj
     * @since 2021/6/13
     */
    @Override
    public Result userAddMessage(String message, String openId,String messageId, String path) {
        if (message.getBytes().length<=10){
            return new Result().result500("留言不得少于5个字:",path);
        }
        Message selectOne = messageMapper.selectOne(new QueryWrapper<Message>().eq("id", messageId));
        if (selectOne!=null){
            selectOne.setUserMessage(message);
            messageMapper.updateById(selectOne);
            return new Result().result200("留言成功",path);
        }else {
            Message addMessage=new Message();
            addMessage.setId(IdUtil.simpleUUID());
            addMessage.setOpenId(openId);
            addMessage.setUserMessage(message);
            addMessage.setCreateTime(new Date());
            messageMapper.insert(addMessage);
            return new Result().result200("留言成功",path);
        }
    }

    /**
     * <p>通过用户id获取用户留言</p>
     * @author tfj
     * @since 2021/6/13
     */
    @Override
    public Result getUserMessageById(String openId, String path) {
        List<GetMessagesVo> messageList = messageMapper.getUserMessageById(openId);
        return new Result().result200(messageList,path);
    }
    /**
     * <p>获取所有用户留言信息</p>
     * @author tfj
     * @since 2021/6/13
     */
    @Override
    public Result getAllMessage(String path) {
        List<GetMessagesVo> allMessage = messageMapper.getAllMessage();
        return new Result().result200(allMessage,path);
    }
}
