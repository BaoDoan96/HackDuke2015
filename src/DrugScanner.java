import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class DrugScanner 
{	
	//stores each collection(set) of similar drugs
	public static ArrayList<Node> myNodeSets = new ArrayList<Node>();
	
	//each drug is going to be its own node
	public static class Node
	{
		String genericName;
		TreeSet<String> brandNames;
		TreeSet<String> alternatives;
		
		public Node()
		{
			genericName = "";
			brandNames = null;
			alternatives = null;
		}
		
		public Node(String myGeneric, TreeSet<String> myBrandNames, TreeSet<String> myAlternatives)
		{
			genericName = myGeneric;
			brandNames = myBrandNames;
			alternatives = myAlternatives;
		}
	}
	
	public static void main(String[] args)
	{
		File textFile = new File("data/test.txt");
		scanTheFile(textFile);
		testArray();
	}
	
	public static void scanTheFile(File textFile)
	{
		//use these fillers to make the variables of the Node class later
		TreeSet<String> currentBrandSet = new TreeSet<String>();
		TreeSet<String> currentAlternativeSet = new TreeSet<String>();
		String currentLine = "k";
		String currentGeneric = "";
		
		//need instance of DrugScanner
		DrugScanner myScanner = new DrugScanner();
		
		try 
		{
			Scanner sc = new Scanner(textFile);
			
			if( sc.hasNextLine())
			{
				System.out.println(currentLine);
				currentLine = sc.nextLine(); 
			}
			
			while( sc.hasNextLine())
			{
				if(currentLine.indexOf("\n") > -1)
				{
					//System.out.println(currentLine);
					if(sc.hasNextLine())
					{
						currentGeneric = sc.nextLine();
						currentLine = sc.nextLine();
						System.out.println(currentLine);
						
						//brand loop
						while( currentLine.indexOf('\n') < 0 && currentLine.indexOf('*') < 0)
						{
							currentBrandSet.add(currentLine);
							currentLine = sc.nextLine();
						}
						
						//alternatives loop
						if( currentLine.indexOf('*') > -1)
						{
							currentLine = sc.nextLine();
							while(currentLine.indexOf('\n') < 0)
							{
								currentAlternativeSet.add(currentLine);
								currentLine = sc.nextLine(); 
							}
						}
						
						if( currentLine.indexOf('\n') > -1)
						{
							DrugScanner.myNodeSets.add(new Node( currentGeneric, currentBrandSet, currentAlternativeSet));
							currentBrandSet.clear();
							currentAlternativeSet.clear();
						}
					}
				}
			}
		} 
		
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public static void testArray()
	{

	}
	public static void genericLookUp(String theGeneric)
	{
		
	}
	
	public static void brandLookup(String theBrand)
	{
		
	}
}
