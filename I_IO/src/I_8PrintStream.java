/*
 * DataOutputStream 中的 writeXXX(data)方法的结果是计算机识别的二进制形式
 * PrintStream 中的 println(data) 方法的结果是以人们习惯看到的字符串形式
 */

import java.io.*;

public class I_8PrintStream 
{
	public static void main(String[] args) throws Exception
	{
		long h=123456789;
		System.out.println(h);				//以10进制输出
		System.out.printf("%#X\n",h);		//以16进制输出
		
		DataOutputStream DOS=new DataOutputStream(new FileOutputStream("file/1.txt"));
		DOS.writeLong(h);
		DOS.close();
		
		PrintStream PS=new PrintStream(new FileOutputStream("file/2.txt"));
//		PrintStream PS=new PrintStream("file/3.txt");
		PS.println(h);
		PS.close();
	}

}
