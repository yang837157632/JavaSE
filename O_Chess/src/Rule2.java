
public class Rule2 {
	ChessMan[][] ChessMen;
	boolean canMove;
	int i,j;
	
	public Rule2(ChessMan[][] ChessMen)
	{
		this.ChessMen=ChessMen;
	}
	
	public boolean canMove(int startI,int startJ,int endI,int endJ,String name)
	{
		canMove=false;
		int maxI,minI,maxJ,minJ;
		if(startI>startJ)
		{
			maxI=startI;
			minI=endI;
		}else
		{
			maxI=endI;
			minI=startI;
		}
		if(startJ>endJ)
		{
			maxJ=startJ;
			minJ=endJ;
		}else
		{
			maxJ=endJ;
			minJ=startJ;
		}
		if(name.equals("Ü‡"))
		{
			this.ju(maxI, minI, maxJ, minJ);
		}
		if(name.equals("ñR"))
		{
			this.ma(maxI, minI, maxJ, minJ, startI, endI, startJ, endJ);
		}
		if(name.equals("Ïà"))
		{
			this.xiang1(maxI, minI, maxJ, minJ, startI, endI, startJ, endJ);
		}
		if(name.equals("Ïó"))
		{
			this.xiang2(maxI, minI, maxJ, minJ, startI, endI, startJ, endJ);
		}
		if((name.equals("ÊË"))||(name.equals("Ê¿")))
		{
			this.shi(maxI, minI, maxJ, minJ, startI, endI, startJ, endJ);
		}
		if((name.equals("Ž›"))||(name.equals("Œ¢")))
		{
			this.jiang(maxI, minI, maxJ, minJ, startI, endI, startJ, endJ);
		}
		if((name.equals("ÅÚ"))||(name.equals("³h")))
		{
			this.pao(maxI, minI, maxJ, minJ, startI, endI, startJ, endJ);
		}
		if(name.equals("±ø"))
		{
			this.bing(maxI, minI, maxJ, minJ, startI, endI, startJ, endJ);
		}
		if(name.equals("×ä"))
		{
			this.zu(maxI, minI, maxJ, minJ, startI, endI, startJ, endJ);
		}
		
		return canMove;
	}
	
	public void ju(int maxI,int minI,int maxJ,int minJ)
	{
		if(maxI==minI)
		{
			int count=0;
			for(int j=minJ+1;j<maxJ;j++)
			{
				if(ChessMen[maxI][j]!=null)
				{
					count =1;
					break;
				}
			}
			if(count==0)
			{
				canMove=true;
			}
		}
		if(maxJ==minJ)
		{
			int count=0;
			for(int i=minI+1;i<maxI;i++)
			{
				if(ChessMen[i][maxJ]!=null)
				{
					count=1;
					break;
				}
			}
			if(count==0)
			{
				canMove=true;
			}
		}
	}
	
	public void ma(int maxI,int minI,int maxJ,int minJ,int startI,int endI,int startJ,int endJ)
	{
		int a=maxI-minI;
		int b=maxJ-minJ;
		if(a==1&&b==2)
		{
			if(startJ<endJ)
			{
				if(ChessMen[startI][startJ+1]==null)
				{
					canMove=true;
				}
			}else
			{
				if(ChessMen[startI][startJ-1]==null)
				{
					canMove=true;
				}
			}
		}
		if(a==2&&b==1)
		{
			if(startI<endI)
			{
				if(ChessMen[startI+1][startJ]==null)
				{
					canMove=true;
				}
			}else
			{
				if(ChessMen[startI-1][startJ]==null)
				{
					canMove=true;
				}
			}
		}
	}
	
	public void xiang1(int maxI,int minI,int maxJ,int minJ,int startI,int endI,int startJ,int endJ)
	{
		int a=maxI-minI;
		int b=maxJ-minJ;
		if(a==2&&b==2)
		{
			if(ChessMen[(maxI+minI)/2][(maxJ+minJ)/2]==null)
			{
				if(endJ<=4)
				{
					canMove=true;
				}
			}
		}
	}
	
	public void xiang2(int maxI,int minI,int maxJ,int minJ,int startI,int endI,int startJ,int endJ)
	{
		int a=maxI-minI;
		int b=maxJ-minJ;
		if(a==2&&b==2)
		{
			if(ChessMen[(maxI+minI)/2][(maxJ+minJ)/2]==null)
			{
				if(endJ>=5)
				{
					canMove=true;
				}
			}
		}
	}
	
	public void shi(int maxI,int minI,int maxJ,int minJ,int startI,int endI,int startJ,int endJ)
	{
		int a=maxI-minI;
		int b=maxJ-minJ;
		if(a==1&&b==1)
		{
			if(startI>=3&&startI<=5&&endI>=3&&endJ<=5)
			{
				if(startJ<=2&&endJ<=2)
				{
					canMove=true;
				}
				if(startJ>=7&&endJ>=7)
				{
					canMove=true;
				}
			}
		}
	}
	
	public void jiang(int maxI,int minI,int maxJ,int minJ,int startI,int endI,int startJ,int endJ)
	{
		int a=maxI-minI;
		int b=maxJ-minJ;
		if((a==0&&b==1)||(a==1&&b==0))
		{
			if(startI>=3&&startI<=5&&endI>=3&&endJ<=5)
			{
				if(startJ<=2&&endJ<=2)
				{
					canMove=true;
				}
				if(startJ>=7&&endJ>=7)
				{
					canMove=true;
				}
			}
		}
	}
	
	public void pao(int maxI,int minI,int maxJ,int minJ,int startI,int endI,int startJ,int endJ)
	{
		if(minI==maxI)
		{
			if(ChessMen[endI][endJ]==null)
			{
				int count=0;
				for(int j=minJ+1;j<maxJ;j++)
				{
					if(ChessMen[maxI][j]!=null)
					{
						count=1;
						break;
					}
				}
				if(count==0)
				{
					canMove=true;
				}
			}else
			{
				int count =0;
				for(int j=minJ+1;j<maxJ;j++)
				{
					if(ChessMen[maxI][j]!=null)
					{
						count++;
					}
				}
				if(count==1)
				{
					canMove=true;
				}
			}
		}
		if(minJ==maxJ)
		{
			if(ChessMen[endI][endJ]==null)
			{
				int count=0;
				for(int i=minI+1;i<maxI;i++)
				{
					if(ChessMen[i][maxJ]!=null)
					{
						count=1;
						break;
					}
				}
				if(count==0)
				{
					canMove=true;
				}
			}else
			{
				int count =0;
				for(int i=minI+1;i<maxI;i++)
				{
					if(ChessMen[i][maxJ]!=null)
					{
						count++;
					}
				}
				if(count==1)
				{
					canMove=true;
				}
			}
		}
	}
	
	public void bing(int maxI,int minI,int maxJ,int minJ,int startI,int endI,int startJ,int endJ)
	{
		int a=maxI-minI;
		int b=maxJ-minJ;
		if(startJ<=4)
		{
			if(a==0&&(startJ+1)==endJ)
			{
				canMove=true;
			}
		}else
		{
			if(a==0&&(startJ+1)==endJ)
			{
				canMove=true;
			}
			if(a==1&&b==0)
			{
				canMove=true;
			}
		}
	}
	
	public void zu(int maxI,int minI,int maxJ,int minJ,int startI,int endI,int startJ,int endJ)
	{
		int a=maxI-minI;
		int b=maxJ-minJ;
		if(startJ>=5)
		{
			if(a==0&&(startJ-1)==endJ)
			{
				canMove=true;
			}
		}else
		{
			if(a==0&&(startJ-1)==endJ)
			{
				canMove=true;
			}
			if(a==1&&b==0)
			{
				canMove=true;
			}
		}
	}
	
}
