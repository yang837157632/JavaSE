import java.util.Scanner;
public class A_19 
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Please input the number of student: ");
		int num=in.nextInt();
		int i=1;
		int sum=0;
		int ave=0;
		while(i<=num){
			System.out.print("Please input the score of "+i+" student: ");
			sum+=in.nextInt();
			i++;
		}
		ave=sum/num;
		System.out.println("Ave = "+ave+" , Sum = "+sum);
	}

}
