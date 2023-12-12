package com.twilio;

import com.twilio.*;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import java.util.Scanner;
import com.twilio.type.PhoneNumber;

public class Emergency {

	public static final String ACCOUNT_SID = "AC64688cc08515afe8149a9ef22b2e9987";
	public static final String AUTH_TOKEN = "1b93d233513114887f05dd46eb332d88";
	public static String text = null;
	
	public static void main(String[] args) {

		Scanner myInput =  new Scanner(System.in);
		System.out.println("Are you in immediate danger, or do you need to text 911? (Please enter Yes or No.)");
		String danger = myInput.nextLine();
		while(!danger.equals("Yes") && (!danger.equals("No"))) {
			System.out.println("Please try again. Invalid Input!");
			danger = myInput.nextLine();
		}
		if (danger.equals("Yes")) {
			// For this example I have the number set as my personal number as to avoid
			// accidental calls or text messages to 911
			// For the emergency contact my personal number is also set because Twilio only accepts verified phone numbers
			System.out.println("Please enter information regarding your predicament.");
			text = myInput.nextLine();
			System.out.print("Emergency services has been contacted!");
		}
		if (danger.equals("No")) {
			System.out.println("Do you wish to text your emergency contact instead? (Type Yes or No)");
				String answer = myInput.nextLine();
				while(!answer.equals("Yes") && (!answer.equals("No"))) {
					System.out.println("Please try again. Invalid Input!");
					answer = myInput.nextLine();
				}
				if (answer.equals("No")) {
					System.out.print("The program will now terminate!");
					System.exit(0);
				}
				if(answer.equals("Yes"))
				System.out.println("Enter your message.");
				text = myInput.nextLine();
				System.out.print("Emergency contact has been messaged!");
		}
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		
		try {
		Message message = Message.creator(
			new PhoneNumber("+19127045843"),
			new PhoneNumber("+18445430701"),
			text
		).create();
		
		System.out.print(message.getSid());
		} catch(Exception a) {
			
		}
	
	}

}
