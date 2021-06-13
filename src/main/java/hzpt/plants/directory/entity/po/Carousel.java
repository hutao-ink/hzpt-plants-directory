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
 * @since 2021-06-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_carousel")
@ApiModel(value="Carousel对象", description="")
public class Carousel implements Serializable {

    private String id ;


    @ApiModelProperty(value = "图片地址")
    @TableField("carouselUrl")
    private String carouselUrl;

    @ApiModelProperty(value = "物种id")
    @TableField("biologicalId")
    private String biologicalId;

     @ApiModelProperty(value = "物种名称")
     @TableField("biologicalName")
     private String biologicalName;


    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private Date createTime;


}
