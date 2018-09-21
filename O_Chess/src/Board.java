import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Board extends JPanel implements MouseListener
{
	private int width;
	boolean focus=false;
	int jiang_i=4;
	int jiang_j=9;
	int shuai_i=4;
	int shuai_j=0;
	int startI=-1;
	int startJ=-1;
	int endI=-1;
	int endJ=-1;
	ChessMan[][] ChessMen;
	Chess chess;
	Rule rule;

	public Board(ChessMan[][] ChessMen,int width,Chess chess)
	{
		this.chess=chess;
		this.width=width;
		this.ChessMen=ChessMen;
		rule=new Rule(ChessMen);
		this.setBounds(0,0,700,700);
		this.setLayout(null);
		this.addMouseListener(this);
	}

	public void paint(Graphics g1)
	{
		Graphics2D g=(Graphics2D)g1;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		Color c=g.getColor();
		g.setColor(Chess.bgColor);
		g.fill3DRect(60, 30, 580, 630, false);
		g.setColor(Color.BLACK);
		for(int j=80;j<=620;j=j+width)//绘制横线
		{
			g.drawLine(110, j, 590, j);
		}
		g.drawLine(110,80,110,620);
		g.drawLine(590,80,590,620);
		for(int i=170;i<=530;i=i+width)//绘制竖线
		{
			g.drawLine(i,80,i,320);
			g.drawLine(i,380,i,620);
		}
		g.drawLine(290, 80, 410, 200);//绘制交叉线
		g.drawLine(290, 200, 410, 80);
		g.drawLine(290, 500, 410, 620);
		g.drawLine(290, 620, 410, 500);
		this.smallLine(g,1,2);//红炮
		this.smallLine(g,7,2);//红炮
		this.smallLine(g,0,3);//红兵兵
		this.smallLine(g,2,3);
		this.smallLine(g,4,3);
		this.smallLine(g,6,3);
		this.smallLine(g,8,3);
		this.smallLine(g,0,6);//绿卒
		this.smallLine(g,2,6);
		this.smallLine(g,4,6);
		this.smallLine(g,6,6);
		this.smallLine(g,8,6);
		this.smallLine(g,1,7);//绿炮
		this.smallLine(g,7,7);
		g.setFont(new Font("新宋体",Font.BOLD,50));
		g.drawString("楚 河", 170, 365);
		g.drawString("漢 界", 400, 365);
		Font font=new Font("宋体",Font.BOLD,30);
		g.setFont(font);
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<10;j++)
			{
				if(ChessMen[i][j]!=null)  
				{
					if(this.ChessMen[i][j].getFocus()==true)
					{
						g.setColor(Chess.bgColor);
						g.fillOval(110+i*60-25,80+j*60-25,50,50);
						g.setColor(Chess.focuschar);
					}else
					{
						g.fillOval(110+i*60-25,80+j*60-25,50,50);
						g.setColor(ChessMen[i][j].getColor());
					}
					g.drawString(ChessMen[i][j].getName(),110+i*60-15,80+j*60+10);
					g.setColor(Color.BLACK);
				}
			}
		}
		g.setColor(c);
	}

	public void mouseClicked(MouseEvent e)
	{
		if(this.chess.kaiPan==true)
		{
			int i=-1,j=-1;
			int[] pos=getPos(e);
			i=pos[0];
			j=pos[1];
			if(i>=0&&i<=8&&j>=0&&j<=9)
			{
				if(focus==false)
				{
					this.noFocus(i,j);
				}else
				{
					if(ChessMen[i][j]!=null)
					{
						if(ChessMen[i][j].getColor()==ChessMen[startI][startJ].getColor())
						{
							ChessMen[startI][startJ].setFocus(false);
							ChessMen[i][j].setFocus(true);
							startI=i;
							startJ=j;
						}else
						{
							endI=i;
							endJ=j;
							String name=ChessMen[startI][startJ].getName();
							boolean canMove=rule.canMove(startI, startJ, endI, endJ, name);
							if(canMove)
							{
								try
								{
									this.chess.cat.DOS.writeUTF("<#MOVE#>"+this.chess.cat.challenger+startI+startJ+endI+endJ);
									focus=false;
									if(ChessMen[endI][endJ].getName().equals("帥")||ChessMen[endI][endJ].getName().equals("將"))
									{
										this.success();
									}else
									{
										this.noJiang();
									}
								}catch(Exception ee)
								{ 
									ee.printStackTrace();
								}
							}
						}
					}else
					{
						endI=i;
						endJ=j;
						String name=ChessMen[startI][startJ].getName();
						boolean canMove=rule.canMove(startI, startJ, endI, endJ, name);
						if(canMove)
						{
							try
							{
								this.chess.cat.DOS.writeUTF("<#MOVE#>"+this.chess.cat.challenger+startI+startJ+endI+endJ);
								focus=false;
								this.noChessMan();
							}catch(Exception ee)
							{ 
								ee.printStackTrace();
							}
						}
					}
				}
			}
			this.chess.repaint();
		}
	}

	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

	public int[] getPos(MouseEvent e)
	{
		int[] pos=new int[2];
		pos[0]=-1;
		pos[1]=-1;
		Point p=e.getPoint();
		double x=p.getX();
		double y=p.getY();
		if(Math.abs((x-110)/1%60)<=25)
		{
			pos[0]=Math.round((float)(x-110))/60;
		}else if(Math.abs((x-110)/1%60)>=35)
		{
			pos[0]=Math.round((float)(x-110))/60+1;
		}
		if(Math.abs((y-80)/1%60)<=25)
		{
			pos[1]=Math.round((float)(y-80))/60;
		}else if(Math.abs((y-80)/1%60)>=35)
		{
			pos[1]=Math.round((float)(y-80))/60+1;
		}
		return pos;
	}

	public void noFocus(int i,int j)
	{
		if(this.ChessMen[i][j]!=null)
		{
			if(this.chess.color==0)
			{
				if(this.ChessMen[i][j].getColor().equals(Chess.color1))
				{
					this.ChessMen[i][j].setFocus(true);
					focus=true;
					startI=i;
					startJ=j;
				}
			}else
			{
				if(this.ChessMen[i][j].getColor().equals(Chess.color2))
				{
					this.ChessMen[i][j].setFocus(true);
					focus=true;
					startI=i;
					startJ=j;
				}
			}
		}
	}

	public void success()
	{
		ChessMen[endI][endJ]=ChessMen[startI][startJ];
		ChessMen[startI][startJ]=null;
		this.chess.repaint();
		JOptionPane.showMessageDialog(this.chess,"恭喜你，您获胜了","提示",JOptionPane.INFORMATION_MESSAGE);
		this.chess.next();
		this.chess.host.setEnabled(false);
		this.chess.port.setEnabled(false);
		this.chess.nickname.setEnabled(false);
		this.chess.ConnectB.setEnabled(false);
		this.chess.DisconnectB.setEnabled(true);
		this.chess.ChallengeB.setEnabled(true);
		this.chess.AcceptB.setEnabled(false);
		this.chess.RefuseB.setEnabled(false);
		this.chess.SurrenderB.setEnabled(false);
		jiang_i=4;
		jiang_j=9;
		shuai_i=4;
		shuai_j=0;
		startI=-1;
		startJ=-1;
		endI=-1;
		endJ=-1;
	}

	public void noJiang()
	{
		ChessMen[endI][endJ]=ChessMen[startI][startJ];
		ChessMen[startI][startJ]=null;
		ChessMen[endI][endJ].setFocus(false);
		this.chess.repaint();
		if(ChessMen[endI][endJ].getName().equals("帥"))
		{
			shuai_i=endI;
			shuai_j=endJ;
		}
		if(ChessMen[endI][endJ].getName().equals("將"))
		{
			jiang_i=endI;
			jiang_j=endJ;
		}
		if(jiang_i==shuai_i)
		{
			int count=0;
			for(int j=shuai_j+1;j<jiang_j;j++)
			{
				if(ChessMen[jiang_i][j]!=null)
				{
					count++;
					break;
				}
			}
			if(count==0)
			{
				JOptionPane.showMessageDialog(this.chess,"照将！！！你失败了!!!","提示",JOptionPane.INFORMATION_MESSAGE);
				this.chess.next();
				this.chess.host.setEnabled(false);
				this.chess.Port.setEnabled(false);
				this.chess.nickname.setEnabled(false);
				this.chess.ConnectB.setEnabled(false);
				this.chess.DisconnectB.setEnabled(true);
				this.chess.ChallengeB.setEnabled(true);
				this.chess.AcceptB.setEnabled(false);
				this.chess.RefuseB.setEnabled(false);
				this.chess.SurrenderB.setEnabled(false);
				shuai_i=4;
				shuai_j=0;
				jiang_i=4;
				jiang_j=9;
			}else
			{
				this.chess.tip.setText("对方移动中");
				this.chess.kaiPan=false;
			}
		}else
		{
			this.chess.tip.setText("对方移动中");
			this.chess.kaiPan=false;
		}
		startI=-1;
		startJ=-1;
		endI=-1;
		endJ=-1;
	}

	public void noChessMan()
	{
		try
		{
			ChessMen[endI][endJ]=ChessMen[startI][startJ];
			ChessMen[startI][startJ]=null;
			ChessMen[endI][endJ].setFocus(false);
			this.chess.repaint();
			if(ChessMen[endI][endJ].getName().equals("帥"))
			{
				shuai_i=endI;
				shuai_j=endJ;
			}
			if(ChessMen[endI][endJ].getName().equals("將"))
			{
				jiang_i=endI;
				jiang_j=endJ;
			}
			if(jiang_i==shuai_i)
			{
				int count=0;
				for(int j=shuai_j+1;j<jiang_j;j++)
				{
					if(ChessMen[jiang_i][j]!=null)
					{
						count++;
						break;
					}
				}
				if(count==0)
				{
					JOptionPane.showMessageDialog(this.chess,"照将！！！你失败了！！！","提示",JOptionPane.INFORMATION_MESSAGE);
					this.chess.next();
					this.chess.host.setEnabled(false);
					this.chess.port.setEnabled(false);
					this.chess.nickname.setEnabled(false);
					this.chess.ConnectB.setEnabled(false);
					this.chess.DisconnectB.setEnabled(true);
					this.chess.ChallengeB.setEnabled(true);
					this.chess.AcceptB.setEnabled(false);
					this.chess.RefuseB.setEnabled(false);
					this.chess.SurrenderB.setEnabled(false);
					jiang_i=4;
					jiang_j=9;
					shuai_i=4;
					shuai_j=0;
				}else
				{
					this.chess.tip.setText("对方移动中");
					this.chess.kaiPan=false;
				}
			}else
			{
				this.chess.tip.setText("对方移动中");
				this.chess.kaiPan=false;
			}
			startI=-1;
			startJ=-1;
			endI=-1;
			endJ=-1;
		}catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}

	public void move(int startI,int startJ,int endI,int endJ)
	{
		if(ChessMen[endI][endJ]!=null&&(ChessMen[endI][endJ].getName().equals("帥")||ChessMen[endI][endJ].getName().equals("將")))
		{
			ChessMen[endI][endJ]=ChessMen[startI][startJ];
			ChessMen[startI][startJ]=null;
			this.chess.repaint();
			JOptionPane.showMessageDialog(this.chess,"很遗憾，你失败了！！！","提示",JOptionPane.INFORMATION_MESSAGE);
			this.chess.next();
			this.chess.host.setEnabled(false);
			this.chess.port.setEnabled(false);
			this.chess.nickname.setEnabled(false);
			this.chess.ConnectB.setEnabled(false);
			this.chess.DisconnectB.setEnabled(true);
			this.chess.ChallengeB.setEnabled(true);
			this.chess.AcceptB.setEnabled(false);
			this.chess.RefuseB.setEnabled(false);
			this.chess.SurrenderB.setEnabled(false);
			jiang_i=4;
			jiang_j=9;
			shuai_i=4;
			shuai_j=0;
		}else
		{
			ChessMen[endI][endJ]=ChessMen[startI][startJ];
			ChessMen[startI][startJ]=null;
			this.chess.repaint();
			if(ChessMen[endI][endJ].getName().equals("帥"))
			{
				shuai_i=endI;
				shuai_j=endJ;
			}
			if(ChessMen[endI][endJ].equals("將"))
			{
				jiang_i=endI;
				jiang_j=endJ;
			}
			if(jiang_i==shuai_i)
			{
				int count=0;
				for(int j=shuai_j+1;j<jiang_j;j++)
				{
					if(ChessMen[jiang_i][j]!=null)
					{
						count++;
						break;
					}
				}
				if(count==0)
				{
					JOptionPane.showMessageDialog(this.chess,"对方照将!!!,你胜利了！！！","提示",JOptionPane.INFORMATION_MESSAGE);
					this.chess.next();
					this.chess.host.setEnabled(false);
					this.chess.port.setEnabled(false);
					this.chess.nickname.setEnabled(false);
					this.chess.ConnectB.setEnabled(false);
					this.chess.DisconnectB.setEnabled(true);
					this.chess.ChallengeB.setEnabled(true);
					this.chess.AcceptB.setEnabled(false);
					this.chess.RefuseB.setEnabled(false);
					this.chess.SurrenderB.setEnabled(false);
					shuai_i=4;
					shuai_j=0;;
					jiang_i=4;
					shuai_j=9;
				}
			}
		}
		this.chess.repaint();
	}

	public void smallLine(Graphics2D g,int i,int j)
	{
		int x=110+60*i;
		int y=80+60*j;
		g.drawLine(x-3, y-3, x-20, y-3);
		g.drawLine(x-3, y-3, x-3, y-20);
		g.drawLine(x+3, y-3, x+20, y-3);
		g.drawLine(x+3, y-3, x+3, y-20);
		g.drawLine(x-3, y+3, x-20, y+3);
		g.drawLine(x-3, y+3, x-3, y+20);
		g.drawLine(x+3, y+3, x+20, y+3);
		g.drawLine(x+3, y+3, x+3, y+20);
	}

}
