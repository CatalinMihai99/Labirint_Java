import java.awt.Color;
import java.util.*;
import java.io.*;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
public class View extends JFrame
{




	/**
	 	* 
	 	*/
	private static final long serialVersionUID = 1L;

	public static int[][] citireFisier() 
	{
		int n,m;
		int[][]aux=null;
		Scanner f;
		try 
		{
			FileReader fisier=new FileReader("Text.txt");
			f=new Scanner(fisier);
			while(f.hasNext())
			{
				n=f.nextInt();
				m=f.nextInt();
				if(n<0 || m<0)
					throw new Exception();
				aux=new int[n][m];
				for(int index=0;index<n;index++)
					for(int index2=0;index2<m;index2++)
						aux[index][index2]=f.nextInt();
			}
			f.close();
		}
	catch(Exception ex) 
	{
		System.out.println("Matricea nu poate contine dimensiune negativa");
	}
	return aux;
	}
	int[][] maze=citireFisier();
	public View()
	{	
		setTitle("Labirint");
		setSize(640,480);
		int[] s= {0,0};
		for(int index=0;index<maze.length;index++)
			for(int index2=0;index2<maze[0].length;index2++)
			{
				if (maze[index][index2]==2)
				{
					s=new int[] {index,index2};
				}
			}
		for(int index=0;index<maze.length;index++)
			for(int index2=0;index2<maze[0].length;index2++)
			{
				if(maze[index][index2]==3)
				{
					int[] e= {index,index2};
					Parcurgere.print(maze, s, e);
				}
			}
	
  	
		}
	@Override
	public void paint(Graphics g){
	super.paint(g);
	g.translate(55, 100);
	
	for(int index=0;index<maze.length;index++)
		for(int index2=0;index2<maze[0].length;index2++)
		{
			Color color;
			switch (maze[index][index2])
			{
				case 1: color=Color.BLACK;break;
				case 2: color=Color.BLUE;break;
				case 3: color=Color.RED;break;
				case 4: color=Color.GREEN;break;
				default: color=Color.WHITE;break;
			}
			g.setColor(color);
			g.fillRect(30*index2, 30*index, 30, 30);
			//g.setColor(Color.YELLOW);
		   // g.drawRect(30*index2, 30*index, 30, 30);
		}
	
	}

	public static void main(String[] args)
	{
	   SwingUtilities.invokeLater(new Runnable()
	   {
		   @Override
		   public void run()
		   {
	   			View view=new View();
	   			view.setVisible(true);
		   }
	   
	   });
	}
}