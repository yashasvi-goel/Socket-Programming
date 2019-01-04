import java.net.*;
import java.io.*;
import java.util.*;

public class Client
{
	public static void main(String args[])
	{
		try
		{
			Socket s=new Socket("192.168.43.171",9005);//server ip;port number
			//File f=new File("Word.txt");
			// Scanner sc=new Scanner(f);

			System.out.println("Welcome to the Client Program");
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

			PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));

			out.println("Hello Server");
			out.flush();
			//out.close();
			//s.close();

			System.out.println("Please enter the type of modulation");
			System.out.println("1) PCM");
			System.out.println("2) DPCM");
			System.out.println("3) Delta Modulation");
			Process r=Runtime.getRuntime().exec("g++ DPCM.cpp -o DPCM.out");//compiling cpp programs
			r=Runtime.getRuntime().exec("g++ pccm.cpp -o pcm.out");
			r=Runtime.getRuntime().exec("g++ ff.cpp -o dm.out");
			Scanner sc=new Scanner(System.in);
			int x=sc.nextInt();//choose an option
			equation A=new equation();//function generator
			A.man();
			FunctionGraph fxn=new FunctionGraph();
			fxn.man("values.txt");
			Process p;
			String str;
			switch(x)
			{
				case 1:{
					       p=Runtime.getRuntime().exec("./pcm.out");
					       BufferedReader stdInput = new BufferedReader(new InputStreamReader (p.getInputStream()));
					       while((str = stdInput.readLine())!=null) {
						       System.out.println(str);
					       }

					       break;
				}
				case 2:{
					       p=Runtime.getRuntime().exec("./DPCM.out");
					       BufferedReader stdInput = new BufferedReader(new InputStreamReader (p.getInputStream()));
					       while((str = stdInput.readLine())!=null) {
						       System.out.println(str);
					       }
					       break;
				}
				case 3:{
					       p=Runtime.getRuntime().exec("./dm.out");
					       BufferedReader stdInput = new BufferedReader(new InputStreamReader (p.getInputStream()));
					       while((str = stdInput.readLine())!=null) {
						       System.out.println(str);
					       }
					       break;
				}
			}
			q1 asd =new q1();
			asd.man();
//			System.out.println("manchester");
			//Sushant
			File f=new File("manEncoded.txt");
			Scanner scan=new Scanner(f);
			//BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			//PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
			out.println(x);
			out.flush();

			String temp;
			while(scan.hasNextLine())
			{
				temp=scan.next();
				out.println(temp);
				out.flush();
				scan.nextLine();
			}
			//			out.println("Over");
			//			out.flush();
		}
		catch(Exception e)
		{
			System.out.println(e.getStackTrace());
		}
	}
};
