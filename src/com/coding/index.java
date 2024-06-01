package com.coding;

import java.util.Scanner;

public class index {

	public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
		while(true) {
			System.out.println("||*Welcome to Employee Management System**||");
			System.out.println("     |*****1.Manager REGISTER******|");
			System.out.println("     |*****2.Manager LOGIN*********|");
			System.out.println("     |*****3.View All Managers*****|");
			System.out.println("     |*****4.Staff LOGIN***********|");
	        System.out.println("     |*****5.Exit******************|");
	        System.out.println("            Enter Your choice :");
	        int choice =sc.nextInt();
	        switch(choice) {
	        case 1 :
	        		Manager.AddManager("Manager");        	
	        	break;
	        case 2 :
	        	Manager.ManagerLogin("Manager");
	        	break;
	        case 3 :
	        	Manager.ViewAllManager("Manager");
	        	break;
	        case 4 :
	          
	        case 5 :
	        	System.out.println("Think for you!!");
	        	System.exit(0);
	        	default :
	        		System.out.println("Invaild deatils !!!");
	        }
		}
		

	}

}
