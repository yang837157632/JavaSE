import java.util.*;
public class B_7Insert 
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		int[] a={12,23,34,45,65,89,96,123};
		int[] b=new int[a.length+1];
		System.out.println("Please input the number: ");
		b[b.length-1]=in.nextInt();
		for(int i=0;i<a.length;i++)
		{
			b[i]=a[i];
		}
		Arrays.sort(b);
		for(int i=0;i<b.length;i++)
		{
			System.out.print(b[i]+"\t");
		}
	}

}
