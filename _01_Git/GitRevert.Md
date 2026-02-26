## Git Revert

- Purpose: Safe undo for shared branches
- Revert undoes a commit by creating a new commit that reverses its changes.
- History is preserved
- Safe for production / shared branches

Interview one-liner:
- Use git revert to safely undo a commit without rewriting history.

🔹 Simple visual understanding
```
Before revert:

A ── B ── C ── D
          ↑
Bug introduced

After revert:

A ── B ── C ── D ── E
                    ↑
Revert commit (undoes C)

C is preserved
E reverses C
History remains intact and traceable
```



## Git Revert — Rollback production safely
📌 Scenario
A bad commit is already merged into main and deployed to production.

✅ What you do
- git revert <bad-commit-id>
- this create a new commit which is reverse of this bad commit 
   by which the changes are nullify

🎯 Why
Creates a new rollback commit
Safe for shared branches
No history rewrite
Interview line:
- I use revert to safely roll back a production issue without rewriting Git history.