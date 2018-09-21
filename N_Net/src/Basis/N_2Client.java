package Basis;
import java.io.*;
import java.net.*;
public class N_2Client 
{
	public static void main(String[] args)
	{
		new N_2Client();
	}
	public N_2Client()
	{
		
		try{
			Socket s=new Socket("127.0.0.1",9998);
			InputStreamReader ISR=new InputStreamReader(s.getInputStream());
			BufferedReader BR=new BufferedReader(ISR);
			PrintWriter PW=new PrintWriter(s.getOutputStream(),true);
			InputStreamReader ISR2=new InputStreamReader(System.in);
			BufferedReader BR2=new BufferedReader(ISR2);
			while(true){
				System.out.print("我发言：");
				String send=BR2.readLine();
				PW.println(send);
				String receive=BR.readLine();
				System.out.println("服务器说："+receive);
			}
		}catch(Exception e){}
		
	}
}
