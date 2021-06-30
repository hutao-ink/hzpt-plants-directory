package hzpt.plants.directory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaoTools.core.IdUtil.IdUtil;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.dto.PostPlantsDto;
import hzpt.plants.directory.entity.po.*;
import hzpt.plants.directory.entity.vo.GetAnimalsAllInfoVo;
import hzpt.plants.directory.entity.vo.GetPlantsAllInfoVo;
import hzpt.plants.directory.entity.vo.GetPlantsVo;
import hzpt.plants.directory.mapper.*;
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
    @Resource
    private BranchMapper branchMapper;
    @Resource
    private GenusMapper genusMapper;
    @Resource
    private SpeciesMapper speciesMapper;
    /**
     * <p>查询所有植物</p>
     * @author tfj
     * @since 2021/6/7
     */
    @Override
    public Result searchPlants(Integer currentPage,String path) {
        Page<Plants> page=new Page<>(currentPage,21);
        IPage<Plants> plantsList=plantsMapper.selectPage(page,null);
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
     * <p>分页模糊查询</p>
     * @author tfj
     * @since 2021/6/7
     */
    @Override
    public Result fuzzyQuery(String name,Integer currentPage, String path) {
        QueryWrapper<Plants> queryWrapper= Wrappers.query();
                queryWrapper.like("plantName", name)
                .or().like("alias",name)
                .or().like("address",name)
                .or().like("remarks",name);
        Page<Plants> page=new Page<>(currentPage,8);
        IPage<Plants> plantsList=plantsMapper.selectPage(page,queryWrapper);
        List<GetPlantsVo> getPlantsVos = BeansUtils.listCopy(plantsList.getRecords(), GetPlantsVo.class);
        return new Result().result200(getPlantsVos,path);
    }
    /**
     * <p>通过名字模糊查询</p>
     * @author tfj
     * @since 2021/6/8
     */
    @Override
    public List<GetPlantsVo> fuzzyQueryPlants(String name,Integer currentPage) {
        QueryWrapper<Plants> queryWrapper=Wrappers.query();
        queryWrapper.like("plantName", name)
                .or().like("alias",name)
                .or().like("address",name)
                .or().like("remarks",name);
        Page<Plants> page=new Page<>(currentPage,8);
        IPage<Plants> plantsList=plantsMapper.selectPage(page,queryWrapper);
        return BeansUtils.listCopy(plantsList.getRecords(), GetPlantsVo.class);
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
    /**
     * <p>添加植物</p>
     * @author tfj
     * @since 2021/6/22
     */
    @Override
    public Result insertPlant(PostPlantsDto postPlantsDto, String path) {
        Branch branch = branchMapper.selectOne(new QueryWrapper<Branch>().eq("branch", postPlantsDto.getBranch()));
        if (branch==null){
            Branch newBranch = new Branch();
            newBranch.setId(IdUtil.simpleUUID());
            newBranch.setCreateTime(new Date());
            newBranch.setType(0);
            newBranch.setBranch(postPlantsDto.getBranch());
            branchMapper.insert(newBranch);
        }else {
            String branchId = branch.getId();
            Genus genus = genusMapper.selectOne(new QueryWrapper<Genus>().eq("genus", postPlantsDto.getGenus()));
            if (genus==null){
                Genus newGenus=new Genus();
                newGenus.setId(IdUtil.simpleUUID());
                newGenus.setGenus(postPlantsDto.getGenus());
                newGenus.setBranchId(branchId);
                newGenus.setCreateTime(new Date());
                genusMapper.insert(newGenus);
            }else {
                String genusId = genus.getId();
                Species species = speciesMapper.selectOne(new QueryWrapper<Species>().eq("species", postPlantsDto.getSpecies()));
                if (species==null){
                    Species newSpecies=new Species();
                    newSpecies.setId(IdUtil.simpleUUID());
                    newSpecies.setSpecies(postPlantsDto.getSpecies());
                    newSpecies.setGenusId(genusId);
                    newSpecies.setCreateTime(new Date());
                    speciesMapper.insert(newSpecies);
                }else {
                    String speciesId = species.getId();
                    Plants plants = plantsMapper.selectOne(new QueryWrapper<Plants>().eq("plantName", postPlantsDto.getPlantName()));
                    if (plants==null){
                        Plants newPlant=new Plants();
                        newPlant.setId(IdUtil.simpleUUID());
                        newPlant.setPlantName(postPlantsDto.getPlantName());
                        newPlant.setAlias(postPlantsDto.getAlias());
                        newPlant.setDescription(postPlantsDto.getDescription());
                        newPlant.setRemarks(postPlantsDto.getRemarks());
                        newPlant.setCreateTime(new Date());
                        newPlant.setImagesUrl(postPlantsDto.getImagesUrl());
                        newPlant.setSpeciesId(speciesId);
                        plantsMapper.insert(newPlant);
                        return new Result().result200("添加植物成功",path);
                    }else {
                        return new Result().result500("该植物已存在，请选择修改植物",path);
                    }
                }
            }
        }
        return new Result().result500("添加失败",path);
    }
    /**
     * <p>修改植物</p>
     * @author tfj
     * @since 2021/6/23
     */
    @Override
    public Result putPlantById(PostPlantsDto postPlantsDto, String plantId, String path) {

        Branch branch = branchMapper.selectOne(new QueryWrapper<Branch>().eq("branch", postPlantsDto.getBranch()));
        branch.setBranch(postPlantsDto.getBranch());
        branchMapper.updateById(branch);
        String branchId = branch.getId();

        Genus genus = genusMapper.selectOne(new QueryWrapper<Genus>().eq("genus", postPlantsDto.getGenus()));
        genus.setGenus(postPlantsDto.getGenus());
        genus.setBranchId(branchId);
        genus.setModifyTime(new Date());
        genusMapper.updateById(genus);
        String genusId = genus.getId();

        Species species = speciesMapper.selectOne(new QueryWrapper<Species>().eq("species", postPlantsDto.getSpecies()));
        species.setGenusId(genusId);
        species.setModifyTime(new Date());
        speciesMapper.updateById(species);
        String speciesId = species.getId();

        Plants plants = plantsMapper.selectOne(new QueryWrapper<Plants>().eq("id", plantId));
        plants.setAddress(postPlantsDto.getAddress());
        plants.setDescription(postPlantsDto.getDescription());
        plants.setRemarks(postPlantsDto.getRemarks());
        plants.setSpeciesId(speciesId);
        plants.setAlias(postPlantsDto.getAlias());
        plants.setModifyTime(new Date());

        plantsMapper.updateById(plants);
        return new Result().result200("修改成功",path);
    }
    /**
     * <p>删除植物</p>
     * @author tfj
     * @since 2021/6/23
     */
    @Override
    public Result deletePlantById(String plantId, String path) {
        if (plantsMapper.deleteById(plantId)==1){
            return new Result().result200("删除植物成功",path);
        }
        return new Result().result500("删除失败",path);
    }
}
