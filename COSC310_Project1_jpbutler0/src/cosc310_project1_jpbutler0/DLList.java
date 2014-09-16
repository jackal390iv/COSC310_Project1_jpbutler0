package cosc310_project1_jpbutler0;

/**
 *
 * @author Reaper
 */
public class DLList {

    public DLListNode head;
    public DLListNode tail;

    public DLList() {
        head = tail = null;
    }

    /**
     * adds elements to the back
     *
     * @param element
     */
    public void append(Object element) {
        if (head == null) {
            head = tail = new DLListNode(element, null, null);
            return;
        }

        tail = new DLListNode(element, tail, null);
        tail.prev.next = tail;
    }

    /**
     * Add the element into the right location of the list, maintain the order
     * of the list
     *
     * @param element
     */
    public void insert(Object element) {
        if (head == null) {
            head = tail = new DLListNode(element, null, null);
            return;
        }

        head.prev = new DLListNode(element, null, head);
        head = head.prev;

    }

    /**
     * Remove the list node which contains data that has the same value as the
     * element
     *
     * @param element
     * @return true if successful, false otherwise
     */
    public void remove(Object element) {
        if (head == null) {
            return;
        }
        if (((Comparable) head.data).compareTo(element) == 0) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            return;
        }

        if (head == tail) {
            return;
        }
        DLListNode ref = head.next;
        while (ref != tail) {
            if (((Comparable) ref.data).compareTo(element) == 0) {
                ref.prev.next = ref.next;
                ref.next.prev = ref.prev;
                return;
            }
            ref = ref.next;
        }

        if (((Comparable) tail.data).compareTo(element) == 0) {
            tail = tail.prev;
            tail.next = null;
        }
    }

    /**
     * makes the list empty
     */
    public void clear() {
        if (head == null) {
            return;
        } else {
            head = tail = null;
        }

    }

    /**
     * tells the size of the DLList
     *
     * @return
     */
    public int size() {
        if (head == null) {
            return 0;
        }
        if (head == tail) {
            return 1;
        }
        DLListNode temp = head;
        int i = 0;
        while (temp != null) {
            temp = temp.next;
            ++i;
        }
        return i;
    }

    /**
     *
     * @return prints out the DDList in order
     */
    @Override
    public String toString() {

        String temp = "\n";
        temp += "++++++++++++++++++++++++++++++++++++++++++++++++++\n";
        temp += "The DLList from front to rear contains:\n";
        temp += "size= " + size() + "\n";
        if (head == null) {
            return "The DLList is empty";
        }

        DLListNode ref = head;
        int i = 0;
        while (ref != tail) {
            temp += "\n";
            temp += "Element ";
            temp += i;
            temp += ": ";
            temp += "\t";
            temp += ref.data;
            i++;
            ref = ref.next;
        }
        temp += "\n++++++++++++++++++++++++++++++++++++++++++++++++++\n";
        return temp;
    }
}
