/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial_edd;
import doublelinkedlist.DoubleLinkedList;
import doublelinkedlist.ListNode;
import java.util.Iterator;


/**
 *
 * @author Repre
 *//*
1 1 1 1 1 1
1 1 1 0 0 1
1 0 0 0 e 1
1 0 0 m 1 1
1 1 1 1 1 1
 */

import java.util.Scanner;


public class Parcial_EdD {
    public static String ResultToString(DoubleLinkedList result) {
        StringBuilder resultToString = new StringBuilder();
         ListNode current =result.Start;
         for(int i=0;i<result.size;i++){
             
             int[] coordinates=(int[])current.Value;
             resultToString.append("[").append(coordinates[0]).append(":").append(coordinates[1]).append("]");
             current=current.Next;
         }
        return resultToString.toString();
    }
    public static boolean CheckDirection(int []direction, int []point, DoubleLinkedList map) {
        String[] badChars = {"1", "-1"};
        if (direction[0] == 1) {
            if (point[0] + 1 < map.size) {
                for (String badChar : badChars) {
                    if (((String[])map.Get(point[0] + 1))[point[1]].equals(badChar)) {
                        return false;
                    }
                }
                return true;
            }
        } else if (direction[0] == -1) {
            if (point[0] - 1 >= 0) {
                for (String badChar : badChars) {
                    if (((String[])map.Get(point[0] - 1))[point[1]].equals(badChar)) {
                        return false;
                    }
                }
                return true;
            }
        } else if (direction[1] == 1) {
            if (point[1] + 1 < ((String[])map.Get(0)).length) {
                for (String badChar : badChars) {
                    if (((String[])map.Get(point[0]))[point[1] + 1].equals(badChar)) {
                        return false;
                    }
                }
                return true;
            }
        } else if (direction[1] == -1) {
            if (point[1] - 1 >= 0) {
                for (String badChar : badChars) {
                    if (((String[])map.Get(point[0]))[point[1] - 1].equals(badChar)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
    public static DoubleLinkedList TestNear(
            int[] current,
            int[] objective,
            DoubleLinkedList map,
            DoubleLinkedList target
            ) {
        int [][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        DoubleLinkedList[] directionsResults = new DoubleLinkedList[]{null, null, null, null};
        for (int index = 0; index < 4; index++) {
            if (CheckDirection(directions[index], current, map)) {
                
                ((String[])map.Get(current[0]))[current[1]] = "-1";
                int []newCurrent = {current[0] + directions[index][0], current[1]+ directions[index][1]};
                DoubleLinkedList context = CopyList(target);
                
                context.add(newCurrent);
                if (newCurrent[0] == objective[0] && newCurrent[1] == objective[1]) {
                    return context;
                }
                directionsResults[index] = TestNear(newCurrent, objective, map, context);
            }
        }
        for (DoubleLinkedList result : directionsResults) {
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    public static void FindRoute(DoubleLinkedList map) {
        int start[] = {0, 0};
        int objective[] = { 0, 0};
        for (int rowIndex = 0; rowIndex < map.size; rowIndex++) {
            for (int columnIndex = 0; columnIndex < ((String[])map.Get(rowIndex)).length; columnIndex++) {
                if (((String[])map.Get(rowIndex))[columnIndex].equals("e")) {
                    objective[0] = rowIndex;
                    objective[1] = columnIndex;
                } else if (((String[])map.Get(rowIndex))[columnIndex].equals("m")) {
                    start[0] = rowIndex;
                    start[1] = columnIndex;
                }
            }
        }
        if (((String[])map.Get(objective[0]))[objective[1]].equals("e") && ((String[])map.Get(start[0]))[start[1]].equals("m")) {
            DoubleLinkedList target = new DoubleLinkedList();
            target.add(start);
            System.out.println(ResultToString(TestNear(start, objective, map, target)));
        }
    }

    public static DoubleLinkedList GetMap() {
        Scanner scanner = new Scanner(System.in);
        DoubleLinkedList map = new DoubleLinkedList();
        String line;
        while (true) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                break;
            }
            map.add(line.split(" "));
        }
        return map;
    }

    public static void main(String[] args) {
        FindRoute(GetMap());
    }
    
    public static DoubleLinkedList CopyList(DoubleLinkedList list){
        Iterator<ListNode>  ite = list.iterator();
        DoubleLinkedList result= new DoubleLinkedList();
        while(ite.hasNext()){
             result.add(ite.next().Value);
         }
        
        return result;
    }
}