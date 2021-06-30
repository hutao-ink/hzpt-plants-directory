package hzpt.plants.directory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoTools.core.IdUtil.IdUtil;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.config.OssConfig;
import hzpt.plants.directory.entity.po.Carousel;
import hzpt.plants.directory.entity.vo.GetCarouselVo;
import hzpt.plants.directory.mapper.CarouselMapper;
import hzpt.plants.directory.service.CarouselService;
import hzpt.plants.directory.utils.BeansUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
    @Resource
    private OssConfig ossConfig;
    /**
     * <p>获取所有轮播图</p>
     * @author tfj
     * @since 2021/6/8
     */
    @Override
    public Result queryCarousel(String path) {
        List<Carousel> carousels = carouselMapper.selectList(new QueryWrapper<Carousel>());
        List<GetCarouselVo> getCarouselVos = BeansUtils.listCopy(carousels, GetCarouselVo.class);
        return new Result().result200(getCarouselVos,path);
    }
    /**
     * <p>添加轮播图</p>
     * @author tfj
     * @since 2021/6/8
     */
    @Override
    public Result insertCarousel(MultipartFile multipartFile,String biologicalName, String biologicalId, String path) {
        String uploadImage = ossConfig.uploadImage(multipartFile);
        Carousel carousel = new Carousel();carousel.setId(IdUtil.simpleUUID());
        carousel.setCarouselUrl(uploadImage);
        carousel.setBiologicalName(biologicalName);
        carousel.setBiologicalId(biologicalId);
        carousel.setCreateTime(new Date());
        if (carouselMapper.insert(carousel) == 1) {
            return new Result().result200("添加成功", path);
        }
        return new Result().result500("添加失败", path);
    }

    /**
     * <p>修改轮播图</p>
     * @author tfj
     * @since 2021/6/21
     */
    @Override
    public Result putCarousel(MultipartFile file, String carouselId, String path) {
        String uploadImage = ossConfig.uploadImage(file);
        Carousel selectOne = carouselMapper.selectOne(new QueryWrapper<Carousel>().eq("id", carouselId));
        selectOne.setCarouselUrl(uploadImage);
        selectOne.setModifyTime(new Date());
        if (carouselMapper.updateById(selectOne) == 1) {
            return new Result().result200("修改成功", path);
        }
        return new Result().result500("修改失败", path);
    }

    /**
     * <p>删除轮播图</p>
     * @author tfj
     * @since 2021/6/21
     */
    @Override
    public Result deleteCarousel(String carouselId, String path) {
        int i = carouselMapper.deleteById(carouselId);
        if (i==1){

            return new Result().result200("删除成功",path);
        }
        return new Result().result500("删除失败",path);
    }
}
