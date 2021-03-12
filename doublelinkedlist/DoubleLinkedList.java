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
public class DoubleLinkedList implements ListInterface, Iterable<ListNode>{
    public ListNode Start;
    public ListNode End;
    public int size;
    private ListNode inode;

    public DoubleLinkedList() {
        this.Start = null;
        this.End = null;
        this.size = 0;
    }
    
    @Override
    public int getSize() {
        return size;
    }
    
    @Override
    public boolean isEmpty() {
        return Start == null;
    }
    
    @Override
    public void clear() {
        Start = null;
        End = null;
        size = 0;
    }
    
    @Override
    public Object getHead() {
        return Start;
    }
    
    @Override
    public Object getTail() {
        return End;
    }
    
    public int GetIndex(Object object){
        for(int i=0;i<this.size;i++){
            if(object==this.Get(i)){
                return i;
            }
        }
        throw new IndexOutOfBoundsException("Object not in list");
    }
    
    
    public Object Get(int index) {
        if (isEmpty() == true) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        ListNode current = this.Start;
        for (int list_index = 0; list_index < this.size; list_index++) {
            if (list_index == index) {
                return current.Value;
            }
            current = current.Next;
        }
        // It will never execute this
        return null;
    }
    
    public ListNode GetNode(int index) {
        if (isEmpty() == true) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        ListNode current = this.Start;
        for (int list_index = 0; list_index < this.size; list_index++) {
            if (list_index == index) {
                return current;
            }
            current = current.Next;
        }
        // It will never execute this
        return null;
    }

    @Override
    public ListNode search(Object object) {
        Iterator<ListNode> i = this.iterator();
        ListNode inode;
        while ((inode = i.next()) != null) {
            if (inode.getObject().toString().equals(object.toString())) {
                return inode;
            }
        }
        i = this.RevIterator();
        while ((inode = i.next()) != null) {
            if (inode.getObject().toString().equals(object.toString())) {
                return inode;
            }
        }
        
        
        return null;
    }
    
    @Override
    public boolean add(Object value) {
        try {
            this.insertTail(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    

    @Override
    public boolean insert(ListNode node, Object object) {
        try {
            if (node.Next == null) {
                add(object);
            } else {
                ListNode newNode = new ListNode(object);
                newNode.Next = node.Next;
                node.Next = newNode;
            }
            size++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean insert(Object ob, Object object) {
        try {
            if (ob != null) {
                ListNode node = this.search(ob);
                if (node != null) {
                    return insert(node, object);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
       
    public boolean insertTail(Object value){
        try{
        if (isEmpty() == true) {
            
            this.Start = new ListNode(value);
            this.End = this.Start;
            this.Start.Before=null;
        } else {
            ListNode old_end_node = this.End;
            this.End = new ListNode(value);
            this.End.Before = old_end_node;
            old_end_node.Next = this.End;
        }
        this.size++;
        return true;
        }
        catch (Exception e) {
            return false;
        }
    }     
    
    
    
    @Override
    public boolean insertHead(Object value){
        try{
        if (isEmpty() == true) {
            this.Start = new ListNode(value);
            this.End = this.Start;
            this.Start.Before=null;
            
        } else {
            Start = new ListNode(value, Start);
            Start.Before=null;
        }
        this.size++;
        return true;
        }
        catch (Exception e) {
            return false;
        }
    }        
            
    public void Remove(int index) {
    if (isEmpty() == true) {
                throw new IndexOutOfBoundsException("List is empty");
            }
            if (index >= this.size) {
                throw new IndexOutOfBoundsException("Index out of range");
            }
            if (this.size == 1) {
                // The list has only one Node
                this.Start = null;
                this.End = null;
            } else if (index == 0) {
                // First Node
                this.Start = this.Start.Next;
                this.Start.Before = null;
            } else if (index == this.size - 1) {
                // Last Node
                this.End = this.End.Before;
                this.End.Next = null;
            } else {
                // Any middle node
                ListNode current = this.Start;
                for (int list_index = 0; list_index < this.size; list_index++) {
                    if (list_index == index) {
                        // Node1 -> Node2 -> Node3
                        // Node1 -> Node3
                        current.Before.Next = current.Next;
                        current.Next.Before = current.Before;
                        break;
                    }
                    current = current.Next;
                }
            }
            this.size--;
            
    }
    /*
    Provisional method, not final version
    */
    @Override
    public boolean remove(ListNode node) {
        try {
            int index = this.GetIndex(node.getObject());
            this.Remove(index);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    /*
    Provissional method, not final version
    */
    @Override
    public boolean remove(Object object) {
        try {
            int index = this.GetIndex(object);
            this.Remove(index);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public boolean contains(Object object) {
        if(this.search(object)==null){
            return false;
        }
        else{
            return true;
        }
    }
    
    @Override
    public Object[] toArray(){
        Object[] arrayOfObjects = new Object[this.size];
        for(int i=0;i<this.size;i++){
            arrayOfObjects[i]=this.Get(i);
        }
        return arrayOfObjects;
    }
    
    @Override
    public Object[] toArray(Object[] arrayOfObjects){
        for(int i=0;i<this.size;i++){
            arrayOfObjects[i]=this.Get(i);
        }
        return arrayOfObjects;
    }
    
    @Override
    public ListNode getBeforeTo(ListNode node){
        ListNode current= this.search(node.getObject());
        current= current.Before;
        return current;
    }
    
    @Override
    public Object getNextTo(ListNode node){
        ListNode current= this.search(node.getObject());
        current= current.Next;
        return current;
    }
    
    @Override
    public DoubleLinkedList subList(ListNode from, ListNode to) {
        if (this.contains(from.getObject()) == true && this.contains(to.getObject()) == true) {
            int indexFrom = this.GetIndex(from.getObject());
            int indexTo = this.GetIndex(to.getObject());
            DoubleLinkedList subList = new DoubleLinkedList();

            for (int i = 0; i < this.size; i++) {
                if (i >= indexFrom && i <= indexTo) {
                    subList.add(this.Get(i));
                }
            }

            return subList;
        }
        else{
            throw new IndexOutOfBoundsException("At least one of the two nodes are not in list");
        }
    }
    
    @Override
    public Iterator<ListNode> iterator() {
        inode = Start;
        return new Iterator<ListNode>() {
            @Override
            public boolean hasNext() {
                return inode != null;
            }

            @Override
            public ListNode next() {
                if (inode != null) {
                    ListNode tmp = inode;
                    inode = inode.Next;
                    return tmp;
                } else {
                    return null;
                }
            }
        };
    }
    
    public Iterator<ListNode> RevIterator() {
    inode = End;
    return new Iterator<ListNode>(){
        @Override
        public ListNode next() {
                if (inode != null) {
                    ListNode tmp = inode;
                    inode = inode.Before;
                    return tmp;
                } else {
                    return null;
                }
            }
            @Override
            public boolean hasNext() {
                return inode.Before != null;
            }
    };
    }

    
    

    
    @Override
    public Object getBeforeTo() {
        return null;
    }

    @Override
    public Object getNextTo() {
        return null;
    }
    
    @Override
    public DoubleLinkedList sortList() 
    { 
        DoubleLinkedList sortedList= new DoubleLinkedList();
        // Node current will point to head 
        ListNode current = this.Start, index = null; 
  
        int temp; 
  
        if (this.Start == null) { 
            return null; 
        } 
        else { 
            while (current != null) { 
                index = current.Next; 
  
                while (index != null) {  
                    if ((int)current.Value > (int)index.Value) { 
                        temp = (int)current.Value; 
                        current.Value = index.Value; 
                        index.Value = temp;
                        
                    } 
                    
                    index = index.Next; 
                } 
                sortedList.add(current.Value);
                current = current.Next; 
            } 
        }
        return sortedList;
    }
        
}
