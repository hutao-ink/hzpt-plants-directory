package hzpt.plants.directory.controller;


import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.service.BranchService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
     * <p>添加科目</p>
     * @author tfj
     * @since 2021/6/7
     */
    @ApiOperation(value = "添加科目")
    @PostMapping("/insertBranch")
    public Result insertBranch(@RequestParam String branch){
        return branchService.insertBranch(branch,"/branch/insertBranch");
    }

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


}

