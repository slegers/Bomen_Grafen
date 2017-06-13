package domain;

import java.util.List;

public class Graph {
	private final boolean [][] verbindingsMatrix ;
	
	public static final int infty = Integer.MAX_VALUE ;
	
	public Graph (int [][] matrix ) {
		if (! isGeldigeVerbindingsMatrix ( matrix ))
			throw new IllegalArgumentException ( " No valid nabijheidsmatrix " );
	
		this.verbindingsMatrix = new boolean [ matrix . length ][ matrix . length ];
	
		for ( int i = 0; i < matrix . length ; i ++)
			for ( int j = 0; j < matrix . length ; j ++)
				this . verbindingsMatrix [ i ][ j ] = matrix [ i ][ j ] == 1;
	}
	
	private boolean isGeldigeVerbindingsMatrix (int [][] matrix ) {
		if ( matrix == null || matrix . length != matrix [0]. length )
			return false ;
		for ( int i = 0; i < matrix . length ; i ++)
			if ( matrix [ i ][ i ] != 0)
				return false ;
	
		for ( int i = 0; i < matrix . length ; i ++)
			for ( int j = 0; j < matrix . length ; j ++)
				if ( matrix [ i ][ j ] != 0 && matrix [ i ][ j ] != 1)
					return false ;
	return true ;
	}
	
	private int getAantalKnopen () {
	return this.verbindingsMatrix.length;
	}
	
	public boolean isPad(List<Integer> lpad) {
		if(lpad.size() == 1){
			return false;
		}else{
			int ini = lpad.remove(0);
			if(ini > getAantalKnopen()){
				return false;
			}
			while(!lpad.isEmpty()){
				int sec = lpad.remove(0);
				if(sec > getAantalKnopen()){
					return false;
				}
				if(!verbindingsMatrix[ini-1][sec-1]){
					return false;
				}
				ini = sec;
			}
			return true;

		}
	}

}
