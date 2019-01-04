#include<bits/stdc++.h>
using namespace std;
int main()
{
	vector<float> v;
	string line;
	float data;
	ifstream myfile ("values.txt");
	if(myfile.is_open())
	{
		while(!myfile.eof())
		{
			getline(myfile,line);
			data=::strtod(line.c_str(),0);
			v.push_back(data);
		}
		myfile.close();
	}

	int n=v.size();

	int i=0,b[n],k=1;
	//b[0]=0;
	//cout << b[0] << endl;
	vector<int> vec;
	//n--;	
	//	float dif[n];

	for(int j=0;j<n-1;j++)
	{
		//		dif[j] = v[j+1]-v[j];
		if(v[j]<v[j+1])

		{

			vec.push_back(1);
		}
		else if(v[j]>v[j+1])
		{

			vec.push_back(0);
		}
		else if(v[j]==v[j+1])
		{
			vec.push_back(vec.back());
		}
	}

	/*float summ=0;

	  for(int x=0;x<n-1;x++)
	  dif[x]*=100000;

	  for(int x=0;x<n-1;x++){
	  summ+=dif[x];
	  }*/
	//summ/=n-1;


	//summ*=1000;

	//cout<<dif[5]<<" "<<dif[6]<<endl;

	int len = vec.size();
	/*for(int j=0;j<len;j++)
	  {
	  cout<<vec[j]<<endl;
	  }*/
	float mini=0,maxi=0;
	for(i=0;i<n;i++)
	{
		if(maxi<v[i])
			maxi = v[i];
		if(mini>v[i])
			mini=v[i];
	}

	float diff=maxi-mini;

	ofstream output;
	output.open("inut1.txt");
	output<<v[0]<<"\n";
	output<<diff/30<<endl;

	//	output.precision(20);
	//output<<summ<<"\n";

	for(i=0;i<len;i++)
	{
		output << vec[i] << "\n";
	}
	output.close();
	return 0;
}
