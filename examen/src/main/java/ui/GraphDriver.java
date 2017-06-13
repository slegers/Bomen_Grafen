package ui;

import java.util.ArrayList;
import java.util.List;

import domain.Graph;

public class GraphDriver {
	public static void main ( String [] args ) {
		int data [][] = { { 0 , 1 , 0 , 1 , 0 , 0 , 0 } ,
		{ 0 , 0 , 1 , 0 , 0 , 0 , 0 } ,
		{ 1 , 0 , 0 , 1 , 1 , 0 , 0 } ,
		{ 0 , 0 , 0 , 0 , 1 , 1 , 0 } ,
		{ 0 , 1 , 0 , 0 , 0 , 0 , 1 } ,
		{ 0 , 0 , 0 , 0 , 1 , 0 , 0 } ,
		{ 0 , 0 , 0 , 0 , 0 , 1 , 0 } };
		Graph g = new Graph ( data );
		int [] pad1 = {1 ,2 ,3 ,5 ,2};
		
		List<Integer> lpad1 = new ArrayList<>();
		for ( int i : pad1 ) 
			lpad1.add ( i );
		
		System.out.println ( lpad1 + " : " + g.isPad( lpad1 ));
		int [] pad2 = {1 ,2 ,3 ,5 ,3};
		List<Integer> lpad2 = new ArrayList<>();
		
		for ( int i : pad2 ) 
			lpad2.add ( i );
		System.out.println ( lpad2 + " : " + g.isPad( lpad2 ));
		
		
		List<Integer> lpad3 = new ArrayList<>();
		lpad3 . add (1);
		System.out.println ( lpad3 + " : " + g.isPad(lpad3));
		
		
		List<Integer> lpad4 = new ArrayList<>();
		lpad4.add (1);
		lpad4.add (8);
		lpad4.add (2);
		System.out.println ( lpad4 + " : " + g.isPad( lpad4 ));
	
		}
}
