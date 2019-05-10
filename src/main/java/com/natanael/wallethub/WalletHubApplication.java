package com.natanael.wallethub;

import java.io.File;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//lograr que H2 cree la base de dato, se conecte y cree la tabla automaticamente.
@SpringBootApplication
public class WalletHubApplication implements ApplicationRunner {

	private Parser ps;
	
	public WalletHubApplication(Parser ps) {
		this.ps = ps;
	}

	public static void main(String[] args) {
		SpringApplication.run(WalletHubApplication.class, args);		
		
		
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		File file = new File("access.log");
		ps.procesarArchivo(file);
		
		
		
	}

}
