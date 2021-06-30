package hzpt.plants.directory.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.service.CipherService;
import io.swagger.annotations.Api;
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
@RequestMapping("/cipher")
public class CipherController {
    @Resource
    private CipherService cipherService;
    /**
     * <p>添加管理员权限密码</p>
     * @author tfj
     * @since 2021/6/21
     */
    @ApiOperation(value = "添加管理员权限密码")
    @PostMapping("/insertCipher")
    public Result insertCipher(@RequestParam String openId){
        if (!StpUtil.hasRole("管理员")){
            return new Result().result403("无权限访问","admin/insertCipher");
        }
        return  cipherService.insertCipher(openId,"admin/insertCipher");
    }

}
