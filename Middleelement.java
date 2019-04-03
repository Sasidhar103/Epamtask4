package in.sasi;

import java.util.*;
class MyNode
{
	int data;
	MyNode next;
	MyNode(int data)
	{
		this.data=data;
		this.next=null;
	}
	
}
class List
{
	MyNode insert(int data,MyNode head)
	{
		MyNode node = new MyNode(data);
		if(head==null)
		{
			head=node;
		}
		else
		{
			MyNode temp = head;
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			temp.next = node;
		}
		return head;
	}
	void print(MyNode head)
	{
		if(head==null)
			return;
		MyNode temp = head;
		while(temp!=null)
		{
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		System.out.println("null");
	}
	void find_middle(MyNode head)
	{
		if(head==null)
			return;
		MyNode slow=head, fast=head;
		while(fast!=null&&fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
		}
		System.out.println("middle element is "+slow.data);
	}
}
public class Middleelement {

	public static void main(String args[])
	{
		int choice;
		Scanner sc = new Scanner(System.in);
		choice = sc.nextInt();
		MyNode head = null;
		List list = new List();
		do
		{
			System.out.println("enter 1 to insert\nenter 2 to stop inserting");
			choice = sc.nextInt();
			if(choice == 1)
			{
				System.out.println("enter element");
				int x = sc.nextInt();
				head = list.insert(x, head);
				
			}
		}while(choice!=2);
		list.print(head);
		list.find_middle(head);
		
	}
}