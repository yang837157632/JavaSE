package Tool;
import java.util.*;
import Interface.*;

public class ChatM 
{
	private static HashMap<String,Chat> hm=new HashMap<String,Chat>();
	
	public static void addChat(String OplusF,Chat chat)
	{
		hm.put(OplusF,chat);
	}
	
	public static Chat getChat(String OplusF)
	{
		return (Chat)hm.get(OplusF);
	}
}
