package hzpt.plants.directory.mapper;

import hzpt.plants.directory.entity.po.Species;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tfj
 * @since 2021-06-06
 */
public interface SpeciesMapper extends BaseMapper<Species> {

    @Select("select * from tbl_species where imagesUrl is null;")
    List<Species> searchSpeciesWhereImageNull();
}
