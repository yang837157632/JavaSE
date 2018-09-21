package Tool;
import java.util.*;
public class ThreadM 
{
	private static HashMap<String,STLink> hm=new HashMap<String,STLink>();
	
	public static void addSTLink(String Id,STLink stl)
	{
		hm.put(Id,stl);
	}
	
	public static STLink getSTLink(String Id)
	{
		return (STLink)hm.get(Id);
	}
}
