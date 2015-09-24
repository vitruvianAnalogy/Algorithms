import java.util.*;

class Node{
	public int data;
	public Node next;

	public Node(int data){
		this.data = data;
		this.next = null;
	}
	public Node(){}
}


class LinkedList{
	public Node head;

	public LinkedList(){
		head = null;
	}

	public boolean isEmpty(){
		return (head==null);
	}

	/*New node when added pushes the head element down and itself becomes the
	head element.*/
	public void add(int data){
		Node newNode = new Node(data);
		Node current = this.head;
		if(head==null)
		{
			head = newNode;
			head.next = null;
		}
		else
		{
			while(current.next!=null)
			{
				current=current.next;
			}
			current.next = newNode;
			current.next.next = null;
		}
	}
}


public class MergeSortLL{

	public static Node mergeSort(Node head){

		Node a;
		Node b;

		/*If the list is empty or has only one elements then there 
		is no need for sorting*/

		/*if((head == null)|| (head.next == null))
			return head;*/

		/*Splitting head into sublists*/
		
				/*We will use two pointers to find the middle of the list
		The fast pointer will cover two spaces for slow pointer's one space*/
		Node fast;
		Node slow;
		/*If there is zero elements then front becomes head which is null
		but if there is one element then again front becomes head which
		has one element*/
		if(head == null || head.next == null){
			a = head;
			b = null;
		}
		else{
			/*Slow will become head because we are trying to make slow find
			the middle, i.e. it should stay behind fast*/
			slow = head;
			/*Fast will become next in case there are two elements and
			also since we need fast to reach the end of the list, so basically
			slow is behind fast. Why we initialize them as head and head.next
			is because we have covered the cases where there is one element or null
			Therefore we are starting from where there are 2 elements
			and then we loop forward*/
			fast = head.next;

			/*We will run the loop until fast reaches the end of the list*/
			while(fast!=null){
				fast=fast.next;
				if(fast!= null)
				{
					fast=fast.next;
					slow=slow.next;
				}
			}

			/*head will become the head of top sublist and slow.next will become the
			head of bottom sublist. After that we will remove slow.next
			from the  */
			a = head;
			b = slow.next;
			slow.next = null;
		}

			/*Merge the two sublists*/
			return merge(mergeSort(a),mergeSort(b));
		
	}

	public static Node merge(Node a, Node b){
		
		Node c = new Node();
		Node temp = c;

		while(a!=null && b!=null){
			if(a.data<=b.data)
			{
				c = a;
				a = a.next;
				c = c.next;
			}else{
				c = b;
				b = b.next;
				c = c.next;
			}
		}
		/*When either a or b becomes null we concatenate the rest of the
		existing sublist to the temporary list that we created*/
		if(a==null)
			c = b;
		else
			c = a;
		/*c.next = (a==null)?b:a;*/

		return temp;
	}

	public static void main(String[] args){
		Scanner sn = new Scanner(System.in);
		System.out.println("Enter the number of elements");
		int n = sn.nextInt();

		LinkedList myList = new LinkedList();
		System.out.println("Enter the elements");
		for(int i=0;i<n;i++){
			myList.add(sn.nextInt());
		}

		/*List before sorting*/
		Node a = myList.head;
		while(a!=null){
			System.out.println(a.data);
			a = a.next;
		}

		System.out.println("Sorting");

		mergeSort(myList.head);
		Node temp = myList.head;

		System.out.println("LinkedList after sorting");
		/*Print linkedList*/
		while(temp!=null){
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}