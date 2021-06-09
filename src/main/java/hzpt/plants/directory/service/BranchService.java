package hzpt.plants.directory.service;

import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.po.Branch;
import com.baomidou.mybatisplus.extension.service.IService;

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
    Result searchBranch(String path);

}
