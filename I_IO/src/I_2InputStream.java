//复制文本文件用字符流，其余格式用字节流

import java.io.*;

public class I_2InputStream 
{
	public static void main(String[] args) throws Exception
	{
		//FileReader copy=new FileReader("F:/Absolute music/易水两岸.mp3");
		//FileWriter paste=new FileWriter("E:/Java/Work/I_IO/易水两岸.mp3");
		FileInputStream copy=new FileInputStream("F:/Music/Absolute music/易水两岸.mp3");
		FileOutputStream paste=new FileOutputStream("file/易水两岸.mp3");
		//FileInputStream copy=new FileInputStream("F:/Pictures/日出/安徽黄山.webp.jpg");
		//FileOutputStream paste=new FileOutputStream("E:/Java/Work/I_IO/安徽黄山.webp.jpg");
		int b=copy.read();
		while(b!=-1)
		{
			paste.write(b);
			b=copy.read();
		}
		paste.flush();		//将流中残留内容全部输出，需写在文件关闭之前
		copy.close();
		paste.close();
	}

}
