package hzpt.plants.directory.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.po.Cipher;

/**
 * <p>管理员修改密码</p>
 * @author tfj
 * @since 2021/6/21
 */
public interface CipherService extends IService<Cipher> {
    /**
     * <p></p>
     * @author tfj
     * @since 2021/6/21
     */
    Result putCipher(String openId,String cipher,String oldCipher, String path);
    /**
     * <p>添加管理员权限密码</p>
     * @author tfj
     * @since 2021/6/21
     */
    Result insertCipher(String openId, String path);
}
