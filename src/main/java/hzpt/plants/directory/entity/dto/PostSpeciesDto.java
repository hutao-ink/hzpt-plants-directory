package hzpt.plants.directory.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/22
 */
@Data
public class PostSpeciesDto {
    private String id ;

    @ApiModelProperty(value = "种名")
    private String species;

    @ApiModelProperty(value = "属的id")
    @TableField("genusId")
    private String genusId;

    @TableField("modifyTime")
    private Date modifyTime;
}
