
import java.io.*;
import java.util.*;

public class I_10Print 
{
	public static void main(String[] args)
	{
		PrintStream PSout=null;
		PrintStream PSerr=null;
		Scanner in=null;
		try
		{
			PSout=new PrintStream("file/PSout.txt");
			PSerr=new PrintStream("file/PSerr.txt");
			in=new Scanner(System.in);
			int j;
			System.setOut(PSout);
			System.setErr(PSerr);
			while(true)
			{
				j=in.nextInt();
				System.out.println(j);
			}
		}catch(Exception e)
		{
			System.err.println(" ‰»Î”–ŒÛ");
		}
	}
}
