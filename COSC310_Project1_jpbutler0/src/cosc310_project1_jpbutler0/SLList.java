package cosc310_project1_jpbutler0;

/**
 *
 * @author Reaper
 */
public class SLList {

    private SLListNode head;
    private SLListNode tail;

    /*
     * this constructer sets up an empty singly link list.
     */
    public SLList() {
        head = tail = null;
    }

    /*
     *@elements added to the end of the list
     */
    public void append(Object element) {
        if (head == null) {
            head = tail = new SLListNode(element, null);
            return;
        }

        tail = tail.next = new SLListNode(element, null);

    }

    /*
     *@element passed to the begining of the list
     */
    public void insert(Object element) {
        if (head == null) {
            head = tail = new SLListNode(element, null);
            return;
        }
        head = new SLListNode(element, head);
    }

    /*
     * The isEmpty method returns true if the list is empty and false if it is not
     */
    public boolean isEmpty() {
        return head == null;
    }

    /*
     * Counts the amount of elements in the list and then it returns the size 
     */
    public int size() {
        if (head == null) {
            return 0;
        }
        if (head == tail) {
            return 1;
        }

        int size = 0;
        SLListNode ref = head;
        while (ref != null) {
            ref = ref.next;
            size++;
        }
        return size;
    }

    /*
     * Checks the list to see if the object is in the list that the user wants to remove
     * once the object is found the user grabs the object and returns true
     * If the object is not found then the list returns false
     */
    public boolean remove(Object element) {
        if (head == null) {
            return false;
        }
        if (((Comparable) (head.data)).compareTo((Comparable) element) == 0) {
            if (head == tail) {
                head = tail = null;
                return true;
            }
            head = head.next;
            return true;
        }

        if (head == tail) {
            return false;
        }

        SLListNode ref = head;
        while (ref.next != tail) {
            if (((Comparable) (ref.next.data)).compareTo(element) == 0) {
                ref.next = ref.next.next;
                return true;
            }
            ref = ref.next;
        }
        if (((Comparable) (ref.next.data)).compareTo(element) == 0) {
            tail = ref;
            tail.next = null;
            return true;
        }
        return false;
    }

    /*
     * Removes the elements in the list
     */
    public void clear() {
        head = tail = null;
    }

    /*
     * Prints the list and it returns the size and objects 
     */
    public String toString() {
        String temp = "\n";
        temp += "The current Single Linked List contains: \n";
        temp += "size = " + size() + "\n";
        if (head == null) {
            return "The list is empty.";
        }
        if (head == tail) {
            temp += head.data;
            return temp;
        }

        SLListNode ref = head;
        int i = 0;
        while (ref != null) {
            if ((i) % 5 == 0 && (Integer) ref.data < 10) {
                temp += "\n";
                temp += " ";
            } else if ((i) % 5 == 0) {
                temp += "\n";
            }
            if ((Integer) ref.data < 1000 && (Integer) ref.data > 99) {
                temp += " ";
            }
            if ((Integer) ref.data < 100) {
                temp += " ";
            }
            temp += ref.data;
            temp += "";
            temp += "\t";
            ref = ref.next;
            i++;

        }
        System.out.println();
        return temp;
    }
}
