package hzpt.plants.directory.controller;

import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.dto.PostUserDto;
import hzpt.plants.directory.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;


/**
 * <p></p>
 * @author tfj
 * @since 2021/6/7
 */
@CrossOrigin
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
     * <p>微信用户获取登录凭证</p>
     * @author tfj
     * @since 2021/6/10
     */
    @ApiOperation(value = "微信用户获取登录凭证")
    @GetMapping("/userLogin")
    public Result userLoginWx(String code){
        return userService.userLoginWx(code,"/user/userLoginWx");
    }
    /**
     * <p>获取微信用户信息</p>
     * @author tfj
     * @since 2021/6/11
     */
    @ApiOperation(value = "获取微信用户信息")
    @PostMapping("/getUserInfo")
    public Result getUserInfo(@RequestBody PostUserDto postUserDto){
        return userService.getUserInfo(postUserDto,"/user/getUserInfo");
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

    /**
     * <p>用户批量上传图片</p>
     * @author tfj
     * @since 2021/6/12
     */
    @ApiOperation(value = "用户批量上传图片")
    @PostMapping("/userUploadImages")
    public Result userUploadImages(@RequestPart MultipartFile multipartFile,String userId){
        return userService.userUploadImages(multipartFile,userId,"/user/userUploadImages");
    }
    /**
     * <p>用户留言</p>
     * @author tfj
     * @since 2021/6/12
     */
    @ApiOperation(value = "用户留言")
    @PostMapping("/userMessage")
    public Result userMessage(String userId,String message){
        return userService.userMessage(userId,message,"/user/userMessage");
    }

}
