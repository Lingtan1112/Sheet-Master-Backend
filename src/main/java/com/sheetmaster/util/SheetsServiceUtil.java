package com.sheetmaster.util;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class SheetsServiceUtil {

	private static final String APPLICATION_NAME = "Google Sheets Example";

	public static Sheets getSheetsService() throws IOException, GeneralSecurityException {
		Credential credential = GoogleAuthorizeUtil.authorize();
		return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(),
				credential).setApplicationName(APPLICATION_NAME).build();

	}
	
	public static List<String> getPathParamtersFromUrl(String url) {
	    String[] path = url.split("\\?");
	    String[] pathparams = path[0].split("\\//");
	    String[] param = pathparams[1].split("\\/");
	    List<String> p = Arrays.asList(param);
	    return p.stream().filter(x -> !x.contains(".")).collect(Collectors.toList());
	}

}
