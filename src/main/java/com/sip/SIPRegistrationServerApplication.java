package com.sip;

import com.sip.servlet.AORRegistrationTCPServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SIPRegistrationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SIPRegistrationServerApplication.class, args);
        new AORRegistrationTCPServlet().start();
    }
}