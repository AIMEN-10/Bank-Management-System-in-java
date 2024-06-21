import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Writedata {
	public  String account;
	public  String password;
	public  String id;
	
	
	Scanner sc=new Scanner(System.in);
	public void writedata() {
		System.out.println("Enter an id for account:");
		id=sc.next();
		//System.out.println("Enter your name :");
		
		System.out.println("Enter password for account:");
		password=sc.next();
		String s=id+";"+password;
		File file=new File("C:\\\\\\\\Users\\\\\\\\dell pc\\\\\\\\Desktop\\\\\\\\password.txt");
		try {
			FileWriter fwriter=new FileWriter(file,true);
					fwriter.write(s);
			fwriter.close();
		}
		catch(Exception ex) {ex.printStackTrace();}
	}
	
	public void writeData2(User[] users) {
		File file=new File("C:\\\\\\\\Users\\\\\\\\dell pc\\\\\\\\Desktop\\\\\\\\password.txt");
		try {
			FileWriter fw = new FileWriter(file);
			String data = "";
			for (User user: users) 
				data += user.toString() + "#";
			
			fw.write(data);
			fw.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void WriteDataAfterTrans(User _user) {
		try {
		  String filePath = "C:\\\\\\\\Users\\\\\\\\dell pc\\\\\\\\Desktop\\\\\\\\password.txt";
	      //Instantiating the Scanner class to read the file

          sc = new Scanner(new File(filePath));
	      //instantiating the StringBuffer class
	      StringBuffer buffer = new StringBuffer();
	      //Reading lines of the file and appending them to StringBuffer
	      while (sc.hasNextLine()) {
	         buffer.append(sc.nextLine()+"#");
	      }
	      String fileContents = buffer.toString();
	 //     System.out.println("Contents of the file: "+fileContents);
	      //closing the Scanner object
	      sc.close();
	      String oldLine = _user.account_no+":"+_user.password+":"+_user.title+":"+_user.PreviousBal;
	      String newLine =  _user.account_no+":"+_user.password+":"+_user.title+":"+_user.balance;
	      //Replacing the old line with new line
	     // System.out.println(oldLine);
	      System.out.println("New Balance is:"+_user.balance);
	     
	      fileContents = fileContents.replaceAll(oldLine, newLine);
	      //instantiating the FileWriter class
	      FileWriter writer = new FileWriter(filePath);
	      System.out.println("");
	//      System.out.println("new data: "+fileContents);
	      writer.append(fileContents);
	      writer.flush();
		}catch(Exception ex)
		{
			 ex.printStackTrace();		
		}
	}}
