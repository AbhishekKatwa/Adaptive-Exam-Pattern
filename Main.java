import java.util.*;
class ThreadClass implements Runnable {
   private Thread t;
   private String threadName;
   
   static ArrayList<LoggedInUser> loggedInUsers=new ArrayList<>();
  //Scanner in=new Scanner(System.in);
  //decalaration of all the classes that it is going to need to complete all its functionalities
  	static QuestionClass qc;
  	static Evaluation eval;
  	static LoggedInUser user;
  	static USN usn;
  	static Scanner in=new Scanner(System.in);
  	static Observer obs ;
  	static Calendar now = Calendar.getInstance();
  	static int time = now.get(Calendar.HOUR_OF_DAY) *60+ now.get(Calendar.MINUTE);
  	//now = Calendar.getInstance();
  	static int maxTime = time + 1;
  	//time = now.get(Calendar.HOUR_OF_DAY) *60+ now.get(Calendar.MINUTE);
  	//maxTime +=time;
   ThreadClass( String name) {
      threadName = name;
      //System.out.println("Creating " +  threadName );
   }
   
   public void run() {
      //System.out.println("Running " +  threadName );
      try {
         if("Main".equals(threadName))
         	Main_method();
         else if("Time".equals(threadName))
         	time_method();
      } catch (Exception e) {
         System.out.println("Thread " +  threadName + " interrupted.");
      }
      System.out.println("Thread " +  threadName + " exiting.");
   }

   public void Main_method(){
   	while(true)
    {

      System.out.println("Enter USN:");
      String USN=in.next();
      
      //time = now.get(Calender.HOUR) *60;
      time = now.get(Calendar.HOUR_OF_DAY) *60+ now.get(Calendar.MINUTE);
  	  maxTime = 0;
  	  maxTime += time;
      System.out.println(time);
      if(usn.Validate(USN))
      if(true)
      {
        //LoggedInUser us=doTheNecessaryFirstTime(USN);
        user=new LoggedInUser(USN);
        //obs.attach(user);
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
            
            if(actionVal != 0)
            {
              
              if(actionVal == -1 && user.context.getState() == user.easyState){
	            obs.notifyAllObservers("************Very Poor************");
	            System.exit(0);
              }
              else if(actionVal == 1 && user.context.getState() == user.hardState){
              	obs.notifyAllObservers("************Excellent***********");
              	System.exit(0);
              }
              user.changeState(actionVal);
              user.fetchQuestions();
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

   public void time_method(){
   		
   		while(time<maxTime){
   			now = Calendar.getInstance();
   			time = now.get(Calendar.HOUR_OF_DAY) *60 + now.get(Calendar.MINUTE);
   		}
   		obs.notifyAllObservers("*******************Time left is 2 minutes*******************");
   		maxTime += 2; 
   		while(time<maxTime){
   			now = Calendar.getInstance();
   			time = now.get(Calendar.HOUR_OF_DAY) *60 + now.get(Calendar.MINUTE);
   		}
   		obs.notifyAllObservers("*******************Thank you for taking the test*******************");
   		System.exit(0);

   }
   
   public void start () {
      //System.out.println("Starting " +  threadName );
      if (t == null) {
         t = new Thread (this, threadName);
         t.start ();
      }
   }
}
public class Main
{
  
  public static void main(String[] args) 
  {
  	
    ThreadClass R1 = new ThreadClass( "Main");
      R1.start();
      
      ThreadClass R2 = new ThreadClass( "Time");
      R2.start();
  }
  
}