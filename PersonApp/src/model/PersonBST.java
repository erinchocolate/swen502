package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonBST{
	private Node root = null;
	private int height;
	private Comparator comparator;	
	private List<Node> sortedArray = new ArrayList<>();
	private List<Person> sortedData = new ArrayList<>();
	private List<Person> personByNameLength = new ArrayList<>();
	
	// Internal node containing node references
	// and the actual person object
	private class Node{
		Person person;
		Node left, right;
		
		Node(Person person) {
		     this.person = person;
		}
		
		Node(Node left, Node right, Person person) {
			this.left = left;
			this.right = right;
			this.person = person;
		}
	}
		
	// Construct BST to store people object sorted by 
	// different attributes(first name, age etc)
	PersonBST(Comparator comparator){
		setComparator(comparator);
	}
	
	public void setComparator(Comparator comparator) {
		this.comparator = comparator;
	}
	
	// Returns true if the person exists in the tree
    public boolean contains(Person person) {
    	return contains(root, person);
    }
    
    // private recursive method to find if the person exists in the tree
    private boolean contains(Node node, Person person) {
    	if(node == null) { 
    		return false;   	
    	}
    	if(comparator.compare(node.person, person) > 0) {
    		return contains(node.left, person);
    	}
    	else if(comparator.compare(node.person, person) < 0){
    		return contains(node.right, person);
    	} 
    	else {
    		return true;
    	}
    }
        		
	// Add a person to the tree.
	public void add(Person person) {
		root = add(root, person);
	}
	
    // Private method to recursively add a person in the tree
	private Node add(Node node, Person person) {
		if(node == null) return new Node(person);
		// Use comparator to decide which subtree to insert 
		// Different person has different id, therefore there won't be duplicate
		// person in the tree. 
		// Different person might have same attribute like name or age,
		// but they are not the same object because of the setup of the comparator 
		// and the existence of the id
		if(comparator.compare(node.person, person) > 0) {
			node.left = add(node.left, person);
		}
		else {
			node.right = add(node.right, person);
		}		
		return node;
	}	
	
	// Remove a person from the tree if it exists
    public void delete(Person person) {
    	root = delete(root, person);
    }
    
    private Node delete(Node node, Person person) {
    	if(node == null) {
    		return null;  	
    	}
    	if(comparator.compare(node.person, person) > 0) {
    		node.left = delete(node.left, person);
    	}
    	else if(comparator.compare(node.person, person) < 0) {
			node.right = delete(node.right, person);
		}
    	// Found the node we want to remove
    	else {
    		// If the node only has left child or no child, 
    		// swap the node with its right child
    		if(node.left == null) {
    			return node.right;
    		} 
    		// If the node only has right child or no child, 
    		// swap the node with its left child
    		else if(node.right == null) {
    			return node.left;
    		}
    		// If the node has both right child and left child,
    		// swap the node with its biggest child in the left subtree or
    		// its smallest child in the right subtree.
    		// I choose to find the smallest child in the right subtree.
    		else {
    			// Find the smallest child in the right subtree
    			Node temp = findMin(node.right); 
    			// Swap the person object
    			node.person = temp.person; 	
    			// Remove the smallest child of the right subtree
    			node.right = delete(node.right, temp.person);
    		}
    	} 	
    	return node;  	
    }
           
    // Private method to recursively find the biggest child in the left subtree
    private Node findMin(Node node) {
    	while(node.left!=null) {
    		node = node.left;   	
    	}
    	return node;
    }	
       
    // Get the height of the tree
    public int height() {
    	return height(root);
    }
    
    // Private method to recursively compute the height of the tree
    private int height(Node root) {
    	if(root == null) {
    		return 0;
    	}
    	return Math.max(height(root.left), height(root.right)) + 1;   	
    }
    
    // Check if the tree is balanced 
    public boolean isBalanced() {
    	return isBalanced(root);
    }
    
    // Private method to recursively check if the tree is balanced
    private boolean isBalanced(Node root) {
    	if(root == null){
    		return true;
    	}
    	// Check if subtrees have height within 1. If they do, check if the
        // subtrees are balanced
    	return Math.abs(height(root.left) - height(root.right)) < 2
    	        && isBalanced(root.left)
    	        && isBalanced(root.right);
    }
    
    // Construct a balanced tree
    public void balance() {
    	balancedBST(root);
    }
        
    // Use in-order traversal to get a sorted array
    // Construct a new balanced tree from the sorted array recursively
    private Node balancedBST(Node root) {
    	inorder(root);
    	return sortedArrayToBST(0, sortedArray.size() - 1);
    }
    
    //
    private Node sortedArrayToBST(int start, int end) {
    	// If start > end, then there is no elements available for that subtree
    	if(start > end) {
    		return null;
    	}
    	// Choose left middle node as a root
    	int mid = (start + end) /2;
    	Node root = sortedArray.get(mid);
    	// Compute recursively left and right subtrees
    	root.left = sortedArrayToBST(start, mid-1);
    	root.right = sortedArrayToBST(mid + 1, end);
    	return root;
    }
    
    public void inorder() {
    	inorder(root);
    }
	
    private void inorder(Node root) {
    	if (root == null) {
            return;
        }
        inorder(root.left);
        //System.out.println(root.person);
        sortedArray.add(root);
        sortedData.add(root.person);
        inorder(root.right);
    }
    
    public void preorder() {
        preorder(root);
    }

    private void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.person + " ");
        preorder(root.left);
        preorder(root.right);
    }
    
    public void postorder() {
        postorder(root);
    }

    private void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.person + " ");
    }
    
    public void levelorder() {
    	height = height(root);
        for (int i = 1; i <= height; i++) {
        	levelorder(root, i);
        }        	
    }
    
    private void levelorder(Node root, int level)
    {
        if (root == null) {
        	return;
        }            
        if (level == 1) {
        	System.out.print(root.person + " ");
        }            
        else if (level > 1) {
        	levelorder(root.left, level - 1);
        	levelorder(root.right, level - 1);
        }
    }
    
    // Returns the person by firstname
    // Needs to refactor the code to have one function that can search first name,
    // last name and age
    public Person searchByFirstName(String firstName) {
    	if(searchByFirstName(root, firstName) == null) {
    		return null;
    	}
    	return(searchByFirstName(root, firstName).person);
    }
    
    private Node searchByFirstName(Node node, String firstName) {
    	if(node == null) {
    		return null;
    	}  		
    	int cmp = node.person.getFirstName().compareTo(firstName);
		if(cmp > 0) { 
    		return(searchByFirstName(node.left, firstName));
    	}
    	else if(cmp < 0){
    		return(searchByFirstName(node.right, firstName));
        }   
    	else{
    		return node;
    	}
    }   
    
    public Person searchByLastName(String name) {
    	if(searchByLastName(root, name) == null) {
    		return null;
    	}
    	return(searchByLastName(root, name).person);
    }
    
    private Node searchByLastName(Node node, String name) {
    	if(node == null) {
    		return null;
    	}  		
    	int cmp = node.person.getLastName().compareTo(name);
		if(cmp > 0) { 
    		return(searchByLastName(node.left, name));
    	}
    	else if(cmp < 0){
    		return(searchByLastName(node.right, name));
        }   
    	else{
    		return node;
    	}
    }
    
    public Person searchByAge(int age) {
    	if(searchByAge(root, age) == null) {
    		return null;
    	}
    	return(searchByAge(root, age).person);
    }
    
    private Node searchByAge(Node node, int age) {
    	if(node == null) {
    		return null;
    	}  		
    	int cmp = node.person.getAge()-age;
		if(cmp > 0) { 
    		return(searchByAge(node.left, age));
    	}
    	else if(cmp < 0){
    		return(searchByAge(node.right, age));
        }   
    	else{
    		return node;
    	}
    }  
    
    public List<Person> getSortedData() {
    	if(sortedData != null) {
    		sortedData.clear();
    		inorder();
    	}
    	return sortedData;
    }    
    
    // Use preoreder to find the person with certain length of the first name
    public void preorderByNameLength(int length) {
    	preorderByNameLength(root, length);
    }
    
    private void preorderByNameLength(Node root, int length) {
    	if (root == null) {
            return;
        }
    	if(root.person.getFirstNameLength() == length) {
    		personByNameLength.add(root.person);
    	}
    	preorderByNameLength(root.left, length);
    	preorderByNameLength(root.right, length);
    }
    
    public List<Person> getPersonByNameLength() {
    	return personByNameLength;
    }
       
}
