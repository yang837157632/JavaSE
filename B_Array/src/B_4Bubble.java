import java.util.*;
public class B_4Bubble 
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Please input the number of student: ");
		int num=in.nextInt();
		int[] a=new int[num];
		int com=0;
		int rep=0;
		for(int i=0;i<num;i++)
		{
			System.out.print("Please input the "+(i+1)+" number: ");
			a[i]=in.nextInt();			
		}
		for(int i=1;i<num;i++)
		{
			for(int j=0;j<num-i;j++)
			{
				if(a[j]<a[j+1])
				{
					int b=a[j];
					a[j]=a[j+1];
					a[j+1]=b;
					rep++;
				}
				com++;
			}
		}
		for(int i=0;i<num;i++)
		{
			System.out.print(a[i]+"\t");			
		}
		System.out.println("\ncompare = "+com+" , replace = "+rep);
	}

}
