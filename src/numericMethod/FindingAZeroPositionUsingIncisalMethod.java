package numericMethod;

import java.io.IOException;

import core.Polynominal;
import core.Program;
import core.Tools;

public class FindingAZeroPositionUsingIncisalMethod extends NumericalMethod
{	
	
	@Override
	protected void begin() throws IOException
	{
		double 
			approximationAccuracy = 1e-14,
			x1 = -1,
			x2 = 1,
			xn = 0,
			fn = 0;
		
		int
			maxNumberOfChecks = 100,
			numberOfChecks = 0;
		
		double
			f1,
			f2;
		
		boolean
			resultIsFound = false;
		
		Polynominal polynominal = Tools.createPolynominalFromInputLineWithStandardMessage();
		x1 = Tools.requestDouble("Please provide the starting boundary value of the interval (x1): ");
		x2 = Tools.requestDouble("Please provide the closing boundary value of the interval (x2): ");
		
		f1 = polynominal.valueAtX(x1);
		f2 = polynominal.valueAtX(x2);
		
		while(++numberOfChecks < maxNumberOfChecks)
		{
	        xn = (f1 * x2 - f2 * x1) / (f1 - f2);

	        fn = polynominal.valueAtX(xn);

	        if((Tools.absoluteValueOf(fn) < approximationAccuracy) || (Tools.absoluteValueOf(xn - x2) < approximationAccuracy))
	        {
	        	resultIsFound = true;
	        	break;
	        }

	        x1 = x2; f1 = f2;
	        x2 = xn; f2 = fn;
		}
		
		if(!resultIsFound)
		{
			Program.print(
				Tools.BELT + "\n"
				+	"Result was not found - possibly a zero position does not\n"
				+	"exist close enough to the given starting points."
			);
		}
		
		Program.print( 
			Tools.BELT + "\n"
			+	"ZeroPosition xn = %.14f\n"
			+	"Function Value f(xn) = %.14f\n"
			+	"Approximation Accuracy = %.14f\n"
			+	"Runs performed = %d\n" +
			Tools.BELT,
				
			xn, 
			fn, 
			approximationAccuracy, 
			numberOfChecks
		);		
	}

}