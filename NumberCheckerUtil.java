package ticketbooking;

import java.util.ArrayList;
import java.util.Scanner;

public  class NumberCheckerUtil {
	
	static Scanner userInput = new Scanner(System.in);
//	static String number ;
	static ArrayList<Customer> customerList ;
	
	
	
	public static String getContactNumber(ArrayList<Customer> customerDetailList , boolean isDupCheckerNeeded) {
		customerList = customerDetailList ;
		System.out.print("Enter Contact Number :");
		String number = userInput.next();
		if(numberChecker(number , isDupCheckerNeeded)) {
			return number ;
		}
		return getContactNumber(customerList , isDupCheckerNeeded);
	}
	
	public static boolean numberChecker(String num , boolean isDupCheckerNeeded) {
		if (num.length() == 10 && (Character.getNumericValue(num.charAt(0))) < 10
				&& (Character.getNumericValue(num.charAt(0))) > 5 && duplicateChecker(num , isDupCheckerNeeded)) {

			return true;
		}
		System.out.println();
		System.out.println("OOPS! ,The Number You Entered Is InValid !");
		System.out.println();
		return false;
	}

	private static boolean duplicateChecker(String number, boolean isDuplicateCheckerNeeded) {
		if (isDuplicateCheckerNeeded) {
			for (Customer i : customerList) {
				if (i.getNumber().equals(number)) {
					System.out.println("(The Number You Entered Is Already Exist)");
					return false;
				}
			}
			return true;
		} else {
			return true;
		}

	}
}
