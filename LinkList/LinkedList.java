public class LinkedList{
    public LinkedList(){
        length = 0;
    }

    ListNode head;

    private int length = 0;
    
    // create a new linkedlist
    public void createLinkedList(int ... data){
        for(int i : data){
            if(i == 0){
                insertAtBeginning(new ListNode(i));
            }else{
                insertAtEnd(new ListNode(i));
            }
        }
    }

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
            ListNode current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = node;
            length++;
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
            newNode.next = tmp.next;
            tmp.setNext(newNode);
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
        while((next = x.getNext()) != null){
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

    // Print linked list
    public String linkedListToString(){
        String result = "[";
        if(head == null){
            return result + "]";
        }
        result = result + head.getData();
        ListNode temp = head.getNext();
        while(temp != null){
            result = result + "," + temp.getData();
            temp = temp.getNext();
        }
        return result + "]";
    }
}