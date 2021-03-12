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
public class main {
    public static void main(String[] args) {
        DoubleLinkedList lista = new DoubleLinkedList();
        
        lista.add(4);
        lista.add(2);
        lista.add(6);
        lista.add(4);
        lista.add(5);
        
        //lista.insertHead(1);
        lista.insert(lista.GetNode(0), 8);
         //System.out.println(lista.search(2));

        for(int i=0;i<lista.size;i++){
            System.out.println(lista.Get(i));
        }
        System.out.println("");
        lista= lista.sortList();
        for(int i=0;i<lista.size;i++){
            System.out.println(lista.Get(i));
        }
    }
}
