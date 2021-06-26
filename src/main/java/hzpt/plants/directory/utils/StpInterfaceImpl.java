package hzpt.plants.directory.utils;

import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpUtil;
import hzpt.plants.directory.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.annotation.Resource;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/21
 */
@Component
@Slf4j
public class StpInterfaceImpl implements StpInterface {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public List<String> getPermissionList(Object openId, String s) {
      return null;
    }

    @Override
    public List<String> getRoleList(Object nickName, String s) {

        List<String> list=new ArrayList<>();
        String permissionByNickName = userMapper.getPermissionByNickName((String) nickName);
        if (permissionByNickName.equals("管理员")){
            list.add("管理员");
        }else if (permissionByNickName.equals("普通用户")){
            list.add("普通用户");
        }else if (permissionByNickName.equals("黑名单")){
           list.add("黑名单");
        }
        return list;
    }

}
