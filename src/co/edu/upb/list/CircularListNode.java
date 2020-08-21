package co.edu.upb.list;

public class CircularListNode implements Comparable<CircularListNode> {

    private Object object;
    public CircularListNode next;

    public CircularListNode() {
        this.object = null;
        this.next = null;
    }
    public CircularListNode(Object object) {
        this.object = object;
        this.next = null;
    }

    public boolean isEquals(CircularListNode nodo){ //si un nodo es igual a otro
        if(this.toString().equals(nodo.toString())){
            return true;
        }else{
            return false;
        }
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Nodo que tiene: " + "object=" + object;
    }

    public Object getNextTo() {
        CircularListNode sig = this.next;
        return sig.getObject();
    }

    @Override
    public int compareTo(CircularListNode n) {
        return (this.getObject().toString()).compareTo(n.getObject().toString());
    }
}
