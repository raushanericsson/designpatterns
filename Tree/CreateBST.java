class CreateBST{

	static Node parent = null;

	static class Node{
		int Data;
		Node left,right;
		Node(int Data){
			this.Data = Data;
			left = right = null;
		}
	}

	// Method for creating BST 
	//@root Sending root node for insertion
	//@Data to be inserted 
	// logn time to search & insert
	public static Node insertNodeInBST(Node root,int Data){
		if(root == null){
			return new Node(Data);
		}
		if(Data > root.Data){
			if(root.right != null && root.right.Data > Data){
				Node temp = new Node(Data);
				temp.right = root.right;
				root.right = temp;
				return root; 	
			}
			root.right = insertNodeInBST(root.right,Data);
		}else {
			if(root.left != null && root.left.Data < Data){
				Node temp = new Node(Data);
				temp.left = root.left;
				root.left = temp;
				return root; 	
			}
			root.left = insertNodeInBST(root.left,Data);
		}
		return root;
	}

	public static void treeTraversal(Node node){
		if(node == null){
			return;
		}

		treeTraversal(node.left);
		System.out.print(node.Data + " ==>");
		treeTraversal(node.right);
	}

// Time complexity 
	//summation (i = 0 -> n) log(i)
	public static void main(String[] args){

		int[] arr = {6,12,16,14,11,10,7,1,13};
		for(int i=0;i<arr.length;i++){
			parent = insertNodeInBST(parent,arr[i]);
					treeTraversal(parent);
					System.out.println();
		}
	//	treeTraversal(parent);

	}

	/**
output
6 ==>
6 ==>12 ==>
6 ==>12 ==>16 ==>
6 ==>12 ==>14 ==>16 ==>
6 ==>11 ==>12 ==>14 ==>16 ==>
6 ==>10 ==>11 ==>12 ==>14 ==>16 ==>
6 ==>7 ==>10 ==>11 ==>12 ==>14 ==>16 ==>
1 ==>6 ==>7 ==>10 ==>11 ==>12 ==>14 ==>16 ==>
1 ==>6 ==>7 ==>10 ==>11 ==>12 ==>13 ==>14 ==>16 ==>


}