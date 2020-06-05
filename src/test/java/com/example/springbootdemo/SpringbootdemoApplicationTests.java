package com.example.springbootdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.lang.Nullable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.yaml.snakeyaml.introspector.PropertyUtils;

import javax.annotation.Resource;
import java.security.ProtectionDomain;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootdemoApplicationTests {


    private Environment env;

    @Test
    public void contextLoads() {
        System.out.println(env.getDefaultProfiles()[0]);
    }

    public static void main(String[] args) throws Exception{
        String str = "{\"name\":\"qiuzhi\",\"address\":\"ningjin\",\"con\":\"con\",\"students\":[{\"name\":\"zhangsan\",\"age\":11},{\"name\":\"lisi\",\"age\":12}]}";
        ObjectMapper mapper = new ObjectMapper();

        School school = mapper.readValue(str, School.class);
        System.out.println(school);
    }

}
