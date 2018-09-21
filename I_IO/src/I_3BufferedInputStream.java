//缓冲流千万别和虚拟内存混淆

import java.io.*;

public class I_3BufferedInputStream 
{
	public static void main(String[] args) throws Exception
	{
		//F:/Absolute music/梦幻曲.mp3	E:/Book/中国四大古典名著.exe
		BufferedInputStream Bcopy=new BufferedInputStream(new FileInputStream("F:/Book/中国名著/中国通史.pdf"));
		BufferedOutputStream Bpaste=new BufferedOutputStream(new FileOutputStream("file/中国通史.pdf"));
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
