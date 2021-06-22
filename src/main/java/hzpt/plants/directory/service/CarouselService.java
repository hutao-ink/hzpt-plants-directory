package hzpt.plants.directory.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.po.Carousel;
import org.springframework.web.multipart.MultipartFile;

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
    Result insertCarousel(MultipartFile multipartFile, String biologicalName, String biologicalId, String path);

    /**
     * <p>修改轮播图</p>
     * @author tfj
     * @since 2021/6/21
     */
    Result putCarousel(MultipartFile file, String carouselId, String path);
    /**
     * <p>删除轮播图</p>
     * @author tfj
     * @since 2021/6/21
     */
    Result deleteCarousel(String carouselId, String path);
}
