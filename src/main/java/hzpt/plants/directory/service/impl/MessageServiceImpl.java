package hzpt.plants.directory.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import hzpt.plants.directory.entity.po.Message;
import hzpt.plants.directory.mapper.MessageMapper;
import hzpt.plants.directory.service.MessageService;
import org.springframework.stereotype.Service;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/12
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {
}
