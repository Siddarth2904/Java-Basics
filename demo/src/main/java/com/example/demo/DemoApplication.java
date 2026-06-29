package com.example.demo;

import com.example.interfaceDemo.MobileDeveloper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo", "com.example.interfaceDemo"})
public class DemoApplication {

	public static void main(String[] args) {
        ApplicationContext ac =SpringApplication.run(DemoApplication.class, args);
        ComputerDevloper compDev = ac.getBean(ComputerDevloper.class);
        compDev.develop();
        MobileDeveloper mobDev=ac.getBean(MobileDeveloper.class);
        mobDev.develop();
	}

}
