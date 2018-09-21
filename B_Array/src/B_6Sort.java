import java.util.*;
public class B_6Sort 
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Please input the number of people: ");
		int num=in.nextInt();
		int[] a=new int[num];
		for(int i=0;i<num;i++)
		{
			System.out.print("Please input the "+(i+1)+" people's score: ");
			a[i]=in.nextInt();
		}
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+"\t");
		}
		System.out.println();
		
		Arrays.sort(a);
		
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+"\t");
		}
	}
}
