import java.io.*;
import java.net.*;

public class Server{
	public static void main(String[] args){
		try{
			ServerSocket ss=new ServerSocket(9005);
			System.out.println("Welcome to Server Side");
			Socket s=ss.accept();

			BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter out=new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
			String str=(String)in.readLine();
			System.out.println("Client says = "+str);
			File fw=new File("pencoded.txt");
			fw.createNewFile();
			FileWriter wr=new FileWriter(fw);
			String s1=null;
			int k=0;
			String choice=null;

			while((s1=in.readLine())!=null){
				if(k==0){
					choice=s1;
					k++;
				        System.out.println(choice);
				}
				else{	
					wr.write(s1+"\n");
					wr.flush();
					k++;
				}
			}
			System.out.println("as");
			Manchesterdec zx=new Manchesterdec();
			zx.man();
			switch(choice.trim()){
				case "1":
					{
						//System.out.println("sdfg");
						PcmDecoder pcmdecode=new PcmDecoder();
				        pcmdecode.man();	
				//System.out.println("dfgh");	
					break;
					}
				case "2":
					{ PcmDecoder pcmdecode=new PcmDecoder();	
					pcmdecode.man();
					break;
					}
				case "3":
					dmod demodulate=new dmod();
					demodulate.man();
					break;
			}
			System.out.println("GRAPH");
			//Graph
			FunctionGraph fxn=new FunctionGraph();
			fxn.man();
			ss.close();
		}
		catch(Exception e){
			System.out.println(e.getStackTrace());
		}
	}
}
