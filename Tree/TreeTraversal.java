


class TreeTraversal{

	Node root;

	static class Node{
		int Data;
		Node left,right;
		Node(int Data){
			this.Data = Data;
			left = right = null;
		}
	}


	// Change Order for Pre & Post
	private void inOrderTraversal(Node node){
		if(node == null){
			return;
		}
		if(node.left != null){
			inOrderTraversal(node.left);	
		}		
		System.out.print(node.Data + " ");
		if(node.right != null){
			inOrderTraversal(node.right);	
		}
	}


	// Try using Stack or Queue 

	//8,10,14
	// --10
	// My Observation DFS is not possible through Stack or Queue 
;

	private void bfsTraversal(){
		int height = getTreeHeight(this.root);
		for(int i=1;i<=height;i++){
			bfsTraversalUtility(this.root,i);
		}
	}

	private void bfsTraversalUtility(Node node,int level){
		if(node == null){
			return;
		}
		if(level == 1){
			System.out.print(node.Data+" ");
			return;
		}
		bfsTraversalUtility(node.left,level-1);
		bfsTraversalUtility(node.right,level-1);
	}

	// Get Height of Tree
	private int getTreeHeight(Node node){
		if(node == null){
			return 0;
		}
		int left_height = 1 + getTreeHeight(node.left);
		int right_height = 1 + getTreeHeight(node.right);
		return Math.max(left_height,right_height);
	}


	public static void main(String[] args){
		TreeTraversal exampleTree = new TreeTraversal();
		exampleTree.root = new Node(10);
		Node rt = exampleTree.root;
		rt.left = new Node(8);
		rt.right = new Node(14);
		rt.left.right = new Node(90);
		rt.left.right.left = new Node(45);
		System.out.print(" inOrderTraversal == ");
		exampleTree.inOrderTraversal(exampleTree.root);
		System.out.println();
		System.out.print(" Breadth First Traversal == ");
		exampleTree.bfsTraversal();
	}


}
