## 🔹 What are Git tags?

**Git tags are labels attached to specific commits** to **mark important points in history**, most commonly **release versions**.

👉 Unlike branches, **tags do not move** once created.

---

## 🔹 Why Git tags are used
- Mark **release versions** (v1.0, v2.1.3, etc.)
- Easily checkout a **specific release**
- Used by CI/CD pipelines for **deployments and rollbacks**

---

## 🔹 Simple demo (commands + output)

### Create a tag
```bash
git tag v1.0.0
```

#🔹 Annotated vs Lightweight tags
Type	Description
Lightweight	Simple pointer to a commit
Annotated	Stores message, author, date (recommended for releases)

Example (annotated tag):
```
git tag -a v1.1.0 -m "Release v1.1.0"
```

🔹 Real production scenario
📌 Scenario

Your application is tested and ready for release.
✅ Typical workflow
```
git checkout main
git tag -a v2.0.0 -m "Production release v2.0.0"
git push origin v2.0.0
```

# 🎯 Benefits:

- CI/CD deploys exact release version

- Easy rollback by redeploying the tag

# 🧠 Interview-ready one-liner

- Git tags are immutable labels used to mark specific commits, usually to identify release versions.