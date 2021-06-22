package hzpt.plants.directory.service;

import com.xiaoTools.core.result.Result;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/21
 */
public interface AdminService {
    /**
     * <p>管理员登录</p>
     * @author tfj
     * @since 2021/6/21
     */
    Result login(String nickName, String cipher, String path);
    /**
     * <p>获取所有用户信息</p>
     * @author tfj
     * @since 2021/6/21
     */
    Result getAllUserInfo(String path);
    /**
     * <p>修改用户权限</p>
     * @author tfj
     * @since 2021/6/21
     */
    Result updateUserPermission(String openId, String permissionName, String path);
}
