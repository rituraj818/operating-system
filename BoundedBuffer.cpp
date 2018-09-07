#include<iostream>
using namespace std;
int S=1,E=10,F=0;


int wait(int S)
{
	while(S<=0);
	S--;	
	return S;
}

int signal(int S)
{
	S++;
	return S;	
}
void produce()
{
	S=wait(S);
	E=wait(E);
	F=signal(F);
	cout<<"\nProduce item\n";
	S=signal(S);	
}
void consume()
{
	S=wait(S);
	F=wait(F);
	E=signal(E);
	cout<<"\n Consumer is consume item\n";
	S=signal(S);	
}

int main()
{
	
	while(1)
	{
	  int ch;
	cout<<"1.Producer\n 2.Consumer\n 3.exit\n";
	cout<<"enter your choice";
	cin>>ch;	
	switch(ch)
	{
		case 1:
			if(S==1 && E!=0)
			{
			produce();
			break;
		    }
			else
			{
			cout<<"producer is waiting\n";
		   }
		case 2:
			if(S==1 && F!=0)
			{
				consume();
				break;
			}
			else 
			{
				cout<<"no product to consume\n";
			}
		case 3:
			{
				exit(0);
			}
		default:
			{
				cout<<"Invalid choice";
			}
			
	}
}
return 0;
}
