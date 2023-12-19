import java.util.*;

// Initializing each type & method
interface LabSet<E> {
    boolean add(E e);
    boolean contains(E e);
    boolean remove(E e);
    int size();
    boolean containsAll(Collection<?> c);
    boolean addAll(Collection<? extends E> c);
    boolean removeAll(Collection<?> c);
    boolean retainAll(Collection<?> c);
    void clear();
    boolean isEmpty();
    Iterator<E>  iterator(); 
}

class HashMapSet<E> implements LabSet<E> {
    private final Map<E, Object> map;

    public HashMapSet() {
        this.map = new HashMap<>();
    }

    // Adds the specified element to this set if it is not already present
    @Override
    public boolean add(E e) {
        if (!contains(e)) {
            map.put(e, new Object());
            return true;
        }
        return false;
    }

    // Returns true if this set contains the specified element
    @Override
    public boolean contains(E e) {
        return map.containsKey(e);
    }

    // Removes the specified element from this set if it is present
    @Override
    public boolean remove(E e) {
        if (contains(e)) {
            map.remove(e);
            return true;
        }
        return false;
    }

    // Returns the number of elements in this set
    @Override
    public int size() {
        return map.size();
    }

    // New methods
    @Override
    public boolean containsAll(Collection<?> c) {
        return map.keySet().containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E element : c) {
            modified |= add(element);
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return map.keySet().removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return map.keySet().retainAll(c);
    }

    @Override
    public void clear(){
        map.clear();
    }
    @Override
    public boolean isEmpty(){
        return map.isEmpty();
    }
    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }
}

public class Lab07 {
    public static void main(String[] args) {
        LabSet<String> set = new HashMapSet<>();

        // Add elements
        set.add("APPLE");
        set.add("APPLE");
        set.add("TON");

        // Print size
        System.out.println("Size: " + set.size());

        System.out.print("Iterator: ");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        set.clear();
        // Check if an element is present
        System.out.println("\nContains Tiger: " + set.contains("Tiger"));

        // Remove an element
        System.out.println("Remove TON: " + set.remove("TON"));

        // Print size after removal
        System.out.println("Size: " + set.size());

        // New collection
        List<String> arr = Arrays.asList("APPLE", "ORANGE", "BANANA");

        System.out.print("Iterator: ");
        Iterator<String> iterator2 = arr.iterator();
        while (iterator2.hasNext()) {
            System.out.print(iterator2.next() + " ");
        }

        // Check containsAll
        System.out.println("\nContainsAll arr: " + set.containsAll(arr));

        // AddAll
        System.out.println("AddAll arr: " + set.addAll(arr));

        // Print size after AddAll
        System.out.println("Size: " + set.size());

        // RetainAll
        System.out.println("RetainAll arr: " + set.retainAll(Arrays.asList("APPLE")));

        // Print size after RetainAll
        System.out.println("Size: " + set.size());

        // RemoveAll
        System.out.println("RemoveAll arr: " + set.removeAll(arr));

        System.out.println("Is Empty: " + set.isEmpty());
    }
}
