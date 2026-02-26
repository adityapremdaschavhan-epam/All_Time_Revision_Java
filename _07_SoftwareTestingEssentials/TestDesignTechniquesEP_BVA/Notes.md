# Introduction to Test Design Techniques:

Test design techniques are systematic methods used to derive effective test 
cases from requirements to ensure maximum coverage with minimum effort.

- Definition of black-box techniques.
  - Black-box testing techniques design test cases based on system inputs 
    and expected outputs without knowing internal code or implementation.

- Overview of EP and BVA in the context of functional testing.
  - Equivalence Partitioning and Boundary Value Analysis are black-box techniques 
    used in functional testing to reduce test cases while ensuring valid and invalid input coverage.
   
### Equivalence Partitioning (EP):

- Identifying input classes (valid and invalid partitions).
  -Equivalence Partitioning divides input data into valid and invalid 
    groups where each value in a group behaves the same.

- Steps to implement EP for creating focused test cases.
  -Identify input conditions, divide them into equivalence classes,
  and select one representative value from each class as a test case.
   
### Boundary Value Analysis (BVA):

- Why edge cases matter in testing.
    -Most defects occur at boundary values, so testing minimum, maximum, and 
        edge limits helps catch critical failures.
- Identifying minimum, maximum, and boundary conditions for inputs.
  - Identify the minimum, maximum, just below, and just above boundary 
    values of input ranges for testing.-
   
### Comparing EP and BVA:

- Strengths, weaknesses, and best-use cases for each technique.
  - EP reduces test cases efficiently by grouping inputs, while BVA focuses 
    on edge values and is best used for numeric or range-based inputs.
   
### Practical Application of EP and BVA:

- Designing test cases for common scenarios such as input fields
    (e.g., age validation, numeric range limits).

- Evaluating test sufficiency and coverage using EP/BVA.
    - Test sufficiency is achieved when all equivalence classes and boundary 
       conditions are covered, ensuring no critical input behavior is untested.