package PasswordGenerator;

public class Characters {

	public final String lowerCase = "abcdefghijklmnopqrstuvwxyz";
	public final String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public final String splSym = "!@#$%^&*()-_=+\\/~?";
	public final String numbers = "1234567890";

	public StringBuilder str = new StringBuilder();

	public Characters(boolean inLowerCase, boolean inUpperCase, boolean inSplSym, boolean inNumbers) {
		if (inLowerCase) // If it is true then it will append alphabets into String Builder variable.
		{
			str.append(lowerCase);
		}
		if (inUpperCase) {
			str.append(upperCase);
		}

		if (inSplSym) {
			str.append(splSym);
		}
		if (inNumbers) {
			str.append(numbers);
		}
	}

	public String getCharacters() {

		return str.toString(); // toString  is used to convert StringBUilder into
								// String

	}

}
