
public class P03_Infix_To_Postfix {
    private int top;
    private int size;
    private char[] arr;

    public P03_Infix_To_Postfix(int size) {
        this.size = size;
        top = -1;
        arr = new char[size];
    }
    
    public boolean isEmpty(){
        return (top==-1);
    }
    
    public char peek(){
        return arr[top];
    }
    
    public char pop(){
        if(isEmpty()){
            System.out.println("\nStack Is Empty");
            return '$';
        }
        return arr[top--];
    }
    
    public void push(char i){
        arr[++top] = i;
    }
    
    public boolean isOperand(char i){
        return (i>='a' && i<='z') || (i>='A' && i<='Z');
    }
    
    public int prec(char ch){
        switch(ch){
            case '+' :
            case '-' :
                return 1;
            case '*' :
            case '/' :
                return 2;
            case '^' :
                return 3;
        }
        return -1;
    }
    
    public int infixToPostfix(P03_Infix_To_Postfix stack,char[] exp){
        int i=0,k=0;
        
        if(stack==null)
            return -1;
        
        for(i=0,k=-1 ; i<exp.length ; i++){
            if(isOperand(exp[i]))
                exp[++k] = exp[i];
            
            else if(exp[i]=='(')
                push(exp[i]);
            
            else if(exp[i] == ')'){
                while(!isEmpty() && peek()!='(')
                    exp[++k]=pop();
                if(!isEmpty() && peek()!='(')
                    return -1;
                else 
                    pop();
            }
            
            else{
                while(!isEmpty() && prec(exp[i])<=prec(peek()))
                    exp[++k] = pop();
                    push(exp[i]);
            }    
        }
        
        while(!isEmpty())
            exp[++k] = pop();
        
        for(int v = 0;v<=k;v++){
            System.out.print(exp[v] + " ");
        }
     return -1;
    }
    
    public static void main(String[] args){
        String str = "((A+B)*C-D)*E";
        char[] ch = new char[str.length()];
        
        for(int i=0 ; i<str.length() ; i++)
            ch[i] = str.charAt(i);
        
        P03_Infix_To_Postfix stack = new P03_Infix_To_Postfix(ch.length);
        
        stack.infixToPostfix(stack, ch);
    }    	
}// A B + C * D - E *//A B + C * D - E * 

