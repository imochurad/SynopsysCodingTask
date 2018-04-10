This repo contains the implementation of <i>Synopsys</i> coding [task](https://github.com/imochurad/SynopsysCodingTask/blob/master/docs/java_homework.%20hassib.docx). 

Expression evaluation is split into stages:

1. Tokenization of input expression and classifying tokens.
2. Generation of the expression tree.
3. Evaluation of the tree. Each operation node `(+,-,*,/)` recursively computes left and right expression and applies results of both parts. `Let`(denoted as `$` for brevity) operation is slightly different as it contains 3 child nodes. Second and third nodes are expressions. The result of computation of a second node is the value of a variable, which is stashed in node 1. That value then is being used in computing result of let operation, which is the result of recursive computation of node 3.

![Tree Representations](/docs/diagrams/tree_representations.jpeg)

An assumption is made that the input expressions are valid. The code does perform few sanity checks while on the go. However, it would have been better to employ something like ANTLR to build a grammar and then generate abstract syntax tree (AST) based on the input. Even though it is mentioned in the description of the task that the values are `Integer`s, in order to avoid overflow, it was decided to convert them into `BigInteger`s.

Examlpe of launch command:

```java -jar synopsys-coding-task-0.0.1-SNAPSHOT.jar "let(a, let(b, 10, add(b, b)), let(b, 20, add(a, b))" "mult(5, sub(1,3))" "add(1, mult(2, 3))" "mult(add(2, 2), div(9, 3))" "let(a, 5, let(b, mult(a, 10), add(b, a)))" "let(a, 5, add(a, a))"```

It would process multiple expressions at once, output expression trees and generate results at the end.

Logback was chosen as the logging framework. 

Dependency injection - Guice. 

Build system - Maven.

Travis CI is utilized for continuous integration. Once the change is pushed in the repo, Travis would build the code, launch one and only integration test and produce an artifact. 

The code is not covered with unit tests, which is not the best practice.