import java.util.*;
import java.io.*;
import java.lang.*;
import java.nio.file.*;
class USN
{
	String USN;
	USN(String USN)
	{
		this.USN=USN;
	}
	static boolean Validate(String USN)
  {
    String data = "";
    try
    {
      data = new String(Files.readAllBytes(Paths.get("USN.txt")));
      if(data.contains(USN))
        return true;
      else return false;
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return false;
  }
}