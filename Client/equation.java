import java.math.*;
import java.io.*;
import java.util.*;

public class equation{
	public void man(){
		int a;
		System.out.println("Please enter the corresponding integer:");
		System.out.println("1) Sine waveform");
		System.out.println("2) Cosine waveform");
		System.out.println("3) Exponential Sine waveform");
		System.out.println("4) Exponential Cosine waveform");
		System.out.println("5) Sine+Cosine Waveform");

		Scanner sc;
		sc=new Scanner(System.in);
		a=sc.nextInt();
		float PI=(float)Math.PI;
		float phase=0;
		try{
			FileWriter fw=new FileWriter("values.txt");
			if(a==1)
			{
				System.out.println("Enter 'T'(time period)\nsin((2*"+PI+"/T)*t+phase*"+PI+")");
				float T;
				T=sc.nextInt();

				int amp;
				System.out.println("Enter the Amplitude of the wave:");
				amp=sc.nextInt();

				float e;
				System.out.println("Writting values...");

				for(int t=0;t<10*100*T;t++)
				{
					e=(2*PI*t/(T))+(phase);
					e=PI*e;
					e=e/180;
					e=(float)Math.sin(e);
					e=e*amp;
					fw.write(e+"\n");
				}
			}
			else if(a==2)
			{
				System.out.println("Enter 'T'(time period)\ncos((2*"+PI+"/T)*t+phase*"+PI+")");

				float T;
				T=sc.nextFloat();

				float e;
				int amp;
				System.out.println("Enter the Amplitude of the wave:");
				amp=sc.nextInt();

				System.out.println("Writting values...\n");

				for(int t=0;t<10*100*T;t++)
				{
					e=(2*PI*t/(T))+(phase);
					e=PI*e;
					e=e/180;
					e=(float)Math.cos(e);
					e=e*amp;
					fw.write(e+"\n");
				}
//				System.out.println("dfg");
			}
			else if(a==3)
			{
				System.out.println("Please enter the power of the sine function:\n");
				int ne;

				ne=sc.nextInt();
				System.out.println("Enter 'T'(time period)\nsin^"+ne+"((2*"+PI+"/T)*t+phase*"+PI+")");

				float T;
				T=sc.nextInt();

				float e;
				int amp;
				System.out.println("Enter the Amplitude of the wave:\n");

				amp=sc.nextInt();
				System.out.println("Writting values...");

				for(int t=0;t<10*100*T;t++)
				{
					e=(2*PI*t/(T))+(phase);
					e=PI*e;
					e=e/180;
					e=(float)Math.sin(e);
					e=(float)Math.pow(e,ne);
					e=e*amp;
					fw.write(e+"\n");
					//				fprintf(fp,"%0.5f\n",e);
				}
			}
			else if(a==4)
			{
				System.out.println("Please enter the power of the cosine function:\n");
				int ne;
				ne=sc.nextInt();
				//			scanf("%d",&ne);
				//printf("Enter 'T'(time period)\ncos^%d((2*%0.4f/T)*t+phase*%0.4f)\n",ne,PI,PI);
				System.out.println("Enter 'T'(time period)\ncos^"+ne+"((2*"+PI+"/T)*t+phase*"+PI+")");
				float T;
				//	scanf("%f",&T);
				T=sc.nextInt();
				float e;
				int amp;
				System.out.println("Enter the Amplitude of the wave:\n");
				//			scanf("%d",&amp);
				amp=sc.nextInt();
				System.out.println("Writting values...\n");
				//		fprintf(fp,"%0.5f\n",amp);
				for(int t=0;t<10*100*T;t++)
				{
					e=(2*PI*t/(T))+(phase);
					e=PI*e;
					e=e/180;
					e=(float)Math.cos(e);
					e=(float)Math.pow(e,ne);
					e=e*amp;
					fw.write(e+"\n");
					//				fprintf(fp,"%0.5f\n",e);
				}
			}
			else if(a==5)
			{
				System.out.println("Please enter the amplitude of the sine function:\n");
				int ne;
				float P1=0;
				//		scanf("%d",&ne);
				ne=sc.nextInt();
				System.out.println("Please enter the amplitude of the cosine function:\n");
				int NE;
				float P2=0;
				//	scanf("%d",&NE);
				NE=sc.nextInt();
				System.out.println("Enter time period of sine followed by cos\n[("+ne+")sin((2*"+PI+"/T)*t+phase*"+PI+")]+[("+NE+")cos((2*"+PI+"/T)*t+phase*"+PI+")]");
				float T,r;
				T=sc.nextFloat();
				r=sc.nextFloat();
				//	scanf("%f %f",&T,&r);
				float e;
				float E;
				float amp;
				System.out.println("Writting values...\n");
				for(int t=0;t<10*100*T;t++)
				{
					e=(2*PI*r/(T))+(P2);
					E=(2*PI*t/T)+P1;
					e=PI*e;
					E=PI*E;
					e=e/180;
					E=E/180;
					e=(float)Math.cos(e);
					E=(float)Math.sin(E);
					e=e*ne;
					E=E*NE;
					e=e+E;
					fw.write(e+"\n");
					//				fprintf(fp,"%0.5f\n",e);
				}

			}
			fw.close();
		}
		catch(Exception e){
			System.out.println(e.getStackTrace());
		}
	}
}
