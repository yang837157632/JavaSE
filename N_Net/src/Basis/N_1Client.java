package Basis;
import java.io.*;
import java.net.*;
public class N_1Client {
	public static void main(String[] args){
		new N_1Client();
	}
	public N_1Client(){
		
		try{
			Socket s=new Socket("127.0.0.1",9999);
			PrintWriter PW=new PrintWriter(s.getOutputStream(),true);
			PW.println("我是客户端");
			InputStreamReader ISR=new InputStreamReader(s.getInputStream());
			BufferedReader BR=new BufferedReader(ISR);
			String receive=BR.readLine();
			System.out.println(receive);
		}catch(Exception e){}
	}
}
