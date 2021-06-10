package hzpt.plants.directory.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.dto.PostUserDto;
import hzpt.plants.directory.entity.po.CustomUserState;
import hzpt.plants.directory.entity.po.Plants;
import hzpt.plants.directory.entity.po.User;
import hzpt.plants.directory.entity.vo.GetAnimalsVo;
import hzpt.plants.directory.entity.vo.GetPlantsVo;
import hzpt.plants.directory.mapper.PlantsMapper;
import hzpt.plants.directory.mapper.UserMapper;
import hzpt.plants.directory.service.AnimalsService;
import hzpt.plants.directory.service.PlantsService;
import hzpt.plants.directory.service.UserService;
import hzpt.plants.directory.config.WxConfig;
import hzpt.plants.directory.utils.BeansUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
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
    /**
     * <p>用户搜索动植物</p>
     * @author tfj
     * @since 2021/6/8
     */
    @Override
    public Result fuzzyQuery(String name, String path) {
        List<GetAnimalsVo> getAnimalsVos = animalsService.fuzzyQueryAnimals(name);
        List<GetPlantsVo> getPlantsVos = plantsService.fuzzyQueryPlants(name);
        if (getAnimalsVos.size()>0){
            return new Result().result200(getAnimalsVos,path);
        }else if (getPlantsVos.size()>0){
            return new Result().result200(getPlantsVos,path);
        }
        return new Result().result200("未找到",path);
    }

    /**
     * <p>微信用户登录</p>
     * @author tfj
     * @since 2021/6/10
     */
    @Override
    public Result userLoginWx(PostUserDto postUserDto,String code, String path) {
        User addUser=new User();
        CustomUserState responseEntity = wxConfig.getResponseEntity(code);
        addUser.setOpenId(responseEntity.getOpenid());
        if (userMapper.selectList(new QueryWrapper<User>().eq("openId",responseEntity.getOpenid())).size()==0){
            addUser.setId(IdUtil.simpleUUID());
            addUser.setUserName(postUserDto.getUserName());
            addUser.setCreateTime(new Date());
            addUser.setOpenId(responseEntity.getOpenid());
            int insert = userMapper.insert(addUser);
            return new Result().result200(insert+"首次登录成功",path);
        }else {
            User user = userMapper.selectOne(new QueryWrapper<User>().eq("openId",responseEntity.getOpenid()));
            return new Result().result200(user,path);
        }
    }

    /**
     * <p>获取最新的二十条添加记录</p>
     * @author tfj
     * @since 2021/6/10
     */
    @Override
    public Result getNewestTwentyBiological(String path) {
        List<Plants> plantsList = plantsMapper.selectList(new QueryWrapper<Plants>().orderByAsc("createTime").last("limit 20"));
        List<GetPlantsVo> getPlantsVoList = BeansUtils.listCopy(plantsList, GetPlantsVo.class);
        return new Result().result200(getPlantsVoList,path);
    }
}
