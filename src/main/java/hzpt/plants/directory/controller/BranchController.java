package hzpt.plants.directory.controller;


import cn.dev33.satoken.stp.StpUtil;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.dto.PostBranchDto;
import hzpt.plants.directory.service.BranchService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tfj
 * @since 2021-06-06
 */
@RestController
@RequestMapping("/branch")
public class BranchController {
    @Resource
    private BranchService branchService;

    /**
     * <p>获取科目总数</p>
     * @author tfj
     * @since 2021/6/7
     */
    @ApiOperation(value = "获取科目总数")
    @GetMapping("/branchCount")
    public Result branchCount(){
        int count = branchService.count();
        return new Result().result200(count,"/branch/branchCount");
    }

    /**
     * <p>查询所有科目</p>
     * @author tfj
     * @since 2021/6/7
     */
    @ApiOperation(value = "查询所有科目")
    @GetMapping("/searchBranch")
    public Result searchBranch(){
        return branchService.searchBranch("/branch/searchBranch");
    }

     /**
     * <p>查询植物科目</p>
     * @author tfj
     * @since 2021/6/13
     */
    @ApiOperation(value = "查询植物科目")
    @GetMapping("/searchPlantBranch")
    public Result searchPlantBranch(){
        return branchService.searchPlantBranch("/branch/searchPlantBranch");
    }

    /**
     * <p>查询动物科目</p>
     * @author tfj
     * @since 2021/6/13
     */
    @ApiOperation(value = "查询动物科目")
    @GetMapping("/searchAnimalBranch")
    public Result searchAnimalBranch(){
        return branchService.searchAnimalBranch("/branch/searchAnimalBranch");
    }


    /**
     * <p>通过科名获取科信息</p>
     * @author tfj
     * @since 2021/6/16
     */
    @ApiOperation(value = "通过科名获取科信息")
    @GetMapping("/getBranchInfo")
    public Result getBranchInfo(@RequestParam String branch){
        return branchService.getBranchInfo(branch,"/genus/getBranchInfo");
    }

    /**
     * <p>添加科目</p>
     * @author tfj
     * @since 2021/6/7
     */
    @ApiOperation(value = "添加科目")
    @PostMapping("/insertBranch")
    public Result insertBranch(@RequestParam String branchName){
        if (!StpUtil.hasRole("管理员")){
            return new Result().result403("无权限访问","branch/insertBranch");
        }
        return branchService.insertBranch(branchName,"branch/insertBranch");
    }

    /**
     * <p>添加科目图片</p>
     * @author tfj
     * @since 2021/6/22
     */
    @ApiOperation(value = "添加科目图片")
    @PostMapping("/insertBranchImage")
    public Result insertBranchImage(@RequestPart MultipartFile file,@RequestParam String branchName){
        if (!StpUtil.hasRole("管理员")){
            return new Result().result403("无权限访问","branch/insertBranchImage");
        }
        return branchService.insertBranchImage(file,branchName,"branch/insertBranchImage");
    }

    /**
     * <p>删除科目</p>
     * @author tfj
     * @since 2021/6/22
     */
    @ApiOperation(value = "删除科目")
    @DeleteMapping("/deleteBranchById")
    public Result deleteBranchById(@RequestParam String branchId){
        if (!StpUtil.hasRole("管理员")){
            return new Result().result403("无权限访问","branch/deleteBranchById");
        }
        return branchService.deleteBranchById(branchId,"branch/deleteBranchById");
    }
    /**
     * <p>修改科目信息</p>
     * @author tfj
     * @since 2021/6/22
     */
    @ApiOperation(value = "")
    @PutMapping("/putBranchById")
    public Result putBranchById(@RequestBody PostBranchDto postBranchDto){
        if (!StpUtil.hasRole("管理员")){
            return new Result().result403("无权限访问","branch/putBranchById");
        }
       return branchService.putBranchById(postBranchDto,"branch/putBranchById");
    }
    /**
     * <p>修改科目图片</p>
     * @author tfj
     * @since 2021/6/22
     */
    @ApiOperation(value = "")
    @PutMapping("/putBranchImage")
    public Result putBranchImage(@RequestPart MultipartFile file,@RequestParam String branchId){
        if (!StpUtil.hasRole("管理员")){
            return new Result().result403("无权限访问","branch/putBranchImage");
        }
        return branchService.putBranchImage(file,branchId,"branch/putBranchImage");
    }

}

