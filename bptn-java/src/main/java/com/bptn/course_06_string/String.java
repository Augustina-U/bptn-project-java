package com.bptn.course_06_string;


	
	// FREEZE CODE BEGIN
	import java.util.Scanner;

	public class String {
	    public static void main(String[] args) {      
	        // Create an object from scanner class
	        Scanner myObj= new Scanner(System.in);
	        
	        // Print a statement on the console
	        System.out.println("Enter you name , favourite city, age and salary");
	// FREEZE CODE END
	        // Get string input for name
	        java.lang.String name = "Augustina";
	            
	        // Get string input for fav city
	        java.lang.String favCity = "Paris";
	        
	        // Get numerical input for user's age
	        int age = 31;
	        
	        // Get numerical input for user's salary
	            double salary = 2000.0;
	// FREEZE CODE BEGIN     
	        // Output of all the inputs provided by the user
	        System.out.println("Name: "+ name);
	        System.out.println("Favourite city : "+ favCity);
	        System.out.println("Age : "+ age);
	        System.out.println("Salary : "+ salary);
	        
	        // Question for you: why is this here? Edit this comment to explain: what does it do and why?
	        myObj.close();
	    }
	}
	// FREEZE CODE END
	/*The comment 'myObj.close()' is there to close the Scanner object, preventing potential resource
	 leaks by releasing the input stream used by the program*/	
	
			
			
	
	
	

}
