package domain;

import java.util.ArrayList;

public class GraphOplossing {
	private final int[][] gewichtenMatrix;

	public GraphOplossing(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
			throw new IllegalArgumentException();
		}

		this.gewichtenMatrix = matrix.clone();
	}

	private int[][] initMatrixDijkstra(int vanKnoop) {
		int[][] res = new int[this.gewichtenMatrix.length + 1][this.gewichtenMatrix.length];
		//initialiseer alle getallen op eerste rij nu op een grote waarde
		// omdat de kortste afstanden nog niet gevonden zijn
		for (int i = 0; i < this.gewichtenMatrix.length; i++)
			res[0][i] = Integer.MAX_VALUE;
		for (int i = 1; i <= this.gewichtenMatrix.length; i++) {
			for (int j = 0; j < this.gewichtenMatrix.length; j++) {
				if (this.gewichtenMatrix[i - 1][j] == Integer.MAX_VALUE){
					res[i][j] = 0;
				}
				else{
					res[i][j] = this.gewichtenMatrix[i - 1][j];
				}
			}
		}

		for (int i = 0; i < this.gewichtenMatrix.length; i++) {
			res[i][vanKnoop - 1] = 0;
		}
		return res;
	}

	public int[][] Dijkstra(int vanKnoop) {
		int[][] res = initMatrixDijkstra(vanKnoop);
		System.out.println("Initiele matrix: \n");
		printIntMatrix(res);
		boolean ok = false; while (!ok) {
			int indexKleinsteJ = 0;
			int indexKleinsteI = 0;
			int kleinste = Integer.MAX_VALUE;
			for (int i = 0; i < this.gewichtenMatrix.length; i++) {
				if (res[0][i] != Integer.MAX_VALUE) {
				// doorzoek alle knopen waar nog geen kortste pad voor werd
				// gevonden en die bereikbaar zijn uit knopen waar reeds korste pad voor
					// werd gevonden en zoek hierin de kleinste afstand
				for (int j = 0; j < this.gewichtenMatrix.length; j++) {
					if (res[i + 1][j] != 0 && res[0][j] == Integer.MAX_VALUE)
						if (res[0][i] + res[i + 1][j] < kleinste) {
							indexKleinsteJ = j;
							indexKleinsteI = i + 1;
							kleinste = res[0][i] + res[i + 1][j];
						}
					}
				}
			}
			if (kleinste == Integer.MAX_VALUE) {
				ok = true;
			} else {
				res[0][indexKleinsteJ] = kleinste;
				for (int i = 1; i <= this.gewichtenMatrix.length; i++)
					if (i != indexKleinsteI){
					res[i][indexKleinsteJ] = 0;
					}
			}
		}
		return res;
	}

	private ArrayList<Integer> vindPad(int vanKnoop, int naarKnoop, int[][] res) {
		ArrayList<Integer> pad = new ArrayList<>();
		pad.add(naarKnoop);
		while (naarKnoop != vanKnoop) {
			int k = 1;
			while (k < res.length && res[k][naarKnoop - 1] == 0)
				k++;
			pad.add(0, k);
			naarKnoop = k;
		}
		return pad; }

	public String berekenPaden(int vanKnoop) {
		String uit = "";
		int[][] res = this.Dijkstra(vanKnoop);

		System.out.println("Resulterende matrix: \n");
		printIntMatrix(res);
		
		for (int i = 0; i < res[0].length; i++) {
			if ((i + 1) != vanKnoop) {
				if (res[0][i] == Integer.MAX_VALUE) {
					uit += "Er is geen pad van " + vanKnoop + " naar " + (i + 1) + "\n";
				} else {
					uit += "Kortste afstand van " + vanKnoop + " naar " + (i + 1) + " = " + res[0][i] + "\n";
					uit += "via ";

					int j = (i + 1);
					ArrayList<Integer> pad = vindPad(vanKnoop, j, res);
					uit += pad + "\n";
				}
			}
		}
		return uit;
	}
	
	private static void printIntMatrix(int[][] matrix) {
		String result ="";
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				result += (matrix[i][j] == Integer.MAX_VALUE ? "inf" : matrix[i][j]) + "\t";
			}
			result += "\n";
		}
		result += "\n";
		
		System.out.println(result);		
	}

}
