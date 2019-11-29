
public class MergeTwoOrderListTest01 {

	public static Node mergeTwoOrderList01(Node nA,Node nB){
		Node newHead=null;
		if(nA==null){
			return nB;
		}else if(nB==null){
			return nA;
		}else{
			if(nA.data<=nB.data){
				newHead=nA;
				newHead.next=mergeTwoOrderList01(nA.next,nB);
			}else{
				newHead=nB;
				newHead.next=mergeTwoOrderList01(nA,nB.next);
			}
			return newHead;
		}
	}
	
	public static void traverse(Node head){
		while(head!=null){
			System.out.println(head.data);
			head=head.next;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node nodeA5=new Node(5,null);
		Node nodeA3=new Node(3,nodeA5);
		Node nodeA1=new Node(1,nodeA3);
		
		Node nodeB6=new Node(6,null);
		Node nodeB4=new Node(4,nodeB6);
		Node nodeB2=new Node(2,nodeB4);
		
		Node newHead=mergeTwoOrderList01(nodeA1,nodeB2);
		traverse(newHead);
	}

}
