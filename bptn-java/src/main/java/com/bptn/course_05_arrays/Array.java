package com.bptn.course_05_arrays;

import java.util.Arrays;

public class Array {
	
				
public static void main(String[] args) {

	
		  int i0 = 4;
		  int i1 = 5;
		  int i2 = 7;
		  int i3 = 2;
		  int i4 = 19;
		  int i5 = 14;
		  int i6 = 35;
		  int i7 = 46;
		  int i8 = 71;
		  int i9 = 28;
		  
		  // 1. Declare and initialize the array (hard-coded values)
		  int[] nums = { 4, 5, 7, 2, 19, 14, 35, 46, 71, 28, 45, 23 };
		  //             0  1  2  3   4   5   6   7   8   9  10  11  
		  
		  nums[4] = 100;
		  
		  // 2. Declare and allocate memory for the array
		  int[] nums2 = new int[1000000];
		  
		  
		  System.out.println( Arrays.toString(nums) );
		  System.out.println( nums.length );
		  
		  // Traditional for loop / C for-loop
		  for (int i = 0; i < nums.length; i++) {
		   System.out.println( nums[i] );
		  }
		  
		  // for-each / Enhanced for-loop / As of Java 5
		  for (int num : nums) {
		   System.out.println( num );
		  }
		  
		  String[] strs = {"Hello", "I", "love", "Java" };
		  System.out.println( Arrays.toString(strs) );
		  
		  for (String str : strs) {
		   System.out.println(str);
		  }
		 }


		}