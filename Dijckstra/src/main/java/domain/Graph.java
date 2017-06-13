package domain;

import java.util.ArrayList;

public class Graph {
	private final int[][] gewichtenMatrix;

	public Graph(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
			throw new IllegalArgumentException();
		}

		this.gewichtenMatrix = matrix.clone();
	}

	private int[][] initMatrixDijkstra(int vanKnoop) {
		int[][] res = new int[this.gewichtenMatrix.length + 1][this.gewichtenMatrix.length];
		// eerste rij is rij met kortste lengtes vanuit vanKnoop

		// oefening 3.3

		return res;
	}

	public int[][] Dijkstra(int vanKnoop) {
		int[][] res = initMatrixDijkstra(vanKnoop);
		
		System.out.println("Initiele matrix: \n");
		printIntMatrix(res);
		
		// oefening 3.4

		return res;
	}

	private ArrayList<Integer> vindPad(int vanKnoop, int naarKnoop, int[][] res) {
		ArrayList<Integer> pad = new ArrayList<>();
		// oefening 3.5
		return pad;
	}

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
