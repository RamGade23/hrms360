package com.cordis.hrms360.configuaration;

import com.cordis.hrms360.bean.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HrmsConfig {

    @Bean
    public TestBean getTestBean() {
        System.out.println("inside HrmsConfig at getTestBean");
        return new TestBean();
    }
}
