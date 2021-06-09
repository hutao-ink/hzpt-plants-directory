package hzpt.plants.directory.controller;


import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.service.GenusService;
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
@RequestMapping("/genus")
public class GenusController {
    @Resource
    private GenusService genusService;
    /**
     * <p>添加属目</p>
     * @author tfj
     * @since 2021/6/7
     */
    @ApiOperation(value = "添加属目")
    @PostMapping("/insertGenus")
    public Result insertGenus(@RequestParam String genus,String branchId){
        return genusService.insertGenus(genus,branchId,"/genus/insertGenus");
    }
    /**
     * <p>获取属总数</p>
     * @author tfj
     * @since 2021/6/7
     */
    @ApiOperation(value = "获取属总数")
    @GetMapping("/genusCount")
    public Result genusCount(){
        int count = genusService.count();
        return new Result().result200(count,"/genus/genusCount");
    }


    /**
     * <p>查询所有属目</p>
     * @author tfj
     * @since 2021/6/7
     */
    @ApiOperation(value = "查询所有属目")
    @GetMapping("/searchGenus")
    public Result searchGenus(){
        return genusService.searchGenus("/branch/searchGenus");
    }
    /**
     * <p>通过科类id查找所有属类</p>
     * @author tfj
     * @since 2021/6/7
     */
    @ApiOperation(value = "通过科类id查找所有属类")
    @GetMapping("/searchGenusByBranchId")
    public Result searchGenusByBranchId(@RequestParam String id){
        return genusService.searchGenusByBranchId(id,"branch/searchGenusByBranchId");
    }
}

