package com.abdulmajid.minilink;

import com.abdulmajid.minilink.util.ShortCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MinilinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinilinkApplication.class, args);
        System.out.println("Running ...");
       // System.out.println(ShortCodeGenerator.generateShortCode());
	}



}
