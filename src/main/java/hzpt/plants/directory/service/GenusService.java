package hzpt.plants.directory.service;

import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.dto.PostGenusDto;
import hzpt.plants.directory.entity.po.Genus;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tfj
 * @since 2021-06-06
 */
public interface GenusService extends IService<Genus> {

    /**
     * <p>添加属目</p>
     * @author tfj
     * @since 2021/6/7
     */
    Result insertGenus(String genus, String branchId, String path);
    /**
     * <p>查询所有属目</p>
     * @author tfj
     * @since 2021/6/7
     */
    Result searchGenus(Integer currentPage,String path);
    /**
     * <p>通过科类id查找所有属类</p>
     * @author tfj
     * @since 2021/6/7
     */
    Result searchGenusByBranchId(String id, String path);
    /**
     * <p>修改属目</p>
     * @author tfj
     * @since 2021/6/22
     */
    Result putGenusById(PostGenusDto postGenusDto, String path);
    /**
     * <p>删除属目</p>
     * @author tfj
     * @since 2021/6/22
     */
    Result deleteGenus(String genusId, String path);
}
