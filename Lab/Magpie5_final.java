import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;
import chn.util.*;

public class Magpie5_final
{
	//1st_Form_Method
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String transform1st_FormStatement(String subject, String verb, String preposition)
	{
		String newStatement = "";

		String result = Check_AddToFile(verb);
		verb = result.substring(0, result.length()-1);
		int newTense = Integer.parseInt(result.substring(result.length()-1));

		subject = replaceBoth(subject, "I", "you");
		subject = replaceBoth(subject, "your", "my");
		subject = replace(subject, "a", "the");

		final int NUMBER_OF_RESPONSES = 2;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);

		switch(newTense)
		{
			
			// past
			case 0: 

				if(whichResponse == 0)
					newStatement = "Then what happened?";

				else
				{
					if(preposition.equals(""))
						newStatement = "Why did " + subject + " " + verb + "?";

					else
						newStatement = "Why did " + subject + " " + verb + " " + preposition + "?";
				}

				break;

			// present
			case 1: 

				subject = replace(subject, "you", "yourself");
				subject = replace(subject, "me", "myself");
				subject = replace(subject, "he", "him");
				subject = replace(subject, "she", "her");

				newStatement = "What do you mean? Tell me more about " + subject + ".";
	
				break;

			case 2: // future

				if(whichResponse == 0)

					newStatement = "What will " + subject + " do after that?";

				else
				{

					if(preposition.equals(""))
						newStatement = "Are you sure that " + subject + " will " + verb + "?";
					else

						newStatement = "Are you sure that " + subject + " will " + verb + " " + preposition + "?";
				}

				break;
		}
		
		return newStatement;
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//2nd_Form_Method
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String transform2nd_FormStatement(String question, String subject, String verb, String subjectComplement)
	{

		String newStatement = "";
		int typeOfVerb = 0;
		boolean check = false;

		int newTense = 0;
		String newVerb = "",changeVerb="";

		if((findKeyword(subject.toLowerCase(),"this question",0)>=0||findKeyword(subject.toLowerCase(),"the question",0)>=0)&&(findKeyword(subjectComplement,"weird",0)>=0||findKeyword(subjectComplement,"strange",0)>=0||findKeyword(subjectComplement,"awkward",0)>=0)){
				newStatement=questionError(question);
			}
			else if((findKeyword(subject.toLowerCase(),"this conversation",0)>=0||findKeyword(subject.toLowerCase(),"the conversation",0)>=0)&&(findKeyword(subjectComplement,"weird",0)>=0||findKeyword(subjectComplement,"strange",0)>=0||findKeyword(subjectComplement,"awkward",0)>=0)){
				newStatement=conversationError();
			}

		if (check == false)
		{
			FileInput verbs_2ndPerception_Input = new FileInput("2ndPerception.txt");
			while(verbs_2ndPerception_Input.hasMoreTokens()){
				String newLine = verbs_2ndPerception_Input.readLine();
				changeVerb =verb+".";
				if (newLine.length() > changeVerb.length()
					&& changeVerb.equals(newLine.substring(0,changeVerb.length())))
				{
					newVerb=newLine.substring(0,changeVerb.length());
					newTense = Integer.parseInt(newLine.substring(newLine.length()-1,newLine.length()));
					typeOfVerb=1;
					check=true;
					break;
				}
					//typeOfVerb = 1;
					//check = true;
					//break;
			}
			verbs_2ndPerception_Input.close();
		}

		if (check == false)
		{
			FileInput verbs_2ndPerception2_Input = new FileInput("2ndPerception2.txt");
			while(verbs_2ndPerception2_Input.hasMoreTokens()){
				String newLine = verbs_2ndPerception2_Input.readLine();
				changeVerb =verb+".";
				if (newLine.length() > changeVerb.length()
					&& changeVerb.equals(newLine.substring(0,changeVerb.length())))
				{
					newVerb=newLine.substring(0,changeVerb.length());
					newTense = Integer.parseInt(newLine.substring(newLine.length()-1,newLine.length()));
					typeOfVerb=2;
					check=true;
					break;
				}
			}
			verbs_2ndPerception2_Input.close();
		}

		if(check == false)
		{
			FileInput verbs_2ndState_Input = new FileInput("2ndState.txt");
			while(verbs_2ndState_Input.hasMoreTokens()){
				String newLine = verbs_2ndState_Input.readLine();
				changeVerb =verb+".";
				if (newLine.length() > changeVerb.length()
					&& changeVerb.equals(newLine.substring(0,changeVerb.length())))
				{
					newVerb=newLine.substring(0,changeVerb.length());
					newTense = Integer.parseInt(newLine.substring(newLine.length()-1,newLine.length()));
					typeOfVerb=3;
					check=true;
					break;
				}
			}
			verbs_2ndState_Input.close();
		}

		
		if(check == false)
		{
			FileInput verbs_2ndChange_Input = new FileInput("2ndChange.txt");
			while(verbs_2ndChange_Input.hasMoreTokens()){
				String newLine = verbs_2ndChange_Input.readLine();
				changeVerb =verb+".";
				if (newLine.length() > changeVerb.length()
					&& changeVerb.equals(newLine.substring(0,changeVerb.length())))
				{
					newVerb=newLine.substring(0,changeVerb.length());
					newTense = Integer.parseInt(newLine.substring(newLine.length()-1,newLine.length()));
					typeOfVerb=4;
					check=true;
					break;
				}
			}
			verbs_2ndChange_Input.close();
		}

		if(check == false){

				Scanner in = new Scanner (System.in);
				System.out.println("Hmmmm. This is a verb that I need to learn.");
				System.out.println("what is the root form of this verb?");
				newVerb = in.nextLine();
				System.out.println("what is the tense of this verb? 0: past, 1: present, 2: future");
				newTense = in.nextInt();
				System.out.println("what is the type of this verb? 1: Perception1, 2:Perception2, 3: State, 4: Change");
				typeOfVerb = in.nextInt();

				if( typeOfVerb == 1 )
				{
					FileOutput verbs_2ndPerception_Output = new FileOutput("2ndPerception.txt", "append");
					verbs_2ndPerception_Output.print(verb + "." +newVerb+" ");
					verbs_2ndPerception_Output.println(newTense);
					verbs_2ndPerception_Output.close();
				} 

				if( typeOfVerb == 2 )
				{
					FileOutput verbs_2ndPerception2_Output = new FileOutput("2ndPerception2.txt", "append");
					verbs_2ndPerception2_Output.print(verb + "." +newVerb+" ");
					verbs_2ndPerception2_Output.println(newTense);
					verbs_2ndPerception2_Output.close();
				} 

				else if( typeOfVerb == 3 )
				{
					FileOutput verbs_2ndState_Output = new FileOutput("2ndState.txt", "append");
					verbs_2ndState_Output.print(verb + "." +newVerb+" ");
					verbs_2ndState_Output.println(newTense);
					verbs_2ndState_Output.close();
				}

				else if( typeOfVerb == 4 )
				{
					FileOutput verbs_2ndChange_Output = new FileOutput("2ndChange.txt", "append");
					verbs_2ndChange_Output.print(verb + "." +newVerb+" ");
					verbs_2ndChange_Output.println(newTense);
					verbs_2ndChange_Output.close();
				}

				
		}

		//verb = newVerb;
		
		subject = replaceBoth(subject, "I", "you");
		subjectComplement = replaceBoth(subjectComplement, "me", "you");

		subject = replaceBoth(subject, "your", "my");
		subjectComplement = replaceBoth(subjectComplement, "your", "my");

		subject = replaceBoth(subject, "We", "youguys");
		subjectComplement = replaceBoth(subjectComplement, "our", "your");

		subject = replace(subject, "a", "the");
		subjectComplement = replace(subjectComplement, "a", "the");

		subjectComplement = replaceBoth(subjectComplement, "they", "them");

		subject = replace(subject, "he", "him");
		subject = replace(subject, "she", "her");
		
		if (subject.equals("She")||subject.equals("He")||
			subject.equals("Her")||subject.equals("Him")||subject.equals("It")||subject.equals("They"))
		{
			subject = subject.toLowerCase(); 
		}
		
		String lastChar = subjectComplement.substring(subjectComplement.length() - 1);
		if (lastChar.equals("."))
		{
			subjectComplement = subjectComplement.substring(0, subjectComplement.length() - 1);
		}
		lastChar=subject.substring(subject.length()-1);

		final int NUMBER_OF_RESPONSES = 2;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);

		switch(newTense){

		case 0: // past

			if(typeOfVerb == 1)
				newStatement = "Why did " + subject + " " + verb + " " + subjectComplement + "?";

			else if(typeOfVerb == 2)
			{
				newStatement = "Ooh.. I would love to have chat more about that.. Tell me more about " +"\""+ subject + "\".";
			}

			else if(typeOfVerb == 3)
			{
				if(whichResponse == 1)
				{
					newStatement = "I see... What happened to " + subject + " ?";
				}

				else
					newStatement = "Oh really? How about now? Still " + subjectComplement + " ?";
			}
			
			else if(typeOfVerb == 4)
			{
				if(whichResponse == 1)
				{
					if (findKeyword(subject,"your",0)>=0 && findKeyword(subject,"your",0)+3 < subject.length())
					{
						newStatement = "Why did the "+subject+" "+verb+" "+ subjectComplement+"?";
					}
					else 
						newStatement= "What made " + subject + " " + verb + " " + subjectComplement + " ?";

					
				}
			
				else
				{
					if (findKeyword(subject,"your",0)>=0 && findKeyword(subject,"your",0)+3 < subject.length())
					{
						newStatement = "Why did the " + subject + " " + verb + " " + subjectComplement + "?";
					}
					else
						newStatement = "Ooh... What made " + subject + " feel that change?";
				}
			}
				
			break;

		case 1: // present

			if(typeOfVerb == 1)
				newStatement = "Ooh really? Interesting.... Tell me more about " + subject + ".";
			
			else if(typeOfVerb==2)
				newStatement = "Ooh...Honestly... I like that.... Tell me more about " +"\""+ subject + "\".";

			else if(typeOfVerb == 3)
					newStatement = "Ooh... Tell me more about " + subject + ".";

			else if(typeOfVerb == 4)
				if (findKeyword(subject,"your",0)>=0 && findKeyword(subject,"your",0)+3 < subject.length()&&lastChar.equals("s"))
				{ 
					newStatement = "Why do the "+subject+" "+verb+" "+ subjectComplement+"?";
				}
				else if (findKeyword(subject,"your",0)>=0 && findKeyword(subject,"your",0)+3 < subject.length())
				{
					newStatement = "Why does the "+subject+" "+verb+" "+ subjectComplement+"?";
				}
				else newStatement = "Ooh...What made "+ subject + " feel that change?";
				
			break;

			
		case 2: // future
			if(typeOfVerb == 1)
				newStatement = "Yeah probably...Actually, I'm not quite sure... Please tell me more.";

			else if(typeOfVerb == 2)
				newStatement = "Ooh...Honestly... I like that.... Tell me more about " + subject + ".";
	
			else if(typeOfVerb == 3)
				newStatement = "Hmm... Are you really sure about that " + subject + " " + verb + " " + subjectComplement + "?";
			
			else if(typeOfVerb == 4)
				newStatement = "Hmm... Are you really sure about that" + subject + " " + verb + " " + subjectComplement + "?";
				
			break;
			
		}

		if((findKeyword(subject.toLowerCase(), "this question", 0) >= 0 || 
			findKeyword(subject.toLowerCase(), "the question", 0) >= 0) &&
			(findKeyword(subjectComplement, "weird", 0) >=0 || findKeyword(subjectComplement, "strange", 0) >= 0 || 
			findKeyword(subjectComplement, "awkward", 0) >=0 ))

			newStatement = questionError(question);

		else if((findKeyword(subject.toLowerCase(), "this conversation", 0) >= 0 ||
		 	findKeyword(subject.toLowerCase() , "the conversation", 0) >= 0) &&
			(findKeyword(subjectComplement, "weird", 0) >=0 || 
			findKeyword(subjectComplement,"strange",0)>=0 || findKeyword(subjectComplement, "awkward", 0) >= 0))
			
			newStatement = conversationError();

		return newStatement;
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//3rd_Form_Method
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String transform3rd_FormStatement(String subject, String verb, String object)
	{

		String newStatement = "";
		
		String result = Check_AddToFile(verb);
		verb = result.substring(0, result.length()-1);
		int newTense = Integer.parseInt(result.substring(result.length()-1));

		// Changing I -> you, you -> I for subject
		subject = replaceBoth(subject, "I", "you");
		
		// Changing me -> you, you -> me for object
		object = replaceBoth(object, "me", "you");

		// Changing my -> your, your -> my for subject / object
		subject = replaceBoth(subject, "your", "my");
		object = replaceBoth(object, "your", "my");

		// Changing a -> the
		// for both subject and object
		subject = replace(subject, "a", "the");
		object = replace(object, "a", "the");
	

		final int NUMBER_OF_RESPONSES = 5;
				double r = Math.random();
				int whichResponse = (int)(r * NUMBER_OF_RESPONSES);

		switch(newTense){

		case 0: // past
				
				if(whichResponse == 0)
				{
				if(findKeyword(object, "to", 0) >= 0)
				{
					String[] parts = object.split(" ");
					object = parts[parts.length - 1];
				}
				newStatement = "Interesting. Tell me more about " + object + ".";	
				}

				else if(whichResponse == 1)
					newStatement = "Why did " + subject + " " + verb + " " + object + "?";
			
				else if(whichResponse == 2)
					newStatement = "Hmm... Why did " + subject + " " + verb + " " + object + "?";

				else if(whichResponse == 3)
					newStatement = "Really? How did " + subject + " " + verb + " " + object + "?";

				else 
					newStatement = "Oh. Why did " + subject + " " + verb + " " + object + "?";
			
				break;

		case 1: // present

			if(whichResponse == 0)
			{
				if(findKeyword(object, "to", 0) >= 0)
				{
					String[] parts = object.split(" ");
					object = parts[parts.length - 1];
				}
				newStatement = "Interesting. Tell me more about " + object + ".";	
			}

			else if(whichResponse == 1)
			{
				if(findKeyword(subject, "you", 0) >= 0) newStatement = "Why do " + subject + " " + verb + " " + object + "?";
				else newStatement = "Why does " + subject + " " + verb + " " + object + "?";
			}

			else if(whichResponse == 2)
			{
				if(findKeyword(subject, "you", 0) >= 0) newStatement = "Hmm... Why do " + subject + " " + verb + " " + object + "?";
				else newStatement = "Hmm... Why does " + subject + " " + verb + " " + object + "?";
			}

			else if(whichResponse == 3)
			{
				if(findKeyword(subject, "you", 0) >= 0) newStatement = "Really? How do " + subject + " " + verb + " " + object + "?";
				else newStatement = "Really? How does " + subject + " " + verb + " " + object + "?";
			}
				
			else 
			{
				if(findKeyword(subject, "you", 0) >= 0) newStatement = "Oh. Why do you " + verb + " " + object + "?";
				else newStatement = "Oh. Why does " + subject + " " + verb + " " + object + "?";
			}

			break;

		case 2: // future

			if(whichResponse == 0)
			{
				if(findKeyword(object, "to", 0) >= 0)
				{
					String[] parts = object.split(" ");
					object = parts[parts.length - 1];
				}
				newStatement = "Interesting. Tell me more about " + object + ".";	
			}

			else if(whichResponse == 1)
				newStatement = "Why will " + subject + " " + verb + " " + object + "?";

			else if(whichResponse == 2)
				newStatement = "Hmm... Why will " + subject + " " + verb + " " + object + "?";

			else if(whichResponse == 3)
				newStatement = "Really? How will " + subject + " " + verb + " " + object + "?";
			
			else 
				newStatement = "Oh. Why will " + subject + " do that?";
			
			break;

		}

		return newStatement;
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//4th_Form_Method
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String transform4th_FormStatement(String subject, String verb, String directObject, String indirectObject)
	{
		
		String newStatement = "";
		

		String result = Check_AddToFile(verb);
		verb = result.substring(0, result.length()-1);
		int newTense = Integer.parseInt(result.substring(result.length()-1));


		subject = replaceBoth(subject, "I", "you");
		directObject = replaceBoth(directObject, "me", "you");

		subject = replaceBoth(subject, "your", "my");
		directObject = replaceBoth(directObject, "your", "my");
		indirectObject = replaceBoth(indirectObject, "your", "my");

		subject = replace(subject, "a", "the");
		directObject = replace(directObject, "a", "the");
		indirectObject = replace(indirectObject, "a", "the");


		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		
		switch(newTense){
		
		case 0: // past

			if (whichResponse == 0)
				if (directObject.equals("you"))
					newStatement = "Do you like yourself?";
				else
					newStatement = "Do you like " + directObject + "?";

			else if (whichResponse == 1)
			{
				if (findKeyword(directObject, "you", 0) >= 0)
					newStatement = "Were you happy?";
				
				else
				{
					directObject = replace(directObject, "him", "he");
					directObject = replace(directObject, "her", "she");				
					newStatement = "Was " + directObject + " happy?";
				}
			}

			else if (whichResponse == 2)
			
				newStatement = "Why did " + subject + " do that?";

			else if (whichResponse == 3)

				newStatement = "Tell me more about " + directObject + ".";


			else if (whichResponse == 4)
				
				newStatement = "Why did " + subject + " " + verb + " " + directObject + " " + indirectObject + "?";

			else

				newStatement = "How did " + subject + " " + verb + " " + directObject + " " + indirectObject + "?";
			
			break;

		case 1: // present

			if (whichResponse == 0)
					if (directObject.equals("you"))
						newStatement = "Do you like yourself?";
					else
						newStatement = "Do you like " + directObject + "?";


			else if (whichResponse == 1)
			{
				if (findKeyword(directObject, "you", 0) >= 0)
					newStatement = "Are you happy?";

				else
				{
					directObject = replace(directObject, "him", "he");
					directObject = replace(directObject, "her", "she");				
					newStatement = "Is " + directObject + " happy?";
				}
			}

			else if (whichResponse == 2)
	
				newStatement = "Why do " + subject + " do that?";
	

			else if (whichResponse == 3)
	
				newStatement = "Tell me more about " + directObject + ".";

			else if (whichResponse == 4)
			{
				if (findKeyword(subject, "I", 0) >= 0 || findKeyword(subject, "you", 0) >= 0)
					newStatement = "Why do " + subject + " " + verb + " " + directObject + " " + indirectObject + "?";

				else 
					newStatement = "Why does " + subject + " " + verb + " " + directObject + " " + indirectObject + "?";
			}

			else if(whichResponse == 5)
			{
				if (findKeyword(subject, "I", 0) >= 0 || findKeyword(subject, "you", 0) >= 0 )
					newStatement = "How do " + subject + " " + verb + " " + directObject + " " + indirectObject + "?";

				else 
					newStatement = "How does " + subject + " " + verb + " " + directObject + " " + indirectObject + "?";
			}

			break;

		case 2: // future

			if (whichResponse == 0)
			{
				if (findKeyword(directObject, "me", 0) >= 0)
					newStatement = "Do you like me?";
				else
					if (directObject.equals("you"))
						newStatement = "Do you like yourself?";
					else
						newStatement = "Do you like " + directObject + "?";
			}

			else if (whichResponse == 1)
			{
				// him -> he, her -> she
				// for directObject
				if(findKeyword(directObject, "him", 0) >= 0)
					directObject = "he";

				if(findKeyword(directObject, "her", 0) >= 0)
					directObject = "she";

				newStatement = "Do you think " + directObject + " will be happy?";
			}

			else if (whichResponse == 2)
			
				newStatement = "Why will " + subject + " do that?";

			else if (whichResponse == 3)
	
				newStatement = "Tell me more about "+directObject+".";
	
			else if (whichResponse == 4)
	
				newStatement = "Why will " + subject + " " + verb + " " + directObject + " " + indirectObject+"?";
	
			else if(whichResponse == 5)
			
				newStatement = "How will " + subject + " " + verb + " " + directObject + " " + indirectObject+"?";
			

			break;
		}

		return newStatement;
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	//5th_Form_Method
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		public String transform5th_FormStatement(String subject, String verb, String object, String objectComplement)
		{
			
			String newStatement = "";
			

			String result = Check_AddToFile(verb);
			verb = result.substring(0, result.length()-1);
			int newTense = Integer.parseInt(result.substring(result.length()-1));

			
			// Changing I -> you, you -> I for subject
			subject = replaceBoth(subject, "I", "you");
			
			// Changing me -> you, you -> me for object
			object = replaceBoth(object, "me", "you");

			// Changing my -> your, your -> my for subject / object
			subject = replaceBoth(subject, "your", "my");
			object = replaceBoth(object, "your", "my");

			// Changing a -> the
			// for both subject and object
			subject = replace(subject, "a", "the");
			object = replace(object, "a", "the");

			final int NUMBER_OF_RESPONSES = 6;
			double r = 0.0;

			while(newStatement == "")
			{
				r = Math.random();
				int whichResponse = (int) (r * NUMBER_OF_RESPONSES);

				switch(newTense){
				
					case 0: 
		
						if(whichResponse == 0)
							newStatement = "How did " + subject + " " + verb + " " + object + " " + objectComplement + "?";

						else if(whichResponse == 1)
							newStatement = "Tell me more about " + object + ".";
		
						else if(whichResponse == 2)
						{
							subject = replace(subject, "she", "her");
							subject = replace(subject, "he", "him");
							newStatement = "Tell me more about " + subject;
						}
		
						else if(whichResponse == 3)
						{
							if(findKeyword(verb, "elect", 0) >= 0)
							{
								object = replace(object, "she", "her");
								object = replace(object, "he", "him");
							
								newStatement = "Do you think" + " " + object + " will be a good " + objectComplement + "?";
							}
						}
		
						else if(whichResponse == 4)
						{
							if(verb.equals("make") || verb.equals("get") || verb.equals("want"))
								newStatement = "Was " + object + " " + "happy to do that?";
						}
		
						else
							newStatement = "Why did " + subject + " " + verb + " " + object + " " + objectComplement + "?";
						
						break;


					case 1:

						if(whichResponse == 0)
							newStatement = "How does " + subject + " " + verb + " " + object + " " + objectComplement + "?";

						else if(whichResponse == 1)
							newStatement = "Tell me more about " + object + ".";
						
						else if(whichResponse == 2)
						{
							subject = replace(subject, "she", "her");
							subject = replace(subject, "he", "him");
							newStatement = "Tell me more about " + subject;
						}

						else if(whichResponse == 3)
						{
							if(findKeyword(verb, "elect" , 0) >= 0)
							{
								object = replace(object, "she", "her");
								object = replace(object, "he", "him");
								String[] parts = objectComplement.split(" ");
								objectComplement  = parts[parts.length - 1];
								newStatement = "Do you think" + " " + object + " will be a good " + objectComplement + "?";
							}
						}

						else if(whichResponse == 4)
						{
							if(verb.equals("make") || verb.equals("get") || verb.equals("want"))
								newStatement = "Is " + object + " " + "happy to do that?";
						}

						else 
							newStatement = "Why does " + subject + " " + verb + " " + object + " " + objectComplement + "?";
					
						break;


					case 2:

						if(whichResponse == 0)
							newStatement = "How will " + subject + " " + verb + " " + object + " " + objectComplement + "?";

						else if(whichResponse == 1)
							newStatement = "Tell me more about " + object + ".";

						else if(whichResponse == 2){
							subject = replace(subject, "she", "her");
							subject = replace(subject, "he", "him");
							newStatement = "Tell me more about " + subject;
						}

						else if(whichResponse == 3)
						{
							if(findKeyword(verb, "elect", 0) >= 0)
							{
								object = replace(object, "she", "her");
								object = replace(object, "he", "him");
								newStatement = "Do you think" + " " + object + " will be a good " + objectComplement + "?";
							}
						}

						else if(whichResponse == 4)
						{
							if(verb.equals( "make") || verb.equals("get") || verb.equals("want"))
							{
								newStatement = "Will " + object + " " + "happy to do that?";
							}
						}

						else 
							newStatement = "Why will " + subject + " " + verb + " " + object + " " + objectComplement + "?";
						
						break;
				}
			}

			return newStatement;
		}
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////



	//Additional methods
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private int findKeyword(String statement, String goal, int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		//The only change to incorporate the startPos is in the line below
		int psn = phrase.indexOf(goal, startPos);

		//Refinement--make sure the goal isn't part of a word
		while (psn >= 0)
		{
			//Find the string of length 1 before and after the word
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

			//If before and after aren't letters, we've found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}

			//The last position didn't work, so let's find the next, if there is one.
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
	
	private String [] randomResponses = 
	{
		"Interesting, tell me more",
		"Hmmm.",
		"Do you really think so?",
		"You don't say.",
		"I disagree."
	};

	private String questionError(String question)
	{
		FileOutput out = new FileOutput("questionError.txt", "append");
		String response = "I'm sorry, let's try again.\n";
		response = response + getRandomQuestion();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		out.println("Question at " + dtf.format(now) + " : " + question);
		out.close();
		return response;
	}

	private String conversationError()
	{
		String response = "***********ERROR!!!***********\nI'm sorry, let's try again\n";
		response = response + getRandomQuestion();

		return response;
	}

	public String getRandomQuestion()
	{
		Random r=new Random();
		return (String)(randomQuestions.remove(r.nextInt(randomQuestions.size())));
	}
	
	private List<String> randomQuestions = new ArrayList<String>();
	
	public void init()
	{
		String[] questions = 
		{ 
			"What did you do yesterday?",
			"What did you eat today?",
			"Tell me about your family.",
			"Tell me about yourself.",
			"What do you do to get rid of stress?",
			"Tell me about your one of your pets.",
			"What do you want to do right now?",
			"What do you want to do in the future?",
			"What did you do today?",
			"Do you like me?"
		};

		for(String a : questions){
			randomQuestions.add(a);
		}
	}

	

//Replace a with b, or b with a.
	private	String replaceBoth(String statement, String a, String b)
	{
		// I you I you -> you I you I
		// ArrayList to save the indexes of a, b
		ArrayList<Integer> a_list = new ArrayList<Integer>();
		ArrayList<Integer> b_list = new ArrayList<Integer>();
		
		int count_a = 0;
		int count_b = 0;
		
		int newIndex = 0;
		while(findKeyword(statement, a, count_a) >= 0)
		{
			newIndex = findKeyword(statement, a, count_a);
			a_list.add(newIndex);
			count_a = newIndex + a.length();
		}

		while(findKeyword(statement, b, count_b) >= 0)
		{
			newIndex = findKeyword(statement, b, count_b);
			b_list.add(newIndex);
			count_b = newIndex + b.length();
		}
		
		int newIndex2 = 0;
		for(Integer seq : a_list){
			newIndex2 = seq + a_list.indexOf(seq) * (b.length() - a.length());
			
			for(Integer check : b_list)
				if(check > newIndex2)
					b_list.set(b_list.indexOf(check), check + (b.length() - a.length()));		
			
			statement = statement.substring(0, newIndex2) + b + statement.substring(newIndex2 + a.length()); 
		}

		for(Integer seq : b_list){
			newIndex2 = seq + b_list.indexOf(seq) * (a.length() - b.length());
			statement = statement.substring(0, newIndex2) + a + statement.substring(newIndex2 + b.length()); 
		}

		return statement;
	}
	
	
private	String replace(String statement, String a, String b)
	{	
		int count = 0;

		while(findKeyword(statement, a, count) >= 0)
		{
			int newIndex = findKeyword(statement, a, count);
			statement = statement.substring(0, newIndex) + b + statement.substring(newIndex + a.length());
			
			count = newIndex + b.length();
		}

		return statement;
	}

	private String Check_AddToFile(String verb)
	{
		FileInput verbs_Input = new FileInput("wordBank.txt");
		boolean check = false;
		String newVerb = "", changeVerb = verb;

		while(verbs_Input.hasMoreTokens()){
			String newLine = verbs_Input.readLine();
			changeVerb += ".";

			if(newLine.length() > changeVerb.length() 
			 && changeVerb.equals(newLine.substring(0, changeVerb.length()))
			){
				newVerb = newLine.substring(changeVerb.length(), newLine.length()); 
				check = true;
				break;
			} 
		}

		verbs_Input.close();
		
		if(!check){
			Scanner in = new Scanner (System.in);
			System.out.println("Hmmmm. This is a verb that I need to learn.");
			System.out.println("what is the root form of this verb?");
			newVerb = in.nextLine();
			System.out.println("what is the tense of this verb? 0: past, 1: present, 2: future");
			newVerb += in.nextInt();
					
			FileOutput verbs_Output = new FileOutput("wordBank.txt", "append");
			verbs_Output.print(verb + "." + newVerb);
			verbs_Output.println();
			verbs_Output.close();
		}

		return newVerb;
	}


	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
