package Basis;
import java.io.*;
import java.net.*;
public class N_1Service {
	public static void main(String[] args){
		new N_1Service();
	}
	public N_1Service(){
		
		try{
			ServerSocket ss=new ServerSocket(9999);
			System.out.println("���������ڼ���");
			Socket s=ss.accept(); 
			System.out.println("hello");
			InputStreamReader ISR=new InputStreamReader(s.getInputStream());
			BufferedReader BR=new BufferedReader(ISR);
			String receive=BR.readLine();
			System.out.println(receive);
			PrintWriter PW=new PrintWriter(s.getOutputStream(),true);
			PW.println("���Ƿ�����");
		}catch(Exception e){}
		
	}
}
