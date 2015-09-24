public class Node{
	private int data;
	private Node next;

	public void setData(int d){
		this.data = data;
	}
	public int getData(){
		return this.data;
	}

	public void setNode(Node n){
		this.next = n;
	}

	public Node getNode(){
		return this.next;
	}

	public Node(int data, Node next){
		this.data = data;
		this.next = next;
	}
}