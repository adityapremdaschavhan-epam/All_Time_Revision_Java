# Java Exception Types (Complete List)

---

## 1️⃣ Exception Hierarchy (Quick Recall)


Throwable
├── Error
└── Exception
├── Checked Exceptions
└── RuntimeException (Unchecked)

---

## 2️⃣ Error Types (❌ Not Meant to Be Handled)

Errors indicate **JVM-level problems**.

### Common `Error` Subclasses
- OutOfMemoryError
- StackOverflowError
- VirtualMachineError
- NoClassDefFoundError
- AssertionError
- InternalError
- LinkageError

📌 **Rule:** Do **NOT** catch or handle these in normal applications.

---

## 3️⃣ Checked Exceptions (Compile-Time)

✔ Checked at **compile time**  
✔ Must be handled using `try-catch` or `throws`

### Common Checked Exceptions
- IOException
    - FileNotFoundException
    - EOFException
- SQLException
- ClassNotFoundException
- InterruptedException
- ParseException
- MalformedURLException
- CloneNotSupportedException
- InstantiationException
- IllegalAccessException
- ReflectiveOperationException

📌 **Used when:** external resources (file, database, network, I/O)

---

## 4️⃣ Unchecked Exceptions (RuntimeException)

✔ Occur at **runtime**  
✔ Usually caused by **programming mistakes**

### 🔹 Language / Logic Errors
- NullPointerException
- ArithmeticException
- ArrayIndexOutOfBoundsException
- StringIndexOutOfBoundsException
- IndexOutOfBoundsException
- ClassCastException
- IllegalArgumentException
- IllegalStateException
- NumberFormatException

### 🔹 Collections & Concurrency
- ConcurrentModificationException
- NoSuchElementException
- UnsupportedOperationException

### 🔹 Input / Validation
- InputMismatchException
- MissingResourceException

---

## 5️⃣ IOException Sub-Hierarchy (Very Important)

IOException
├── FileNotFoundException
├── EOFException
├── SocketException
├── SocketTimeoutException
└── UnknownHostException

---

## 6️⃣ SQLException Sub-Hierarchy


SQLException
├── SQLTimeoutException
├── SQLSyntaxErrorException
├── SQLIntegrityConstraintViolationException
└── SQLTransientException


---

## 7️⃣ Security Exceptions

- SecurityException
- AccessControlException

---

## 8️⃣ Reflection-Related Exceptions

- ClassNotFoundException (Checked)
- NoSuchMethodException
- NoSuchFieldException
- InvocationTargetException
- InstantiationException
- IllegalAccessException

---

## 9️⃣ Custom Exceptions (User-Defined)

### ✅ Checked Custom Exception
```java
class InvalidAgeException extends Exception {
    public InvalidAgeException(String msg) {
        super(msg);
    }
}
❌ Unchecked Custom Exception
class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String msg) {
        super(msg);
    }
}

🔟 Most Asked in Interviews (🔥 MUST REMEMBER)
Top 10 Exceptions

NullPointerException
ArithmeticException
ArrayIndexOutOfBoundsException
ClassCastException
IllegalArgumentException
NumberFormatException
IOException
SQLException
ClassNotFoundException
FileNotFoundException

🧠 One-Page Memory Trick

Checked → External world problems
Unchecked → Developer mistakes
Error → JVM problems

---

If you want next, I can:
- Add **real-life examples for each exception**
- Create a **printable one-page PDF**
- Add **interview Q&A below each section**

Just tell me 👍