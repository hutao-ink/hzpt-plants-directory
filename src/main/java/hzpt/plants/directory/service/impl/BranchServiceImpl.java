package hzpt.plants.directory.service.impl;

import cn.hutool.core.util.IdUtil;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.config.OssConfig;
import hzpt.plants.directory.entity.dto.PostBranchDto;
import hzpt.plants.directory.entity.po.Animals;
import hzpt.plants.directory.entity.po.Branch;
import hzpt.plants.directory.mapper.BranchMapper;
import hzpt.plants.directory.service.BranchService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
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
    @Resource
    private OssConfig ossConfig;
    /**
     * <p>添加科目</p>
     * @author tfj
     * @since 2021/6/7
     */
    @Override
    public Result insertBranch(String branch,String path) {
        Branch addBranch=new Branch();
        Branch selectOne = branchMapper.selectOne(new QueryWrapper<Branch>().eq("branch", branch));
        if (selectOne!=null){
            return new Result().result200("科目已存在，无法添加",path);
        }
        addBranch.setId(IdUtil.simpleUUID());
        addBranch.setBranch(branch);
        addBranch.setCreateTime(new Date());
        if(branchMapper.insert(addBranch)==1){
            return new Result().result200(addBranch.getBranch(),path);
        }
        return new Result().result500("添加失败",path);
    }
    /**
     * <p>查询所有科目</p>
     * @author tfj
     * @since 2021/6/7
     */
    @Override
    public Result searchBranch(Integer currentPage,String path) {
        Page<Branch> page=new Page<>(currentPage,21);
        IPage<Branch> branchList=branchMapper.selectPage(page,null);
        return new Result().result200(branchList,path);
    }

    /**
     * <p>查询植物科目</p>
     * @author tfj
     * @since 2021/6/13
     */
    @Override
    public Result searchPlantBranch(String path) {
        List<Branch> type = branchMapper.selectList(new QueryWrapper<Branch>().eq("type", 0).orderByDesc("createTime"));
        return new Result().result200(type,path);
    }

    /**
     * <p>查询动物科目</p>
     * @author tfj
     * @since 2021/6/13
     */
    @Override
    public Result searchAnimalBranch(String path) {
        List<Branch> type = branchMapper.selectList(new QueryWrapper<Branch>().eq("type", 1).orderByDesc("createTime"));
        return new Result().result200(type,path);
    }
    /**
     * <p>通过科名获取科信息</p>
     * @author tfj
     * @since 2021/6/16
     */
    @Override
    public Result getBranchInfo(String branch, String path) {
        Branch selectOne = branchMapper.selectOne(new QueryWrapper<Branch>().eq("branch", branch));
        return new Result().result200(selectOne,path);
    }
    /**
     * <p>添加科目图片</p>
     * @author tfj
     * @since 2021/6/22
     */
    @Override
    public Result insertBranchImage(MultipartFile file, String branchName, String path) {
        OSS ossClient = new OSSClientBuilder().build(ossConfig.getEndpoint(), ossConfig.getAccessKeyId(), ossConfig.getAccessKeySecret());
        if (file != null) {
            String originalFilename = file.getOriginalFilename();

            PutObjectRequest putObjectRequest = null;
            try {
                putObjectRequest = new PutObjectRequest(ossConfig.getBucketName(), originalFilename, new ByteArrayInputStream(file.getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            ossClient.putObject(putObjectRequest);
            ossClient.shutdown();

            String imagesUrl = ossConfig.getDomain() + originalFilename;
            Branch selectOne = branchMapper.selectOne(new QueryWrapper<Branch>().eq("branch", branchName));
            selectOne.setImagesUrl(imagesUrl);
            branchMapper.updateById(selectOne);
            return new Result().result200("添加科目图片成功",path);
        }
        return new Result().result500("添加科目图片失败",path);
    }
    /**
     * <p>删除科目</p>
     * @author tfj
     * @since 2021/6/22
     */
    @Override
    public Result deleteBranchById(String branchId, String path) {
        int i = branchMapper.deleteById(branchId);
        if (i==1){
            return new Result().result200("删除成功",path);
        }
        return new Result().result500("删除失败",path);
    }
    /**
     * <p>修改科目信息</p>
     * @author tfj
     * @since 2021/6/22
     */
    @Override
    public Result putBranchById(PostBranchDto postBranchDto, String path) {
        Branch selectOne = branchMapper.selectOne(new QueryWrapper<Branch>().eq("id", postBranchDto.getId()));
        selectOne.setBranch(postBranchDto.getBranch());
        selectOne.setModifyTime(new Date());
        selectOne.setType(postBranchDto.getType());
        if (branchMapper.updateById(selectOne)==1){
            return new Result().result200("修改成功",path);
        }
        return new Result().result500("修改失败",path);
    }
    /**
     * <p>修改科目信息</p>
     * @author tfj
     * @since 2021/6/22
     */
    @Override
    public Result putBranchImage(MultipartFile file, String branchId, String path) {
        OSS ossClient = new OSSClientBuilder().build(ossConfig.getEndpoint(), ossConfig.getAccessKeyId(), ossConfig.getAccessKeySecret());
        if (file != null) {
            String originalFilename = file.getOriginalFilename();
            PutObjectRequest putObjectRequest = null;
            try {
                putObjectRequest = new PutObjectRequest(ossConfig.getBucketName(), originalFilename, new ByteArrayInputStream(file.getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            ossClient.putObject(putObjectRequest);
            ossClient.shutdown();

            String imagesUrl = ossConfig.getDomain() + originalFilename;
            Branch branch = branchMapper.selectOne(new QueryWrapper<Branch>().eq("id", branchId));
            branch.setImagesUrl(imagesUrl);
            branchMapper.updateById(branch);
            return new Result().result200("修改科目图片成功",path);
        }
        return new Result().result500("修改科目图片失败",path);
    }
}
