package hzpt.plants.directory.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.po.Permission;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/21
 */
public interface PermissionService extends IService<Permission> {
    /**
     * <p></p>
     * @author tfj
     * @since 2021/6/21
     */
    Result addPermission(String name,String path);

}
