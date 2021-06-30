package hzpt.plants.directory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaoTools.core.IdUtil.IdUtil;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.config.OssConfig;
import hzpt.plants.directory.entity.dto.PostSpeciesDto;
import hzpt.plants.directory.entity.po.Species;
import hzpt.plants.directory.mapper.SpeciesMapper;
import hzpt.plants.directory.service.SpeciesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tfj
 * @since 2021-06-06
 */
@Service
public class SpeciesServiceImpl extends ServiceImpl<SpeciesMapper, Species> implements SpeciesService {
    @Resource
    private SpeciesMapper speciesMapper;
    @Resource
    private OssConfig ossConfig;
    /**
     * <p>添加种类</p>
     * @author tfj
     * @since 2021/6/7
     */
    @Override
    public Result insertSpecies(PostSpeciesDto postSpeciesDto, String path) {
        Species species1=new Species();
        species1.setId(IdUtil.simpleUUID());
        species1.setSpecies(postSpeciesDto.getSpecies());
        species1.setGenusId(postSpeciesDto.getGenusId());
        species1.setCreateTime(new Date());
        if (speciesMapper.insert(species1)==1){
            return new Result().result200(species1.getId(),path);
        }
        return new Result().result500("添加失败",path);
    }
    /**
     * <p>查询所有种类</p>
     * @author tfj
     * @since 2021/6/7
     */
    @Override
    public Result searchSpecies(Integer currentPage,String path) {
        Page<Species> page=new Page<>(currentPage,21);
        IPage<Species> speciesList=speciesMapper.selectPage(page,null);
        return new Result().result200(speciesList,path);
    }
    /**
     * <p>通过属类id查找所有种类</p>
     * @author tfj
     * @since 2021/6/7
     */
    @Override
    public Result searchSpeciesByGenusId(String id, String path) {
        List<Species> speciesList = speciesMapper.selectList(new QueryWrapper<Species>().eq("genusId", id));
        return new Result().result200(speciesList,path);
    }

    /**
     * <p>种类插入图片</p>
     * @author tfj
     * @since 2021/6/22
     */
    @Override
    public Result insertImageById(String speciesId, MultipartFile file, String path) {
        String uploadImage = ossConfig.uploadImage(file);
        Species species = speciesMapper.selectOne(new QueryWrapper<Species>().eq("id", speciesId));
        species.setImagesUrl(uploadImage);
        species.setModifyTime(new Date());
        if (speciesMapper.updateById(species)==1){;
            return new Result().result200("修改属类图片成功",path);
        }
        return new Result().result500("修改属类图片失败",path);
    }
    /**
     * <p>删除物种</p>
     * @author tfj
     * @since 2021/6/22
     */
    @Override
    public Result deleteSpecies(String speciesId, String path) {
        if (speciesMapper.deleteById(speciesId)==1){
            return new Result().result200("删除物种失败",path);
        }
        return new Result().result500("删除物种失败",path);
    }
}
