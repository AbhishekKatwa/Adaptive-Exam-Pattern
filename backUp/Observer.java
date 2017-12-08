import java.util.Timer;
import java.util.ArrayList;
class Observer
{
	static ArrayList<LoggedInUser> loggedInUsers=new ArrayList<>();
	public void attach(LoggedInUser observer)
	{
      loggedInUsers.add(observer);		
   }

   public static void notifyAllObservers()
   {
      for (LoggedInUser l: loggedInUsers) 
      {
         //l.update();
      	//System.out.println("Time out/Error Occurred");
         
      }
      System.out.println("Observer Pattern : State Changed");
   } 	
}