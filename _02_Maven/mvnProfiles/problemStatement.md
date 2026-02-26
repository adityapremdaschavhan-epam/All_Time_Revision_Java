# 🎯 Problem Statement (Your Scenario)

You have multiple environments:

dev

test

prod

You want:

Different configuration per environment

Ability to switch environment without changing code

Use Maven profiles to control this

# 🧠 Big Picture (Before Code)

Think of Maven Profiles like modes:

👉 “When I run Maven in DEV mode → use DEV config”
👉 “When I run Maven in PROD mode → use PROD config”

# ✅ What We Will Build (Minimal Setup)

pom.xml

Define 3 Maven profiles: dev, test, prod

Each profile sets an env.name property

Java class

Reads env.name

Prints which environment is running

Command line

Run Maven with different profiles

Observe output