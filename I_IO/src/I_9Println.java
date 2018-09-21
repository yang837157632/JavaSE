
import java.io.*;

public class I_9Println 
{
	public static void main(String[] args) throws Exception
	{
 		PrintStream PS=new PrintStream("file/4.txt");
//		PrintStream PS=new PrintStream(new FileOutputStream("file/5.txt"));
		System.setOut(PS);
		System.out.println("Hello");
		System.out.println(123456789);
		PS.close();
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out))); 
		System.out.println(123456789);
	}

}