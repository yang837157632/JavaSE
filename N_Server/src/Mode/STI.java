package Mode;
import java.util.*;
public class STI 
{
	public static HashMap<String,ST> hm=new HashMap<String,ST>();
	
	public static void addThread(String UserId , ST st)
	{
		hm.put(UserId,st);
	}
	
	public static ST getThread(String UserId)
	{
		return (ST)hm.get(UserId);
	}
	
	public static String getOnlineUser(){
		Iterator it=hm.keySet().iterator();
		String res="";
		while(it.hasNext()){
			res+=it.next().toString()+" ";
		}
		return res;
	}
}
