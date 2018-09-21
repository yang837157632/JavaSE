import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class J_5MouseListener extends JFrame
{
	MyPanel5 MP=null;
	
	public static void main(String[] args)
	{
		new J_5MouseListener();
	}
	
	public J_5MouseListener()
	{
		MP=new MyPanel5();
		this.add(MP);
		this.addMouseListener(MP);
		this.addKeyListener(MP);
		this.addMouseMotionListener(MP);
		this.setSize(400,300);
		this.setLocation(300,280);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}

 class MyPanel5 extends JPanel implements MouseListener,KeyListener,MouseMotionListener
 {
	 //Jpanel
	 public void paint(Graphics g)
	 {
		 super.paint(g);
	 }
	 
	 //MouseListener
	 public void mouseClicked(MouseEvent e)
	 {
		 System.out.println("鼠标点击的位置是： ");
		 System.out.println("横坐标：\t"+e.getX());
		 System.out.println("纵坐标：\t"+e.getY());
	 }
	 
	 public void mousePressed(MouseEvent e)
	 {
//		 System.out.println("鼠标被按下");
	 }
	 
	 public void mouseReleased(MouseEvent e)
	 {
//		 System.out.println("鼠标被松开");
	 }
	 
	 public void mouseEntered(MouseEvent e)
	 {
//		 System.out.println("鼠标移动到界面中");
	 }
	 
	 public void mouseExited(MouseEvent e)
	 {
//		 System.out.println("鼠标离开界面");
	 }
	 
	 //KeyListener
	 public void keyTyped(KeyEvent e){}
	 
	 public void keyPressed(KeyEvent e)
	 {
		 System.out.println(e.getKeyChar()+"被按下");
	 }
	 
	 public void keyReleased(KeyEvent e){}
	 
	 //MouseMotionListener
	 public void mouseDragged(MouseEvent e)
	 {
//		 System.out.println("鼠标当前位置是：");
//		 System.out.println("横坐标：\t"+e.getX());
//		 System.out.println("纵坐标：\t"+e.getY());
	 }
	 
	 public void mouseMoved(MouseEvent e)
	 {
//		 System.out.println("鼠标当前位置是：");
//		 System.out.println("横坐标：\t"+e.getX());
//		 System.out.println("纵坐标：\t"+e.getY());
	 }
 }