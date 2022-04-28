import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class ParenthesesChecker {

    public boolean checkParentheses(String string){

        char[] arrayLetters = string.toCharArray();
        Stack<Character> letterStack = new Stack();
        ArrayList<Character> parenthesesArrayOpen = new ArrayList<>();
        ArrayList<Character> parenthesesArrayClosed = new ArrayList<>();

        for(int i=0;i<arrayLetters.length;i++){
            letterStack.push(arrayLetters[i]);
        }
        while(letterStack.empty()==false){
            if(letterStack.peek().equals('(')||letterStack.peek().equals('[')
            ||letterStack.peek().equals('{')||letterStack.peek().equals('<')){

                parenthesesArrayOpen.add(letterStack.peek());
                letterStack.pop();
            }else if(letterStack.peek().equals(')')||letterStack.peek().equals(']')
            ||letterStack.peek().equals('}')||letterStack.peek().equals('>')){

                parenthesesArrayClosed.add(letterStack.peek());
                letterStack.pop();
            }else{
                letterStack.pop();
            }


        }



        if((parenthesesArrayOpen.size()+parenthesesArrayClosed.size())%2==0){
            int check =0;
            for(int i =0;i<parenthesesArrayClosed.size();i++){
                if(parenthesesArrayClosed.get(i).equals(')')&&parenthesesArrayOpen.get((parenthesesArrayOpen.size()-1)-i).equals('(')
                        ||parenthesesArrayClosed.get(i).equals(']')&&parenthesesArrayOpen.get((parenthesesArrayClosed.size()-1)-i).equals('[')
                        ||parenthesesArrayClosed.get(i).equals('}')&&parenthesesArrayOpen.get((parenthesesArrayClosed.size()-1)-i).equals('{')
                        ||parenthesesArrayClosed.get(i).equals('>')&&parenthesesArrayOpen.get((parenthesesArrayClosed.size()-1)-i).equals('<'))

                {
                    check++;
                }
            }
           if(check==(parenthesesArrayOpen.size())){
               return true;
           }else{
               return false;
           }
        }
            return false;
        }


    }



