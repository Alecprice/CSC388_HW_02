import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Two {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/alecprice/Desktop/CSC388-HW02/src/in.txt");
        Scanner sc = new Scanner(file);
        Inner_LinkedList linked_List = new Inner_LinkedList();

        while (sc.hasNextLine()) {
            linked_List.insert_node(sc.nextInt());
            // System.out.println(linked_List.toString());
            System.out.print(linked_List.head.data + " \n");
        }
        Boolean isMatch = list_Checker(linked_List.head,linked_List.head.next);
        if(isMatch){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

    }

    /**
     *
     * @param currentNode takes in the node working off of to make the comparison
     * @param nextNode takes the node next to the current node and continuously runs down the list
     *                 looking for matches
     * @return
     */
    public static Boolean list_Checker(Inner_Node currentNode, Inner_Node nextNode){
        if(nextNode == null){
            //System.out.println("Here ");
            //System.exit(1);
            return false;
        }else if(currentNode.data == nextNode.data){
            //System.out.println("Matched " + currentNode.data + "to " + nextNode.data);
            return true;
        }
        //System.out.println("No match for " + currentNode.data + " " + nextNode.data);

        if(nextNode.next != null){
            nextNode = nextNode.next;
            return list_Checker(currentNode, nextNode);
        }
        else if(currentNode.next != null){
            currentNode = currentNode.next;
            nextNode = currentNode.next;
            return list_Checker(currentNode, nextNode);
        }

        return false;
    }

    }

    // class used to point to the current place in the linked list
    class Inner_Node
    {
        int data;
        Inner_Node next;
        Inner_Node(int d)
        {
            data = d;
            next = null;
        }
    }

     class Inner_LinkedList {
        Inner_Node head;    //Head of list

        //Inserts a new node at the front of the list

         /**
          *
          * @param new_data is the values being pulled from the .txt file
          */
        public void insert_node(int new_data) {

            //Allocate new node and putting data
            Inner_Node new_Inner_node = new Inner_Node(new_data);

            //Make next of new node as head
            new_Inner_node.next = head;

            //Move the head to point to new Node
            head = new_Inner_node;
        }
    }
