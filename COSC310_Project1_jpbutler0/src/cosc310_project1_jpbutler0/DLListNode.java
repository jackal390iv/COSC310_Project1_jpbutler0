package cosc310_project1_jpbutler0;

/**
 *
 * @author Reaper
 */
public class DLListNode {

    public Object data;
    public DLListNode prev;
    public DLListNode next;

    public DLListNode(Object d, DLListNode p, DLListNode n) {
        data = d;
        prev = p;
        next = n;
    }
}
