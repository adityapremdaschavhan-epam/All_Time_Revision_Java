# Git rebase 
moves your commits on top of another branch, rewriting commit history
to make it look **linear and clean**.

pick -> keep the commit
drop -> to remove commit
reword -> to change of the commit message.
squash -> to merge previous commit into one 
fixup -> 

Instead of creating a merge commit, it:
Reapplies your commits one by one
Creates a straight-line history

🔹 When to use git rebase?
✅ Use git rebase when:
Working on a local feature branch
You want a clean, readable commit history
Before creating a Pull Request (PR)
Syncing your branch with main without merge commits

Example:

git checkout feature
git rebase main
git rebase -i HEAD~1

❌ Never use git rebase when:
The branch is shared with others
The branch is already pushed to remote and used by teammates
Why?
👉 Rebase rewrites history, which can break others’ work.

# 📌 Scenario
You are working on a feature branch.
Meanwhile, main has received multiple commits.

✅ What you do
- git checkout feature
- git rebase main

🎯 Why

Keeps commit history linear
Makes PR easier to review
No extra merge commits

Interview line:
I use rebase to sync my local feature branch with main before raising a PR.