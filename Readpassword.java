import java.io.File;
import java.util.Scanner;

public class Readpassword {
	private static String password1 = null;

	String data;
	File re_file;
	String password;
	public static Scanner input = new Scanner(System.in);

	public String getpasssword() {
		System.out.print("Enter password");
		password = input.next();
		return password;
	}

	public String readFromFile1() {
		// Boolean found = false;
		File file = new File("C:\\\\Users\\\\dell pc\\\\Desktop\\\\password.txt");
		if (!file.exists()) {
			System.out.println("NO FILE!");
			return null;
		}
		Scanner reader;
		try {

			reader = new Scanner(file);
			re_file = file;
			while (reader.hasNextLine()) {
				int i = 0;
				String data = reader.nextLine();

				// System.out.print(data);
				String data1[] = data.split("#");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
		// return found;
	}
	
	public Boolean readFromFile2(String real_password, String real_acc_no, User user) {
		Boolean found = false;
		File file = new File("C:\\\\Users\\\\dell pc\\\\Desktop\\\\password.txt");
		String u_data = "";
		Scanner reader;
		try {

			reader = new Scanner(file);
			re_file = file;
			while (reader.hasNextLine()) {
				int i = 0;
				String data = reader.nextLine();
				//System.out.println(data);
				// System.out.print(data);
				String data1[] = data.split("#");

				for (; i < data1.length; i++) {
					String arr[] = data1[i].split(":");
					String acc_no = arr[0], password = arr[1];

					if (acc_no.compareToIgnoreCase(real_acc_no) == 0) {
						if (password.compareToIgnoreCase(real_password) == 0) {
							//u_data = data1[i];
							found = true;
							break;
						}
					}
				}

			}

			if (!found) {
				System.out.println("Not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return found;
	}

	public String readFromFile(String real_password, String real_acc_no, User user) {
		Boolean found = false;
		File file = new File("C:\\\\Users\\\\dell pc\\\\Desktop\\\\password.txt");
		String u_data = "";
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
					String acc_no = arr[0], password = arr[1];

					if (acc_no.compareToIgnoreCase(real_acc_no) == 0) {
						if (password.compareToIgnoreCase(real_password) == 0) {
							u_data = data1[i];
							found = true;
							break;
						}
					}
				}

			}

			if (!found) {
				System.out.println("Not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return u_data;
	}}

