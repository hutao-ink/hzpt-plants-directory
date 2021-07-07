package hzpt.plants.directory.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.dto.PostAnimalsDto;
import hzpt.plants.directory.entity.dto.PostPlantsDto;
import hzpt.plants.directory.service.AnimalsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/7 16
 */
@RestController
@CrossOrigin()
@RequestMapping("/animals")
@Api(tags = "动物")
public class AnimalsController {
    @Resource
    private AnimalsService animalsService;

    /**
     * <p>通过动物id获取动物所有信息</p>
     * @author tfj
     * @since 2021/6/9
     */
    @ApiOperation(value = "通过动物id获取动物所有信息")
    @GetMapping("/queryAnimalById")
    public Result queryAnimalById(@RequestParam String id){
        return animalsService.queryAnimalById(id,"/animals/queryAnimalById");
    }

    /**
     * <p>通过种类id查找所有动物</p>
     * @author tfj
     * @since 2021/6/9
     */
    @ApiOperation(value = "通过种类id查找所有动物")
    @GetMapping("/searchAnimalsByGenusId")
    public Result searchAnimalsByGenusId(@RequestParam String id){
        return animalsService.searchAnimalsByGenusId(id,"/animals/searchAnimalsByGenusId");
    }
    /**
     * <p>查询所有动物</p>
     * @author tfj
     * @since 2021/6/9
     */
    @ApiOperation(value = "查询所有动物")
    @GetMapping("/searchAnimals")
    public Result searchAnimals(@RequestParam Integer currentPage){
        return animalsService.searchAnimals(currentPage,"/animals/searchAnimals");
    }
    /**
     * <p>获取动物总数</p>
     * @author tfj
     * @since 2021/6/9
     */
    @ApiOperation(value = "获取动物总数")
    @GetMapping("/animalsCount")
    public Result animalsCount(){
        int count = animalsService.count();
        return new Result().result200(count,"/animals/animalsCount");
    }

    /**
     * <p>添加动物</p>
     * @author tfj
     * @since 2021/6/23
     */
    @ApiOperation(value = "添加动物")
    @PostMapping("/insertAnimal")
    public Result insertAnimal(@RequestBody PostAnimalsDto postAnimalsDto){
        if (!StpUtil.hasRole("管理员")){
            return new Result().result403("无权限访问","animals/insertAnimal");
        }
        return animalsService.insertPlant(postAnimalsDto,"animals/insertAnimal");
    }
    /**
     * <p>修改动物</p>
     * @author tfj
     * @since 2021/6/23
     */
    @ApiOperation(value = "修改动物")
    @PutMapping("/putAnimal")
    public Result putAnimal(@RequestParam String animalId,@RequestBody PostAnimalsDto postAnimalsDto){
        if (!StpUtil.hasRole("管理员")){
            return new Result().result403("无权限访问","animals/putAnimal");
        }
        return animalsService.putAnimal(animalId,postAnimalsDto,"animals/putAnimal");
    }
    /**
     * <p>删除动物</p>
     * @author tfj
     * @since 2021/6/23
     */
    @ApiOperation(value = "删除动物")
    @DeleteMapping("deleteAnimalById")
    public Result deleteAnimalById(@RequestParam String animalId){
        if (!StpUtil.hasRole("管理员")){
            return new Result().result403("无权限访问","plants/deleteAnimalById");
        }
        return animalsService.deleteAnimalById(animalId,"plants/deleteAnimalById");
    }
}
