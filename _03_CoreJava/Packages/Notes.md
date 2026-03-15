Package Naming Rules (IMPORTANT for interviews)
Rule	Example
All lowercase	com.company.project
Reverse domain name	com.google.search
No spaces	❌ my package
Meaningful	✅ com.bank.account

- Avoid class name conflicts
- Control access (security)
- Make large projects manageable

## Creating a Package (Syntax)
```
package com.myapp.util;
public class Helper {
}
```
📌 Rule
package statement must be FIRST line
Only one package per class

- java.lang is auto-imported (String, System, etc.)
- Other packages must be imported manually

public    → everywhere
protected → package + child
default   → package only
private   → class only

