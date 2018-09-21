
public class B_2Copy 
{
	public static void main(String[] args)
	{
		int[] a={23,65,52,43,95,542,26,58};
		int[] b=new int[a.length];
		for(int i=0;i<a.length;i++)
		{
			b[i]=a[i];
		}
		for(int i=0;i<b.length;i++)
		{
			System.out.print(b[i]+"\t");
		}
	}

}
