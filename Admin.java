import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Admin {
	private static final User User = null;
	private String id;
	private String name;
	private String password;
	public int amount;
	String acc_no;

	public static Readdata r = new Readdata();
	public static Readpassword p = new Readpassword();
	public static Writedata w = new Writedata();
	public static User[] users;
	Scanner input = new Scanner(System.in);

	public Admin() {

	}

	public Admin(String id, String name, String password) {

		this.id = id;
		this.name = name;
		this.password = password;
	}

	private static String adminpass = null;
	String data;
	File re_file;

	public void adminpass() {
		System.out.println("Enter id:");
		id = input.next();
		System.out.println("Enter password:");
		password = input.next();

		Boolean found = false;
		File file = new File("C:\\Users\\dell pc\\Desktop\\login.txt");

		Scanner reader;
		try {

			reader = new Scanner(file);
			re_file = file;
			while (reader.hasNextLine()) {
				int i = 0;
				String data = reader.nextLine();
				
				String data1[] = data.split("#");

				for (; i < data1.length; i++) {
					String arr[] = data1[i].split(":");
					String id2 = arr[0], password2 = arr[1];

					if (id.compareToIgnoreCase(id2) == 0) {
						if (password.compareToIgnoreCase(password2) == 0) {
							found = true;
							System.out.println("Successfully logged in");

							System.out.println(
									"**************************\nPress 1 to add account\nPress 2 to show a user using id\nPress 3 for Exit");

							int choice = input.nextInt();
							switch (choice) {
							case 1: {
								System.out.println("Enter account no:");
								acc_no = input.next();
								System.out.println("Enter password:");
								password = input.next();
								insertUser(User);
								File file1 = new File("C:\\\\Users\\\\dell pc\\\\Desktop\\\\password.txt");
								Scanner sc;
								try {
									sc = new Scanner(file1);
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								while (input.nextLine() != null)
									;
								System.out.println(input.nextLine() != null);
							}
								break;
							case 2: {


								show_using_acc_no();
							}
								break;
							
							case 3: {
								System.out.println("You Exit Successfully:");
							}
								break;
							}
							while (choice != 0)
								;
						}
						// return false;
					}
				}

			}
			if (!found) {
				System.out.println("Not found.Please enter the right one");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void show_using_acc_no() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your account no to be searched:");
		acc_no = input.nextLine();

		boolean Found = false;
	

		if (r.readFromFile(acc_no)) {
			System.out.println("Enter passsword of the account  to be searched:");
			password = input.nextLine();

			if (p.readFromFile(password, acc_no, getUserFromID(acc_no)) != "") {
				String data[] = p.readFromFile(password, acc_no, getUserFromID(acc_no)).split(":");
				System.out.println("Account ID: " + data[0]);
				System.out.println("Password: " + data[1]);
				System.out.println("Title: " + data[2]);
				System.out.println("Balance: " + data[3]);
			}

		} else {
			System.out.println("WHY?");
		}

		Found = true;

		if (!Found) {
			System.out.println("Not found");
		}
	}

	public static void insertUser(User user) {
		if (users == null) {
			users = new User[] { user };
		} else {
			User[] temp = new User[users.length];
			for (int i = 0; i < users.length; i++)
				temp[i] = users[i];

			temp[users.length] = user;
			users = temp;
		}
		System.out.println("Your Account has been successfully created");
		insertUser(user); 
		w.writeData2(users);
	}

	public static User getUserFromID(String id) {
		Boolean found = false;
		if (users != null) {
			for (User user : users) {
				if (user.getID().compareToIgnoreCase(id) == 0) {
					found = true;
					System.out.println(user.toString());
					return user;
				}
			}
		}
		return null;
	}

	public void delete() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter account no of the account to be deleted:");
		acc_no = input.nextLine();
		System.out.println("Enter password no of the account to be deleted:");
		password = input.nextLine();
		boolean Found = false;
		// String s=data1;
		{
			String username = r.getaccno();

			if (r.readFromFile(username))
				;
			{
				String password2 = p.getpasssword();

				if (p.readFromFile2(password2, username, getUserFromID(username))) {

					System.out.println(data);
				}
				;
			}

		}

	}
}
