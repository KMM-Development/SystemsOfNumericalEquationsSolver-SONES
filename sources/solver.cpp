#include "../headers/solver.h"

Matrix Solver::buildAMatrix() 
{
	int m, n;
	std::cout << "\nPlease specify the numer of columns and rows, separated by a space.\n";
	std::cin >> m >> n;
	std::cout << "\nNow creating a matrix with " << m << " columns and " << n << " rows.";
	std::cout << "\nWrite down a matrix string below, each value separated by either a space or enter.\n";
	double *arr = new double[m * n], value;
	for (int i = 0; i < m * n; i++)
	{
		std::cin >> value;
		arr[i] = value;
	}

	return Matrix(m, n, arr);
}

void Solver::solveSystemOfNumericalEquationsUsingMatrices()
{
	Matrix mtrx = Solver::buildAMatrix();
	std::cout << "Determinant of the given matrix is " << Matrix::getDeterminantOf(mtrx) << std::endl;
}

void Solver::calculateAreaOfIntegrateUsingTrapezoids()
{
    double delta, a, b, x;
    int n;
    double sum = 0;
    std::cout << "Beginning of the integration interval: ";
    std::cin >> a;
    std::cout << "End of the integration interval: ";
    std::cin >> b;
    std::cout << "Number of intervals: ";
    std::cin >> n;
    std::cout << "Function: ";
    delta = (b - a) / n;
    for (int i = 0; i < n; i++) {
        x = a + delta * i;
        sum = sum + delta * (std::pow(x,2) + std::pow(x + delta,2)) / 2;
    }
    std::cout << "Area of integrate is: " << sum;
}
/*/
void Solver::solveSystemOfPolynominalEquations()
{
    int polynominalsNo = 1, doneNo = 0;
    std::string input;
    std::vector<std::vector<double>> polynominals;
    std::cout << "Please enter values of variables next to decreasing powers of 'x',\nand end the line after the value next to x^0.";

    do {
        std::cout << "\nPolynominal number " << polynominalsNo++<<":\n(press only 'enter' to signify that there are no more polynominals to enter)\n ";
        std::getline(std::cin, input);
        if (input.length() != 0) 
        {//\n
            //polynominals.push_back(Parser::parseLineOfDoublesAndReverse(input));
            doneNo++;
        }
    } while (input != "");

    std::cout << doneNo << " polynominals alegedly entered." << std::endl;
}
*/
