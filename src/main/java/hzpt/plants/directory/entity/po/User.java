package hzpt.plants.directory.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/8
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_user")
@ApiModel(value="User对象", description="user表实体类")
public class User implements Serializable {

    private String id;

    @ApiModelProperty(value = "用户名")
    @TableField("nickName")
    private String nickName;

    @ApiModelProperty(value = "头像地址")
    @TableField("imageUrl")
    private String imageUrl;

    @ApiModelProperty(value = "用户性别")
    @TableField("gender")
    private int gender;

    @ApiModelProperty(value = "openID")
    @TableField("openId")
    private String openId;

    @ApiModelProperty(value = "城市")
    @TableField("city")
    private String city;

    @ApiModelProperty(value = "省份")
    @TableField("province")
    private String province;

   @ApiModelProperty(value = "国家")
    @TableField("country")
    private String country;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private Date createTime;

}
