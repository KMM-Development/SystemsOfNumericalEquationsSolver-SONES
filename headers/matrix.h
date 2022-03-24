#pragma once
#include <iostream>

class Matrix
{
	public:
	Matrix();
	Matrix(int, int);
	Matrix(int, int, double[]);
	
	static double getDeterminantOf(Matrix); // m == n
	
	void set(int, int, int);
	void initialize();
	void show();
	void fillWithOnes();
	void fillWithZeros();
	//void fillWithRandom();
	
	double get(int, int);
	
	int getM();
	int getN();
	
	// get a matrix without column m and row n
	Matrix getComplementaryMatrix(int, int);
	
	private:
	int m_, n_; /// m = x, n = y
	double* *content_;
};