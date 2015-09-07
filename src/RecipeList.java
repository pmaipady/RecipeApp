import java.io.*;
import java.util.Scanner;



public class RecipeList{
			
		public static void main(String[] args) {

		Scanner sFile;
		int recipe_pos= -1;
		int index;
		boolean ing = false;
		String[] recipe_name = new String[32];
		String line;
		int selection;
		
				
		try {
				sFile = new Scanner(new File("Recipes.txt"));
								
				do
				{
					line = sFile.nextLine();
					index = line.indexOf("Recipe:");
			
			if (index == 0)
					{
					recipe_pos++;
					recipe_name[recipe_pos] = line;
					System.out.println ("The recipe Selection:-  " + recipe_pos + "\t" + recipe_name[recipe_pos] );
					}
					
		}while(sFile.hasNextLine());
							

				Scanner in = new Scanner(System.in);
								
				System.out.println("Enter a Recipe Selection");
				selection = in.nextInt();
				
				in.close();
				recipe_pos = 0;
				sFile = new Scanner(new File("Recipes.txt"));
				
				do
				{
					line = sFile.nextLine();
					index = line.indexOf("Recipe:");
					
					if (index == 0)
							{
							recipe_pos++;
							if (selection == recipe_pos)
							{
								System.out.println ("The recipe Selection:-  " + recipe_pos + "\t" + recipe_name[recipe_pos] );
							}
							}
					if(line.indexOf("Ingredients:") == 0)
					{
							ing = true; 
							//items[recipe_pos] = sFile.nextLine();
							//		System.out.println ("The ingredients is " + items[recipe_pos]);
					}
					if (ing== true)
					{
						if(line.indexOf("Directions:") ==0)
						{
							ing = false;
						}
						else
							if (recipe_pos == selection)
							{
						System.out.println ( line );
							}
					}
				}while(sFile.hasNextLine());
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
	   System.out.println("Sorry File not Found");
 
	 		System.exit(1);
	 		 		
		}
		}
}
	