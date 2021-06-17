package hzpt.plants.directory.controller;


import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.service.PlantsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 * @author tfj
 * @since 2021-06-06
 */
@RestController
@RequestMapping("/plants")
public class PlantsController {
    @Resource
    private PlantsService plantsService;

    /**
     * <p>添加植物</p>
     * @author tfj
     * @since 2021/6/7
     */
    @ApiOperation(value = "添加植物")
    @PostMapping("/insertPlant")
    public Result insertPlant(@RequestParam String plantName, String alias
    ,String imagesUrl,String description,String speciesId,String address){
        return plantsService.insertPlant(plantName,alias,imagesUrl,description,speciesId,address,"/plants/insertPlant");
    }

    /**
     * <p>获取植物总数</p>
     * @author tfj
     * @since 2021/6/7
     */
    @ApiOperation(value = "获取植物总数")
    @GetMapping("/plantsCount")
    public Result plantsCount(){
        int count = plantsService.count();
        return new Result().result200(count,"/plants/plantsCount");
    }


    /**
     * <p>查询所有植物</p>
     * @author tfj
     * @since 2021/6/7
     */
    @ApiOperation(value = "查询所有植物")
    @GetMapping("/searchPlants")
    public Result searchPlants(){
        return plantsService.searchPlants("/plants/searchPlants");
    }

    /**
     * <p>通过种类id查找所有植物</p>
     * @author tfj
     * @since 2021/6/7
     */
    @ApiOperation(value = "通过种类id查找所有植物")
    @GetMapping("/searchPlantsByGenusId")
    public Result searchPlantsByGenusId(@RequestParam String id){
        return plantsService.searchPlantsByGenusId(id,"/plants/searchPlantsByGenusId");
    }

    /**
     * <p>分页模糊查询</p>
     * @author tfj
     * @since 2021/6/7
     */
    @ApiOperation(value = "分页模糊查询")
    @GetMapping("/fuzzyQuery")
    public Result fuzzyQuery(@RequestParam String name,Integer currentPage){
        return plantsService.fuzzyQuery(name,currentPage,"/plants/fuzzyQuery");
    }


    /**
     * <p>通过生物id查询植物所有信息</p>
     * @author tfj
     * @since 2021/6/7
     */
    @ApiOperation(value = "通过生物id查询植物所有信息")
    @GetMapping("/queryPlantById")
    public Result queryPlantById(@RequestParam String id){
        return plantsService.queryPlantById(id,"/plants/queryPlantById");
    }

}

