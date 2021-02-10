import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class fileAccess {
	
	private static Scanner sc;
	accountstatementfile acst=new accountstatementfile();
	String account_no="";
	String name="";
	String balance="";
	//String oldfile="/Users/manaslohani111rediffmail.com/Desktop/Manasaccount.txt";
	//String newfile="/Users/manaslohani111rediffmail.com/Desktop/tempFile.txt";
	
	String oldfile="src/Manasaccount.txt";
	String newfile="src/tempFile.txt";
		

	
	public boolean searchname(String searchtext)
	{
		try {
        sc=new Scanner(new File(oldfile));
        sc.useDelimiter("[,\n]");
        while(sc.hasNext())
        {
        	account_no=sc.next();
        	name=sc.next();
        	balance=sc.next();
        	
        	//System.out.println(account_no+","+name+","+balance);
        	
        	if(name.trim().toLowerCase().equals(searchtext.trim().toLowerCase()))
        	{
        		return false;
        	}
        }
		}
		catch(Exception e)
		{
			//System.out.println("Unable to search name");
		}
		return true;
		
	}
	
	public String getaccount_no()
	{
		try {
	        sc=new Scanner(new File(oldfile));
	        sc.useDelimiter("[,\n]");
	        
	        while(sc.hasNext())
	        {
	        	account_no=sc.next();
	        	name=sc.next();
	        	balance=sc.next();	
	        }
			}
			catch(Exception e)
			{
				//System.out.println("Unable to get Account Number");
			}
		int i=Integer.parseInt(account_no);
		String acc=Integer.toString(i);
		return acc;
		
	}
	
	public void Add(String acc,int am,String via)
	{
		String bal;
		try {
		File oldfile1=new File(oldfile);
		File newfile1=new File(newfile);
		
		FileWriter fw=new FileWriter(newfile,true);
		BufferedWriter bw=new BufferedWriter(fw);
		PrintWriter pw=new PrintWriter(bw);
		
		sc=new Scanner(new File(oldfile));
		sc.useDelimiter("[,\n]");
		try {
			
		while(sc.hasNext())
		{
			account_no=sc.next();
        	name=sc.next();
        	balance=sc.next();
        	if(account_no.trim().equals(acc.trim())){
        		int i=Integer.parseInt(balance);
        		i=i+am;
        		bal=Integer.toString(i);
        		pw.println(account_no+","+name+","+bal);
        		System.out.println("balance is "+bal+"\n");
        		String amount=Integer.toString(am);
        		acst.Editstatement("Cr",account_no,bal,amount,via);
        		System.out.println("\nTransaction Successful\n");
        	}
        	else
        	{
        		pw.println(account_no+","+name+","+balance);
        	}
		}
		}catch(Exception e)
		{
			//System.out.println();
		}
		
		
		sc.close();
		pw.flush();
		pw.close();
		oldfile1.delete();
		File dump=new File(oldfile);
		newfile1.renameTo(dump);
		}
		catch(Exception e)
		{
			System.out.println("Error in add file");
		}
		
		
		
		
	}
	
	public void Withdraw(String acc,int am,String via)
	{
		try {
		File oldfile1=new File(oldfile);
		File newfile1=new File(newfile);
		
		FileWriter fw=new FileWriter(newfile,true);
		BufferedWriter bw=new BufferedWriter(fw);
		PrintWriter pw=new PrintWriter(bw);
		
		sc=new Scanner(new File(oldfile));
		sc.useDelimiter("[,\n]");
		try {
			
		while(sc.hasNext())
		{
			account_no=sc.next();
        	name=sc.next();
        	balance=sc.next();
        	if(account_no.trim().equals(acc.trim())){
        		int i=Integer.parseInt(balance);
        		
        		if(i>=am) {
        			i=i-am;
        			String bal=Integer.toString(i);
            		pw.println(account_no+","+name+","+bal);
            		System.out.println("balance is "+bal+"\n");
            		String amount=Integer.toString(am);
            		acst.Editstatement("Dr",account_no,bal,amount,via);
        		}
        		else
        		{
        			System.out.println("Insufficient Balance");
        			break;
        		}
        	}
        	else
        	{
        		pw.println(account_no+","+name+","+balance);
        	}
		}
		}catch(Exception e)
		{
			//System.out.println();
		}
		
		
		sc.close();
		pw.flush();
		pw.close();
		oldfile1.delete();
		File dump=new File(oldfile);
		newfile1.renameTo(dump);
		}
		catch(Exception e)
		{
			System.out.println("Error in add file");
		}
		
		
	}
	
	public void check(String searchtext)
	{
		try {
        sc=new Scanner(new File(oldfile));
        sc.useDelimiter("[,\n]");
        while(sc.hasNext())
        {
        	account_no=sc.next();
        	name=sc.next();
        	balance=sc.next();
        	
        	//System.out.println(account_no+","+name+","+balance);
        	
        	if(account_no.trim().equals(searchtext.trim()))
        	{
        		System.out.println("Account Number:  | "+account_no+"\n   Name :        |"+name+"\nCurrent Balance: |"+balance);
        	}
        }
		}
		catch(Exception e)
		{
			//System.out.println("Unable to search name");
		}
		
		
	}
	
}
