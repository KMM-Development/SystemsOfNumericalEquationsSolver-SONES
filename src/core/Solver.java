package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solver
{
	
	// TODO refactor + security plz
	public static void calculateAreaOfIntegrateUsingTrapezoids() throws NumberFormatException, IOException
	{
	    double delta, a, b, x;
	    int n;
	    double sum = 0;
	    Program.print("--------------------------------------------");
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    System.out.print("Beginning of the integration interval: ");
	    a = Double.parseDouble(br.readLine());

	    System.out.print("End of the integration interval: ");
	    b = Double.parseDouble(br.readLine());

	    System.out.print("Number of intervals: ");
	    n = Integer.parseInt(br.readLine());
	    
	    System.out.print("Function: ");
	    Polynominal polynominal = Polynominal.simpleInterpret(br.readLine());
	    
	    Program.print("--------------------------------------------");
	    
	    delta = (b - a) / n;
	    for (int i = 0; i < n; i++) {
	        x = a + delta * i;
	        sum = sum + delta * (polynominal.valueAtX(x) + polynominal.valueAtX(x + delta)) / 2;
	    }
	    Program.print( "Area of integrate is: %f",  sum);
	}
	
	// TODO obsługa wpisywania macierzy (+ wyjątki) [bo samo liczenie już mamy]
	
	// TODO układ równań liniowych
	
	// TODO znajdowanie pierwiastków metodą siecznych
	
	// TODO znajdowanie pierwiastków metodą Newtona

}
