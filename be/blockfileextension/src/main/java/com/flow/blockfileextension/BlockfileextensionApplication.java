package com.flow.blockfileextension;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class BlockfileextensionApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlockfileextensionApplication.class, args);
	}
}
