package hzpt.plants.directory.controller;


import cn.dev33.satoken.stp.StpUtil;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.dto.PostPlantsDto;
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
@CrossOrigin()
@RequestMapping("/plants")
public class PlantsController {
    @Resource
    private PlantsService plantsService;

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
    public Result searchPlants(@RequestParam Integer currentPage){
        return plantsService.searchPlants(currentPage,"/plants/searchPlants");
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

    /**
     * <p>添加植物</p>
     * @author tfj
     * @since 2021/6/22
     */
    @ApiOperation(value = "添加植物")
    @PostMapping("/insertPlant")
    public Result insertPlant(@RequestBody PostPlantsDto postPlantsDto){
        if (!StpUtil.hasRole("管理员")){
            return new Result().result403("无权限访问","plants/insertPlant");
        }
        return plantsService.insertPlant(postPlantsDto,"plants/insertPlant");
    }
    /**
     * <p>修改植物</p>
     * @author tfj
     * @since 2021/6/23
     */
    @ApiOperation(value = "修改植物")
    @PutMapping("/putPlantById")
    public Result putPlantById(@RequestBody PostPlantsDto postPlantsDto,@RequestParam String plantId){
        if (!StpUtil.hasRole("管理员")){
            return new Result().result403("无权限访问","plants/insertPlant");
        }
        return plantsService.putPlantById(postPlantsDto,plantId,"plants/putPlantById");
    }
    /**
     * <p>删除植物</p>
     * @author tfj
     * @since 2021/6/23
     */
    @ApiOperation(value = "删除植物")
    @DeleteMapping("deletePlantById")
    public Result deletePlantById(@RequestParam String plantId){
        if (!StpUtil.hasRole("管理员")){
            return new Result().result403("无权限访问","plants/deletePlantById");
        }
        return plantsService.deletePlantById(plantId,"plants/deletePlantById");
    }

}

