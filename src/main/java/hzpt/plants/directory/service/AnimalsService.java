package hzpt.plants.directory.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoTools.core.result.Result;
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
    List<GetAnimalsVo> fuzzyQueryAnimals(String name);
}
