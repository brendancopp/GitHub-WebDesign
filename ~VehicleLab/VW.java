
public class VW extends car{
	
	private final static int MAX_SPEED = 75;
	private final static double opCost = .10;
	
	public VW()
	{
		super(opCost, MAX_SPEED, "VW");
	}
	
	public double insurance(double miles)
	{
		return ( .1 * (opCost * miles));
	}
	
	
	

}
