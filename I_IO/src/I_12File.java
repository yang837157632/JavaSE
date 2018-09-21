
import java.io.*;

public class I_12File 
{
	public static void main(String[] args)
	{
		File L=new File("file/飘.txt");
		
		if(L.exists())
		{
			System.out.println("文件路径：\t"+L.getAbsolutePath());
			System.out.println("文件大小：\t"+L.length());
			System.out.println("文件可读性：\t"+L.canRead());
			System.out.println("文件可写性：\t"+L.canWrite());
		}else
		{
			System.out.println("文件不存在，读取属性失败");
		}
		
		if(!L.exists())
		{
			try
			{
				L.createNewFile();
			}catch(Exception e){}
		}else
		{
			System.out.println("文件已存在，创建失败");
		}
	}

}
