import java.util.*;

public class BankTester {
	
	
	public static void main (String args[])
	{
		Scanner kb = new Scanner(System.in);
		ArrayList arr = new ArrayList();
		String name;
		do
		{
			System.out.println("Please enter the name to whome the account belongs to");
			name = kb.nextLine();
			if(!name.equalsIgnoreCase("Exit"))
			{
				System.out.println("Please enter the amount to deposit");
				double amount = kb.nextDouble();
				kb.nextLine();
				System.out.println("");
				
				BankAccount obj = new BankAccount(name, amount);
				arr.add(obj);
				
			}
		}
		while(!name.equalsIgnoreCase("Exit"));
		
		BankAccount ba = (BankAccount) arr.get(0);
		double maxBalance = ba.balance;
		String maxName = ba.name;
		
		for(int j = 1; j<arr.size(); j++)
		{
			ba = (BankAccount) arr.get(j);

			if(ba.balance > maxBalance)
			{
				maxBalance = ba.balance;
				maxName = ba.name;
			}
		}
		
		System.out.println("Owner = "+maxName + ", Balance = " + maxBalance);
	}

}
