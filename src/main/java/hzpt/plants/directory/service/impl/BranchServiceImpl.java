package hzpt.plants.directory.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.po.Branch;
import hzpt.plants.directory.mapper.BranchMapper;
import hzpt.plants.directory.service.BranchService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tfj
 * @since 2021-06-06
 */
@Service
public class BranchServiceImpl extends ServiceImpl<BranchMapper, Branch> implements BranchService {
    @Resource
    private BranchMapper branchMapper;
    /**
     * <p>添加科目</p>
     * @author tfj
     * @since 2021/6/7
     */
    @Override
    public Result insertBranch(String branch,String path) {
        Branch branch1=new Branch();
        branch1.setId(IdUtil.simpleUUID());
        branch1.setBranch(branch);
        branch1.setCreateTime(new Date());
        if(branchMapper.insert(branch1)==1){
            return new Result().result200("添加成功",path);
        }
        return new Result().result500("添加失败",path);
    }
    /**
     * <p>查询所有科目</p>
     * @author tfj
     * @since 2021/6/7
     */
    @Override
    public Result searchBranch(String path) {
        List<Branch> branchList = branchMapper.selectList(new QueryWrapper<>());
        return new Result().result200(branchList,path);
    }

    /**
     * <p>查询植物科目</p>
     * @author tfj
     * @since 2021/6/13
     */
    @Override
    public Result searchPlantBranch(String path) {
        List<Branch> type = branchMapper.selectList(new QueryWrapper<Branch>().eq("type", 0));
        return new Result().result200(type,path);
    }

    /**
     * <p>查询动物科目</p>
     * @author tfj
     * @since 2021/6/13
     */
    @Override
    public Result searchAnimalBranch(String path) {
        List<Branch> type = branchMapper.selectList(new QueryWrapper<Branch>().eq("type", 1));
        return new Result().result200(type,path);
    }
}
