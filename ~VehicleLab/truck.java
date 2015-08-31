
public class truck extends vehicle{
	
	private final static double MAX_SPEED = 55;
	
	public truck(double inOpCost, double inCarry, String inName)
	{
		super(inOpCost, MAX_SPEED, inName, inCarry);
	}
	
	public double insurance(double miles)
	{
		return  ((.1 * getCarry()) * miles);
	}
	
	public String getInfo(double inMiles)
	{
		return super.getInfo(inMiles) + "\nMax Storage : " + getCarry() + " Lb(s) \nEstimated Trip : " + estTrip(inMiles) +" Hour(s)\n-----------------------------------";
	}

}
