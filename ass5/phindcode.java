class Node {
    private int id;
    private boolean hasToken;

    public Node(int id) {
        this.id = id;
        this.hasToken = false;
    }

    public void receiveToken() {
        this.hasToken = true;
        System.out.println("Node " + id + " received the token.");
    }

    public void passToken(Node nextNode) {
        this.hasToken = false;
        nextNode.receiveToken();
        System.out.println("Node " + id + " passed the token to Node " + nextNode.id + ".");
    }

    public void enterCriticalSection() {
        if (hasToken) {
            System.out.println("Node " + id + " is entering the critical section.");
            // Critical section code here
            System.out.println("Node " + id + " is leaving the critical section.");
        }
    }
}

public class TokenRing {
    public static void main(String[] args) {
        int numberOfNodes = 5;
        Node[] nodes = new Node[numberOfNodes];
        for (int i = 0; i < numberOfNodes; i++) {
            nodes[i] = new Node(i);
        }

        // Initialize the token with the first node
        nodes[0].receiveToken();

        // Simulate token passing
        for (int i = 0; i < numberOfNodes; i++) {
            nodes[i].enterCriticalSection();
            if (i < numberOfNodes - 1) {
                nodes[i].passToken(nodes[i + 1]);
            } else {
                nodes[i].passToken(nodes[0]); // Pass the token back to the first node
            }
        }
    }
}

