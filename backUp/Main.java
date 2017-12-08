import java.util.*;
public class Main
{
  static ArrayList<LoggedInUser> loggedInUsers=new ArrayList<>();
  //Scanner in=new Scanner(System.in);
  //decalaration of all the classes that it is going to need to complete all its functionalities
  	static QuestionClass qc;
  	static Evaluation eval;
  	static LoggedInUser user;
  	static USN usn;
  	static Scanner in=new Scanner(System.in);
  	static Observer obs;
  	static Calendar now;
  	static int time;

  	static int maxTime = 5;
  public static void main(String[] args) 
  {
  	
    while(true)
    {
      System.out.println("Enter USN:");
      String USN=in.next();
      now = Calendar.getInstance();
      //time = now.get(Calender.HOUR) *60;
      time = now.get(Calender.HOUR) *60 + now.get(Calendar.MINUTE);
      maxTime += time;
      System.out.println(time);
      if(usn.Validate(USN))
      //if(true)
      {
        //LoggedInUser us=doTheNecessaryFirstTime(USN);
        user=new LoggedInUser(USN);
        //this below is for the observer pattern
        //obs.attach(user);
        loggedInUsers.add(user);
        //user.context.setState(user.mediumState);
        user.setDefaultState();
        System.out.println("Default");
        //System.out.println("Main::main::if::fetchQuestions");
        user.fetchQuestions();
        System.out.println("Fetched");
        while(true)
        {
          System.out.println("Difficulty set to:"+user.context.getState());	
          //should state be changed?

          int actionVal=eval.evaluateResponses(recordResponses(user,qc),user);
          //System.out.println(actionVal);
          //now since changing the state is not this class's responsibility, we assign this responsibilty to some other class
        //{
          //if(user.context.getState()==user.mediumState)
          //{
            //System.out.println("One Iteration Over");
            user.changeState(actionVal);
            if(actionVal != 0)
            {
              user.fetchQuestions();
              obs.notifyAllObservers();
            }
			//System.out.println(user.context.getState());          	
          //}
        //}

        }
      }
      else System.out.println("Sorry Invalid Login");
    }
  }
  static ArrayList<String> recordResponses(LoggedInUser user,QuestionClass qc)
  {
  	//QuestionClass qc;
  	//Scanner in=new Scanner(System.in);
    ArrayList<String> response=new ArrayList<>();
    //System.out.println("Main::recordResponses");
    for(int i=0;i<user.currentQuestionSet.size();i++)
    {
      //QuestionClass curr=user.answeredQuestions.get(i);
    //System.out.println(user.currentQuestionSet.get(i).getClass());
      displayQuestions(user.currentQuestionSet.get(i));
      //displaying questions is that responsibility, not taking user input, that is main class responsibilty
      /*
		while(response.add(in.next())!=null || time<maxTime){
			time = now.get(Calendar.MINUTE);
		}
      */
      response.add(in.next());

    }
    return response;
  }
  static void displayQuestions(QuestionClass curr)
  {
      //System.out.print(curr.questionID);
      //System.out.print(":");
      System.out.println(curr.question);
      System.out.println("a)"+curr.optionA);
      System.out.println("b)"+curr.optionB);
      System.out.println("c)"+curr.optionC);
      System.out.println("d)"+curr.optionD);
  }
}