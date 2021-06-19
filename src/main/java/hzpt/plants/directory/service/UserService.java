package hzpt.plants.directory.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.dto.PostUserDto;
import hzpt.plants.directory.entity.po.User;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/8
 */
public interface UserService extends IService<User> {
    /**
     * <p>用户搜索动植物</p>
     * @author tfj
     * @since 2021/6/8
     */
    Result fuzzyQuery(String name,Integer currentPage, String path);
    /**
     * <p>微信用户获取登录凭证</p>
     * @author tfj
     * @since 2021/6/10
     */
    Result userLoginWx(String code, String path);
    /**
     * <p>获取微信用户信息</p>
     * @author tfj
     * @since 2021/6/11
     */
    Result getUserInfo(PostUserDto postUserDto,String path);
    /**
     * <p>获取最新的二十条添加记录</p>
     * @author tfj
     * @since 2021/6/10
     */
    Result getNewestTwentyBiological(String path);
    /**
     * <p>用户留言</p>
     * @author tfj
     * @since 2021/6/13
     */
    Result userAddMessage(String message,String openId,String messageId, String path);
    /**
     * <p>通过用户id获取用户留言</p>
     * @author tfj
     * @since 2021/6/13
     */
    Result getUserMessageById(String openId, String path);
    /**
     * <p>获取所有用户留言信息</p>
     * @author tfj
     * @since 2021/6/13
     */
    Result getAllMessage(String path);
    /**
     * <p>用户上传图片</p>
     * @author tfj
     * @since 2021/6/13
     */
    Result userAddImages(MultipartFile multipartFile, String openId, String path);
}
