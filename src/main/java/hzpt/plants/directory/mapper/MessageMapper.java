package hzpt.plants.directory.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import hzpt.plants.directory.entity.po.Message;
import hzpt.plants.directory.entity.vo.GetMessagesVo;

import java.util.List;

/**
 * @Author: tfj
 * @Date: 2021/6/12 14
 * @Description:
 */
public interface MessageMapper extends BaseMapper<Message> {
    List<GetMessagesVo> getUserMessageById(String openId);

    List<GetMessagesVo> getAllMessage();
}
