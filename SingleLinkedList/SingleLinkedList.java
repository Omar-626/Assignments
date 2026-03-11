package SingleLinkedList2;

public class SingleLinkedList {
    private Node head;
    private Node tail;
    private int numberOfItems = 0;

    public boolean isEmpty(){
        return head == null;
    }
    public void append(int item){
        if(isEmpty()){
            firstInsertion(item);
            return;
        }
        Node newNode = new Node(item);
        tail.next = newNode;
        tail = newNode;
        numberOfItems++;
    }
    public void insertAtFirst(int item){
        if(isEmpty()){
            firstInsertion(item);
            return;
        }
        Node newNode = new Node(item);
        newNode.next = head;
        head = newNode;
        numberOfItems++;
    }
    public void insertAtPosition(int item, int position){
        if (position < 0) {
            throw new Error("Position can't be negative");
        }
        if (position > numberOfItems)  {
            throw new Error("Position out of boundaries");
        }
        if(position == 0){
            insertAtFirst(item);
            return;
        }
        if(position == numberOfItems){
            append(item);
            return;
        }
        Node newNode = new Node(item);
        Node current = head;
        int pointer = 0;
        while (current.next != null && pointer < position- 1) {
            current = current.next;
            pointer++;
        }
        newNode.next = current.next;
        current.next = newNode;
        numberOfItems++;
    }
    public void displayForward() {
        if(isEmpty()){
            System.out.println("There is no any items");
            return;
        }
        System.out.print(head.data);
        Node current = head;
        while (current != tail){
            current = current.next;
            System.out.print(" -> " + current.data);
        }
        System.out.print(" -> null");
        System.out.println();
    }

    public Node getIndexOf(int index){
        if (index < 0) {
            throw new Error("Index can't be negative");
        }
        if (index > numberOfItems - 1)  {
            throw new Error("Index out of boundaries");
        }
        if(index == 0){
            return head;
        }
        Node current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current;
    }

    public void displayBackward(){
        if(isEmpty()){
            System.out.println("There is no any items");
            return;
        }
        for(int i = numberOfItems - 1; i >= 0; i--){
            System.out.print(getIndexOf(i).data + " -> ");
        }
        System.out.print("null");
        System.out.println();

    }

    public int getNumberOfItems(){
        return numberOfItems;
    }
    public Node getHead(){
        return head;
    }
    public Node getTail(){
        return tail;
    }
    public Node deleteHead(){
        Node temp = head;
        head = head.next;
        numberOfItems--;
        return temp;
    }
    public Node deleteTail(){
        Node temp = tail;
        tail = null;
        numberOfItems--;
        return temp;
    }
    public Node deleteItem(int itemData){
        if(isEmpty()) return null;
        Node current = head;
        if(head.data == itemData) {
            head = head.next;
            numberOfItems--;
            return head;
        }
        while(current.next != null && current.next.data != itemData){
            current = current.next;
        }
        if(current.next == null) return null;
        Node temp = current;
        current.next = current.next.next;
        numberOfItems--;
        return temp;
    }
    public void merge(SingleLinkedList list2){
        if(list2.isEmpty()) return;
        if(isEmpty()){
            head = list2.head;
            tail = list2.tail;
            numberOfItems = list2.getNumberOfItems();
            return;
        }
        this.tail.next = list2.head;
        this.tail = list2.tail;
        numberOfItems += list2.getNumberOfItems();
    }
    private void firstInsertion(int item){
        Node newNode = new Node(item);
        head = newNode;
        tail = newNode;
        numberOfItems++;
    }


}
