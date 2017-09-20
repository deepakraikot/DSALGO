package booking.com;

//https://www.careercup.com/question?id=4823988742127616

//Populate right child of a node.
class Node {
	Node children[];
	Node right;
	int value;

	Node(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}

public class PopulateRightChild {

	public void populateRightChild(Node node) {
		if (node == null || node.children == null || node.children.length < 2)
			return;
		if (node.children.length > 1) {
			Node lastChild = node.children[node.children.length - 1];
			node.right = lastChild;
		}
		for (Node child : node.children) {
			populateRightChild(child);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PopulateRightChild obj = new PopulateRightChild();
		Node _1 = new Node(1);
		Node _6 = new Node(6);
		Node _8 = new Node(8);
		Node _11 = new Node(11);
		Node _13 = new Node(13);
		Node _15 = new Node(15);
		Node _17 = new Node(17);
		Node _22 = new Node(22);
		Node _25 = new Node(25);
		Node _27 = new Node(27);
		_1.children = new Node[] { _6 };
		_8.children = new Node[] { _1, _11 };
		_13.children = new Node[] { _8, _17 };
		_17.children = new Node[] { _15, _25 };
		_25.children = new Node[] { _22, _27 };
		Node root = _13;
		obj.populateRightChild(root);
		System.out.println(_25.right);
	}

}
