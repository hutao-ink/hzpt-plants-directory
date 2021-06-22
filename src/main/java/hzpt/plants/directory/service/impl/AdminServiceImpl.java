package hzpt.plants.directory.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.po.Cipher;
import hzpt.plants.directory.entity.po.Permission;
import hzpt.plants.directory.entity.po.User;
import hzpt.plants.directory.entity.po.UserPermission;
import hzpt.plants.directory.entity.vo.GetUserInfoVo;
import hzpt.plants.directory.mapper.CipherMapper;
import hzpt.plants.directory.mapper.PermissionMapper;
import hzpt.plants.directory.mapper.UserMapper;
import hzpt.plants.directory.mapper.UserPermissionMapper;
import hzpt.plants.directory.service.AdminService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/21
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private CipherMapper cipherMapper;
    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    @Resource
    private PermissionMapper permissionMapper;
    @Resource
    private UserPermissionMapper userPermissionMapper;

    /**
     * <p>管理员登录</p>
     * @author tfj
     * @since 2021/6/21
     */
    @Override
    public Result login(String nickName, String cipher, String path) {
        if (nickName==null||cipher==null){
            return new Result().result200("昵称和密码不能为空",path);
        }
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("nickName",nickName));
        Cipher userCipher = cipherMapper.selectOne(new QueryWrapper<Cipher>().eq("openId", user.getOpenId()));
        if (user.getOpenId().equals(userCipher.getOpenId())&&userCipher.getCipher().equals(cipher)){
            redisTemplate.opsForValue().set(user.getOpenId(),user,7, TimeUnit.DAYS);
            StpUtil.setLoginId(user.getNickName());
            Map<String, Object> map=new HashMap<>(1);
            map.put("info","登录成功");
            map.put("openId",user.getOpenId());
            return new Result().result200(map,path);
        }
        return new Result().result200("登录失败",path);
    }

    /**
     * <p>获取所有用户信息</p>
     * @author tfj
     * @since 2021/6/21
     */
    @Override
    public Result getAllUserInfo(String path) {
        List<GetUserInfoVo> allUserInfo = userMapper.getAllUserInfo();
        return new Result().result200(allUserInfo,path);
    }

    /**
     * <p>修改用户权限</p>
     * @author tfj
     * @since 2021/6/21
     */
    @Override
    public Result updateUserPermission(String openId, String permissionName, String path) {
        UserPermission userPermission = userPermissionMapper.selectOne(new QueryWrapper<UserPermission>().eq("openId", openId));
        Permission admin = permissionMapper.selectOne(new QueryWrapper<Permission>().eq("permissionName", "管理员"));
        if (admin.getId().equals(userPermission.getPermissionId())){
            return new Result().result403("无法修改该管理员权限",path);
        }
        Permission permission = permissionMapper.selectOne(new QueryWrapper<Permission>().eq("permissionName", permissionName));

        userPermission.setPermissionId(permission.getId());
        userPermissionMapper.updateById(userPermission);
        return new Result().result200("修改权限成功",path);
    }
}
