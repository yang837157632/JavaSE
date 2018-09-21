import java.util.*;
public class B_5Selection 
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Please input the number of student£º ");
		int num=in.nextInt();
		int com=0;
		int rep=0;
		int[] a=new int[num];
		for(int i=0;i<num;i++)
		{
			System.out.print("Please input the "+(i+1)+" number: ");
			a[i]=in.nextInt();
		}
		for(int i=0;i<num-1;i++)
		{
			for(int j=i+1;j<num;j++)
			{
				if(a[i]<a[j])
				{
					int b=a[i];
					a[i]=a[j];
					a[j]=b;
					rep++;
				}
				com++;
			}
		}
		for(int i=0;i<num;i++)
		{
			System.out.print(a[i]+"\t");
		}
		System.out.println("\ncompare = "+com+" ,replace = "+rep);
	}

}
