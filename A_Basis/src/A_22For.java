import java.util.Scanner;
public class A_22For 
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Please input the number of students: ");
		int num=in.nextInt();
		int sum=0;
		int ave=0;
		for(int i=0;i<num;i++)
		{
			System.out.print("Please input the score of the "+(i+1)+" student: ");
			sum+=in.nextInt();
		}
		ave=sum/num;
		System.out.println("Sum = "+sum+" , Ave = "+ave);		
	}

}
