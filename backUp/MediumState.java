import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.*;
import java.util.Random;
public class MediumState implements State 
{
	@Override
	public String toString(){
		return "MediumState";
	}
  public void fetchQuestions(ArrayList<QuestionClass> currentQuestionSet,ArrayList<QuestionClass> answeredQuestions) 
  {
  	//System.out.println("Entering MediumState::fetchQuestions");
  	currentQuestionSet.clear();
  	Random rand=new Random();
    String fileName="Mediumquestions.txt";
    List<String> lines = Collections.emptyList();
    try
    {
    	//System.out.println("Entering MediumState::fetchQuestions::try");	
      lines =Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
      while(currentQuestionSet.size()<4)
      {
      	int randomno=rand.nextInt(lines.size());
      	String q =lines.get(randomno);
      	String[] arr=q.split("%%%");
      	//System.out.println(arr[6]);
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
      }
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