/*
 * �����������ӳ�����豸֮��Ĺܵ�����Ҫ�������ݴ��䡣
 * ����ܵ����кܶ�İ�ť��ÿ����ť����ʵ�ֲ�ͬ�Ĺ��ܡ�
 * 
 * ���ķ���
 * �Ĵ������������������	�����	�ֽ���	�ַ���
 * �ļ���		������	ת����	������	Print��	Object��
 * 
 * ������		read	input
 * �����		write	output
 * �ַ���		read	write
 * �ֽ���		input	output
 * 
 * 1�ַ�=2�ֽ�
 * Ӣ����ĸ������	1�ֽڣ�	����	2�ֽ�
 * �ַ����ٶȿ�
 */

import java.io.*;

public class I_1Reader 
{
	public static void main(String[] args) throws Exception
	{
		FileReader A=new FileReader("src/I_1Reader.java");
//		FileInputStream A=new FileInputStream("src/I_1Reader.java");
		//�ֽ�����ȡ��ʱ���޷���ʾ����
		int a;				//������붨������Σ�java�涨read()�����ķ���ֵ�����ε�
		a=A.read();	    	//��ȡһ���ַ�
		System.out.println("�ļ�����Ϊ�� ");
		while(a!=-1)
		{					//ASCII���Ǵ�0��ʼ�����֣�ʲô��û�е�ʱ��Ż᷵��-1
			System.out.print((char)a);
			a=A.read();
		}
		A.close();
	}
}
