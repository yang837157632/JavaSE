
import java.io.*;

public class I_13Folder 
{
	public static void main(String[] args)
	{
		File M=new File("folder");
		if(M.isDirectory())
		{					//�ļ����Ƿ����
			System.out.println("���ļ����Ѵ��ڣ�����ʧ��");

			File a=new File("folder/a.txt");
			if(!a.exists())
			{
				try
				{
					a.createNewFile();
					System.out.println("a.txt�����ɹ�");
				}catch(Exception e){}
			}else
			{
				System.out.println("a.txt�ļ��Ѵ��ڣ�����ʧ��");
			}
			
			File b=new File("folder/b.txt");
			if(!b.exists())
			{
				try
				{
					b.createNewFile();
					System.out.println("b.txt�����ɹ�");
				}catch(Exception e){}
			}else
			{
				System.out.println("b.txt�ļ��Ѵ��ڣ�����ʧ��");
			}
			
			File c=new File("folder/c.txt");
			if(!c.exists())
			{
				try
				{
					c.createNewFile();
					System.out.println("c.txt�����ɹ�");
				}catch(Exception e){}
			}else
			{
				System.out.println("c.txt�ļ��Ѵ��ڣ�����ʧ��");
			}

			File m[]=M.listFiles();				//��ʾ�ļ�
			for(int i=0;i<m.length;i++)
			{
				System.out.println((i+1)+"�ļ���\t"+m[i]);
			}
		}else
		{
			M.mkdir();
			System.out.println("�ļ��д����ɹ�");
		}
	}
}
