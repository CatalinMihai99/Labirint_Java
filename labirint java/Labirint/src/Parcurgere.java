import java.util.LinkedList;

public class Parcurgere {
	
	private static class Celula implements Comparable<Celula> {
        int x;
        int y;
        int dist;
        Celula prev;
 
        Celula(int x, int y, int dist, Celula prev) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.prev = prev;
        }
        //apare de la eroarea clasei
		@Override
		public int compareTo(Parcurgere.Celula o) 
		{
			return 0;
		}
 
      
    }
    public static void print (int[][] matrice, int[] start, int[] end) 
    {
	   if (matrice[start[0]][start[1]] ==1 || matrice[end[0]][end[1]] ==1)
		   return;
	   
        Celula[][] Celula_matrice = new Celula[matrice.length][matrice[0].length];
        for (int index = 0; index < Celula_matrice.length; index++) {
            for (int index2 = 0; index2 < Celula_matrice[0].length; index2++) {
                if (matrice[index][index2] != 1) {
                    Celula_matrice[index][index2] = new Celula(index, index2, Integer.MAX_VALUE, null);
                }
            }
        }
      
 
        LinkedList<Celula> coada = new LinkedList<>();
        Celula src = Celula_matrice[start[0]][start[1]];
        src.dist = 0;
        coada.add(src);
        Celula celula_destinatie = null;
        Celula celula_curenta;
        
        while ((celula_curenta = coada.poll()) != null) {
            if (celula_curenta.x==end[0] && celula_curenta.y == end[1]) {
                celula_destinatie = celula_curenta;
            }
            visit(Celula_matrice, coada, celula_curenta.x - 1, celula_curenta.y, celula_curenta);
            visit(Celula_matrice, coada, celula_curenta.x + 1, celula_curenta.y, celula_curenta);
            visit(Celula_matrice, coada, celula_curenta.x, celula_curenta.y - 1, celula_curenta);
            visit(Celula_matrice, coada, celula_curenta.x, celula_curenta.y + 1, celula_curenta);
        }
        if (celula_destinatie == null) {
            return;
        } else {
        	
            LinkedList<Celula> path = new LinkedList<>();
            
            celula_curenta = celula_destinatie;
            do {
                path.addFirst(celula_curenta);
               
            } while ((celula_curenta = celula_curenta.prev) != null);
            
            for(int p=1;p<path.size()-1;p++)
    		{
    	     Celula z=path.get(p);
    		matrice[z.x][z.y]=4;
    		
    		}
         
        }
    }
 
    static void visit(Celula[][] Celula_matrice, LinkedList<Celula> coada, int x, int y, Celula parent) {
        int dist = parent.dist + 1;
        if (x < 0 || x >= Celula_matrice.length || y < 0 || y >= Celula_matrice[0].length || Celula_matrice[x][y] == null) {
            return;
        }
        Celula celula_curenta = Celula_matrice[x][y];
        if (dist < celula_curenta.dist) {
            celula_curenta.dist = dist;
            celula_curenta.prev = parent;
            coada.add(celula_curenta);
        }
       
    }
}


