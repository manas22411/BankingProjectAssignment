import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class accountstatementfile {

	private static Scanner sc;
	getterAndsetter getset=new getterAndsetter();
	String oldfile="src/account_statement.txt";
	
	//String oldfile="/Users/manaslohani111rediffmail.com/Desktop/account_statement.txt";
	
	public void Editstatement(String cr,String account_no,String bal,String am,String via)
	{
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now(); 
			
			FileWriter fw=new FileWriter(oldfile,true);
			fw.append(dtf.format(now));
			fw.append(",");
			fw.append(cr);
			fw.append(",");
			fw.append(account_no);
			fw.append(",");
			fw.append(am);
			fw.append(",");
			fw.append(bal);
			fw.append(",");
			fw.append(via);
			fw.append("\n");
			fw.close();
			
			System.out.println("Saved Successfully");
			}catch(Exception e)
			{
				System.out.println("Error While saving data Please Try Again");
			}
		
	}
}
