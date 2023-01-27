public class ScottList<E> {

    /* --------------------------- LOCAL CLASS  -----------------------------*/
    private class Node<E>{
        E data;
        Node<E> next;

        public Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }
    }

    /* --------------------------- INSTANCE VARIABLES  -----------------------------*/
    private Node<E> head;

    /* --------------------------- CONSTRUCTOR  -----------------------------*/
    public ScottList(){
        this.head = null;
    }

    /* --------------------------- METHODS  -----------------------------*/
    public void addToFront(E newData){
        this.head = new Node<E>(newData, head);

    }

    public boolean isEmpty() {
        return (head == null); //the list is empty if head is null
    }

    //NOTE:Both of these work with THIS and without THIs.

    public E removeFromFront(){
        if (isEmpty()){
            return null;
        }
        Node<E> frontItemToRemove = this.head;
        //System.out.println(frontItemToRemove.data.toString());
        this.head = frontItemToRemove.next;
        return frontItemToRemove.data;
    }

    public E removeFromFrontNoThis(){
        if (isEmpty()){
            return null;
        }
        E removedData = head.data;
        head = head.next;
        return removedData;
    }

    public E removeFromBack(){
        E removedData;
        Node<E> previous = head;
        Node<E> nextNode = previous.next;

        if (isEmpty()){
            return null;
        } else if (nextNode == null){
            removedData = previous.data;
            this.head = null;
        } else {
            while (nextNode.next != null){
                previous = nextNode;
                nextNode = previous.next;
            }
            previous.next = null;
            removedData = nextNode.data;

        }
        return removedData;
    }

    public String toString(){
        Node<E> current = head;
        String result = "";

        while (current != null) {
            result = result + current.data.toString() + "\n";
            current = current.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ScottList<String> dogNames = new ScottList();
        dogNames.addToFront("Gatsby");
        dogNames.addToFront("Murphy");
        dogNames.addToFront("Doug");
        dogNames.addToFront("Mav");
        dogNames.addToFront("Darby");
//        System.out.println(dogNames.toString());
//        dogNames.removeFromFront();
        //System.out.println(dogNames.removeFromFront().toString());
//        System.out.println(dogNames.toString());
        //System.out.println(dogNames.removeFromBack());
//        dogNames.removeFromBack();
//        dogNames.removeFromFront();
//        dogNames.removeFromFrontNoThis();
//        System.out.println(dogNames.toString());
        dogNames.removeFromBack();
        System.out.println(dogNames);

    }
}
