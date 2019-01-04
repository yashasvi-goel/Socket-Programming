#include<cstdio>
#include<fstream>
#include<string>
#include<iostream>
#include<cstdlib>
#include<math.h>
#include<vector>

using namespace std;

int binary(int n){
	int a[10],i;

	for(i=0; n>0; i++)
	{
		a[i]=n%2;
		n= n/2;
	}


	int f=pow(10,i),sum=0;

	for(i=i-1 ;i>=0 ;i--)
	{
		sum=sum+(f*a[i]);
		f=pow(10,i);
	}

	return sum/10;
}

int main(){

	float A_max=0,A_min=0;
	int inter;
	int L=32;
	float q_out,q_in,q_er,pr_in,pr_out=0;

	vector<int> v;

	cout<<"The number of levels for the quantizer: "<<L<<endl;

	ifstream input("values.txt");

	if(input.is_open()){
		while(!input.eof()){
			string number;
			getline(input,number);
			float data=::strtod(number.c_str(),0);
			if(data>A_max)
				A_max=data;
			if(data<A_min)
				A_min=data;

		}
	}
	input.close();

	float d=(A_max-A_min)/L;

	ifstream in("values.txt");

	if(in.is_open()){
		while(!in.eof()){
			string number;
			getline(in,number);
			float data=::strtod(number.c_str(),0);

			q_er=d/32;

			q_in=data-pr_out;       //quantizer input , difference between data and predictor output
			q_out=q_in+q_er;        //quantizer output, sum of error and input

			//now to set each ran

			int lvl=0;

			for(float i=0;A_min+i<=A_max-d;i+=d){
				if(!(data>=A_min+i&&data<=A_min+i+d)){
					lvl++;
					//cout<<"c"<<endl;
				}
				else
					break;
				//cout<<"c"<<endl;
			}
			if(lvl>31)
				lvl=31;
			v.push_back(binary(lvl));

			pr_in=q_out+pr_out; //then you need to find the output and update it.

			pr_out+=data; //predictor output here

		}
	}
	in.close();

	ofstream file;
	file.open("input1.txt");
	int l=v.size();
	int y=0;
	int p=L;
	while(p!=1){
		p/=2;
		y++;
	}
	file<<A_max<<endl<<A_min<<endl;

	for(int i=0;i<l;i++){
		int p=v[i];
		int x=log10(p)+1;
		if(p==0)
			x=1;
		int s=y-x;
		while(s>0){
			file<<"0";
			s--;
		}
		file<<v[i]<<endl;
	}

	file.close();
	return 0;
}
