package hzpt.plants.directory.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostUserDto {

    @ApiModelProperty(value = "用户名")
    @TableField("userName")
    private String userName;
}
