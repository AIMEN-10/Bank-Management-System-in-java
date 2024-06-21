import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
public class Transaction {
	private static final String acc_no = null;
	public int amount;
	public double balance;
	//static Deposit d=new deposit(rate:4,)
	Readdata r = new Readdata();
	static Readpassword p = new Readpassword();
	Scanner input = new Scanner(System.in);
	private String type;
	double data0;
	public Transaction(String type2) {
		// System.out.println(type2);
		this.type = type2;
	}
	
	public void processTransaction(String type, User user) {
		Scanner input = new Scanner(System.in);

		if (type.compareToIgnoreCase("desposit") == 0) {
			System.out.println("Enter Amount to Desposit: ");
			double depo = input.nextDouble();
			user.setBalance(user.getBalance() + depo);
			System.out.println("Amount Deposited Sucessfully");
		} else {
			System.out.println("Enter Amount to Withdraw: ");
			double wt = input.nextDouble();
			if (wt > user.getBalance())
				System.out.println("You don't have " + wt + " in your account");
			else
				user.setBalance(user.getBalance() - wt);
		}
	}
	
	public void call(User user) {
		System.out.print("***********\nPress 1 to perform transaction\nPress 2 to check balance\nPress 3 to Exit");
		int choice;
		do {
			choice = input.nextInt();
			if (choice == 1) {
				System.out.print("***********\nPress 1 for Withdraw\nPress 2 for Deposit\nPress 3 for Exit");
				int choice2;
				do {
					choice2 = input.nextInt();
					if (choice2 == 1) {
						System.out.println("Enter amount u want to withdraw ");
						amount = input.nextInt();

						if (amount > user.getBalance())
							System.out.println("You don't have " + amount + " in your account");
						else {
							user.setBalance(user.getBalance() - amount);
							System.out.println("Amount Withdrawn");
							
						
							
						}	
						break;
					} 
					else if (choice2 == 2) {
						System.out.println("Enter amount u want to deposit ");
						amount = input.nextInt();						
						user.setBalance(amount + user.getBalance());
						 data0=amount + user.getBalance();
						System.out.println("new Amount: " + user.getBalance());
						System.out.println("Account Deposited Sucessfuly");
						break;
					}
					else if (choice2 == 3) {
						System.out.println("Successfully Exit: ");
					}
				} while(choice2 != 0);
				break;
			}
		
			else if (choice == 2) 
			{
				System.out.println("Your account balance is:" + user.getBalance());
			}
			else if (choice == 3) 
			{
				System.out.println("Successfully Exit: ");
			}
			
			
			
		}
		while(choice != 0);
		
		Writedata wd = new Writedata();
		wd.WriteDataAfterTrans(user);
	}
}
	
