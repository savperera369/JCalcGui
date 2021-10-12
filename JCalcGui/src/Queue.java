// The code for this Queue data 
// structure was taken from Professor
// Ferrie's myCourses page from 
// the Supplemental Topic-Data Structures sheet
// Some comments were also taken from the above sheet

public class Queue {
	/**
	 * The following method adds a string to the back(rear) of the queue
	 * @param value is the string being added to the queue
	 */
	public void enqueue(String value) {
		listNode node = new listNode(); // create empty listNode
		node.data = value; // set data value of node to parameter string
		node.next = null; // set the link to null
		if(rear!=null) {
			rear.next = node; // attach the above node to the rear of the queue
		} else 
		front = node; // make front point to new node
		rear = node; // in either case rear points to new node
	}
	
	/**
	 * The following method removes a string from the front of the queue
	 * @return The method returns a string from the front of the queue
	 */
	public String dequeue() {
		if (front!=null) { 
			if (front==rear) rear = null; // if there is only one node in the queue, set the rear pointer to null
			String j = front.data; // obtain the data stored in the front node
			front = front.next; // set the front node to the next node in the queue
			return j; // return the string stored in the front node
		}
		else return null; // if queue is empty return null
	}
	
	/**
	 * This method returns a string that is composed of the individual strings in a queue
	 */
	public String toString() {
		String result = ""; // initialize empty string
		while(true) {
			String j = dequeue(); // while queue is non empty, dequeue strings
			if (j==null) break;
			result +=(j+ " "); // add the string to the result string
		}
		return result; // return the result string
	}
	
	// 2 instance variables of type listNode to keep track of the front and back of the queue
	listNode front = null;
	listNode rear = null;
}
