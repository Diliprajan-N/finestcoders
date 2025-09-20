class reverselinkedlistday2{
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }

    }
    static Node head;
    static void add(int data){
        Node newNode =new Node(data);
        if(head==null){
            head=newNode;
            return;
        }else{
            Node curr=head;
            while(curr.next!=null){
                curr=curr.next;
            }curr.next=newNode;

        }
    }
  static Node reverseKGroup(Node head, int k) {
        if (head == null || k <= 1) return head;

        Node newHead = null, prevGroupEnd = null, curr = head;

        while (curr != null) {
            Node groupStart = curr;
            Node kth = getKthNode(curr, k - 1);
            if (kth == null) {
                if (prevGroupEnd != null) prevGroupEnd.next = groupStart;
                break;
            }

            Node nextGroup = kth.next;

    
            Node prev = nextGroup;
            while (curr != nextGroup) {
                Node temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            if (newHead == null) newHead = kth; 
            if (prevGroupEnd != null) prevGroupEnd.next = kth;
            prevGroupEnd = groupStart;
        }

        return newHead != null ? newHead : head;
    }

    static Node getKthNode(Node start, int k) {
        while (k-- > 0 && start != null) start = start.next;
        return start;
    }

    static void printList(Node head) {
        for (; head != null; head = head.next)
            System.out.print(head.data + " -> ");
        System.out.println("null");
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 6; i++) add(i);

        int k = 2;
        Node newHead = reverseKGroup(head, k);
        printList(newHead);
    }
}
