

/*
✅ Way 1: Using Arrays.asList() (Java 5+)
List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
⚠️ Important:
Fixed-size list
You cannot add/remove elements

✅ Way 2: Using List.of() (Java 9+ — RECOMMENDED)
List<Integer> list = List.of(1, 2, 3, 4, 5);
✔ Immutable list
✔ Cleaner
✔ Safer

✅ Way 3: Mutable List (Most Common in Real Code)
List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));
✔ Can add / remove elements

* */

public class Arrays_revision_methods
{

}
