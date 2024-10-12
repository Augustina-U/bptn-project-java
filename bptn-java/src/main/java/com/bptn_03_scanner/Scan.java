package com.bptn_03_scanner;

import java.util.Scanner;



	
		
		public class Scan {


			 
			 public static void main(String[] args) {
			  
			  Scanner scan = new Scanner(System.in);
			 
			  System.out.println("Please enter an String:");
			  String str = scan.nextLine();
			  
			  System.out.println("Please enter an Integer:");
			  int num = scan.nextInt(); // 7 <Enter>
			  //scan.nextLine(); // Clean Buffer. Removes <enter>
			  
			  System.out.println("Please enter an Integer:");
			  int num2 = scan.nextInt(); // 7 <Enter>
			  


			        System.out.println();  
			  
			  System.out.println("Num is: " + num);
			  System.out.println("Num2 is: " + num2);
			  System.out.println("Str is: " + str);
			  
			  scan.close();
			 }

		
		}
	

		
		
		
		
	
			
			

