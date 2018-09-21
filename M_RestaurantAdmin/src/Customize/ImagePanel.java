package Customize;
import java.awt.*;
import javax.swing.*;

public class ImagePanel extends JPanel
{
	Image image;
	
	public ImagePanel(Image image)
	{
		this.image=image;
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(width,height);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(image,0,0,this.getWidth(),this.getHeight(),this);
	}
}
