import java.io.*;
import java.lang.*;
import java.util.*;
public class q1
{
	public void  man()
	{
		File f=null;
		Scanner sc=null;
		File filewrite=null;
		FileWriter wr=null;
		String arr;
		int j;
		char ch;
		int i;
		try
		{
			f=new File("input1.txt");
			sc=new Scanner(f);
			filewrite=new File("manEncoded.txt");
			filewrite.createNewFile();
			wr=new FileWriter(filewrite,false);
			arr=sc.nextLine();
			wr.write(arr+"\n");
			arr=sc.nextLine();
			wr.write(arr+"\n");
			while(sc.hasNextLine())
			{
				arr=sc.nextLine();
				j=0;
				for(i=0;i<arr.length();i++)
				{
					ch=arr.charAt(i);
					if((int)ch-48==1)
						wr.write("1-1\n");
					else 
						wr.write("-11\n");
				}
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error");
		}
		catch(IOException e)
		{
			System.out.println("Error");
		}
		finally
		{
			try
			{
				sc.close();
				wr.close();
			}
			catch(Exception e)
			{
			}
		}
	}
}



