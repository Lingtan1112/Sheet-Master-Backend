package com.sheetmaster.bussiness;

import java.util.List;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.sheetmaster.util.SheetsServiceUtil;

import reactor.core.publisher.Mono;

@Service
public class SheetBussiness {

	@Value("${spring.sheet.apikey}")
	String apiKey;
	
	@Value("${spring.sheet.baseurl}")
	String baseUrl;
	

	public Mono<ResponseEntity<Object>> getSheetInfo(String sheetUrl) {
		List<String> params = SheetsServiceUtil.getPathParamtersFromUrl(sheetUrl);
		String sheetId = params.get(2);
	    String requestUrl = baseUrl.concat(sheetId).concat("?key=").concat(apiKey);
	    System.out.println(requestUrl);
		Mono<ResponseEntity<Object>> sheetInfo = WebClient.builder().build().get().uri(requestUrl).retrieve().toEntity(Object.class);	
		return sheetInfo;
	}
	
	
}
