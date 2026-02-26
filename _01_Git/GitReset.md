# Git Rset

Purpose: Undo commits and move HEAD

- Reset moves HEAD to a previous commit and optionally removes staged and
  working changes.
- git reset is used to undo commits by moving HEAD, with different levels
  of change removal.
- Difference between reset types?
- Command Effect
  -  --soft	Undo commit only -> keep stagged files
  -  --mixed	Undo commit + staging files
  -  --hard	Undo everything -> undo commit + stagged + working directory

### git reset — Undo a wrong local commit
📌 Scenario

You accidentally committed:

debug logs
wrong files
incorrect commit message
and haven’t pushed yet.

✅ What you do
- git reset --soft HEAD~1

🎯 Why
Removes the commit
- Keeps changes staged for correction
Interview line:
- I use reset to fix local commits before pushing to remote.