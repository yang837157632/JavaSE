//�����ı��ļ����ַ����������ʽ���ֽ���

import java.io.*;

public class I_2InputStream 
{
	public static void main(String[] args) throws Exception
	{
		//FileReader copy=new FileReader("F:/Absolute music/��ˮ����.mp3");
		//FileWriter paste=new FileWriter("E:/Java/Work/I_IO/��ˮ����.mp3");
		FileInputStream copy=new FileInputStream("F:/Music/Absolute music/��ˮ����.mp3");
		FileOutputStream paste=new FileOutputStream("file/��ˮ����.mp3");
		//FileInputStream copy=new FileInputStream("F:/Pictures/�ճ�/���ջ�ɽ.webp.jpg");
		//FileOutputStream paste=new FileOutputStream("E:/Java/Work/I_IO/���ջ�ɽ.webp.jpg");
		int b=copy.read();
		while(b!=-1)
		{
			paste.write(b);
			b=copy.read();
		}
		paste.flush();		//�����в�������ȫ���������д���ļ��ر�֮ǰ
		copy.close();
		paste.close();
	}

}
