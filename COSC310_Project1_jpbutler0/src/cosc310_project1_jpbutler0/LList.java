package cosc310_project1_jpbutler0;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Reaper
 */
public class LList<E> implements List<E> {

    private Link<E> head; // Pointer to list header
    private Link<E> tail; // Pointer to last element
    protected Link<E> curr; // Access to current element
    int cnt; // Size of list

    /**
     * Constructors
     */
    LList(int size) {
        this();
    } // Constructor -- Ignore size

    LList() {
        curr = tail = head = new Link<E>(null); // Create header
        cnt = 0;
    }

    /**
     * Remove all elements
     */
    public void clear() {
        head.setNext(null); // Drop access to links
        curr = tail = head = new Link<E>(null); // Create header
        cnt = 0;
    }

    /**
     * Insert "it" at current position
     */
    public void insert(E it) {
        curr.setNext(new Link<E>(it, curr.next()));
        if (tail == curr) {
            tail = curr.next(); // New tail
        }
        cnt++;
    }

    /**
     * Append "it" to list
     */
    public void append(E it) {
        tail = tail.setNext(new Link<E>(it, null));
        cnt++;
    }

    /**
     * Remove and return current element
     */
    public E remove() {
        if (curr.next() == null) {
            return null; // Nothing to remove
        }
        E it = curr.next().element(); // Remember value
        if (tail == curr.next()) {
            tail = curr; // Removed last
        }
        curr.setNext(curr.next().next()); // Remove from list
        cnt--; // Decrement count
        return it; // Return value
    }

    /**
     * Set curr at list start
     */
    public void moveToStart() {
        curr = head;
    }

    /**
     * Set curr at list end
     */
    public void moveToEnd() {
        curr = tail;
    }

    /**
     * Move curr one step left; no change if now at front
     */
    public void prev() {
        if (curr == head) {
            return; // No previous element
        }
        Link<E> temp = head;
        // March down list until we find the previous element
        while (temp.next() != curr) {
            temp = temp.next();
        }
        curr = temp;
    }

    /**
     * Move curr one step right; no change if now at end
     */
    public void next() {
        if (curr != tail) {
            curr = curr.next();
        }
    }

    /**
     * @return List length
     */
    public int length() {
        return cnt;
    }

    /**
     * @return The position of the current element
     */
    public int currPos() {
        Link<E> temp = head;
        int i;
        for (i = 0; curr != temp; i++) {
            temp = temp.next();
        }
        return i;
    }

    /**
     * Move down list to "pos" position
     */
    public void moveToPos(int pos) {
        assert (pos >= 0) && (pos <= cnt) : "Position out of range";
        curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.next();
        }
    }

    /**
     * @return Current element value
     */
    public E getValue() {
        if (curr.next() == null) {
            return null;
        }
        return curr.next().element();
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection<? extends E> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(int i, Collection<? extends E> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E set(int i, E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(int i, E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E remove(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<E> listIterator(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<E> subList(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
