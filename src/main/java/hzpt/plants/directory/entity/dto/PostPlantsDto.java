package hzpt.plants.directory.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * <p></p>
 * @author tfj
 * @since 2021/6/22
 */
@Data
public class PostPlantsDto {

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

    @ApiModelProperty(value = "分布区域")
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
}
