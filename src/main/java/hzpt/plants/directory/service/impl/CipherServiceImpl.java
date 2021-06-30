package hzpt.plants.directory.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoTools.core.IdUtil.IdUtil;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.po.Cipher;
import hzpt.plants.directory.mapper.CipherMapper;
import hzpt.plants.directory.service.CipherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/21
 */
@Service
public class CipherServiceImpl extends ServiceImpl<CipherMapper, Cipher> implements CipherService {
    @Resource
    private CipherMapper cipherMapper;

    /**
     * <p>管理员修改密码</p>
     * @author tfj
     * @since 2021/6/21
     */
    @Override
    public Result putCipher(String openId, String cipher,String oldCipher, String path) {
        Cipher selectOne = cipherMapper.selectOne(new QueryWrapper<Cipher>().eq("openId", openId));
        if (!oldCipher.equals(selectOne.getCipher())){
            return new Result().result200("密码错误，修改失败",path);
        }
        Cipher putCipher=new Cipher();
        putCipher.setCipher(cipher);
        int i = cipherMapper.update(putCipher, new QueryWrapper<Cipher>().eq("openId", openId));
        if (i==1){
            return new Result().result200("修改成功",path);
        }
        return new Result().result500("修改失败",path);
    }
    /**
     * <p>添加管理员权限密码</p>
     * @author tfj
     * @since 2021/6/21
     */
    @Override
    public Result insertCipher(String openId, String path) {
        Cipher cipher=new Cipher();
        cipher.setCipher("111111");
        cipher.setCreateTime(new Date());
        cipher.setId(IdUtil.simpleUUID());
        cipher.setOpenId(openId);
        cipherMapper.insert(cipher);
        return new Result().result200("添加管理员权限密码成功",path);
    }
}
