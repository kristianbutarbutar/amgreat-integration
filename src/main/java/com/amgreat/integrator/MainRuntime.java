package com.amgreat.integrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan (basePackages = "com.amgreat.lib, com.amgreat.integrator.be, com.amgreat.integrator.cache, com.amgreat.integrator.ctrl, com.amgreat.integrator.data, com.amgreat.integrator.util, com.amgreat.vo")
@SpringBootApplication
public class MainRuntime 
{
    public static void main(String[] args) {
		SpringApplication.run(MainRuntime.class, args);
	}
}
