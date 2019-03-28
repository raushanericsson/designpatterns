import java.util.Arrays;
class LowestCommonAncestor{

	Node root;

	static class Node{
		int data;
		Node left,right ;
		Node(int data){
			this.data = data;
			left = right = null;
		}

	}

	public static void main(String[] args){

		LowestCommonAncestor lca = new LowestCommonAncestor();
		lca.root = new Node(1); 
        lca.root.left = new Node(2); 
        lca.root.right = new Node(3); 
        lca.root.left.left = new Node(4); 
        lca.root.left.right = new Node(5); 
        lca.root.right.left = new Node(6); 
        lca.root.right.right = new Node(7); 
        lca.root.left.right.left = new Node(8); 
        lca.root.left.right.right = new Node(9);

        //System.out.println(lca.getHeight(lca.root));
        //lca.printTree(lca.root);

        int[] arr = new int[]{1,2,4,0};
        int seg_size = getLengthOfSegementTree(arr.length);

        seg = new int[seg_size];
        Arrays.fill(seg,Integer.MAX_VALUE);

        createSegementTree(arr,0,arr.length-1,0);

        for(int i:seg){
        	System.out.print(i + " ");
        }

        System.out.println(" Find getMinimumQuery");

        System.out.println(getMinimumQuery(0,3,0,3,0));
	}


	private static int getLengthOfSegementTree(int len){

		double f = Math.ceil(len* 1.0/2);
		int size = (int) f;

		size = (int) (2 * Math.pow(2,size)-1);

		return size;
	}

	private static int[] seg;

	private static void createSegementTree(int[] arr,int start,int end,int position){
		if(start == end){
			seg[position] = arr[start];
			return;
		}

		int mid = start + (end-start)/2;
		createSegementTree(arr,start,mid,2 * position + 1);
		createSegementTree(arr,mid+1,end,2*position + 2);
		seg[position] = Math.min(seg[2*position+1],seg[2*position+2]);

	}


	private static int getMinimumQuery(int qs,int qe,int start,int end,int position){
		// No Overlap
		if(qs > end  || end < qs){
			return Integer.MAX_VALUE;
		}else if(qs >= start && qe <= end){
			return seg[position];
			// Partial Overlap
		}

		int mid = start  + (end-start)/2;
		return Math.min(getMinimumQuery(qs,qe,start,mid,2*position+1), getMinimumQuery(qs,qe,mid+1,end,2*position+2));
	}


























	private void eulerTour(Node node){
		if(node == null){
			return;
		}
		System.out.print(node.data + " ");
		eulerTour(node.left);
		System.out.print(node.data + " ");
		eulerTour(node.right);
		System.out.print(node.data + " ");

	}



	// Practising BFS for next level 


	private int getHeight(Node node){
		if(node == null){
			return 0;
		}

		return 1 + Math.max(getHeight(node.left),getHeight(node.right));
	}

	private void printTree(Node node){
		int height = getHeight(node);
		for(int i=0;i<height;i++){
			printCurrentLevel(node,i);
			System.out.println();
		}
	}


	private void printCurrentLevel(Node node,int height){
		if(node == null){
			return;
		}
		if(height == 0 ){
			System.out.print(node.data+" ");
			return;
		}
		printCurrentLevel(node.left,height-1);
		printCurrentLevel(node.right,height-1);
	}

}