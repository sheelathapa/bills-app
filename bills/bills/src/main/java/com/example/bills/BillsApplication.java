package com.example.bills;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BillsApplication {

    public static void main(String[] args) {
//		var encoder = new BCryptPasswordEncoder();
//		System.out.println(encoder.encode("password1"));

        SpringApplication.run(BillsApplication.class, args);
    }

}
