package hzpt.plants.directory.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import hzpt.plants.directory.entity.po.Permission;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/21
 */
public interface PermissionMapper extends BaseMapper<Permission> {
    void addUserPermission(String openId, String name);
}
