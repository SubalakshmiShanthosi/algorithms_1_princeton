# Union- Find Algorithm

A set of algorithms for solving dynamic connectivity problem

Two algorithms explored- Quick Find and Quick Union

Steps for developing an usable algorithm - Scientific Approach for Solving the problem - We also do mathematical analysis to evaluate.

1. Model for the problem
2. Find algorithms to solve the problem.
3. Fast enough? Enough memory is available?
4. If Not, Figure out why?
5. Find a way to address the problem
6. Iterate until satisfied

Given a set of N Objects =>
  Union Command: Connect two objects
  Find/Connected query: Is there a path connecting two objects?

Implementing the find and union operations =>

Find Query: Check if two objects belong to same component.
Union Query: Replace components containing two objects with their union.

Union Find Data Type(API):

```java
public class UF:

    UF(int N) //Initialize Union Find algorithm data structure with N (0 to N-1)objects. 

    void union(int p,int q) //Add connection between p and q

    boolean connected(int p, int q) // Are p and q in the same component?

    int find(int p) // Find component identifier of p (0 to N-1)

    int count() // number of components

```
