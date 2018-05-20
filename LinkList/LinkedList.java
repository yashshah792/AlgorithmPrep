package linkedlist;
import java.awt.HeadlessException;

import javax.swing.text.DefaultStyledDocument.ElementSpec;

import org.graalvm.compiler.core.gen.NodeLIRBuilder;

import linkedlist.ListNode;

public class LinkedList{
    ListNode head;

    public LinkedList(){
        lenght = 0;
    }

    private int length = 0;
    
    // get first node i.e. head
    public ListNode getHead(){
        return head;
    }
/*
    ___                     _   _               _       _          _     _       _            _ _     _     _   
    |_ _|_ __  ___  ___ _ __| |_(_)_ __   __ _  (_)_ __ | |_ ___   | |   (_)_ __ | | _____  __| | |   (_)___| |_ 
     | || '_ \/ __|/ _ \ '__| __| | '_ \ / _` | | | '_ \| __/ _ \  | |   | | '_ \| |/ / _ \/ _` | |   | / __| __|
     | || | | \__ \  __/ |  | |_| | | | | (_| | | | | | | || (_) | | |___| | | | |   <  __/ (_| | |___| \__ \ |_ 
    |___|_| |_|___/\___|_|   \__|_|_| |_|\__, | |_|_| |_|\__\___/  |_____|_|_| |_|_|\_\___|\__,_|_____|_|___/\__|
                                         |___/                                                                   
                                        */

    // Insert node in the beginning
    public void insertAtBeginning(ListNode node){
        node.setNext(head);
        head = node;
        length++;
    }

    // Insert node at the end
    public void insertAtEnd(ListNode node){
        if(head == null){
            head = node;
        }
        else{
            ListNode current, end;
            for(current = head; (end = current.getNext()) != null ; current = end){
                current.setNext(node);
                length++;
            }
        }
    }

    // Insert node at a given position
    public void insert(int data, int position){
        if(position < 0){
            position = 0;
            if(head == null){
                head = new ListNode(data);
            }else{
                ListNode tmp = new ListNode(data);
                insertAtBeginning(tmp);
            }
        }else if(position > length){
            position = length;
            ListNode tmp = new ListNode(data);
            insertAtEnd(tmp);
        }else{
            ListNode tmp = head;
            for(int i = 0; i < position; i++){
                tmp = tmp.getNext();
            }
            ListNode newNode = new ListNode(data);
            newNode.next = temp.next;
            temp.setNext(newNode);
        }
        length++;
    }

/*   ____                           _                __                       _     _       _            _ _     _     _   
 |  _ \ ___ _ __ ___   _____   _(_)_ __   __ _   / _|_ __ ___  _ __ ___   | |   (_)_ __ | | _____  __| | |   (_)___| |_ 
 | |_) / _ \ '_ ` _ \ / _ \ \ / / | '_ \ / _` | | |_| '__/ _ \| '_ ` _ \  | |   | | '_ \| |/ / _ \/ _` | |   | / __| __|
 |  _ <  __/ | | | | | (_) \ V /| | | | | (_| | |  _| | | (_) | | | | | | | |___| | | | |   <  __/ (_| | |___| \__ \ |_ 
 |_| \_\___|_| |_| |_|\___/ \_/ |_|_| |_|\__, | |_| |_|  \___/|_| |_| |_| |_____|_|_| |_|_|\_\___|\__,_|_____|_|___/\__|
                                         |___/                                                                          */

    // Remove head
    public ListNode removeFromBegining(){
        ListNode node = head;
        if(node != null){
            head = node.getNext();
            node.setNext(null);
        }
        length--;
        return node;
    }
    
    //Remove the last node
    public ListNode removeFromEnd(){
        //linklist empty
        if(head == null){
            return null;
        }
        if(head.next == null){
            ListNode tmp = head;
            head = null;
            return tmp;
        }
        ListNode x = head, y = null, next = head.getNext();
        while((next = p.getNext()) != null){
            y = x;
            y = next;
        }
        y.setNext(null);
        length--;
        return x;
    }

    // Remove value at a specific location
    public void remove(int position){
        if(position <= 0){
            removeFromBegining();
        }else if(position >= length){
            removeFromEnd();
        }else{
            ListNode temp = head;
            for(int i =0; i < position; i++){
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
        }
        length--;
    }
}