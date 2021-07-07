package hzpt.plants.directory.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

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

    @ApiModelProperty(value = "用户凭证")
    @TableField("openId")
    private String openId;

    @ApiModelProperty(value = "留言信息")
    @TableField("userMessage")
    private String userMessage;

    @ApiModelProperty(value = "用户上传图片地址")
    @TableField("imagesUrl")
    private String imagesUrl;

    @TableField("deleted")
    @TableLogic
    private int deleted;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private Date createTime;

    @TableField("modifyTime")
    private Date modifyTime;
}
