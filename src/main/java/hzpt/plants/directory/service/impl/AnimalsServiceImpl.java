package hzpt.plants.directory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.po.Animals;
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
    public List<GetAnimalsVo> fuzzyQueryAnimals(String name){
        List<Animals> animalsList = animalsMapper.selectList(new QueryWrapper<Animals>().like("animalName", name)
                .or().like("alias",name)
                .or().like("description",name)
                .or().like("address",name)
                .or().like("remarks",name));
        return  BeansUtils.listCopy(animalsList, GetAnimalsVo.class);
    }
}