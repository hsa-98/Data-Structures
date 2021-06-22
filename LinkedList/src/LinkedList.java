import java.util.Scanner;

/**
 * @author Harsh
 * This Class creates an object of class Node and performs various operations on it.
 */


public class LinkedList {
    Node head = new Node();
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        while (choice != 9) {
            System.out.println("1)Add number in inked list");
            System.out.println("2)Print linked list");
            System.out.println("3)Add element before the head element.");
            System.out.println("4)Add element at a certain position");
            System.out.println("5).Pop element");
            System.out.println("6)Pop Last element");
            System.out.println("7)Search an element and enter a new element after it");
            System.out.println("8)Delete Element");
            System.out.println("9)Exit.");
            System.out.println("ENTER YOUR CHOICE");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the number you want to add");
                    int num = sc.nextInt();
                    linkedList.add(num);
                    break;
                case 2:
                    linkedList.print();
                    break;
                case 3:
                    System.out.println("Enter the number you want to add");
                    num = sc.nextInt();
                    linkedList.addBeforeHead(num);
                    break;
                case 4:
                    System.out.println("Enter the number you want to add");
                    num = sc.nextInt();
                    linkedList.addInBetween(num);
                case 5:
                    linkedList.popElement();
                    break;
                case 6:
                    linkedList.popLast();
                    break;
                case 7:
                    System.out.println("Enter the number you want to search");
                    num = sc.nextInt();
                    System.out.println("Enter the element you want to enter");
                    int  num1 = sc.nextInt();
                    linkedList.search(num,num1);
                    break;
                case 8:
                    System.out.println("Enter the element you want to delete");
                    num = sc.nextInt();
                    linkedList.deleteElement(num);
                    break;
            }
        }
    }

    /**
     * adds a new element to linked list and creates a new list if it doesnt exist
     *
     * @param num
     * @param <E>
     */
    public <E> void add(E num) {
        if (head.getNode() == null) {
            head.setNode((Comparable) num);
        } else {
            Node node = new Node();
            node.setNode((Comparable) num);
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(node);
        }

    }

    /**
     * This function prints the LinkedList
     *
     * @param <E>
     */
    public <E> void print() {
        if (head.getNode() == null) {
            System.out.println("Linked list is empty");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.getNode()+" ");
                temp = temp.getNext();
            }
        }
    }

    /**
     * This function adds element before the head element.
     *
     * @param num
     * @param <E>
     */
    public <E> void addBeforeHead(E num) {
        Node node = new Node();
        node.setNode((Comparable) num);
        Node temp = head;
        head = node;
        node.setNext(temp);
    }

    /**
     * This method  adds element at a certain position given by the user
     * * @param num
     *
     * @param <E>
     */
    public <E> void addInBetween(E num) {
        System.out.println("Enter the positin you want to enter at");
        int pos = sc.nextInt();
        Node node = new Node();
        node.setNode((Comparable) num);
        Node temp = head;
        for (int i = 1; i < pos - 1; i++) {
            temp = temp.getNext();
        }
        node.setNext(temp.getNext());
        temp.setNext(node);
    }

    /**
     * This method pops the head element and replaces it with the second element
     *
     * @param <E>
     */
    public <E> void popElement() {
        System.out.println(head.getNode());
        head = head.getNext();
    }

    /**
     * This method pops the last element
     */
    public <E> void popLast() {
        Node temp = head;
        Node prev = temp;
        while (temp.getNext() != null) {
            prev = temp;
            temp = temp.getNext();
        }
        prev.setNext(null);
    }

    /**
     * Can search for a particular value in linked list
     * and then add a new element after the element
     */
    public <E> void search(E num,E num1) {
        Node temp = head;
        int flag = 0;
        while (temp.getNext() != null) {
            if (temp.getNode() == num) {
                flag = 1;
                break;
            }
            temp = temp.getNext();
        }
        if (flag == 0) {
            System.out.println("Element doesnt exists");
        } else {
            Node node = new Node();
            node.setNode((Comparable) num1);
            node.setNext(temp.getNext());
            temp.setNext(node);
        }

    }

    /**
     * This element deletes an element given by the user
     */
    public <E> void deleteElement(E num){
        Node temp = head;
        Node prev = temp;
        int flag = 0;
        while (temp.getNext() != null) {
            if (temp.getNode() == num) {
                flag = 1;
                break;
            }
            temp = temp.getNext();
            prev = temp;
        }
        if (flag == 0) {
            System.out.println("Element doesnt exists");
        } else {
            prev.setNext(temp.getNext());

        }

    }
}
