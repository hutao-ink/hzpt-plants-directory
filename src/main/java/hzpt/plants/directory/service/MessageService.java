package hzpt.plants.directory.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.po.Message;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/12
 */
public interface MessageService extends IService<Message> {
    /**
     * <p>展示所有用户留言</p>
     * @author tfj
     * @since 2021/6/12
     */
    Result getAllMessages(Integer currentPage,String path);
    /**
     * <p>删除用户留言</p>
     * @author tfj
     * @since 2021/6/22
     */
    Result deleteUserMessages(String messageId, String path);
}
