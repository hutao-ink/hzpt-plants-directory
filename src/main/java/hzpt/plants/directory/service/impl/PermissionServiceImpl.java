package hzpt.plants.directory.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoTools.core.IdUtil.IdUtil;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.po.Permission;
import hzpt.plants.directory.mapper.PermissionMapper;
import hzpt.plants.directory.mapper.UserPermissionMapper;
import hzpt.plants.directory.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/21
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
    @Resource
    private PermissionMapper permissionMapper;
    @Resource
    private UserPermissionMapper userPermissionMapper;
    @Override
    public Result addPermission(String name,String path) {
        Permission permission=new Permission();
        permission.setId(IdUtil.simpleUUID());
        permission.setPermissionName(name);
        permission.setCreateTime(new Date());
        permissionMapper.insert(permission);
        return new Result().result200("添加权限成功",path);
    }


}
