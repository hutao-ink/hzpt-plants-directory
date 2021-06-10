package hzpt.plants.directory.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.dto.PostUserDto;
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
    /**
     * <p>微信用户登录</p>
     * @author tfj
     * @since 2021/6/10
     */
    Result userLoginWx(PostUserDto postUserDto,String code, String path);
    /**
     * <p>获取最新的二十条添加记录</p>
     * @author tfj
     * @since 2021/6/10
     */
    Result getNewestTwentyBiological(String path);
}
