package hzpt.plants.directory.controller;


import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.service.SpeciesService;
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
@RequestMapping("/species")
public class SpeciesController {
    @Resource
    private SpeciesService speciesService;
    /**
     * <p>添加种类</p>
     * @author tfj
     * @since 2021/6/7
     */
    @ApiOperation(value = "添加种类")
    @PostMapping("/insertSpecies")
    public Result insertSpecies(@RequestParam String species,String genusId){
        return speciesService.insertSpecies(species,genusId,"/species/insertSpecies");
    }

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
    public Result searchSpecies(){
        return speciesService.searchSpecies("/branch/searchSpecies");
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
     * <p>获取所有图片为空的种类</p>
     * @author tfj
     * @since 2021/6/17
     */
    @ApiOperation(value = "获取所有图片为空的种类")
    @GetMapping("/searchSpeciesWhereImageNull")
    public Result searchSpeciesWhereImageNull(){
        return speciesService.searchSpeciesWhereImageNull("branch/searchSpeciesWhereImageNull");
    }
    /**
     * <p>种类插入图片</p>
     * @author tfj
     * @since 2021/6/17
     */
    @ApiOperation(value = "种类插入图片")
    @GetMapping("/insertImageByName")
    public Result insertImageByName(String name,String imageUrl){
        return speciesService.insertImageByName(name,imageUrl,"branch/insertImageByName");
    }
}

