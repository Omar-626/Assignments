public class Deque {
    private int maxSize;
    private int front = 0;
    private int rear = -1;
    private int[] queueArray;

    public Deque(int maxSize){
        this.maxSize = maxSize;
        queueArray = new int[maxSize];
    }

    public void insertLast(int element) {
        if (!isFull()) {
            queueArray[++rear] = element;
        }else {
            System.out.println("Cannot insert more elements, the Queue is full");
        }
    }

    public void insertFirst(int element) {
        if (!isFull()) {
            if(front <= 0) {
                System.out.println("Cannot insert more elements in the front, it can't be less than 0");
                return;
            }
            queueArray[--front] = element;
        }else {
            System.out.println("Cannot insert more elements, the Queue is full");
        }
    }

    public int removeFirst() {
        if (!isEmpty()) {
            return queueArray[front++];
        } else {
            System.out.println("Queue is empty");
            return -1;
        }
    }

    public int removeLast() {
        if (!isEmpty()) {
            return queueArray[rear--];
        } else {
            System.out.println("Queue is empty");
            return -1;
        }
    }

    public boolean isEmpty() {
        return (front - rear == 1);
    }

    public boolean isFull() {
        return (maxSize - (rear - front) == 1);
    }

    public int getFront(){
        if(!isEmpty()) return queueArray[front];
        else{
            System.out.println("Queue is empty");
            return -1;
        }
    }

    public int getRear(){
        if(!isEmpty()) return queueArray[rear];
        else{
            System.out.println("Queue is empty");
            return -1;
        }
    }

    public void display() {
        if (!isEmpty()) {
            System.out.print("[" + queueArray[front]);
            for (int i = front + 1; i <= rear; i++) {
                System.out.print(", " + queueArray[i]);
            }
            System.out.print("]");
        }else {
            System.out.print("[]");
        }
        System.out.println("");
    }


}
