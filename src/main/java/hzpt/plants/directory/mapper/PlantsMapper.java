package hzpt.plants.directory.mapper;

import hzpt.plants.directory.entity.po.Plants;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import hzpt.plants.directory.entity.vo.GetPlantsAllInfoVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tfj
 * @since 2021-06-06
 */
public interface PlantsMapper extends BaseMapper<Plants> {
    /**
     * <p>通过id四表联查获取植物所有属性</p>
     * @author tfj
     * @since 2021/6/9
     */
    GetPlantsAllInfoVo searchPlantsAllInfo(String id);
}
