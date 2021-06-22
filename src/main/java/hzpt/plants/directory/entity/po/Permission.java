package hzpt.plants.directory.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_permission")
@ApiModel(value="permission对象", description="permission表实体类")
public class Permission implements Serializable {

    private String id;

   @ApiModelProperty(value = "权限名")
    @TableField("permissionName")
    private String permissionName;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private Date createTime;

    @TableField("modifyTime")
    private Date modifyTime;


}
