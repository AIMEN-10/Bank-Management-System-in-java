
import java.io.File;
import java.util.Scanner;

public class MainClass {

	static Readdata r = new Readdata();
	static Readpassword p = new Readpassword();
	static Writedata w = new Writedata();
	//Transaction t;
	public static User[] users;

//static Transaction P=new Transaction();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Admin a =new Admin();
		// Account1 acnt=new Account1 ();

		int choice;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("***************BANK MANAGEMENT SYSTEM************");
			System.out.println("Press 1 for user\nPress 2 for admin");
			choice = sc.nextInt();
			int choice2 = 0 ;
			do {
				if (choice == 1) {
					System.out.println("Press 1 for Login\nPress 2 for Signup");

					 choice2 = sc.nextInt();
					if (choice2 == 1) {
						String username = r.getaccno();

						if (r.readFromFile(username)) {

							String password2 = p.getpasssword();

							if (p.readFromFile(password2, username, getUserFromID(username)) != "") {
								System.out.println("Congratulations successfully log in.");
								String data[] = p.readFromFile(password2, username, getUserFromID(username)).split(":");
								//System.out.println(p.readFromFile(password2, username, getUserFromID(username)));
								User testUser = new User(data[0], data[2], data[1], Double.parseDouble(data[3].trim()));
								insertUser(testUser);
								testUser.PreviousBal = testUser.getBalance();
								
								
								
								Transaction trans = new Transaction("NONE");
							
								trans.call(testUser);
								

							};
							


						}

						break;
					}

					else if (choice2 == 2) {
						System.out.println("2");
						// w.writedata();
						sc.nextLine();
						System.out.print("Enter Account No: ");
						String acc_no = sc.nextLine();
						System.out.print("Enter Title: ");
						String title = sc.nextLine();
						System.out.print("Enter Password: ");
						String password = sc.nextLine();
						
						User user = new User(acc_no, title, password, 0.0);
						Transaction trans = new Transaction("desposit");
						trans.processTransaction("desposit", user);
						
						System.out.println("Your Account has been successfully created");
						insertUser(user);
						w.writeData2(users);
					//	Transaction t = new Transaction("NONE");
						//t.processTransaction("desposit", user);
						break;

					} else {
						System.out.println("Invalid choice");
					//	break;

					}
				} else if (choice == 2) {
					System.out.println("Admin");
					a.adminpass();
				}
				// break;
				else {
					System.out.println("Invalid choice");
				}

			} while (choice2!= 0);
			

		} while (choice != 0);
		w.writeData2(users);
	}
	public static void insertUser(User user) {
		
		if (users == null) {
			users = new User[] { user };
		} else {
			User[] temp = new User[users.length];
			for (int i = 0; i < users.length; i++)
				temp[i] = users[i];
			try {
			temp[users.length-1] = user;
			users = temp;}catch(Exception e) {e.printStackTrace();}
		}
	}
	public static User getUserFromID(String id) {
		Boolean found = false;
		if (users != null) {
			for (User user: users) {
				if (user.getID().compareToIgnoreCase(id) == 0) {
					found = true;
					System.out.println(user.toString());
					return user;
				}
			}
			System.out.println("HERE");
		}else {
			//System.out.println("NOT EXISTS");
		}
		return null;
	}
	

}
