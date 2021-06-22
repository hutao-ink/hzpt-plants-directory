package hzpt.plants.directory.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_user_permission")
@ApiModel(value="用户权限", description="tbl_user_permission表实体类")
public class UserPermission {

    private String id;

    @TableField("openId")
    private String openId;

    @TableField("permissionId")
    private String permissionId;

    @TableField("createTime")
    private Date createTime;

    @TableField("modifyTime")
    private Date modifyTime;

}
