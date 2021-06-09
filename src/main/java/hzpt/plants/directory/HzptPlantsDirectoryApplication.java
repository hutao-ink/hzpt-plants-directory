package hzpt.plants.directory;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "hzpt.plants.directory.mapper")
public class HzptPlantsDirectoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(HzptPlantsDirectoryApplication.class, args);
    }

}
