class Views {

	Node root;

	static class Node{
		int Data;
		Node left,right;
		Node(int Data){
			this.Data = Data;
			left = right = null;
		}
	}

	public static void main(String[] args){
		Views top = new Views();
		top.root = new Node(1);
		top.root.left = new Node(2);
		top.root.right = new Node(3);
		top.root.left.left = new Node(4);
		top.root.left.right = new Node(5);
		top.root.right.left = new Node(6);
		top.root.right.right = new Node(7);
		top.root.right.right.right = new Node(8);
		top.root.left.left.left = new Node(9);
		top.topView(top.root);
		//top.inOrderTraversal(top.root);


	}

	private void inOrderTraversal(Node node){
		if(node == null){
			return;
		}
		inOrderTraversal(node.left);
		System.out.println(node.Data + " ==> ");
		inOrderTraversal(node.right);
	}


	private  void topView(Node node){
		if(root != null){
			leftUtility(node.left);
			System.out.print(root.Data+" ==> ");
			rightUtility(node.right);
		}


	}

	private  void leftUtility(Node node){
		if(node == null){
			return;
		}
		leftUtility(node.left);
		System.out.print(node.Data + " ==> ");


	}

	private  void rightUtility(Node node){
		if(node == null){
			return;
		}
		System.out.print(node.Data +" ==> ");
		rightUtility(node.right);
		

	}
}