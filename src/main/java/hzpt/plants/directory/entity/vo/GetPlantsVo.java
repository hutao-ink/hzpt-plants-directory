package hzpt.plants.directory.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: tfj
 * @Date: 2021/6/7 16
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_plants")
public class GetPlantsVo {

    private String id;

    @ApiModelProperty(value = "植物名称")
    @TableField("plantName")
    private String plantName;

}
