package hzpt.plants.directory.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/21
 */
@Data
public class GetUserInfoVo {

    @TableField("openId")
    private String openId;

    @ApiModelProperty(value = "用户名")
    @TableField("nickName")
    private String nickName;

    @ApiModelProperty(value = "城市")
    @TableField("city")
    private String city;

    @ApiModelProperty(value = "头像地址")
    @TableField("imageUrl")
    private String imageUrl;


    @ApiModelProperty("权限名")
    @TableField("permissionName")
    private String permissionName;
}
