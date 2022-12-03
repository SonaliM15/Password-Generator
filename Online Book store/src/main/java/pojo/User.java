package pojo;

public class User {

	private int userId;
	private String firstName;
	private String lastName;
	private String userEmail;
	private long userMobile;
	private String userPassword;
	private String userRole;
	private String userAddress;
	private String userQuestion;
	private String userAnswer;

	public int getUserId() {
		return userId;
	}

	public String getUserQuestion() {
		return userQuestion;
	}

	public void setUserQuestion(String userQuestion) {
		this.userQuestion = userQuestion;
	}

	public String getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}

	public User(String userEmail) {
		
		this.userEmail = userEmail;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public long getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(long userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public User() {

	}

	public User(int userId, String firstName, String lastName, String userEmail, long userMobile, String userPassword,
			String userRole, String userAddress, String userQUestion, String userAnswer) {

		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userEmail = userEmail;
		this.userMobile = userMobile;
		this.userPassword = userPassword;
		this.userRole = userRole;
		this.userAddress = userAddress;
		this.userQuestion = userQUestion;
		this.userAnswer = userAnswer;
	}

	public User(String firstName, String lastName, String userEmail, long userMobile, String userPassword,
			String userRole, String userAddress, String userQUestion, String userAnswer) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.userEmail = userEmail;
		this.userMobile = userMobile;
		this.userPassword = userPassword;
		this.userRole = userRole;
		this.userAddress = userAddress;
		this.userQuestion = userQUestion;
		this.userAnswer = userAnswer;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", userEmail="
				+ userEmail + ", userMobile=" + userMobile + ", userPassword=" + userPassword + ", userRole=" + userRole
				+ ", userAddress=" + userAddress + ", userQuestion=" + userQuestion + ", userAnswer=" + userAnswer
				+ "]";
	}

}
