#pragma once
#include <iostream>

class Matrix
{
	public:
	Matrix();
	Matrix(int, int);
	//Matrix(double[] )
	
	static double getDeterminantOf(Matrix a); // m == n
	
	void set(int row, int col, int val);
	void initialize();
	void show();
	void fillWithOnes();
	void fillWithZeros();
	void fillWithRandom();
	
	double get(int row, int col);
	
	int getM();
	int getN();
	
	// get a matrix without column m and row n
	Matrix getComplementaryMatrix(int m, int n);
	
	private:
	int m_, n_; /// m = x, n = y
	double* *content_;
};