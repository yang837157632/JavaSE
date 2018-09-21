
import java.io.*;

public class I_13Folder 
{
	public static void main(String[] args)
	{
		File M=new File("folder");
		if(M.isDirectory())
		{					//文件夹是否存在
			System.out.println("该文件夹已存在，创建失败");

			File a=new File("folder/a.txt");
			if(!a.exists())
			{
				try
				{
					a.createNewFile();
					System.out.println("a.txt创建成功");
				}catch(Exception e){}
			}else
			{
				System.out.println("a.txt文件已存在，创建失败");
			}
			
			File b=new File("folder/b.txt");
			if(!b.exists())
			{
				try
				{
					b.createNewFile();
					System.out.println("b.txt创建成功");
				}catch(Exception e){}
			}else
			{
				System.out.println("b.txt文件已存在，创建失败");
			}
			
			File c=new File("folder/c.txt");
			if(!c.exists())
			{
				try
				{
					c.createNewFile();
					System.out.println("c.txt创建成功");
				}catch(Exception e){}
			}else
			{
				System.out.println("c.txt文件已存在，创建失败");
			}

			File m[]=M.listFiles();				//显示文件
			for(int i=0;i<m.length;i++)
			{
				System.out.println((i+1)+"文件：\t"+m[i]);
			}
		}else
		{
			M.mkdir();
			System.out.println("文件夹创建成功");
		}
	}
}
