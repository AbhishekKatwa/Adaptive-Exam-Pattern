import java.util.ArrayList;
interface State 
{
  public void fetchQuestions(ArrayList<QuestionClass> currentQuestionSet,ArrayList<QuestionClass> answeredQuestions);
}