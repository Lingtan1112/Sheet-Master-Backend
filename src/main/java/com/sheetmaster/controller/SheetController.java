package com.sheetmaster.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/v1/sheet")
//@CrossOrigin(origins = "http://localhost:4200")
public class SheetController {

	@GetMapping("/list")
	public ResponseEntity<Object> getSheetList() {
		System.out.println("Hello");
		ResponseEntity<Object> demo = null;
		try {
			RestTemplate res = new RestTemplate();
			demo = res.getForEntity(
					"https://sheets.googleapis.com/v4/spreadsheets/12xPYQO4zXBEecb_F115dG6jswplsLX48Cqe_2lCO0zs/values/demo123?key=AIzaSyBGi2QsBVggOvi7qHHLkEDPWTDfUGHqGTM",
					Object.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return demo;


	}

	@GetMapping("/webclient")
	public Mono<ResponseEntity<Object>> web() {
		ResponseEntity<Object> demo = null;

		Mono<ResponseEntity<Object>> d = WebClient.builder().build().get().uri(
						"https://sheets.googleapis.com/v4/spreadsheets/12xPYQO4zXBEecb_F115dG6jswplsLX48Cqe_2lCO0zs?key=AIzaSyBGi2QsBVggOvi7qHHLkEDPWTDfUGHqGTM")
				.retrieve().toEntity(Object.class);
		System.out.println(d);
		return d;
	}

	@GetMapping("/info")
	public ResponseEntity<Object> demo() {
		ResponseEntity<Object> demo = null;
		RestTemplate res = new RestTemplate();
		demo = res.getForEntity(
				"https://sheets.googleapis.com/v4/spreadsheets/12xPYQO4zXBEecb_F115dG6jswplsLX48Cqe_2lCO0zs?key=AIzaSyBGi2QsBVggOvi7qHHLkEDPWTDfUGHqGTM",
				Object.class);
		return demo;

	}

}
