import java.util.*;
class LoggedInUser
{
  String USN;
  ArrayList<QuestionClass> currentQuestionSet;
  ArrayList<QuestionClass> answeredQuestions;
  Context context;
  /*Easy*/State easyState;
  /*Medium*/State mediumState;
  /*Hard*/State hardState;
  LoggedInUser(String USN)
  {
    this.USN=USN;
    /*ArrayList<QuestionClass>*/ currentQuestionSet=new ArrayList<>();
    /*ArrayList<QuestionClass>*/ answeredQuestions=new ArrayList<>();
    /*Context */context=new Context();
    /*EasyState*/ easyState=new EasyState();
    /*MediumState*/ mediumState=new MediumState();
    /*HardState*/ hardState=new HardState();
  }
  void setDefaultState()
  {
    context.setState(mediumState);
  }
  void fetchQuestions()
  {
  	//System.out.println("lol");
  	currentQuestionSet.clear();
  	answeredQuestions.clear();
    //Collections.clear(currentQuestionSet);
    //Collections.clear(answeredQuestions);
    //System.out.println("Hello");
    this.context.fetchQuestions(currentQuestionSet,answeredQuestions);
  }
  void changeState(int actionVal)
  {
    if(actionVal<0)
    {
      if(context.getState()==hardState)
        this.context.setState(mediumState);
      else if(context.getState()==mediumState)
        this.context.setState(easyState);
    }
    else if(actionVal==0){
      if(context.getState()==hardState)
        this.context.setState(hardState);
      else if(context.getState()==mediumState)
        this.context.setState(mediumState);
      else
        this.context.setState(easyState);
    }
    else {
      if(context.getState()==easyState)
        this.context.setState(mediumState);
      else if(context.getState()==mediumState)
        this.context.setState(hardState);
    }
    System.out.println("Changed State to" + context.getState());
  }
}
