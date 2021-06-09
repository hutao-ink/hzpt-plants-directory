package hzpt.plants.directory.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.po.Species;
import hzpt.plants.directory.mapper.SpeciesMapper;
import hzpt.plants.directory.service.SpeciesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
    /**
     * <p>添加种类</p>
     * @author tfj
     * @since 2021/6/7
     */
    @Override
    public Result insertSpecies(String species, String genusId, String path) {
        Species species1=new Species();
        species1.setId(IdUtil.simpleUUID());
        species1.setSpecies(species);
        species1.setGenusId(genusId);
        species1.setCreateTime(new Date());
        if (speciesMapper.insert(species1)==1){
            return new Result().result200("添加成功",path);
        }
        return new Result().result500("添加失败",path);
    }
    /**
     * <p>查询所有种类</p>
     * @author tfj
     * @since 2021/6/7
     */
    @Override
    public Result searchSpecies(String path) {
        List<Species> speciesList = speciesMapper.selectList(new QueryWrapper<>());
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
}
