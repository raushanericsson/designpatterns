
import java.util.LinkedList;
import java.util.Queue;

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
	// Time complexity O(n) visiting one node only once
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

	// Time complexity O(n) = O(n) + O(n^3)
	// exponential complexity
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
	// Time complexity O(n)
	private int getTreeHeight(Node node){
		if(node == null){
			return 0;
		}
		int left_height = 1 + getTreeHeight(node.left);
		int right_height = 1 + getTreeHeight(node.right);
		return Math.max(left_height,right_height);
	}



	// Time complexity O(n) , Space Complexity O(n) Visting one node only once
	private void bfsTraversalUsingQueue(){
		System.out.print(" BFS Using Queue : ");
		Queue<Node> nodeQueue = new LinkedList<Node>();
		if(this.root == null)
			return;
		nodeQueue.add(this.root);
		while(nodeQueue.size() > 0){
			Node temp = nodeQueue.poll();
			System.out.print(temp.Data + " ");
			if(temp.left != null){
				nodeQueue.add(temp.left);
			}
			if(temp.right != null){
				nodeQueue.add(temp.right);
			}
		}
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
		exampleTree.bfsTraversalUsingQueue();
	}


}
