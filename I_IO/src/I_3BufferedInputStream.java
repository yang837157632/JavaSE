//������ǧ���������ڴ����

import java.io.*;

public class I_3BufferedInputStream 
{
	public static void main(String[] args) throws Exception
	{
		//F:/Absolute music/�λ���.mp3	E:/Book/�й��Ĵ�ŵ�����.exe
		BufferedInputStream Bcopy=new BufferedInputStream(new FileInputStream("F:/Book/�й�����/�й�ͨʷ.pdf"));
		BufferedOutputStream Bpaste=new BufferedOutputStream(new FileOutputStream("file/�й�ͨʷ.pdf"));
		byte[] Buffer=new byte[2048];
		int c=Bcopy.read(Buffer);
		while(c!=-1)
		{
			Bpaste.write(Buffer,0,c);
			c=Bcopy.read(Buffer);
		}
		Bpaste.flush();
		Bcopy.close();
		Bpaste.close();
	}
}
