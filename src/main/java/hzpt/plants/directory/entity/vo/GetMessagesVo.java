package hzpt.plants.directory.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: tfj
 * @Date: 2021/6/12 23
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetMessagesVo {

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


    @ApiModelProperty(value = "用户名")
    @TableField("nickName")
    private String nickName;

    @ApiModelProperty(value = "头像地址")
    @TableField("imageUrl")
    private String imageUrl;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private Date createTime;
}
