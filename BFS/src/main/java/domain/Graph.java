package domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
	private final boolean[][] verbindingsMatrix;
	public static final int infty = Integer.MAX_VALUE;

	public Graph(int[][] matrix) {
		if (!isGeldigeVerbindingsMatrix(matrix))
			throw new IllegalArgumentException("No valid nabijheidsmatrix");

		this.verbindingsMatrix = new boolean[matrix.length][matrix.length];
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix.length; j++)
				this.verbindingsMatrix[i][j] = matrix[i][j] == 1;
	}

	private boolean isGeldigeVerbindingsMatrix(int[][] matrix) {
		// als de matrix niet vierkant is of null
		if (matrix == null || matrix.length != matrix[0].length)
			return false;
		// Verbindingsmatrix moet overal 0 zijn op de diagonaal
		for (int i = 0; i < matrix.length; i++)
			if (matrix[i][i] != 0)
				return false;
		//Het is een niet gerichte graaf dus rij-kolom moet gelijk zijn aan kolom-rij
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix.length; j++)
				if (matrix[i][j] != 0 && matrix[i][j] != 1)
					return false;
		return true;
	}

	private int getAantalKnopen() {
		return this.verbindingsMatrix.length;
	}



	private boolean isRechtStreekseVerbinding(int huidige, int i) {
		return (verbindingsMatrix[i-1][huidige-1]);

	}

    private int[] findAncestors(int start, int destination) {
        int aantalKnopen = this.getAantalKnopen();
        int[] ancestors = new int[aantalKnopen]; initArray(ancestors, infty);
        Queue<Integer> queue = new LinkedList<>(); queue.add(start);
        ancestors[start - 1] = 0;
        int huidig = queue.remove();

        while (huidig != destination) {
            //zoek alle nog niet bezochte knooppunten vanuit huidig
            for (int i = 1; i <= aantalKnopen; i++) {
                if (isRechtStreekseVerbinding(huidig, i) && (ancestors[i - 1] == infty)) {
                    queue.add(i);
                    //duid aan dat huidig de ouder is van i in ancestormatrix
                    ancestors[i - 1] = huidig;
                }
            }
            if (!queue.isEmpty()) {
                huidig = queue.remove(); //of .poll() wat geen exception gooit
            } else {
                break;
            }
        }
        return ancestors;
    }

    public List<Integer> findPath(int start, int destination) {
        if (start <= 0 || start > this.getAantalKnopen() || destination <= 0 || destination > this.getAantalKnopen())
            throw new IllegalArgumentException();

        int[] ancestors = this.findAncestors(start, destination); List<Integer> path = new LinkedList<>();
        int ouder = ancestors[destination - 1]; while (ouder != 0 && ouder != infty) {
            path.add(0, destination);;
            destination = ouder;
            ouder = ancestors[destination - 1];
        }
        if (ouder == 0) {
            path.add(0,destination);
        }
        return path;
    }

	private void initArray(int[] array, int value) {
		for (int i = 0; i < array.length; i++)
			array[i] = value;
	}

	
	// methode om tussenliggend resultaat te kunnen schrijven naar het scherm
	public String geefAncestors(int start, int destination) {
		String res = "Ancestors van "+start+" naar "+destination+":\n";
		int[] ancestors = this.findAncestors(start, destination);
		for (int a=0; a<ancestors.length; a++) 
			res += ancestors[a]!=infty ? ancestors[a]:"infty"+" ";
				
		return res;
	}



}
