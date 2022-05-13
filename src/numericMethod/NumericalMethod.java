package numericMethod;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class NumericalMethod
{
	
	public abstract void begin() throws IOException;
	
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
	
}
