package utils.collections;

/**
 * TODO: implement java.util.List
 * 
 * @param <E>
 */
public class CircularLinkedList<E> {
    Node<E> head;
    Node<E> last;
    Node<E> current;

    public void append(E newContents) {
        Node<E> newNode = new Node<E>(newContents);

        if(head == null) {
            head = newNode;
            last = newNode;
            current = newNode;
            newNode.setNext(newNode);
        } else {
            last.setNext(newNode);
            newNode.setNext(head);
            last = newNode;
        }
    }

    public void advanceCurrent() {
        current = current.getNext();
    }
    
    public E getCurrentValue() {
        return current.getContents();
    }
    
    private class Node<F> {
        Node<F> next;
        F       contents;

        Node(F contentsIn) {
            contents = contentsIn;
        }

        public void setNext(Node<F> newNext) {
            next = newNext;
        }

        public Node<F> getNext() {
            return next;
        }

        public F getContents() {
            return contents;
        }
    }
}