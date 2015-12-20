
import java.util.ArrayList;
class pattern{
	 static int size=4;//Size of the pattern used in game
	ArrayList patternList=new ArrayList();//The ArrayList that contains the elements in the pattern
	static enum colors{Red,blue,green,yellow,cyan,pink,orange,magenta};
	int full;//the size of the filled elements of pattern
	enum Difficulty{easy,hard};

	public void generatePattern(){}//Overridden in the children classes
	public void reset(){}//Overridden in children classes
	public void setDifficulty(){}
		//The user is supposed to initialize the difficulty level
	protected boolean isAvailable(Object obj){//Tested and working :D
		int i;
		for( i=0;i<patternList.size();i++)
		if(obj.equals(patternList.get(i)))
		break;
		if(i<patternList.size())
			return true;
		else return false;
		
//if obj is available in the PatternList then isAvailable() returns true else false
		
	}
	public ArrayList getPattern(){//Tested and working :D
		return patternList;
	}
	}
	

class patternComputer extends pattern{
	public void generatePattern(){//Tested and working :D
		int i;
		colors c;
		for(i=0;i<size;i++)
		{c=colors.values()[(int)(Math.random()*colors.values().length)];
		if(!isAvailable(c))
			patternList.add(i,c );
		else i--;
		}
		//The program randomly generates colors from the enum available
		//checks if the element randomly generated is available in the list::HINT>>we can implement anothermethod for checking availability isAvailable()
		//if not already available in patternList add the element into list
		//repeats the process until the size is of the pattern is completed
		/*Pseudocode::
		if(isfilled()<size)
		{repeat the process
		}
		*/
		
	}
	public void reset(){//No need to implement this method
		//generatePattern()
	}
	
}
class patternUser extends pattern{
	 //public static  boardRows=4;
	public void gaeneratePattern(){
		/*when the user choose radiobutton red ,Red (member of enum colors )is added into the arraylist
		THIS IS RELATED TO THE USER'S Interaction class(Doaa')*/
		/*If the user chooses one color he can't choose it another time:
		 //DOAA's Part
		PSEUDO_Code:
		if(the element is choosen ){
		patternList.add(element)}
		*/
		
	}
	public void reset(){
		/*PSEUDO_Code:
	     for(int i=0;i<patternList.size;i++)
	     patternList.remove(i);       */
		
	}
	
	
}

