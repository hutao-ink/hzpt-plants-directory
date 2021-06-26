package hzpt.plants.directory.service;

import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.dto.PostSpeciesDto;
import hzpt.plants.directory.entity.po.Species;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

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
    Result insertSpecies(PostSpeciesDto postSpeciesDto, String path);
    /**
     * <p>查询所有种类</p>
     * @author tfj
     * @since 2021/6/7
     */
    Result searchSpecies(Integer currentPage,String path);
    /**
     * <p>通过属类id查找所有种类</p>
     * @author tfj
     * @since 2021/6/7
     */
    Result searchSpeciesByGenusId(String id, String path);
    /**
     * <p>种类插入图片</p>
     * @author tfj
     * @since 2021/6/22
     */
    Result insertImageById(String speciesId, MultipartFile file, String path);
    /**
     * <p>删除物种</p>
     * @author tfj
     * @since 2021/6/22
     */
    Result deleteSpecies(String speciesId, String path);
}
