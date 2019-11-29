
public class MergeTwoOrderListTest01 {
	/*合并两个有序链表*/
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
	
	/*
	 *将两个链表中的结点相加，链表头存储低位，链表结尾存储高位。
	 *两个整数的各个数位放在两个链表中，其中链表头存储低位，链表结尾存储高位。 将这两个链表相加
	 * */
	public static Node additionTwoList(Node nA,Node nB){
		if(nA==null){
			return nB;
		}else if(nB==null){
			return nA;
		}else if(nA!=null&&nB!=null){
			int sum=0;
			int flag=0;
			Node p=new Node(0);
			Node head=p;
			sum=nA.data+nB.data;
			flag=sum/10;
			p.data=sum%10;
			
			nA=nA.next;
			nB=nB.next;
			while(nA!=null||nB!=null||flag==1){
				sum=flag;
				sum+=(nA!=null?nA.data:0)+(nB!=null?nB.data:0);
				p.next=new Node(sum%10);
				flag=sum/10;
				nA=nA!=null?nA.next:null;
				nB=nB!=null?nB.next:null;
				p=p.next;
			}
			return head;
		}
		return null;
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
		
		Node newHead1=mergeTwoOrderList01(nodeA1,nodeB2);
		traverse(newHead1);
		
		Node nodea5=new Node(5,null);
		Node nodea3=new Node(3,nodea5);
		Node nodea1=new Node(1,nodea3);
		
		Node nodeb6=new Node(6,null);
		Node nodeb4=new Node(4,nodeb6);
		Node nodeb2=new Node(2,nodeb4);
		Node newHead2=additionTwoList(nodea1,nodeb2);
		traverse(newHead2);
	}

}
