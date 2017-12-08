import java.util.Timer;
import java.util.ArrayList;
class Observer
{
	static ArrayList<LoggedInUser> loggedInUsers=new ArrayList<>();
	public void attach(LoggedInUser observer)
	{
      loggedInUsers.add(observer);		
   }

   public static void notifyAllObservers(String status)
   {
      	System.out.println(status);
   } 	
}