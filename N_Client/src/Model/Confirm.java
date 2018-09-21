package Model;
import Common.*;
public class Confirm 
{
	public boolean checkUser(User u)
	{
		return new Link().send(u);
	}
}
