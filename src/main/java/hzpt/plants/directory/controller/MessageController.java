package hzpt.plants.directory.controller;

import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.service.MessageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/12
 */
@RestController
@RequestMapping("/message")
public class MessageController {
    @Resource
    private MessageService messageService;
    /**
     * <p>展示所有用户留言</p>
     * @author tfj
     * @since 2021/6/12
     */
    @ApiOperation(value = "展示所有用户留言")
    @GetMapping("/getAllMessages")
    public Result getAllMessages(){
        return messageService.getAllMessages("/message/getAllMessages");
    }
}
