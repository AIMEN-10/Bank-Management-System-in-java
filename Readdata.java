import java.io.File;

import java.util.Scanner;

public class Readdata {
    private static String accno = null;
  
    String data;
    File re_file;
    String acc_no;
    public static Scanner input = new Scanner(System.in);
    public Boolean readFromFile(String acc2) 
    {
        Boolean found = false;
        File file = new File("C:\\\\Users\\\\dell pc\\\\Desktop\\\\password.txt");
       
        Scanner reader;
        try {

            reader = new Scanner(file);
            re_file = file;
            while (reader.hasNextLine()) {
                int i = 0;
                String data = reader.nextLine();
                //System.out.print(data);
                String data1[] = data.split(":");
              

                for (; i < data1.length; i++) 
                {
                   
                    if (data1[i].compareToIgnoreCase(acc2) == 0) 
                    {
                    	found = true;
                    	break;
                    }
                }
 
            }

           
            if (!found) 
            {
                System.out.println("Not found");
            }


            } catch (Exception e) {
            e.printStackTrace();
        }
           return found;
    }

    public String getaccno() 
    {
        System.out.print("Enter account no");
        acc_no = input.next();
        return acc_no;
    }
}