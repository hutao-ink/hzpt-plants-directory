package hzpt.plants.directory.controller;


import cn.dev33.satoken.stp.StpUtil;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.dto.PostSpeciesDto;
import hzpt.plants.directory.service.SpeciesService;
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
@CrossOrigin()
@RequestMapping("/species")
public class SpeciesController {
    @Resource
    private SpeciesService speciesService;
    /**
     * <p>获取种总数</p>
     * @author tfj
     * @since 2021/6/7
     */
    @ApiOperation(value = "获取种总数")
    @GetMapping("/genusCount")
    public Result speciesCount(){
        int count = speciesService.count();
        return new Result().result200(count,"/species/speciesCount");
    }

    /**
     * <p>查询所有种类</p>
     * @author tfj
     * @since 2021/6/7
     */
    @ApiOperation(value = "查询所有种类")
    @GetMapping("/searchSpecies")
    public Result searchSpecies(@RequestParam Integer currentPage){
        return speciesService.searchSpecies(currentPage,"/branch/searchSpecies");
    }
    /**
     * <p>通过属类id查找所有种类</p>
     * @author tfj
     * @since 2021/6/7
     */
    @ApiOperation(value = "通过属类id查找所有种类")
    @GetMapping("/searchSpeciesByGenusId")
    public Result searchSpeciesByGenusId(@RequestParam String id){
        return speciesService.searchSpeciesByGenusId(id,"branch/searchSpeciesByGenusId");
    }

    /**
     * <p>添加种类</p>
     * @author tfj
     * @since 2021/6/7
     */
    @ApiOperation(value = "添加种类")
    @PostMapping("/insertSpecies")
    public Result insertSpecies(@RequestBody PostSpeciesDto postSpeciesDto){
        if (!StpUtil.hasRole("管理员")){
            return new Result().result403("无权限访问","species/insertSpecies");
        }
        return speciesService.insertSpecies(postSpeciesDto,"species/insertSpecies");
    }

    /**
     * <p>种类插入图片</p>
     * @author tfj
     * @since 2021/6/17
     */
    @ApiOperation(value = "种类插入图片")
    @PostMapping("/insertImageById")
    public Result insertImageByName(@RequestParam String speciesId,@RequestPart MultipartFile file){
        if (!StpUtil.hasRole("管理员")){
            return new Result().result403("无权限访问","species/insertImageById");
        }
        return speciesService.insertImageById(speciesId,file,"species/insertImageById");
    }

    /**
     * <p>删除物种</p>
     * @author tfj
     * @since 2021/6/22
     */
    @ApiOperation(value = "删除物种")
    @DeleteMapping("/deleteSpecies")
    public Result deleteSpecies(@RequestParam String speciesId){
        if (!StpUtil.hasRole("管理员")){
            return new Result().result403("无权限访问","species/deleteSpecies");
        }
        return speciesService.deleteSpecies(speciesId,"species/deleteSpecies");
    }



}

