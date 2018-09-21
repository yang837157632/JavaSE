package Basis;
import java.io.*;
import java.net.*;
public class N_4Client 
{
	public static void main(String[] args)
	{
		new N_4Client();
	}
	public N_4Client()
	{
		try
		{
			System.out.println("¿Í»§¶Ë");
			Socket s=new Socket("127.0.0.1",9996);
			ObjectOutputStream OOS=new ObjectOutputStream(s.getOutputStream());
			UserInfo u=new UserInfo();
			u.setName("Star");
			u.setPass("956431");
			OOS.writeObject(u);
			System.out.println("Client Testing");
		}catch(Exception e)
		{
			System.out.println("Client Error");
		}
	}
}
