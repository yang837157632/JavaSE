import java.awt.*;
import javax.swing.*;

public class G_2Button extends JFrame
{
	JButton b=null;						//把需要的组件全部在这里定义
	
	public static void main(String[] args)
	{
		new G_2Button();				//主函数只需调用即可
	}
	
	G_2Button()
	{									//把初始化的全部工作放到构造函数中
		this.setTitle("GUI");			//设置窗口标题
		this.setSize(400,300);			//设置窗口大小
		this.setLocation(350,250);		//设置窗口位置
		b=new JButton("Button");		//设置组件
		this.add(b);					//添加组件
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
