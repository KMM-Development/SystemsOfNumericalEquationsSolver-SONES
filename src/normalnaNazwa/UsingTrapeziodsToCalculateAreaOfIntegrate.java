package normalnaNazwa;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import core.Polynominal;
import core.Program;

public class UsingTrapeziodsToCalculateAreaOfIntegrate extends NormalnaNazwa
{

	// TODO refactor + obsługa wyjątków
	@Override
	public void begin()
	{
		try 
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
		    Program.print( "Area of integrate is: %f",  sum );
		}
		catch(Exception e)
		{
			Program.print("Ding dong something's wrong.");
			e.printStackTrace();
		}
	}

}
