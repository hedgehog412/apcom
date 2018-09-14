import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;

import chn.util.*;

//import 모두 해줘야함 
public class Magpie5_2
{


	public Magpie5_2(){//처음에 arraylist에다가 randomqustion을 넣기 위해 
		init();
	}
	
	public String transform1st_FormStatement(String subject, String verb)
	{
		String newStatement = "";

		{
			if(findKeyword(subject, "I", 0) >= 0) subject = "you";
			else if(findKeyword(subject, "you", 0) >= 0) subject = "I";
		}

		if(findKeyword(subject, "they") >= 0 || findKeyword(subject, "we") >= 0)
			newStatement = "Who sepcifically?";

		else {
			if(verb.length() <= 4)
				newStatement = "Then what happened?";

			else if (subject.length()+verb.length() > 4 && subject.length()+verb.length() <= 8)
				newStatement = "Tell me more.";

			else
				newStatement = "When did " + subject + verb+ "?";
		}

		return newStatement;


	}

	public String transform2nd_FormStatement(String question,String subject, String verb, String subjectComplement)
	{
		String newStatement = "";

		{
			if(findKeyword(subject, "I", 0) >= 0) subject = "you";
			else if(findKeyword(subject, "you", 0) >= 0) subject = "I";
		}

		
		//***에러 잡아내는 코드가 추가됨
		if((findKeyword(subject.toLowerCase(),"this question",0)>=0||findKeyword(subject.toLowerCase(),"the question",0)>=0)&&(findKeyword(subjectComplement,"weird",0)>=0||findKeyword(subjectComplement,"strange",0)>=0||findKeyword(subjectComplement,"awkward",0)>=0)){
			newStatement=questionError(question);
		}
		else if((findKeyword(subject.toLowerCase(),"this conversation",0)>=0||findKeyword(subject.toLowerCase(),"the conversation",0)>=0)&&(findKeyword(subjectComplement,"weird",0)>=0||findKeyword(subjectComplement,"strange",0)>=0||findKeyword(subjectComplement,"awkward",0)>=0)){
			newStatement=conversationError();
		}
		else{

			final int NUMBER_OF_RESPONSES = 3;
			double r = Math.random();
			int whichResponse = (int)(r*NUMBER_OF_RESPONSES);


			if (whichResponse == 0)
				newStatement = "What made "+ subject + " " + subjectComplement+"?";

			else if (whichResponse == 1)
				newStatement = "Tell me more about " + subject + ".";

			else if (whichResponse == 3)
				newStatement = "I see... Tell me more about the "+ subject + ".";
		}

		return newStatement;

	}


	public String transform3rd_FormStatement(String subject, String verb, String object)
	{
		String newStatement = "";

		{
			if(findKeyword(subject, "I", 0) >= 0) subject = "you";
			else if(findKeyword(subject, "you", 0) >= 0) subject = "I";
		}

		{
			if(findKeyword(object, "me", 0) >= 0) object = "you";
			else if(findKeyword(object, "you", 0) >= 0)	object = "me";
		}

		if(verb.substring(verb.length()-2, verb.length()).equals("ed")){

			verb = verb.substring(0, verb.length()-2);
			if(verb.substring(verb.length()-1).equals("i"))
				verb = verb.substring(0, verb.length()-1) + "y";

			final int NUMBER_OF_RESPONSES = 3;
			double r = Math.random();
			int whichResponse = (int)(r * NUMBER_OF_RESPONSES);

			if(whichResponse == 0){
				String[] parts = object.split(" ");
				object = parts[parts.length - 1];
				newStatement = "Interesting. Tell me more about " + object + ".";	
			}

			else{
				newStatement = "Why did " + subject + " " + verb + " " + object + "?";
			}			
		}

		else if(findKeyword(verb, "went", 0) >=0){

			final int NUMBER_OF_RESPONSES = 3;
			double r = Math.random();
			int whichResponse = (int)(r*NUMBER_OF_RESPONSES);

			if(whichResponse == 0){
				String[] parts = object.split(" ");
				object = parts[parts.length - 1];
				newStatement = "What? Tell me more about " + object + ".";	
			}

			else{
				newStatement = "Why did " + subject + " go " + object + "?";
			}			
		}

		else if(findKeyword(verb, "ate", 0) >=0){

			{
				if(findKeyword(subject, "I", 0) >= 0) subject = "you";
				else if(findKeyword(subject, "you", 0) >= 0) subject = "I";
			}

			{
				if(findKeyword(object, "me", 0) >= 0) object = "you";
				else if(findKeyword(object, "you", 0) >= 0)	object = "me";
			}

			final int NUMBER_OF_RESPONSES = 3;
			double r = Math.random();
			int whichResponse = (int)(r*NUMBER_OF_RESPONSES);

			if(whichResponse == 0){
				String[] parts = object.split(" ");
				object = parts[parts.length - 1];
				newStatement = "Wow! Tell me more about " + object + ".";	
			}

			else
				newStatement = "Why did " + subject + " eat " + object + "?";		
		}

		else if(findKeyword(verb, "had", 0) >=0){

			final int NUMBER_OF_RESPONSES = 2;
			double r = Math.random();
			int whichResponse = (int)(r*NUMBER_OF_RESPONSES);

			if(whichResponse == 0){
				String[] parts = object.split(" ");
				object = parts[parts.length - 1];
				newStatement = "Interesting... Tell me more about " + object + ".";
			}

			else{
				newStatement = "Why did " + subject + " have " + object + "?";			
			}			
		}


		else if(verb.length() > 4 && verb.substring(0, 4).equals("will")){

			verb = verb.substring(5, verb.length());

			final int NUMBER_OF_RESPONSES = 3;
			double r = Math.random();
			int whichResponse = (int)(r*NUMBER_OF_RESPONSES);

			if(whichResponse == 0){
				newStatement = "Why will " + subject + " do that?";	
			}

			else if(whichResponse == 1){
				newStatement = "Why will " + subject + " " + verb + " " + object + "?";		
			}			

			else{
				String[] parts = object.split(" ");
				object = parts[parts.length - 1];
				newStatement = "Hmm.. Tell me more about " + object + ".";
			}
		}

		else {

			final int NUMBER_OF_RESPONSES = 2;
			double r = Math.random();
			int whichResponse = (int)(r*NUMBER_OF_RESPONSES);

			if(whichResponse == 0){
				String[] parts = object.split(" ");
				object = parts[parts.length - 1];
				newStatement = "Hmm.. Tell me more about " + object + ".";
			}

			else{
				if(findKeyword(subject, "you", 0) < 0) newStatement = "Why does " + subject + " " + verb + " " + object + "?";
				else newStatement = "Why do " + subject + " " + verb + " " + object + "?";
			}
		}

		return newStatement;

	}

	public String transform4th_FormStatement(String subject, String verb, String directObject, String indirectObject){

		String newStatement = "";

		final int NUMBER_OF_RESPONSES = 3;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0)
			newStatement = "Do you like " + directObject + "?";

		else if (whichResponse == 1)
			newStatement = "Was " + directObject + " happy?";

		else if (whichResponse == 2)
			newStatement = "Why did " + subject + " did that?";

		return newStatement;

	}

	public String transform5th_FormStatement(String subject, String verb, String object, String objectComplement){//text file사용 가능 하게 코드 바뀜 
		FileInput verbs_5th_Input = new FileInput("5th.txt");
		boolean check = false;

		int newTense = 0;
		String newVerb = "";

		while(verbs_5th_Input.hasMoreTokens()){
			String newLine = verbs_5th_Input.readLine();
			char newLine_2[] = newLine.toCharArray();
			if(findKeyword(newLine, verb, 0) == 0){
				int i = 0;
				for(i = verb.length()+1 ; newLine_2[i] != ' ' ; i++)
					newVerb += newLine_2[i];
				newTense =  Character.getNumericValue(newLine_2[i+1]);
				check = true;
				break;
			}
		}

		verbs_5th_Input.close();

		if(!check){
			Scanner in = new Scanner (System.in);
			System.out.println("Hmmmm. This is a verb that I need to learn.");
			System.out.println("what is the root form of this verb?");
			newVerb = in.nextLine();
			System.out.println("what is the tense of this verb? 0: past, 1: present, 2: future");
			newTense = in.nextInt();

			FileOutput verbs_5th_Output = new FileOutput("5th.txt", "append");
			verbs_5th_Output.print(verb + " ");
			verbs_5th_Output.print(newVerb + " ");
			verbs_5th_Output.println(newTense);
			verbs_5th_Output.close();
		}

		verb = newVerb;

		String newStatement = "empty";

		{
			subject=subject.toLowerCase();
			if(findKeyword(subject, "i", 0) >= 0) subject = "you";
			else if(findKeyword(subject, "you", 0) >= 0) subject = "I";
			else if(findKeyword(subject,"my",0)>=0){
				subject=subject.substring(3);
				subject="your "+subject;
			}
			else if(findKeyword(subject,"your",0)>=0){
				subject=subject.substring(5);
				subject="my "+subject;
			}
		}

		{
			if(findKeyword(object, "me", 0) >= 0) object = "you";
			else if(findKeyword(object, "you", 0) >= 0)	object = "me";
			else if(findKeyword(object,"my",0)>=0){
				object=object.substring(3);
				object="your "+object;
			}
			else if(findKeyword(object,"your",0)>=0){
				object=object.substring(5);
				object="my "+object;
			}
		}

		if(verb.substring(verb.length()-2).equals("ed")){
			verb = verb.substring(0, verb.length()-2);

			if(verb.substring(verb.length()-1).equals("i"))
				verb = verb.substring(0, verb.length()-1) + "y";
		}

		else if((findKeyword(verb, "made", 0) >= 0)||(findKeyword(verb,"makes",0)>=0))
			verb="make";

		else if(findKeyword(verb, "told", 0) >= 0)
			verb="tell";

		else if(findKeyword(verb, "got", 0) >= 0)
			verb="get";
		else if(findKeyword(verb,"bought",0)>=0)
			verb="buy";

		if(findKeyword(subject, "a", 0) >= 0)
			subject = "the" + subject.substring(1);

		if(findKeyword(object, "a", 0) >= 0)
			object = "the" + object.substring(1);


		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int) (r * NUMBER_OF_RESPONSES);

		while(newStatement.equals("empty")){

			switch(newTense){

			case 0: 
				if(whichResponse==0){
					newStatement = "How did " + subject + " " + verb + " " + object + " " + objectComplement + "?";
				}
				else if(whichResponse==1){
					newStatement = "Tell me more about " + object + ".";}
				else if(whichResponse==2){
					if(subject.equals("she")) 
						subject = "her";

					else if(subject.equals("he"))
						subject = "him";

					newStatement = "Tell me more about " + subject;}
				else if(whichResponse==3){
					if(findKeyword(verb,"elect",0)>=0){
						if(object.equals("her")){
							object="she";
						}
						else if(object.equals("him")){
							object="he";
						}
						newStatement = "Do you think" + " " + object + " will be a good " + objectComplement + "?";
					}}
				else if(whichResponse==5){
					if(verb.equals( "make") || verb.equals("get") || verb.equals("want")){
						newStatement = "Was " + object + " " + "happy to do that?";}}
				else if(whichResponse==6){
					newStatement = "Why did " + subject + " " + verb + " " + object + " " + objectComplement + "?";}
				break;
			case 1:
				if(whichResponse==0){
					newStatement = "How does " + subject + " " + verb + " " + object + " " + objectComplement + "?";
				}
				else if(whichResponse==1){
					newStatement = "Tell me more about " + object + ".";}
				else if(whichResponse==2){
					if(subject.equals("she")) 
						subject = "her";

					else if(subject.equals("he"))
						subject = "him";

					newStatement = "Tell me more about " + subject;}
				else if(whichResponse==3){
					if(findKeyword(verb,"elect",0)>=0){
						if(object.equals("her")){
							object="she";
						}
						else if(object.equals("him")){
							object="he";
						}
						newStatement = "Do you think" + " " + object + " will be a good " + objectComplement + "?";
					}}
				else if(whichResponse==5){
					if(verb.equals( "make") || verb.equals("get") || verb.equals("want")){
						newStatement = "Is " + object + " " + "happy to do that?";}}
				else if(whichResponse==6){
					newStatement = "Why does " + subject + " " + verb + " " + object + " " + objectComplement + "?";}
				break;
			case 2:
				if(whichResponse==0){
					newStatement = "How will " + subject + " " + verb + " " + object + " " + objectComplement + "?";
				}
				else if(whichResponse==1){
					newStatement = "Tell me more about " + object + ".";}
				else if(whichResponse==2){
					if(subject.equals("she")) 
						subject = "her";

					else if(subject.equals("he"))
						subject = "him";

					newStatement = "Tell me more about " + subject;}
				else if(whichResponse==3){
					if(findKeyword(verb,"elect",0)>=0){
						if(object.equals("her")){
							object="she";
						}
						else if(object.equals("him")){
							object="he";
						}
						newStatement = "Do you think" + " " + object + " will be a good " + objectComplement + "?";
					}}
				else if(whichResponse==5){
					if(verb.equals( "make") || verb.equals("get") || verb.equals("want")){
						newStatement = "Will " + object + " " + "happy to do that?";}}
				else if(whichResponse==6){
					newStatement = "Why will " + subject + " " + verb + " " + object + " " + objectComplement + "?";}
				break;
			}
		}

		return newStatement;
	}



	private int findKeyword(String statement, String goal, int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		int psn = phrase.indexOf(goal, startPos);


		while (psn >= 0)
		{

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


			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) 
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}


			psn = phrase.indexOf(goal, psn + 1);

		}

		return -1;
	}

	public int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}


	private String getRandomResponse()
	{
		Random r = new Random ();
		return randomResponses [r.nextInt(randomResponses.length)];
	}

	private String [] randomResponses = {"Interesting, tell me more",
			"Hmmm.",
			"Do you really think so?",
			"You don't say.",
			"I disagree."
	};

	//여기 뒤부터 에러 메소드와 random qustion이 추가됨 
	private String questionError(String question){
		FileOutput out=new FileOutput("questionError.txt", "append");
		String response="I'm sorry, let's try again\n";
		response=response+getRandomQuestion();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		out.println("Question at "+dtf.format(now)+" : "+question);
		out.close();
		return response;
	}

	private String conversationError(){
		String response="***********ERROR!!!***********\nI'm sorry, let's try again\n";
		response=response+getRandomQuestion();

		return response;
	}

	public String getRandomQuestion(){
		Random r=new Random();
		return (String) randomQuestions.remove(r.nextInt(randomQuestions.size()));
	}
	
	private static List<String> randomQuestions=new ArrayList<String>();
	static void init(){
	String[] questions={ "What did you do yesterday?",
			"What did you eat today?",
			"Tell me about your family.",
			"Tell me about you.",
			"What do you do to get rid of stress?",
			"Tell me about your pets.",
			"What do you want to do right now?",
			"What do you want to do in the future?",
			"What did you do today?"
	};
	for(String a:questions){
		randomQuestions.add(a);
	}
	}
}

