## 1️⃣ Maven Basics & Architecture

What is Maven?
- Maven is a build automation and dependency management tool(pom.xml) used 
primarily for Java projects to standardize project structure(by using a standard 
lifecycle) and centralized dependency management.

### Why Maven over Ant/Gradle?
- Ant – “Do everything manually”
    - Ant is procedural
    - You define how to do everything
- Maven – “Convention over Configuration”
  - Maven is declarative
- Gradle – “Flexible but complex”
  - Powerful and faster
  - Uses Groovy/Kotlin DSL
  - Steeper learning curve
  - Less standardized across teams

#### when not to use maven
- If build speed is critical → Gradle
- If project needs heavy customization → Gradle
- Android projects → Gradle

### Maven project structure
- standardized directory layout
    - separates source code, test code, resources, and build output
    - ensuring consistency and maintainability across projects.
      project-root
      │
      ├── pom.xml
      │
      ├── src
      │   ├── main
      │   │   ├── java
      │   │   │   └── com/company/project
      │   │   └── resources
      │   │       └── application.properties
      │   │
      │   └── test
      │       ├── java
      │       │   └── com/company/project
      │       └── resources
      │
      └── target
      ├── classes
      ├── test-classes
      └── project-name.jar
### **Scenario** Spring Boot Microservice
src/main/java → REST controllers, services
src/main/resources → application.yml
src/test/java → JUnit / TestNG tests
target/ → JAR deployed to server
👉 New developer joins → no confusion → faster onboarding.

### POM.xml (heart of Maven)
- POM.xml (Project Object Model) is the central configuration file
- defines project metadata, dependencies, build lifecycle, plugins, and environment-specific configurations.
- Because it controls:
- Project identity
  Dependency management
  Build lifecycle behavior
  Plugin executions
  Profiles and environment

<project>
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.company.app</groupId>          --> Organization or domain
    <artifactId>order-service</artifactId>      --> Project/module name
    <version>1.0.0</version>                    -->Release identifier
    <packaging>jar</packaging>

    <dependencies>.dependency..</dependencies>  --> Defines libraries required by the project.
    <build>.plugin..</build>                    --> Controls plugins and build behavior.Plugins-->Defines tools like 
                                                    compiler, test runners.
    <profiles>.profile..</profiles>             --> Environment-specific configurations.
</project>

### Real-Time Industry Scenario
Spring Boot Microservice
Dependencies: Spring Web, JPA, MySQL
Plugins: Compiler, Surefire
Environments: dev, test, prod

### Maven coordinates (GAV)
- Enterprise Repository (Nexus)
- Multiple teams
- Hundreds of artifacts
- Same artifact name possible
- 👉 GAV ensures no collision and correct dependency resolution.Uniquely identify artifacts across repositories and ensure
      correct dependency resolution.

## What happens if two dependencies have same artifactId but different groupId?
- Maven treats them as completely different artifacts because groupId differentiates ownership.

## 📍 Foundation topic
### 🔹 2️⃣ Maven Build Lifecycles (VERY IMPORTANT)

## 1️⃣ What is a Maven Lifecycle?
📌 Definition (Opening Line)
A Maven lifecycle is a predefined sequence of phases that define the order in which a project is built, tested, packaged,
and deployed.

Interview one-liner:
Lifecycle defines the flow, plugins define the execution.

## 2️⃣ Why Maven Uses Lifecycles (Concept)
Maven uses lifecycles to:
Standardize build process
Avoid custom build scripts
Ensure predictable builds
Integrate easily with CI/CD
👉 Every Maven project follows the same lifecycle, which is why builds are consistent.

## 3️⃣ Types of Maven Lifecycles
Maven has 3 built-in lifecycles:
Lifecycle	Purpose
Default	    Build, test, package
Clean	    Cleanup before build
Site	    Documentation generation

## 2️⃣ Default Lifecycle (MOST IMPORTANT)
📌 Purpose
Handles compiling, testing, packaging, and installing the application.

🔑 Important Phases (Interview Focus)
Phase	    What Happens
validate	Project structure is validated
compile	    Source code is compiled
test	    Unit tests executed
package	    JAR/WAR created
verify	    Quality checks
install	    Artifact installed to local repo
deploy	    Artifact deployed to remote repo

## 5️⃣ Clean Lifecycle
📌 Purpose
Removes previous build artifacts.

Phase	    Action
pre-clean	Pre cleanup
clean	    Deletes target/
post-clean	Post cleanup

👉 Ensures fresh build.

## 6️⃣ Site Lifecycle
📌 Purpose
Generates project documentation and reports.
Phase	        Action
pre-site        preparation before genration site(documentation) prepare metadata
site	        Generates site 
post-site
site-deploy	    Publishes documentation
👉 Mostly used in large enterprises.

## 7️⃣ Phases vs Goals (INTERVIEW FAVORITE)
### 🔹 Phase
A step in lifecycle
Ordered
Example: compile, test
### 🔹 Goal
A specific task executed by a plugin
Bound to phases
Example: compiler:compile

### 🎯 Key Line for Interview:
Phases define WHEN, goals define WHAT.
Phases vs Goals
mvn clean install – what actually happens internally? 
- all the claen phases + previous phases to install are going to execute 

📍 Interview favorite

# 3️⃣ Maven Dependencies (MOST ASKED)

## Dependency management
1️⃣ What is Dependency Management?
📌 Definition (Strong Opening)
Dependency management in Maven is the mechanism used to declare, download, manage, and control external libraries 
dependency is lieke importing external library
required by a project.
Interview one-liner:
You declare the dependency, Maven manages the rest.

## 2️⃣ Real-Time Scenario (Why Dependencies Exist)
🏢 Spring Boot Application
Needs:
Spring Web
Hibernate
MySQL Driver
👉 Instead of downloading JARs manually:
```
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
  <version>3.2.1</version>
</dependency>
```
### Maven:
Downloads JAR
Downloads dependent JARs
**Stores in .m2**
Adds to classpath

## Dependency scopes: Dependency scope defines WHEN and WHERE a dependency is available.

snapshot:-

### 1) compile :- available everywhere
Explanation:-Available in compile, test, and runtime.
Scenario:-Spring Core required everywhere.
<scope>compile</scope>
📌 If scope is not specified → compile

### 2) provided
Explanation:-Available at compile time,( but NOT packaged.)
Scenario (INTERVIEW FAVORITE):-
->Servlet API in a web application. 
* we need this for starting our project (only for compile and test)
* but Tomcat(server) already provides it -> Including it again causes conflict
* therefore it should not be includeed it into packaged
<scope>provided</scope>

### 3) runtime
Explanation:
   - Not needed at compile time, required only at runtime.
Scenario:
Database drivers (MySQL).
   - Code uses interfaces
   - Driver required only during execution

<scope>runtime</scope>

### 4) test
Explanation:
   Available only during testing.
Scenario:
JUnit, TestNG.
<scope>test</scope>
👉 Will NOT go to production JAR.

### 5) system
Explanation:
   Dependency provided via local system path.
Scenario:
we have created some project and cvreate it jar -> custom.jar
Legacy JAR not in repository.
<scope>system</scope>
<systemPath>/libs/custom.jar</systemPath>
❌ Not portable
❌ Avoid in real projects

### Transitive dependencies
Transitive Dependencies (INTERVIEW GOLD)
📌 Definition
Transitive dependency is a dependency of your dependency.
🔹 Example Scenario
You add:

**spring-boot-starter-web**

It automatically brings:
1. Spring Core
2. Spring MVC
3. Jackson
4. Tomcat
👉 You did NOT declare them explicitly.

### Dependency conflict & resolution
📌 What is Dependency Conflict?
Occurs when:
Two dependencies bring different versions of the same library.

🔹 Real-Time Scenario
A → depends on log4j:1.2
B → depends on log4j:2.0
👉 Maven chooses only one.

 Dependency Resolution Strategy (IMPORTANT)
Maven uses:
**👉 Nearest Definition Wins**
Dependency closest to project in dependency tree is chosen.

🔹 How to Fix Conflicts
```
1️⃣ Explicit version declaration
<dependency>
<groupId>log4j</groupId>
<artifactId>log4j</artifactId>
<version>2.0</version>
</dependency>
2️⃣ Exclusion
<exclusions>
<exclusion>
<groupId>log4j</groupId>
<artifactId>log4j</artifactId>
</exclusion>
</exclusions>
```

## dependency:tree

**mvn dependency:tree** (VERY IMPORTANT COMMAND)

📌 Purpose
Shows:
All dependencies
Transitive dependencies
Conflicts and versions
mvn dependency:tree
🔹 Interview Scenario
Build failing due to version conflict
👉 Run dependency:tree
👉 Identify conflicting library
👉 Fix via exclusion or version override

📍 Real-time heavy

## 🔹 4️⃣ Maven Repositories

## Local repository
The local repository is a folder on your system where Maven stores downloaded dependencies.
📍 Default location:
~/.m2/repository
#### 🔹 What is Stored in .m2?
Downloaded dependencies
Plugins
Project artifacts built locally (mvn install)
Metadata

## Central repository
Maven Central is the default public repository maintained by the Maven community.
Contains thousands of open-source libraries
Automatically configured
No setup required
###  Real-Time Scenario
Adding:
<dependency>
  <groupId>org.apache.commons</groupId>
  <artifactId>commons-lang3</artifactId>
  <version>3.14.0</version>
</dependency>
👉 Maven fetches it directly from Central.

## Remote repository
📌 What is a Remote Repository?
A remote repository is a company-hosted repository (e.g., Nexus / Artifactory).
🔹 Why Companies Use Remote Repositories?
Store internal libraries
Cache external dependencies
Control versions
Improve security

Real-Time Scenario (INTERVIEW GOLD)
🏢 Enterprise setup:
Internet access restricted
Dependencies approved by security team
All builds go through Nexus
👉 Developers download dependencies only from company repo.

### How Maven downloads dependencies
📌 Dependency Resolution Order (VERY IMPORTANT)
When Maven needs a dependency:
1️⃣ Check Local Repository (.m2)
2️⃣ If not found → check Remote Repository
3️⃣ If not found → check Central Repository
4️⃣ Download → store in .m2
👉 Next build uses local copy.
.m2 folder 

Common .m2 Files
        File	            Purpose
        repository/	                Dependency storage
        settings.xml	        Repo credentials, proxies
        settings-security.xml	Encrypted passwords

## 🔹 5️⃣ Maven Plugins

What is a plugin?
Plugin vs dependency

Common plugins:
## compiler:- Compiles Java source code.
🔹 Real-Time Scenario
Different Java versions across teams.
<plugin>
  <artifactId>maven-compiler-plugin</artifactId>
  <version>3.11.0</version>
  <configuration>
    <source>17</source>
    <target>17</target>
  </configuration>
</plugin>
👉 Ensures consistent Java version.

## surefire:- Runs unit tests.
🔹Real-Time Scenario
JUnit / TestNG tests executed during CI build.
Runs tests in src/test/java
Bound to test phase
👉 If tests fail → build fails.

## failsafe:- Runs integration tests.
🔹 Real-Time Scenario (INTERVIEW GOLD)
Integration tests need: DB , Server
Should run after packaging
👉 Runs during:
integration-test
verify
🔑 Surefire = unit tests
🔑 Failsafe = integration test

## jar:- Creates JAR file.
🔹 Real-Time Scenario
Packaging a microservice into a deployable JAR.
Bound to package phase
Output goes to target/

# Plugin execution phases ****************
📌 How Plugins Are Executed.....?
Ans:-Plugins are bound to lifecycle phases.

Example:
compile phase → compiler plugin
test phase → surefire plugin,failsafe plugin
package phase → jar plugin
👉 When a phase runs, all plugin goals bound to it run automatically.

🔹 6️⃣ Maven Profiles (INTERVIEW GOLD)

What are profiles?
📌 Definition (Strong Opening)
A Maven profile is a conditional configuration that allows you to change build behavior 
based on environment or requirement, without modifying the main POM.xml.

command:-  mvn test - Pdev

Why profiles are needed
In real projects:
Configurations differ per environment
You cannot hardcode values in pom.xml
You must avoid maintaining multiple POMs
👉 Profiles solve this problem cleanly.

Environment-based builds (dev/test/prod)

Profile activation
Command-line vs POM profiles



## 🔹 7️⃣ Maven Dependency Management (Advanced)
dependencyManagement vs dependencies
Maven Dependency Management is a mechanism to centralize and control dependency versions 
across projects and modules without forcing their inclusion.
<dependencyManagement>
Parent POM or super pom -> 
Version control across modules
BOM (Bill of Materials)

🔹 8️⃣ Multi-Module Maven Projects

Parent & child POM
Reactor build
Order of execution
Real-time enterprise use case

🔹 9️⃣ Maven & Testing

Unit tests with Surefire
Integration tests with Failsafe
Skipping tests
comand line:- 
a)mvn test -DskipTests test is going to compile but not goinng to run
b) -Dmaven.test.skip=true her no compile and no run
from xml :-   <skipTest>true</skipTest>
Test lifecycle mapping

🔹 🔟 Maven in CI/CD (Industry Scenario)
Maven in Jenkins pipeline
Build → Test → Package → Deploy
Snapshot vs Release versions

🔹 1️⃣1️⃣ Common Maven Issues (Real Interview Traps)

Dependency not found
Version conflict
Build failure
Corrupted local repo
Offline Mode