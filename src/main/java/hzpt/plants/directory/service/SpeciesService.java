package hzpt.plants.directory.service;

import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.po.Species;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tfj
 * @since 2021-06-06
 */
public interface SpeciesService extends IService<Species> {
    /**
     * <p>添加种类</p>
     * @author tfj
     * @since 2021/6/7
     */
    Result insertSpecies(String species, String genusId, String path);
    /**
     * <p>查询所有种类</p>
     * @author tfj
     * @since 2021/6/7
     */
    Result searchSpecies(String path);
    /**
     * <p>通过属类id查找所有种类</p>
     * @author tfj
     * @since 2021/6/7
     */
    Result searchSpeciesByGenusId(String id, String path);
}
