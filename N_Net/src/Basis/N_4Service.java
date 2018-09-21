package Basis;
import java.io.*;
import java.net.*;
public class N_4Service 
{
	public static void main(String[] args)
	{
		new N_4Service();
	}
	public N_4Service()
	{
		
		try
		{
			System.out.println("服务器端");
			ServerSocket ss=new ServerSocket(9996);
			Socket s=ss.accept();
			ObjectInputStream OIS=new ObjectInputStream(s.getInputStream());
			UserInfo u=(UserInfo)OIS.readObject();//此处出错，原因未知
			System.out.println(u.getName());
			System.out.println(u.getPass());
			System.out.println("Service Testing");
		}catch(Exception e)
		{
			System.out.println("Service Error");
		}
		
		
	}
}
