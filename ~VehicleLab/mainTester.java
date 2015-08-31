// I Pledge My Honor

import java.util.Scanner;

public class mainTester {
	
	public static void main (String args[])
	{
		
	boolean cont = true;
	Scanner kboard = new Scanner(System.in);
	
	// Obj Reference Array
	vehicle[] refArr = new vehicle[6];
	refArr[0]= new ferrari();
	refArr[1]= new chevy();
	refArr[2]= new VW();
	refArr[3]= new semi();
	refArr[4]= new pickup();
	refArr[5]= new dumptruck();
	
	
while(cont)
{
	// Input and UI
	System.out.println("Welcome to Vehicle Renter : Here is a list of vehicles we offer\n-------------------------------------------------------------");
	
	for(int i = 0; i < refArr.length; i++)
	{
		System.out.println("" + refArr[i].getName());
	}
	
	System.out.println("--------------------------------------------------- \n Enter the amount of cargo you would like to carry : ");
	double carry = kboard.nextDouble();
	System.out.println("Enter length of your journy in Miles : ");
	double miles = kboard.nextDouble();
	System.out.println("Enter the Time you would like your journy to take in Hours : ");
	double estTime = kboard.nextDouble();
	System.out.println("----------------------------------------------");
	
	
	//Process User Scan Using getInfo()
	boolean retBoolean = false;
	for (int i = 0; i < refArr.length; i++)
	{
		if(refArr[i].getCarry() >= carry && refArr[i].estTrip(miles) <= estTime)
		{
			retBoolean = true;
			System.out.println(refArr[i].getInfo(miles));
		}
	}

	//No Reqs if statment, and End Program Booleans
	if(retBoolean == false)
	{
		System.out.println("Sorry, none of our vehicles fit your requirments");
	}
	
	System.out.println("Continue? -  1 for Yes,  2 for No");

	double again = kboard.nextDouble();
	
	if(again == 2)
		cont = false;
	
	System.out.println("\n-----------------------------------\n Thank You For Using Our System \n-----------------------------------");
	
	}
}
}
