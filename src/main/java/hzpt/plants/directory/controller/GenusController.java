package hzpt.plants.directory.controller;


import cn.dev33.satoken.stp.StpUtil;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.dto.PostGenusDto;
import hzpt.plants.directory.service.GenusService;
import io.swagger.annotations.Api;
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
@CrossOrigin()
@RequestMapping("/genus")
@Api(tags = "属")
public class GenusController {
    @Resource
    private GenusService genusService;
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
    public Result searchGenus(@RequestParam Integer currentPage){
        return genusService.searchGenus(currentPage,"/genus/searchGenus");
    }
    /**
     * <p>通过科类id查找所有属类</p>
     * @author tfj
     * @since 2021/6/7
     */
    @ApiOperation(value = "通过科类id查找所有属类")
    @GetMapping("/searchGenusByBranchId")
    public Result searchGenusByBranchId(@RequestParam String id){
        return genusService.searchGenusByBranchId(id,"/genus/searchGenusByBranchId");
    }

    /**
     * <p>添加属目</p>
     * @author tfj
     * @since 2021/6/7
     */
    @ApiOperation(value = "添加属目")
    @PostMapping("/insertGenus")
    public Result insertGenus(@RequestParam String genus,String branchId){
        if (!StpUtil.hasRole("管理员")){
            return new Result().result403("无权限访问","genus/insertGenus");
        }
        return genusService.insertGenus(genus,branchId,"genus/insertGenus");
    }
    /**
     * <p>修改属目</p>
     * @author tfj
     * @since 2021/6/22
     */
    @ApiOperation(value = "修改属目")
    @PutMapping("/putGenusById")
    public Result putGenusById(@RequestBody PostGenusDto postGenusDto){
        if (!StpUtil.hasRole("管理员")){
            return new Result().result403("无权限访问","genus/insertGenus");
        }
        return genusService.putGenusById(postGenusDto,"genus/insertGenus");
    }
    /**
     * <p>删除属目</p>
     * @author tfj
     * @since 2021/6/22
     */
    @ApiOperation(value = "删除属目")
    @DeleteMapping("/deleteGenus")
    public Result deleteGenus(@RequestParam String genusId){
        if (!StpUtil.hasRole("管理员")){
            return new Result().result403("无权限访问","genus/deleteGenus");
        }
        return genusService.deleteGenus(genusId,"genus/deleteGenus");
    }

}

