package hzpt.plants.directory.config;


import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/12
 */
@Configuration
@Data
public class OssConfig {
    @Value("${aliyun.oss.accessKeyId}")
    private String accessKeyId;

    @Value("${aliyun.oss.accessKeySecret}")
    private String accessKeySecret;

    @Value("${aliyun.oss.endpoint}")
    private String endpoint;

    @Value("${aliyun.oss.bucketName}")
    private String bucketName;

    @Value("${aliyun.oss.domain}")
    private String domain;

    @Bean
    public OSS OssClient(){
        return new OSSClientBuilder().build(endpoint,accessKeyId,accessKeySecret);
    }
}
