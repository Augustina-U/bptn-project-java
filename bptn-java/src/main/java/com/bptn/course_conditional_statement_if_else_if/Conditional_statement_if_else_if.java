package com.bptn.course_conditional_statement_if_else_if;

	import java.util.Scanner;

	public class Conditional_statement_if_else_if {
	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        System.out.println("\n\n You are on an island surrounded by water.\n There is a path to the woods to the north, the sea to the south, and a beach shack to the east. \n Which way do you want to go (n,e,s,w)?");
	        
	        String command = scan.nextLine();
	        if (command.equals("n")) {
	            System.out.println("You enter the forest and hear some rustling. \nThere may be tigers here or maybe it's just monkeys.");
	        
	        
	        // Add else-ifs for s, e, w, and an else for any other input. Be creative!
	        // for south
	    }   else if (command.equals("s")){
	            System.out.println("You are now at the sea!" );
	    
	        //for east
	        } else if (command.equals("e")){
	           System.out.println( "You are now entering the beach shack!");

	           //for west
	        } else if (command.equals("e")){
	           System.out.println( "You are now headed west!");
      
	           
	           
	           
	            } else {
	            System.out.println("End of adventure!"); 
	            }
	        scan.close();
	    }
	}
	
	
