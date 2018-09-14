/**
 * A program to carry on conversations with a human user.
 * This version: 
 * <ul><li>
 *    Uses advanced search for keywords 
 * </li></ul> 
 *    
 * @author Laurie White
 * @version April 2012
 */
import java.util.Scanner;
public class Magpie3
{
	/**
	 * Get a default greeting
	 * 
	 * @return a greeting
	 */
	/*else if(findKeyword(statement,"5")>=0){
	Scanner in=new Scanner(System.in);
	System.out.print("subject:");
	String s=in.nextLine();
	System.out.print("verb:");
	String v=in.nextLine();
	System.out.print("object:");
	String o=in.nextLine();
	System.out.print("object complement:");
	String c=in.nextLine();
	response=type5(s,v,o,c);
}*/
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
		if (statement.length() == 0)
		{
			response = "Say something, please.";
		}
		else if (findKeyword(statement, "no") >= 0)
		{
			response = "Why so negative?";
		}
		else if (findKeyword(statement, "mother") >= 0
				|| findKeyword(statement, "father") >= 0
				|| findKeyword(statement, "sister") >= 0
				|| findKeyword(statement, "brother") >= 0)
		{
			response = "Tell me more about your family.";
		}
		else if (findKeyword(statement, "dog") >= 0
				|| findKeyword(statement, "cat") >= 0
				|| findKeyword(statement, "fish") >= 0
				|| findKeyword(statement, "pet") >= 0)
		{
			response = "Tell me more about your pet.";
		}
		else if (findKeyword(statement, "Mr. Park") >= 0
				|| findKeyword(statement, "teacher") >= 0
				|| findKeyword(statement, "Mrs. Seuk") >= 0
				|| findKeyword(statement, "Mr. Kim") >= 0)
		{
			if(findKeyword(statement, "Mr.")>=0){
				response="He sounds like a good teacher.";
			}
			else if(findKeyword(statement,"Mrs.")>=0||findKeyword(statement,"Ms.")>=0){
				response="She sounds like a good teacher.";
			}
		}
		else if(findKeyword(statement, "Hi") >= 0
				|| findKeyword(statement, "Hello") >= 0){
			response="Hi! Tell me more about you";
		}
		else
		{
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Search for one word in phrase. The search is not case
	 * sensitive. This method will check that the given goal
	 * is not a substring of a longer string (so, for
	 * example, "I know" does not contain "no").
	 *
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @param startPos
	 *            the character of the string to begin the
	 *            search at
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */
	private static int findKeyword(String statement, String goal,
			int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.indexOf(goal, startPos);

		// Refinement--make sure the goal isn't part of a
		// word
		while (psn >= 0)
		{
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1);
			}

			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
											// letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal, psn + 1);

		}

		return -1;
	}

	/**
	 * Search for one word in phrase. The search is not case
	 * sensitive. This method will check that the given goal
	 * is not a substring of a longer string (so, for
	 * example, "I know" does not contain "no"). The search
	 * begins at the beginning of the string.
	 * 
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */
	public static int findKeyword(String statement, String goal)
	{
		return findKeyword(statement, goal, 0);
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * 
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
		String response = "";

		switch(whichResponse){
			case 0:response = "Interesting, tell me more.";
					break;
			case 1: response = "Hmmm.";
					break;
			case 2: response = "Do you really think so?";
					break;
			case 3: response = "You don't say.";
					break;
			case 4: response="Oh really?";
					break;
			case 5: response="That's amazing.";
					break;
		}

		return response;
	}
	public String type5(String s, String v, String o, String c){
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
		String response = "";

		String sub="";
		String verb="";
		String obj="";
		String com="";
		
		if(s.toLowerCase().equals("i")){
			sub="you";
		}
		else if(s.toLowerCase().equals("you")){
			sub="I";
		}
		else{
			sub=s;
		}
		
		if(v.toLowerCase().substring(v.length()-2).equals("ed")){
			verb=v.toLowerCase().substring(0, v.length()-2);
		}
		else if(v.toLowerCase().equals("made")){
			verb="make";
		}
		else if(v.toLowerCase().equals("told")){
			verb="tell";
		}
		else if(v.toLowerCase().equals("got")){
			verb="get";
		}
		else{
			verb=v;
		}
		
		if(o.toLowerCase().equals("me")){
			obj="you";
		}
		else if(o.toLowerCase().equals("you")){
			obj="me";
		}
		else{
			obj=o;
		}
		com=c;
		
		switch(whichResponse){
		
		case 1: response="How did "+sub.toLowerCase()+" "+verb+" "+obj+" "+com+"?";
				break;
		case 2: response="Tell me more about "+obj.toLowerCase();
				break;
		case 3: if(sub=="she"){
			sub="her";
		}
		else if(sub=="he"){
			sub="he";
		}
		else if(sub=="I"){
			sub="you";
		}
		else if(sub=="you"){
			sub="me";
		}
			response="Tell me more about "+sub.toLowerCase();//sub-->obj로 바꾸는거 만들어야 함
				break;
		case 4: if(v=="make"||v=="get"||v=="want"){
					response="Was "+obj.toLowerCase()+" "+"happy to do that?";
					break;
				}
		case 5: if(v=="elect"){
					response="Do you think "+" "+obj.toLowerCase()+" will be a good "+com.toLowerCase()+"?";
							break;
			}
		case 0: response="Why did "+sub.toLowerCase()+" "+" "+verb.toLowerCase()+" "+obj.toLowerCase()+" "+com.toLowerCase()+"?";
		break;
		}
		return response;
	}

	public static void main(String[]args){
		System.out.println(findKeyword("I can't catch wild cats","cat",0));
	}
}
