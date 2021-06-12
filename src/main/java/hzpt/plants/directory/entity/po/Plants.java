package hzpt.plants.directory.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author tfj
 * @since 2021-06-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_plants")
@ApiModel(value="Plants对象", description="")
public class Plants implements Serializable {

    private String id ;

    @ApiModelProperty(value = "植物名称")
    @TableField("plantName")
    private String plantName;

    @ApiModelProperty(value = "别名")
    private String alias;

    @ApiModelProperty(value = "图片地址")
    @TableField("imagesUrl")
    private String imagesUrl;

    @ApiModelProperty(value = "描述信息")
    private String description;

    @ApiModelProperty(value = "种类id")
    @TableField("speciesId")
    private String speciesId;

    @ApiModelProperty(value = "分布区域id")
    @TableField("address")
    private String address;

    @ApiModelProperty(value = "备注")
    @TableField("remarks")
    private String remarks;

    @ApiModelProperty(value = "逻辑删除，1删除，0没删除")
    private Integer deleted;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
}
