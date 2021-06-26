package hzpt.plants.directory.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.service.MessageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/12
 */
@RestController
@CrossOrigin
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
    public Result getAllMessages(@RequestParam Integer currentPage){
        return messageService.getAllMessages(currentPage,"/message/getAllMessages");
    }

    /**
     * <p>删除用户留言</p>
     * @author tfj
     * @since 2021/6/22
     */
    @ApiOperation(value = "删除用户留言")
    @DeleteMapping("/deleteUserMessages")
    public Result deleteUserMessages(@RequestParam String messageId){
        if (!StpUtil.hasRole("管理员")){
            return new Result().result403("无权限访问","message/deleteUserMessages");
        }
        return messageService.deleteUserMessages(messageId,"message/deleteUserMessages");
    }
    /**
     * <p>留言总数</p>
     * @author tfj
     * @since 2021/6/24
     */
    @ApiOperation(value = "留言总数")
    @GetMapping("/messagesCount")
    public Result messagesCount(){
        int count = messageService.count();
        return new Result().result200(count,"/message/messagesCount");
    }
}
