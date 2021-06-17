package hzpt.plants.directory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.po.Animals;
import hzpt.plants.directory.entity.po.Plants;
import hzpt.plants.directory.entity.vo.GetAnimalsAllInfoVo;
import hzpt.plants.directory.entity.vo.GetAnimalsVo;
import hzpt.plants.directory.mapper.AnimalsMapper;
import hzpt.plants.directory.service.AnimalsService;
import hzpt.plants.directory.utils.BeansUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/8
 */
@Service
public class AnimalsServiceImpl extends ServiceImpl<AnimalsMapper, Animals> implements AnimalsService {
    @Resource
    private AnimalsMapper animalsMapper;
    /**
     * <p>通过名字模糊查询</p>
     * @author tfj
     * @since 2021/6/8
     */
    @Override
    public Result fuzzyQuery(String name, String path) {
        List<Animals> animalsList = animalsMapper.selectList(new QueryWrapper<Animals>().like("animalName", name)
                .or().like("alias",name)
                .or().like("description",name)
                .or().like("address",name)
                .or().like("remarks",name));
        List<GetAnimalsVo> getAnimalsVos = BeansUtils.listCopy(animalsList, GetAnimalsVo.class);
        return new Result().result200(getAnimalsVos,path);
    }

    /**
     * <p>通过名字模糊查询返回VO</p>
     * @author tfj
     * @since 2021/6/8
     */
    @Override
    public List<GetAnimalsVo> fuzzyQueryAnimals(String name,Integer currentPage){
        QueryWrapper<Animals> queryWrapper= Wrappers.query();
        queryWrapper.like("animalName", name)
                .or().like("alias",name)
                .or().like("address",name)
                .or().like("remarks",name);
        Page<Animals> page=new Page<>(currentPage,8);
        IPage<Animals> animalsList=animalsMapper.selectPage(page,queryWrapper);
        return  BeansUtils.listCopy(animalsList.getRecords(), GetAnimalsVo.class);
    }

    /**
     * <p>通过动物id获取动物所有信息</p>
     * @author tfj
     * @since 2021/6/9
     */
    @Override
    public Result queryAnimalById(String id, String path) {
        GetAnimalsAllInfoVo animalsAllInfoVo = animalsMapper.getAnimalsAllInfoVo(id);
        return new Result().result200(animalsAllInfoVo,path);
    }

    /**
     * <p>通过种类id查找所有动物</p>
     * @author tfj
     * @since 2021/6/9
     */
    @Override
    public Result searchAnimalsByGenusId(String id, String path) {
        List<Animals> animalsList = animalsMapper.selectList(new QueryWrapper<Animals>().eq("speciesId", id));
        List<GetAnimalsVo> getAnimalsVos = BeansUtils.listCopy(animalsList, GetAnimalsVo.class);
        return new Result().result200(getAnimalsVos,path);
    }
    /**
     * <p>查询所有动物</p>
     * @author tfj
     * @since 2021/6/9
     */
    @Override
    public Result searchAnimals(String path) {
        List<Animals> animalsList = animalsMapper.selectList(new QueryWrapper<>());
        return new Result().result200(animalsList,path);
    }
}