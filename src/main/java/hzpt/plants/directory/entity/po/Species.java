package hzpt.plants.directory.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
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
@TableName("tbl_species")
@ApiModel(value="Species对象", description="")
public class Species implements Serializable {

    private String id ;

    @ApiModelProperty(value = "种名")
    private String species;

    @ApiModelProperty(value = "图片地址")
    @TableField("imagesUrl")
    private String imagesUrl;

    @ApiModelProperty(value = "属类id")
    @TableField("genusId")
    private String genusId;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;


}
