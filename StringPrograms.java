package GBSoft.Learning;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;

public class StringPrograms
{
	static final int MAX_CHAR = 256;

	public static void main(String[] args) 
	{
		String str1 = "Girish";
		String str2 = "Ramesh";
		String str3 = "Bhujbal";
		
        String str = "aAcCbB";
        StringBuilder str4 = new StringBuilder(str);
        //char[] chars = str.toCharArray();
        //Arrays.sort(chars);
        System.out.println(str4);
		
		int mArray[] = {5,3,1008,343,23,33,9,54,502,33,45};
		Arrays.sort(mArray);
		
		/* String S1 = "Girish";
		String S2 = new String("Girish");
		System.out.println(S1 == S2);
		System.out.println(S1.equals(S2)); */
		
		String mVar = "I live in India";

		mVar = mVar.replaceAll(" ","");
		mVar = mVar + "1";
		//System.out.println(mVar);
		
		//System.out.println(mArray[mArray.length-1]);

		//Add 3 strings
		//System.out.println(str1.concat(str2).concat(str3));

		MergeStrings();
		//CharTypesinString("Helloo World");
		//CheckOddEvenNumbers(80);
		//StringReverse("I love to write Selenium with Java coding");
		//getOccurringChar("I love to write Selenium with Java coding");
	
		//removeDuplicates("Girish");
		//PrintDuplicateChar("Girish 1122");

		//String inputString = "Banana";
		//String mTmp = inputString.replaceAll("", " ");
		//System.out.println(mTmp);
		//char secondHighestOccurrence = findSecondHighestOccurrence(inputString);
		//System.out.println("Second highest occurrence: " + secondHighestOccurrence);

		//inputString = "I love to write Selenium with Java coding";  

		//getOccuringChar(inputString);

		//int[] charCounts = countCharacterOccurrence(inputString);

		// Display the results
	/*
		System.out.println("Character occurrence in the string:");
		for (int i = 0; i < charCounts.length; i++)
		{
			char currentChar = (char) i;
			if (charCounts[i] > 0)
			{
				System.out.println("'" + currentChar + "': " + charCounts[i] + " times");
			}
		}
	*/
	}

	private static void MergeStrings() {
		String str1 = "Girish";
		String str2 = "Bhujbalxyz";
		String mres = "";
		
		int i = 0;
		int j = 0;

		while (i < str1.length() || j < str2.length()) {
			if (i < str1.length()){
				mres = mres + str1.charAt(i);
				i++;
			}
			if (j < str2.length()){
				mres = mres + str2.charAt(j);
				j++;
			}
		}
		
		/*
		StringBuffer mResultStr = new StringBuffer();
		while (i < str1.length() || j < str2.length()) {
			if (i < str1.length()){
				mResultStr.append(str1.charAt(i));
				i++;
			}
			if (j < str2.length()){
				mResultStr.append(str2.charAt(j));
				j++;
			}
		}
		str3 = mResultStr.toString();
		*/

		System.out.println(mres);
	}

	public static void CharTypesinString(String mStringToCheck)
	{
		int lowercaseCount = 0;
		int uppercaseCount = 0;

		for (int i = 0; i < mStringToCheck.length(); i++)
		{
			if (Character.isLowerCase(mStringToCheck.charAt(i)))
			{lowercaseCount++;}
			else if (Character.isUpperCase(mStringToCheck.charAt(i)))
			{ uppercaseCount++;}
			
			if (Character.isDigit(mStringToCheck.charAt(i)))
			{
				System.out.println("Digit ");
			}
		}

		System.out.println("Lowercase characters: "+ lowercaseCount);
		System.out.println("Uppercase characters: "+ uppercaseCount);
	}

	public static void CheckOddEvenNumbers(int mNumToValidate)
	{
		// Print odd and even numbers
		for (int i = 0; i < 50; i++)
		{          
			if (i%2==0)
			{
				System.out.println("Even number: "+i);               
			} else
			{        	   
				System.out.println("Odd number: "+ i);                              
			}
		}
	}
	
	static void getOccurringChar(String mStr)
	{
		int[] mCharCount = new int[256];

		System.out.println(mStr);
		//populate array
		for(int i= 0; i < mStr.length(); i++)
			mCharCount[mStr.charAt(i)]++;
		
		//print the
		for(int i= 0; i < mCharCount.length; i++)
		{
			if (mCharCount[i] != 0)
			{
				System.out.println("Character :"+ (char) i + " Count: "+ mCharCount[i]);
			}
		}

		//Anagram
		String str1 = "listen";
        String str2 = "silent";
        
        // Remove whitespace and convert to lowercase
		str1 = str1.replaceAll("\\s", "").toLowerCase();
	    str2 = str2.replaceAll("\\s", "").toLowerCase();

	    if (str1.length() == str2.length()) {
		    char[] charArray1 = str1.toCharArray();
		    char[] charArray2 = str2.toCharArray();

		    Arrays.sort(charArray1);
		    Arrays.sort(charArray2);
		        
		    //return Arrays.equals(charArray1, charArray2);
	        }
	}

	static void removeDuplicates(String str)   
	{
		LinkedHashSet<Character> set = new LinkedHashSet<>();
		
		for(int i=0;i<str.length();i++)   
			set.add(str.charAt(i));
	
		// print the string after removing duplicate characters   
		for(char ch : set)
			System.out.print(ch);
		
		// Remove duplicate digits
		int num1 = 143145232;
		String str1 = String.valueOf(num1);
		LinkedHashSet <Character> numSet = new LinkedHashSet<>();
		String str4 = "";
		
		for(int i = 0; i < str1.length();i++)
			numSet.add(str1.charAt(i));
		
		for(char ch: numSet) str4 = str4 + ch;
	
        System.out.println(str4);
	}

	private static char findSecondHighestOccurrence(String input)
	{
		// Remove spaces and convert the string to lowercase for case-insensitive comparison
		input = input.replaceAll("\\s", "").toLowerCase();

		// Create a map to store the count of each character
		Map<Character, Integer> charCountMap = new HashMap<>();

		// Populate the map with character occurrences
		for (char c : input.toCharArray())
		{
			charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
		}

		// Find the maximum and second maximum occurrences
		int maxCount = 0;
		int secondMaxCount = 0;
		char maxChar = 0;
		char secondMaxChar = 0;

		for (Entry<Character, Integer> entry : charCountMap.entrySet()) {
			int count = entry.getValue();
			if (count > maxCount) {
				secondMaxCount = maxCount;
				secondMaxChar = maxChar;
				maxCount = count;
				maxChar = entry.getKey();
			} else if (count > secondMaxCount && count != maxCount) {
				secondMaxCount = count;
				secondMaxChar = entry.getKey();
			}
		}

		return secondMaxChar;
	}

	private static void PrintDuplicateChar(String inputString)
	{
		char[] mChar;
		mChar = inputString.toCharArray();
	
		for(int i=0;i<inputString.length();i++)
		{
			for(int j=i+1; j < inputString.length();j++)
			{
				if (inputString.charAt(j) == mChar[i] && mChar[j] !=' ')
				{
					System.out.println("Duplicate " + inputString.charAt(i));
				}
				 //else if (Character.isLowerCase(mChar[i])) {System.out.println("lower");}
				 //else if (Character.isUpperCase(mChar[i])) //{System.out.println("lower");}
			}
		}
		
		int i,j,index;
		index = 0;
		
		for(i=0;i<inputString.length();i++)
		{
			for(j=0; j < inputString.length();j++) {
				if (inputString.charAt(j) == mChar[i] && mChar[j] !=' ')
				{break;}
			}
			if (i == j) {}
		}
	}
	
	public static void Reverse()
	{
		//Reverse each word in the sentence
		String sentence = "This is an interview question";

        String[] words = sentence.split(" ");
        String mstr1 =  "";
        String mstr2 ="";
        StringBuilder revWord = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
        	revWord= new StringBuilder(words[i]);
            mstr1 = revWord.reverse().toString();
            mstr2 = mstr2 +" " + mstr1;
        }
        System.out.println("Original sentence: "+sentence+" Reversed senence: "+mstr2);

        //Reverse the each string in the Array
		String[] stringArray = {"Apple", "Banana", "Orange", "Grapes"};
		StringBuilder mStb = new StringBuilder();
		String mVar = "";
		
		for(int i = 0; i < stringArray.length;i++) {
			System.out.println(stringArray[i]);
			mStb = new StringBuilder(stringArray[i]);
			mVar = mStb.reverse().toString();
			System.out.println(mVar);
		}
        
		// Reverse the string
        String inputString = "Muramba";
        
        char[] mChar = inputString.toCharArray();

        System.out.println(inputString);
		String mRevStr = "";
		
		for(int i=inputString.length()-1;i >= 0;i--)
		{
			mRevStr = mRevStr + mChar[i];
		}
		System.out.println("Reversed string: "+ mRevStr);
		if (inputString.equals(mRevStr)) {System.out.println("pallindrom string");}
	}
}