## ==
checks reference of two object

## Equals
Every class in Java already has equals().{Default equals}
Why?
Because it comes from the parent class:
➡ Object

```
class Object {
public boolean equals(Object obj) {
return (this == obj);
}
}
```
😲 Shock?

Default equals() internally uses ==
So by default:
**equals() ❌ does NOT compare data
It compares reference only**

🔍 What Happens Now?
```
System.out.println(s1.equals(s2));
Output:
false
```
Why?
Because default equals() behaves same as ==

🧠 Conclusion So Far
Comparison	What it checks

| Comparison            | What it checks           |
|-----------------------|--------------------------|
| `==`                  | Memory reference         |
| ** Default `equals()` | Memory reference    **** |
| Custom `equals()`     | Logical data (we define) |

## so overiding .equlas method in java for buisness logic

see ->>>> OverridingEqual.java file

```
class Student {
int rollNo;
String name;
    @Override
    public boolean equals(Object obj) {
        if (this == obj) // same reffernce same obj
            return true;

        if (obj == null)  // obj can never be null before comparison
            return false;

        if (this.getClass() != obj.getClass())
            return false;   // student != teacher

        Student other = (Student) obj;  type casting obj to student for check
        return this.rollNo == other.rollNo;
    }
}
```
************************************************************************
## 1️⃣ First, What is hashCode()? (Beginner Meaning)

hashCode() returns an integer number
that represents an object for fast lookup
### Think of it as:
A bucket number
A shortcut
A grouping key
### Java uses this number mainly in:
HashMap
HashSet
Hashtable
👉 Hash-based collections don’t use equals() first
They use hashCode() first.
but if hash collision occur na then it goes to heck for equlas 

# What happens if hashCode() uses different fields than equals()?
equals uses -> id but hascode use name
🔹 What problems does this cause?
🚨 Problem 1: Equal objects go into different buckets
Student s1 = new Student(1, "A");
Student s2 = new Student(1, "B");   // same id → equals() true
equals() → true
hashCode() → different (A vs B)

note -> hashCode() can use MORE fields than equals(), but NEVER fewer or different ones
Valid:
equals → id
hashCode → id + name

👉 HashMap thinks they belong to different buckets
**********************************************************************************
# Real world scenario for hashcode and equals
HashMap

- 🧪 Full Flow Summary (Memorize This)
  When you do add() / get():
  1️⃣ Call hashCode()
  2️⃣ Go to bucket
  3️⃣ If collision → call equals()
  4️⃣ Decide duplicate or not

Concept : Hash Collision

Collision means:
Two different objects land in the same bucket
This is normal and expected.

🧪 Collision Example
Student s1 (rollNo=101) → hashCode=101 → bucket 1
Student s2 (rollNo=111) → hashCode=111 → bucket 1
Bucket 1 now contains:
[s1, s2]

🧠 NOW equals() COMES INTO PLAY
When adding s2, Java says:
“Before adding, let me check if it’s already present”
Java does:
s2.equals(s1)
If true → duplicate ❌ not added
If false → allowed ✅ added

🔥 Important:
equals() is called ONLY inside the same bucket
Never across all objects

🚨 Why the Contract Matters (One Line)
hashCode() decides WHERE to look
equals() decides WHO is equal

*****************************************************************
# some points to rembember
1) Why is using mutable fields in hashCode() dangerous?
Using mutable fields in hashCode() is dangerous because if the field changes after the object is added to a hash-based 
collection, the object’s hash code changes and the collection can no longer find it.
```
Student s = new Student();
s.id = 101;
HashSet<Student> set = new HashSet<>();
set.add(s);
s.id = 202;
```
HashSet looks in bucket 202 (as its hascode is now 202)
Object is still in bucket 101
equals() is never called

