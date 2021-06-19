package hzpt.plants.directory.controller;

import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.service.CarouselService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tfj
 * @since 2021-06-08
 */
@RestController
@RequestMapping("/carousel")
public class CarouselController {
    @Resource
    private CarouselService carouselService;

    /**
     * <p>获取所有轮播图</p>
     * @author tfj
     * @since 2021/6/8
     */
    @ApiOperation(value = "获取所有轮播图")
    @GetMapping("/queryCarousel")
    public Result queryCarousel(){
        return carouselService.queryCarousel("/carousel/queryCarousel");
    }

    /**
     * <p>添加轮播图</p>
     * @author tfj
     * @since 2021/6/8
     */
    @ApiOperation(value = "添加轮播图")
    @PostMapping("/insertCarousel")
    public Result insertCarousel(@RequestParam String carouselUrl,String biologicalName,String biologicalId){
        return carouselService.insertCarousel(carouselUrl,biologicalName,biologicalId,"/carousel/insertCarousel");
    }

}
