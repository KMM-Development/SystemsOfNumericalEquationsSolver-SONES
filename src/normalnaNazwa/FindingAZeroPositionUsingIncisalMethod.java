package normalnaNazwa;

import core.Program;
import core.Tools;

public class FindingAZeroPositionUsingIncisalMethod extends NormalnaNazwa
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
		
		/*
		 2 4 2
		 1 2 3
		 
		 
		*/
		
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
			Program.print("Result was not found - possibly a zero position does not exist.");
		
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

/*
 *double f(double x)
{
  return sin(x*x-x+1/3.0)+0.5*x;
}

// Tutaj definiujemy parametry początkowe

double epsx = 1e-14; // Dokładność wyznaczania pierwiastka
double epsy = 1e-14; // Dokładność wyznaczania zera
double x1   = -1.1;  // Punkty startowe
double x2   = -1.0;
int n       = 64;    // Maksymalna liczba obiegów

// Program główny
//---------------

int main()
{
    // Zmienne

    double f1,f2,fn,xn;
    bool result = false; // Zmienna informująca o poprawnym zakończeniu metody

    setlocale(LC_ALL,"");

    cout << setprecision(15) << fixed;
    cout << "Obliczanie przybliżonego pierwiastka funkcji metodą siecznych" << endl
         << "-------------------------------------------------------------" << endl << endl;

    // Obliczamy i zapamiętujemy wartości funkcji na krańcach przedziału [a,b]

    f1 = f(x1);
    f2 = f(x2);

    while(--n)
    {
        // Obliczamy punkt przecięcia siecznej z osią OX

        xn = (f1 * x2 - f2 * x1) / (f1 - f2);

        // Obliczamy wartość funkcji w punkcie przecięcia

        fn = f(xn);

        // sprawdzamy warunki zakończenia

        if((fabs(fn) < epsy) || (fabs(xn - x2) < epsx))
        {
            result = true;
            break;
        }

        // Uaktualniamy przybliżenia

        x1 = x2; f1 = f2;
        x2 = xn; f2 = fn;
    }

    if(!result) cout << "Przekroczono liczbę obiegów !!!" << endl << endl;

    cout << "Pierwiastek        xn = " << setw(18) << xn << endl
         << "Wartość funkcji f(xn) = " << setw(18) << fn << endl
         << "Dokładność dla x epsx = " << setw(18) << epsx << endl
         << "Dokładność dla y epsy = " << setw(18) << epsy << endl
         << "Liczba obiegów        = " << 64 - n;

    cout << endl << endl;

    return 0;
} 
 */