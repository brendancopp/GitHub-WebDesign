
public class chevy extends car {
	
	private final static int MAX_SPEED = 100;
	private final static double opCost = .25;
	
	public chevy()
	{
		super(opCost, MAX_SPEED, "Chevy");
	}
	
	public double insurance(double miles)
	{
		return .05 * miles;
	}
	

}
