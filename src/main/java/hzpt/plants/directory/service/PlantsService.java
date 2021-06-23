package hzpt.plants.directory.service;

import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.dto.PostPlantsDto;
import hzpt.plants.directory.entity.po.Plants;
import com.baomidou.mybatisplus.extension.service.IService;
import hzpt.plants.directory.entity.vo.GetPlantsVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tfj
 * @since 2021-06-06
 */
public interface PlantsService extends IService<Plants> {
    /**
     * <p>查询所有植物</p>
     * @author tfj
     * @since 2021/6/7
     */
    Result searchPlants(String path);
    /**
     * <p>通过种类id查找所有植物</p>
     * @author tfj
     * @since 2021/6/7
     */
    Result searchPlantsByGenusId(String id, String path);
    /**
     * <p>分页模糊查询</p>
     * @author tfj
     * @since 2021/6/7
     */
    Result fuzzyQuery(String name,Integer currentPage, String path);
    /**
     * <p>通过名字模糊查询</p>
     * @author tfj
     * @since 2021/6/8
     */
    List<GetPlantsVo> fuzzyQueryPlants(String name,Integer currentPage);
    /**
     * <p>通过植物id查询植物所有信息</p>
     * @author tfj
     * @since 2021/6/7
     */
    Result queryPlantById(String id, String path);
    /**
     * <p>添加植物</p>
     * @author tfj
     * @since 2021/6/22
     */
    Result insertPlant(PostPlantsDto postPlantsDto, String path);
    /**
     * <p>修改植物</p>
     * @author tfj
     * @since 2021/6/23
     */
    Result putPlantById(PostPlantsDto postPlantsDto, String plantId, String path);
    /**
     * <p>删除植物</p>
     * @author tfj
     * @since 2021/6/23
     */
    Result deletePlantById(String plantId, String path);
}
