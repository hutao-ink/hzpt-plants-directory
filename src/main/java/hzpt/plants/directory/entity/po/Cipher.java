package hzpt.plants.directory.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_cipher")
@ApiModel(value="密码", description="tbl_cipher表实体类")
public class Cipher {
    private String id;

    @TableField("openId")
    private String openId;

    private String cipher;

    @TableField("createTime")
    private Date createTime;

    @TableField("modifyTime")
    private Date modifyTime;
}
