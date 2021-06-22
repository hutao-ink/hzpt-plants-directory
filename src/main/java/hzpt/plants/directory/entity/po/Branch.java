package hzpt.plants.directory.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author tfj
 * @since 2021-06-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_branch")
@ApiModel(value="Branch对象", description="")
public class Branch implements Serializable {

    private String id ;

    @ApiModelProperty(value = "科目")
    private String branch;

    @ApiModelProperty(value = "图片地址")
    @TableField("imagesUrl")
    private String imagesUrl;

    @ApiModelProperty(value = "科目类型地址")
    @TableField("type")
    private int type;

    @TableField("deleted")
    @TableLogic
    private int deleted;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private Date createTime;

    @TableField("modifyTime")
    private Date modifyTime;
}
