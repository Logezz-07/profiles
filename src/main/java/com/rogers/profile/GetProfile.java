package com.rogers.profile;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestHeader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GetProfile {

	@GetMapping("/timeout")
	public ResponseEntity<Map<String, Object>> timeoutTest(@RequestHeader(value = "time", required = false) String timeHeader) {
		Map<String, Object> response = new HashMap<>();
		System.out.println("Received time header as date: " +timeHeader);
		try {
                    Thread.sleep(15000);
                    response.put("statusCode", 500);
                    response.put("statusMessage", "Simulated error");
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			response.put("statusCode", 500);
			response.put("statusMessage", "Interrupted");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}
}
		
