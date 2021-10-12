// The code for this Stack data 
// structure was taken from Professor
// Ferrie's myCourses page from 
// the Supplemental Topic-Data Structures sheet
// Some comments were also taken from this sheet

public class Stack {
	/**
	 * This method pushes a string to the top of the stack
	 * @param value This parameter is a string
	 */
	public void push(String value) {
		listNode node = new listNode(); // create new listNode
		node.data = value; // set the data to the input string
		node.next = top; // link to rest of the stack
		top = node;	// top of stack now points to this new node
	}
	
	/**
	 * This method pops a string from the top of the stack
	 * @return This method returns a value of type String
	 */
	public String pop() {
		if (top==null) return null; // check to see if stack is empty
		String popped = top.data; // get data from the top node
		top = top.next; // set top node to the next node
		return popped; // return the string data from the top of the stack
	}
	
	// 1 instance variable of type listNode to refer to the top of the stack
	listNode top = null;
}
