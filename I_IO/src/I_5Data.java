
import java.io.*;

public class I_5Data 
{
	public static void main(String[] args) throws Exception
	{
		ByteArrayOutputStream BAOS=new ByteArrayOutputStream();
		DataOutputStream DOS=new DataOutputStream(BAOS);
		long E=123456789;
		DOS.writeLong(E);
		
		byte[] b=BAOS.toByteArray();
		ByteArrayInputStream BAIS=new ByteArrayInputStream(b);
		DataInputStream DIS=new DataInputStream(BAIS);
		long e;
		e=DIS.readLong();
		
		System.out.println("e = "+e);
	}

}
