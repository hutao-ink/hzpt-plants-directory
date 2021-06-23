package hzpt.plants.directory.controller;

import cn.dev33.satoken.stp.StpUtil;
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
     * <p>用户搜索动植物分页</p>
     * @author tfj
     * @since 2021/6/8
     */
    @ApiOperation(value = "用户搜索动植物分页")
    @GetMapping("/fuzzyQuery")
    public Result fuzzyQueryByName(@RequestParam String name,Integer currentPage){
        return userService.fuzzyQuery(name,currentPage,"/user/fuzzyQueryByName");
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
     * <p>用户上传图片</p>
     * @author tfj
     * @since 2021/6/13
     */
    @ApiOperation(value = "用户上传图片")
    @PostMapping(value = "/userAddImages")
    public Result userAddImages(@RequestParam String openId,@RequestPart MultipartFile file) {
//        if (StpUtil.hasRole("黑名单")){
//            return new Result().result403("已被拉黑，无法上传图片","/user/userAddImages");
//        }
        return userService.userAddImages(file,openId,"/user/userAddImages");
    }

    /**
     * <p>用户留言</p>
     * @author tfj
     * @since 2021/6/13
     */
    @ApiOperation(value = "用户留言")
    @GetMapping(value = "/userAddMessage")
    public Result userAddMessage(@RequestParam String message,String openId,String messageId){
//        if (StpUtil.hasRole("黑名单")){
//            return new Result().result403("已被拉黑，无法留言","/user/userAddMessage");
//        }
        return userService.userAddMessage(message,openId,messageId,"/user/userAddMessage");
    }



    /**
     * <p>通过用户openId获取用户留言</p>
     * @author tfj
     * @since 2021/6/13
     */
    @ApiOperation(value = "通过用户openId获取用户留言")
    @GetMapping("/getUserMessageById")
    public Result getUserMessageById(@RequestParam String openId){
        return userService.getUserMessageById(openId,"/user/getUserMessageById");
    }

    /**
     * <p>获取所有用户留言信息</p>
     * @author tfj
     * @since 2021/6/13
     */
    @ApiOperation(value = "获取所有用户留言信息")
    @GetMapping("getAllMessage")
    public Result getAllMessage(){
        return userService.getAllMessage("/user/getAllMessage");
    }

}
