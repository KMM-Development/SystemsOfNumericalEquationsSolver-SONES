#include "../headers/matrix.h"

Matrix::Matrix()
{
	this->m = 3;
	this->n = 3;
	this->initialize();
	this->fillWithZeros();
}

Matrix::Matrix(int m, int n)
{
	this->m = m;
	this->n = n;
	this->initialize();
	this->fillWithZeros();
}

double Matrix::getDeterminantOf(Matrix mtrx)
{
	int 
		m = mtrx.getM(), 
		n = mtrx.getN();
		
	if(m != n) throw "This is not a square matrix, cannot return a determinant.";
	if(m == 1)
	{
		return mtrx.content[0][0];
	}
	else if(m == 2)
	{
		return (mtrx.content[0][0] * mtrx.content[1][1]) - (mtrx.content[0][1] * mtrx.content[1][0]);
	}
	else
	{
		/// Let's use 1st row of our matrix. (y = 0)
		/*/
		for(int i=0; i<m; i++)
		{
			
		}
		/**/
	}
}

void Matrix::initialize()
{
	content = new double*[n];
	
	for(int i=0; i<n; i++)
		content[i] = new double[m];	
}

void Matrix::fillWithZeros()
{
	for(int i = 0; i<this->n; i++)
	{
		for(int j = 0; j<this->m; j++){
			(content[i])[j] = 0;
		}
	}
}

void Matrix::show()
{
	for(int i = 0; i<this->n; i++)
	{
		for(int j = 0; j<this->m; j++){
			std::cout<< content[i][j] << " ";
		}
		std::cout<<std::endl;
	}
}

int Matrix::getM()
{
	return this->m;
}

int Matrix::getN()
{
	return this->n;
}
