
public class minMax 
{

	public static void main(String[] args) 
	{
		int[] MaxMin = {3, 4, 6, 1, 6, 10, 100, 0};
		
		///Min number find
		int mainN = MaxMin[0];
		for(int i = 0+1; i < MaxMin.length; i++)
		{
			if(MaxMin[i] < mainN)
			{
				mainN = MaxMin[i];
			}	
		}
		System.out.println("Min Number: "+mainN);
		
		//Max Number find 
		for(int k = 0+1; k < MaxMin.length; k++)
		{
			if(MaxMin[k] > mainN)
			{
				mainN = MaxMin[k];
			}
		}
		System.out.println("Max Number:" +mainN);
	}

}
