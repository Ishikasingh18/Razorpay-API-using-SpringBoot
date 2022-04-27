package com.Bank.IFSC.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.Bank.IFSC.model.*;
import com.google.gson.Gson;

public class Service {

	public Bank getBankDetailAPi(String ifsc) {
		try {
			String api = "https://ifsc.razorpay.com/" + ifsc;
			URL url = new URL(api);
			HttpURLConnection hr = (HttpURLConnection) url.openConnection();
			InputStream inputStream = hr.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			String line = br.readLine();
			
			StringBuffer sb = new StringBuffer();
			while (line != null) {
				sb.append(line).append("\n");
				line = br.readLine();
			}
			System.out.println(sb.toString());
			return new Gson().fromJson(sb.toString(), Bank.class);

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
}
