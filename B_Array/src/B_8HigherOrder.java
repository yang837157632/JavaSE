
public class B_8HigherOrder 
{
	public static void main(String[] args)
	{
		int[][] a={{1,2,3},{5,8,1,5},{1},{45,23}};
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[i].length;j++)
			{
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
		int[][] b=new int[3][];
		b[0]=new int[3];
		b[1]=new int[4];
		b[2]=new int[2];
		for(int i=0;i<b.length;i++)
		{
			for(int j=0;j<b[i].length;j++)
			{
				b[i][j]=i+j;
			}
		}
		for(int i=0;i<b.length;i++)
		{
			System.out.println();
			for(int j=0;j<b[i].length;j++)
			{
				System.out.print(b[i][j]+"\t");
			}
		}
	}

}
