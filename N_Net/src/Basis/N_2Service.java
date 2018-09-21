package Basis;
import java.io.*;
import java.net.*;
public class N_2Service 
{
	public static void main(String[] args)
	{
		new N_2Service();
	}
	public N_2Service()
	{
		
		try{
			ServerSocket ss=new ServerSocket(9998);
			System.out.println("服务器开始监听");
			Socket s=ss.accept();
			InputStreamReader ISR=new InputStreamReader(s.getInputStream());
			BufferedReader BR=new BufferedReader(ISR);
			PrintWriter PW=new PrintWriter(s.getOutputStream(),true);
			InputStreamReader ISR2=new InputStreamReader(System.in);
			BufferedReader BR2=new BufferedReader(ISR2);
			while(true){
				String receive=BR.readLine();
				System.out.println("客户端："+receive);
				System.out.print("我说：");
				String send=BR2.readLine();
				PW.println(send);
			}
		}catch(Exception e){}
		
	}
}
