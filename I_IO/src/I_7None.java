
import java.io.*;

public class I_7None 
{
	public static void main(String[] args) throws Exception
	{
		System.out.println("请输入一个字符串： ");
		BufferedReader G=new BufferedReader(new InputStreamReader(System.in));
		String g=G.readLine();
		//如果直接输入回车的话，字符串就是一个空字符串
		System.out.println("----------");
		System.out.println(g+"123456789");
		System.out.println(g.equals(""));
		System.out.println(g.equals(null));
	}
}
