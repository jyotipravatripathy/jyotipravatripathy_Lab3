package sumOfPairs;

import java.util.List;
import java.util.Stack;

class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data = data;
	}
}
public class SumOfPairInBinarySearchTree {

	static boolean findpair(Node root, int sum, List<Integer> set)
	{
		if (root == null)
			return false;
		
		if (set.contains(sum - root.data)) {
			System.out.println("Pair is found ("
					+ (sum - root.data) + ", " 
					+ root.data + ")");
			return true;
		}
		else
			set.add(root.data);
		
		if (findpair(root.left, sum, set))
			return true;
		return findpair(root.right, sum, set);
	}

	static void printSumOfPair(Node root, int sum)
	{
		List<Integer> set = new Stack<Integer>();
		if (!findpair(root, sum, set))
			System.out.println("Pairs do not exit");
	}

	public static void main(String[] args) {
		
		Node root = new Node(40);
		root.left = new Node(20);
		root.left.left = new Node(10);
		root.left.right = new Node(30);
		root.right = new Node(60);
		root.right.right = new Node(70);
		root.right.left = new Node(50);
		
		printSumOfPair(root, 120);
		
	}
}