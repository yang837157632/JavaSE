import java.util.*;
import java.awt.*;
import javax.swing.*;

public class ChessMan
{
	private Color color;
	private String name;
	private int x;
	private int y;
	private boolean focus=false;
	
	public ChessMan() {}
	
	public ChessMan(Color color,String name,int x,int y)
	{
		this.color=color;
		this.name=name;
		this.x=x;
		this.y=y;
	}
	
	public Color getColor()
	{
		return this.color;
	}
	
	public void setColor(Color color)
	{
		this.color=color;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public void setX(int x)
	{
		this.x=x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public void setY(int y)
	{
		this.y=y;
	}
	
	public boolean getFocus()
	{
		return focus;
	}
	
	public void setFocus(boolean focus)
	{
		this.focus=focus;
	}
}