package hzpt.plants.directory.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.dto.PostAnimalsDto;
import hzpt.plants.directory.entity.po.Animals;
import hzpt.plants.directory.entity.vo.GetAnimalsVo;

import java.util.List;

/**
 * @Author: tfj
 * @Date: 2021/6/8 16
 * @Description:
 */
public interface AnimalsService extends IService<Animals> {
    /**
     * <p>通过名字模糊查询</p>
     * @author tfj
     * @since 2021/6/8
     */
    Result fuzzyQuery(String name, String path);
    /**
     * <p>通过名字模糊查询返回VO</p>
     * @author tfj
     * @since 2021/6/8
     */
    List<GetAnimalsVo> fuzzyQueryAnimals(String name,Integer currentPage);
    /**
     * <p>通过动物id获取动物所有信息</p>
     * @author tfj
     * @since 2021/6/9
     */
    Result queryAnimalById(String id, String path);
    /**
     * <p>通过种类id查找所有动物</p>
     * @author tfj
     * @since 2021/6/9
     */
    Result searchAnimalsByGenusId(String id, String path);
    /**
     * <p>查询所有动物</p>
     * @author tfj
     * @since 2021/6/9
     */
    Result searchAnimals(Integer currentPage,String path);
    /**
     * <p>添加动物</p>
     * @author tfj
     * @since 2021/6/23
     */
    Result insertPlant(PostAnimalsDto postAnimalsDto, String path);
    /**
     * <p>修改动物</p>
     * @author tfj
     * @since 2021/6/23
     */
    Result putAnimal(String animalId, PostAnimalsDto postAnimalsDto, String path);
    /**
     * <p>删除动物</p>
     * @author tfj
     * @since 2021/6/23
     */
    Result deleteAnimalById(String animalId, String path);
}
