import java.util.*;

public class first_script_codelity_collection {

    public static void main(String[] args) {

        System.out.println("=========== JAVA COLLECTIONS FULL REVISION ===========");

        /* ==================================================
           1️⃣ LIST INTERFACE
           ================================================== */

        System.out.println("\n--- LIST INTERFACE ---");
        System.out.println("List allows duplicates, maintains insertion order, index-based access");

        /* -------------------------------
           ArrayList
           ------------------------------- */

        ArrayList<Integer> arrayList = new ArrayList<>();

        System.out.println("\nArrayList internally uses a dynamic array");

        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(20);
        arrayList.add(30);

        System.out.println("ArrayList after add(): " + arrayList);
        // [10, 20, 20, 30]

        System.out.println("Element at index 1: " + arrayList.get(1));
        // 20

        arrayList.remove(0);
        System.out.println("After remove(0): " + arrayList);
        // [20, 20, 30]

        System.out.println("Contains 20? " + arrayList.contains(20));
        // true

        System.out.println("Size of ArrayList: " + arrayList.size());

        /*
         Internal:
         - Default capacity = 10
         - Grows by 50% when full
         - Random access is O(1)
         - Insert/delete in middle is costly (shift elements)
        */

        /* -------------------------------
           LinkedList
           ------------------------------- */

        System.out.println("\nLinkedList internally uses Doubly Linked List");

        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("A");
        linkedList.add("B");
        linkedList.addFirst("Start");
        linkedList.addLast("End");

        System.out.println("LinkedList elements: " + linkedList);
        // [Start, A, B, End]

        linkedList.removeFirst();
        linkedList.removeLast();

        System.out.println("After removals: " + linkedList);
        // [A, B]

        /*
         Internal:
         - Each node has prev & next reference
         - Access O(n)
         - Insert/delete O(1)
        */

        /* ==================================================
           2️⃣ STACK (LEGACY BUT IMPORTANT)
           ================================================== */

        System.out.println("\n--- STACK ---");
        System.out.println("Stack follows LIFO (Last In First Out)");

        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack after push(): " + stack);
        // [10, 20, 30]

        System.out.println("peek(): " + stack.peek());
        // 30

        System.out.println("pop(): " + stack.pop());
        // 30

        System.out.println("Stack after pop(): " + stack);
        // [10, 20]

        System.out.println("isEmpty(): " + stack.isEmpty());
        System.out.println("search(10): " + stack.search(10));  // output :- 2
        // Position from top (1-based)

        /*
         Internal:
         - Stack extends Vector
         - Thread-safe but slower
         - ArrayDeque is preferred in real projects
        */

        /* ==================================================
           3️⃣ SET INTERFACE (IN DEPTH)
           ================================================== */

        System.out.println("\n--- SET INTERFACE ---");
        System.out.println("Set does NOT allow duplicates");

        /* -------------------------------
           HashSet
           ------------------------------- */

        HashSet<Integer> hashSet = new HashSet<>();

        hashSet.add(10);
        hashSet.add(20);
        hashSet.add(10);
        hashSet.add(30);
        hashSet.add(20);

        System.out.println("HashSet elements: " + hashSet);

        System.out.println("remove(20): " + hashSet.remove(20));
        System.out.println("After removal: " + hashSet);

        /*
         Internal:
         - Uses HashMap internally
         - Value stored as dummy object -> // Dummy value to associate with an Object in the backing Map
            static final Object PRESENT = new Object();
         - No order guaranteed
         - add() -> hashCode() -> equals()
        */

        /* -------------------------------
           LinkedHashSet
           ------------------------------- */

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add(10);
        linkedHashSet.add(20);
        linkedHashSet.add(30);

        System.out.println("\nLinkedHashSet maintains insertion order");
        System.out.println("Elements: " + linkedHashSet);

        /*
         Internal:
         - HashSet + Doubly Linked List
         - Slightly slower than HashSet
        */

        /* -------------------------------
           TreeSet
           ------------------------------- */

        TreeSet<Integer> treeSet = new TreeSet<>();

        treeSet.add(30);
        treeSet.add(10);
        treeSet.add(20);

        System.out.println("\nTreeSet sorted elements: " + treeSet);

        System.out.println("first(): " + treeSet.first());
        System.out.println("last(): " + treeSet.last());
        System.out.println("higher(10): " + treeSet.higher(10));
        System.out.println("lower(20): " + treeSet.lower(20));

        /*
         Internal:
         - Uses Red-Black Tree
         - Elements are sorted
         - Operations O(log n)
        */

        /* ==================================================
           4️⃣ MAP INTERFACE (IN DEPTH)
           ================================================== */

        System.out.println("\n--- MAP INTERFACE ---");
        System.out.println("Map stores key-value pairs");

        /* -------------------------------
           HashMap
           ------------------------------- */

        HashMap<Integer, String> hashMap = new HashMap<>();

        hashMap.put(1, "A");
        hashMap.put(2, "B");
        hashMap.put(1, "C");

        System.out.println("HashMap elements: " + hashMap);
        System.out.println("get(2): " + hashMap.get(2));
        System.out.println("containsKey(1): " + hashMap.containsKey(1));
        System.out.println("containsValue(A): " + hashMap.containsValue("A"));

        // count frequency
        String s = "abcba";
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char ch : s.toCharArray()){
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }
        System.out.println(hm);

        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        hashMap.entrySet().stream().forEach(System.out::println);

        /*
        Expected Output:
        Iterating HashMap using entrySet():
        Key = 1, Value = C
        Key = 2, Value = B
        */

        /*
         Internal:
         - Uses array of buckets
         - Default capacity = 16
         - Load factor = 0.75
         - Collision handled using LinkedList / Tree (Java 8+)
        */

        /* -------------------------------
           LinkedHashMap
           ------------------------------- */

        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put(1, "A");
        linkedHashMap.put(2, "B");

        System.out.println("\nLinkedHashMap maintains insertion order");
        System.out.println(linkedHashMap);

        /* -------------------------------
           TreeMap
           ------------------------------- */

        TreeMap<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(3, "C");
        treeMap.put(1, "A");
        treeMap.put(2, "B");

        System.out.println("\nTreeMap sorted by key");
        System.out.println(treeMap);

        /* ==================================================
           5️⃣ ITERATING COLLECTIONS & MAPS
           ================================================== */

        System.out.println("\n--- ITERATION TECHNIQUES ---");

        System.out.println("\nIterating List using Iterator");
        Iterator<Integer> listIterator = arrayList.iterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        System.out.println("\nIterating Set using for-each");
        for (Integer i : treeSet) {
            System.out.println(i);
        }

        System.out.println("\nIterating Map using entrySet()");
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nIterating Map using keySet()");
        for (Integer key : hashMap.keySet()) {
            System.out.println(key + " -> " + hashMap.get(key));
        }

        System.out.println("\nIterating Map using values()");
        for (String value : hashMap.values()) {
            System.out.println(value);
        }

        System.out.println("\n=========== END OF REVISION ===========");
    }
}