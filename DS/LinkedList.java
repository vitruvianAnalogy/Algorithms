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

	public int getMiddle(){

		int counter = 1;
		Node fast = head;
		Node slow = head;

		while(true){
			counter++;
			if(fast.next!=null){
				fast = fast.next.next;
			}
			else
				return counter;
			slow = slow.next;
		}

		return 1;
	}

	/*How to find the intersection of two lists.
	1. Traverse both lists and find the length of both lists and then calculate the difference
	2. Traverse the difference in the larger list so that both lists are now at the same level
	3. Now start comparing same level elements of both list and that is how you find the intersection*/

	/*There are two methods. One with linear time but linear space too. It uses stack.
	I am using the second method that reverse half the list and then the other half. This is linear and takes constant space*/
	public boolean isPalindrome(){
		Node current = head;

		int middle = getMiddle();
		Node headOfReversedList = reverseList()
	}

	public boolean isLoopPresent(){
		Node slow = head;
		Node fast = head;

		while(true){
			if (fast.next!=null)
				fast = fast.next.next;
			else
				return false;

			slow = slow.next;

			// If either of them has reached null.
			if(fast==null || slow==null)
				return false;
			if(fast==slow)
				return true;
		}
	}

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
					current.data = current.next.data;
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

		//Detect loop in linked list
		boolean hasLoop = myLinkedList.isLoopPresent();
		if (hasLoop) {
			System.out.println("Yes it has a loop. Whoa!!!");	
		}
		else
		{
			System.out.println("No loop. Told you!");
		}
		


		//Find length
		int length = myLinkedList.findLength();
		System.out.println("Length of the linked list is " + length);

		//Find recursive Length
		int recursiveLength = myLinkedList.findRecursiveLength(myLinkedList.head);
		System.out.println("Length of the linked list via recursion method is " + recursiveLength);


		//Find element at a certain index
		System.out.println("Which place number you want to find");
		int nth = sn.nextInt();
		int nthElement = myLinkedList.findNthElement(nth);
		System.out.println("The nth element you wanted is "+ nthElement);

		//Find element from the end of a linked list.
		int nthElementFromTheBack = myLinkedList.findBackNthElement(nth);
		System.out.println("The reverse nth element you wanted is "+ nthElementFromTheBack);

		//Print the linked list
		System.out.println("The linked list consists of");
		myLinkedList.printList();

		//Reverse the linked list
		Node checkNode = myLinkedList.reverseList(myLinkedList.head);
		if(checkNode==null)
			System.out.println("No list exists");
		else
		{
			System.out.println("Reversed List");
			myLinkedList.printList();			
		}
			


		//DELETIONS

		//Delete a certain element from the linked list
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