package com.homework.supplychainmgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SupplyChainMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupplyChainMgmtApplication.class, args);
	}

}
