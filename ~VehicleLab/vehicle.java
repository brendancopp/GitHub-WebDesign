
public abstract class vehicle  {
	
	private String name;
	private double opCost;
	private double speed;
	private double carry;
	
	public vehicle(double inOp, double inSpeed, String inName, double inCarry)
	{
		opCost = inOp;
		speed = inSpeed;
		carry = inCarry;
		name = inName;
	}
	
	//-----------------------------------------------------------
	
	public double getCarry()
	{ return carry; }
	
	public double getSpeed()
	{ return speed; }
	
	public double getopCost()
	{ return opCost; }
	
	public String getName()
	{ return name; }
	
	//-----------------------------------------------------------
	
	public double totalOp(double inMiles)
	{
		return (opCost * inMiles);
	}
	
	public double totalCost(double inMiles)
	{
		return totalOp(inMiles) + insurance(inMiles);
	}
	
	public double estTrip(double inMiles)
	{
		return inMiles / speed;
	}
	
	public String getInfo(double inMiles)
	{
		return "Vehicle : " + getName() + "\nOperation Cost : " + totalOp(inMiles) + "\nInsurance : " + insurance(inMiles) + 
				"\nTotal Cost : " + (totalOp(inMiles) + insurance(inMiles));
	}
	
	//(Structure) - Abstract Declared in truck class, and in individual car classes
	public abstract double insurance(double miles);
	
	

}
