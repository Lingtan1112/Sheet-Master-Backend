package com.sheetmaster.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.google.api.services.sheets.v4.Sheets;
import com.sheetmaster.model.Sheet;
import com.sheetmaster.util.SheetsServiceUtil;

import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/v1/sheet")
//@CrossOrigin(origins = "http://localhost:4200")
public class SheetController {

	@GetMapping("/list")
	public String getSheetList() {
		System.out.println("Hello");

		try {
			Mono<Sheet> d = WebClient.builder().
			build()
			.get()
			.uri("https://sheets.googleapis.com/v4/spreadsheets/{spreadsheetId}/values/{range}")
			.retrieve()
			.bodyToMono(Sheet.class);
			Sheets sheetService = SheetsServiceUtil.getSheetsService();
			System.out.println(d);
			
		} catch (IOException | GeneralSecurityException e) {
			e.printStackTrace();
		}
		return "Hello World";
		
		
	}
	
	@GetMapping("/demo")
	public String demo() {
		
		return "Hello World";
		
	}
	
}
