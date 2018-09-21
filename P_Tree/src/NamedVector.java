import java.util.Vector;

public class NamedVector<E> extends Vector<E>
{
	String name;
	NamedVector(String name)
	{
		this.name=name;
	}
	
	NamedVector(String name,E elements[])
	{
		this.name=name;
		for(int i=0;i<elements.length;i++)
		{
			this.add(elements[i]);
		}
	}
	
	public String toString()
	{
		return "["+name+"]";
	}
}
