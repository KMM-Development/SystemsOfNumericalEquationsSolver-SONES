package numericMethod;

import java.io.IOException;

import core.Polynominal;
import core.Program;
import core.Tools;

public class FindingAZeroPositionUsingNewtonMethod extends NumericalMethod {

	@Override
	protected void begin() throws IOException 
	{
		double
			approximationAccuracy = 1e-14, 
			x0, 
			x1, 
			f0 = 0, 
			f1;

		boolean 
			resultIsFound = false;

		int 
			maxNumberOfChecks = 100, 
			numberOfChecks = 0;

		Polynominal 
			polynominal = Tools.createPolynominalFromInputLineWithStandardMessage(),
			derivative = polynominal.getDerivative();

		x0 = Tools.requestDouble("Please provide the initial boundary value of the interval (x0): ");

		while (++numberOfChecks < maxNumberOfChecks) 
		{
			f0 = polynominal.valueAtX(x0);

			if (Tools.absoluteValueOf(f0) < approximationAccuracy) 
			{
				resultIsFound = true;
				break;
			}

			f1 = derivative.valueAtX(x0);

			x1 = x0;

			x0 -= f0 / f1;

			if (Tools.absoluteValueOf(x1 - x0) < approximationAccuracy) 
			{
				resultIsFound = true;
				break;
			}

		}

		if (!resultIsFound) 
		{
			Program.print("Result was not found - possibly a zero position does not exist.\n"
					+ "Or the starting position was too far away.");
		}
		Program.print(
			Tools.BELT + "\n" +
			"ZeroPosition xn = %.14f\n" + 
			"Function Value f(xn) = %.14f\n" + 
			"Approximation Accuracy = %.14f\n"+ 
			"Runs performed = %d\n" +
			Tools.BELT,
			
			x0, 
			f0, 
			approximationAccuracy, 
			numberOfChecks
		);
	}

}
