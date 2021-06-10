package hzpt.plants.directory.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import hzpt.plants.directory.entity.po.Animals;
import hzpt.plants.directory.entity.vo.GetAnimalsAllInfoVo;

/**
 * @Author: tfj
 * @Date: 2021/6/8 14
 * @Description:
 */
public interface AnimalsMapper extends BaseMapper<Animals> {
    /**
     * <p>通过id四表联查动物所有信息</p>
     * @author tfj
     * @since 2021/6/9
     */
    GetAnimalsAllInfoVo getAnimalsAllInfoVo(String id);
}
