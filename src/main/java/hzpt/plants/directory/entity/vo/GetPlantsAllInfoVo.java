package hzpt.plants.directory.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/9
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_plants")
@ApiModel(value="Plants对象", description="植物信息类")
public class GetPlantsAllInfoVo {

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


    @ApiModelProperty(value = "分布区域id")
    @TableField("address")
    private String address;

    @ApiModelProperty(value = "备注")
    @TableField("remarks")
    private String remarks;

    @ApiModelProperty(value = "科")
    @TableField("branch")
    private String branch;

    @ApiModelProperty(value = "属")
    @TableField("genus")
    private String genus;

    @ApiModelProperty(value = "种")
    @TableField("species")
    private String species;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

}
