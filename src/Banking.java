import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;


public class Banking {
	
	public void savedata(String account_no,String name,String balance)
	{
		try {
				
		//FileWriter f=new FileWriter("/Users/manaslohani111rediffmail.com/Desktop/Manasaccount.txt",true);
		FileWriter fw=new FileWriter("src/Manasaccount.txt",true);
		fw.append(account_no);
		fw.append(",");
		fw.append(name);
		fw.append(",");
		fw.append("0");
		fw.append("\n");
		fw.close();
		
		System.out.println("Saved Successfully");
		}catch(Exception e)
		{
			System.out.println("Error While saving data Please Try Again");
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Banking mainobj=new Banking();
		System.out.println("WELCOME TO BANK \nHOW CAN I HELP YOU\n");
		getterAndsetter getset=new getterAndsetter();
		fileAccess obj=new fileAccess();
		Scanner sc=new Scanner(System.in);
		boolean v=true;
		while(v)
		{
		try {	
		System.out.println("Press 1 - Create a NEW ACCOUNT");
		System.out.println("Press 2 - ADD MONEY");
		System.out.println("Press 3 - WITHDRAW MONEY");
		System.out.println("Press 4 - CHECK BALANCE");
		System.out.println("Press ANY other Key To Exit");
		int i=sc.nextInt();
		switch(i)
		{
		case 1:
			
			System.out.println("Enter Your Name");
			String name=sc.next();
			boolean r=obj.searchname(name);
			if(r==true)
			{
				String acc=obj.getaccount_no();
				int acc1=Integer.parseInt(acc);
				acc1=acc1+1;
				String account_no=Integer.toString(acc1);
				getset.setAccount_no(account_no);
				getset.setName(name);
				getset.setBalance("0");
				
				//System.out.println(account_no);
				
				mainobj.savedata(getset.getAccount_no(),getset.getName(),getset.getBalance());
				continue;
				
			}
			else
			{
				System.out.println("Already Register Sorry");
				continue;
			}
		case 2:
			System.out.println("Mode Of Transcation :- \n 1- via Cash \n 2- via Online\n 3 <-Back");
			int add=sc.nextInt();
			switch(add) {
			case 1:
				System.out.println("Enter your Account Number\n");
				String acc=sc.next();
				System.out.println("Enter Ammount\n");
			    int am=sc.nextInt();  
			    obj.Add(acc,am,"cash");
			       
			case 2:
				System.out.println("Enter your Account Number\n");
				String acc1=sc.next();
				System.out.println("Enter Ammount\n");
			    int am1=sc.nextInt();  
			    obj.Add(acc1,am1,"online");
			default:
				System.out.println("\n");
				continue;
				
			}
			
		case 3:
			System.out.println("Mode Of Withdraw :- \n 1- Cash \n 2- Online\n 3- ATM\n");
			int withd=sc.nextInt();
			switch(withd)
			{
			case 1:
				System.out.println("Enter your Account Number\n");
				String acc=sc.next();
				System.out.println("Enter Ammount\n");
			    int am=sc.nextInt();  
			    obj.Withdraw(acc,am,"cash");
				
			case 2:
				System.out.println("Enter your Account Number\n");
				String acc1=sc.next();
				System.out.println("Enter Ammount\n");
			    int am1=sc.nextInt();  
			    obj.Withdraw(acc1,am1,"online");
				
			case 3:
				System.out.println("Enter your Account Number\n");
				String acc2=sc.next();
				System.out.println("Enter Ammount\n");
			    int am2=sc.nextInt();  
			    obj.Withdraw(acc2,am2,"atm");
				
			default:
				System.out.println("\n");
				continue;
			}
			
		case 4:
			System.out.println("Enter your Account Number\n");
			String acc2=sc.next(); 
		    obj.check(acc2);
		    continue;
			
		default:
			v=false;
		}
		}catch(Exception e)
		{
			v=false;
			System.out.println("\nTHANK YOU\n");
		}
		}
		
		System.out.println("\nTHANK YOU");
	}

}
