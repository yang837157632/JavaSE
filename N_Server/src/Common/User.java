package Common;

public class User implements java.io.Serializable
{
	private String UserId;
	private String passwd;
	public String getUserId() 
	{
		return UserId;
	}
	public void setUserId(String userId) 
	{
		this.UserId = userId;
	}
	public String getPasswd() 
	{
		return passwd;
	}
	public void setPasswd(String passwd) 
	{
		this.passwd = passwd;
	}	
}
