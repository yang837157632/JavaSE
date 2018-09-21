/*
 * DataOutputStream �е� writeXXX(data)�����Ľ���Ǽ����ʶ��Ķ�������ʽ
 * PrintStream �е� println(data) �����Ľ����������ϰ�߿������ַ�����ʽ
 */

import java.io.*;

public class I_8PrintStream 
{
	public static void main(String[] args) throws Exception
	{
		long h=123456789;
		System.out.println(h);				//��10�������
		System.out.printf("%#X\n",h);		//��16�������
		
		DataOutputStream DOS=new DataOutputStream(new FileOutputStream("file/1.txt"));
		DOS.writeLong(h);
		DOS.close();
		
		PrintStream PS=new PrintStream(new FileOutputStream("file/2.txt"));
//		PrintStream PS=new PrintStream("file/3.txt");
		PS.println(h);
		PS.close();
	}

}
