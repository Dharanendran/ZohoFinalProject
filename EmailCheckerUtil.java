package ticketbooking;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EmailCheckerUtil 
{ 
	static Scanner userInput = new Scanner(System.in);
	
	public static String getMailId(ArrayList<Customer> customerList , boolean isDuplicateCheckerNeeded)
	{
		System.out.print("Enter Mail Id        :");
		String mailId = userInput.next();
		if(emailChecker(mailId) && duplicateChecker(customerList , mailId , isDuplicateCheckerNeeded)){
			return mailId;
		}
		System.out.println("OOPS! Entered Mail Id Is Invalid ");
		return getMailId(customerList , isDuplicateCheckerNeeded);
	} 
	
	
    public static boolean emailChecker(String email) 
    { 
    	 if (email == null) 
             return false;
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +  
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"; 
        Pattern pat = Pattern.compile(emailRegex); 
        return pat.matcher(email).matches(); 
    }
    
	private static boolean duplicateChecker(ArrayList<Customer> customerList, String mailId, boolean isNeeded) {
		if (isNeeded) {
			for (Customer i : customerList) {
				if (i.getMailId().equals(mailId)) {
					System.out.println("(THE MAIL ID YOU ENTERED IS ALREADY EXIST)");
					return false;
				}
			}
		} 
		return true;
	}


}
//public class EmailCheckerUtil {
//	public static boolean emailChecker(String mail_id) {
//
//		if (mail_id.length() >= 11 && mail_id.contains("@") && mail_id.contains(".") && comchecker(mail_id)
//				&& gmailChecker(mail_id)) {
//			return true;
//		}
//		return false;
//	}
//
//	public static boolean gmailChecker(String mail_id) {
//
//		for (int i = 0; i < mail_id.length(); i++) {
//			if (mail_id.charAt(i) == '@' && mail_id.length() - (i + 1) == 9) {
//				if (mail_id.charAt(i + 6) == '.') {
//					return true;
//				}
//
//			}
//		}
//
//		return false;
//	}
//
//	public static boolean comchecker(String mail_id) {
//		int letterCount = 0;
//		for (int i = mail_id.length() - 1; i > -1; i--) {
//			if (mail_id.charAt(i) == '.') {
//				break;
//			}
//			letterCount++;
//
//		}
//
//		if (letterCount == 3) {
//
//			return true;
//		}
//
//		return false;
//	}
//
//}
