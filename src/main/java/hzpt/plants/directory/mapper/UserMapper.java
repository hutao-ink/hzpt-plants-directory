package hzpt.plants.directory.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import hzpt.plants.directory.entity.po.Message;
import hzpt.plants.directory.entity.po.User;
import hzpt.plants.directory.entity.vo.GetUserInfoVo;

import java.util.List;

public interface UserMapper extends BaseMapper<User>{


    String getPermissionByNickName(String nickName);


    List<GetUserInfoVo> getAllUserInfo();

    String getUserRole(String nickName);
}
