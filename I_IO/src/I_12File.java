
import java.io.*;

public class I_12File 
{
	public static void main(String[] args)
	{
		File L=new File("file/Ʈ.txt");
		
		if(L.exists())
		{
			System.out.println("�ļ�·����\t"+L.getAbsolutePath());
			System.out.println("�ļ���С��\t"+L.length());
			System.out.println("�ļ��ɶ��ԣ�\t"+L.canRead());
			System.out.println("�ļ���д�ԣ�\t"+L.canWrite());
		}else
		{
			System.out.println("�ļ������ڣ���ȡ����ʧ��");
		}
		
		if(!L.exists())
		{
			try
			{
				L.createNewFile();
			}catch(Exception e){}
		}else
		{
			System.out.println("�ļ��Ѵ��ڣ�����ʧ��");
		}
	}

}
