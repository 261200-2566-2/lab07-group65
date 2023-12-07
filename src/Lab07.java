import java.util.*;

interface LabSet<E> {
    boolean add(E e);
    boolean contains(E e);
    boolean remove(E e);
    int size();
    Object[] toArray();
}

class HashMapSet<E> implements LabSet<E> {
    private final Map<E, Object> map;

    public HashMapSet() {
        this.map = new HashMap<>();
    }

    @Override
    public boolean add(E e) {
        if (!contains(e)) {
            map.put(e, new Object());
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(E e) {
        return map.containsKey(e);
    }

    @Override
    public boolean remove(E e) {
        if (contains(e)) {
            map.remove(e);
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Object[] toArray(){
        return map.keySet().toArray();
    }

}

public class Lab07 {
    public static void main(String[] args) {
        LabSet<String> set = new HashMapSet<>();

        // Add elements
        set.add("APPLE");
        set.add("B");
        set.add("C");
        Object[] arr = set.toArray();

        // Print size
        System.out.println("Size: " + set.size()); 

        // Check if an element is present
        System.out.println("Contains APPLE: " + set.contains("APPLE"));
        System.out.println("Contains D: " + set.contains("D")); 

        // Remove an element
        System.out.println("Remove D: " + set.remove("D"));

        // Print size after removal
        System.out.println("Size: " + set.size()); 
        System.out.println("to Array: " +Arrays.toString(arr));
    }
}
