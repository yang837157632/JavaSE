
import java.io.*;

public class I_6ReadLine 
{
	public static void main(String[] args)
	{
		BufferedReader F=new BufferedReader(new InputStreamReader(System.in));
		try
		{
			System.out.println("String: ");
			String f1=F.readLine();
		}catch(Exception e)
		{
			System.out.println(" String Testing");
		}

		try
		{
			System.out.println("Float: ");
			float f2=Float.parseFloat(F.readLine());			
		}catch(Exception e)
		{
			System.out.println("Float Testing");
		}
		
		try
		{
			System.out.println("Int: ");
			int f3=Integer.parseInt(F.readLine());			
		}catch(Exception e)
		{
			System.out.println("Integer Testing");
		}
		
		try
		{
			System.out.println("Double: ");
			Double f4=Double.parseDouble(F.readLine());			
		}catch(Exception e)
		{
			System.out.println("Double Testing");
		}
	}
}
