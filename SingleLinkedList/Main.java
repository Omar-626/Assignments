package SingleLinkedList2;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList l1 = new SingleLinkedList();
        l1.append(10);
        l1.append(20);
        l1.append(30);
        l1.append(40);
        l1.append(50);
        l1.displayForward();
        l1.displayBackward();
    }
}
