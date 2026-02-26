## What is git stash?
- git stash temporarily saves your uncommitted changes (modified + staged files) 
and cleans your working directory, so you can switch branches safely without committing half-done work.

👉 Think of it as a clipboard for code.
🔹 Basic demo (commands + what you see)

📌 Situation
- You edited files but haven’t committed:

```bash
$ git status
On branch feature
Changes not staged for commit:
modified: service.java
modified: config.yml
```
1️⃣ Stash the changes
- git stash

Output:
```
Saved working directory and index state WIP on feature: a1b2c3d Initial commit
```
Now your working directory is clean:
```
$ git status
On branch feature
nothing to commit, working tree clean
```
2️⃣ Switch branch safely
```
git checkout main
```

✅ No conflicts, no forced commit.

3️⃣ Bring changes back
```
git stash pop 
```

Output:
```bash
Applied stash@{0}
Dropped stash@{0}
```
Your changes are restored.

# Useful stash commands (quick recall)
- git stash list        # see all stashes
- git stash apply       # apply stash (keeps it)
- git stash pop         # apply + remove stash
- git stash drop        # delete a stash
- git stash clear       # delete all stashes

🔹 Real production scenario
- 📌 Scenario
- You’re working on a feature, halfway done.
- Suddenly, a production bug needs urgent fixing on main.

✅ What you do
```
git stash
git checkout main
```

- Fix bug
- Commit & push hotfix

Then:
```
git checkout feature
git stash pop
```

🎯 Your unfinished feature work continues exactly where you left off.
# 🧠 Interview-ready one-liner
- git stash temporarily stores uncommitted changes so developers can switch branches safely without committing incomplete work.