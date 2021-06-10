package hzpt.plants.directory.controller;

import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.dto.PostUserDto;
import hzpt.plants.directory.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * <p></p>
 * @author tfj
 * @since 2021/6/7
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * <p>用户搜索动植物</p>
     * @author tfj
     * @since 2021/6/8
     */
    @ApiOperation(value = "用户搜索动植物")
    @GetMapping("/fuzzyQuery")
    public Result fuzzyQueryByName(@RequestParam String name){
        return userService.fuzzyQuery(name,"/user/fuzzyQueryByName");
    }
    /**
     * <p>微信用户登录</p>
     * @author tfj
     * @since 2021/6/10
     */
    @ApiOperation(value = "微信用户登录")
    @GetMapping("/userLogin")
    public Result userLoginWx(@RequestBody PostUserDto postUserDto,HttpServletRequest request){
        String code=request.getParameter("code");
        return userService.userLoginWx(postUserDto,code,"/user/userLoginWx");
    }
    /**
     * <p>获取最新的二十条添加记录</p>
     * @author tfj
     * @since 2021/6/10
     */
    @ApiOperation(value = "获取最新的二十条添加记录")
    @GetMapping("/getNewestTwentyBiological")
    public Result getNewestTwentyBiological(){
        return userService.getNewestTwentyBiological("/user/getNewestTwentyBiological");
    }

}
