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

void Solver::solveSystemOfNumericalEquations()
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