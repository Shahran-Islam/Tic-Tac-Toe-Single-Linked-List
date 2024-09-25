public class LinkedList {

    private Node head;

    public LinkedList() {
        this.head = null;
        createBoard();
    }

    public void createBoard() {
        Node previous = null;
        for (int i = 1; i <= 9; i++) {
            Node newNode = new Node(i);
            if (head == null) {
                head = newNode;
            } else {
                previous.next = newNode;
            }
            previous = newNode;
        }
    }

    public void insertAtEnd(String data) {
        Node newNode = new Node(-1);
        newNode.data = data;

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void updatePosition(int position, String data) {
        Node current = head;
        while (current != null) {
            if (current.position == position) {
                if (current.data.equals(" ")) {
                    current.data = data;
                }
                return;
            }
            current = current.next;
        }
    }

    public String getPositionValue(int position) {
        Node current = head;
        while (current != null) {
            if (current.position == position) {
                return current.data;
            }
            current = current.next;
        }
        return "";
    }

    public void displayBoard() {
        Node current = head;
        int count = 0;
        System.out.println("\n-------------");
        while (current != null) {
            System.out.print("| " + current.data + " ");
            count++;
            if (count % 3 == 0) {
                System.out.println("|\n-------------");
            }
            current = current.next;
        }
    }

    public boolean checkWinCondition() {
        return (checkCombination(1, 2, 3) ||
                checkCombination(4, 5, 6) ||
                checkCombination(7, 8, 9) ||
                checkCombination(1, 4, 7) ||
                checkCombination(2, 5, 8) ||
                checkCombination(3, 6, 9) ||
                checkCombination(1, 5, 9) ||
                checkCombination(3, 5, 7));
    }

    private boolean checkCombination(int pos1, int pos2, int pos3) {
        String value1 = getPositionValue(pos1);
        String value2 = getPositionValue(pos2);
        String value3 = getPositionValue(pos3);

        return (!value1.equals(" ") && value1.equals(value2) && value2.equals(value3));
    }

    public boolean isBoardFull() {
        Node current = head;
        while (current != null) {
            if (current.data.equals(" ")) {
                return false;
            }
            current = current.next;
        }
        return true;
    }

    public void resetBoard() {
        Node current = head;
        while (current != null) {
            current.data = " ";
            current = current.next;
        }
    }
}
