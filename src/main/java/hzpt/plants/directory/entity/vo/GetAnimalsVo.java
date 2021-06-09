package hzpt.plants.directory.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: tfj
 * @Date: 2021/6/8 16
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_animals")
public class GetAnimalsVo {

    private String id;

    @ApiModelProperty(value = "动物名称")
    @TableField("animalName")
    private String animalName;
}
