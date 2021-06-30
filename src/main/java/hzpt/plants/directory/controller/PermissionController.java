package hzpt.plants.directory.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.service.PermissionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/21
 */
@RestController
@CrossOrigin()
@RequestMapping("/permission")
public class PermissionController {

    @Resource
    private PermissionService permissionService;
    /**
     * <p></p>
     * @author tfj
     * @since 2021/6/21
     */
    @ApiOperation(value = "添加权限")
    @PostMapping("/addPermission")
    public Result addPermission(String name){
        if (!StpUtil.hasRole("管理员")){
            return new Result().result403("无权限访问","permission/addPermission");
        }
        return permissionService.addPermission(name,"permission/addPermission");
    }

}
