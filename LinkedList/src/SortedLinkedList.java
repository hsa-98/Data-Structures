import java.util.Scanner;


public class SortedLinkedList {
    Node head = new Node();
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        SortedLinkedList sortedLinkedList = new SortedLinkedList();
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        while (choice != 3) {
            System.out.println("1)Add number in inked list");
            System.out.println("2)Print linked list");
            System.out.println("3)Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    int num1 = sc.nextInt();
                    sortedLinkedList.add1(num1);
                    break;
                case 2:
                    sortedLinkedList.print();
                    break;
                case 3:
                    break;

            }
        }
    }

    public <E extends Comparable<E>> void add1(E num) {

        if (head.getNode() == null) {
            head.setNode((Comparable) num);
        }

        else if(head.getNode().compareTo(num)>0){
            Node node = new Node();
            node.setNode(num);
            Node temp = head;
            node.setNext(temp);
            head=node;

        }
        else {
            Node node = new Node();
            node.setNode(num);
            Node temp = head;
            Node prev = temp;
            while (temp.getNext()!=null && temp.getNode().compareTo(num)< 0){
                prev = temp;
                temp = temp.getNext();
            }
            if(temp.getNode().compareTo(num)<0){
                temp.setNext(node);
            }
            else{
                node.setNext(prev.getNext());
                prev.setNext(node);
            }
        }
    }

    public <E> void print() {
        if (head.getNode() == null) {
            System.out.println("Linked list is empty");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.getNode()+" ");
                temp = temp.getNext();
            }
            System.out.println();
        }
    }

}


