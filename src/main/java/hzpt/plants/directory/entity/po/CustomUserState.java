package hzpt.plants.directory.entity.po;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: tfj
 * @Date: 2021/6/10 10
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value="User登录对象", description="自定义用户登录状态")
public class CustomUserState {

    private String openid;

    private String sessionKey;
}
