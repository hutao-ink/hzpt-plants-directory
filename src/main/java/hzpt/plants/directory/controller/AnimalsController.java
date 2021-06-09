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
 * @since 2021/6/8 16
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
        return animalsService.fuzzyQuery(name,"animals/fuzzyQuery");
    }
}
