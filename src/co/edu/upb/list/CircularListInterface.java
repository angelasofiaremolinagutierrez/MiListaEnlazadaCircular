package co.edu.upb.list;

import java.util.Iterator;

public interface CircularListInterface {

    /*
    essential operations
    */
    public boolean isEmpty();

    public int getSize();

    public void clear();

    public Object getHead();

    public Object getTail();

    public Object get(CircularListNode node);

    public Object search(Object object);

    public boolean add(Object object);

    public boolean insert(CircularListNode node, Object object);

    public boolean insert(Object ob, Object object);

    public boolean insertHead(Object object);

    public boolean insertTail(Object object);

    public boolean set(CircularListNode node, Object object);

    public boolean remove(CircularListNode node);

    /*
    expansion operations
     */
    public boolean contains(Object object);

    public Iterator<CircularListNode> iterator();

    public Object[] toArray();

    public Object[] toArray(Object[] object);

    //el metodo de getNextTo fueron transladados a la clase CircularListNode

    public Object getBeforeTo(CircularListNode node);

    public Object getNextTo(CircularListNode node);

    public CircularList subList(CircularListNode from, CircularListNode to);

    public CircularList sortList();
}
