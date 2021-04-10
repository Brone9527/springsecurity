package com.example.springsecurity;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;
import java.util.List;

@SpringBootApplication
@RestController
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringsecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsecurityApplication.class, args);
    }

    @RequestMapping("/test")
    public String test(){
        return "hello spring security";
    }

    @RequestMapping("/")
    public String hello(){
        return "hello spring boot";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PreFilter("")
    @PostAuthorize("")
    @PostFilter("")
    @RequestMapping("/roleAuth")
    public String role(){
        return "admin auth";
    }

    @PreAuthorize("#id<10 or principal.username.equals(#username)")
    @PreFilter("")
    @PostAuthorize("returnObject%2==0")
    @PostFilter("")
    @RequestMapping("/role1Auth")
    public Integer role1(Integer id , String username){
        //...
        return id;
    }

    @PreFilter("filterObject%2==0")
    @PostFilter("filterObject%4==0")
    @RequestMapping("/role2Auth")
    public List<Integer> role2(List<Integer> idList ){
        //...
        return idList;
    }
}
