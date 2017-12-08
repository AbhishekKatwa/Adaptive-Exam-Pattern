//Context
import java.util.ArrayList;
//maybe have a private variable which will store the logged in users
//this private variable will be an arraylist of LoggedInUser class
public class Context 
{
  private State state;
  private Context(State state) 
  {
    this.state= state;
  }
  /*private*/public Context()
  {
    //this.state=new MediumState();
  }
  public void setState(State state) 
  {
    this.state = state;
  }
  public State getState() 
  {
    return state;
  }
  //we have to check how many answers they got right
  public void fetchQuestions(ArrayList<QuestionClass> currentQuestionSet,ArrayList<QuestionClass> answeredQuestions)
  {
    this.state.fetchQuestions(currentQuestionSet,answeredQuestions);  
  }
}