package com.sheetmaster;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.google.api.services.sheets.v4.Sheets;
import com.sheetmaster.util.SheetsServiceUtil;

@SpringBootApplication(scanBasePackages = "com")
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public class SheetmasterApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SheetmasterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello start");
		Sheets sheetsService = SheetsServiceUtil.getSheetsService();
		System.out.println(sheetsService.getBaseUrl());
		System.out.println(sheetsService.getServicePath());
		System.out.println(sheetsService.getRootUrl());
		System.out.println(sheetsService);
		
	}

}
