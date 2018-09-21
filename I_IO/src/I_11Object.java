
import java.io.*;

public class I_11Object 
{
	public static void main(String[] args)
	{
		ObjectOutputStream OOS=null;
		ObjectInputStream OIS=null;
		Student K=new Student("Star",269,92.9f,"OECE");
		Student k=null;
		try
		{
			FileOutputStream FOS=new FileOutputStream("file/Object.txt");
			OOS=new ObjectOutputStream(FOS);
			OOS.writeObject(K);
			
			OIS=new ObjectInputStream(new FileInputStream("file/Object.txt"));
			k=(Student)OIS.readObject();
			System.out.println("name:\t"+k.name);
			System.out.println("no:\t"+k.no);
			System.out.println("grade:\t"+k.grade);
			System.out.println("school:\t"+k.school);
		}catch(Exception e)
		{
			System.out.println("Error!");
		}
		finally
		{
			try
			{
				OOS.close();
				OIS.close();
				System.exit(-1);
			}catch(Exception e)
			{
				System.exit(-1);
			}
		}
	}
}

class Student implements Serializable
{										//�սӿڣ�����������
	String name;
	int no;
	float grade;
	transient String school;			//transient	��������ã���紫����������
	
	public Student(String name,int no,float grade,String school)
	{
		this.name=name;
		this.no=no;
		this.grade=grade;
		this.school=school;
	}
}
