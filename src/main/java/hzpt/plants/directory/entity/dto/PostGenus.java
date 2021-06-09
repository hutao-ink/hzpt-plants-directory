package hzpt.plants.directory.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author: tfj
 * @Date: 2021/6/6 13
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostGenus {

    private String id ;

    @ApiModelProperty(value = "属")
    private String genus;

    @ApiModelProperty(value = "科的id")
    private String branchId;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
}
