/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublelinkedlist;

import java.util.Iterator;

/**
 *
 * @author Repre
 */
public interface ListInterface {
    public boolean isEmpty();

    public int getSize();

    public void clear();

    public Object getHead();

    public Object getTail();

    public ListNode search(Object object);

    public boolean add(Object object);

    public boolean insert(ListNode node, Object object);

    public boolean insert(Object ob, Object object);

    public boolean insertHead(Object value);

    public boolean insertTail(Object object);

    public boolean remove(ListNode Node);
    
    public boolean remove(Object object);

    /*
    expansion operations
     */
    public boolean contains(Object object);

    public Iterator<ListNode> iterator();

    public Object[] toArray();

    public Object[] toArray(Object[] object);

    public Object getBeforeTo();

    public ListNode getBeforeTo(ListNode node);

    public Object getNextTo();

    public Object getNextTo(ListNode node);

    public DoubleLinkedList subList(ListNode from, ListNode to);

    public DoubleLinkedList sortList();
}
