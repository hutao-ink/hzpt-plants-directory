package hzpt.plants.directory.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/8
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_carousel")
public class GetCarouselVo {

    private String id ;


    @ApiModelProperty(value = "图片地址")
    @TableField("carouselUrl")
    private String carouselUrl;

    @ApiModelProperty(value = "物种id")
    @TableField("biologicalId")
    private String biologicalId;
}
