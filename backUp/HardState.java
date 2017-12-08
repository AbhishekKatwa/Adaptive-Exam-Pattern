import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.*;
import java.util.Random;
public class HardState implements State 
{
	@Override
	public String toString(){
		return "HardState";
	}
  public void fetchQuestions(ArrayList<QuestionClass> currentQuestionSet,ArrayList<QuestionClass> answeredQuestions) 
  {
    currentQuestionSet.clear();
    answeredQuestions.clear();
  	Random rand=new Random();
    //System.out.println("Trying to fetch Hard Questions");
    String fileName="HardQuestions.txt";
    List<String> lines = Collections.emptyList();
    try
    {
      lines =Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
      //System.out.println(lines);
      while(currentQuestionSet.size()<4)
      {
      	int randomno=rand.nextInt(lines.size());
      	String q =lines.get(randomno);
      	String[] arr=q.split("%%%");
        //for(int i=0; i<answeredQuestions.size();i++)
          //System.out.println(answeredQuestions.size());
      	if(isPresent(answeredQuestions,Integer.parseInt(arr[0])))
      	{
      		continue;
      	}
      	else
      	{
      		QuestionClass qc=new QuestionClass(Integer.parseInt(arr[0]),arr[1],arr[2],arr[3],arr[4],arr[5],arr[6]);
      		answeredQuestions.add(qc);
      		currentQuestionSet.add(qc);
      	}
        //for(int i=0; i<currentQuestionSet.size();i++)
          //System.out.println(currentQuestionSet.get(i));
        //System.out.println("x");
      }
      //System.out.println("x");
    }
    catch (IOException e)
    {
      // do something
      e.printStackTrace();
    }
	}
    boolean isPresent(ArrayList<QuestionClass> aQ,int curr)
  {
  	for(QuestionClass qc:aQ)
  	{
  		if(qc.questionID==curr)
  			return true;
  	}
  	return false;
  }
  
}