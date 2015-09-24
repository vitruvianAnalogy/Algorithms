public class LinkedListT{

	public static void main(String[] args){		
		System.out.println("Enter the number of elements in linked list");
		Scanner sn = new Scanner(System.in);
		int n = sn.nextInt();

		Node head = new Node();
		Node temp = head;

		//Enter elements
		for(int i=0;i<n;i++){
			temp.data = sn.nextInt();
			if(i==n-1){
				temp.next = ;
			}				
			temp.next = null;
		}
	}
}