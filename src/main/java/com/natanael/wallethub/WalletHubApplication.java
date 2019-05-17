package com.natanael.wallethub;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.classic.Logger;

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
		// ps.procesarArchivo(file);

		LocalDateTime startDate = LocalDateTime.of(2017, 1, 6, 4, 30);
		String duration = "hourly";
		int threshold = 100;

		if (args.containsOption("startDate")) {
			System.out.println(args.getOptionValues("duration").get(0));
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd.HH:mm:ss");
			startDate = LocalDateTime.parse(args.getOptionValues("startDate").get(0), formato);
		}

		if (args.containsOption("duration")) {
			System.out.println(args.getOptionValues("duration").get(0));
			duration = args.getOptionValues("duration").get(0);
		}

		if (args.containsOption("threshold")) {
			System.out.println(args.getOptionValues("duration").get(0));
			threshold = Integer.parseInt(args.getOptionValues("threshold").get(0));
		}
		
		//Meter cada linea del file en un Stream, filtrar por los parametro recibidos
		ps.procesarArchivo(file, startDate, duration, threshold);
		
		
	}
}
