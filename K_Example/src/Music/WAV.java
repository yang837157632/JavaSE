package Music;

import java.io.File;
import javax.sound.sampled.*;

public class WAV 
{
	public static void main(String[] args)
	{
		Thread t=new Thread(new Sound("./tank.wav"));
		t.start();
	}
}

class Sound implements Runnable
{
	private String name;
	
	public Sound(String name)
	{
		this.name=name;
	}
	
	public void run()
	{
		File file=new File(name);
		AudioInputStream AIS=null;
		try
		{
			AIS=AudioSystem.getAudioInputStream(file);
		}catch(Exception e){}	
		AudioFormat format=AIS.getFormat();
		SourceDataLine SDL=null;
		DataLine.Info info=new DataLine.Info(SourceDataLine.class,format);
		try
		{
			SDL=(SourceDataLine)AudioSystem.getLine(info);
			SDL.open(format);
		}catch(Exception e){}
		SDL.start();

		int a=0;
		byte[] buffer=new byte[1024];
		try
		{
			while(a!=-1)
			{
				a=AIS.read(buffer,0,buffer.length);
				if(a>=0)
				{
					SDL.write(buffer,0,a);
				}
			}
		}catch(Exception e){}
		finally
		{
			SDL.drain();			//将残留部分处理干净
			SDL.close();
		}		
	}
}