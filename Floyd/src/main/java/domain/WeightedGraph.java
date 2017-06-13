package domain;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {
	private final double[][] gewichtenMatrix;
	public final static double infty = Double.POSITIVE_INFINITY;

	public WeightedGraph(double[][] matrix) {
		if (matrix == null || matrix.length != matrix[0].length)
			throw new IllegalArgumentException("No valid gewichtenmatrix");
		this.gewichtenMatrix = matrix;
	}

	public int[][] findDistances() {
		int[][] path = new int[this.gewichtenMatrix.length][this.gewichtenMatrix.length];
		/*double[][] distanceMatrix = new double[this.gewichtenMatrix.length][this.gewichtenMatrix.length];
		for (int i = 0; i < this.gewichtenMatrix.length; i++) {
			for (int j = 0; j < this.gewichtenMatrix.length; j++) {
				distanceMatrix[i][j] = this.gewichtenMatrix[i][j];
			}
		}
		*/
		double[][] D = this.gewichtenMatrix.clone();
		for (int i = 0; i < D.length; i++) {
			D[i] = D[i].clone();
		}
		int aantal = gewichtenMatrix.length;
		for (int k = 0; k < aantal; k++) {
			for (int i = 0; i < aantal; i++) {
				for (int j = 0; j < aantal; j++) {
					if (D[i][k] + D[k][j] < D[i][j]) {
						D[i][j] = D[i][k] + D[k][j];
						path[i][j] = k + 1;
					}
				}
			}
		}



		// oefening 2.3

		return path;
	}

	public List<Integer> getShortestPath(int van, int tot, int[][] P) {
		List<Integer> pad = new ArrayList<>();
		if (van == tot) {
			return pad;
		} else {
			int via = P[van - 1][tot - 1]; if (via == 0){
				pad.add(van);
				pad.add(tot); } else {
				pad = getShortestPath(van, via, P);
				pad.remove(pad.size() - 1); //anders dubbel
				pad.addAll(getShortestPath(via, tot, P));
			}
		}

		return pad;

	}

	public int berekenLengte(List<Integer> pad) {
		int som = 0;
		int aantalKnopen = pad.size();
		int huidigeKnoop, volgendeKnoop;
		for (int i = 0; i < aantalKnopen - 1; i++) {
			huidigeKnoop = pad.get(i);
			volgendeKnoop = pad.get(i + 1);
			som += this.gewichtenMatrix[huidigeKnoop - 1][volgendeKnoop - 1];
		}
		return som;
	
		// oefening 2.5
	}

}
