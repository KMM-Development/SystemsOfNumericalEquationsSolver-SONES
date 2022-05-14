package core;

public class ProgramException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public ProgramException(Object message, Object... args)
	{
		super(
			Converter.format(
				Converter.stringify(
					message
				), 
				args
			)
		);
	}

}
