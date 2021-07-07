package hzpt.plants.directory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoTools.core.IdUtil.IdUtil;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.dto.PostAnimalsDto;
import hzpt.plants.directory.entity.po.*;
import hzpt.plants.directory.entity.vo.GetAnimalsAllInfoVo;
import hzpt.plants.directory.entity.vo.GetAnimalsVo;
import hzpt.plants.directory.mapper.AnimalsMapper;
import hzpt.plants.directory.mapper.BranchMapper;
import hzpt.plants.directory.mapper.GenusMapper;
import hzpt.plants.directory.mapper.SpeciesMapper;
import hzpt.plants.directory.service.AnimalsService;
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
public class AnimalsServiceImpl extends ServiceImpl<AnimalsMapper, Animals> implements AnimalsService {
    @Resource
    private AnimalsMapper animalsMapper;
    @Resource
    private BranchMapper branchMapper;
    @Resource
    private GenusMapper genusMapper;
    @Resource
    private SpeciesMapper speciesMapper;

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
    public Result searchAnimals(Integer currentPage,String path) {
        Page<Animals> page=new Page<>(currentPage,21);
        IPage<Animals> animalsList=animalsMapper.selectPage(page,null);
        return new Result().result200(animalsList,path);
    }
    /**
     * <p>添加动物</p>
     * @author tfj
     * @since 2021/6/23
     */
    @Override
    public Result insertPlant(PostAnimalsDto postAnimalsDto, String path) {

        Branch branch = branchMapper.selectOne(new QueryWrapper<Branch>().eq("branch", postAnimalsDto.getBranch()));
        Genus genus = genusMapper.selectOne(new QueryWrapper<Genus>().eq("genus", postAnimalsDto.getGenus()));
        Species species = speciesMapper.selectOne(new QueryWrapper<Species>().eq("species", postAnimalsDto.getSpecies()));
        Animals animals = animalsMapper.selectOne(new QueryWrapper<Animals>().eq("animalName", postAnimalsDto.getAnimalName()));

        if (branch!=null&&genus!=null&&species!=null&&animals!=null) {
            return new Result().result500("已存在动物信息，添加失败",path);
        }

        Branch newBranch = new Branch();
        newBranch.setId(IdUtil.simpleUUID());
        newBranch.setCreateTime(new Date());
        newBranch.setType(1);
        newBranch.setBranch(postAnimalsDto.getBranch());
        newBranch.setImagesUrl(postAnimalsDto.getImagesUrl());
        branchMapper.insert(newBranch);

        Genus newGenus = new Genus();
        newGenus.setId(IdUtil.simpleUUID());
        newGenus.setGenus(postAnimalsDto.getGenus());
        newGenus.setBranchId(newBranch.getId());
        newGenus.setCreateTime(new Date());
        genusMapper.insert(newGenus);

        Species newSpecies = new Species();
        newSpecies.setId(IdUtil.simpleUUID());
        newSpecies.setSpecies(postAnimalsDto.getSpecies());
        newSpecies.setGenusId(newGenus.getId());
        newSpecies.setImagesUrl(postAnimalsDto.getImagesUrl());
        newSpecies.setCreateTime(new Date());
        speciesMapper.insert(newSpecies);

        Animals newAnimal = new Animals();
        newAnimal.setId(IdUtil.simpleUUID());
        newAnimal.setAlias(postAnimalsDto.getAlias());
        newAnimal.setAnimalName(postAnimalsDto.getAnimalName());
        newAnimal.setDescription(postAnimalsDto.getDescription());
        newAnimal.setAddress(postAnimalsDto.getAddress());
        newAnimal.setRemarks(postAnimalsDto.getRemarks());
        newAnimal.setCreateTime(new Date());
        newAnimal.setImagesUrl(postAnimalsDto.getImagesUrl());
        newAnimal.setSpeciesId(newSpecies.getId());
        System.out.println(newAnimal+"===========>newAnimal");
        animalsMapper.insert(newAnimal);

        return new Result().result200("添加成功",path);
    }
    /**
     * <p>修改动物</p>
     * @author tfj
     * @since 2021/6/23
     */
    @Override
    public Result putAnimal(String animalId, PostAnimalsDto postAnimalsDto, String path) {
        Branch branch = branchMapper.selectOne(new QueryWrapper<Branch>().eq("branch", postAnimalsDto.getBranch()));
        branch.setBranch(postAnimalsDto.getBranch());
        branchMapper.updateById(branch);
        String branchId = branch.getId();

        Genus genus = genusMapper.selectOne(new QueryWrapper<Genus>().eq("genus", postAnimalsDto.getGenus()));
        genus.setGenus(postAnimalsDto.getGenus());
        genus.setBranchId(branchId);
        genus.setModifyTime(new Date());
        genusMapper.updateById(genus);
        String genusId = genus.getId();

        Species species = speciesMapper.selectOne(new QueryWrapper<Species>().eq("species", postAnimalsDto.getSpecies()));
        species.setGenusId(genusId);
        species.setModifyTime(new Date());
        speciesMapper.updateById(species);
        String speciesId = species.getId();

        Animals animals = animalsMapper.selectOne(new QueryWrapper<Animals>().eq("id", animalId));
        System.out.println(postAnimalsDto.getAnimalName()+"=============>动物名称");
        animals.setAnimalName(postAnimalsDto.getAnimalName());
        animals.setAddress(postAnimalsDto.getAddress());
        animals.setDescription(postAnimalsDto.getDescription());
        animals.setRemarks(postAnimalsDto.getRemarks());
        animals.setImagesUrl(postAnimalsDto.getImagesUrl());
        animals.setSpeciesId(speciesId);
        animals.setAlias(postAnimalsDto.getAlias());
        animals.setModifyTime(new Date());
        animalsMapper.updateById(animals);
        return new Result().result200("修改成功",path);
    }
    /**
     * <p>删除动物</p>
     * @author tfj
     * @since 2021/6/23
     */
    @Override
    public Result deleteAnimalById(String animalId, String path) {
        if (animalsMapper.deleteById(animalId)==1){
            return new Result().result200("删除动物成功",path);
        }
        return new Result().result500("删除失败",path);
    }
}

