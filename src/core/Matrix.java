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
	
	public void setColumn(int columnIndex, ArrayList<Double> column)
	{
		int y = 0;
		for(double val: column)
		{
			this.set(y++, columnIndex, val);
		}
	}
	
	public double getDeterminant()
	{
		return getDeterminantOf(this);
	}
	
	public Matrix clone()
	{
		return new Matrix(columns, rows, this.content);
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
	
	private static double getDeterminantOf( Matrix matrix )
	{
		if(matrix.columns == 1)
		{
			return matrix.get(0, 0);
		}
		else
		if(matrix.columns == 2)
		{						
			return (matrix.get(0, 0) * matrix.get(1, 1)) - (matrix.get(1, 0) * matrix.get(0, 1));
		}
		else
		{
			double output = 0;
			for(int i = 0; i < matrix.columns; i++)
			{
				output += matrix.get(i, 0) * ( i % 2 == 0 ? 1 : -1 ) 
						* getDeterminantOf(matrix.getComplementaryMatrix(i, 0));
			}
			return output;
		}
	}
	
	private Matrix getComplementaryMatrix( int row, int column )
	{
		Matrix mtrx = new Matrix(rows-1, columns-1);
		
		int mx, my = 0;
		for(int y = 0; y < rows; y++)
		{
			mx = 0;
			if(y==row) continue;
			for(int x = 0; x < columns; x++)
			{
				if(x == column) continue;
				mtrx.set(my, mx, this.get(y, x));
				mx++;
			}
			my++;
		}

		return mtrx;
	}
	
}