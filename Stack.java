import java.util.Arrays;

public class Stack {
    private int maxSize;
    private int top = -1;
    private char[] stackArray;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new char[maxSize];
    }

    public void push(char element) {
        if (!isFull()) {
            stackArray[++top] = element;
        }else {
            System.out.println("Cannot push more elements, the Stack is full");
        }
    }

    public int pop() {
        if (!isEmpty()) {
            return stackArray[top--];
        } else {
            System.out.println("Stack is empty");
            return -1;
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (maxSize - top == 1);
    }

    public int getTop(){
        if(!isEmpty()) return stackArray[top];
        else{
            System.out.println("Stack is empty");
            return -1;
        }
    }

    public void display() {
        if (!isEmpty()) {
            System.out.print("[" + stackArray[0]);
            for (int i = 1; i <= top; i++) {
                System.out.print(", " + stackArray[i]);
            }
            System.out.print("]");
        }else {
            System.out.print("[]");
        }
        System.out.println("");
    }

}
