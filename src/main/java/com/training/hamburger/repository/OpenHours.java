package com.training.hamburger.repository;
import lombok.Data;

@Data
public class OpenHours {
	private String day;
	private String openTime;
	private String closeTime;
}
