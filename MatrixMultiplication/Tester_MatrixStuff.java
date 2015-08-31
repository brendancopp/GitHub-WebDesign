
public class Tester_MatrixStuff {

	public static void main(String[] args) {
	
		int[][] array1 = { {1,2,-2,0}, {-3,4,7,2}, {6,0,3,1} };
		int[][] array2 = { {-1,3}, {0,9}, {1,-11}, {4,-5} };
		
		
		
		//PrintCode
		System.out.println("\tArray 1 * Array 2");
		System.out.println("---------------------------------");
		
		for(int row = 0; row < array1.length; row++)
		{
			for(int col = 0; col < array1[0].length; col++)
			{
				System.out.print(array1[row][col]+"\t");
			}
			System.out.print("\n");
		}
		
		System.out.println("\nX\n");
		
		for(int row = 0; row < array2.length; row++)
		{
			for(int col = 0; col < array2[0].length; col++)
			{
				System.out.print(array2[row][col]+"\t");
			}
			System.out.print("\n");
		}
		System.out.println("------------------------");
		
		
		
		//Pass Code
		int[][] product = new int[array1.length][array2[0].length];
		
		product = MatrixStuff_Pel35.mult(array1, array2);
		
		
		

		//Print Product
		for(int row = 0; row < product.length; row++)
		{
			for(int col = 0; col < product[0].length; col++)
			{
				System.out.print(product[row][col]+"\t");
			}
			System.out.print("\n");
		}

	}

}
