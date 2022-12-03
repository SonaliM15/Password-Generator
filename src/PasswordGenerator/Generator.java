package PasswordGenerator;

import java.util.Scanner;

public class Generator {
	
	Characters character;
	
	public Generator(boolean inLowerCase, boolean inUpperCase, boolean inSplSym, boolean inNumbers) {
		character = new Characters(inLowerCase, inUpperCase, inSplSym, inNumbers); 
	}
	
	public String passwordGenerator(int length) {
		
		StringBuilder pass = new StringBuilder("");
		int len = character.getCharacters().length();
		
		
		for(int i = 1; i <= length; i++ )
		{
			pass.append(character.getCharacters().charAt((int)(Math.random()*len)));
		}
		
		return pass.toString();
	}

	public static void passwordRequest() {
		boolean inLowerCase = false;
		boolean inUpperCase = false;
		boolean inNumbers = false;
		boolean inSplSym = false;
		String input;
		int len;
		Scanner obj = new Scanner(System.in);
		System.out.println("Let's get started with your password generation, answer below question by YES or NO");
		while (true) {
			System.out.println("Would you like to have lower case \"a,b,c,....\" letters in your password?");
			input = obj.nextLine();
			if (input.equals("Yes") || input.equals("YES") || input.equals("yes")) {
				inLowerCase = true;
			} else if (input.equals("No") || input.equals("NO") || input.equals("no")) {
				inLowerCase = false;
			} else {
				System.out.println("Seems input entered is wrong, let's start again.");
				break;
			}

			System.out.println("Would you like to have upper case \"A,B,C,....\" letters in your password?");
			input = obj.nextLine();
			if (input.equals("Yes") || input.equals("YES") || input.equals("yes")) {
				inUpperCase = true;
			} else if (input.equals("No") || input.equals("NO") || input.equals("no")) {
				inUpperCase = false;
			} else {
				System.out.println("Seems input entered is wrong, let's start again.");
				break;
			}

			System.out.println("Would you like to have numbers \"1,2,3,....\" in your password?");
			input = obj.nextLine();
			if (input.equals("Yes") || input.equals("YES") || input.equals("yes")) {
				inNumbers = true;
			} else if (input.equals("No") || input.equals("NO") || input.equals("no")) {
				inNumbers = false;
			} else {
				System.out.println("Seems input entered is wrong, let's start again.");
				break;
			}

			System.out.println("Would you like to have special symbols \"!,@,$,....\" in your password?");
			input = obj.nextLine();
			if (input.equals("Yes") || input.equals("YES") || input.equals("yes")) {
				inSplSym = true;
			} else if (input.equals("No") || input.equals("NO") || input.equals("no")) {
				inSplSym = false;
			} else {
				System.out.println("Seems input entered is wrong, let's start again.");
				break;
			}

			if (!inLowerCase && !inUpperCase && !inSplSym && !inNumbers) {
				System.out.println(
						"You have not selected any character, to generate password atleast one character needs to be selected");
				break;
			}

			System.out.println("Greate now select the length of password");
			len = obj.nextInt();
			
			Generator generator = new Generator(inLowerCase, inUpperCase, inSplSym, inNumbers);
			
			String userPass= generator.passwordGenerator(len);
			System.out.println(userPass);
			break;

		}

	}
	
	
	public static void checkPassword() {
		
		String userPass;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a password to check it's strenght");
		userPass= sc.nextLine();
		PasswordStrength p = new PasswordStrength(userPass);
		p.calculatedStrenght();
				
	}
	

	public static void mainMenu() // In order to call function in static block we are
									// defining it as static.
									// Orelse we can call it through class object as well.
	{

		System.out.println();
		System.out.println("Enter 1 - Password Generator");
		System.out.println("Enter 2 - Password Stength Check");
		System.out.println("Enter 3 - Quit");
		
		System.out.println("Enter your choice:");
	}

	public static void main(String arg[]) {
		int choice = 0;
		Scanner obj = new Scanner(System.in);
		while (choice != 3) {
			mainMenu();
			choice = obj.nextInt();
			switch (choice) {
			case 1:
				passwordRequest();
				break;
			case 2:
				checkPassword();
				break;
			case 3:
				System.out.println("Thank you for using password generator");
				choice = 3;
				break;
			default:
				System.out.println("Invalid input");
				break;
			}

		}
	}
}
