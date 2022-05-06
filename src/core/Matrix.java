package core;

import java.util.ArrayList;
import java.util.List;

public class Matrix
{
	private ArrayList<Double> content = new ArrayList<>();
	
	public int rows, columns;
	
	public Matrix(int rows, int columns)
	{
		this.rows = rows;
		this.columns = columns;
		
		for(int y = 0; y < rows; y++)
		{
			for(int x = 0; x < columns; x++)
			{
				content.add(0d);
			}
		}
	}
	
	public Matrix(int rows, int columns, List<Double> input)
	{		
		this.rows = rows;
		this.columns = columns;
		
		int index = 0;
		
		for(Double d: input)
		{
			content.add(d);
			index++;
		}
		
		for(; index < rows * columns; index++)
		{
			content.add(0d);
		}		
	}
	
	public double get(int y, int x)
	{
		return content.get( y * columns + x );
	}
	
	public void set(int y, int x, double val)
	{
		content.set(y * columns + x, val);
	}
	
	
	public double getDeterminant() throws ProgramException
	{
		
		return getDeterminantOf(this);
	}
	
	@Override
	public String toString()
	{
		String output = "";
		
		for(int y = 0; y < rows ; y++)
		{
			for(int x = 0; x < columns ; x++)
			{
				output += this.get(y, x) + " ";
			}
			output += "\n";
		}
		
		return output.trim();
	}
	
	private static double getDeterminantOf(Matrix matrix) throws ProgramException
	{
		if(matrix.rows != matrix.columns) throw new ProgramException("This is not a square matrix, therefore there is no determinant");
		
		if(matrix.columns == 1)
		{
			return matrix.get(0, 0);
		}
		else
		if(matrix.columns == 2)
		{
			return (matrix.get(0, 0) * matrix.get(1, 1)) - (matrix.get(1,0) * matrix.get(0,1));
		}
		else
		{
			double output = 0;
			for(int i=0; i<matrix.columns; i++)
			{
				output += matrix.get(i,0) * ( i%2==0 ? 1 : -1 ) * getDeterminantOf(matrix.getComplementaryMatrix(i,0));
			}
			return output;
		}
		
	}
	
	private Matrix getComplementaryMatrix(int column, int row)
	{
		Matrix mtrx = new Matrix(columns-1, rows-1);
		
		int mx, my = 0;
		for(int y=0; y<rows; y++)
		{
			mx = 0;
			if(y==row) continue;
			for(int x=0; x<columns; x++)
			{
				if(x==column) continue;
				mtrx.set(mx, my, this.get(y, x));
				mx++;
			}
			my++;
		}

		return mtrx;
	}
	

}

/*
 * #include "../headers/matrix.h"

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
void Matrix::set(int row, int col, double val)
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
 */