package hzpt.plants.directory.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.po.Plants;
import hzpt.plants.directory.entity.vo.GetAnimalsAllInfoVo;
import hzpt.plants.directory.entity.vo.GetPlantsAllInfoVo;
import hzpt.plants.directory.entity.vo.GetPlantsVo;
import hzpt.plants.directory.mapper.AnimalsMapper;
import hzpt.plants.directory.mapper.PlantsMapper;
import hzpt.plants.directory.service.AnimalsService;
import hzpt.plants.directory.service.PlantsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import hzpt.plants.directory.utils.BeansUtils;
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
public class PlantsServiceImpl extends ServiceImpl<PlantsMapper, Plants> implements PlantsService {
    @Resource
    private PlantsMapper plantsMapper;
    @Resource
    private AnimalsMapper animalsMapper;
    /**
     * <p>添加植物</p>
     * @author tfj
     * @since 2021/6/7
     */
    @Override
    public Result insertPlant(String plantName, String alias, String imagesUrl, String description, String speciesId, String address, String path) {
       Plants plants=new Plants();
       plants.setId(IdUtil.simpleUUID());
       plants.setPlantName(plantName);
       plants.setAlias(alias);
       plants.setImagesUrl(imagesUrl);
       plants.setDescription(description);
       plants.setSpeciesId(speciesId);
       plants.setAddress(address);
       plants.setCreateTime(new Date());
       if (plantsMapper.insert(plants)==1){
           return new Result().result200("添加成功",path);
       }
        return new Result().result200("添加失败",path);
    }

    /**
     * <p>查询所有植物</p>
     * @author tfj
     * @since 2021/6/7
     */
    @Override
    public Result searchPlants(String path) {
        List<Plants> plantsList = plantsMapper.selectList(new QueryWrapper<>());
        return new Result().result200(plantsList,path);
    }
    /**
     * <p>通过种类id查找所有植物</p>
     * @author tfj
     * @since 2021/6/7
     */
    @Override
    public Result searchPlantsByGenusId(String id, String path) {
        List<Plants> plantsList = plantsMapper.selectList(new QueryWrapper<Plants>().eq("speciesId", id));
        List<GetPlantsVo> getPlantsVoList = BeansUtils.listCopy(plantsList, GetPlantsVo.class);
        return new Result().result200(getPlantsVoList,path);
    }

    /**
     * <p>通过名字模糊查询</p>
     * @author tfj
     * @since 2021/6/7
     */
    @Override
    public Result fuzzyQuery(String name, String path) {
        List<Plants> plantsList = plantsMapper.selectList(new QueryWrapper<Plants>().like("plantName", name)
                .or().like("alias",name)
                .or().like("description",name)
                .or().like("address",name)
                .or().like("remarks",name));
        List<GetPlantsVo> getPlantsVos = BeansUtils.listCopy(plantsList, GetPlantsVo.class);
        return new Result().result200(getPlantsVos,path);
    }
    /**
     * <p>通过名字模糊查询</p>
     * @author tfj
     * @since 2021/6/8
     */
    @Override
    public List<GetPlantsVo> fuzzyQueryPlants(String name) {
        List<Plants> plantsList = plantsMapper.selectList(new QueryWrapper<Plants>().like("plantName", name)
                .or().like("alias",name)
                .or().like("description",name)
                .or().like("address",name)
                .or().like("remarks",name));
        return BeansUtils.listCopy(plantsList, GetPlantsVo.class);
    }

    /**
     * <p>通过生物id查询植物所有信息</p>
     * @author tfj
     * @since 2021/6/7
     */
    @Override
    public Result queryPlantById(String id, String path) {
        GetPlantsAllInfoVo plantsAllInfoVo = plantsMapper.searchPlantsAllInfo(id);
        GetAnimalsAllInfoVo animalsAllInfoVo = animalsMapper.getAnimalsAllInfoVo(id);
        if (plantsAllInfoVo!=null){
            return new Result().result200(plantsAllInfoVo,path);
        }
        return new Result().result200(animalsAllInfoVo,path);
    }
}
