🧱 PHASE 1 — ALL TECHNIQUES TO HANDLE EXCEPTIONS (Complete Coverage)

Your goal here is:
👉 Know every tool Java gives you to handle errors, and when to use which tool.
*******************************************************************************

## 1️⃣ try – catch – finally (Core of Exception Handling)
🔹 Why it exists
To prevent program crash when a runtime problem occurs.
 Basic Structure
```
try {
// risky code
} catch (ExceptionType e) {
// handling code
} finally {
// always executed
}
```
🔹 What type of errors does it handle?
Type	    Examples
Unchecked	ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException
Checked	    IOException, SQLException
--------------------------------------------------------
🔹 Example 1: ArithmeticException (Unchecked)
```
try {
int a = 10 / 0;
} catch (ArithmeticException e) {
System.out.println("Cannot divide by zero");
}
```
🧠 What happened
JVM detected division by zero
Exception thrown
Caught in catch
Program continues safely
--------------------------------------------------------
🔹 Example 2: finally block
```
try {
int x = 10 / 2;
} catch (Exception e) {
System.out.println("Error");
} finally {
System.out.println("Cleanup done");
}
```
✔ finally runs whether exception occurs or not
✔ Used for closing resources (files, DB, connections)
--------------------------------------------------------
🔹 Multiple catch blocks
```
try {
String s = null;
s.length();
} catch (NullPointerException e) {
System.out.println("Null value found");
} catch (Exception e) {
System.out.println("Generic error");
}
```
📌 Rule
➡️ Child exception first, parent later
*******************************************************************

## 2️⃣ throw (Manually throwing an exception)
🔹 Why needed?
To explicitly signal an error based on business logic.
-------------------------------------------------------------------
🔹 Example: Age validation
```
if (age < 18) {
throw new ArithmeticException("Not eligible to vote");
}
```
🧠 Used when:
Input is invalid
Business rule violated
---------------------------------------------------------------------
🔹 throw vs JVM exception
JVM throws	    You throw
Automatically	Manually
Runtime errors	Business logic errors
*********************************************************************

### 3️⃣ throws (Declaring responsibility)
🔹 Why needed?
To pass exception responsibility to the caller.
🔹 Example (Checked Exception)
```
void readFile() throws IOException {
FileReader fr = new FileReader("data.txt");
}
```
🧠 Meaning:
“I am not handling this exception, caller must handle it”

🔹 Handling with throws
```
public static void main(String[] args) throws IOException {
readFile();
}
```
⚠️ Program will still crash if exception occurs — unless caught later.
try{
readFile(); //dangourous operation
}
catch(IOException e){ sout(e);}
___________________________________________________________________
## throw vs throws
| throw                | throws                   |
|----------------------|--------------------------|
| Used inside method   | Used in method signature |
| Throws one exception | Declares multiple        |
| Creates exception    | Delegates handling       |
___________________________________________________________________
## 4️⃣ Throwable (Root of all exceptions)
🔹 Exception hierarchy (Quick recall)
Throwable
├── Error        ❌ (Don't handle)
└── Exception
├── Checked
└── RuntimeException (Unchecked)

⚠️ Should you catch Throwable?
❌ NO (Almost never)
Because it also catches:

OutOfMemoryError
StackOverflowError
These are JVM-level failures
______________________________________________________________________
5️⃣ Custom Exception (Very Important)
🔹 Why custom exception?

Built-in exceptions are technical
Custom exceptions are business-meaningful

🔹 Step 1: Create exception
```
class InvalidAgeException extends Exception {
public InvalidAgeException(String message) {
super(message);
}
}
```
🔹 Step 2: Use it
```
static void validateAge(int age) throws InvalidAgeException {
if (age < 18) {
throw new InvalidAgeException("Age must be >= 18");
}
}
```
🔹 Step 3: Handle it
```
try {
validateAge(15);
} catch (InvalidAgeException e) {
System.out.println(e.getMessage());
}
```
✔ Clear
✔ Readable
✔ Real-world ready
