
public class MatrixStuff_Pel35 {
	
	

	public static int[][] mult(int[][] inArray1, int[][] inArray2)
	{
		if(inArray1[0].length-1 != inArray2.length-1)
			return null;

		int[][] product = new int[inArray1.length][inArray2[0].length];
			
		
		
		
		for(int j = 0; j < inArray1.length; j++)
		{
			for(int i = 0; i < product[0].length; i++)
			{
				for(int k = 0; k < inArray1[0].length; k++)
				{					
					product[j][i] += inArray1[j][k] * inArray2[k][i];
	
				}
			}
		}
		return product;
	}
}
