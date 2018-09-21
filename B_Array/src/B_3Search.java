import java.util.*;
public class B_3Search 
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		Boolean flag=false;
		int j=0;
		String[] S={"Amy","Steve","Micheal"	,"Jim","Bob","Racheal","Monica"};
		System.out.print("Please input the name: ");
		String a=in.next();
		for(int i=0;i<S.length;i++)
		{
			if(a.equals(S[i]))
			{
				flag=true;
				j=i+1;
				break;
			}
		}
		if(flag)
		{
			System.out.println("Found it, the "+j);
		}else
		{
			System.out.println("Not Found");
		}
	}

}
