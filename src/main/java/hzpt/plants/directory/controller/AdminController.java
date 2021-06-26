package hzpt.plants.directory.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.service.AdminService;
import hzpt.plants.directory.service.CipherService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/21
 */
@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;
    @Resource
    private CipherService cipherService;

    /**
     * <p>管理员登录</p>
     * @author tfj
     * @since 2021/6/21
     */
    @ApiOperation(value = "管理员登录")
    @GetMapping("/login")
    public Result login(@RequestParam String nickName,String cipher){
       return adminService.login(nickName,cipher,"admin/login");
    }

    /**
     * <p>获取所有用户信息</p>
     * @author tfj
     * @since 2021/6/21
     */
    @ApiOperation(value = "获取所有用户信息")
    @GetMapping("/getALlUserIndo")
    public Result getAllUserInfo(){
        if (!StpUtil.hasRole("管理员")){
            return new Result().result403("无权限访问","admin/getAllUserInfo");
        }
        return adminService.getAllUserInfo("admin/getALlUserIndo");
    }
    /**
     * <p>修改用户权限</p>
     * @author tfj
     * @since 2021/6/21
     */
    @ApiOperation(value = "修改用户权限")
    @PutMapping("/updateUserPermission")
    public Result updateUserPermission(@RequestParam String openId,String permissionName){
        if (!StpUtil.hasRole("管理员")){
            return new Result().result403("无权限访问","admin/updateUserPermission");
        }
        return adminService.updateUserPermission(openId,permissionName,"admin/updateUserPermission");
    }

    /**
     * <p>管理员修改密码</p>
     * @author tfj
     * @since 2021/6/21
     */
    @ApiOperation(value = "管理员修改密码")
    @PutMapping("/putCipher")
    public Result putCipher(@RequestParam String cipher,@RequestParam String oldCipher, String openId){
        if (!StpUtil.hasRole("管理员")){
            return new Result().result403("无权限访问","admin/putCipher");
        }
        return cipherService.putCipher(openId,cipher,oldCipher,"admin/putCipher");
    }
}
