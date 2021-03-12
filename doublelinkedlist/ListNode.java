/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublelinkedlist;

/**
 *
 * @author Repre
 */
public class ListNode {
    public Object Value;
    public ListNode Next;
    public ListNode Before;
  
    public ListNode(){
    this.Value=null;
    this.Next=null;
    this.Before=null;
}
    
    public ListNode(Object value) {
        this.Value = value;
        this.Next = null;
    }
    
    public ListNode(Object object, ListNode next) {
        this.Value = object;
        this.Next = next;
    }

    public Object getObject() {
        return Value;
    }

    public void setObject(Object object) {
        this.Value = object;
    }

    public boolean isEquals(Object object) {
        if (this.getObject().toString().equals(object.toString())) {
            return true;
        }
        return false;
    }

    public boolean isEquals(ListNode node) {
        if (this.toString().equals(node.toString())) {
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "ListNode{" +
                "object=" + Value +
                //"before" + Before+
                ", next=" + Next +
                '}';
    }
}
