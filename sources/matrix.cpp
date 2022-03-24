#include "../headers/matrix.h"

Matrix::Matrix()
	: m_(3)
	, n_(3)
{
	initialize();
	fillWithZeros();
}

Matrix::Matrix(int m, int n)
	: m_(m)
	, n_(n)
{
	initialize();
	fillWithZeros();
}

Matrix::Matrix(int m, int n, double arr[])
	: m_(m)
	, n_(n)
{
	initialize();
	fillWithZeros();
	//int x = 0, y = 0;
	for (int i = 0; i < (m_*n_); i++) {
		content_[i%m_][i/m_] = arr[i];
		//if (x >= m_) {
		//	x = 0; y++;
		//	if (y >= n_) return;
		//}
	}
}

void Matrix::show()
{
	for(int i = 0; i<n_; i++)
	{
		for(int j = 0; j<m_; j++){
			std::cout<< content_[j][i] << " ";
		}
		std::cout<<std::endl;
	}
}

double Matrix::getDeterminantOf(Matrix mtrx)
{
	int 
		m = mtrx.m_,
		n = mtrx.n_;
		
	if(m != n) throw "This is not a square matrix, cannot return a determinant.";
	if(m == 1)
	{
		return mtrx.content_[0][0];
	}
	else
	if(m == 2)
	{
		return (mtrx.content_[0][0] * mtrx.content_[1][1]) - (mtrx.content_[1][0] * mtrx.content_[0][1]);
	}
	else
	{
		/// Let's use 1st row of our matrix. (y = 0)
		double output = 0;
		for(int i=0; i<m; i++)
		{
			output += mtrx.get(i,0) * ( i%2==0 ? 1 : -1 ) * Matrix::getDeterminantOf(mtrx.getComplementaryMatrix(i,0));
		}
		return output;
	}
}

double Matrix::get(int row, int col)
{
	return content_[row][col];
}

Matrix Matrix::getComplementaryMatrix(int m, int n)
{
	Matrix mtrx(m_-1,n_-1);
	
	int mx, my = 0;
	for(int y=0; y<n_; y++)
	{
		mx = 0;
		if(y==n) continue;
		for(int x=0; x<m_; x++)
		{
			if(x==m) continue;
			mtrx.set(mx, my, content_[x][y]);
			mx++;
		}
		my++;
	}

	return mtrx;
}
void Matrix::set(int row, int col, int val)
{
	content_[row][col] = val;
}

void Matrix::initialize()
{
	content_ = new double*[n_];
	
	for(int i=0; i<n_; i++){
		content_[i] = new double[m_];	
	}
}

void Matrix::fillWithZeros()
{
	for(int i = 0; i<n_; i++)
	{
		for(int j = 0; j<m_; j++){
			content_[i][j] = 0;
		}
	}
}

void Matrix::fillWithOnes()
{
	for(int i = 0; i<n_; i++)
	{
		for(int j = 0; j<m_; j++){
			content_[i][j] = 1;
		}
	}
	//12 4 2 5 6 7  8 8 6 66 55 4 2 3  3 33 33 
}

int Matrix::getM()
{
	return m_;
}

int Matrix::getN()
{
	return n_;
}