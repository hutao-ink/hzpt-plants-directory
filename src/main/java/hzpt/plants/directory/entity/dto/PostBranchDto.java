package hzpt.plants.directory.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostBranchDto {

    private String id ;

    @ApiModelProperty(value = "科目")
    private String branch;

    @ApiModelProperty(value = "科目类型地址")
    @TableField("type")
    private int type;


    @TableField("modifyTime")
    private Date modifyTime;
}
