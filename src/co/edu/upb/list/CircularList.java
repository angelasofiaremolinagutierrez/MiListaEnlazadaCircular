package co.edu.upb.list;

import java.util.Arrays;
import java.util.Iterator;

public class CircularList implements CircularListInterface, Iterable<CircularListNode> {
    public CircularListNode head;
    public CircularListNode tail;

    int size = 0;
    private CircularListNode inode;

    public CircularList() {
        this.head = null;
        this.head = null;
    }

    public CircularList(Object object){
        insertTail(object);
    }

    @Override
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public Object getHead() {
        return head;
    }

    @Override
    public Object getTail() {
        return tail;
    }

    @Override
    public Object get(CircularListNode node) {
        return node.getObject();
    }

    @Override
    public CircularListNode search(Object object) {
        CircularListNode n = head;
        for (int i = 0; i < size; i++) {
            if(n.getObject().equals(object)){
                return n;
            }else{
                n = n.next;
            }
        }
        return null;
    }

    @Override
    public boolean add(Object object) {
        return insertTail(object);
    }

    @Override
    public boolean insert(CircularListNode nodoAtras, Object object) {
        if(nodoAtras.isEquals(this.tail)){
            return insertTail(object);
        }else if(nodoAtras.isEquals(this.head)){
            return insertHead(object);
        }else{

            CircularListNode nuevoNodo = new CircularListNode(object);
            nuevoNodo.next = nodoAtras.next; // el nuevo agarra al siguiente
            nodoAtras.next = nuevoNodo; //el de atrás agarra al nuevo y suelta al siguiente

            size += 1;
            return true;
        }
    }

    @Override
    public boolean insert(Object object, Object objectRef) {
        CircularListNode nuevoNodo = new CircularListNode(object);
        CircularListNode nodoRef = this.search(objectRef);

        nuevoNodo.next = nodoRef.next;// el nuevo agarra al siguiente
        nodoRef.next = nuevoNodo; //el de atrás agarra al nuevo y suelta al siguiente

        size += 1;
        return true;
    }

    @Override
    public boolean insertHead(Object object) {
        CircularListNode nuevo = new CircularListNode(object);
        if(isEmpty()){
            head = nuevo;
            tail = head;
        }else{
            nuevo.next = head;
            head = nuevo;
            tail.next = head; // cerrar el ciclo nuevamente
        }
        size += 1;
        return true;
    }

    @Override
    public boolean insertTail(Object object) {
        CircularListNode nuevo = new CircularListNode(object);
        if(isEmpty()){
            head = nuevo;
            tail = head;
        }else{
            tail.next = nuevo;
            tail = nuevo;
            tail.next = head; //cerrar el ciclo nuevamente
        }
        size += 1;
        return true;
    }

    @Override
    public boolean set(CircularListNode node, Object object) {
        node.setObject(object);
        return true;
    }

    @Override
    public boolean remove(CircularListNode node) {
        CircularListNode anterior = tail;
        CircularListNode n = head;
        CircularListNode siguiente = n.next;

        for (int i = 0; i < size; i++) {
            if(n.isEquals(node)){
                anterior.next = siguiente;
                n = null;
                size -= 1;
                return true;
            }else{
                anterior = anterior.next;
                n = n.next;
                siguiente = siguiente.next;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Object object) {
        CircularListNode node = this.head;
        for (int i = 0; i < size; i++) {
            if(node.getObject().equals(object)){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public Iterator<CircularListNode> iterator() {
        /*
        DoubleListNode inode = head;
        Iterator<DoubleListNode> i = new Iterator<DoubleListNode>() {
            @Override
            public boolean hasNext() {
                return inode.next ;
            }

            @Override
            public DoubleListNode next() {
                if (hasNext()) {
                    DoubleListNode tmp = inode;
                    inode = inode.next;
                    return tmp;
                } else {
                    return null;
                }
            }
        };
        return i;*/
        return null; //todo preguntar por qué no funciona
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        this.toArray(array);
        return array;
    }

    @Override
    public Object[] toArray(Object[] array) {
        if(array.length == this.size){
            CircularListNode node = this.head;
            for (int i = 1; i <size; i++){
                array[i] = node.getObject();
                node = node.next;
            }
            return array;
        }else{
            System.out.println("El array en el que se quiere insertar la lista no es del mismo tamaño que la lista");
            return null;
        }
    }

    //algunos de los metodos getNextTo y getBeforeTo fueron trasladados a la clase DoubleListNode

    @Override
    public Object getBeforeTo(CircularListNode node) {
        CircularListNode anterior = tail;
        CircularListNode n = head;
        for (int i = 0; i < size; i++) {
            if (node.isEquals(n)){
                return anterior;
            }else{
                anterior = anterior.next;
                n = n.next;
            }
        }
        return null;
    }

    @Override
    public Object getNextTo(CircularListNode node) {
        return node.getNextTo();
    }

    @Override
    public CircularList subList(CircularListNode from, CircularListNode to) {
        CircularList subList = new CircularList();
        CircularListNode n = this.head;
        for (int i = 0; i < size; i++){
            if(n.isEquals(from)){
                subList.add(n.getObject());
                n = n.next;
                for (int j = 0; j < size; j++){
                    subList.add(n.getObject());
                    if(n.isEquals(to)){
                        return subList;
                    }else{
                        n = n.next;
                    }
                }
                break; // retorne nulo porque no se encontró el nodo 'to'
            }else{
                n=n.next;
            }
        }
        return null;
    }

    @Override
    public CircularList sortList() {
        Object[] listaAOrdenar = this.toArray();
        Arrays.sort(listaAOrdenar);

        CircularList listaOrdenada = new CircularList();
        for (Object n:listaAOrdenar) {
            listaOrdenada.add(n);
        }

        this.head = listaOrdenada.head;
        this.tail = listaOrdenada.tail;
        return this;
    }

    @Override
    public String toString() {
        String list_str = "";
        CircularListNode n = head;
        for (int i = 0; i < size; i++) {
            list_str += n.toString();
            list_str += ",\n";
            n = n.next;
        }
        return list_str;
    }

    public CircularListNode getInode() {
        return inode;
    }

    public void setInode(CircularListNode inode) {
        this.inode = inode;
    }
}
