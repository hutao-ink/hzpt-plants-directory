package hzpt.plants.directory.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.po.Carousel;

public interface CarouselService extends IService<Carousel> {

    /**
     * <p>获取所有轮播图</p>
     * @author tfj
     * @since 2021/6/8
     */

    Result queryCarousel(String path);
    /**
     * <p>添加轮播图</p>
     * @author tfj
     * @since 2021/6/8
     */
    Result insertCarousel(String carouselUrl, String biologicalName,String biologicalId, String path);


}
