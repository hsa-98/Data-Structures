import java.util.Scanner;

/**
 * @author Harsh
 * This Class creates an object of class Node and performs various operations on it.
 */
public class LinkedList {
    Node head = new Node();

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        while(choice!=3){
            System.out.println("1)Add number in inked list");
            System.out.println("2)Print linked list");
            System.out.println("3).Exit");
            System.out.println("ENTER YOUR CHOICE");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter the number you want to add");
                    int num = sc.nextInt();
                    linkedList.add(num);
                    break;
                case 2:
                    linkedList.print();
                    break;

            }
        }
    }

    /**
     * adds a new element to linked list and creates a new list if it doesnt exist
     * @param num
     * @param <E>
     */
    public <E> void  add(E num){
        if(head.getNode() ==null){
            head.setNode(num);
        }
        else{
            Node node = new Node();
            node.setNode(num);
            Node temp = head;
            while(temp.getNext()!=null){
                temp=temp.getNext();
            }
            temp.setNext(node);
        }

    }

    public <E> void print(){
        if(head.getNode() == null){
            System.out.println("Linked list is empty");
        }
        else{
            Node temp = head;
            while(temp!=null){
                System.out.println(temp.getNode());
                temp=temp.getNext();
            }
        }
    }
}
