#ifndef MATRIX_H
#define MATRIX_H
#include <iostream>

class Matrix{
	
	public:
	Matrix();
	Matrix(int m, int n);
	
	static double getDeterminantOf(Matrix a); // m == n
	
	void initialize();
	void show();
	void fillWithOnes();
	void fillWithZeros();
	void fillWithRandom();
	
	int getM();
	int getN();
	
	// get a matrix without column m and row n
	Matrix getComplementaryMatrix(int m, int n);
	
	private:
	int m, n; /// m = x, n = y
	double* *content;
		
};

#endif