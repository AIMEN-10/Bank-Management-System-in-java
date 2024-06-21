
public class User {
	public String account_no;
	public String title;
	public String password;
	public double balance;
	public double PreviousBal ;	
	
	public User(String account_no, String title, String passowrd, double balance) {
		this.account_no = account_no;
		this.title = title;
		this.password = passowrd;
		this.balance = balance;
	}
	

	public String getPassword() {
		return password;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double d) {
		this.balance = d;
	}
	public String toString() {
		return account_no + ":" + password + ":" + title + ":" + balance;
	}
	
	public String getID() {
		return account_no;
	}

}
