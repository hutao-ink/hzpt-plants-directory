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
public class PostGenusDto {
    private String id ;

    @ApiModelProperty(value = "属")
    private String genus;

    @ApiModelProperty(value = "科的id")
    @TableField("branchId")
    private String branchId;

    @TableField("modifyTime")
    private Date modifyTime;
}
