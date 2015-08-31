
public class G3_RandomSum {
	

	public static void main (String[] args)
	{
		//Passing Obj
		G3_RandomSum obj = new G3_RandomSum();
		
		//Creates Array With a Random Amount Of Rows and Columns
		int[][] array = new int[(int)(Math.random() * 9) + 1][(int)(Math.random() * 9) + 1];
		
		
								// Remember the ---- length - 1 ----
		for(int row = 0; row < array.length-1; row++)
		{
			for(int col = 0; col < array[row].length-1; col++)
			{
				//Gives Random Number to each space
				array[row][col] = (int)(Math.random() * 9) + 1;
				System.out.print(array[row][col]+"\t");
			}
		}
		//Calls Method
		obj.printTwoDArray(array);
	}


	
	public void printTwoDArray(int[][] inArray)
	{
		//Creates an Array with same row length, and length of Column 0
		int[][] printArray = new int[inArray.length - 1][inArray[0].length -1];
		printArray = inArray;

		System.out.println("\n-----Printed Numbers Over From Method-----");
		System.out.println("-----Should Match Up-----");

		
		//Cycles Print Method
		for(int row = 0; row < printArray.length -1; row++)
		{
			for(int col = 0; col < printArray[row].length -1; col++)
			{
				System.out.print(printArray[row][col]+ "\t");
			}
		}
	}

}
