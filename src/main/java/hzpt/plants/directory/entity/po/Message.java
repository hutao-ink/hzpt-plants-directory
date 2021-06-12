package hzpt.plants.directory.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_message")
@ApiModel(value="message对象", description="用户留言实体类")
public class Message {

    private String id;

    @ApiModelProperty(value = "用户id")
    @TableField("userId")
    private String userId;

    @ApiModelProperty(value = "留言信息")
    @TableField("userMessage")
    private String userMessage;

    @ApiModelProperty(value = "用户上传图片地址")
    @TableField("imagesUrl")
    private String imagesUrl;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private String createTime;
}
