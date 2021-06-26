package hzpt.plants.directory.service;

import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.dto.PostBranchDto;
import hzpt.plants.directory.entity.po.Branch;
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
public interface BranchService extends IService<Branch> {
    /**
     * <p>添加科目</p>
     * @author tfj
     * @since 2021/6/7
     */
    Result insertBranch(String branch,String path);
    /**
     * <p>查询所有科目</p>
     * @author tfj
     * @since 2021/6/7
     */
    Result searchBranch(Integer currentPage,String path);
    /**
     * <p>查询植物科目</p>
     * @author tfj
     * @since 2021/6/13
     */
    Result searchPlantBranch(String path);
    /**
     * <p>查询动物科目</p>
     * @author tfj
     * @since 2021/6/13
     */
    Result searchAnimalBranch(String path);
    /**
     * <p>通过科名获取科信息</p>
     * @author tfj
     * @since 2021/6/16
     */
    Result getBranchInfo(String branch, String path);
    /**
     * <p>添加科目图片</p>
     * @author tfj
     * @since 2021/6/22
     */
    Result insertBranchImage(MultipartFile file, String branchName, String path);
    /**
     * <p>删除科目</p>
     * @author tfj
     * @since 2021/6/22
     */
    Result deleteBranchById(String branchId, String path);
    /**
     * <p>修改科目信息</p>
     * @author tfj
     * @since 2021/6/22
     */
    Result putBranchById(PostBranchDto postBranchDto, String path);
    /**
     * <p>修改科目图片</p>
     * @author tfj
     * @since 2021/6/22
     */
    Result putBranchImage(MultipartFile file, String branchId, String path);
}
