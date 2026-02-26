## What is git rebase?

*********************************************************************
##  Git reset

*********************************************************************
## git revert

*Difference*
- One-Glance Interview Comparison
 - Command	What it does	        History	        Shared Branch
 - rebase	Rewrites commit order	❌ Rewritten	❌ No
 - reset	Removes commits	        ❌ Rewritten	❌ No
 - revert	Reverses commit	        ✅ Preserved	✅ Yes
*****************************************************************
## What is origin?
- Default name for remote repository.
*****************************************************************
## What is .gitignore?
Prevents tracking unnecessary files like logs, builds.

## Why .gitignore not working?
Because file is already tracked.
```
git rm --cached file
```
************************************************************
## git bisect
to find bug
it uses binary search
goodcomit , badcommit.

***********************************************************
##
