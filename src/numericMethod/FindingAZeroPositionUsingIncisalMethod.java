package numericMethod;

import core.Program;
import core.Tools;

public class FindingAZeroPositionUsingIncisalMethod extends NumericalMethod
{

	public double f(double x)
	{
		return x*x + 4;
	}
	
	// TODO Zrobić to nie na twardo
	
	@Override
	public void begin()
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
			f1 = f(x1),
			f2 = f(x2);
		
		boolean
			resultIsFound = false;
		
		while(++numberOfChecks < maxNumberOfChecks)
		{
	        xn = (f1 * x2 - f2 * x1) / (f1 - f2);

	        fn = f(xn);

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
			Program.print("Result was not found - possibly a zero position does not exist.");
		}
		else
		{
			Program.print( 
					"ZeroPosition xn = %f\n"
				+	"Function Value f(xn) = %f\n"
				+	"Approximation Accuracy = %f\n"
				+	"Runs performed = %d",
				
				xn, 
				fn, 
				approximationAccuracy, 
				numberOfChecks
			);
		}
		
	}

}