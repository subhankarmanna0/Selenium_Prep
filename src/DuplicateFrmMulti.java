
public class DuplicateFrmMulti 
{

			public static void main(String[] args) 
			{
				//aabbbccddaaabcccd
				String abcd = "aabbbccddaaabcccd";
				//abcdabcd
				
				char[] ch = abcd.toCharArray();
				/////////////////////////////////////////////////
				System.out.println("Process 1:");
				for(int i = 0; i < ch.length; i++)
				{
					if(i == ch.length-1)
					{
						System.out.print(ch[i]);
					}
					
					else if(ch[i] != ch[i+1])
					{
						System.out.print(ch[i]);
					}
				}
				
				/////////////////////////////////////////////////////
				System.out.println("Process 2:");
				for(int k = 0; k < ch.length; k++)
				{
					if(k == 0)
					{
						System.out.print(ch[k]);
					}
					else if(ch[k-1] != ch[k])
					{
						System.out.print(ch[k]);
					}
				}
				

			}


	}


