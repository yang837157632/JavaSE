
import java.io.*;

public class I_4BufferedReader 
{
	public static void main(String[] args)throws Exception
	{
		BufferedReader Bcopy=new BufferedReader(new FileReader("F:/Book/Íâ¹úÃûÖø/Æ®.txt"));
		BufferedWriter Bpaste=new BufferedWriter(new FileWriter("file/Æ®.txt"));
		char[] Buffer=new char[1024];
		int d=Bcopy.read(Buffer);
		while(d!=-1)
		{
			Bpaste.write(Buffer,0,d);
			d=Bcopy.read(Buffer);
		}
		Bpaste.flush();
		Bcopy.close();
		Bpaste.close();
	}

}
