/*
 * 流是用于连接程序和设备之间的管道，主要用于数据传输。
 * 这个管道上有很多的按钮，每个按钮可以实现不同的功能。
 * 
 * 流的分类
 * 四大基本抽象流：输入流	输出流	字节流	字符流
 * 文件流		缓冲流	转换流	数据流	Print流	Object流
 * 
 * 输入流		read	input
 * 输出流		write	output
 * 字符流		read	write
 * 字节流		input	output
 * 
 * 1字符=2字节
 * 英文字母、数字	1字节，	汉字	2字节
 * 字符流速度快
 */

import java.io.*;

public class I_1Reader 
{
	public static void main(String[] args) throws Exception
	{
		FileReader A=new FileReader("src/I_1Reader.java");
//		FileInputStream A=new FileInputStream("src/I_1Reader.java");
		//字节流读取的时候无法显示汉字
		int a;				//这里必须定义成整形，java规定read()函数的返回值是整形的
		a=A.read();	    	//读取一个字符
		System.out.println("文件内容为： ");
		while(a!=-1)
		{					//ASCII码是从0开始的数字，什么都没有的时候才会返回-1
			System.out.print((char)a);
			a=A.read();
		}
		A.close();
	}
}
