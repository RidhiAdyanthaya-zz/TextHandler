/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package texthandler;

import java.util.Scanner;

/**
 *
 * @author radyanth
 */
public class TextHandler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      //  int count=0;
         Scanner sc = new Scanner(System.in);
         String input;
         int option;
         String ans;
        boolean proceed;
         while(true)
         {
         System.out.print("Enter a word or phrase: ");
         input = sc.nextLine();
         System.out.println("Select the operation you'd like to perform");
         System.out.println("1. Determine if the text is a palindrome.");
         System.out.println("2. Find all the palindromes in the string.");
         System.out.println("3. Search for text.");
         System.out.println("4. Add text.");
         System.out.println("5. Remove text.");
         System.out.println("6. Reverse text.");
         System.out.println("7. Reverse each word of the text.");
         String beforeParse = sc.nextLine();
         option = Integer.parseInt(beforeParse);
         if (option == 1)
         {
             if (palindrome(input)) 
             {
                System.out.printf("The word %s is a palindrome.%n", input);
             } 
             else 
             {
                System.out.printf("The word %s is not a palindrome.%n", input);
             }
         }
         if (option == 2)
         {
             String result = findAllPalindromes(input);
             System.out.println("The palindromes are: "+result);
             
           
         }
          if (option == 3)
         {
             System.out.println("Enter text to be searched: ");
             String search = sc.nextLine();
             int result = searchText(input, search);
             System.out.println("The phrase " + search + "was found %d times"+ result);   
         }
           if (option == 4)
         {
             System.out.printf("Enter text to be added: ");
             String add = sc.nextLine();
             System.out.printf("Enter index: ");
             int index = Integer.parseInt(sc.nextLine());
             String result = addText(input, add, index);
             System.out.println("The resulting string: "+result);
         }
            if (option == 5)
         {
             System.out.println("Enter text to be removed: ");
             String remove = sc.nextLine();
             String result = removeText(input, remove);
             System.out.println("The resulting string: " +result);
             
         }
             if (option == 6)
         {
             String result = reverseText(input);
             System.out.println("The resulting text: " + result);
         }
              if (option == 7)
         {
             String result = reverseEachWord(input);
             System.out.println("The resulting text: " +  result);
         }
         System.out.println("Do you want to proceed? Type y if yes and n if no.");
         ans = sc.nextLine();
         if (ans.equals("y")){
         proceed = true;
         }
         else
         break;
         
  
    }
    }
    public static boolean palindrome(String str) {
   int len=str.length(),half=len/2;
   String test = str.toLowerCase();
        for(int i=0;i < half;i++){
            if(test.charAt(i)!=test.charAt(len-i-1)) return false;
        }
        return true;
}
    public static String findAllPalindromes(String str)
    {
        int count=0;
        str = str.replace("."," ");
        str = str.replace("?"," ");
        str = str.replace("!"," ");
        String answer = "";
        String ar[] = str.split(" ");
        for(int i=0; i < ar.length; i++)
        {
            if(palindrome(ar[i]))
            {
                count++;
                answer += ar[i] + " ";
            }
        }
       return answer;
    }
    public static int searchText(String str, String search)
    {
        int count = 0;
        int index = str.indexOf(search);
        while(index >= 0)
        {
            index = str.indexOf(search, index+1);
            count++;
        }
        return count;
    }
    public static String reverseText(String str)
    {
        String reverseString = "";
        for(int i=str.length()-1; i>=0; i--)
        {
            reverseString = reverseString + str.charAt(i);
        }
        return reverseString;
    }
    
    public static String reverseEachWord(String str)
    {
        String[] words = str.split(" ");
        String reverseString="";
        for(int i=0; i<words.length; i++)
        {
            String word = words[i];
            String reverseword = "";
            for (int j=word.length()-1; j>=0; j--)
            {
                reverseword = reverseword + word.charAt(j);
            }
            reverseString = reverseString+ reverseword+ " ";
        }
        return reverseString;
    }
    public static String addText(String str, String newWord, int index)
    {
        String resultString = new StringBuilder(str).insert(index, newWord).toString();
        return resultString;
    }
    
    public static String removeText(String str, String removeWord)
    {
        String resultString= str.replace(removeWord, "");
       // StringBuffer text = new StringBuffer(str);
       return resultString;
    }
}




