package Linked_List;

public class InsertingNode {
	class Node
	{ 
		Node next;
		int data;
		Node(int d)
		{
			data = d;
			next = null;
		}
	}
	class Insert
	{
		Node head;
	void add(Node node)
	{
		if(head == null)
			head = node;
		else
		{
			Node temp = head;
			while(temp.next != null)
				temp = temp.next;
				
			temp.next = node;
		}	
	} 
	}

}
