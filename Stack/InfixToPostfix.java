import java.util.Stack;

class InfixToPostfix{


  // precedence 
  static int predc(char ch){
      
    switch(ch){
      case '+':
      case '-':
        return 1;

      case '*':
      case '/':
        return 2;
      case '^':
        return 3;

    }

    return -1;
  }

  static String infx(String str){

    String result = new String("");
    Stack<Character> stack = new Stack<>();

    for(int i = 0; i <str.length(); ++i){

      char c = str.charAt(i);


      if(Character.isLetterOrDigit(c))
        result+=c;

      else if(c=='(')
        stack.push(c);

      else if(c==')'){
        while(!stack.isEmpty() && stack.peek() !='(')
          result+=stack.pop();
          stack.pop();

      }
      else{

        while(!stack.isEmpty() && predc(c) <= predc(stack.peek())){
          result+=stack.pop();
        }

        stack.push(c);
      }
        
    }

    while(!stack.isEmpty()){

      if(stack.peek() == '(')
        return "Invalid";
      result+=stack.pop();
    }

    return result;
  }
  public static void main(String[] args){

    String str = "a+b*(c^d-e)^(f+g*h)-i";

    System.out.println(infx(str));
  }

}
