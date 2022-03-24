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