package numericMethod;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import core.Program;
import core.ProgramException;

public abstract class NumericalMethod
{
	
	protected abstract void begin() throws IOException, ProgramException;
	
	public String getReadableClassNameAsSentence()
	{
		String output = "";
		
		Matcher matcher = 
				Pattern
				.compile("([A-Z][a-z]*)")
				.matcher(this.getClass().getSimpleName());
		
		while(matcher.find())
		{
			output += " " + matcher.group();
		}	
		
		return output+".";
	}
	
	public void safeBegin()
	{
		try
		{
			begin();
		}
		catch (IOException e) 
		{
			Program.print("An unexpected I/O Exception caught. Returning to main menu.");
		} 
		catch (ProgramException e)
		{
			Program.print(e.getMessage());
		}
		
	}
}
