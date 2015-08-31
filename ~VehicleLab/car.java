
public abstract class car extends vehicle{
	
	private final static double MAX_CARRY = .5;
	
	public car(double inOpCost, int inSpeed, String inName)
	{
		super(inOpCost, inSpeed, inName, MAX_CARRY);
	}
	
	public String getInfo(double inMiles)
	{
		return super.getInfo(inMiles) + "\nMax Speed : " + getSpeed() + " Mph \nEstimated Trip : " + estTrip(inMiles) + " Hour(s)\n-----------------------------------";
	}

}
