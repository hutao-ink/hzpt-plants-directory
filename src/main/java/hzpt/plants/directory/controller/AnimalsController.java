package hzpt.plants.directory.controller;

import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.service.AnimalsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/7 16
 */
@RestController
@RequestMapping("/animals")
public class AnimalsController {
    @Resource
    private AnimalsService animalsService;
    /**
     * <p>通过名字模糊查询</p>
     * @author tfj
     * @since 2021/6/7
     */
    @ApiOperation(value = "通过名字模糊查询")
    @GetMapping("/fuzzyQuery")
    public Result fuzzyQuery(@RequestParam String name){
        return animalsService.fuzzyQuery(name,"/animals/fuzzyQuery");
    }

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
    public Result searchAnimals(){
        return animalsService.searchAnimals("/animals/searchAnimals");
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
}
