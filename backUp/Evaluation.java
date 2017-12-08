import java.util.ArrayList;
class Evaluation
{
static int evaluateResponses(ArrayList<String> response,LoggedInUser user)
  {
    int numOfCorrectAnswers=0;
    //ArrayList<QuestionClass> actualAnswers=user.currentQuestionSet;
    for(int i=0;i<response.size();i++)
    {
    	//System.out.println(response.get(i));
    	//System.out.println(user.currentQuestionSet.get(i).correctoption);
      if(response.get(i).equals(user.currentQuestionSet.get(i).correctoption))
        ++numOfCorrectAnswers;
    }
    //return numOfCorrectAnswers;
  	//System.out.println(numOfCorrectAnswers);
  	return isStateToBeChanged(numOfCorrectAnswers);
  }
  Evaluation(){}
  static int isStateToBeChanged(int numOfCorrectAnswers)
  {
  	if(numOfCorrectAnswers<2)
  		return -1;
  	else if(numOfCorrectAnswers==2)
  		return 0;
  	else
  		return 1;
  }
}