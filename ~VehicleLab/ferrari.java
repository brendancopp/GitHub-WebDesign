
public class ferrari extends car{
	
	private final static int MAX_SPEED = 200;
	private final static double opCost = 1;
	
	public ferrari()
	{
		super(opCost, MAX_SPEED, "Ferrari");
	}
	
	public double insurance(double miles)
	{
		return (MAX_SPEED * miles / 1000);
	}
	
	
	

}
