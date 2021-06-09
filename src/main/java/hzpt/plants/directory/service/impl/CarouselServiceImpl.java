package hzpt.plants.directory.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.po.Carousel;
import hzpt.plants.directory.entity.vo.GetCarouselVo;
import hzpt.plants.directory.mapper.CarouselMapper;
import hzpt.plants.directory.service.CarouselService;
import hzpt.plants.directory.utils.BeansUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/8
 */
@Service
public class CarouselServiceImpl extends ServiceImpl<CarouselMapper, Carousel> implements CarouselService {
    @Resource
    private CarouselMapper carouselMapper;
    /**
     * <p>获取所有轮播图</p>
     * @author tfj
     * @since 2021/6/8
     */
    @Override
    public Result queryCarousel(String path) {
        List<Carousel> carousels = carouselMapper.selectList(new QueryWrapper<>());
        List<GetCarouselVo> getCarouselVos = BeansUtils.listCopy(carousels, GetCarouselVo.class);
        return new Result().result200(getCarouselVos,path);
    }
    /**
     * <p>添加轮播图</p>
     * @author tfj
     * @since 2021/6/8
     */
    @Override
    public Result insertCarousel(String carouselUrl, String biologicalName,String biologicalId, String path) {
        Carousel carousel=new Carousel();
        carousel.setId(IdUtil.simpleUUID());
        carousel.setCarouselUrl(carouselUrl);
        carousel.setBiologicalName(biologicalName);
        carousel.setBiologicalId(biologicalId);
        carousel.setCreateTime(new Date());
        if (carouselMapper.insert(carousel)==1){
            return new Result().result200("添加成功",path);
        }
        return new Result().result200("添加失败",path);
    }

}
