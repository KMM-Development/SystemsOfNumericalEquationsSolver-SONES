package normalnaNazwa;

import core.Program;
import core.Tools;

public class FindingAZeroPositionUsingNewtonMethod extends NormalnaNazwa
{
	
	public double f(double x)
	{
		//return x * x * x + x * x - 3 * x;
		return x*x + 4;
	}
	
	public double df(double x)
	{
		//return 3 * x * x + 2 * x - 3;
		return 2*x;
	}
	
	// TODO Zrobić to nie na twardo
	
	@Override
	public void begin()
	{
		double 
			approximationAccuracy = 1e-14,
			x0 = 1,
			f0 = 0,
			x1,
			f1;
		
		boolean
			resultIsFound = false;
		
		int
			maxNumberOfChecks = 100,
			numberOfChecks = 0;

		while(++numberOfChecks < maxNumberOfChecks)
	   {
			f0 = f(x0);

			if(Tools.absoluteValueOf(f0) < approximationAccuracy)
			{
	      	 resultIsFound = true;
	          break;
			}

			f1 = df(x0);

			x1 = x0;

			x0 -= f0/f1;

			if(Tools.absoluteValueOf(x1 - x0) < approximationAccuracy)
			{
				resultIsFound = true;
				break;
			}
			
	    }

		if(!resultIsFound) 
			Program.print("Error(?)");

		Program.print( 
				"ZeroPosition xn = %f\n"
			+	"Function Value f(xn) = %f\n"
			+	"Approximation Accuracy = %f\n"
			+	"Runs performed = %d",
				
			x0, 
			f0, 
			approximationAccuracy, 
			numberOfChecks
		);
	}

}
