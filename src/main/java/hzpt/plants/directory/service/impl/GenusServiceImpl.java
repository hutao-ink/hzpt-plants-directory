package hzpt.plants.directory.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.dto.PostGenusDto;
import hzpt.plants.directory.entity.po.Genus;
import hzpt.plants.directory.mapper.GenusMapper;
import hzpt.plants.directory.service.GenusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import hzpt.plants.directory.utils.BeansUtils;
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
public class GenusServiceImpl extends ServiceImpl<GenusMapper, Genus> implements GenusService {
    @Resource
    private GenusMapper genusMapper;
    /**
     * <p>添加属目</p>
     * @author tfj
     * @since 2021/6/7
     */
    @Override
    public Result insertGenus(String genus, String branchId, String path) {
        Genus genus1=new Genus();
        genus1.setId(IdUtil.simpleUUID());
        genus1.setGenus(genus);
        genus1.setBranchId(branchId);
        genus1.setCreateTime(new Date());
        if (genusMapper.insert(genus1)==1){
            return new Result().result200(genus1.getId(),path);
        }
        return new Result().result200("添加失败",path);
    }
    /**
     * <p>查询所有属目</p>
     * @author tfj
     * @since 2021/6/7
     */
    @Override
    public Result searchGenus(String path) {
        List<Genus> genusList = genusMapper.selectList(new QueryWrapper<>());
        return new Result().result200(genusList,path);
    }
    /**
     * <p>通过科类id查找所有属类</p>
     * @author tfj
     * @since 2021/6/7
     */
    @Override
    public Result searchGenusByBranchId(String id, String path) {
        List<Genus> genusList = genusMapper.selectList(new QueryWrapper<Genus>().eq("branchId", id));
        return new Result().result200(genusList,path);
    }

    @Override
    public Result getGenusInfo(String genus, String path) {
        Genus selectOne = genusMapper.selectOne(new QueryWrapper<Genus>().eq("genus", genus));
        return new Result().result200(selectOne,path);
    }
    /**
     * <p>修改属目</p>
     * @author tfj
     * @since 2021/6/22
     */
    @Override
    public Result putGenusById(PostGenusDto postGenusDto, String path) {
        Genus genus = BeansUtils.beanCopy(postGenusDto, Genus.class);
        int i = genusMapper.update(genus, new QueryWrapper<Genus>().eq("id", postGenusDto.getId()));
        if (i==1){
            return new Result().result200("修改成功",path);
        }
        return new Result().result500("修改失败",path);
    }
    /**
     * <p>删除属目</p>
     * @author tfj
     * @since 2021/6/22
     */
    @Override
    public Result deleteGenus(String genusId, String path) {
        if (genusMapper.deleteById(genusId)==1){
            return new Result().result200("删除成功",path);
        }
        return new Result().result500("修改失败",path);
    }
}
