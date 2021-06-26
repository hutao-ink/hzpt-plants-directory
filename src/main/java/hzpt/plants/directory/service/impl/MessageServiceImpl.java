package hzpt.plants.directory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.po.Branch;
import hzpt.plants.directory.entity.po.Message;
import hzpt.plants.directory.mapper.MessageMapper;
import hzpt.plants.directory.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/12
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {
    @Resource
    private MessageMapper messageMapper;
    /**
     * <p>展示所有用户留言</p>
     * @author tfj
     * @since 2021/6/12
     */
    @Override
    public Result getAllMessages(Integer currentPage,String path) {
        Page<Message> page=new Page<>(currentPage,21);
        IPage<Message> messages=messageMapper.selectPage(page,null);
        return new Result().result200(messages,path);
    }
    /**
     * <p>删除用户留言</p>
     * @author tfj
     * @since 2021/6/22
     */
    @Override
    public Result deleteUserMessages(String messageId, String path) {
        if (messageMapper.deleteById(messageId)==1){
            return new Result().result200("修改成功",path);
        }
        return new Result().result500("修改失败",path);
    }
}
