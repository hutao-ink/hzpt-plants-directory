package hzpt.plants.directory.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.po.User;

/**
 * @Author: tfj
 * @Date: 2021/6/8 14
 * @Description:
 */
public interface UserService extends IService<User> {
    /**
     * <p>用户搜索动植物</p>
     * @author tfj
     * @since 2021/6/8
     */
    Result fuzzyQuery(String name, String path);
}
