package hzpt.plants.directory;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import hzpt.plants.directory.entity.po.Branch;
import hzpt.plants.directory.entity.po.Genus;
import hzpt.plants.directory.entity.po.Plants;
import hzpt.plants.directory.entity.po.Species;
import hzpt.plants.directory.entity.vo.GetMessagesVo;
import hzpt.plants.directory.entity.vo.GetPlantsAllInfoVo;
import hzpt.plants.directory.entity.vo.GetPlantsVo;
import hzpt.plants.directory.mapper.*;
import hzpt.plants.directory.service.*;
import hzpt.plants.directory.utils.BeansUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class HzptPlantsDirectoryApplicationTests {

    @Resource
    private BranchService branchService;
    @Resource
    private GenusService genusService;
    @Resource
    private SpeciesService speciesService;
    @Resource
    private PlantsService plantsService;
    @Resource
    private BranchMapper branchMapper;
    @Resource
    private GenusMapper genusMapper;
    @Resource
    private PlantsMapper plantsMapper;
    @Resource
    private MessageMapper messageMapper;
    @Resource
    private AnimalsService animalsService;

    @Test
    void contextLoads() {
        System.out.println(new Date());
    }

    /**
     * 批量添加科目
     */
    @Test
    public void insertBranch(){
        List<Branch> branchList=new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            Branch branch=new Branch();
            branch.setId(IdUtil.simpleUUID());
            branch.setCreateTime(new Date());
            branchList.add(branch);
        }
        boolean b=branchService.saveBatch(branchList);
        System.out.println(b);
    }

    /**
     * 批量添加属类
     */
    @Test
    public void insertGenus(){
        List<Genus> genusList=new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            Genus genus=new Genus();
            genus.setId(IdUtil.simpleUUID());
            genus.setCreateTime(new Date());
            genusList.add(genus);
        }
        boolean b=genusService.saveBatch(genusList);
        System.out.println(b);
    }

    /**
     * 批量添加种类
     */
    @Test
    public void insertSpecies(){
        List<Species> speciesList=new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            Species species=new Species();
            species.setId(IdUtil.simpleUUID());
            species.setCreateTime(new Date());
            speciesList.add(species);
        }
        boolean b=speciesService.saveBatch(speciesList);
        System.out.println(b);
    }
    /**
     * 批量添加种类
     */
    @Test
    public void insertPlants(){
        List<Plants> plantsList=new ArrayList<>(23);
        for (int i = 0; i < 23; i++) {
            Plants plants=new Plants();
            plants.setId(IdUtil.simpleUUID());
            plants.setCreateTime(new Date());
            plantsList.add(plants);
        }
        boolean b=plantsService.saveBatch(plantsList);
        System.out.println(b);
    }

    @Test
    public void SearchBranch(){
        List<Branch> branchList = branchMapper.selectList(new QueryWrapper<>());
        branchList.forEach(branch -> System.out.println(branch));
    }

    @Test
    public void searchGenus(){
        List<Genus> genusList = genusMapper.selectList(new QueryWrapper<>());
        genusList.forEach(genus -> System.out.println(genus));
    }

    @Test
    public void fuzzyQuery(){
        List<Plants> plantsList = plantsMapper.selectList(new QueryWrapper<Plants>().like("plantName", "花"));
        List<GetPlantsVo> getPlantsVos = BeansUtils.listCopy(plantsList, GetPlantsVo.class);
        getPlantsVos.forEach(getPlantsVo -> System.out.println(getPlantsVo));
    }

    @Test
    public void Count(){
        int plantsCount = plantsService.count();
        int animalCount = animalsService.count();
        int branchCount = branchService.count();
        int genusCount = genusService.count();
        int speciesCount = speciesService.count();
        System.out.println("plantsCount===>"+plantsCount);
        System.out.println("animalCount===>"+animalCount);
        System.out.println("speciesCount===>"+speciesCount);
        System.out.println("genusCount===>"+genusCount);
        System.out.println("branchCount===>"+branchCount);
    }

    @Test
    public void idCreate(){
        for (int i = 0; i < 41; i++) {
            String s = IdUtil.simpleUUID();
            System.out.println(s);
        }
    }

    @Test
    public void searchPlantsAllInfo(){
        GetPlantsAllInfoVo plant = plantsMapper.searchPlantsAllInfo("de2a39aa3fbb4b08bd2c8ffb1bc45333");
        System.out.println(plant);
    }

    @Test
    public void test5(){
        List<GetMessagesVo> allMessage = messageMapper.getAllMessage();
        allMessage.forEach(getMessagesVo -> System.out.println(getMessagesVo));
    }

}
