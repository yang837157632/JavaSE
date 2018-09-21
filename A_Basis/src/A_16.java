import java.util.*;
public class A_16 
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		Random R=new Random();
		System.out.println("Roshambo");
		System.out.print("Please chooose 0(Rock)-1(Scissors)-2(Paper)");
		int peo=in.nextInt();
		int com=R.nextInt(3);
		String peoMark=null;
		String comMark=null;
		switch(peo)
		{
		case 0:
			peoMark="Rock";
			break;
		case 1:
			peoMark="Scissors";
			break;
		case 2:
			peoMark="paper";
		}
		switch(com)
		{
		case 0:
			comMark="Rock";
			break;
		case 1:
			comMark="Scissors";
			break;
		case 2:
			comMark="Paper";
		}
		if(peo==com)
		{
			System.out.println("Even.\tYour guess is "+peoMark+"£¬ computer guess is "+comMark);
		}else if(((peo-com)==1)||(peo-com)==-2)
		{
			System.out.println("You lose.\tYour guess is "+peoMark+", computer guess is "+comMark);
		}else
		{
			System.out.println("You Win.\tYour guess is "+peoMark+", computer guess is "+comMark);
		}
	}

}
