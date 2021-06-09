package hzpt.plants.directory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.po.Animals;
import hzpt.plants.directory.entity.po.Plants;
import hzpt.plants.directory.entity.po.User;
import hzpt.plants.directory.entity.vo.GetAnimalsVo;
import hzpt.plants.directory.entity.vo.GetPlantsVo;
import hzpt.plants.directory.mapper.AnimalsMapper;
import hzpt.plants.directory.mapper.PlantsMapper;
import hzpt.plants.directory.mapper.UserMapper;
import hzpt.plants.directory.service.AnimalsService;
import hzpt.plants.directory.service.PlantsService;
import hzpt.plants.directory.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/8
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private PlantsService plantsService;
    @Resource
    private AnimalsService animalsService;
    /**
     * <p>用户搜索动植物</p>
     * @author tfj
     * @since 2021/6/8
     */
    @Override
    public Result fuzzyQuery(String name, String path) {
        List<GetAnimalsVo> getAnimalsVos = animalsService.fuzzyQueryAnimals(name);
        List<GetPlantsVo> getPlantsVos = plantsService.fuzzyQueryPlants(name);
        if (getAnimalsVos.size()>0){
            return new Result().result200(getAnimalsVos,path);
        }else if (getPlantsVos.size()>0){
            return new Result().result200(getPlantsVos,path);
        }
        return new Result().result200("未找到",path);
    }
}
