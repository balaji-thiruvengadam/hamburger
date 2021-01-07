package com.training.hamburger;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.training.hamburger.repository.Location;
import com.training.hamburger.repository.Menu;
import com.training.hamburger.service.AdminOperation;

public class App {
	
	public static final Logger logger = LogManager.getLogger(App.class.getName());
	
	public static void main(String[] args) {

		while (true) {
			System.out.println("\n------------------HAMBURGER ADMIN PANEL------------------\n");
			System.out.println("1.Location 2.Menu 3.Party Reservations 4.Exit \n");
			int choice = 0;
			Scanner scanner = new Scanner(System.in);
			try {
				choice = scanner.nextInt();
				if (choice >= 5 || choice <= 0) {
					break;
				}
			} catch (InputMismatchException ex) {
				logger.error("Wrong input {}",ex.getMessage());
				System.out.println("Incorrect Input\n");
				break;
			}

			switch (choice) {
			case 1:
				AdminOperation<Location> locationOperation = new AdminOperation<>();
				Location location = new Location();
				while (true) {
					int option = 0;
					System.out.println("\n1. create a new location 2. update a location 3. delete a location 4. Show all locations 5. Exit\n");
					try {
						option = scanner.nextInt();
						if (option >= 5) {
							break;
						}
					} catch (InputMismatchException ex) {
						logger.error("Wrong input {}",ex.getMessage());
						System.out.println("Incorrect Input\n");
						break;
					}
					
					switch (option) {
					case 1:
						System.out.println("Enter the following details with comma separated: Name,Latitude,Logitute,address,phone \n");
						String locationDetails = scanner.next();
						try {
							String[] values = locationDetails.split(",");
							location.setName(values[0]);
							location.setLatitude(values[1]);
							location.setLongitude(values[2]);
							location.setAddress(values[3]);
							location.setPhone(values[4]);
							locationOperation.create(location);
							System.out.println("Location is successfully added \n");
						} catch (IOException e) {
							System.out.println("Failed to add the Location, Pls retry\n");
							logger.error("Failed to add Location {}",location);
							e.printStackTrace();
						}
						break;
					case 2:
						locationOperation.update(location);
						break;

					case 3:
						locationOperation.delete(location);
						break;

					case 4:
						locationOperation.list();
						break;
			
					default:
						logger.info("Enter the correct choice");
						break;
					}
				}
				break;
			case 2:
				AdminOperation<Menu> menuOperation = new AdminOperation<>();
				Menu menu = new Menu();
				while(true) {
					int option = 0;
					System.out.println("\n1. create a new Menu 2. update a Menu 3. delete a Menu 4. Show all Menus 5. Exit\n");
					try {
						option = scanner.nextInt();
						if (option >= 5) {
							break;
						}
					} catch (InputMismatchException ex) {
						logger.error("Wrong input {}",ex.getMessage());
						System.out.println("Incorrect Input\n");
						break;
					}
					
					switch (option) {
					case 1:
						System.out.println("Enter the following details with comma separated: Category,Item,Price \n");
						String menuDetails = scanner.next();
						try {
							String[] values = menuDetails.split(",");
							menu.setCategory(values[0]);
							menu.setItem(values[1]);
							menu.setPrice(values[2]);
							menuOperation.create(menu);
							System.out.println(menu.toString());
							System.out.println("Item is successfully added to the menu\n");
						} catch (IOException e) {
							System.out.println("Failed to add the item, Pls retry\n");
							logger.error("Failed to add item {}",menu);
						}
						break;
					case 2:
						menuOperation.update(menu);
						break;

					case 3:
						menuOperation.delete(menu);
						break;

					case 4:
						menuOperation.list();
						break;
			
					default:
						logger.info("Enter the correct choice");
						break;
					}
				}
				break;
			case 4:
				System.out.println("\n------------------CLOSING THE ADMIN PANEL------------------\n");
				System.out.flush(); 
				break;
			default:
				System.out.println("Enter correct choice");
				break;
			}
			if (choice == 4) {
				scanner.close();
				System.exit(0);
			}
		}
	}
}
