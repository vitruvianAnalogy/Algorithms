import java.util.*;

public class Tree{
	public static void main(String[] args){
		
	}
}

class TreeNode{
	int data;
	Node left = head;
	Node right = head;
}

class BinaryTree extends Tree{

	Node head;

	public static void main(String[] args){
		Scanner sn = new Scanner(System.in);
		BinaryTree myBinaryTree = new BinaryTree();
		Node current = myBinaryTree.head;
		
		while(sn.hasNextInt()){
			int data = sn.nextInt();
			if(data && myBinaryTree.head==null){
				myBinaryTree.head = new Node();
				myBinaryTree.head.data = data;
			}
			else
			{
				while(current.left!=null && current.right!=null){
					current=current.next;
				}
				current.next = new Node();
				current.next.data = data;
			}
		}
	}
}