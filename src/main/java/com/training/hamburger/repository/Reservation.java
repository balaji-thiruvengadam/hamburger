package com.training.hamburger.repository;
import java.util.Date;

import lombok.Data;

@Data
public class Reservation {
	private String fullName;
	private String contact;
	private String email;
	private Date dateOfBooking;
	private Date dateOfEvent;
	private String eventCategory;
	private String eventPackageSelected;
	private String status;
}
