package numericMethod;

import java.io.IOException;

import core.Polynominal;
import core.Program;
import core.Tools;

public class CalculatingPolynominalIntegralUsingTrapeziods extends NumericalMethod
{

	// TODO refactor + obsługa wyjątków
	@Override
	public void begin() throws IOException
	{
		Program.print("--------------------------------------------");
		
		double
			a = Tools.requestDouble("Beginning of the integration interval: "),
			b = Tools.requestDouble("End of the integration interval: "),
			sum = 0,
			delta, 
			x;
	
		int
			n = Tools.requestInteger("Number of intervals: ");
		    
			System.out.print("Function: ");
			Polynominal polynominal = Tools.createPolynominalFromInputLine(
					"Write down the numbers standing next to the powers of x in the descending order,\n"
				+	"down to the one next to x^0. (for example, y = x^2 + 2x + 3 would be written down as '1 2 3')\n"
				+	"Use the \"SPACE\" key between each pair of numbers.\n"
		   );
		    
			Program.print("--------------------------------------------");
		    
			delta = (b - a) / n;
			
			for (int i = 0; i < n; i++) {
				x = a + delta * i;
		      sum = sum + delta * (polynominal.valueAtX(x) + polynominal.valueAtX(x + delta)) / 2;
			}
			
		   Program.print( "Area of integrate is: %f",  sum );
		   
			Program.print("--------------------------------------------");
	}

}
