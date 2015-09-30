import java.util.*;

class Node{
	public int data;
	public Node next;

	public int getData(){
		return data;
	}
	public Node getNext(){
		return next;
	}

	public void setData(int data){
		this.data = data;
	}
	public void setNext(Node next){
		this.next = next;
	}

	public Node(int data, Node next){
		this.data = data;
		this.next = next;
	}
}

public class LinkedList{

	public Node head;

	/*To reverse a singly list, we recurse till the bottom
	and then come back out linking everything back*/
	public Node reverseList(Node current){
		if(current==null){			
			return null;	
		}			
		else{
			Node nextNode = reverseList(current.next);
			if(nextNode!=null){
				nextNode.next = current;
				current.next = null;
			}
			else
			{
				this.head = current;
			}			
			return current;
		}
	}

	public boolean deleteList(){

		if(head==null)
			return false;
		while(head.next!=null){
			head=head.next;
		}
		head = null;
		return true;
	}

	public int findBackNthElement(int data){
		Node slow=head;
		Node fast=head;
		int counter = 1;

		while(counter!=data){
			fast = fast.next;
			counter++;			
		}

		while(fast.next!=null){
			slow = slow.next;
			fast = fast.next;
		}
		return slow.data;
	}

	public int findNthElement(int nth){
		Node current = head;
		int counter = 1;
		if(head==null){
			System.out.println("There is no list");			
		}
		else
		{
			while(current!=null){				
				if(nth == counter)
					return current.data;
				current = current.next;
				counter++;
			}
		}
		return -1;
	}

	public boolean deleteHead(){
		if(head!=null){
			this.head = this.head.next;
			return true;
		}
		else
			return false;		
		
	}

	public void addElement(int data, Node next){
		Node current = head;
		Node newNode = new Node(data,next);
		if(head==null)
			head = newNode;
		else
		{
			while(current.next!=null){
				current = current.next;
			}
			current.next = newNode;
		}
	}

	public int findLength(){
		Node current = head;
		int length = 1;
		while(current.next!=null)
		{
			length++;
			current = current.next;
		}

		return length;
	}
	
	public int findRecursiveLength(Node n){		
		if(n == null)
			return 0;
		else
		{
			return (1 + this.findRecursiveLength(n.next));
		}
	}		

	public void deleteElement(int data){
		Node current = head;
		if(head==null)
			System.out.println("Empty list");
		else
		{
			while(current.next!=null){
				if(current.data==data){
					System.out.println("Element found and deleted");
					current.current = data.next.data;
					current.next = current.next.next;
					return;
				}
					
				current = current.next;
			}			
		}
	}

	public void printList(){
		Node current = head;
		while(current!=null)
		{
			System.out.println(current.data);
			current = current.next;
		}
			
	}
	
	public static void main(String[] args){
		LinkedList myLinkedList = new LinkedList();
		Scanner sn = new Scanner(System.in);
		System.out.println("How many numbers?");
		int n = sn.nextInt();
		System.out.println("Enter numbers");
		while(n>0){
			myLinkedList.addElement(sn.nextInt(),null);
			n--;
		}

		//Find length
		int length = myLinkedList.findLength();
		System.out.println("Length of the linked list is " + length);
		int recursiveLength = myLinkedList.findRecursiveLength(myLinkedList.head);
		System.out.println("Length of the linked list via recursion method is " + recursiveLength);

		System.out.println("Which place number you want to find");
		int nth = sn.nextInt();
		int nthElement = myLinkedList.findNthElement(nth);
		System.out.println("The nth element you wanted is "+ nthElement);
		int nthElementFromTheBack = myLinkedList.findBackNthElement(nth);
		System.out.println("The reverse nth element you wanted is "+ nthElementFromTheBack);

		System.out.println("The linked list consists of");
		myLinkedList.printList();

		Node checkNode = myLinkedList.reverseList(myLinkedList.head);
		if(checkNode==null)
			System.out.println("No list exists");
		else
		{
			System.out.println("Reversed List");
			myLinkedList.printList();			
		}
			

		//Deletion
		int data = 2;
		myLinkedList.deleteElement(data);
		System.out.println("The linked list after deletion consists of");
		myLinkedList.printList();

		//Delete head
		boolean isHeadDeleted = myLinkedList.deleteHead();
		if(isHeadDeleted){
			System.out.println("The linked list after deletion of head consists of");			
			myLinkedList.printList();
		}
		else{
			System.out.println("List was empty");			
		}

		//Delete the whole list
		boolean isDeleted = myLinkedList.deleteList();
		if(isDeleted){
			System.out.println("List deleted");			
		}
		else{
			System.out.println("No list present");			
		}			
		
	}
}