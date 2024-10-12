package com.bptn.course_04_flow_control_01_white;

public class Whiteloop {

	public static void main(String[] args) {

		int cnt = 1;

		while (cnt < 10) {

			System.out.println(cnt);
			cnt++; // cnt = cnt + 1;
		}

		// do.. while
		/*
		 * with the do while, the block of code is executed at least one time because
		 * the condition is evaluated after the execution
		 */

		do {
			System.out.println(cnt);
			cnt++; // cnt = cnt + 1;
		} while (cnt < 10);
	}

}
