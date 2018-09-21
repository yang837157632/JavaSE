package Tool;
import java.util.*;
import java.io.*;
import Interface.*;
public class FriendList 
{
	private static HashMap<String,ListF> hm=new HashMap<String,ListF>();
	
	public static void addList(String Id,ListF list)
	{
		hm.put(Id,list);
	}
	
	public static ListF getList(String Id)
	{
		return (ListF)hm.get(Id);
	}

}
