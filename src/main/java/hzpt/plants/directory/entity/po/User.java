package hzpt.plants.directory.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Author: tfj
 * @Date: 2021/6/8 14
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_plants")
@ApiModel(value="Plants对象", description="")
public class User implements Serializable {
    private String id;
}
