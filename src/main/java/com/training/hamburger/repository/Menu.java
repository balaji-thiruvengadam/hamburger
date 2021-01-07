package com.training.hamburger.repository;
import lombok.Data;

@Data
public class Menu extends Category{
	private String item;
	private String price;
}
