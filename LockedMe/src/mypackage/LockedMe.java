package mypackage;

import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;


public class LockedMe 
{
	
	static final String myProjectPath = "C:\\Java Projects\\My Assignments\\Live Classes Assignments\\LockedMe.Com";
	static final String errorMessage="Some error occured please contact @Lockedme.com";
        static final Scanner obj = new Scanner(System.in);
	public static void main(String[] args) 
	{
		
		int ch;
		do
		{
			displayMenu();
			System.out.println("Enter Your Choice :");
			ch=Integer.parseInt(obj.nextLine());
			switch(ch)
			{
			case 1: getAllFiles();
			break;
			case 2: createFiles();
			break;
			case 3: deleteFiles();
			break;
			case 4: searchFiles();
			break;
			case 5: System.out.println("Thanks for using LockedMe.com !!!");
				    System.exit(0);
			break;
			default : System.out.println("Invalid Option");
			}
		}
		while(ch>0);
		obj.close();
	}
	
	public static void displayMenu()
	{
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		System.out.println("");
		System.out.println("                                        Welcome to LockedMe.com"                                                     );
		System.out.println("");
		System.out.println("                                        Created by : Shahnawaz Hashmi"                                               );
		System.out.println("");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		System.out.println("                        \t\t1.Display all the files");
		System.out.println("                        \t\t2.Add a new file");
		System.out.println("                        \t\t3.Delete a file");
		System.out.println("                        \t\t4.Search a file");
		System.out.println("                        \t\t5.Exit");
		
	}
	/**
	 * This function will return all the files from directory 
	 */
	public static void getAllFiles()
	{
		try
		{
		   File folder=new File(myProjectPath);
		   File[] listOfFiles = folder.listFiles();
		   if(listOfFiles.length == 0)
			System.out.println("File not exsist");
		   else
		   {
		   for(var l : listOfFiles)
		   {
			System.out.println(l.getName());
		   }
		   }
	  }
		
		catch(Exception ex)
		{
			System.out.println(errorMessage);
		}
		
		
	}
	
	public static void createFiles()
	{
		try
		{
		   String fileName;
		   System.out.println("Enter file name");
		   fileName=obj.nextLine();
		   int linecount;
		   System.out.println("Enter how many Line you want to create");
		   linecount=Integer.parseInt(obj.nextLine());
		   FileWriter myWritter = new FileWriter(myProjectPath+"\\"+fileName);
		
		for(int i =1; i<=linecount;i++)
		{
			System.out.println("Enter the file line");
			myWritter.write(obj.nextLine()+"\n");
			
		}
		    System.out.println("File Created Succesfully!!");
		    myWritter.close();
		   
		}
		catch(Exception Ex)
		{
			System.out.println(errorMessage);
		}
		
	}
	/**
	 * This method will delete the file based on given file name
	 */
	public static void deleteFiles()
	{
		 try
		 {
		   String fileName;
		   System.out.println("Enter the file name to be delete");
		   fileName=obj.nextLine();
		   File file = new File(myProjectPath+"\\"+fileName);
		 if(file.exists())
		 {
			file.delete();
		    System.out.println("File deleted SuccesFully : "+fileName);
		 }
		 else 
			System.out.println("File not exsist");
		 }
		catch(Exception ex)
		{
			System.out.println(errorMessage);
		}
		
	}
	/**
	 * This method will search the files
	 */
	public static void searchFiles()
	{
		
	
		try
		{
		   String fileName;
		   System.out.println("Enter the file name to be Searched");
		   fileName = obj.nextLine();
		   File folder = new File(myProjectPath);
		   File[] listOfFiles = folder.listFiles();
		   LinkedList<String> filenames = new LinkedList<String>();
		   for(var l : listOfFiles)
			filenames.add(l.getName());
		    if(filenames.contains(fileName))
		    	System.out.println("File is Avilable");
		    else
		    	System.out.println("File not exsist");
		}
			
		catch(Exception ex)
		{
			System.out.println(errorMessage);
		}
		
		
   }
}
