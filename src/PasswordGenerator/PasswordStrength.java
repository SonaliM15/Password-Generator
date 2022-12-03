package PasswordGenerator;

public class PasswordStrength {

	String userPass;
	int len;

	public PasswordStrength(String str) {
		userPass = str;
	}

	public int charType(char c) {
		char chr = c;
		int code = chr;
		int type = 0;
		if (code >= 97 && code <= 112) {
			type = 1;
		} else if (code >= 65 && code <= 90) {
			type = 2;
		} else if (code >= 48 && code <= 57) {
			type = 3;
		} else {
			type = 4;
		}

		return type;

	}

	public int checkStrength() {
		String pass = this.userPass;
		boolean usedLowerCase = false;
		boolean usedUpperCase = false;
		boolean usedSplSym = false;
		boolean usedNumber = false;
		int counter = 0;

		for (int i = 0; i < pass.length(); i++) {
			char ch = pass.charAt(i);
			int type = charType(ch);
			if (type == 1) {
				usedLowerCase = true;
			}
			if (type == 2) {
				usedUpperCase = true;
			}
			if (type == 3) {
				usedNumber = true;
			}
			if (type == 4) {
				usedSplSym = true;
			}
		}

		if (usedLowerCase) {
			counter += 1;
		}
		if (usedUpperCase) {
			counter += 1;
		}
		if (usedSplSym) {
			counter += 1;
		}
		if (usedNumber) {
			counter += 1;
		}
		if (pass.length() >= 8) {
			counter += 1;
		}
		if (pass.length() >= 15) {
			counter += 1;
		}

		return counter;

	}

	public void calculatedStrenght() {

		int score = this.checkStrength();

		if (score == 6) {
			System.out.println("Password strength is excellent");
		} else if (score < 6 && score >= 4) {
			System.out.println("password strength is good");
		}

		else if (score < 4 && score >= 2) {
			System.out.println("Password strength is medium");
		} else {
			System.out.println("Password is too weak");
		}
	}

}
