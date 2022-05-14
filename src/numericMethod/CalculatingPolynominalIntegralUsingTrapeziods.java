package numericMethod;

import java.io.IOException;

import core.Polynominal;
import core.Program;
import core.Tools;

public class CalculatingPolynominalIntegralUsingTrapeziods extends NumericalMethod
{
	@Override
	protected void begin() throws IOException
	{
		Program.print("--------------------------------------------");

		double 
			a = Tools.requestDouble("Beginning of the integration interval: "),
			b = Tools.requestDouble("End of the integration interval: "), sum = 0, delta, x;

		int 
			n = Tools.requestInteger("Number of intervals: ");

		Polynominal polynominal = Tools.createPolynominalFromInputLineWithStandardMessage();

		Program.print("--------------------------------------------");

		delta = (b - a) / n;

		for (int i = 0; i < n; i++)
		{
			x = a + delta * i;
			sum = sum + delta * (polynominal.valueAtX(x) + polynominal.valueAtX(x + delta)) / 2;
		}

		Program.print("Area of integrate is: %f", sum);

		Program.print("--------------------------------------------");
	}

}
