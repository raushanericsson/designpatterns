class MergeLinkedList{

	Node head;
	static class Node{
		int Data;
		Node next;
		Node(int Data){
			this.Data = Data;
			next = null;
		}
	}

	private  void traverseLinkedList(){
		if(this.head == null){
			System.out.println(" Linked List Is Empty !");
		}

		Node temp = this.head;
		while(temp != null){
			System.out.print(temp.Data + "=>");
			temp = temp.next;
		}
		System.out.print("NULL");

	}


	private  Node addNode(int Data){
		if(this.head == null){
			this.head = new Node(Data);
			return this.head;
		}
		Node temp = this.head;
		while(temp.next != null){
			temp = temp.next;
		}
		Node new_node = new Node(Data);
		temp.next = new_node;
		return this.head;
	}

	public static void main(String[] args){
		MergeLinkedList ml = new MergeLinkedList();
		int[] arr = {1,2,4,6};
		int[] arr2 = {};

		for(int i=0;i<arr.length;i++){
			ml.addNode(arr[i]);
		}

		ml.traverseLinkedList();
		System.out.println();
		Node last_insertion = ml.insertInSortedList(3,ml.head);
		//ml.insertInSortedList(3);
		last_insertion = ml.insertInSortedList(0,last_insertion);
		last_insertion = ml.insertInSortedList(13,last_insertion);
		ml.traverseLinkedList();
		ml.printLinkedListRecursion(ml.head);
	}


	/*
	Merge Linked List :
	Maintain two nodes : Current & last_node
	Step -1 : Find Index Data greater than current Node 
	*/

	private Node insertInSortedList(int Data,Node last_insertion){
		Node prev_node = null,current_node = null;
		//current_node = this.head;
		boolean done = false;
		current_node = last_insertion;
		while(current_node.Data < Data){
			prev_node = current_node;
			current_node = current_node.next;
			if(current_node == null){
				prev_node.next = new Node(Data);
				done = true;
				return prev_node.next;
			}
		}
		if(prev_node == null){
			Node new_node = new Node(Data);
			new_node.next = this.head;
			this.head = new_node;
			done = true;
			return this.head;
		}
		if(!done){
			Node new_node = new Node(Data);
			new_node.next = prev_node.next;
			prev_node.next = new_node;
			return new_node;
		}
		return this.head;

	}

	private void printLinkedListRecursion(Node node){
		if(node == null){
			System.out.println();
			return;

		}
		printLinkedListRecursion(node.next);
		System.out.print(node.Data + "== > ");

	}




}