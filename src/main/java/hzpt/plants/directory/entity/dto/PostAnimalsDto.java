package hzpt.plants.directory.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/23
 */
@Data
public class PostAnimalsDto {
    private String id ;

    @ApiModelProperty(value = "动物名称")
    @TableField("animalName")
    private String animalName;

    @ApiModelProperty(value = "别名")
    private String alias;

    @ApiModelProperty(value = "图片地址")
    @TableField("imagesUrl")
    private String imagesUrl;

    @ApiModelProperty(value = "描述信息")
    @TableField("description")
    private String description;

    @ApiModelProperty(value = "分布区域")
    @TableField("address")
    private String address;

    @ApiModelProperty(value = "备注")
    @TableField("remarks")
    private String remarks;

    @TableField("modifyTime")
    private Date modifyTime;

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
