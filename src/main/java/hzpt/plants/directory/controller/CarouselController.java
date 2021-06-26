package hzpt.plants.directory.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.service.CarouselService;
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
 * @since 2021-06-08
 */
@RestController
@CrossOrigin
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
    public Result insertCarousel(@RequestPart MultipartFile file, @RequestParam String biologicalName, String biologicalId){
        if (!StpUtil.hasRole("管理员")){
            return new Result().result403("无权限访问","admin/putCipher");
        }
        return carouselService.insertCarousel(file,biologicalName,biologicalId,"/carousel/insertCarousel");
    }
    /**
     * <p>修改轮播图</p>
     * @author tfj
     * @since 2021/6/21
     */
    @ApiOperation(value = "修改轮播图")
    @PutMapping("/putCarousel")
    public Result putCarousel(@RequestPart MultipartFile file, @RequestParam String carouselId){
        if (!StpUtil.hasRole("管理员")){
            return new Result().result403("无权限访问","admin/putCipher");
        }
        return carouselService.putCarousel(file,carouselId,"/carousel/putCarousel");
    }

    /**
     * <p>删除轮播图</p>
     * @author tfj
     * @since 2021/6/21
     */
    @ApiOperation(value = "删除轮播图")
    @DeleteMapping("/deleteCarousel")
    public Result deleteCarousel(@RequestParam String carouselId){
        if (!StpUtil.hasRole("管理员")){
            return new Result().result403("无权限访问","admin/deleteCarousel");
        }
        return carouselService.deleteCarousel(carouselId,"admin/deleteCarousel");
    }

}
