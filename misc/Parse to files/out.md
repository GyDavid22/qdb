[Popular Core Java Interview Questions and Answers (2023)
(simplilearn.com)](https://www.simplilearn.com/tutorials/java-tutorial/java-interview-questions)

1.  **What is Java?**

Java is a strongly OOP, general-purpose, managed, platform-independent
programming language released in 1995.

2.  **Why is Java a platform independent language?**

This is due to the managed nature of Java, because Java code does not
directly compile to machine code, but to code interpreted by the Java
VM, so the program ultimately runs on the Java VM. And the Java VM is
available in some form for almost every OS/architecture.

3.  **What are the differences between C++ and Java?**

Concept: C++: \"Write once, compile everywhere.\"; Java: \"Write once,
run everywhere.\" That is, unlike the above, C++ turns to OS and
architecture specific machine code.

Language compatibility: C++ was created as an object-oriented extension
of C, i.e. you can use C libraries and write C code in C++ (the reverse
is not true), but many high-level programming languages support C++,
e.g. Java. Java is not typically supported by other languages, except of
course for languages running on the JVM, e.g. Kotlin.

System libraries: C++ can natively handle OS system libraries, so C++
programs can take better advantage of the OS\'s capabilities. While in
the case of Java, the Java Native Interface can help achieve the same,
accessing system libraries natively with stock libraries is not
possible.

Characteristics: C++ does not force either procedural or object-oriented
programming, although both are supported. Since C++ is native code, we
must take care of freeing up the heap content (allocated with \"new\"
operator) space. For Java, all code must be part of a class, and freeing
up unnecessary memory space is always automatic (garbage collection).

Semantics of types: in C++, primitive types and objects work the same
way from the memory perspective. In Java, primitive types are found in
the stack, classes are always derived from the \"Object\" class, also
objects are always addressed by references and are found on the heap.

Interpreted/compiled: Java is also commonly referred to as a compiled
(Java code -\> JVM bytecode) and interpreted (bytecode run by JVM)
language, while C++ is strictly a compiled (C++ code -\> machine code)
language.

Inheritance: While C++ allows a class to have multiple inheritances,
Java doesn't to avoid the diamond problem.

  -----------------------------------------------------------------------------------
  Comparison Index       C++                     Java
  ---------------------- ----------------------- ------------------------------------
  Platform-independent   C++ is                  Java is platform-independent.
                         platform-dependent.     

  Mainly used for        C++ is mainly used for  Java is mainly used for application
                         system programming.     programming. It is widely used in
                                                 window, web-based, enterprise and
                                                 mobile applications.

  Design Goal            C++ was designed for    Java was designed and created as an
                         systems and             interpreter for printing systems but
                         applications            later extended as a support network
                         programming. It was an  computing. It was designed with a
                         extension of C          goal of being easy to use and
                         programming language.   accessible to a broader audience.

  Goto                   C++ supports            Java doesn\'t support the goto
                         the goto statement.     statement.

  Multiple inheritance   C++ supports multiple   Java doesn\'t support multiple
                         inheritance.            inheritance through class. It can be
                                                 achieved by interfaces in java.

  Operator Overloading   C++ supports operator   Java doesn\'t support operator
                         overloading.            overloading.

  Pointers               C++ supports pointers.  Java supports pointer internally.
                         You can write pointer   However, you can\'t write the
                         program in C++.         pointer program in java. It means
                                                 java has restricted pointer support
                                                 in Java.

  Compiler and           C++ uses compiler only. Java uses compiler and interpreter
  Interpreter            C++ is compiled and run both. Java source code is converted
                         using the compiler      into bytecode at compilation time.
                         which converts source   The interpreter executes this
                         code into machine code  bytecode at runtime and produces
                         so, C++ is platform     output. Java is interpreted that is
                         dependent.              why it is platform independent.

  Call by Value and Call C++ supports both call  Java supports call by value only.
  by reference           by value and call by    There is no call by reference in
                         reference.              java.

  Structure and Union    C++ supports structures Java doesn\'t support structures and
                         and unions.             unions.

  Thread Support         C++ doesn\'t have       Java has built-in thread support.
                         built-in support for    
                         threads. It relies on   
                         third-party libraries   
                         for thread support.     

  Documentation comment  C++ doesn\'t support    Java supports documentation comment
                         documentation comment.  (/\*\* \... \*/) to create
                                                 documentation for java source code.

  Virtual Keyword        C++ supports virtual    Java has no virtual keyword. We can
                         keyword so that we can  override all non-static methods by
                         decide whether or not   default. In other words, non-static
                         override a function.    methods are virtual by default.

  unsigned right shift   C++ doesn\'t support    Java supports unsigned right shift
  \>\>\>                 \>\>\> operator.        \>\>\> operator that fills zero at
                                                 the top for the negative numbers.
                                                 For positive numbers, it works same
                                                 like \>\> operator.

  Inheritance Tree       C++ creates a new       Java uses a single inheritance tree
                         inheritance tree        always because all classes are the
                         always.                 child of Object class in java. The
                                                 object class is the root of
                                                 the inheritance tree in java.

  Hardware               C++ is nearer to        Java is not so interactive with
                         hardware.               hardware.

  Object-oriented        C++ is an               Java is also
                         object-oriented         an object-oriented language.
                         language. However, in C However, everything (except
                         language, single root   fundamental types) is an object in
                         hierarchy is not        Java. It is a single root hierarchy
                         possible.               as everything gets derived from
                                                 java.lang.Object.
  -----------------------------------------------------------------------------------

4.  **List the features of the Java Programming language?**

-   Simple: Java is easy to learn. The syntax of Java is based on C++
    which makes easier to write the program in it.

-   Object-Oriented: Java follows the object-oriented paradigm which
    allows us to maintain our code as the combination of different type
    of objects that incorporates both data and behavior.

-   Portable: Java supports read-once-write-anywhere approach. We can
    execute the Java program on every machine. Java program (.java) is
    converted to bytecode (.class) which can be easily run on every
    machine.

-   Platform Independent: Java is a platform independent programming
    language. It is different from other programming languages like C
    and C++ which needs a platform to be executed. Java comes with its
    platform on which its code is executed. Java doesn\'t depend upon
    the operating system to be executed.

-   Secured: Java is secured because it doesn\'t use explicit pointers.
    Java also provides the concept of ByteCode and Exception handling
    which makes it more secured.

-   Robust: Java is a strong programming language as it uses strong
    memory management. The concepts like Automatic garbage collection,
    Exception handling, etc. make it more robust.

-   Architecture Neutral: Java is architectural neutral as it is not
    dependent on the architecture. In C, the size of data types may vary
    according to the architecture (32 bit or 64 bit) which doesn\'t
    exist in Java.

-   Interpreted: Java uses the Just-in-time (JIT) interpreter along with
    the compiler for the program execution.

-   High Performance: Java is faster than other traditional interpreted
    programming languages because Java bytecode is \"close\" to native
    code. It is still a little bit slower than a compiled language
    (e.g., C++).

-   Multithreaded: We can write Java programs that deal with many tasks
    at once by defining multiple threads. The main advantage of
    multi-threading is that it doesn\'t occupy memory for each thread.
    It shares a common memory area. Threads are important for
    multi-media, Web applications, etc.

-   Distributed: Java is distributed because it facilitates users to
    create distributed applications in Java. RMI and EJB are used for
    creating distributed applications. This feature of Java makes us
    able to access files by calling the methods from any machine on the
    internet.

-   Dynamic: Java is a dynamic language. It supports dynamic loading of
    classes. It means classes are loaded on demand. It also supports
    functions from its native languages, i.e., C and C++.

5.  **What do you get in the Java download file? How do they differ from
    one another?**

To run Java, you can download two types of frameworks. They are JDK
(Java Development Kit) and JRE (Java Runtime Environment). What they
have in common is that they are both platform-specific software.
However, they have different purposes, JDK includes components for
development and debugging, while JRE is the end-user version, which only
installs what is needed to run the application. JDK comes in 3 editions:
Standard, Enterprise, Micro.

6.  **What is a ClassLoader?**

Classloader is a subsystem of JVM which is used to load class files.
Whenever we run the java program, it is loaded first by the classloader.
There are three built-in classloaders in Java.

-   Bootstrap ClassLoader: This is the first classloader which is the
    superclass of Extension classloader. It loads the rt.jar file which
    contains all class files of Java Standard Edition like java.lang
    package classes, java.net package classes, java.util package
    classes, java.io package classes, java.sql package classes, etc.

-   Extension ClassLoader: This is the child classloader of Bootstrap
    and parent classloader of System classloader. It loads the jar files
    located inside \$JAVA_HOME/jre/lib/ext directory.

-   System/Application ClassLoader: This is the child classloader of
    Extension classloader. It loads the class files from the classpath.
    By default, the classpath is set to the current directory. You can
    change the classpath using \"-cp\" or \"-classpath\" switch. It is
    also known as Application classloader.

7.  **What are the Memory Allocations available in Java?**

In Java, 5 memory areas are distinguished:

-   Class: the definitions of each class are here, including static
    functions and static member variables.

-   Heap: For Java, this is where instances of objects are located, from
    creation until no references point to them.

-   Stack: The local variables of functions are stored here. Each
    function call has its own stackframe, which is freed as soon as the
    function stops.

-   Program counter: Stores the memory address of the instruction at
    which the program is at.

-   Native method stack: Memory space used by the called native
    libraries of the OS.

8.  **What are the differences between Heap and Stack Memory in Java?**

Stack is a fixed, finite-size memory area allocated separately for each
program. The heap, on the other hand, dynamically adapts to the needs of
the program, and in the case of Java, its max size is adjustable.
(Nowadays, on a modern OS the theoretical limit is set by the length of
the virtual memory address. E.g. 32 bits -- 4GB).

![](image1.png){width="6.5in" height="3.0840277777777776in"}

9.  **Will the program run if we write static public void main?**

Yes, using Java you have some freedom with the order of the specifiers.

10. **Explain the expected output of the following code segment?**

public class Simplilearn

{

\>public static void main (String args\[\])

\>{

\>\>System.out.println(100 + 100 +"Simplilearn\");

\>\>System.out.println("E-Learning Company\" + 100 + 100);

\>}

}

Since there are only \"+\" operators in the above expressions,
precedence is not a concern, the evaluation proceeds from left to right.
The first output will be \"200Simplilearn\", because during the
evaluation the two integers are added first, then since we use "+" for
an integer and a string, Java takes the overload for the operator which
concatenates two strings, converting the left side to a string.

The second output will be \"E-Learning Company100100\", because now the
first operation is performed on a string and an integer, just like
before, so it concatenates the two operands, the situation is the same
with the second "+".

11. **What is an Association?**

Association is the loosest type of connection between two objects, when
there is no ownership or being part of something modelled.

Association is a relationship where all object have their own lifecycle
and there is no owner. Let's take the example of Teacher and Student.
Multiple students can associate with a single teacher and a single
student can associate with multiple teachers but there is no ownership
between the objects and both have their own lifecycle. These
relationships can be one to one, one to many, many to one and many to
many.

12. **What do you mean by aggregation?**

An aggregation is a specialized form of Association where all object has
their own lifecycle but there is ownership and child object can not
belong to another parent object. Let's take an example of Department and
teacher. A single teacher can not belong to multiple departments, but if
we delete the department teacher object will not destroy.

Aggregation can be defined as the relationship between two classes where
the aggregate class contains a reference to the class it owns.
Aggregation is best described as a has-a relationship. For example, The
aggregate class Employee having various fields such as age, name, and
salary also contains an object of Address class having various fields
such as Address-Line 1, City, State, and pin-code. In other words, we
can say that Employee (class) has an object of Address class. Consider
the following example.

Address.java

public class Address {

\>String city,state,country;

\>public Address(String city, String state, String country) {

\>\>this.city = city;

\>\>this.state = state;

\>\>this.country = country;

\>}

}

Employee.java

public class Emp {

\>int id;

\>String name;

\>Address address;

\>public Emp(int id, String name,Address address) {

\>\>this.id = id;

\>\>this.name = name;

\>\>this.address=address;

\>}

\>void display() {

\>\>System.out.println(id+\" \"+name);

\>\>System.out.println(address.city+\" \"+address.state+\"
\"+address.country);

\>}

\>public static void main(String\[\] args) {

\>\>Address address1=new Address(\"gzb\",\"UP\",\"india\");

\>\>Address address2=new Address(\"gno\",\"UP\",\"india\");

\>\>Emp e=new Emp(111,\"varun\",address1);

\>\>Emp e2=new Emp(112,\"arun\",address2);

\>\>e.display();

\>\>e2.display();

\>}

}

Output

111 varun

gzb UP india

112 arun

gno UP india

13. **Define Copy Constructor in Java**

Copy constructor is a member function that is used to initialize an
object using another object of the same class.

There is no copy constructor in java. However, we can copy the values
from one object to another like copy constructor in C++.

There are many ways to copy the values of one object into another in
java. They are:

-   By constructor

-   By assigning the values of one object into another

-   By clone() method of Object class

In this example, we are going to copy the values of one object into
another using java constructor.

//Java program to initialize the values from one object to another

class Student6{

\>int id;

\>String name;

\>//constructor to initialize integer and string

\>Student6(int i,String n){

\>id = i;

\>name = n;

\>}

\>//constructor to initialize another object

\>Student6(Student6 s){

\>id = s.id;

\>name =s.name;

\>}

\>void display(){System.out.println(id+\" \"+name);}

\>public static void main(String args\[\]){

\>Student6 s1 = new Student6(111,\"Karan\");

\>Student6 s2 = new Student6(s1);

\>s1.display();

\>s2.display();

}

}

Output:

111 Karan

111 Karan

14. **What is a Marker Interface?**

In Java, a marker interface is an interface that does not declare any
methods or fields. Its sole purpose is to mark or tag a class as having
a certain characteristic or capability. By implementing a marker
interface, a class indicates that it possesses specific behavior or
qualifies for a particular treatment.

Marker interfaces are purely a convention and serve as a form of
metadata. They provide a way for developers or frameworks to identify
classes that meet certain criteria without requiring any additional
methods or fields.

Some common examples of marker interfaces in Java include:

-   Serializable: The Serializable interface is a marker interface that
    indicates a class can be serialized, allowing objects of that class
    to be converted into a byte stream for storage or transmission.

-   Cloneable: The Cloneable interface is a marker interface that
    indicates a class can be cloned using the \`clone()\` method.
    Implementing this interface allows for creating a copy of an object.

-   Remote: The Remote interface is a marker interface used in Java's
    Remote Method Invocation (RMI) framework. It marks an interface that
    can be invoked remotely, enabling the execution of methods across
    different JVMs.

Marker interfaces can be useful in various scenarios, such as:

-   Providing hints to the Java runtime or frameworks about special
    handling or optimizations for certain classes.

-   Enabling conditional behavior based on the presence of a marker
    interface during runtime.

-   Supporting integration with external libraries or frameworks that
    recognize and operate on marker interfaces.

It's important to note that with the introduction of annotations in
Java, the use of marker interfaces has become less common. Annotations
offer a more flexible and expressive way to attach metadata to classes
and methods. However, marker interfaces still have their place in
certain contexts and are part of the Java language's design and
heritage.

The marker interface can be declared as follows.

public interface Serializable {

}

15. **What is Object Cloning?**

It is the process of creating an exact copy of any object. In order to
support this, a java class has to implement the Cloneable interface of
java.lang package and override the clone() method provided by the Object
class the syntax of which is:

protected Object clone() throws CloneNotSupportedException {

\>return (Object) super.clone();

}

In case the Cloneable interface is not implemented and just the method
is overridden, it results in CloneNotSupportedException in Java.

16. **Can Java be said to be the complete object-oriented programming
    language**

No, Java cannot be treated as a complete object-oriented programming
language

17. **What is an object-oriented paradigm?**

It is a programming paradigm based on objects having data and methods
defined in the class to which it belongs. Object-oriented paradigm aims
to incorporate the advantages of modularity and reusability. Objects are
the instances of classes which interacts with one another to design
applications and programs. There are the following features of the
object-oriented paradigm.

-   Follows the bottom-up approach in program design.

-   Focus on data with methods to operate upon the object\'s data

-   Includes the concept like Encapsulation and abstraction which hides
    the complexities from the user and show only functionality.

-   Implements the real-time approach like inheritance, abstraction,
    etc.

-   The examples of the object-oriented paradigm are C++, Simula,
    Smalltalk, Python, C#, etc.

18. **Define Wrapper Classes in Java.**

Wrapper classes are classes that allow primitive types to be accessed as
objects. In other words, we can say that wrapper classes are built-in
java classes which allow the conversion of objects to primitives and
primitives to objects. The process of converting primitives to objects
is called autoboxing, and the process of converting objects to
primitives is called unboxing. There are eight wrapper classes present
in java.lang package is given below.

![](image2.png){width="6.5in" height="3.8194444444444446in"}

19. **What is a singleton class in Java? And How to implement a
    singleton class?**

A singleton class is a class which can only be instantiated once and
only has one instance. One example to implement it is to set all
constructors to private then add a static getter method to the class
which returns that one instance (and instantiate it before if it haven't
been already).

One example to implement a singleton class:

class WaterJug{

private int waterQuantity = 500;

private WaterJug(){}

private WaterJug object = null;

// Method to provide the service of Giving Water.

public int getWater(int quantity){

\> waterQuantity -= quantity;

\> return quantity;

}

// Method to return the object to the user.

public static Waterjug getInstance(){

\> // Will Create a new object if the object is not already created and
return the object.

\> if(object == null){

\>\> object = new WaterJug();

\> }

\> return object;

}

}

20. **Define package in Java.**

A package is a group of similar type of classes, interfaces, and
sub-packages. It provides access protection and removes naming
collision. The packages in Java can be categorized into two forms,
inbuilt package, and user-defined package. There are many built-in
packages such as Java, lang, awt, javax, swing, net, io, util, sql, etc.
Consider the following example to create a package in Java.

//save as Simple.java

package mypack;

public class Simple {

\>public static void main(String args\[\]) {

\>\>System.out.println(\"Welcome to package\");

\>}

}

![package in java](image3.jpeg){width="6.5in"
height="3.920138888888889in"}

21. **Can you implement pointers in a Java Program?**

Java Virtual Machine takes care of memory management implicitly. Java\'s
primary motto was to keep programming simple. So, accessing memory
directly through pointers is not a recommended action as it can cause
safety issues. Hence, pointers are eliminated in Java.

22. **Differentiate between instance and local variables.**

Variables declared on class-level can be accessed in any code inside
that class, meanwhile local variables are declared in the functions
which means they can only be accessed in their scope (the next "}") and
they don't even exist continuously during the whole lifecycle of the
given object.

23. **Explain Java String Pool.**

String pool is the space reserved in the heap memory that can be used to
store the strings. The main advantage of using the String pool is
whenever we create a string literal; the JVM checks the \"string
constant pool\" first. If the string already exists in the pool, a
reference to the pooled instance is returned. If the string doesn\'t
exist in the pool, a new string instance is created and placed in the
pool. Therefore, it saves the memory by avoiding the duplicacy.

![Java string
literal](image4.jpeg){width="6.006944444444445in"
height="5.333333333333333in"}

![String pool - Java Interview Questions -
Edureka](image5.png){width="6.5in"
height="3.872916666666667in"}

24. **What is an Exception? How does an exception propagate in the
    code?**

An Exception handling in Java is considered an unexpected event that can
disrupt the program\'s normal flow. These events can be fixed through
the process of Exception Handling.

An exception happens on the top level of the call stack, and it stops
the running of the code. The JVM then starts to look in the call stack
for the highest try-catch block with a compatible catch branch (same or
ancestor class of the exception), and executes it. If no such block
exists, the program crashes.

![](image6.jpeg){width="6.5in" height="3.65625in"}

An exception is first thrown from the top of the stack and if it is not
caught, it drops down the call stack to the previous method, If not
caught there, the exception again drops down to the previous method, and
so on until they are caught or until they reach the very bottom of the
call stack. This procedure is called exception propagation. By default,
checked exceptions are not propagated.

class TestExceptionPropagation1 {

\>void m() {

\>\>int data = 50 / 0;

\>}

\>void n() {

\>\>m();

\>}

\>void p() {

\>\>try {

\>\>\>n();

\>\>} catch (Exception e) {

\>\>\>System.out.println(\"exception handled\");

\>\>}

\>}

\>public static void main(String args\[\]) {

\>\>TestExceptionPropagation1 obj = new TestExceptionPropagation1();

\>\>obj.p();

\>\>System.out.println(\"normal flow\...\");

\>}

}

Output:

exception handled

normal flow\...

![exception
propagation](image7.jpeg){width="3.2291666666666665in"
height="2.826388888888889in"}

25. **What is the final keyword in Java?**

The term final is a predefined word in Java that is used while declaring
values to variables. When a value is declared using the final keyword,
then the variable\'s value remains constant throughout the program\'s
execution.

26. **What happens when the main() isn\'t declared as static and why is
    it static?**

When the main method is not declared as static, then the program may be
compiled correctly but ends up with a severe ambiguity and throws a run
time error that reads \"NoSuchMethodError.\" Java\'s main() function is
static by default, allowing the compiler to call it either before or
after creating a class object. The main () function is where the
compiler begins programme execution in every Java programme. Thus, the
main () method needs to be called by the compiler. If the main () method
is permitted to be non-static, the JVM must instantiate its class when
calling the function.

The main method is always static because static members are those
methods that belong to the classes, not to an individual object. JVM
calls the main method based on the class name itself, not by creating
the object.

If we made the main method non-static, JVM would have to create its
object first and then call main() method which will lead to the extra
memory allocation.

27. **What part of memory - Stack or Heap - is cleaned in the garbage
    collection process?**

Heap as the memory area of the stack is freed automatically by the
system.

28. **What is the difference between the program and the process?**

A program is a non-active entity which contains the code to perform its
task. Process is the active, running instance of a program.

29. **What are the differences between constructor and method of a class
    in Java?**

![](image8.png){width="6.5in" height="3.611111111111111in"}

![Java Constructors vs Methods](image9.jpeg){width="6.5in"
height="4.986805555555556in"}

30. **Which among StringBuilder or StringBuffer should be preferred when
    there are a lot of updates required to be done in the data?**

Because StringBuilder is quicker than StringBuffer, it is advised to
utilize it wherever possible. However, StringBuffer objects are the best
choice if thread safety is required.

31. **Can we make the main() thread a daemon thread?**

This technique designates whether the active thread is a user thread or
a daemon thread. For instance, tU.setDaemon(true) would convert a user
thread named tU into a daemon thread. On the other side, executing
tD.setDaemon(false) would convert a Daemon thread, tD, into a user
thread.

32. **What happens if there are multiple main methods inside one class
    in Java?**

You can overload the main method, however, the one with the signature of
"main(String\[\])" is the one which JVM will start when the program is
started.

33. **Can you call a constructor of a class inside another
    constructor?**

Yes, the concept can be termed as constructor chaining and can be
achieved using this().

![](image10.jpeg){width="6.5in" height="4.08125in"}

From the base class: The super() keyword is used to call the constructor
from the base class.

The constructor chaining follows the process of inheritance. The
constructor of the sub class first calls the constructor of the super
class. Due to this, the creation of sub class's object starts with the
initialization of the data members of the super class. The constructor
chaining works similarly with any number of classes. Every constructor
keeps calling the chain till the top of the chain.

34. **Why does the Java array index start with 0?**

That's because with arrays, the containing variable is a reference to
the beginning of the array. The indexing is an offset from the
beginning, so it starts with 0 because the first element in an array is
right at the beginning.

This way the 0 index array avoids the extra arithmetic operation to
calculate the memory address.

Example - Consider the array and assume each element takes 4-byte memory
space. Then the address will be like this:

![](image11.png){width="6.5in" height="2.178472222222222in"}

Now if we want to access index 4. Then internally java calculates the
address using the formula:

\[Base Address + (index \* no_of_bytes)\]. So according to this. The
starting address of the index 4 will be - \[100 + (4\*4)\] = 116. And
exactly that\'s what the address is calculated.

Now consider the same with 1 index Array:

![](image12.png){width="6.5in" height="2.245138888888889in"}

Now if we apply the same formula here. Then we get - 116 as the starting
address of the 4th index. Which is wrong. Then we need to apply
formula - \[Base Address + ((index-1) \* no_of_bytes)\].

And for calculating this, an extra arithmetic operation has to be
performed. And consider the case where millions of addresses need to be
calculated, this causes complexity. So to avoid this, ) the index array
is supported by java.

35. **Why is the remove method faster in the linked list than in an
    array?**

Because less operations have to be performed. In an array, when deleting
an item, all the following items have to be shifted by one to the
direction of the beginning in the array. In a linked list only the
neighboring elements have to be updated, more precisely their reference
to the previous and next element.

In the linked list, we only need to adjust the references when we want
to delete the element from either end or the front of the linked list.
But in the array, indexes are used. So to manage proper indexing, we
need to adjust the values from the array So this adjustment of value is
costlier than the adjustment of references.

Example: To Delete from the front of the linked list, internally the
references adjustments happened like this.

![](image13.png){width="6.5in"
height="3.7715277777777776in"}

The only thing that will change is that the head pointer will point to
the head's next node. And delete the previous node. That is the constant
time operation.

Whereas in the ArrayList, internally it should work like this:

![](image14.png){width="6.5in"
height="3.3069444444444445in"}

For deletion of the first element, all the next element has to move to
one place ahead. So this copying value takes time. So that is the reason
why removing in ArrayList is slower than LinkedList.

36. **How many overloaded add() and addAll() methods are available in
    the List interface? Describe the need and uses.**

There are a total of 4 overloaded methods for add() and addAll() methods
available in List Interface. The below table states the description of
all.

![](image15.png){width="6.5in"
height="2.3097222222222222in"}

37. **How does the size of ArrayList grow dynamically? And also state
    how it is implemented internally?**

ArrayList is implemented in such a way that it can grow dynamically. We
don\'t need to specify the size of ArrayList. For adding the values in
it, the methodology it uses is:

1\. Consider initially that there are 2 elements in the ArrayList. \[2,
3\].

![](image16.png){width="6.5in" height="4.376388888888889in"}

2\. If we need to add the element into this. Then internally what will
happen is:

-   ArrayList will allocate the new ArrayList of Size (current size +
    half of the current size). And add the old elements into the new.
    Old - \[2, 3\],\>New - \[2, 3, null\].

![](image17.png){width="6.5in" height="4.565972222222222in"}

-   Then the new value will be inserted into it. \[2, 3, 4, null\]. And
    for the next time, the extra space will be available for the value
    to be inserted.

![](image18.png){width="6.5in"
height="1.8423611111111111in"}

3\. This process continues and the time taken to perform all of these is
considered as the amortized constant time.

This is how the ArrayList grows dynamically. And when we delete any
entry from the ArrayList then the following steps are performed.

1\. It searches for the element index in the array. Searching takes some
time. Typically it's O(n) because it needs to search for the element in
the entire array.

![](image19.png){width="6.5in" height="1.9875in"}

2\. After searching the element, it needs to shift the element from the
right side to fill the index.

![](image20.png){width="6.5in"
height="2.2916666666666665in"}

So this is how the elements are deleted from the ArrayList internally.
Similarly, the search operations are also implemented internally as
defined in removing elements from the list (searching for elements to
delete).

38. **How is the creation of a String using new() different from that of
    a literal?**

When a String is formed as a literal with the assistance of an
assignment operator, it makes its way into the String constant pool so
that String Interning can take place. This same object in the heap will
be referenced by a different String if the content is the same for both
of them.

public bool checking() {

\>String first = \"InterviewBit\";

\>String second = \"InterviewBit\";

\>if (first == second)

\>\>return true;

\>else

\>\>return false;

}

The checking() function will return true as the same content is
referenced by both the variables.

![](image21.png){width="6.5in"
height="3.9055555555555554in"}

Conversely, when a String formation takes place with the help of a new()
operator, interning does not take place. The object gets created in the
heap memory even if the same content object is present.

public bool checking() {

\>String first = new String(\"InterviewBit\");

\>String second = new String(\"InterviewBit\");

\>if (first == second)

\>\>return true;

\>else

\>\>return false;

}

The checking() function will return false as the same content is not
referenced by both the variables.

![](image22.png){width="6.5in"
height="3.9055555555555554in"}

39. **How is the 'new\' operator different from the 'newInstance()\'
    operator in java?**

Both 'new' and 'newInstance()' operators are used to creating objects.
The difference is- that when we already know the class name for which we
have to create the object then we use a new operator. But suppose we
don't know the class name for which we need to create the object, Or we
get the class name from the command line argument, or the database, or
the file. Then in that case we use the 'newInstance()' operator.

The 'newInstance()' keyword throws an exception that we need to handle.
It is because there are chances that the class definition doesn't exist,
and we get the class name from runtime. So it will throw an exception.

40. **Is exceeding the memory limit possible in a program despite having
    a garbage collector?**

Yes, it is possible for the program to go out of memory in spite of the
presence of a garbage collector. Garbage collection assists in
recognizing and eliminating those objects which are not required in the
program anymore, in order to free up the resources used by them.

In a program, if an object is unreachable, then the execution of garbage
collection takes place with respect to that object. If the amount of
memory required for creating a new object is not sufficient, then memory
is released for those objects which are no longer in the scope with the
help of a garbage collector. The memory limit is exceeded for the
program when the memory released is not enough for creating new objects.

Moreover, exhaustion of the heap memory takes place if objects are
created in such a manner that they remain in the scope and consume
memory. The developer should make sure to dereference the object after
its work is accomplished. Although the garbage collector endeavors its
level best to reclaim memory as much as possible, memory limits can
still be exceeded.

Let's take a look at the following example:

List\<String\> example = new LinkedList\<String\>();

while(true) {

\>example.add(new String(\"Memory Limit Exceeded\"));

}

41. **Why is synchronization necessary? Explain with the help of a
    relevant example.**

Concurrent execution of different processes is made possible by
synchronization. When a particular resource is shared between many
threads, situations may arise in which multiple threads require the same
shared resource.

Synchronization assists in resolving the issue and the resource is
shared by a single thread at a time. Let's take an example to understand
it more clearly. For example, you have a URL and you have to find out
the number of requests made to it. Two simultaneous requests can make
the count erratic.

No synchronization:

package anonymous;

public class Counting {

\> private int increase_counter;

\> public int increase() {

\>\>\> increase_counter = increase_counter + 1;

\>\>\> return increase_counter;

\> }

}

![](image23.png){width="6.5in" height="3.81875in"}

If a thread Thread1 views the count as 10, it will be increased by 1 to
11. Simultaneously, if another thread Thread2 views the count as 10, it
will be increased by 1 to 11. Thus, inconsistency in count values takes
place because the expected final value is 12 but the actual final value
we get will be 11.

Now, the function increase() is made synchronized so that simultaneous
accessing cannot take place.

With synchronization:

package anonymous;

public class Counting {

\> private int increase_counter;

\> public synchronized int increase() {

\>\>\> increase_counter = increase_counter + 1;

\>\>\> return increase_counter;

\> }

}

![](image24.png){width="6.5in" height="4.329166666666667in"}

If a thread Thread1 views the count as 10, it will be increased by 1 to
11, then the thread Thread2 will view the count as 11, it will be
increased by 1 to 12. Thus, consistency in count values takes place.

42. **Define System.out.println().**

System.out.println() is used to print the message on the console.
System - It is a class present in java.lang package. Out is the static
variable of type PrintStream class present in the System class.
println() is the method present in the PrintStream class. It prints its
argument to the standard output.

So if we justify the statement, then we can say that if we want to print
anything on the console then we need to call the println() method that
was present in PrintStream class. And we can call this using the output
object that is present in the System class.

43. **Can you explain the Java thread lifecycle?**

Java thread life cycle is as follows:

-   New -- When the instance of the thread is created and the start()
    method has not been invoked, the thread is considered to be alive
    and hence in the NEW state.

-   Runnable -- Once the start() method is invoked, before the run()
    method is called by JVM, the thread is said to be in RUNNABLE (ready
    to run) state. This state can also be entered from the Waiting or
    Sleeping state of the thread.

-   Running -- When the run() method has been invoked and the thread
    starts its execution, the thread is said to be in a RUNNING state.

-   Non-Runnable (Blocked/Waiting) -- When the thread is not able to run
    despite the fact of its aliveness, the thread is said to be in a
    NON-RUNNABLE state. Ideally, after some time of its aliveness, the
    thread should go to a runnable state.

    -   A thread is said to be in a Blocked state if it wants to enter
        synchronized code but it is unable to as another thread is
        operating in that synchronized block on the same object. The
        first thread has to wait until the other thread exits the
        synchronized block.

    -   A thread is said to be in a Waiting state if it is waiting for
        the signal to execute from another thread, i.e it waits for work
        until the signal is received.

-   Terminated -- Once the run() method execution is completed, the
    thread is said to enter the TERMINATED step and is considered to not
    be alive.

The following flowchart clearly explains the lifecycle of the thread in
Java.

![](image25.jpeg){width="6.5in"
height="4.079861111111111in"}

44. **What could be the tradeoff between the usage of an unordered array
    versus the usage of an ordered array?**

-   The main advantage of having an ordered array is the reduced search
    time complexity of O(log n) whereas the time complexity in an
    unordered array is O(n).

-   The main drawback of the ordered array is its increased insertion
    time which is O(n) due to the fact that its element has to reordered
    to maintain the order of array during every insertion whereas the
    time complexity in the unordered array is only O(1).

-   Considering the above 2 key points and depending on what kind of
    scenario a developer requires, the appropriate data structure can be
    used for implementation.

45. **Is it possible to import the same class or package twice in Java
    and what happens to it during runtime?**

One can import the same package or the same class multiple times.
Neither compiler nor JVM complains about it. However, the JVM will
internally load the class only once no matter how many times you import
the same class.

46. **In case a package has sub packages, will it suffice to import only
    the main package? e.g. Does importing of com.myMainPackage.\* also
    import com.myMainPackage.mySubPackage.\*?**

Sub-packages won\'t be imported when a package is imported. When you
import a package, all of its classes and interfaces---with the exception
of those from its sub-packages---are imported.

47. **Will the final block be executed if the code System.exit(0) is
    written at the end of the try block?**

NO. The control of the program post System.exit(0) is immediately gone
and the program gets terminated which is why the finally block never
gets executed.

48. **Explain the term "Double Brace Initialization" in Java?**

This is a convenient means of initializing any collections in Java.
Consider the below example.

import java.util.HashSet;

import java.util.Set;

public class IBDoubleBraceDemo{

public static void main(String\[\] args){

\> Set\<String\> stringSets = new HashSet\<String\>()

\> {

\>\> {

\>\>\> add(\"set1\");

\>\>\> add(\"set2\");

\>\>\> add(\"set3\");

\>\> }

\> };

\> doSomething(stringSets);

}

private static void doSomething(Set\<String\> stringSets){

\> System.out.println(stringSets);

}

}

In the above example, we see that the stringSets were initialized by
using double braces.

The first brace does the task of creating an anonymous inner class that
has the capability of accessing the parent class's behavior. In our
example, we are creating the subclass of HashSet so that it can use the
add() method of HashSet.

The second brace is an initialization block.

Care should be taken while initializing through this method as the
method involves the creation of anonymous inner classes which can cause
problems during the garbage collection or serialization processes and
may also result in memory leaks.

49. **Why is it said that the length() method of String class doesn\'t
    return accurate results?**

-   The length method returns the number of Unicode units of the String.
    Let\'s understand what Unicode units are and what is the confusion
    below.

```{=html}
<!-- -->
```
-   We know that Java uses UTF-16 for String representation. With this
    Unicode, we need to understand the below two Unicode related terms:

    -   Code Point: This represents an integer denoting a character in
        the code space.

    -   Code Unit: This is a bit sequence used for encoding the code
        points. In order to do this, one or more units might be required
        for representing a code point.

-   Under the UTF-16 scheme, the code points were divided logically into
    17 planes and the first plane was called the Basic Multilingual
    Plane (BMP). The BMP has classic characters - U+0000 to U+FFFF. The
    rest of the characters- U+10000 to U+10FFFF were termed as the
    supplementary characters as they were contained in the remaining
    planes.

    -   The code points from the first plane are encoded using one
        16-bit code unit

    -   The code points from the remaining planes are encoded using two
        code units.

Now if a string contained supplementary characters, the length function
would count that as 2 units and the result of the length() function
would not be as per what is expected.

In other words, if there is 1 supplementary character of 2 units, the
length of that SINGLE character is considered to be TWO - Notice the
inaccuracy here? As per the java documentation, it is expected, but as
per the real logic, it is inaccurate.

50. **What are the possible ways of making objects eligible for garbage
    collection (GC) in Java?**

First Approach: Set the object references to null once the object
creation purpose is served.

public class IBGarbageCollect {

public static void main (String \[\] args){

\> String s1 = \"Some String\";

\>\> // s1 referencing String object - not yet eligible for GC

\> s1 = null; // now s1 is eligible for GC

}

}

Second Approach: Point the reference variable to another object. Doing
this, the object which the reference variable was referencing before
becomes eligible for GC.

public class IBGarbageCollect {

public static void main(String \[\] args){

\> String s1 = \"To Garbage Collect\";

\> String s2 = \"Another Object\";

\> System.out.println(s1); // s1 is not yet eligible for GC

\> s1 = s2; // Point s1 to other object pointed by s2

\> /\* Here, the string object having the content \"To Garbage Collect\"
is not referred by any reference variable. Therefore, it is eligible for
GC \*/

}

}

Third Approach: Island of Isolation Approach: When 2 reference variables
pointing to instances of the same class, and these variables refer to
only each other and the objects pointed by these 2 variables don\'t have
any other references, then it is said to have formed an "Island of
Isolation" and these 2 objects are eligible for GC.

public class IBGarbageCollect {

IBGarbageCollect ib;\>

public static void main(String \[\] str){

\> IBGarbageCollect ibgc1 = new IBGarbageCollect();

\> IBGarbageCollect ibgc2 = new IBGarbageCollect();

\> ibgc1.ib = ibgc2; //ibgc1 points to ibgc2

\> ibgc2.ib = ibgc1; //ibgc2 points to ibgc1

\> ibgc1 = null;

\> ibgc2 = null;

\> /\*

\> \* We see that ibgc1 and ibgc2 objects refer

\> \* to only each other and have no valid

\> \* references- these 2 objects for island of isolcation - eligible
for GC

\> \*/

}

}

51. **What is the best way to inject dependency? Also, state the
    reason.**

The best way to inject dependencies in an application is through
constructor injection. Constructor injection involves passing
dependencies as parameters to a class's constructor. Here are the
reasons why constructor injection is considered the best approach:

-   Explicit dependencies: Constructor injection makes dependencies
    explicit, as they are clearly defined as constructor parameters.
    This improves code readability and makes it easier to understand the
    class's dependencies.

-   Compile-time safety: With constructor injection, dependencies are
    resolved at compile-time rather than runtime. This allows for early
    detection of missing or incorrect dependencies, reducing the chances
    of runtime errors.

-   Testability: Constructor injection facilitates easy testing of
    classes by allowing for the injection of mock or stub dependencies
    during unit testing. By providing test doubles through the
    constructor, you can isolate the class under test and verify its
    behavior without relying on real dependencies.

-   Immutability: Constructor injection promotes immutability as
    dependencies can be declared as final or read-only. Immutable
    objects are generally easier to reason about and less prone to bugs
    related to state changes.

-   Dependency inversion principle: Constructor injection adheres to the
    Dependency Inversion Principle (DIP) of the SOLID principles. DIP
    states that high-level modules should not depend on low-level
    modules, but both should depend on abstractions. Constructor
    injection allows for the injection of abstractions rather than
    concrete implementations, enabling flexibility and loose coupling
    between classes.

While other dependency injection techniques like setter injection and
field injection exist, they have certain drawbacks compared to
constructor injection. Setter injection can lead to optional
dependencies or unexpected null values, while field injection tightly
couples classes and makes it harder to identify dependencies. Hence,
constructor injection is generally recommended as the best way to inject
dependencies.

52. **How we can set the spring bean scope. And what supported scopes
    does it have?**

There are four supported scopes of a Spring bean: singleton, prototype,
request, and session.

The singleton scope creates a single instance of a bean, which is shared
by all objects that request it.

The prototype scope creates a new instance of a bean for each object
that requests it.

The request and session scopes are only available in a web-based
context. The request scope creates a new bean instance for each HTTP
request, and the session scope creates a single instance of a bean
shared by all objects in a single HTTP session.

The ways we can set a scope are using the \@Scope annotation or the
scope attribute in the configuration XML file.

To set the scope using the \`@Scope\` annotation, you can specify it on
the bean class or the bean definition method within a configuration
class. Here's an example:

\@Configuration

public class MyConfig {

\>@Bean

\>@Scope(\"singleton\")

\>public MyBean singletonBean() {

\>\>return new MyBean();

\>}

\>@Bean

\>@Scope(\"prototype\")

\>public MyBean prototypeBean() {

\>\>return new MyBean();

\>}

}

In this example, the \`singletonBean\` method is annotated with
\`@Scope("singleton")\`, indicating that the bean will have a singleton
scope. The \`prototypeBean\` method is annotated with
\`@Scope("prototype")\`, specifying a prototype scope.

53. **What are the different categories of Design patterns?**

Design patterns are categorized into the following different types. And
those are also further categorized as

Structural patterns:

-   Adapter

-   Bridge

-   Filter

-   Composite

-   Decorator

-   Facade

-   Flyweight

-   Proxy

Behavioral patterns:

-   Interpreter

-   Template method/ pattern

-   Chain of responsibility

-   Command pattern

-   Iterator pattern

-   Strategy pattern

-   Visitor pattern

J2EE patterns:

-   MVC Pattern

-   Data Access Object pattern

-   Front controller pattern

-   Intercepting filter pattern

-   Transfer object pattern

Creational patterns:

-   Factory method/Template

-   Abstract Factory

-   Builder

-   Prototype

-   Singleton

54. **What is a Memory Leak? Discuss some common causes of it.**

The Java Garbage Collector (GC) typically removes unused objects when
they are no longer required, but when they are still referenced, the
unused objects cannot be removed. So this causes the memory leak
problem. Example: Consider a linked list like the structure below:

![](image26.png){width="6.5in" height="3.0625in"}

In the above image, there are unused objects that are not referenced.
But then also Garbage collection will not free it. Because it is
referencing some existing referenced object. So this can be the
situation of memory leak.

Some common causes of Memory leaks are -

-   When there are Unbounded caches.

-   Excessive page swapping is done by the operating system.

-   Improper written custom data structures.

-   Inserting into a collection object without first deleting it.

-   etc.

55. **Assume a thread has a lock on it, calling the sleep() method on
    that thread will release the lock?**

A thread that has a lock won\'t be released even after it calls sleep().
Despite the thread sleeping for a specified period of time, the lock
will not be released.

56. **Write a Java Program to print Fibonacci Series using Recursion.**

public class Main {

\>public static void main(String\[\] args) {

\>\>int n = 10;

\>\>for (int i = 0; i \< n; i++) {

\>\>\>System.out.print(fibonacci(i) + \" \");

\>\>}

\>}

\>public static int fibonacci(int depth) {

\>\>if (depth \<= 1) {

\>\>\>return depth;

\>\>}

\>\>return fibonacci(depth - 1) + fibonacci(depth - 2);

\>}

}

57. **Write a Java program to check if the two strings are anagrams.**

public class Main

{

\>public static void main(String\[\] args) {

\>\>areAnagram(\"apple\", \"elppa\");

\>\>areAnagram(\"watermelon\", \"pear\");

\>}

\>public static void areAnagram(String s1, String s2) {

\>\>System.out.print(s1 + \" and \" + s2 + \" are \");

\>\>s1 = s1.toLowerCase().replaceAll(\" \", \"\");

\>\>s2 = s2.toLowerCase().replaceAll(\" \", \"\");

\>\>StringBuilder s1Reversed = new StringBuilder();

\>\>for (int i = s1.length() - 1; i \>= 0; i\--) {

\>\>\>s1Reversed.append(s1.charAt(i));

\>\>}

\>\>if (!s1Reversed.toString().equals(s2)) {

\>\>\>System.out.print(\"not \");

\>\>}

\>\>System.out.println(\"anagrams.\");

\>}

}

58. **Write a Java Program to find the factorial of a given number.**

public class Main

{

\>public static void main(String\[\] args) {

\>\>System.out.println(solution1(5));

\>\>System.out.println(solution2(5));

\>}

\>public static int solution1(int n) {

\>\>if (n == 1) {

\>\>\>return n;

\>\>}

\>\>return n \* solution1(n - 1);

\>}

\>public static int solution2(int n) {

\>\>int result = 1;

\>\>for (int i = 2; i \<= n; i++) {

\>\>\>result \*= i;

\>\>}

\>\>return result;

\>}

}

59. **Given an array of non-duplicating numbers from 1 to n where one
    number is missing, write an efficient java program to find that
    missing number.**

A possible solution with a time complexity of O(n):

public class Main

{

\>public static void main(String\[\] args) {

\>\>int\[\] arr = {1, 2, 4, 6, 3, 7, 8};

\>\>find(arr);

\>}

\>public static void find(int\[\] arr) {

\>\>boolean\[\] contains = new boolean\[arr.length + 1\];

\>\>for (int i = 0; i \< contains.length; i++) {

\>\>\>contains\[i\] = false;

\>\>}

\>\>for (int i : arr) {

\>\>\>contains\[i - 1\] = true;

\>\>}

\>\>for (int i = 0; i \< contains.length; i++) {

\>\>\>if (!contains\[i\]) {

\>\>\>\>System.out.println(\"Number \" + (i + 1) + \" is missing.\");

\>\>\>}

\>\>}

\>}

}

60. **Write a Java Program to check if any number is a magic number or
    not. A number is said to be a magic number if after doing the sum of
    digits in each step and in turn doing the sum of digits of that sum,
    the ultimate result (when there is only one digit left) is 1.**

public class Main

{

\>public static void main(String\[\] args) {

\>\>magic(1234);

\>\>magic(1235);

\>}

\>public static void magic(int n) {

\>\>String numAsString = String.valueOf(n);

\>\>while (!(numAsString.length() == 1)) {

\>\>\>int sum = 0;

\>\>\>for (int i = 0; i \< numAsString.length(); i++) {

\>\>\>\>sum += Character.getNumericValue(numAsString.charAt(i));

\>\>\>}

\>\>\>numAsString = String.valueOf(sum);

\>\>}

\>\>if (numAsString.equals(\"1\")) {

\>\>\>System.out.println(n + \" is a magic number.\");

\>\>} else {

\>\>\>System.out.println(n + \" is not a magic number.\");

\>\>}

\>}

}

61. **Write a Java program to create and throw custom exceptions.**

To create you own exception extend the Exception class or any of its
subclasses.

-   class New1Exception extends Exception { }\>\>\> // this will create
    Checked Exception

-   class NewException extends IOException { }\>\>\> // this will create
    Checked exception

-   class NewException extends NullPonterExcpetion { } // this will
    create UnChecked exception

First we create the custom exception in InvalidAgeException.java:

public class InvalidAgeException extends Exception {

\>public InvalidAgeException() {

\>super("The given age doesn't have the right to vote yet.");

}

}

Then we can use it (of course inside a class):

static void validate(int age) throws InvalidAgeException {

\>if (age \< 18) {

\>\>throw new InvalidAgeException();

\>} else {

\>\>System.out.println(\"You can vote!\");

\>}

}

public static void main(String\[\] args) {

\>try {

\>\>validate(13);

\>} catch (InvalidAgeException e) {

\>\>System.err.println(e.toString());

\>}

}

62. **Write a Java program to rotate arrays 90 degree clockwise by
    taking matrices from user input.**

public class Main {

\>public static void main(String args\[\]) {

\>\>//matrix to rotate

\>\>int a\[\]\[\] = {

\>\>\>{ 1, 2, 3 },

\>\>\>{ 4, 5, 6 },

\>\>\>{ 7, 8, 9 }

\>\>};

\>\>System.out.println(\"Original Matrix: \\n\");

\>\>//loop for rows

\>\>for (int i = 0; i \< 3; i++) {

\>\>\>//loop for columns

\>\>\>for (int j = 0; j \< 3; j++) {

\>\>\>\>//prints the elements of the original matrix

\>\>\>\>System.out.print(\" \" + a\[i\]\[j\] + \"\\t\");

\>\>\>}

\>\>\>System.out.println(\"\\n\");

\>\>}

\>\>System.out.println(\"Rotate Matrix by 90 Degrees Clockwise: \\n\");

\>\>for (int i = 0; i \< 3; i++) {

\>\>\>for (int j = 2; j \>= 0; j\--) {

\>\>\>\>//prints the elements of the rotated matrix

\>\>\>\>System.out.print(\"\" + a\[j\]\[i\] + \"\\t\");

\>\>\>}

\>\>\>System.out.println(\"\\n\");

\>\>}

\>}

}

63. **Write a java program to check if any number given as input is the
    sum of 2 prime numbers.**

public class Main {

\>static ArrayList\<Integer\> calculatePrimesList(int to) {

\>\>ArrayList\<Integer\> primes = new ArrayList\<\>();

\>\>primes.add(2);

\>\>for (int i = 3; i \<= to; i++) {

\>\>\>boolean found = false;

\>\>\>for (int j : primes) {

\>\>\>\>if (i % j == 0) {

\>\>\>\>\>found = true;

\>\>\>\>\>break;

\>\>\>\>}

\>\>\>}

\>\>\>if (!found) {

\>\>\>\>primes.add(i);

\>\>\>}

\>\>}

\>\>return primes;

\>}

\>public static void main(String args\[\]) {

\>\>int numberToCheck = 14;

\>\>ArrayList\<Integer\> primes = calculatePrimesList(14);

\>\>for (int i : primes) {

\>\>\>for (int j : primes) {

\>\>\>\>if (i + j == numberToCheck) {

\>\>\>\>\>System.out.println(numberToCheck + \" can be described as the
sum of 2 primes: \" + i + \"+\" + j);

\>\>\>\>}

\>\>\>}

\>\>}

\>}

}

64. **Write a Java program for solving the Tower of Hanoi Problem.**

class Main {

\>// Java recursive function to solve tower of hanoi puzzle

\>static void towerOfHanoi(int n, char from_rod, char to_rod, char
aux_rod) {

\>\>if (n == 1) {

\>\>\>System.out.println(\"Move disk 1 from rod \" + from_rod + \" to
rod \" + to_rod);

\>\>\>return;

\>\>}

\>\>towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);

\>\>System.out.println(\"Move disk \" + n + \" from rod \" + from_rod +
\" to rod \" + to_rod);

\>\>towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);

\>}

\>public static void main(String args\[\]) {

\>\>int n = 4; // Number of disks

\>\>towerOfHanoi(n, \'A\', \'C\', \'B\'); // A, B and C are names of
rods

\>\>}

\>}

65. **Implement Binary Search in Java using recursion.**

class Main {

\>// returns the index of the found element, -1 if not found

\>// top is exclusive

\>static int binarySearch(int\[\] array, int toSearch, int bottom, int
top) {

\>\>if (bottom \>= top)

\>\>\>return -1;

\>\>int index = (bottom + top) / 2;

\>\>int current = array\[index\];

\>\>if (current == toSearch)

\>\>\>return index;

\>\>if (toSearch \< current)

\>\>\>return binarySearch(array, toSearch, bottom, index);

\>\>return binarySearch(array, toSearch, index + 1, top);

\>}

\>public static void main(String args\[\]) {

\>\>int\[\] array = { 1, 3, 4, 7, 11, 25, 27, 30, 45 };

\>\>System.out.println(binarySearch(array, 7, 0, array.length)); // 7 is
at 3

\>\>System.out.println(binarySearch(array, 12, 0, array.length)); // not
found

\>}

}

66. **Are delete, next, main, exit or null keywords in java?**

No, they are not keywords. Delete, next, exit are operations, which the
program might does, main is the name of the method which serves as an
entry point at launch, null is the value of a variable which doesn't
refer to a memory area at the moment.

67. **What is a JIT compiler?**

In general JIT (just in time compilation) refers to a compilation
method, where the code gets compiled during runtime. (Opposed to AOT
(ahead of time), when the code is compiled completely before the program
starts running.) One advantage of JIT compiling is having reduced
compilation time. The compiler is nothing but a translator of source
code to machine-executable code. But what is special about the JIT
compiler? Let us see how it works:

-   First, the Java source code (.java) conversion to byte code (.class)
    occurs with the help of the javac compiler.

-   Then, the .class files are loaded at run time by JVM and with the
    help of an interpreter, these are converted to machine
    understandable code.

-   JIT compiler is a part of JVM. When the JIT compiler is enabled, the
    JVM analyzes the method calls in the .class files and compiles them
    to get more efficient and native code. It also ensures that the
    prioritized method calls are optimized.

-   Once the above step is done, the JVM executes the optimized code
    directly instead of interpreting the code again. This increases the
    performance and speed of the execution.

> ![](image27.jpeg){width="6.5in"
> height="4.079166666666667in"}

68. **What are Brief Access Specifiers and Types of Access Specifiers?**

Access specifiers or access modifiers are used to set the availability
scope of an attribute of an object. There are 4 of them:

-   Private: only visible from inside the object

-   Protected: only visible from inside the object and from the
    descendants of the object

-   Public: visible from everywhere

-   Package: only visible from objects in the same package (this one has
    no keyword, it's the default value)

69. **How many types of constructors are used in Java?**

There are two types of constructors in Java.

Parameterized Constructors: Parameterized constructor accepts the
parameters with which users can initialize the instance variables. Users
can initialize the class variables dynamically at the time of
instantiating the class.

Default constructors: This type doesn't accept any parameters; rather,
it instantiates the class variables with their default values. It is
used mainly for object creation.

![Java
Constructors](image28.png){width="5.204861111111111in"
height="3.386111111111111in"}

70. **Can a constructor return a value?**

Not explicitly, because it implicitly returns with the reference of the
newly created object.

71. **Explain 'this' keyword in Java.**

The **this** keyword is a reference variable that refers to the current
object. There are the various uses of this keyword in Java. It can be
used to refer to current class properties such as instance methods,
variable, constructors, etc. It can also be passed as an argument into
the methods or constructors. It can also be returned from the method as
the current class instance.

![java this
keyword](image29.jpeg){width="4.386111111111111in"
height="1.9013888888888888in"}

72. **Explain 'super' keyword in Java.**

The super keyword in Java is a reference variable that is used to refer
to the immediate parent class object. Whenever you create the instance
of the subclass, an instance of the parent class is created implicitly
which is referred by super reference variable. The super() is called in
the class constructor implicitly by the compiler if there is no super or
this.

class Animal {

\>Animal() {

\>\>System.out.println(\"animal is created\");

\>}

}

class Dog extends Animal {

\>Dog() {

\>\>System.out.println(\"dog is created\");

\>}

}

class TestSuper4 {

\>public static void main(String args\[\]) {

\>\>Dog d = new Dog();

\>}

}

Output:

animal is created

dog is created

73. **Explain Method Overloading in Java.**

Method overloading is the polymorphism technique which allows us to
create multiple methods with the same name but different signature. We
can achieve method overloading in two ways.

-   By Changing the number of arguments

-   By Changing the data type of arguments

Method overloading increases the readability of the program. Method
overloading is performed to figure out the program quickly.

74. **Can we overload a static method?**

Yes, but there is a restriction: a static method cannot have a
non-static overload.

75. **Define Late Binding.**

It happens when the class type is determined during the runtime, thus a
method implementation cannot be selected before runtime.

76. **Define Dynamic Method Dispatch.**

Also known as polymorphism from the OOP principles, it means that if we
reference a descendant object through an ancestor type variable, and the
descendant class has an overwritten method from the ancestor, the method
of the descendant will run.

77. **Explain the difference between \>\> and \>\>\> operators.**

These 2 are the bitwise right shift operators. Although both operators
look similar. But there is a minimal difference between these two right
shift operators.

-   '\>\>' Bitwise Right Shift Operator- This operator shifts each bit
    to its right position. And this maintains the signed bit.

-   '\>\>\>' Bitwise Right Shift Operator with trailing zero- This
    operator also shifts each bit to its right. But this doesn't
    maintain the signed bit. This operator makes the Most significant
    bit to 0.

Example: Num1 = 8, Num2 = -8.

So the binary form of these numbers are:

Num1 = 00000000 00000000 00000000 00001000

Num2 = 11111111 11111111 11111111 11111000

'\>\>' Operator : 8 \>\> 1 (Shift by one bit):

Num1 = 00000000 00000000 00000000 00000100

Num2 = 11111111 11111111 11111111 11111100

'\>\>\>' Operator : 8 \>\>\> 1 (Shift by one bit):

Num1 = 00000000 00000000 00000000 00000100

Num2 = 01111111 11111111 11111111 11111100

78. **Brief the life cycle of an applet.**

When an applet is created, the following methods are invoked in order.

-   init()

-   start()

-   paint()

When an applet is destroyed, the following functions are invoked in
order.

-   stop()

-   destroy()

However, Java applets are deprecated since 2017.

79. **Why are generics used in Java Programming?**

Compile-time type safety is provided by using generics. Compile-time
type safety allows users to catch unnecessary invalid types at compile
time. Generic methods and classes help programmers specify a single
method declaration, a set of related methods, or related types with an
available class declaration.

80. **Explain the Externalizable interface.**

The Externalizable interface helps with control over the process of
serialization. An \"externalisable\" interface incorporates readExternal
and writeExternal methods.

81. **What is the Daemon Thread?**

The Daemon thread can be defined as a thread with the least priority.
This Daemon thread is designed to run in the background during the
Garbage Collection in Java.

The setDaemon() method creates a Daemon thread in Java.

82. **Explain the term enumeration in Java.**

Enumeration (or enum for short) is a special data type which is intended
to store predefined constants. It is useful when we have a set of values
which doesn't change, e.g., the days of the week.

83. **Why is Java dynamic?**

Java is considered to be more dynamic than C or C++ since it is designed
to adapt to an evolving environment. Java programs can carry an
extensive amount of run-time information that can be used to verify and
resolve accesses to objects at run-time.

84. **Can you run a code before executing the main method?**

Yes, the code you write in a static block is running immediately after
the class is loaded, which means it runs before the main method starts
running.

85. **How many times is the finalize method called?**

The finalize method is called the Garbage collector. For every object,
the Garbage Collector calls the finalize() method just for one time,
before destroying the object.

86. **Can \"this()\" and \"super()\" keywords be used together?**

No. Both of them are meant to be the first statement in a constructor,
you can use either of them, if necessary, but not both at the same time.

87. **What is a JSP page?**

JSP is an abbreviation for Java Servlet Page. JSP is a backend
technology used to generate dynamic webpages. The JSP page consists of
two types of text.

-   Static Data

-   JSP elements

88. **What is JDBC?**

JDBC is an abbreviation for Java Database Connector.

JDBC is an abstraction layer used to establish connectivity between an
existing database and a Java application.

89. **Explain the various directives in JSP.**

Directives are instructions processed by JSP Engine. After the JSP page
is compiled into a Servlet, Directives set page-level instructions,
insert external files, and define customized tag libraries. Directives
are defined using the symbols below:

start with \"\< %@\" and then end with \"% \>\"

The various types of directives are shown below:

-   Include directive: It includes a file and combines the content of
    the whole file with the currently active pages.

-   Page directive: Page Directive defines specific attributes in the
    JSP page, like the buffer and error page.

-   Taglib: Taglib declares a custom tag library, which is used on the
    page.

90. **What are the observer and observable classes?**

They are part of the observer design pattern, Java has a predefined
abstract class and an interface to implement it. Observable classes can
be subscribed to and this class keeps track of the subscribed Observer
objects. When the observable class changes, it calls the update() method
of each subscribed observers, which then do their operations.

91. **What is Session Management in Java?**

Session management in Java refers to the process of maintaining a
dynamic state of interaction between a client and a server during a
user\'s visit to a web application. It involves the exchange of
information, typically in the form of requests and responses, between
the client\'s web browser and the server. One common approach to
implementing session management is by using a session ID, which is a
unique identifier assigned to each client\'s communication session and
is exchanged between the client and the server to keep track of the
session\'s state.

92. **Briefly explain the term Spring Framework.**

The Spring Framework is an essential Java application framework and an
inversion of control container. It is primarily used for building
enterprise-level Java applications. It\'s important to note that the
Spring Framework offers a set of core features that can benefit
virtually any Java application.

93. **How to handle exceptions in Spring MVC Framework?**

Spring MVC Framework provides the following ways to help us achieving
robust exception handling.

-   Controller Based:

We can define exception handler methods in our controller classes. All
we need is to annotate these methods with \@ExceptionHandler annotation.

-   Global Exception Handler:

Exception Handling is a cross-cutting concern and Spring provides
\@ControllerAdvice annotation that we can use with any class to define
our global exception handler.

-   HandlerExceptionResolver implementation:

For generic exceptions, most of the times we serve static pages. Spring
Framework provides HandlerExceptionResolver interface that we can
implement to create global exception handler. The reason behind this
additional way to define global exception handler is that Spring
framework also provides default implementation classes that we can
define in our spring bean configuration file to get spring framework
exception handling benefits.

-   XML Configuration: The user can use the
    SimpleMappingExceptionResolver bean in Spring's application file and
    map the exception.

94. **What is JCA in Java?**

JCA (Java Cryptography Architecture) in Java is a framework that
provides a platform and a set of architecture and application
programming interfaces (APIs) for implementing encryption and decryption
operations. Developers use JCA to integrate security features into their
applications. It facilitates the incorporation of third-party security
protocols and compliance with various security regulations.

JCA utilizes cryptographic techniques such as hash tables and encryption
message digests to enhance the security of Java applications.

95. **Explain JPA in Java.**

Java Persistence API is one possible way to create a persistence layer
for desktop and web applications. Java Persistence deals in the
following:

-   Java Persistence API

-   Query Language

-   Java Persistence Criteria API

-   Object Mapping Metadata

96. **Explain the different authentications in Java Servlets.**

Java Servlets provide several authentication options:

-   Basic Authentication: Usernames and passwords are provided by the
    client to authenticate the user.

-   Form-Based Authentication: Programmers create a login form using
    HTML.

-   Digest Authentication: Similar to basic authentication, but
    passwords are encrypted using a Hash formula, making it more secure.

-   Client Certificate Authentication: Requires each client to have a
    certificate, which it sends to authenticate itself. Typically used
    with the SSL protocol for added security.

97. **Explain FailFast iterator and FailSafe iterator along with
    examples for each.**

FailFast and FailSafe iterators are used in Java Collections.

FailFast iterators do not allow changes to the collection while
iterating. If an element is added or removed during iteration, they
throw a ConcurrentModificationException.

Example: ArrayList, HashMap

On the contrary, FailSafe iterators allow modifications to the
collection. They operate on a cloned copy of the collection, so no
exceptions are thrown even if the collection is modified during
iteration.

Example: CopyOnWriteArrayList

98. **How do we reverse a string?**

public class Main

{

\>public static void main(String\[\] args) {

\>\>String toReverse = \"This is an example.\";

\>\>StringBuilder reversed = new StringBuilder();

\>\>for (int i = toReverse.length() - 1; i \>= 0; i\--) {

\>\>\>reversed.append(toReverse.charAt(i));

\>\>}

\>\>System.out.println(\"The string is reversed: \" +
reversed.toString());

\>}

}

99. **Write a program that detects the duplicate characters in a
    string.**

public class Main {

\>public static void main(String\[\] args) {

\>\>String toDetect = \"We are looking for duplicates here\";

\>\>Map\<Character, Boolean\> chars = new HashMap\<\>();

\>\>for (int i = 0; i \< toDetect.length(); i++) {

\>\>\>char current = Character.toLowerCase(toDetect.charAt(i));

\>\>\>if (chars.containsKey(current)) {

\>\>\>\>chars.replace(current, true);

\>\>\>} else {

\>\>\>\>chars.put(current, false);

\>\>\>}

\>\>}

\>\>System.out.print(\"Duplicated characters are: \");

\>\>for (Entry\<Character, Boolean\> e : chars.entrySet()) {

\>\>\>if (e.getValue()) {

\>\>\>\>System.out.print(e.getKey() + \" \");

\>\>\>}

\>\>}

\>}

}

100. **Write a Program to remove duplicates in an ArrayList.**

public class Main{

\>public static void main(String args\[\]) {

\>\>List\<Integer\> num = new ArrayList\<Integer\>();

\>\>num.add(1);

\>\>num.add(2);

\>\>num.add(3);

\>\>num.add(4);

\>\>num.add(5);

\>\>num.add(6);

\>\>num.add(3);

\>\>num.add(4);

\>\>num.add(5);

\>\>num.add(6);

\>\>System.out.println(\"Your list of elements in ArrayList : \" + num);

\>\>Set\<Integer\> primesWithoutDuplicates = new
LinkedHashSet\<Integer\>(num);

\>\>num.clear();

\>\>num.addAll(primesWithoutDuplicates);

\>\>System.out.println(\"list of original numbers without duplication:
\" + num);

\>}

}

101. **Find the word count in a string using HashMap Collection.**

public class Main {

\>public static void main(String\[\] args) {

\>\>String str = \"Counting words in this string\";

\>\>String\[\] split = str.toLowerCase().split(\" \");

\>\>HashMap\<String, Integer\> map = new HashMap\<String, Integer\>();

\>\>for (int i = 0; i \< split.length; i++) {

\>\>\>if (map.containsKey(split\[i\])) {

\>\>\>\>int count = map.get(split\[i\]);

\>\>\>\>map.put(split\[i\], count + 1);

\>\>\>} else {

\>\>\>\>map.put(split\[i\], 1);

\>\>\>}

\>\>}

\>\>System.out.println(map);

\>}

}

102. **Write a program to find the Second Highest number in an
     ArrayList**

public class Main {

\>public static void main(String\[\] args) {

\>\>int array\[\] = { 1, 2, 3, 4, 11, 12, 13, 14, 21, 22, 23, 24, 31,
32};

\>\>int high = array\[0\];

\>\>int nextHigh = array\[0\];

\>\>for (int i = 0; i \< array.length; i++) {

\>\>\>if (array\[i\] \> high) {

\>\>\>\>nextHigh = high;

\>\>\>\>high = array\[i\];

\>\>\>}

\>\>\>else if (array\[i\] \> nextHigh) {

\>\>\>\>nextHigh = array\[i\];

\>\>\>}

\>\>}

\>\>System.out.println(\"Second Highest is: \" + nextHigh);

\>\>System.out.println(\"Highest Number is: \" + high);

\>}

}

103. **What is the difference between System.out, System.err, and
     System.in?**

Both System.out and System.err are used to print text on the console,
System.out writes to the standard output and System.err writes to
standard error output. (The differentiation is useful e.g. when
redirecting the output.) System.in represents the standard input as an
InputStream object, which, as the name implies, is used to input text.

104. **Could you provide an implementation for a Dictionary with a large
     number of words?**

The simplest implementation is to use a List where you can store words
in order and perform binary searches. Another implementation with better
search performance is to use a HashMap, where the key is the first
character of the word, and the value is a LinkedList.

105. **What do you understand by an instance variable and a local
     variable?**

Generally, by instance variables we mean the class level variables,
while local variables are inside a block of code, where their scope
ends, as they aren't available from the outside.

106. **Comment on method overloading and overriding by citing relevant
     examples.**

Method overloading occurs during the compile time, whereas method
overriding occurs during the run time. Static binding is used during
overloading, whereas dynamic binding is used during methods overriding.
In Java , method overloading is made possible by introducing different
methods in the same class consisting of the same name. Still, all the
functions differ in the number or type of parameters. It takes place
inside a class and enhances program readability. The only difference in
the return type of the method does not promote method overloading.

![](image30.png){width="6.5in" height="4.517361111111111in"}

Method overriding is the concept in which two methods having the same
method signature are present in two different classes in which an
inheritance relationship is present. A particular method implementation
(already present in the base class) is possible for the derived class by
using method overriding.

![](image31.png){width="6.5in" height="4.272916666666666in"}

//Function overloading

//function1

void addPodium(int a, int b) {

\>System.out.println(a + b);

}

//function2

float addPodium(float a, float b, float c) {

\>System.out.println(a + b + c);

}

//Function overriding

class Parent {

\>void show() {

\>\>System.out.println(\"I am Parent\");

\>}

}

class Child extends Parent {

\>void show() {

\>\>System.out.println(\"I am Child\");

\>}

}

class Main {

\>public static void main(String\[\] args) {

\>\>Parent obja = new Parent();

\>\>obja.show();

\>\>Parent objb = new Child();

\>\>objb.show();

\>}

}

Using the \@Override annotation is not necessary but it can be really
helpful as we will get a compile-time error if we made a mistake.

107. **A single try block and multiple catch blocks can co-exist in a
     Java Program. Explain.**

That's because a code inside a try block might be able to throw multiple
types of exceptions and we would like to handle them differently. See
this example:

public class Example {

\>public static void main(String args\[\]) {

\>\>try {

\>\>\>int a\[\] = new int\[10\];

\>\>\>a\[10\] = 10 / 0;

\>\>} catch (ArithmeticException e) {

\>\>\>System.out.println(\"Arithmetic exception in first catch block\");

\>\>} catch (ArrayIndexOutOfBoundsException e) {

\>\>\>System.out.println(\"Array index out of bounds in second catch
block\");

\>\>} catch (Exception e) {

\>\>\>System.out.println(\"Any exception in third catch block\");

\>\>}

\>}

}

108. **Do final, finally and finalize keywords have the same function?**

All three keywords have their own utility while programming.

Final: If any restriction is required for classes, variables, or
methods, the final keyword comes in handy. Inheritance of a final class
and overriding of a final method is restricted by the use of the final
keyword. The variable value becomes fixed after incorporating the final
keyword. Example:

final int a=100;

a = 0; // error

The second statement will throw an error.

Finally: It is the block present in a program where all the codes
written inside it get executed irrespective of handling of exceptions.
Example:

try {

int variable = 5;

}

catch (Exception exception) {

System.out.println(\"Exception occurred\");

}

finally {

System.out.println(\"Execution of finally block\");

}

Finalize: Prior to the garbage collection of an object, the finalize
method is called so that the clean-up activity is implemented. Example:

public static void main(String\[\] args) {

String example = new String(\"InterviewBit\");

example = null;

System.gc(); // Garbage collector called

}

public void finalize() {

// Finalize called

![](image32.png){width="6.5in"
height="2.3680555555555554in"}

109. **When can you use the \"super\" keyword?**

You can use super in a descendant class, where super refers to the
ancestor class's methods and variables.

110. **What are shallow copy and deep copy in Java?**

To copy the object\'s data, we have several methods like deep copy and
shallow copy.

Example:

class Rectangle{

int length = 5;

\> int breadth = 3;

}

Object for this Rectangle class - Rectangle obj1 = new Rectangle();

Shallow copy - The shallow copy only creates a new reference and points
to the same object. Example: for Shallow copy, we can do this by:

Rectangle obj2 = obj1;

Now by doing this what will happen is the new reference is created with
the name obj2 and that will point to the same memory location.

Deep Copy - In a deep copy, we create a new object and copy the old
object value to the new object. Example:

Rectangle obj3 = new Rectangle();

Obj3.length = obj1.length;

Obj3.breadth = obj1.breadth;

Both these objects will point to the memory location as stated below:

![](image33.png){width="6.5in" height="3.825in"}

111. **Using relevant properties highlight the differences between
     interfaces and abstract classes.**

![](image34.png){width="6.5in" height="7.551388888888889in"}

112. **What are the different ways of thread usage?**

> There are two ways to create a thread:

-   Extending Thread class

    -   This creates a thread by creating an instance of a new class
        that extends the Thread class. The extending class must override
        the run() function, which is the thread's entry point.

-   Implementing Runnable interface

    -   This is the easiest way to create a thread, by creating a class
        that implements the runnable interface. After implementing the
        runnable interface, the class must implement the public void
        run() method ()

> The run() method creates a parallel thread in your programme. When
> run() returns, the thread will come to an end.
>
> Within the run() method, you must specify the thread's code.
>
> Like any other method, the run() method can call other methods, use
> other classes, and define variables.

113. **What is the difference between the 'throw\' and 'throws\' keyword
     in Java?**

The 'throw' keyword is used to manually throw the exception to the
calling method.

And the 'throws' keyword is used in the function definition to inform
the calling method that this method throws the exception. So if you are
calling, then you have to handle the exception.

Example:

class Main {

public static int testExceptionDivide(int a, int b) throws
ArithmeticException{

\> if(a == 0 \|\| b == 0)

\>\> throw new ArithmeticException();

\> return a/b;

}

public static void main(String args\[\]) {

\> try{

\>\> testExceptionDivide(10, 0);

\> }

\> catch(ArithmeticException e){

\>\> //Handle the exception

\> }

}

}

Here in the above snippet, the method testExceptionDivide throws an
exception. So if the main method is calling it then it must have handled
the exception. Otherwise, the main method can also throw the exception
to JVM.

And the method testExceptionDivide \'throws' the exception based on the
condition.

![](image35.png){width="6.5in" height="3.838888888888889in"}

114. **Java works as a "pass by value" or "pass by reference"
     phenomenon?**

Java always works as a "pass by value". There is nothing called a "pass
by reference" in Java. However, when the object is passed in any method,
the address of the value is passed due to the nature of object handling
in Java. When an object is passed, a copy of the reference is created by
Java and that is passed to the method. The objects point to the same
memory location. 2 cases might happen inside the method:

Case 1: When the object is pointed to another location: In this case,
the changes made to that object do not get reflected the original object
before it was passed to the method as the reference points to another
location.

For example:

class InterviewBitTest {

int num;

InterviewBitTest(int x) {

\> num = x;

}

InterviewBitTest() {

\> num = 0;

}

}

class Driver {

public static void main(String\[\] args) {

\> //create a reference

\> InterviewBitTest ibTestObj = new InterviewBitTest(20);

\> //Pass the reference to updateObject Method

\> updateObject(ibTestObj);

\> //After the updateObject is executed, check for the value of num in
the object.

\> System.out.println(ibTestObj.num);

}

public static void updateObject(InterviewBitTest ibObj) {

\> // Point the object to new reference

\> ibObj = new InterviewBitTest();

\> // Update the value

\> ibObj.num = 50;

}

}

Output:

20

Case 2: When object references are not modified: In this case, since we
have the copy of reference the main object pointing to the same memory
location, any changes in the content of the object get reflected in the
original object.

For example:

class InterviewBitTest {

int num;

InterviewBitTest(int x) {

\> num = x;

}

InterviewBitTest() {

\> num = 0;

}

}

class Driver {

public static void main(String\[\] args) {

\> //create a reference

\> InterviewBitTest ibTestObj = new InterviewBitTest(20);

\> //Pass the reference to updateObject Method

\> updateObject(ibTestObj);

\> //After the updateObject is executed, check for the value of num in
the object.

\> System.out.println(ibTestObj.num);

}

public static void updateObject(InterviewBitTest ibObj) {

\> // no changes are made to point the ibObj to new location

\> // Update the value of num

\> ibObj.num = 50;

}

}

Output:

50

115. **How to not allow serialization of attributes of a class in
     Java?**

One approach to not allow serialization of attributes of a class in Java
is by using writeObject() and readObject() methods in the subclass and
throwing a not Serializable exception.

Other, probably better approach is the following:

In order to achieve this, the attribute can be declared along with the
usage of transient keyword as shown below:

public class InterviewBitExample {

private transient String someInfo;

private String name;

private int id;

// :

// Getters setters

// :

}

In the above example, all the fields except someInfo can be serialized.

116. **What are the default values assigned to variables and instances
     in Java?**

By default for the wrapper classes, for a numerical value it is 0, for
the boolean value it is false and for objects it is NULL. However,
leaving a primitive type uninitialized leads to a compilation time
error.

117. **What do you mean by data encapsulation?**

Data encapsulation is one of the properties of OOP concepts, where all
the data such as variables and methods are enclosed together as a single
unit. It helps developers to follow modularity while developing software
by ensuring that each object is independent of other objects by having
its own methods, attributes, and functionalities. It is used for the
security of the private properties of an object and hence serves the
purpose of data hiding.

We can achieve encapsulation in Java by:

-   Declaring the variables of a class as private.

-   Providing public setter and getter methods to modify and view the
    values of the variables.

118. **Can you tell the difference between equals() method and equality
     operator (==) in Java?**

In the case of objects, == checks the memory reference, while equals()
checks the value/contenth of the objects. In order to understand this
better, let's consider this with the example:

String str1 = \"InterviewBit\";

String str2 = \"InterviewBit\";

System.out.println(str1 == str2);

This code will print true. We know that both strings are equals so it
will print true. But here (==) Operators don't compare each character in
this case. It compares the memory location. And because the string uses
the constant pool for storing the values in the memory, both str1 and
str2 are stored at the same memory location.

![](image36.png){width="6.5in" height="4.199305555555555in"}

Now, if we modify the program a little bit with:

String str1 = new String(\"InterviewBit\");

String str2 = \"InterviewBit\";

System.out.println(str1 == str2);

![](image37.png){width="6.5in"
height="7.1722222222222225in"}

Then in this case, it will print false. Because here no longer the
constant pool concepts are used. Here, new memory is allocated. So here
the memory address is different, therefore ( == ) Operator returns
false. But the twist is that the values are the same in both strings. So
how to compare the values? Here the .equals() method is used.

.equals() method compares the values and returns the result accordingly.
If we modify the above code with:

System.out.println(str1.equals(str2));

Then it returns true.

![](image38.png){width="6.5in"
height="3.7645833333333334in"}

Note:

-   In the cases where the equals method is not overridden in a class,
    then the class uses the default implementation of the equals method
    that is closest to the parent class.

-   Object class is considered as the parent class of all the java
    classes. The implementation of the equals method in the Object class
    uses the == operator to compare two objects. This default
    implementation can be overridden as per the business logic.

119. **Explain the use of the final keyword in variable, method and
     class.**

With a variable, its value can't be changed, with a method, it can't be
overridden (not even in descendant classes) and with a class, it can't
have any descendants. Constructors cannot be marked as final.

120. **Is it possible that the 'finally\' block will not be executed? If
     yes then list the case.**

Yes, it's possible. Some examples are if the JVM crashes, the program
runs into a fatal error or if we explicitly interrupt the run of the
program with System.exit().

Here is an example:

public int someMethod(int i){

try{

\> //some statement

\> return 1;

}catch(Exception e){

\> //some statement

\> return 999;

}finally{

\> //finally block statements

}

}

finally block will be executed irrespective of the exception or not. The
only case where finally block is not executed is when it encounters
'System.exit()' method anywhere in try/catch block.

121. **Difference between static methods, static variables, and static
     classes in Java.**

-   Static Methods and Static variables are those methods and variables
    that belong to the class of the java program, not to the object of
    the class. This gets memory where the class is loaded. And these can
    directly be called with the help of class names.

    -   For example - We have used mathematical functions in the java
        program like - max(), min(), sqrt(), pow(), etc. And if we
        notice that, then we will find that we call it directly with the
        class name. Like - Math.max(), Math.min(), etc. So that is a
        static method. And Similarly static variables we have used like
        (length) for the array to get the length. So that is the static
        method.

-   Static classes - A class in the java program cannot be static except
    if it is the inner class. If it is an inner static class, then it
    exactly works like other static members of the class.

122. **What is the main objective of garbage collection?**

The main goal of using garbage collection is to free the heap memory by
eliminating unnecessary objects, which have no references to them. This
ensures that the memory resource is used efficiently, but it provides no
guarantee that there would be sufficient memory for the program
execution.

123. **Apart from the security aspect, what are the reasons behind
     making strings immutable in Java?**

-   String Pool: Designers of Java were aware of the fact that String
    data type is going to be majorly used by the programmers and
    developers. Thus, they wanted optimization from the beginning. They
    came up with the notion of using the String pool (a storage area in
    Java heap) to store the String literals. They intended to decrease
    the temporary String object with the help of sharing. An immutable
    class is needed to facilitate sharing. The sharing of the mutable
    structures between two unknown parties is not possible. Thus,
    immutable Java String helps in executing the concept of String Pool.

![](image39.png){width="6.5in" height="3.904166666666667in"}

-   Multithreading: The safety of threads regarding the String objects
    is an important aspect in Java. No external synchronization is
    required if the String objects are immutable. Thus, a cleaner code
    can be written for sharing the String objects across different
    threads. The complex process of concurrency is facilitated by this
    method.

-   Collections: In the case of Hashtables and HashMaps, keys are String
    objects. If the String objects are not immutable, then it can get
    modified during the period when it resides in the HashMaps.
    Consequently, the retrieval of the desired data is not possible.
    Such changing states pose a lot of risks. Therefore, it is quite
    safe to make the string immutable.

-   Java uses the concept of the string literal. Suppose there are five
    reference variables, all refer to one object \"sachin\". If one
    reference variable changes the value of the object, it will be
    affected by all the reference variables. That is why string objects
    are immutable in java.

![Heap diagram](image40.jpeg){width="6.5in"
height="5.350694444444445in"}

124. **Which of the below generates a compile-time error? State the
     reason.**

int\[\] n1 = new int\[0\];

boolean\[\] n2 = new boolean\[-200\];

double\[\] n3 = new double\[2241423798\];

char\[\] ch = new char\[20\];

n3 will give a compile time error, because array sizes are in int and
that number is bigger than what an integer can store. Other than that,
n2 will give a runtime exception of NegativeArraySizeException. The
reason because it doesn't give a compile-time error is that JVM will try
to allocate the memory area in runtime, and that's when it notices the
negative integer. Also, an integer too big can't happen during runtime,
so we can check that during the compilation, meanwhile the size of an
array can be decided during runtime, which means a compile-time can't
filter out these cases.

125. **How would you differentiate between a String, StringBuffer, and a
     StringBuilder?**

The String class is immutable, whereas the other two are mutable in
nature. StringBuffer is synchronous, meaning it is thread-safe, whereas
StringBuilder is asynchronous, which means it is not thread-safe. String
uses the string pool as memory storage for string literals, whereas the
other two use the heap memory for storage purposes. StringBuilder is the
fastest in performing operations. The speed of a StringBuffer is more
than a String and less than a StringBuilder. (For example appending a
character is fastest in StringBuilder and very slow in String because a
new memory is required for the new String with appended character.)

![](image41.png){width="6.5in"
height="2.7743055555555554in"}

![](image42.png){width="6.5in"
height="2.3777777777777778in"}

![](image43.png){width="6.5in"
height="1.6895833333333334in"}

126. **What is a Comparator in Java?**

Consider the example where we have an ArrayList of employees like( EId,
Ename, Salary), etc. Now if we want to sort this list of employees based
on the names of employees. Then that is not possible to sort using the
Collections.sort() method. We need to provide something to the sort()
function depending on what values we have to perform sorting. Then in
that case a comparator is used.

A comparator is an interface, which makes it possible to compare two
objects, mostly used for sorting.

127. **In Java, overriding static methods is not possible, but private
     method overriding is possible. Comment on the statement.**

In Java, you cannot override a static method. However, you can override
a private method in a subclass if you create a similar method with the
same return type and method arguments; this is known as method hiding.
It\'s important to note that private methods are not directly accessible
in a subclass, so you\'re essentially creating a new method with the
same name and signature in the subclass. About overriding static
methods, declaration of static methods having the same signature can be
done in the subclass but run time polymorphism cannot take place in such
cases. Overriding or dynamic polymorphism occurs during the runtime, but
the static methods are loaded and looked up at the compile time
statically. Hence, these methods can't be overridden.

128. **What makes a HashSet different from a TreeSet?**

Although both HashSet and TreeSet are not synchronized and ensure that
duplicates are not present, there are certain properties that
distinguish a HashSet from a TreeSet.

-   Implementation: For a HashSet, the hash table is utilized for
    storing the elements in an unordered manner. However, TreeSet makes
    use of the red-black tree to store the elements in a sorted manner.

-   Complexity/ Performance: For adding, retrieving, and deleting
    elements, the time amortized complexity is O(1) for a HashSet. The
    time complexity for performing the same operations is a bit higher
    for TreeSet and is equal to O(log n). Overall, the performance of
    HashSet is faster in comparison to TreeSet.

-   Methods: hashCode() and equals() are the methods utilized by HashSet
    for making comparisons between the objects. Conversely, compareTo()
    and compare() methods are utilized by TreeSet to facilitate object
    comparisons.

-   Objects type: Heterogeneous and null objects can be stored with the
    help of HashSet. In the case of a TreeSet, runtime exception occurs
    while inserting heterogeneous objects or null objects.

129. **Why is the character array preferred over string for storing
     confidential information?**

In Java, a string is basically immutable i.e. it cannot be modified.
After its declaration, it continues to stay in the string pool as long
as it is not removed in the form of garbage. In other words, a string
resides in the heap section of the memory for an unregulated and
unspecified time interval after string value processing is executed.

As a result, vital information can be stolen for pursuing harmful
activities by hackers if a memory dump is illegally accessed by them.
Such risks can be eliminated by using mutable objects or structures like
character arrays for storing any variable. After the work of the
character array variable is done, the variable can be configured to
blank at the same instant. Consequently, it helps in saving heap memory
and also gives no chance to the hackers to extract vital data.

130. **What are the differences between HashMap and HashTable in Java?**

![](image44.png){width="6.5in"
height="1.4513888888888888in"}

131. **What is the importance of reflection in Java?**

-   The term reflection is used for describing the inspection capability
    of a code on other code either of itself or of its system and modify
    it during runtime.

-   Consider an example where we have an object of unknown type and we
    have a method 'fooBar()' which we need to call on the object. The
    static typing system of Java doesn\'t allow this method invocation
    unless the type of the object is known beforehand. This can be
    achieved using reflection which allows the code to scan the object
    and identify if it has any method called "fooBar()" and only then
    call the method if needed.

Method methodOfFoo = fooObject.getClass().getMethod(\"fooBar\", null);

methodOfFoo.invoke(fooObject, null);

-   Using reflection has its own cons:

    -   Speed --- Method invocations due to reflection are about three
        times slower than the direct method calls.

    -   Type safety --- When a method is invoked via its reference
        wrongly using reflection, invocation fails at runtime as it is
        not detected at compile/load time.

    -   Traceability --- Whenever a reflective method fails, it is very
        difficult to find the root cause of this failure due to a huge
        stack trace. One has to deep dive into the invoke() and proxy()
        method logs to identify the root cause.

-   Hence, it is advisable to follow solutions that don\'t involve
    reflection and use this method as a last resort.

Reflection is the process of examining or modifying the runtime behavior
of a class at runtime. The java.lang.Class class provides various
methods that can be used to get metadata, examine and change the runtime
behavior of a class. The java.lang and java.lang.reflect packages
provide classes for java reflection. It is used in:

-   IDE (Integrated Development Environment), e.g., Eclipse, MyEclipse,
    NetBeans.

-   Debugger

-   Test Tools, etc.

132. **What are the different types of Thread Priorities in Java? And
     what is the default priority of a thread assigned by JVM?**

There are a total of 3 different types of priority available in Java.

-   MIN_PRIORITY: It has an integer value assigned with 1.

-   MAX_PRIORITY: It has an integer value assigned with 10.

-   NORM_PRIORITY: It has an integer value assigned with 5.

In Java, Thread with MAX_PRIORITY gets the first chance to execute. But
the default priority for any thread is NORM_PRIORITY assigned by JVM.
Also, besides these predefined values, assigning a number between 1 and
10 by hand as a priority will also work.

133. **What is the 'IS-A' relationship in OOPs Java?**

'IS-A' relationship is another name for inheritance. When we inherit the
base class from the derived class, then it forms a relationship between
the classes. So that relationship is termed an 'IS-A' Relationship.

Example: Consider a Television (Typical CRT TV). Now another Smart TV
that is inherited from television class. So we can say that the Smart iv
is also a TV. Because CRT TV things can also be done in the Smart TV.

![](image45.png){width="6.5in"
height="2.8194444444444446in"}

So here 'IS-A' Relationship formed. \[ SmartTV 'IS-A' TV \].

134. Example - Consider a Television (Typical CRT TV). Now another Smart
     TV that is inherited from television class. So we can say that the
     Smart iv is also a TV. Because CRT TV things can also be done in
     the Smart TV.**Why is Java, not a pure object-oriented language?**

It is not a pure object-oriented language because it supports primitive
data types like int, double, and char, which are not objects, and it
supports static methods and variables.

However, it's not wrong to call Java a completely object-oriented
language as the primitive data types have their respective wrapper
classes.

135. **Explain static variables with examples and a diagram.**

A static variable in Java is a variable that is associated with the
class rather than an instance of the class. This means that all
instances of the class share the same static variable. They are declared
using the static keyword.

public class Example {

\>static int count = 0;

\>public Example() {

\>\>count++;

\>}

}

136. **Explain static block**

Static block is used to initialize the static data member. It is
executed before the main method, at the time of classloading.

class A2 {

static {

System.out.println(\"static block is invoked\");

}

public static void main(String args\[\]) {

System.out.println(\"Hello main\");

}

}

Test it Now

Output:

static block is invoked

Hello main

137. **How can constructor chaining be done using this keyword?**

Constructor chaining enables us to call one constructor from another
constructor of the class with respect to the current class object. We
can use this keyword to perform constructor chaining within the same
class. Consider the following example which illustrates how can we use
this keyword to achieve constructor chaining.

public class Employee {

\>int id,age;

\>String name, address;

\>public Employee (int age) {

\>\>this.age = age;

\>}

\>public Employee(int id, int age) {

\>\>this(age);

\>\>this.id = id;

\>}

\>public Employee(int id, int age, String name, String address) {

\>\>this(id, age);

\>\>this.name = name;

\>\>this.address = address;

\>}

\>public static void main (String args\[\]) {

\>\>Employee emp = new Employee(105, 22, \"Vikas\", \"Delhi\");

\>\>System.out.println(\"ID: \"+emp.id+\" Name:\"+emp.name+\"
age:\"+emp.age+\" address: \"+emp.address);

\>}

}

Output

ID: 105 Name:Vikas age:22 address: Delhi

138. **Why are multiple inheritances not supported in Java?**

To reduce the complexity and simplify the language, multiple inheritance
is not supported in java. Consider a scenario where A, B, and C are
three classes. The C class inherits A and B classes. If A and B classes
have the same method and you call it from child class object, there will
be ambiguity to call the method of A or B class.

Since the compile-time errors are better than runtime errors, Java
renders compile-time error if you inherit 2 classes. So whether you have
the same method or different, there will be a compile time error.

class A {

\>void msg(){System.out.println(\"Hello\");}

}

class B {

\>void msg(){System.out.println(\"Welcome\");}

}

class C extends A,B{//suppose if it were

\>Public Static void main(String args\[\]){

\> C obj=new C();

\> obj.msg();//Now which msg() method would be invoked?

\>}

}

Output

Compile Time Error

139. **Why is method overloading not possible by changing the return
     type in Java?**

In Java, method overloading is not possible by changing the return type
of the program due to avoid the ambiguity.

class Adder {

\>static int add(int a, int b) {

\>\>return a + b;

\>}

\>static double add(int a, int b) {

\>\>return a + b;

\>}

}

class TestOverloading3 {

\>public static void main(String\[\] args) {

\>\>System.out.println(Adder.add(11, 11)); //ambiguity

\>}

}

Output:

Compile Time Error: method add(int, int) is already defined in class
Adder

140. **What is method overloading with type promotion?**

By Type promotion is method overloading, we mean that one data type can
be promoted to another implicitly if no exact matching is found.

![Java Method Overloading with Type
Promotion](image46.png){width="6.25in"
height="4.689583333333333in"}

As displayed in the above diagram, the byte can be promoted to short,
int, long, float or double. The short datatype can be promoted to int,
long, float or double. The char datatype can be promoted to int, long,
float or double and so on. Consider the following example.

class OverloadingCalculation1 {

\>void sum(int a, long b) {

\>\>System.out.println(a + b);

\>}

\>void sum(int a, int b, int c) {

\>\>System.out.println(a + b + c);

\>}

\>public static void main(String args\[\]) {

\>\>OverloadingCalculation1 obj = new OverloadingCalculation1();

\>\>obj.sum(20, 20); //now second int literal will be promoted to long

\>\>obj.sum(20, 20, 20);

\>}

}

Output

40

60

141. **Can we change the scope of the overridden method in the
     subclass?**

No, we cannot change the scope of the overridden method in the subclass.

142. **Can you have virtual functions in Java?**

In Java, all non-static methods are virtual functions by default.

143. **What is the covariant return type?**

Now, since java5, it is possible to override any method by changing the
return type if the return type of the subclass overriding method is
subclass type. It is known as covariant return type. The covariant
return type specifies that the return type may vary in the same
direction as the subclass.

class A {

\>A get() {

\>\>return this;

\>}

}

class B1 extends A {

\>B1 get() {

\>\>return this;

\>}

\>void message() {

\>\>System.out.println(\"welcome to covariant return type\");

\>}

\>public static void main(String args\[\]) {

\>\>new B1().get().message();

\>}

}

Output: welcome to covariant return type

144. **Difference between the final method and the abstract method**

The main difference between a final method and an abstract method in
Java is that a final method cannot be overridden in a subclass, while an
abstract method must be overridden in a subclass.

[Core Java Interview Questions and Answers (2023) -
InterviewBit](https://www.interviewbit.com/java-interview-questions/#instance-variables-and-local-variables-in-java)

145. **What do you understand about an instance variable and a local
     variable?**

Instance variables and local variables are two types of variables in
Java. Instance variables are declared inside a class but outside any
method. They are used to store data that is specific to an object and
are accessible from any method of the given class. Local variables, on
the other hand, are declared inside a method or a code block and are
used to store temporary data that is required only within that method.

In Java, a local variable is typically used inside a method,
constructor, or a block and has only local scope. Thus, this variable
can be used only within the scope of a block. The best benefit of having
a local variable is that other methods in the class won't be even aware
of that variable.

Example

if(x \> 100) {

\>String test = \"Edureka\";

}

Whereas, an instance variable in Java, is a variable which is bounded to
its object itself. These variables are declared within a class, but
outside a method. Every object of that class will create it's own copy
of the variable while using it. Thus, any changes made to the variable
won't reflect in any other instances of that class and will be bound to
that particular instance only.

class Test {

\>public String EmpName;

\>public int empAge;

}

146. **How is an infinite loop declared in Java?**

Infinite loops are those loops that run infinitely without any breaking
conditions. Some examples of consciously declaring infinite loop is:

Using For Loop:

for (;;)

{

// Business logic

// Any break logic

}

Using while loop:

while(true){

// Business logic

// Any break logic

}

Using do-while loop:

do{

// Business logic

// Any break logic

}while(true);

147. **Briefly explain the concept of constructor overloading**

Constructor overloading is the process of creating multiple constructors
in the class consisting of the same name with a difference in the
constructor parameters. Depending upon the number of parameters and
their corresponding types, distinguishing of the different types of
constructors is done by the compiler.

![](image47.png){width="6.5in" height="4.445138888888889in"}

Three constructors are defined here but they differ on the basis of
parameter type and their numbers. There is no limit regarding the number
of created constructors.

148. **Can the main method be Overloaded?**

Yes, It is possible to overload the main method. We can create as many
overloaded main methods we want. However, JVM has a predefined calling
method that JVM will only call the main method with the definition of:

public static void main(string\[\] args)

Consider the below code snippets:

class Main {

\>public static void main(String args\[\]) {

\>\>System.out.println(\" Main Method\");

\>}

\>public static void main(int\[\] args){

\>\>System.out.println(\"Overloaded Integer array Main Method\");

\>}

\>public static void main(char\[\] args){

\>\>System.out.println(\"Overloaded Character array Main Method\");

\>}

\>public static void main(double\[\] args){

\>\>System.out.println(\"Overloaded Double array Main Method\");

\>}

\>public static void main(float args){

\>\>System.out.println(\"Overloaded float Main Method\");

\>}

}

149. **Identify the output of the java program and state the reason.**

1\. public class InterviewBit

2\. {

3.\> public static void main(String\[\] args) {

4.\> \> final int i;

5.\>\> i = 20;

6.\>\> int j = i+20;

7.\>\> i = j+30;

8.\>\> System.out.println(i + \" \" + j);

9.\> }

10\. }

The above code will generate a compile-time error at Line 7 saying -
\[error: variable i might already have been initialized\]. It is because
variable 'i' is the final variable. And final variables are allowed to
be initialized only once, and that was already done on line no 5.

150. **When can you use super keyword?**

-   The super keyword is used to access hidden fields and overridden
    methods or attributes of the parent class.

-   Following are the cases when this keyword can be used:

    -   Accessing data members of parent class when the member names of
        the class and its child subclasses are same.

    -   To call the default and parameterized constructor of the parent
        class inside the child class.

    -   Accessing the parent class methods when the child classes have
        overridden them.

151. **Is this program giving a compile-time error? If Yes then state
     the reason and number of errors it will give. If not then state the
     reason.**

abstract final class InterviewBit {

\>public abstract void printMessage();

}

class ScalarAcademy extends InterviewBit {

\>public void printMessage() {

\>\>System.out.println(\"Welcome to Scalar Academy By InterviewBit\");

\>}

}

class ScalarTopics extends ScalarAcademy {

\>public void printMessage() {

\>\>System.out.println(\"Welcome to Scalar Topics By Scalar Academy\");

\>}

}

public class Main {

\>public static void main(String\[\] args) {

\>\>InterviewBit ib = new ScalarTopics();

\>\>ib.printMessage();

\>}

}

The above program will give a compile-time error. The compiler will
throw 2 errors in this.

-   \[Illegal Combination of modifiers: abstract and final\] at line 1.

-   \[Cannot inherit from final 'InterviewBit'\] at line 4.

It is because abstract classes are incomplete classes that need to be
inherited for making their concrete classes. And on the other hand, the
final keywords in class are used for avoiding inheritance. So these
combinations are not allowed in Java.

152. **What do we get in the JDK file?**

JDK: For making java programs, we need some tools that are provided by
JDK (Java Development Kit). JDK is the package that contains various
tools, Compiler, Java Runtime Environment, etc.

JRE: To execute the java program we need an environment. (Java Runtime
Environment) JRE contains a library of Java classes + JVM. What are JAVA
Classes? It contains some predefined methods that help Java programs to
use that feature, build and execute. For example - there is a system
class in java that contains the print-stream method, and with the help
of this, we can print something on the console.

JVM: (Java Virtual Machine) JVM is a part of JRE that executes the Java
program at the end. Actually, it is part of JRE, but it is software that
converts bytecode into machine-executable code to execute on hardware.

![](image48.png){width="6.5in" height="3.257963692038495in"}

153. **What are the differences between JVM, JRE and JDK in Java?**

![](image49.png){width="6.5in" height="3.75in"}

154. **Identify the output of the below java program and Justify your
     answer.**

class Main {

\>public static void main(String args\[\]) {

\>\>Scaler s = new Scaler(5);

\>}

}

class InterviewBit {

\>InterviewBit() {

\>\>System.out.println(\" Welcome to InterviewBit \");

\>}

}

class Scaler extends InterviewBit {

\>Scaler() {

\>\>System.out.println(\" Welcome to Scaler Academy \");

\>}

\>Scaler(int x) {

\>\>this();

\>\>super();

\>\>System.out.println(\" Welcome to Scaler Academy 2\");

\>}

}

The above code will throw the compilation error. It is because the
super() is used to call the parent class constructor. But there is the
condition that super() must be the first statement in the block. Now in
this case, if we replace this() with super() then also it will throw the
compilation error. Because this() also has to be the first statement in
the block. So in conclusion, we can say that we cannot use this() and
super() keywords in the same block.

155. **Which among String or String Buffer should be preferred when
     there are lot of updates required to be done in the data?**

StringBuffer is mutable and dynamic in nature whereas String is
immutable. Every updation / modification of String creates a new String
thereby overloading the string pool with unnecessary objects. Hence, in
the cases of a lot of updates, it is always preferred to use
StringBuffer as it will reduce the overhead of the creation of multiple
String objects in the string pool.

156. **Consider the below program, identify the output, and also state
     the reason for that.**

public class Main {

\>public static void main(String\[\] args) {

\>\>System.out.println(\" Hello. Main Method. \");

\>}

\>public static void main(int\[\] args) {

\>\>System.out.println(\" Hello. Main Method2. \");

\>}

}

The output of the above program will be Hello. Main Method. This is
because JVM will always call the main method based on the definition it
already has. Doesn\'t matter how many main methods we overload it will
only execute one main method based on its declaration in JVM. The main
method JVM starts is always the public static void one, with only a
String\[\] object as a parameter.

157. **Can we make the main() thread a daemon thread?**

In java multithreading, the main() threads are always non-daemon
threads. And there is no way we can change the nature of the non-daemon
thread to the daemon thread. If we tried with the following code
snippet, an IllegalThreadStateException would be thrown:

public static void main(String\[\] args) {

\>Thread current = Thread.currentThread();

\>current.setDaemon(true);

}

158. **What happens if there are multiple main methods inside one class
     in Java?**

If the signature is not the same, it wont be an issue, as it's just a
simple overloading, but if it's the same, the compiler will throw an
error, regardless if it's a main method or not.

159. **How do exceptions affect the program if it doesn\'t handle
     them?**

Exceptions are runtime errors. Suppose we are making an android
application with java. And it all works fine but there is an exceptional
case when the application tries to get the file from storage and the
file doesn't exist (This is the case of exception in java). And if this
case is not handled properly then the application will crash. This will
be a bad experience for users. This is the type of error that cannot be
controlled by the programmer. But programmers can take some steps to
avoid this so that the application won't crash. The proper action can be
taken at this step.

160. **Is it mandatory for a catch block to be followed after a try
     block?**

It is not necessary that each try block must be followed by a catch
block. It should be followed by either a catch block OR a finally block.
So whatever exceptions are likely to be thrown should be declared in the
throws clause of the method. Consider the following example.

public class Main {

\>public static void main(String\[\] args) {

\>\>try {

\>\>\>int a = 1;

\>\>\>System.out.println(a / 0);

\>\>} finally {

\>\>\>System.out.println(\"rest of the code\...\");

\>\>}

\>}

}

Output:

Exception in thread main java.lang.ArithmeticException:/ by zero

rest of the code\...

161. **Contiguous memory locations are usually used for storing actual
     values in an array but not in ArrayList. Explain.**

In the case of ArrayList, data storing in the form of primitive data
types (like int, float, etc.) is not possible. The data members/objects
present in the ArrayList have references to the objects which are
located at various sites in the memory. Thus, storing of actual objects
or non-primitive data types (like Integer, Double, etc.) takes place in
various memory locations.

![](image50.png){width="6.5in"
height="3.8847222222222224in"}

However, the same does not apply to the arrays. Object or primitive type
values can be stored in arrays in contiguous memory locations, hence
every element does not require any reference to the next element.

![](image51.png){width="6.5in"
height="3.8847222222222224in"}

162. **Although inheritance is a popular OOPs concept, it is less
     advantageous than composition. Explain.**

Inheritance lags behind composition in the following scenarios:

Multiple-inheritance is not possible in Java. Classes can only extend
from one superclass. In cases where multiple functionalities are
required, for example - to read and write information into the file, the
pattern of composition is preferred. The writer, as well as reader
functionalities, can be made use of by considering them as the private
members.

Composition assists in attaining high flexibility and prevents breaking
of encapsulation.

Unit testing is possible with composition and not inheritance. When a
developer wants to test a class composing a different class, then Mock
Object can be created for signifying the composed class to facilitate
testing. This technique is not possible with the help of inheritance as
the derived class cannot be tested without the help of the superclass in
inheritance.

The loosely coupled nature of composition is preferable over the tightly
coupled nature of inheritance.

Let's take an example:

package comparison;

public class Top {

public int start() {

\>return 0;

}

}

class Bottom extends Top {

\>public int stop() {

\>\>return 0;

\>}

}

In the above example, inheritance is followed. Now, some modifications
are done to the Top class like this:

public class Top {

\>public int start() {

\>\>return 0;

\>}

public void stop() {

\>}

}

If the new implementation of the Top class is followed, a compile-time
error is bound to occur in the Bottom class. Incompatible return type is
there for the Top.stop() function. Changes have to be made to either the
Top or the Bottom class to ensure compatibility. However, the
composition technique can be utilized to solve the given problem:

class Bottom {

\>Top par = new Top();

\>public int stop() {

\>\>par.start();

\>\>par.stop();

\>\>return 0;

\>}

}

163. **What are Composition and Aggregation? State the difference.**

Composition, and Aggregation help to build (Has - A - Relationship)
between classes and objects. But both are not the same in the end. Let's
understand with the help of an example.

-   Consider the University as a class that has some departments in it.
    So the university will be the container object. And departments in
    it will contain objects. Now in this case, if the container object
    destroys then the contained objects will also get destroyed
    automatically. So here we can say that there is a strong association
    between the objects. So this Strong Association is called
    Composition.

-   Now consider one more example. Suppose we have a class department
    and there are several professors\' objects there in the department.
    Now if the department class is destroyed then the professor\'s
    object will become free to bind with other objects. Because
    container objects (Department) only hold the references of contained
    objects (Professor's). So here is the weak association between the
    objects. And this weak association is called Aggregation.

164. **In the given code below, what is the significance of \... ?**

public void fooBarMethod(String\... variables){

// method code

}

-   Ability to provide \... is a feature called varargs (variable
    arguments) which was introduced as part of Java 5.

-   The function having \... in the above example indicates that it can
    receive multiple arguments of the datatype String.

-   For example, the fooBarMethod can be called in multiple ways and we
    can still have one method to process the data as shown below:

fooBarMethod(\"foo\", \"bar\");

fooBarMethod(\"foo\", \"bar\", \"boo\");

fooBarMethod(new String\[\]{\"foo\", \"var\", \"boo\"});

public void myMethod(String\... variables){

for(String variable : variables){

\> // business logic

}

}

165. **What will be the output of the below java program and define the
     steps of Execution of the java program with the help of the below
     code?**

class InterviewBit{

\>int i;

\>static int j;

\>{

\>\>System.out.println(\" Instance Block 1. Value of i = \"+i);

\>}

\>static{

\>\>System.out.println(\" Static Block 1. Value of j = \"+j);

\>\>method_2();

\>}

\>{

\>\>i = 5;

\>}

\>static{

\>\>j = 10;

\>}

\>InterviewBit(){

\>\>System.out.println(\" Welcome to InterviewBit \");

\>}

\>public static void main(String\[\] args){

\>\>InterviewBit ib = new InterviewBit();

\>}

\>public void method_1(){

\>\>System.out.println(\" Instance method. \");

\>}

\>static{

\>\>System.out.println(\" Static Block 2. Value of j = \"+j);

\>}

\>{

\>\>System.out.println(\" Instance Block 2. Value of i = \"+i);

\>\>method_1();

\>}

\>public static void method_2(){

\>\>System.out.println(\" Static method. \");

\>}

}

The Output we get by executing this program will be:

**Static Block 1. Value of j = 0**

**Static method.**

**Static Block 2. Value of j = 10**

**Instance Block 1. Value of i = 0**

**Instance Block 2. Value of i = 5**

**Instance method.**

**Welcome to InterviewBit**

This is a java tricky interview question frequently asked in java
interviews for the experienced. The output will be like this because,
when the java program is compiled and gets executed, then there are
various steps followed for execution. And the steps are -

-   Identification of Static Members from top to bottom.

-   Execution of Static variable assignment and a Static block from top
    to bottom.

-   Execution of the main method.

-   Identification of Instance Members from top to bottom.

-   Execution of Instance variable assignment and Instance block from
    top to bottom.

-   Execution of Constructor.

In above steps from 4 to 6, will be executed for every object creation.
If we create multiple objects then for every object these steps will be
performed.

Now from the above code, the execution will happen like this -

1\. In the step of identification of static members. It is found that -

-   static int j.

-   static block.

-   main method.

-   static method_2.

During identification, the JVM will assign the default value in the
static int j variable. Then it is currently in the state of reading and
indirectly writing. Because the original value is not assigned.

2\. In the next step, it will execute the static block and assign the
value in static variables.

-   First static block it will print and because execution from top to
    bottom and original value in j is not assigned. So it will print the
    default value of 0.

-   After executing static block 1. It will execute the static method_1
    because it is called from the static block 1.

-   Then it will assign the original value of 5 in the j variable. And
    executes the remaining static block.

3\. Now it will execute the main method. In which it will create an
object for the class InterviewBit. And then the execution of instances
will happen.

4\. Identify the instance variables and blocks from top to bottom.

-   int i.

-   Instance block 1.

-   Instance method_1.

Like a static variable, the instance variable also has been initialized
with the default value 0 and will be in the state of reading and writing
indirectly.

5\. It will execute the instance methods and assign the original value
to the instance variable.

-   Prints the Instance block 1. And the current value of i is not
    assigned till now, so it will print 0.

-   Assign the original value to i. Then print instance block 2. And
    after that instance method will be called and printed because it is
    being called in the instance block.

6\. And at the last step, the constructor will be invoked and the lines
will be executed in the constructor.

This is how the java program gets executed.

166. **What is the output of the below code and why?**

public class InterviewBit{

public static void main(String\[\] args)

{

\> System.out.println(\'b\' + \'i\' + \'t\');

}

}

"bit" would have been the result printed if the letters were used in
double-quotes (or the string literals). But the question has the
character literals (single quotes) being used which is why concatenation
wouldn\'t occur. The corresponding ASCII values of each character would
be added and the result of that sum would be printed.

The ASCII values of 'b', 'i', 't' are:

-   'b' = 98

-   'i' = 105

-   't' = 116

98 + 105 + 116 = 319

Hence 319 would be printed

167. **In the below Java Program, how many objects are eligible for
     garbage collection?**

class Main{

public static void main(String\[\] args){

\> int\[\]\[\] num = new int\[3\]\[\];

\> num\[0\] = new int\[5\];

\> num\[1\] = new int\[2\];

\> num\[2\] = new int\[3\];

\>

\> num\[2\] = new int\[5\];

\> num\[0\] = new int\[4\];

\> num\[1\] = new int\[3\];

\>

\> num = new int\[2\]\[\];

}

}

In the above program, a total of 7 objects will be eligible for garbage
collection. Let's visually understand what\'s happening in the code.

![](image52.png){width="6.5in" height="6.110416666666667in"}

![](image53.png){width="6.5in" height="3.811111111111111in"}

In the above figure on line 3, we can see that on each array index we
are declaring a new array so the reference will be of that new array on
all the 3 indexes. So the old array will be pointed to by none. So these
three are eligible for garbage collection. And on line 4, we are
creating a new array object on the older reference. So that will point
to a new array and older multidimensional objects will become eligible
for garbage collection.

168. **Check if a given string is palindrome using recursion.**

/\*

\* Java program to check if a given inputted string is palindrome or not
using recursion.

\*/

import java.util.\*;

public class InterviewBit {

public static void main(String args\[\]) {

\> Scanner s = new Scanner(System.in);

\> String word = s.nextLine();

\> System.out.println(\"Is \"+word+\" palindrome? -
\"+isWordPalindrome(word));

}

public static boolean isWordPalindrome(String word){

\> String reverseWord = getReverseWord(word);

\> //if word equals its reverse, then it is a palindrome

\> if(word.equals(reverseWord)){

\>\> return true;

\> }

\> return false;

}

public static String getReverseWord(String word){

\> if(word == null \|\| word.isEmpty()){

\>\> return word;

\> }

\>

\> return word.charAt(word.length()- 1) +
getReverseWord(word.substring(0, word.length() - 1));

}

}

[300 Core Java Interview Questions (2023) -
javatpoint](https://www.javatpoint.com/corejava-interview-questions)

169. **What do you understand by Java virtual machine?**

Java Virtual Machine is a virtual machine that enables the computer to
run the Java program. JVM acts like a run-time engine which calls the
main method present in the Java code. JVM is the specification which
must be implemented in the computer system. The Java code is compiled by
JVM to be a Bytecode which is machine independent and close to the
native code.

170. **What is the platform?**

A platform is the hardware or software environment in which a piece of
software is executed. There are two types of platforms, software-based
and hardware-based. Java provides the software-based platform.

171. **What are the main differences between the Java platform and other
     platforms?**

There are the following differences between the Java platform and other
platforms.

-   Java is the software-based platform whereas other platforms may be
    the hardware platforms or software-based platforms.

-   Java is executed on the top of other hardware platforms whereas
    other platforms can only have the hardware components.

172. **What gives Java its \'write once and run anywhere\' nature?**

The bytecode. Java compiler converts the Java programs into the class
file (Byte Code) which is the intermediate language between source code
and machine code. This bytecode is not platform specific and can be
executed on any computer.

173. **Is Empty .java file name a valid source file name?**

Yes, Java allows to save our java file by .java only, we need to compile
it by javac .java and run by java classname Let\'s take a simple
example:

//save by .java only

class A {

\>public static void main(String args\[\]){

\>\>System.out.println(\"Hello java\");

\>}

}

compile it by javac .java

run it by java A

174. **If I don\'t provide any arguments on the command line, then what
     will the value stored in the String array passed into the main()
     method, empty or NULL?**

It is empty, but not null.

175. **What is the purpose of static methods and variables?**

The methods or variables defined as static are shared among all the
instances of the class. The static is the part of the class and not of
the object. The static variables are stored in the class area, and we do
not need to create the object to access such variables. Therefore,
static is used in the case, where we need to define variables or methods
which are common to all the objects of the class.

For example, In the class simulating the collection of the students in a
college, the name of the college is the common attribute to all the
students. Therefore, the college name will be defined as static.

176. **What are the advantages of Packages in Java?**

There are various advantages of defining packages in Java.

-   Packages avoid the name clashes.

-   The Package provides easier access control.

-   We can also have the hidden classes that are not visible outside and
    used by the package.

-   It is easier to locate the related classes.

-   Packages enable the developer to organize the similar classes more
    effectively. For example, one can clearly understand that the
    classes present in java.io package are used to perform io related
    operations.

177. **What is the output of the following Java program?**

class Test

{

\>public static void main (String args\[\])

\>{

\>\>System.out.println(10 \* 20 + \"Javatpoint\");

\>\>System.out.println(\"Javatpoint\" + 10 \* 20);

\>}

}

The output of the above code will be

200Javatpoint

Javatpoint200

Explanation

In the first case, The numbers 10 and 20 will be multiplied first and
then the result 200 is treated as the string and concatenated with the
string Javatpoint to produce the output 200Javatpoint.b

In the second case, The numbers 10 and 20 will be multiplied first to be
200 because the precedence of the multiplication is higher than
addition. The result 200 will be treated as the string and concatenated
with the string Javatpointto produce the output as Javatpoint200.

178. **What is the output of the following Java program?**

class Test

{

\>public static void main (String args\[\])

\>{

\>\>for(int i=0; 0; i++)

\>\>{

\>\>\>System.out.println(\"Hello Javatpoint\");

\>\>}

\>}

}

The above code will give the compile-time error because the for loop
demands a boolean value in the second part and we are providing an
integer value, i.e., 0.

179. **What is an object?**

The Object is the real-time entity having some state and behavior. In
Java, Object is an instance of the class having the instance variables
as the state of the object and the methods as the behavior of the
object. The object of a class can be created by using the new keyword.

An object has three characteristics:

-   State

-   Behavior

-   Identity

An object is created using the 'new' keyword. For example:

ClassName obj = new ClassName();

180. **What is the difference between an object-oriented programming
     language and object-based programming language?**

There are the following basic differences between the object-oriented
language and object-based language.

-   Object-oriented languages follow all the concepts of OOPs whereas,
    the object-based language doesn\'t follow all the concepts of OOPs
    like inheritance and polymorphism.

-   Object-oriented languages do not have the inbuilt objects whereas
    Object-based languages have the inbuilt objects, for example,
    JavaScript has window object.

-   Examples of object-oriented programming are Java, C#, Smalltalk,
    etc. whereas the examples of object-based languages are JavaScript,
    VBScript, etc.

181. **What is the constructor?**

The constructor can be defined as the special type of method that is
used to initialize the state of an object. It is invoked when the class
is instantiated, and the memory is allocated for the object. Every time,
an object is created using the new keyword, the default constructor of
the class is called. The name of the constructor must be similar to the
class name. The constructor must not have an explicit return type.

-   When a new object is created in a program a constructor gets invoked
    corresponding to the class.

-   The constructor is a method which has the same name as the class
    name.

-   If a user doesn't create a constructor implicitly a default
    constructor will be created.

-   The constructor can be overloaded.

-   If the user created a constructor with a parameter then he should
    create another constructor explicitly without a parameter.

182. **What is the purpose of a default constructor?**

The purpose of the default constructor is to assign the default value to
the objects. The java compiler creates a default constructor implicitly
if there is no constructor in the class.

class Student3 {

\>int id;

\>String name;

\>void display() {

\>\>System.out.println(id+\" \"+name);

\>}

\>public static void main(String args\[\]) {

\>\>Student3 s1=new Student3();

\>\>Student3 s2=new Student3();

\>\>s1.display();

\>\>s2.display();

\>}

}

Output:

0 null

0 null

Explanation: In the above class, you are not creating any constructor,
so compiler provides you a default constructor. Here 0 and null values
are provided by default constructor.

![Java default constructor](image54.png){width="6.5in"
height="2.441666666666667in"}

183. **Is constructor inherited?**

No, The constructor is not inherited.

184. **Can you make a constructor final?**

No, the constructor can\'t be final.

185. **What is the output of the following Java program?**

public class Test

{

\>Test(int a, int b)

\>{

\>\>System.out.println(\"a = \"+a+\" b = \"+b);

\>}

\>Test(int a, float b)

\>{

\>\>System.out.println(\"a = \"+a+\" b = \"+b);

\>}

\>public static void main (String args\[\])

\>{

\>\>byte a = 10;

\>\>byte b = 15;

\>\>Test test = new Test(a,b);

\>}

}

The output of the following program is:

a = 10 b = 15

Here, the data type of the variables a and b, i.e., byte gets promoted
to int, and the first parameterized constructor with the two integer
parameters is called.

186. **What is the output of the following Java program?**

class Test {

\>int i;

}

public class Main {

\>public static void main (String args\[\]) {

\>\>Test test = new Test();

\>\>System.out.println(test.i);

\>}

}

The output of the program is 0 because the variable i is initialized to
0 internally. As we know that a default constructor is invoked
implicitly if there is no constructor in the class, the variable i is
initialized to 0 since there is no constructor in the class.

187. **What is the output of the following Java program?**

class Test {

\>int test_a, test_b;

\>Test(int a, int b) {

\>test_a = a;

\>test_b = b;

\>}

\>public static void main (String args\[\]) {

\>\>Test test = new Test();

\>\>System.out.println(test.test_a+\" \"+test.test_b);

\>}

}

There is a compiler error in the program because there is a call to the
default constructor in the main method which is not present in the
class. However, there is only one parameterized constructor in the class
Test. Therefore, no default constructor is invoked by the constructor
implicitly.

188. **What is the static variable?**

The static variable is used to refer to the common property of all
objects (that is not unique for each object), e.g., The company name of
employees, college name of students, etc. Static variable gets memory
only once in the class area at the time of class loading. Using a static
variable makes your program more memory efficient (it saves memory).
Static variable belongs to the class rather than the object.

//Program of static variable

class Student8 {

int rollno;

String name;

static String college =\"ITS\";

\>

Student8(int r,String n){

rollno = r;

name = n;

}

void display (){System.out.println(rollno+\" \"+name+\" \"+college);

}

public static void main(String args\[\]) {

Student8 s1 = new Student8(111,\"Karan\");

Student8 s2 = new Student8(222,\"Aryan\");

s1.display();

s2.display();

}

}

Output:

111 Karan ITS

222 Aryan ITS

![Static Variable](image55.jpeg){width="6.424305555555556in"
height="4.628472222222222in"}

189. **What is the static method?**

-   A static method belongs to the class rather than the object.

-   There is no need to create the object to call the static methods.

-   A static method can access and change the value of the static
    variable.

190. **What are the restrictions that are applied to the Java static
     methods?**

Two main restrictions are applied to the static methods.

-   The static method can not use non-static data member or call the
    non-static method directly.

-   this and super cannot be used in static context as they are
    non-static.

191. **Can we override the static methods?**

No, we can\'t override static methods.

192. **Can we execute a program without main() method?**

No, It was possible before JDK 1.7 using the static block. Since JDK
1.7, it is not possible.

193. **What is the difference between static (class) method and instance
     method?**

![](image56.png){width="6.5in" height="2.397222222222222in"}

194. **Can we make constructors static?**

As we know that the static context (method, block, or variable) belongs
to the class, not the object. Since Constructors are invoked only when
the object is created, there is no sense to make the constructors
static. However, if you try to do so, the compiler will show the
compiler error.

195. **Can we make the abstract methods static in Java?**

In Java, if we make the abstract methods static, It will become the part
of the class, and we can directly call it which is unnecessary. Calling
an undefined method is completely useless therefore it is not allowed.

196. **Can we declare the static variables and methods in an abstract
     class?**

Yes, we can declare static variables and methods in an abstract method.
As we know that there is no requirement to make the object to access the
static context, therefore, we can access the static context declared
inside the abstract class by using the name of the abstract class.
Consider the following example.

abstract class Test {

\>static int i = 102;

\>static void TestMethod()

\>{

\>\>System.out.println(\"hi !! I am good !!\");

\>}

}

public class TestClass extends Test {

\>public static void main (String args\[\]) {

\>\>Test.TestMethod();

\>\>System.out.println(\"i = \"+Test.i);

\>}

}

Output

hi !! I am good !!

i = 102

197. **What are the main uses of this keyword?**

There are the following uses of this keyword.

-   this can be used to refer to the current class instance variable.

-   this can be used to invoke current class method (implicitly)

-   this() can be used to invoke the current class constructor.

-   this can be passed as an argument in the method call.

-   this can be passed as an argument in the constructor call.

-   this can be used to return the current class instance from the
    method.

198. **Can we assign the reference to this variable?**

No, this cannot be assigned to any value because it always points to the
current class object and this is the final reference in Java. However,
if we try to do so, the compiler error will be shown. Consider the
following example.

public class Test {

\>public Test() {

\>\>this = null;

\>\>System.out.println(\"Test class constructor called\");

\>}

\>public static void main (String args\[\]) {

\>\>Test t = new Test();

\>}

}

Output

Test.java:5: error: cannot assign a value to final variable this

\>\>this = null;

\>\>\^

1 error

199. **Can this keyword be used to refer static members?**

Yes, It is possible to use this keyword to refer static members because
this is just a reference variable which refers to the current class
object. However, as we know that, it is unnecessary to access static
variables through objects, therefore, it is not the best practice to use
this to refer static members. Consider the following example.

public class Test {

\>static int i = 10;

\>public Test () {

\>\>System.out.println(this.i);\>

\>}

\>public static void main (String args\[\]) {

\>\>Test t = new Test();

\>}

}

Output

10

200. **What are the advantages of passing this into a method instead of
     the current class object itself?**

As we know, that this refers to the current class object, therefore, it
must be similar to the current class object. However, there can be two
main advantages of passing this into a method instead of the current
class object.

this is a final variable. Therefore, this cannot be assigned to any new
value whereas the current class object might not be final and can be
changed.

this can be used in the synchronized block.

201. **What is the Inheritance?**

Inheritance is a mechanism by which one object acquires all the
properties and behavior of another object of another class. It is used
for Code Reusability and Method Overriding. The idea behind inheritance
in Java is that you can create new classes that are built upon existing
classes. When you inherit from an existing class, you can reuse methods
and fields of the parent class. Moreover, you can add new methods and
fields in your current class also. Inheritance represents the IS-A
relationship which is also known as a parent-child relationship.

There are five types of inheritance in Java.

-   Single-level inheritance: In single inheritance, one class inherits
    the properties of another i.e there will be only one parent as well
    as one child class.

-   Multi-level inheritance: When a class is derived from a class which
    is also derived from another class, i.e. a class having more than
    one parent class but at different levels, such type of inheritance
    is called Multilevel Inheritance.

-   Multiple Inheritance

-   Hierarchical Inheritance: When a class has more than one child
    classes (subclasses) or in other words, more than one child classes
    have the same parent class, then such kind of inheritance is known
    as hierarchical.

-   Hybrid Inheritance: Hybrid inheritance is a combination of two or
    more types of inheritance.

Multiple inheritance is not supported in Java through class.

202. **Why is Inheritance used in Java?**

There are various advantages of using inheritance in Java that is given
below.

-   Inheritance provides code reusability. The derived class does not
    need to redefine the method of base class unless it needs to provide
    the specific implementation of the method.

-   Runtime polymorphism cannot be achieved without using inheritance.

-   We can simulate the inheritance of classes with the real-time
    objects which makes OOPs more realistic.

-   Inheritance provides data hiding. The base class can hide some data
    from the derived class by making it private.

-   Method overriding cannot be achieved without inheritance. By method
    overriding, we can give a specific implementation of some basic
    method contained by the base class.

203. **How can constructor chaining be done by using the super
     keyword?**

class Person {

\>String name, address;

\>int age;

\>public Person(int age, String name, String address) {

\>\>this.age = age;

\>\>this.name = name;

\>\>this.address = address;

\>}

}

class Employee extends Person {

\>float salary;

\>public Employee(int age, String name, String address, float salary) {

\>\>super(age, name, address);

\>\>this.salary = salary;

\>}

}

public class Test {

\>public static void main(String args\[\]) {

\>\>Employee e = new Employee(22, \"Mukesh\", \"Delhi\", 90000);

\>\>System.out.println(\"Name: \" + e.name + \" Salary: \" + e.salary +
\" Age: \" + e.age + \" Address: \" + e.address);

\>}

}

Output

Name: Mukesh Salary: 90000.0 Age: 22 Address: Delhi

204. **What are the main uses of the super keyword?**

There are the following uses of super keyword.

-   super can be used to refer to the immediate parent class instance
    variable.

-   super can be used to invoke the immediate parent class method.

-   super() can be used to invoke immediate parent class constructor.

```{=html}
<!-- -->
```
-   What are the differences between this and super keyword?

There are the following differences between this and super keyword.

The super keyword always points to the parent class contexts whereas
this keyword always points to the current class context.

The super keyword is primarily used for initializing the base class
variables within the derived class constructor whereas this keyword
primarily used to differentiate between local and instance variables
when passed in the class constructor.

The super and this must be the first statement inside constructor
otherwise the compiler will throw an error.

205. **What are the differences between this and super keyword?**

There are the following differences between this and super keyword.

-   The super keyword always points to the parent class contexts whereas
    this keyword always points to the current class context.

-   The super keyword is primarily used for initializing the base class
    variables within the derived class constructor whereas this keyword
    primarily used to differentiate between local and instance variables
    when passed in the class constructor.

-   The super and this must be the first statement inside constructor
    otherwise the compiler will throw an error.

![](image57.png){width="6.5in"
height="1.9270833333333333in"}

206. **What is the output of the following Java program?**

class Person {

\>public Person() {

\>\>System.out.println(\"Person class constructor called\");

\>}

}

public class Employee extends Person {

\>public Employee() {

\>\>System.out.println(\"Employee class constructor called\");

\>}

\>public static void main(String args\[\]) {

\>\>Employee e = new Employee();

\>}

}

Output:

Person class constructor called

Employee class constructor called

Explanation:

The super() is implicitly invoked by the compiler if no super() or
this() is included explicitly within the derived class constructor.
Therefore, in this case, The Person class constructor is called first
and then the Employee class constructor is called.

207. **Can we overload the methods by making them static?**

No, We cannot overload the methods by just applying the static keyword
to them(number of parameters and types are the same). Consider the
following example.

public class Animal {

\>void consume(int a) {

\>\>System.out.println(a + \" consumed!!\");

\>}

\>static void consume(int a) {

\>\>System.out.println(\"consumed static \" + a);

\>}

\>public static void main(String args\[\]) {

\>\>Animal a = new Animal();

\>\>a.consume(10);

\>\>Animal.consume(20);

\>}

}

Output:

Animal.java:7: error: method consume(int) is already defined in class
Animal

\>static void consume(int a)

\>\>\>\>\^

Animal.java:15: error: non-static method consume(int) cannot be
referenced from a static context

\>\>Animal.consume(20);

\>\>\> \^

2 errors

208. **What is the output of the following Java program?**

class OverloadingCalculation3 {

\>void sum(int a, long b) {

\>\>System.out.println(\"a method invoked\");

\>}

\>void sum(long a, int b) {

\>\>System.out.println(\"b method invoked\");

\>}

\>public static void main(String args\[\]) {

\>\>OverloadingCalculation3 obj = new OverloadingCalculation3();

\>\>obj.sum(20, 20); //now ambiguity\>

\>}

}

Output

OverloadingCalculation3.java:7: error: reference to sum is ambiguous

obj.sum(20,20);//now ambiguity

\> \^

\> both method sum(int,long) in OverloadingCalculation3

\> and method sum(long,int) in OverloadingCalculation3 match

1 error

Explanation

There are two methods defined with the same name, i.e., sum. The first
method accepts the integer and long type whereas the second method
accepts long and the integer type. The parameter passed that are a = 20,
b = 20. We can not tell that which method will be called as there is no
clear differentiation mentioned between integer literal and long
literal. This is the case of ambiguity. Therefore, the compiler will
throw an error.

209. **What is method overriding?**

If a subclass provides a specific implementation of a method that is
already provided by its parent class, it is known as Method Overriding.
It is used for runtime polymorphism and to implement the interface
methods.

Rules for Method overriding

-   The method must have the same name as in the parent class.

-   The method must have the same signature as in the parent class.

-   Two classes must have an IS-A relationship between them.

210. **Can we override the overloaded method?**

Yes.

211. **Difference between method Overloading and Overriding.**

![](image58.png){width="6.5in"
height="2.0694444444444446in"}

212. **Can we override the private methods?**

No, we cannot override the private methods because the scope of private
methods is limited to the class and we cannot access them outside of the
class.

213. **Can we change the scope of the overridden method in the
     subclass?**

Yes, we can change the scope of the overridden method in the subclass.
However, we must notice that we cannot decrease the accessibility of the
method. The following point must be taken care of while changing the
accessibility of the method.

-   The private can be changed to protected, public, or default.

-   The protected can be changed to public or default.

-   The default can be changed to public.

-   The public will always remain public.

214. **Can we modify the throws clause of the superclass method while
     overriding it in the subclass?**

Yes, we can modify the throws clause of the superclass method while
overriding it in the subclass. However, there are some rules which are
to be followed while overriding in case of exception handling.

-   If the superclass method does not declare an exception, subclass
    overridden method cannot declare the checked exception, but it can
    declare the unchecked exception.

-   If the superclass method declares an exception, subclass overridden
    method can declare same, subclass exception or no exception but
    cannot declare parent exception.

215. **What is the output of the following Java program?**

class Base {

\>void method(int a) {

\>\>System.out.println(\"Base class method called with integer a = \" +
a);

\>}

\>void method(double d) {

\>\>System.out.println(\"Base class method called with double d =\" +
d);

\>}

}

class Derived extends Base {

\>@Override

\>void method(double d) {

\>\>System.out.println(\"Derived class method called with double d =\" +
d);

\>}

}

public class Main {

\>public static void main(String\[\] args) {

\>\>new Derived().method(10);

\>}

}

Output

Base class method called with integer a = 10

Explanation

The method() is overloaded in class Base whereas it is derived in class
Derived with the double type as the parameter. In the method call, the
integer is passed.

216. **What is the output of the following Java program?**

class Base {

\>public void baseMethod() {

\>\>System.out.println(\"BaseMethod called \...\");

\>}

}

class Derived extends Base {

\>public void baseMethod() {

\>\>System.out.println(\"Derived method called \...\");

\>}

}

public class Test {

\>public static void main(String args\[\]) {

\>\>Base b = new Derived();

\>\>b.baseMethod();

\>}

}

Output

Derived method called \...

Explanation

The method of Base class, i.e., baseMethod() is overridden in Derived
class. In Test class, the reference variable b (of type Base class)
refers to the instance of the Derived class. Here, Runtime polymorphism
is achieved between class Base and Derived. At compile time, the
presence of method baseMethod checked in Base class, If it presence then
the program compiled otherwise the compiler error will be shown. In this
case, baseMethod is present in Base class; therefore, it is compiled
successfully. However, at runtime, It checks whether the baseMethod has
been overridden by Derived class, if so then the Derived class method is
called otherwise Base class method is called. In this case, the Derived
class overrides the baseMethod; therefore, the Derived class method is
called.

217. **What is the final variable?**

In Java, the final variable is used to restrict the user from updating
it. If we initialize the final variable, we can\'t change its value. In
other words, we can say that the final variable once assigned to a
value, can never be changed after that. The final variable which is not
assigned to any value can only be assigned through the class
constructor.

![final keyword in
java](image59.jpeg){width="3.886111111111111in"
height="2.8256944444444443in"}

class Bike9 {

\>final int speedlimit = 90; //final variable

\>void run() {

\>\>speedlimit = 400;

\>}

\>public static void main(String args\[\]) {

\>\>Bike9 obj = new Bike9();

\>\>obj.run();

\>}

} //end of class

Output:

Compile Time Error

218. **What is the final method?**

If we change any method to a final method, we can\'t override it.

class Bike {

\>final void run() {

\>\>System.out.println(\"running\");

\>}

}

class Honda extends Bike {

\>void run() {

\>\>System.out.println(\"running safely with 100kmph\");

\>}

\>public static void main(String args\[\]) {

\>\>Honda honda = new Honda();

\>\>honda.run();

\>}

}

Output:

Compile Time Error

219. **What is the final class?**

If we make any class final, we can\'t inherit it into any of the
subclasses.

final class Bike {}

class Honda1 extends Bike {

\>void run() {

\>\>System.out.println(\"running safely with 100kmph\");

\>}

\>public static void main(String args\[\]) {

\>\>Honda1 honda = new Honda1();

\>\>honda.run();

\>}

}

Output:

Compile Time Error

220. **What is the final blank variable?**

A final variable, not initialized at the time of declaration, is known
as the final blank variable. We can\'t initialize the final blank
variable directly. Instead, we have to initialize it by using the class
constructor. If it is static blank final variable, it can be initialized
only in the static block. It is useful in the case when the user has
some data which must not be changed by others, for example, PAN Number.
Consider the following example:

class Student {

\>int id;

\>String name;

\>final String PAN_CARD_NUMBER;

\>\...

}

221. **Can you declare the main method as final?**

Yes, We can declare the main method as public static final void
main(String\[\] args){}.

222. **What is the output of the following Java program?**

class Main {

\>public static void main(String args\[\]) {

\>\>final int i;

\>\>i = 20;

\>\>System.out.println(i);

\>}

}

Output

20

Explanation

Since i is the blank final variable. It can be initialized only once. We
have initialized it to 20. Therefore, 20 will be printed.

223. **What is the output of the following Java program?**

class Base {

\>protected final void getInfo() {

\>\>System.out.println(\"method of Base class\");

\>}

}

public class Derived extends Base {

\>protected final void getInfo() {

\>\>System.out.println(\"method of Derived class\");

\>}

\>public static void main(String\[\] args) {

\>\>Base obj = new Base();

\>\>obj.getInfo();

\>}

}

Output

\>Derived.java:11: error: getInfo() in Derived cannot override getInfo()
in Base

\>protected final void getInfo()

\>\>\>\>\>\> \^

overridden method is final

1 error

Explanation

The getDetails() method is final; therefore it can not be overridden in
the subclass.

224. **What is the difference between compile-time polymorphism and
     runtime polymorphism?**

![](image60.png){width="6.5in"
height="3.7534722222222223in"}

225. **What is Runtime Polymorphism?**

Runtime polymorphism or dynamic method dispatch is a process in which a
call to an overridden method is resolved at runtime rather than at
compile-time. In this process, an overridden method is called through
the reference variable of a superclass. The determination of the method
to be called is based on the object being referred to by the reference
variable.

class Bike {

\>void run() {

\>\>System.out.println(\"running\");

\>}

}

class Splendor extends Bike {

\>void run() {

\>\>System.out.println(\"running safely with 60km\");

\>}

\>public static void main(String args\[\]) {

\>\>Bike b = new Splendor(); //upcasting

\>\>b.run();

\>}

}

Output:

running safely with 60km.

In this process, an overridden method is called through the reference
variable of a superclass. The determination of the method to be called
is based on the object being referred to by the reference variable.

226. **Can you achieve Runtime Polymorphism by data members?**

No, because method overriding is used to achieve runtime polymorphism
and data members cannot be overridden. We can override the member
functions but not the data members. Consider the example given below.

class Bike {

\>int speedlimit = 90;

}

class Honda3 extends Bike {

\>int speedlimit = 150;

\>public static void main(String args\[\]) {

\>\>Bike obj = new Honda3();

\>\>System.out.println(obj.speedlimit); //90

\>}

}

Output:

90

227. **What is the difference between static binding and dynamic
     binding?**

In case of the static binding, the type of the object is determined at
compile-time whereas, in the dynamic binding, the type of the object is
determined at runtime.

Static Binding

class Dog {

\>private void eat() {

\>\>System.out.println(\"dog is eating\...\");

\>}

\>public static void main(String args\[\]) {

\>\>Dog d1 = new Dog();

\>\>d1.eat();

\>}

}

Dynamic Binding

class Animal {

\>void eat() {

\>\>System.out.println(\"animal is eating\...\");

\>}

}

class Dog extends Animal {

\>void eat() {

\>\>System.out.println(\"dog is eating\...\");

\>}

\>public static void main(String args\[\]) {

\>\>Animal a = new Dog();

\>\>a.eat();

\>}

}

228. **What is the output of the following Java program?**

class BaseTest {

\>void print() {

\>\>System.out.println(\"BaseTest:print() called\");

\>}

}

public class Test extends BaseTest {

\>void print() {

\>\>System.out.println(\"Test:print() called\");

\>}

\>public static void main(String args\[\]) {

\>\>BaseTest b = new Test();

\>\>b.print();

\>}

}

Output

Test:print() called

Explanation

It is an example of Dynamic method dispatch. The type of reference
variable b is determined at runtime. At compile-time, it is checked
whether that method is present in the Base class. In this case, it is
overridden in the child class, therefore, at runtime the derived class
method is called.

229. **What is Java instanceOf operator?**

The instanceof in Java is also known as type comparison operator because
it compares the instance with type. It returns either true or false. If
we apply the instanceof operator with any variable that has a null
value, it returns false. Consider the following example.

class Simple1 {

\>public static void main(String args\[\]) {

\>\>Simple1 s = new Simple1();

\>\>System.out.println(s instanceof Simple1); //true

\>}

}

Output

true

An object of subclass type is also a type of parent class. For example,
if Dog extends Animal then object of Dog can be referred by either Dog
or Animal class.

230. **What is the abstraction?**

Abstraction is a process of hiding the implementation details and
showing only functionality to the user. It displays just the essential
things to the user and hides the internal information, for example,
sending SMS where you type the text and send the message. You don\'t
know the internal processing about the message delivery. Abstraction
enables you to focus on what the object does instead of how it does it.
Abstraction lets you focus on what the object does instead of how it
does it.

In Java, there are two ways to achieve the abstraction.

-   Abstract Class

-   Interface

231. **What is the difference between abstraction and encapsulation?**

Abstraction hides the implementation details whereas encapsulation wraps
code and data into a single unit.

232. **What is the abstract class?**

A class that is declared as abstract is known as an abstract class. It
needs to be extended and its method implemented. It cannot be
instantiated. It can have abstract methods, non-abstract methods,
constructors, and static methods. It can also have the final methods
which will force the subclass not to change the body of the method.
Consider the following example.

abstract class Bike {

\>abstract void run();

}

class Honda4 extends Bike {

\>void run() {

\>\>System.out.println(\"running safely\");

\>}

\>public static void main(String args\[\]) {

\>\>Bike obj = new Honda4();

\>\>obj.run();

\>}

}

Output

running safely

233. **Can there be an abstract method without an abstract class?**

No, if there is an abstract method in a class, that class must be
abstract.

234. **Is the following program written correctly? If yes then what will
     be the output of the program?**

abstract class Calculate {

\>abstract int multiply(int a, int b);

}

public class Main {

\>public static void main(String\[\] args) {

\>\>int result = new Calculate() {

\>\>\>@Override

\>\>\>int multiply(int a, int b) {

\>\>\>\>return a \* b;

\>\>\>}

\>\>}.multiply(12, 32);

\>\>System.out.println(\"result = \" + result);

\>}

}

Yes, the program is written correctly. The Main class provides the
definition of abstract method multiply declared in abstract class
Calculation. The output of the program will be:

Output

384

235. **Can you use abstract and final both with a method?**

No, because we need to override the abstract method to provide its
implementation, whereas we can\'t override the final method.

236. **Is it possible to instantiate the abstract class?**

No, the abstract class can never be instantiated even if it contains a
constructor and all of its methods are implemented.

237. **What is the interface?**

The interface is a blueprint for a class that has static constants and
abstract methods. It can be used to achieve full abstraction and
multiple inheritance. It is a mechanism to achieve abstraction. There
can be only abstract methods in the Java interface, not method body. It
is used to achieve abstraction and multiple inheritance in Java. In
other words, you can say that interfaces can have abstract methods and
variables. Java Interface also represents the IS-A relationship. It
cannot be instantiated just like the abstract class. However, we need to
implement it to define its methods. Since Java 8, we can have the
default, static, and private methods in an interface.

Example:

public interface Animal {

\>public void eat();

\>public void sleep();

\>public void run();

}

238. **Can you declare an interface method static?**

No, because methods of an interface are abstract by default, and we can
not use static and abstract together.

239. **Can the Interface be final?**

No, because an interface needs to be implemented by the other class and
if it is final, it can\'t be implemented by any class.

240. **Can we define private and protected modifiers for the members in
     interfaces?**

No, they are implicitly public.

241. **When can an object reference be cast to an interface reference?**

An object reference can be cast to an interface reference when the
object implements the referenced interface.

242. **How to make a read-only class in Java?**

A class can be made read-only by making all of the fields private. The
read-only class will have only getter methods which return the private
property of the class to the main method. We cannot modify this property
because there is no setter method available in the class. Consider the
following example.

//A Java class which has only getter methods.\>

public class Student {

\>//private data member\>

\>private String college = \"AKG\";

\>//getter method for college\>

\>public String getCollege() {

\>\>return college;

\>}

}

243. **How to make a write-only class in Java?**

A class can be made write-only by making all of the fields private. The
write-only class will have only setter methods which set the value
passed from the main method to the private fields. We cannot read the
properties of the class because there is no getter method in this class.
Consider the following example.

//A Java class which has only setter methods.\>

public class Student {

\>//private data member\>

\>private String college;

\>//setter method for college\>

\>public void setCollege(String college) {

\>\>this.college = college;

\>}

}

244. **What are the advantages of Encapsulation in Java?**

There are the following advantages of Encapsulation in Java:

-   By providing only the setter or getter method, you can make the
    class read-only or write-only. In other words, you can skip the
    getter or setter methods.

-   It provides you the control over the data. Suppose you want to set
    the value of id which should be greater than 100 only, you can write
    the logic inside the setter method. You can write the logic not to
    store the negative numbers in the setter methods.

-   It is a way to achieve data hiding in Java because other class will
    not be able to access the data through the private data members.

-   The encapsulate class is easy to test. So, it is better for unit
    testing.

-   The standard IDEs are providing the facility to generate the getters
    and setters. So, it is easy and fast to create an encapsulated class
    in Java.

245. **How to create packages in Java?**

If you are using the programming IDEs like Eclipse, NetBeans, MyEclipse,
etc. click on file-\>new-\>project and eclipse will ask you to enter the
name of the package. It will create the project package containing
various directories such as src, etc. If you are using an editor like
notepad for java programming, use the following steps to create the
package.

-   Define a package package_name. Create the class with the name
    class_name and save this file with your_class_name.java.

-   Now compile the file by running the following command on the
    terminal.

javac -d . your_class_name.java

The above command creates the package with the name package_name in the
present working directory.

-   Now, run the class file by using the absolute class file name, like
    following.

java package_name.class_name

246. **How can we access some class in another class in Java?**

There are two ways to access a class in another class.

-   By using the fully qualified name: To access a class in a different
    package, either we must use the fully qualified name of that class,
    or we must import the package containing that class.

-   By using the relative path, We can use the path of the class that is
    related to the package that contains our class. It can be the same
    or subpackage.

247. **Do I need to import java.lang package any time? Why?**

No. It is by default loaded internally by the JVM.

248. **What is the static import?**

By static import, we can access the static members of a class directly,
and there is no to qualify it with the class name.

249. **How many types of exception can occur in a Java program?**

There are mainly two types of exceptions: checked and unchecked. Here,
an error is considered as the unchecked exception. According to Oracle,
there are three types of exceptions:

-   Checked Exception: Checked exceptions are the one which are checked
    at compile-time. For example, SQLException, ClassNotFoundException,
    etc.

-   Unchecked Exception: Unchecked exceptions are the one which are
    handled at runtime because they can not be checked at compile-time.
    For example, ArithmaticException, NullPointerException,
    ArrayIndexOutOfBoundsException, etc.

-   Error: Error cause the program to exit since they are not
    recoverable. For Example, OutOfMemoryError, AssertionError, etc.

250. **What is Exception Handling?**

Exception Handling is a mechanism that is used to handle runtime errors.
It is used primarily to handle checked exceptions. Exception handling
maintains the normal flow of the program. There are mainly two types of
exceptions: checked and unchecked. Here, the error is considered as the
unchecked exception.

There are five keywords used to handle exceptions in Java:

-   try

-   catch

-   finally

-   throw

-   throws

Two different ways to handle exceptions are explained below:

-   Using try/catch:

> The risky code is surrounded by try block. If an exception occurs,
> then it is caught by the catch block which is followed by the try
> block.
>
> Example:
>
> class Manipulation {
>
> \>public static void main(String\[\] args) {
>
> \>\>add();
>
> \>}
>
> \>Public void add() {
>
> \>\>try {
>
> \>\>\>addition();
>
> \>\>} catch (Exception e) {
>
> \>\>\>e.printStacktrace();
>
> \>\>}
>
> \>}
>
> }

-   By declaring throws keyword:

> At the end of the method, we can declare the exception using throws
> keyword.
>
> Example:
>
> class Manipulation {
>
> \>public static void main(String\[\] args) {
>
> \>\>add();
>
> \>}
>
> \>public void add() throws Exception {
>
> \>\>addition();
>
> \>}
>
> }

251. **Explain the hierarchy of Java Exception classes?**

The java.lang.Throwable class is the root class of Java Exception
hierarchy which is inherited by two subclasses: Exception and Error. A
hierarchy of Java Exception classes are given below:

![hierarchy of exception
handling](image61.png){width="6.5in"
height="8.253472222222221in"}

252. **What is the difference between Checked Exception and Unchecked
     Exception?**

-   Checked Exception

The classes that extend Throwable class except RuntimeException and
Error are known as checked exceptions, e.g., IOException, SQLException,
etc. Checked exceptions are checked at compile-time.

-   Unchecked Exception

The classes that extend RuntimeException are known as unchecked
exceptions, e.g., ArithmeticException, NullPointerException, etc.
Unchecked exceptions are not checked at compile-time.

253. **What is the base class for Error and Exception?**

The Throwable class is the base class for Error and Exception.

254. **What is the output of the following Java program?**

public class ExceptionHandlingExample {

\>public static void main(String args\[\]) {

\>\>try {

\>\>\>int a = 1 / 0;

\>\>\>System.out.println(\"a = \" + a);

\>\>} catch (Exception e) {

\>\>\>System.out.println(e);

\>\>} catch (ArithmeticException ex) {

\>\>\>System.out.println(ex);

\>\>}

\>}

}

Output

ExceptionHandlingExample.java:10: error: exception ArithmeticException
has already been caught

\>catch(ArithmeticException ex){System.out.println(ex);}\>

\>\^

1 error

Explanation

ArithmaticException is the subclass of Exception. Therefore, it can not
be used after Exception. Since Exception is the base class for all the
exceptions, therefore, it must be used at last to handle the exception.
No class can be used after this.

255. **What is finally block?**

The \"finally\" block is used to execute the important code of the
program. It is executed whether an exception is handled or not. In other
words, we can say that finally block is the block which is always
executed. Finally block follows try or catch block. If you don\'t handle
the exception, before terminating the program, JVM runs finally block,
(if any). The finally block is mainly used to place the cleanup code
such as closing a file or closing a connection. Here, we must know that
for each try block there can be zero or more catch blocks, but only one
finally block. The finally block will not be executed if program
exits(either by calling System.exit() or by causing a fatal error that
causes the process to abort).

![java finally](image62.jpeg){width="4.868055555555555in"
height="5.798611111111111in"}

256. **Can finally block be used without a catch?**

Yes, According to the definition of finally block, it must be followed
by a try or catch block, therefore, we can use try block instead of
catch.

257. **What is the output of the following Java program?**

public class Main {

\>public static void main(String\[\] args) {

\>\>try {

\>\>\>throw 90;

\>\>} catch (int e) {

\>\>\>System.out.println(\"Caught the exception \" + e);

\>\>}

\>}

}

Output

Main.java:6: error: incompatible types: int cannot be converted to
Throwable

\>\>\>throw 90;

\>\>\>\^

Main.java:8: error: unexpected type

\>\>catch(int e){

\>\>\> \^

required: class

found:\>int

2 errors

Explanation

In Java, the throwable objects can only be thrown. If we try to throw an
integer object, The compiler will show an error since we can not throw
basic data type from a block of code.

258. **What is the output of the following Java program?**

class Calculation extends Exception {

\>public Calculation() {

\>\>System.out.println(\"Calculation class is instantiated\");

\>}

\>public void add(int a, int b) {

\>\>System.out.println(\"The sum is \" + (a + b));

\>}

}

public class Main {

\>public static void main(String\[\] args) {

\>\>try {

\>\>\>throw new Calculation();

\>\>} catch (Calculation c) {

\>\>\>c.add(10, 20);

\>\>}

\>}

}

Output

Calculation class is instantiated

The sum is 30

Explanation

The object of Calculation is thrown from the try block which is caught
in the catch block. The add() of Calculation class is called with the
integer values 10 and 20 by using the object of this class. Therefore
there sum 30 is printed. The object of the Main class can only be thrown
in the case when the type of the object is throwable. To do so, we need
to extend the throwable class.

259. **Can an exception be rethrown?**

Yes.

260. **Can subclass overriding method declare an exception if parent
     class method doesn\'t throw an exception?**

Yes but only unchecked exception not checked.

261. **What is the output of the following Java program?**

public class Main {

\>void a() {

\>\>try {

\>\>\>System.out.println(\"a(): Main called\");

\>\>\>b();

\>\>} catch (Exception e) {

\>\>\>System.out.println(\"Exception is caught\");

\>\>}

\>}

\>void b() throws Exception {

\>\>try {

\>\>\>System.out.println(\"b(): Main called\");

\>\>\>c();

\>\>} catch (Exception e) {

\>\>\>throw new Exception();

\>\>} finally {

\>\>\>System.out.println(\"finally block is called\");

\>\>}

\>}

\>void c() throws Exception {

\>\>throw new Exception();

\>}

\>public static void main(String args\[\]) {

\>\>Main m = new Main();

\>\>m.a();

\>}

}

Output

a(): Main called

b(): Main called

finally block is called

Exception is caught

Explanation

In the main method, a() of Main is called which prints a message and
call b(). The method b() prints some message and then call c(). The
method c() throws an exception which is handled by the catch block of
method b. However, It propagates this exception by using throw
Exception() to be handled by the method a(). As we know, finally block
is always executed therefore the finally block in the method b() is
executed first and prints a message. At last, the exception is handled
by the catch block of the method a().

262. **What is the output of the following Java program?**

public class Calculation {

\>int a;

\>public Calculation(int a) {

\>\>this.a = a;

\>}

\>public int add() {

\>\>a = a + 10;

\>\>try {

\>\>\>a = a + 10;

\>\>\>try {

\>\>\>\>a = a \* 10;

\>\>\>\>throw new Exception();

\>\>\>} catch (Exception e) {

\>\>\>\>a = a - 10;

\>\>\>}

\>\>} catch (Exception e) {

\>\>\>a = a - 10;

\>\>}

\>\>return a;

\>}

\>public static void main(String args\[\]) {

\>\>Calculation c = new Calculation(10);

\>\>int result = c.add();

\>\>System.out.println(\"result = \" + result);

\>}

}

Output

result = 290

Explanation

The instance variable a of class Calculation is initialized to 10 using
the class constructor which is called while instantiating the class. The
add method is called which returns an integer value result. In add()
method, a is incremented by 10 to be 20. Then, in the first try block,
10 is again incremented by 10 to be 30. In the second try block, a is
multiplied by 10 to be 300. The second try block throws the exception
which is caught by the catch block associated with this try block. The
catch block again alters the value of a by decrementing it by 10 to make
it 290. Thus the add() method returns 290 which is assigned to result.
However, the catch block associated with the outermost try block will
never be executed since there is no exception which can be handled by
this catch block.

263. **What is the meaning of immutable regarding String?**

The simple meaning of immutable is unmodifiable or unchangeable. In
Java, String is immutable, i.e., once string object has been created,
its value can\'t be changed. Consider the following example for better
understanding.

class Testimmutablestring {

\>public static void main(String args\[\]) {

\>\>String s = \"Sachin\";

\>\>s.concat(\" Tendulkar\"); //concat() method appends the string at
the end

\>\>System.out.println(s); //will print Sachin because strings are
immutable objects

\>}

}

Output:

Sachin

264. **How many ways can we create the string object?**

-   String Literal

Java String literal is created by using double quotes. For Example:

String s=\"welcome\";

Each time you create a string literal, the JVM checks the \"string
constant pool\" first. If the string already exists in the pool, a
reference to the pooled instance is returned. If the string doesn\'t
exist in the pool, a new string instance is created and placed in the
pool. String objects are stored in a special memory area known as the
string constant pool For example:

String s1=\"Welcome\";

String s2=\"Welcome\";//It doesn\'t create a new instance

-   By new keyword

String s=new String(\"Welcome\");//creates two objects and one reference
variable

In such case, JVM will create a new string object in normal (non-pool)
heap memory, and the literal \"Welcome\" will be placed in the constant
string pool. The variable s will refer to the object in a heap
(non-pool).

265. **How many objects will be created in the following code?**

String s1=\"Welcome\";

String s2=\"Welcome\";

String s3=\"Welcome\";

Only one object will be created using the above code because strings in
Java are immutable.

266. **Why java uses the concept of the string literal?**

To make Java more memory efficient (because no new objects are created
if it exists already in the string constant pool).

267. **How many objects will be created in the following code?**

String s = new String(\"Welcome\");

Two objects, one in string constant pool and other in non-pool(heap).

268. **What is the output of the following Java program?**

public class Test {

\>public static void main(String args\[\]) {

\>\>String a = new String(\"Sharma is a good player\");

\>\>String b = \"Sharma is a good player\";

\>\>if (a == b) {

\>\>\>System.out.println(\"a == b\");

\>\>}

\>\>if (a.equals(b)) {

\>\>\>System.out.println(\"a equals b\");

\>\>}

\>}

}

Output

a equals b

Explanation

The operator == also check whether the references of the two string
objects are equal or not. Although both of the strings contain the same
content, their references are not equal because both are created by
different ways(Constructor and String literal) therefore, a == b is
unequal. On the other hand, the equal() method always check for the
content. Since their content is equal hence, a equals b is printed.

269. **What is the output of the following Java program?**

public class Test {

\>public static void main(String args\[\]) {

\>\>String s1 = \"Sharma is a good player\";

\>\>String s2 = new String(\"Sharma is a good player\");

\>\>s2 = s2.intern();

\>\>System.out.println(s1 == s2);

\>}

}

Output

true

Explanation

The intern method returns the String object reference from the string
pool. In this case, s1 is created by using string literal whereas, s2 is
created by using the String pool. However, s2 is changed to the
reference of s1, and the operator == returns true.

270. **How can we create an immutable class in Java?**

We can create an immutable class by defining a final class having all of
its members as final. Consider the following example.

public final class Employee {

\>final String pancardNumber;

\>public Employee(String pancardNumber) {

\>\>this.pancardNumber = pancardNumber;

\>}

\>public String getPancardNumber() {

\>\>return pancardNumber;

\>}

}

271. **What is the purpose of toString() method in Java?**

The toString() method returns the string representation of an object. If
you print any object, java compiler internally invokes the toString()
method on the object. So overriding the toString() method, returns the
desired output, it can be the state of an object, etc. depending upon
your implementation. By overriding the toString() method of the Object
class, we can return the values of the object, so we don\'t need to
write much code. Consider the following example.

class Student {

\>int rollno;

\>String name;

\>String city;

\>Student(int rollno, String name, String city) {

\>\>this.rollno = rollno;

\>\>this.name = name;

\>\>this.city = city;

\>}

\>public String toString() { //overriding the toString() method

\>\>return rollno + \" \" + name + \" \" + city;

\>}

\>public static void main(String args\[\]) {

\>\>Student s1 = new Student(101, \"Raj\", \"lucknow\");

\>\>Student s2 = new Student(102, \"Vijay\", \"ghaziabad\");

\>\>System.out.println(s1); //compiler writes here s1.toString()

\>\>System.out.println(s2); //compiler writes here s2.toString()

\>}

}

Output:

101 Raj lucknow

102 Vijay Ghaziabad

272. **Write a Java program to count the number of words present in a
     string?**

Program:

public class Test {

\>public static void main(String args\[\]) {

\>\>String s = \"Sharma is a good player and he is so punctual\";

\>\>String words\[\] = s.split(\" \");

\>\>System.out.println(\"The Number of words present in the string are :
\" + words.length);

\>}

}

Output

The Number of words present in the string are: 10

273. **Name some classes present in java.util.regex package.**

There are the following classes and interfaces present in
java.util.regex package.

-   MatchResult Interface

-   Matcher class

-   Pattern class

-   PatternSyntaxException class

![Java Regex API](image63.jpeg){width="6.5in"
height="4.879861111111111in"}

274. **How the metacharacters are different from the ordinary
     characters?**

Metacharacters have the special meaning to the regular expression
engine. The metacharacters are \^, \$, ., \*, +, etc. The regular
expression engine does not consider them as the regular characters. To
enable the regular expression engine treating the metacharacters as
ordinary characters, we need to escape the metacharacters with the
backslash.

275. **Write a regular expression to validate a password. A password
     must start with an alphabet and followed by alphanumeric
     characters; Its length must be in between 8 to 20.**

The regular expression for the above criteria will be:
\^\[a-zA-Z\]\[a-zA-Z0-9\]{8,19} where \^ represents the start of the
regex, \[a-zA-Z\] represents that the first character must be an
alphabet, \[a-zA-Z0-9\] represents the alphanumeric character, {8,19}
represents that the length of the password must be in between 8 and 20.

276. **What is the output of the following Java program?**

import java.util.regex.\*;

class RegexExample2 {

\>public static void main(String args\[\]) {

\>\>System.out.println(Pattern.matches(\".s\", \"as\")); //line 4

\>\>System.out.println(Pattern.matches(\".s\", \"mk\")); //line 5

\>\>System.out.println(Pattern.matches(\".s\", \"mst\")); //line 6

\>\>System.out.println(Pattern.matches(\".s\", \"amms\")); //line 7

\>\>System.out.println(Pattern.matches(\"..s\", \"mas\")); //line 8

\>}

}

Output

true

false

false

false

true

Explanation

line 4 prints true since the second character of string is s, line 5
prints false since the second character is not s, line 6 prints false
since there are more than 3 characters in the string, line 7 prints
false since there are more than 2 characters in the string, and it
contains more than 2 characters as well, line 8 prints true since the
third character of the string is s.

277. **What are the advantages of Java inner classes?**

There are two types of advantages of Java inner classes.

-   Nested classes represent a special type of relationship that is it
    can access all the members (data members and methods) of the outer
    class including private.

-   Nested classes are used to develop a more readable and maintainable
    code because it logically groups classes and interfaces in one place
    only.

-   Code Optimization: It requires less code to write.

278. **What is a nested class?**

The nested class can be defined as the class which is defined inside
another class or interface. We use the nested class to logically group
classes and interfaces in one place so that it can be more readable and
maintainable. A nested class can access all the data members of the
outer class including private data members and methods. The syntax of
the nested class is defined below.

class Java_Outer_class {

\>//code\>

\>class Java_Nested_class {

\>\>//code\>

\>}

}

There are two types of nested classes, static nested class, and
non-static nested class. The non-static nested class can also be called
as inner-class.

279. **What are the disadvantages of using inner classes?**

There are the following main disadvantages of using inner classes.

-   Inner classes increase the total number of classes used by the
    developer and therefore increases the workload of JVM since it has
    to perform some routine operations for those extra classes which
    result in slower performance.

-   IDEs provide less support to the inner classes as compare to the top
    level classes and therefore it annoys the developers while working
    with inner classes.

280. **What are the types of inner classes (non-static nested class)
     used in Java?**

There are mainly three types of inner classes used in Java.

![](image64.png){width="6.5in"
height="2.2493055555555554in"}

281. **Is there any difference between nested classes and inner
     classes?**

Yes, inner classes are non-static nested classes. In other words, we can
say that inner classes are the part of nested classes.

282. **Can we access the non-final local variable, inside the local
     inner class?**

No, the local variable must be constant if you want to access it in the
local inner class.

283. **How many class files are created on compiling the OuterClass in
     the following program?**

public class Person {

\>String name, age, address;

\>class Employee {

\>\>float salary = 10000;

\>}

\>class BusinessMen {

\>\>final String gstin = \"£4433drt3\$\";

\>}

\>public static void main(String args\[\]) {

\>\>Person p = new Person();

\>}

}

3 class-files will be created named as Person.class,
Person\$BusinessMen.class, and Person\$Employee.class.

284. **What are anonymous inner classes?**

Anonymous inner classes are the classes that are automatically declared
and instantiated within an expression. We cannot apply different access
modifiers to them. Anonymous class cannot be static, and cannot define
any static fields, method, or class. In other words, we can say that it
a class without the name and can have only one object that is created by
its definition. Consider the following example.

abstract class Person {

\>abstract void eat();

}

class TestAnonymousInner {

\>public static void main(String args\[\]) {

\>\>Person p = new Person() {

\>\>\>void eat() {

\>\>\>\>System.out.println(\"nice fruits\");

\>\>\>}

\>\>};

\>\>p.eat();

\>}

}

Output:

nice fruits

Consider the following example for the working of the anonymous class
using interface.

interface Eatable {

\>void eat();

}

class TestAnnonymousInner1 {

\>public static void main(String args\[\]) {

\>\>Eatable e = new Eatable() {

\>\>\>public void eat() {

\>\>\>\>System.out.println(\"nice fruits\");

\>\>\>}

\>\>};

\>\>e.eat();

\>}

}

Output:

nice fruits

285. **What is the nested interface?**

An Interface that is declared inside the interface or class is known as
the nested interface. It is static by default. The nested interfaces are
used to group related interfaces so that they can be easy to maintain.
The external interface or class must refer to the nested interface. It
can\'t be accessed directly. The nested interface must be public if it
is declared inside the interface but it can have any access modifier if
declared within the class. The syntax of the nested interface is given
as follows.

interface interface_name {

\>\...

\>interface nested_interface_name {

\>\>\...

\>}

}

286. **Can a class have an interface?**

Yes, an interface can be defined within the class. It is called a nested
interface.

287. **Can an Interface have a class?**

Yes, they are static implicitly.

288. **What is Garbage Collection?**

Garbage collection is a process of reclaiming the unused runtime
objects. It is performed for memory management. In other words, we can
say that It is the process of removing unused objects from the memory to
free up space and make this space available for Java Virtual Machine.
Due to garbage collection java gives 0 as output to a variable whose
value is not set, i.e., the variable has been defined but not
initialized. For this purpose, we were using free() function in the C
language and delete() in C++. In Java, it is performed automatically.
So, java provides better memory management.

289. **What is gc()?**

The gc() method is used to invoke the garbage collector for cleanup
processing. This method is found in System and Runtime classes. This
function explicitly makes the Java Virtual Machine free up the space
occupied by the unused objects so that it can be utilized or reused.
Consider the following example for the better understanding of how the
gc() method invoke the garbage collector.

public class TestGarbage1 {

\>public void finalize() {

\>\>System.out.println(\"object is garbage collected\");

\>}

\>public static void main(String args\[\]) {

\>\>TestGarbage1 s1 = new TestGarbage1();

\>\>TestGarbage1 s2 = new TestGarbage1();

\>\>s1 = null;

\>\>s2 = null;

\>\>System.gc();

\>}

}

Output:

object is garbage collected

object is garbage collected

290. **How is garbage collection controlled?**

Garbage collection is managed by JVM. It is performed when there is not
enough space in the memory and memory is running low. We can externally
call the System.gc() for the garbage collection. However, it depends
upon the JVM whether to perform it or not.

291. **How can an object be unreferenced?**

There are many ways:

-   By nulling the reference

-   By assigning a reference to another

-   By anonymous object etc.

![Java Garbage Collection
Scenario](image65.jpeg){width="6.333333333333333in"
height="4.451388888888889in"}

-   By nulling a reference:

> Employee e=new Employee();
>
> e=null;

-   By assigning a reference to another:

> Employee e1=new Employee();
>
> Employee e2=new Employee();
>
> e1=e2;//now the first object referred by e1 is available for garbage
> collection

-   By anonymous object:

new Employee();

292. **What is the purpose of the finalize() method?**

The finalize() method is invoked just before the object is garbage
collected. It is used to perform cleanup processing. The Garbage
collector of JVM collects only those objects that are created by new
keyword. So if you have created an object without new, you can use the
finalize method to perform cleanup processing (destroying remaining
objects). The cleanup processing is the process to free up all the
resources, network which was previously used and no longer needed. It is
essential to remember that it is not a reserved keyword, finalize method
is present in the object class hence it is available in every class as
object class is the superclass of every class in java. Here, we must
note that neither finalization nor garbage collection is guaranteed.
Consider the following example.

public class FinalizeTest {

\>int j = 12;

\>void add() {

\>\>j = j + 12;

\>\>System.out.println(\"J=\" + j);

\>}

\>public void finalize() {

\>\>System.out.println(\"Object is garbage collected\");

\>}

\>public static void main(String\[\] args) {

\>\>new FinalizeTest().add();

\>\>System.gc();

\>\>new FinalizeTest().add();

\>}

}

293. **Can an unreferenced object be referenced again?**

Yes, see the example below.

public class Resurrect {

\>static Resurrect resurrect = null;

\>public static void main(String\[\] args) {

\>\>Resurrect localInstance = new Resurrect();

\>\>System.out.println(\"first instance: \" + localInstance.hashCode());

\>\>// after this code there is no more reference to the first instance

\>\>localInstance = new Resurrect();

\>\>System.out.println(\"second instance: \" +
localInstance.hashCode());

\>\>// will (in this simple example) request the execution of the
finalize() method of the first instance

\>\>System.gc();

\>}

\>@Override

\>public void finalize() {

\>\>resurrect = this;

\>\>System.out.println(\"resurrected: \" + resurrect.hashCode());

\>}

}

294. **What kind of thread is the Garbage collector thread?**

Daemon thread.

295. **What is the purpose of the Runtime class?**

Java Runtime class is used to interact with a java runtime environment.
Java Runtime class provides methods to execute a process, invoke GC, get
total and free memory, etc. There is only one instance of
java.lang.Runtime class is available for one java application. The
Runtime.getRuntime() method returns the singleton instance of Runtime
class.

296. **How will you invoke any external process in Java?**

By Runtime.getRuntime().exec(?) method. Consider the following example.

public class Runtime1 {

\>public static void main(String args\[\]) throws Exception {

\>\>Runtime.getRuntime().exec(\"notepad\"); //will open a new notepad

\>}

}

297. **Give the hierarchy of InputStream and OutputStream classes.**

OutputStream Hierarchy

![Java output stream hierarchy](image66.png){width="6.5in"
height="2.529861111111111in"}

InputStream Hierarchy

![Java input stream hierarchy](image67.png){width="6.5in"
height="2.529861111111111in"}

298. **What do you understand by an IO stream?**

The stream is a sequence of data that flows from source to destination.
It is composed of bytes. In Java, three streams are created for us
automatically.

-   System.out: standard output stream

-   System.in: standard input stream

-   System.err: standard error stream

299. **What is the difference between the Reader/Writer class hierarchy
     and the InputStream/OutputStream class hierarchy?**

The Reader/Writer class hierarchy is character-oriented, and the
InputStream/OutputStream class hierarchy is byte-oriented. The
ByteStream classes are used to perform input-output of 8-bit bytes
whereas the CharacterStream classes are used to perform the input/output
for the 16-bit Unicode system. There are many classes in the ByteStream
class hierarchy, but the most frequently used classes are
FileInputStream and FileOutputStream. The most frequently used classes
CharacterStream class hierarchy is FileReader and FileWriter.

300. **What are the super most classes for all the streams?**

All the stream classes can be divided into two types of classes that are
ByteStream classes and CharacterStream Classes. The ByteStream classes
are further divided into InputStream classes and OutputStream classes.
CharacterStream classes are also divided into Reader classes and Writer
classes. The SuperMost classes for all the InputStream classes is
java.io.InputStream and for all the output stream classes is
java.io.OutPutStream. Similarly, for all the reader classes, the
super-most class is java.io.Reader, and for all the writer classes, it
is java.io.Writer.

301. **What are the FileInputStream and FileOutputStream?**

Java FileOutputStream is an output stream used for writing data to a
file. If you have some primitive values to write into a file, use
FileOutputStream class. You can write byte-oriented as well as
character-oriented data through the FileOutputStream class. However, for
character-oriented data, it is preferred to use FileWriter than
FileOutputStream. Consider the following example of writing a byte into
a file.

import java.io.FileOutputStream;

public class FileOutputStreamExample {

\>public static void main(String args\[\]) {

\>\>try {

\>\>\>FileOutputStream fout = new
FileOutputStream(\"D:\\\\testout.txt\");

\>\>\>fout.write(65);

\>\>\>fout.close();

\>\>\>System.out.println(\"success\...\");

\>\>} catch (Exception e) {

\>\>\>System.out.println(e);

\>\>}

\>}

}

Java FileInputStream class obtains input bytes from a file. It is used
for reading byte-oriented data (streams of raw bytes) such as image
data, audio, video, etc. You can also read character-stream data.
However, for reading streams of characters, it is recommended to use
FileReader class. Consider the following example for reading bytes from
a file.

import java.io.FileInputStream;

public class DataStreamExample {

\>public static void main(String args\[\]) {

\>\>try {

\>\>\>FileInputStream fin = new FileInputStream(\"D:\\\\testout.txt\");

\>\>\>int i = fin.read();

\>\>\>System.out.print((char) i);

\>\>\>fin.close();

\>\>} catch (Exception e) {

\>\>\>System.out.println(e);

\>\>}

\>}

}

302. **What is the purpose of using BufferedInputStream and
     BufferedOutputStream classes?**

Java BufferedOutputStream class is used for buffering an output stream.
It internally uses a buffer to store data. It adds more efficiency than
to write data directly into a stream. So, it makes the performance fast.
Whereas, Java BufferedInputStream class is used to read information from
the stream. It internally uses the buffer mechanism to make the
performance fast.

303. **How to set the Permissions to a file in Java?**

In Java, FilePermission class is used to alter the permissions set on a
file. Java FilePermission class contains the permission related to a
directory or file. All the permissions are related to the path. The path
can be of two types:

D:\\\\IO\\\\-: It indicates that the permission is associated with all
subdirectories and files recursively.

D:\\\\IO\\\\\*: It indicates that the permission is associated with all
directory and files within this directory excluding subdirectories.

Let\'s see the simple example in which permission of a directory path is
granted with read permission and a file of this directory is granted for
write permission.

package com.javatpoint;

import java.io.\*;

import java.security.PermissionCollection;

public class FilePermissionExample {

\>public static void main(String\[\] args) throws IOException {

\>\>String srg = \"D:\\\\IO Package\\\\java.txt\";

\>\>FilePermission file1 = new FilePermission(\"D:\\\\IO Package\\\\-\",
\"read\");

\>\>PermissionCollection permission = file1.newPermissionCollection();

\>\>permission.add(file1);

\>\>FilePermission file2 = new FilePermission(srg, \"write\");

\>\>permission.add(file2);

\>\>if (permission.implies(new FilePermission(srg, \"read,write\"))) {

\>\>\>System.out.println(\"Read, Write permission is granted for the
path \" + srg);

\>\>} else {

\>\>\>System.out.println(\"No Read, Write permission is granted for the
path \" + srg);

\>\>}

\>}

}

Output

Read, Write permission is granted for the path D:\\IO Package\\java.txt

304. **What are FilterStreams?**

FilterStream classes are used to add additional functionalities to the
other stream classes. FilterStream classes act like an interface which
read the data from a stream, filters it, and pass the filtered data to
the caller. The FilterStream classes provide extra functionalities like
adding line numbers to the destination file, etc.

305. **What is an I/O filter?**

An I/O filter is an object that reads from one stream and writes to
another, usually altering the data in some way as it is passed from one
stream to another. Many Filter classes that allow a user to make a chain
using multiple input streams. It generates a combined effect on several
filters.

306. **In Java, How many ways you can take input from the console?**

In Java, there are three ways by using which, we can take input from the
console.

-   Using BufferedReader class: we can take input from the console by
    wrapping System.in into an InputStreamReader and passing it into the
    BufferedReader. It provides an efficient reading as the input gets
    buffered. Consider the following example.

> import java.io.BufferedReader;
>
> import java.io.IOException;
>
> import java.io.InputStreamReader;
>
> public class Person {
>
> \>public static void main(String\[\] args) throws IOException {
>
> \>\>System.out.println(\"Enter the name of the person\");
>
> \>\>BufferedReader reader = new BufferedReader(new
> InputStreamReader(System.in));
>
> \>\>String name = reader.readLine();
>
> \>\>System.out.println(name);
>
> \>}
>
> }

-   Using Scanner class: The Java Scanner class breaks the input into
    tokens using a delimiter that is whitespace by default. It provides
    many methods to read and parse various primitive values. Java
    Scanner class is widely used to parse text for string and primitive
    types using a regular expression. Java Scanner class extends Object
    class and implements Iterator and Closeable interfaces. Consider the
    following example.

> import java.util.\*;
>
> public class ScannerClassExample2 {
>
> \>public static void main(String args\[\]) {
>
> \>\>String str = \"Hello/This is JavaTpoint/My name is Abhishek.\";
>
> \>\>//Create scanner with the specified String Object\>
>
> \>\>Scanner scanner = new Scanner(str);
>
> \>\>System.out.println(\"Boolean Result: \" +
> scanner.hasNextBoolean());
>
> \>\>//Change the delimiter of this scanner\>
>
> \>\>scanner.useDelimiter(\"/\");
>
> \>\>//Printing the tokenized Strings\>
>
> \>\>System.out.println(\"\-\--Tokenizes String\-\--\");
>
> \>\>while (scanner.hasNext()) {
>
> \>\>\>System.out.println(scanner.next());
>
> \>\>}
>
> \>\>//Display the new delimiter\>
>
> \>\>System.out.println(\"Delimiter used: \" + scanner.delimiter());
>
> \>\>scanner.close();
>
> \>}
>
> }

-   Using Console class: The Java Console class is used to get input
    from the console. It provides methods to read texts and passwords.
    If you read the password using the Console class, it will not be
    displayed to the user. The java.io.Console class is attached to the
    system console internally. The Console class is introduced since
    1.5. Consider the following example.

> import java.io.Console;
>
> class ReadStringTest {
>
> \>public static void main(String args\[\]) {
>
> \>\>Console c = System.console();
>
> \>\>System.out.println(\"Enter your name: \");
>
> \>\>String n = c.readLine();
>
> \>\>System.out.println(\"Welcome \" + n);
>
> \>}
>
> }

307. **What is serialization?**

Serialization in Java is a mechanism of writing the state of an object
into a byte stream. It is used primarily in Hibernate, RMI, JPA, EJB and
JMS technologies. It is mainly used to travel object\'s state on the
network (which is known as marshaling). Serializable interface is used
to perform serialization. It is helpful when you require to save the
state of a program to storage such as the file. At a later point of
time, the content of this file can be restored using deserialization. It
is also required to implement RMI(Remote Method Invocation). With the
help of RMI, it is possible to invoke the method of a Java object on one
machine to another machine.

![java
serialization](image68.png){width="3.7777777777777777in"
height="3.4375in"}

308. **How can you make a class serializable in Java?**

A class can become serializable by implementing the Serializable
interface.

309. **How can you avoid serialization in child class if the base class
     is implementing the Serializable interface?**

It is very tricky to prevent serialization of child class if the base
class is intended to implement the Serializable interface. However, we
cannot do it directly, but the serialization can be avoided by
implementing the writeObject() or readObject() methods in the subclass
and throw NotSerializableException from these methods. Consider the
following example.

import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.IOException;

import java.io.NotSerializableException;

import java.io.ObjectInputStream;

import java.io.ObjectOutputStream;

import java.io.Serializable;

class Person implements Serializable {

\>String name = \" \";

\>public Person(String name) {

\>\>this.name = name;

\>}

}

class Employee extends Person {

\>float salary;

\>public Employee(String name, float salary) {

\>\>super(name);

\>\>this.salary = salary;

\>}

\>private void writeObject(ObjectOutputStream out) throws IOException {

\>\>throw new NotSerializableException();

\>}

\>private void readObject(ObjectInputStream in ) throws IOException {

\>\>throw new NotSerializableException();

\>}

}

public class Test {

\>public static void main(String\[\] args)

\>throws Exception {

\>\>Employee emp = new Employee(\"Sharma\", 10000);

\>\>System.out.println(\"name = \" + emp.name);

\>\>System.out.println(\"salary = \" + emp.salary);

\>\>FileOutputStream fos = new FileOutputStream(\"abc.ser\");

\>\>ObjectOutputStream oos = new ObjectOutputStream(fos);

\>\>oos.writeObject(emp);

\>\>oos.close();

\>\>fos.close();

\>\>System.out.println(\"Object has been serialized\");

\>\>FileInputStream f = new FileInputStream(\"ab.txt\");

\>\>ObjectInputStream o = new ObjectInputStream(f);

\>\>Employee emp1 = (Employee) o.readObject();

\>\>o.close();

\>\>f.close();

\>\>System.out.println(\"Object has been deserialized\");

\>\>System.out.println(\"name = \" + emp1.name);

\>\>System.out.println(\"salary = \" + emp1.salary);

\>}

}

310. **Can a Serialized object be transferred via network?**

Yes, we can transfer a serialized object via network because the
serialized object is stored in the memory in the form of bytes and can
be transmitted over the network. We can also write the serialized object
to the disk or the database.

311. **What is Deserialization?**

Deserialization is the process of reconstructing the object from the
serialized state. It is the reverse operation of serialization. An
ObjectInputStream deserializes objects and primitive data written using
an ObjectOutputStream.

import java.io.\*;

class Depersist {

\>public static void main(String args\[\]) throws Exception {

\>\>ObjectInputStream in = new ObjectInputStream(new
FileInputStream(\"f.txt\"));

\>\>Student s = (Student) in .readObject();

\>\>System.out.println(s.id + \" \" + s.name);

\>\>in .close();

\>}

}

211 ravi

312. **What is the transient keyword?**

If you define any data member as transient, it will not be serialized.
By determining transient keyword, the value of variable need not persist
when it is restored.

313. **What is the difference between Serializable and Externalizable
     interface?**

![](image69.png){width="6.5in"
height="3.7083333333333335in"}

314. **Give a brief description of Java socket programming?**

Java Socket programming is used for communication between the
applications running on different JRE. Java Socket programming can be
connection-oriented or connectionless. Socket and ServerSocket classes
are used for connection-oriented socket programming and DatagramSocket,
and DatagramPacket classes are used for connectionless socket
programming. The client in socket programming must know two information:

-   IP address of the server

-   port number

315. **What is Socket?**

A socket is simply an endpoint for communications between the machines.
It provides the connection mechanism to connect the two computers using
TCP. The Socket class can be used to create a socket.

316. **What are the steps that are followed when two computers connect
     through TCP?**

There are the following steps that are performed when two computers
connect through TCP.

-   The ServerSocket object is instantiated by the server which denotes
    the port number to which, the connection will be made.

-   After instantiating the ServerSocket object, the server invokes
    accept() method of ServerSocket class which makes server wait until
    the client attempts to connect to the server on the given port.

-   Meanwhile, the server is waiting, a socket is created by the client
    by instantiating Socket class. The socket class constructor accepts
    the server port number and server name.

-   The Socket class constructor attempts to connect with the server on
    the specified name. If the connection is established, the client
    will have a socket object that can communicate with the server.

-   The accept() method invoked by the server returns a reference to the
    new socket on the server that is connected with the server.

317. **Write a program in Java to establish a connection between client
     and server?**

Consider the following program where the connection between the client
and server is established.

File: MyServer.java

import java.io.\*;

import java.net.\*;

public class MyServer {

\>public static void main(String\[\] args) {

\>\>try {

\>\>\>ServerSocket ss = new ServerSocket(6666);

\>\>\>Socket s = ss.accept(); //establishes connection

\>\>\>DataInputStream dis = new DataInputStream(s.getInputStream());

\>\>\>String str = (String) dis.readUTF();

\>\>\>System.out.println(\"message= \" + str);

\>\>\>ss.close();

\>\>} catch (Exception e) {

\>\>\>System.out.println(e);

\>\>}

\>}

}

File: MyClient.java

import java.io.\*;

import java.net.\*;

public class MyClient {

\>public static void main(String\[\] args) {

\>\>try {

\>\>\>Socket s = new Socket(\"localhost\", 6666);

\>\>\>DataOutputStream dout = new DataOutputStream(s.getOutputStream());

\>\>\>dout.writeUTF(\"Hello Server\");

\>\>\>dout.flush();

\>\>\>dout.close();

\>\>\>s.close();

\>\>} catch (Exception e) {

\>\>\>System.out.println(e);

\>\>}

\>}

}

318. **How do I convert a numeric IP address like 192.18.97.39 into a
     hostname like java.sun.com?**

By InetAddress.getByName(\"192.18.97.39\").getHostName() where
192.18.97.39 is the IP address. Consider the following example.

import java.io.\*;

import java.net.\*;

public class InetDemo {

\>public static void main(String\[\] args) {

\>\>try {

\>\>\>InetAddress ip = InetAddress.getByName(\"195.201.10.8\");

\>\>\>System.out.println(\"Host Name: \" + ip.getHostName());

\>\>} catch (Exception e) {

\>\>\>System.out.println(e);

\>\>}

\>}

}

319. **What is the purpose of using java.lang.Class class?**

The java.lang.Class class performs mainly two tasks:

-   Provides methods to get the metadata of a class at runtime.

-   Provides methods to examine and change the runtime behavior of a
    class.

320. **What are the ways to instantiate the Class class?**

There are three ways to instantiate the Class class.

-   forName() method of Class class: The forName() method is used to
    load the class dynamically. It returns the instance of Class class.
    It should be used if you know the fully qualified name of the class.
    This cannot be used for primitive types.

-   getClass() method of Object class: It returns the instance of Class
    class. It should be used if you know the type. Moreover, it can be
    used with primitives.

-   the .class syntax: If a type is available, but there is no instance
    then it is possible to obtain a Class by appending \".class\" to the
    name of the type. It can be used for primitive data type also.

321. **What is the output of the following Java program?**

class Simple {

\>public Simple() {

\>\>System.out.println(\"Constructor of Simple class is invoked\");

\>}

\>void message() {

\>\>System.out.println(\"Hello Java\");

\>}

}

class Test1 {

\>public static void main(String args\[\]) {

\>\>try {

\>\>\>Class c = Class.forName(\"Simple\");

\>\>\>Simple s = (Simple) c.newInstance();

\>\>\>s.message();

\>\>} catch (Exception e) {

\>\>\>System.out.println(e);

\>\>}

\>}

}

Output

Constructor of Simple class is invoked

Hello Java

Explanation

The newInstance() method of the Class class is used to invoke the
constructor at runtime. In this program, the instance of the Simple
class is created.

322. **What is the purpose of using javap?**

The javap command disassembles a class file. The javap command displays
information about the fields, constructors and methods present in a
class file.

Syntax

javap fully_class_name

323. **Can you access the private method from outside the class?**

Yes, by changing the runtime behavior of a class if the class is not
secured.

324. **What are autoboxing and unboxing? When does it occur?**

The autoboxing is the process of converting primitive data type to the
corresponding wrapper class object, eg., int to Integer. The unboxing is
the process of converting wrapper class object to primitive data type.
For eg., integer to int. Unboxing and autoboxing occur automatically in
Java. However, we can externally convert one into another by using the
methods like valueOf() or xxxValue().

It can occur whenever a wrapper class object is expected, and primitive
data type is provided or vice versa.

-   Adding primitive types into Collection like ArrayList in Java.

-   Creating an instance of parameterized classes ,e.g., ThreadLocal
    which expect Type.

-   Java automatically converts primitive to object whenever one is
    required and another is provided in the method calling.

-   When a primitive type is assigned to an object type.

325. **What is the output of the below Java program?**

public class Test1 {

\>public static void main(String\[\] args) {

\>\>Integer i = new Integer(201);

\>\>Integer j = new Integer(201);

\>\>if (i == j) {

\>\>\>System.out.println(\"hello\");

\>\>} else {

\>\>\>System.out.println(\"bye\");

\>\>}

\>}

}

Output

bye

Explanation

Above we create two Integer objects, which is the wrapper class of int.
In case of objects the == operator checks equality by reference, so
checks if the two variables point to the same object. Even though the
two objects hold the same value, they are two separate objects, so i ==
j will return false.

326. **What are the advantages and disadvantages of object cloning?**

Advantages of Object Cloning

-   You don\'t need to write lengthy and repetitive codes. Just use an
    abstract class with a 4- or 5-line long clone() method.

-   It is the easiest and most efficient way of copying objects,
    especially if we are applying it to an already developed or an old
    project. Just define a parent class, implement Cloneable in it,
    provide the definition of the clone() method and the task will be
    done.

-   Clone() is the fastest way to copy the array.

Disadvantages of Object Cloning

-   To use the Object.clone() method, we have to change many syntaxes to
    our code, like implementing a Cloneable interface, defining the
    clone() method and handling CloneNotSupportedException, and finally,
    calling Object.clone(), etc.

-   We have to implement the Cloneable interface while it does not have
    any methods in it. We have to use it to tell the JVM that we can
    perform a clone() on our object.

-   Object.clone() is protected, so we have to provide our own clone()
    and indirectly call Object.clone() from it.

-   Object.clone() does not invoke any constructor, so we do not have
    any control over object construction.

-   If you want to write a clone method in a child class, then all of
    its superclasses should define the clone() method in them or inherit
    it from another parent class. Otherwise, the super.clone() chain
    will fail.

-   Object.clone() supports only shallow copying, but we will need to
    override it if we need deep cloning.

327. **What is a native method?**

A native method is a method that is implemented in a language other than
Java. Natives methods are sometimes also referred to as foreign methods.

328. **What is the purpose of the strictfp keyword?**

Java strictfp keyword ensures that you will get the same result on every
platform if you perform operations in the floating-point variable. The
precision may differ from platform to platform that is why java
programming language has provided the strictfp keyword so that you get
the same result on every platform. So, now you have better control over
the floating-point arithmetic.

It can be used for classes, methods or interfaces. Example:

public strictfp class ScientificCalculator {

\>public double sum(double value1, double value2) {

\>\>return value1 + value2;

\>}

\>public double diff(double value1, double value2) {

\>\>return value1 - value2;

\>}

}

public strictfp void calculateMarksPercentage() {

\>\...

}

public strictfp interface Circle {

\>double computeArea(double radius);

}

329. **What is the purpose of the System class?**

The purpose of the System class is to provide access to system resources
such as standard input and output. It cannot be instantiated. Facilities
provided by System class are given below.

-   Standard input

-   Error output streams

-   Standard output

-   utility method to copy the portion of an array

-   utilities to load files and libraries

There are the three fields of Java System class, i.e., static
printstream err, static inputstream in, and standard output stream.

330. **What comes to mind when someone mentions a shallow copy in
     Java?**

Object cloning.

331. **Write a Java program that prints all the values given at
     command-line.**

Program

class A {

\>public static void main(String args\[\]) {

\>\>for (int i = 0; i \< args.length; i++)

\>\>\>System.out.println(args\[i\]);

\>}

}

compile by \> javac A.java

run by \> java A sonoo jaiswal 1 3 abc

Output

sonoo

jaiswal

1

3

abc

332. **Which containers use a border layout as their default layout?**

The Window, Frame and Dialog classes use a border layout as their
default layout.

333. **Which containers use a FlowLayout as their default layout?**

The Panel and Applet classes use the FlowLayout as their default layout.

334. **What are peerless components?**

The lightweight component of Swing is called peerless components. Spring
has its libraries, so it does not use resources from the Operating
System, and hence it has lightweight components.

335. **is there is any difference between a Scrollbar and a
     ScrollPane?**

The Scrollbar is a Component whereas the ScrollPane is a Container. A
ScrollPane handles its events and performs its scrolling.

336. **What is a lightweight component?**

Lightweight components are the one which does not go with the native
call to obtain the graphical units. They share their parent component
graphical units to render them. For example, Swing components, and
JavaFX Components.

337. **What is a heavyweight component?**

The portable elements provided by the operating system are called
heavyweight components. AWT is limited to the graphical classes provided
by the operating system and therefore, It implements only the minimal
subset of screen elements supported by all platforms. The Operating
system dependent UI discovery tools are called heavyweight components.

338. **What is an applet?**

An applet is a small java program that runs inside the browser and
generates dynamic content. It is embedded in the webpage and runs on the
client side. It is secured and takes less response time. It can be
executed by browsers running under many platforms, including Linux,
Windows, Mac Os, etc. However, the plugins are required at the client
browser to execute the applet. The following image shows the
architecture of Applet.

![hierarchy of
applet](image70.jpeg){width="1.5451388888888888in"
height="4.788194444444445in"}

339. **Can you write a Java class that could be used both as an applet
     as well as an application?**

Yes. Add a main() method to the applet.

340. **What is Locale?**

A Locale object represents a specific geographical, political, or
cultural region. This object can be used to get the locale-specific
information such as country name, language, variant, etc.

import java.util.\*;

public class LocaleExample {

\>public static void main(String\[\] args) {

\>\>Locale locale = Locale.getDefault();

\>\>//Locale locale=new Locale(\"fr\",\"fr\");//for the specific locale

\>\>System.out.println(locale.getDisplayCountry());

\>\>System.out.println(locale.getDisplayLanguage());

\>\>System.out.println(locale.getDisplayName());

\>\>System.out.println(locale.getISO3Country());

\>\>System.out.println(locale.getISO3Language());

\>\>System.out.println(locale.getLanguage());

\>\>System.out.println(locale.getCountry());

\>}

}

Output:

United States

English

English (United States)

USA

eng

en

US

341. **How will you load a specific locale?**

By ResourceBundle.getBundle(?) method.

342. **What is a JavaBean?**

JavaBean is a reusable software component written in the Java
programming language, designed to be manipulated visually by a software
development environment, like JBuilder or VisualAge for Java. t. A
JavaBean encapsulates many objects into one object so that we can access
this object from multiple places. Moreover, it provides the easy
maintenance. Consider the following example to create a JavaBean class.

//Employee.java

package mypack;

public class Employee implements java.io.Serializable {

\>private int id;

\>private String name;

\>public Employee() {}

\>public void setId(int id) {

\>\>this.id = id;

\>}

\>public int getId() {

\>\>return id;

\>}

\>public void setName(String name) {

\>\>this.name = name;

\>}

\>public String getName() {

\>\>return name;

\>}

}

343. **What is the purpose of using the Java bean?**

According to Java white paper, it is a reusable software component. A
bean encapsulates many objects into one object so that we can access
this object from multiple places. Moreover, it provides the easy
maintenance.

344. **What do you understand by the bean persistent property?**

The persistence property of Java bean comes into the act when the
properties, fields, and state information are saved to or retrieve from
the storage.

345. **What is RMI?**

The RMI (Remote Method Invocation) is an API that provides a mechanism
to create the distributed application in java. The RMI allows an object
to invoke methods on an object running in another JVM. The RMI provides
remote communication between the applications using two objects stub and
skeleton.

346. **What is the purpose of stub and skeleton?**

Stub

The stub is an object, acts as a gateway for the client side. All the
outgoing requests are routed through it. It resides at the client side
and represents the remote object. When the caller invokes the method on
the stub object, it does the following tasks:

-   It initiates a connection with remote Virtual Machine (JVM).

-   It writes and transmits (marshals) the parameters to the remote
    Virtual Machine (JVM).

-   It waits for the result.

-   It reads (unmarshals) the return value or exception.

-   It finally, returns the value to the caller.

Skeleton

The skeleton is an object, acts as a gateway for the server side object.
All the incoming requests are routed through it. When the skeleton
receives the incoming request, it does the following tasks:

-   It reads the parameter for the remote method.

-   It invokes the method on the actual remote object.

-   It writes and transmits (marshals) the result to the caller.

347. **What are the steps involved to write RMI based programs?**

There are 6 steps which are performed to write RMI based programs.

-   Create the remote interface.

-   Provide the implementation of the remote interface.

-   Compile the implementation class and create the stub and skeleton
    objects using the rmic tool.

-   Start the registry service by the rmiregistry tool.

-   Create and start the remote application.

-   Create and start the client application.

348. **What is the use of HTTP-tunneling in RMI?**

HTTP tunneling can be defined as the method which doesn\'t need any
setup to work within the firewall environment. It handles the HTTP
connections through the proxy servers. However, it does not allow
outbound TCP connections.

349. **What is JRMP?**

JRMP (Java Remote Method Protocol) can be defined as the Java-specific,
stream-based protocol which looks up and refers to the remote objects.
It requires both client and server to use Java objects. It is wire level
protocol which runs under RMI and over TCP/IP.

350. **Can RMI and CORBA based applications interact?**

Yes, they can. RMI is available with IIOP as the transport protocol
instead of JRMP.

351. **How to perform Bubble Sort in Java?**

Consider the following program to perform Bubble sort in Java.

public class BubbleSort {

\>public static void main(String\[\] args) {

\>\>int\[\] a = {

\>\>\>10, 9, 7, 101, 23, 44, 12, 78, 34, 23

\>\>};

\>\>for (int i = 0; i \< 10; i++) {

\>\>\>for (int j = 0; j \< 10; j++) {

\>\>\>\>if (a\[i\] \< a\[j\]) {

\>\>\>\>\>int temp = a\[i\];

\>\>\>\>\>a\[i\] = a\[j\];

\>\>\>\>\>a\[j\] = temp;

\>\>\>\>}

\>\>\>}

\>\>}

\>\>System.out.println(\"Printing Sorted List \...\");

\>\>for (int i = 0; i \< 10; i++) {

\>\>\>System.out.println(a\[i\]);

\>\>}

\>}

}

Output:

Printing Sorted List . . .

7

9

10

12

23

34

34

44

78

101

352. **How to perform Binary Search in Java?**

Consider the following program to perform the binary search in Java.

import java.util.\*;

public class BinarySearch {

\>public static void main(String\[\] args) {

\>\>int\[\] arr = {

\>\>\>16, 19, 20, 23, 45, 56, 78, 90, 96, 100

\>\>};

\>\>int item, location = -1;

\>\>System.out.println(\"Enter the item which you want to search\");

\>\>Scanner sc = new Scanner(System.in);

\>\>item = sc.nextInt();

\>\>location = binarySearch(arr, 0, 9, item);

\>\>if (location != -1)

\>\>\>System.out.println(\"the location of the item is \" + location);

\>\>else

\>\>\>System.out.println(\"Item not found\");

\>}

\>public static int binarySearch(int\[\] a, int beg, int end, int item)
{

\>\>int mid;

\>\>if (end \>= beg) {

\>\>\>mid = (beg + end) / 2;

\>\>\>if (a\[mid\] == item) {

\>\>\>\>return mid + 1;

\>\>\>} else if (a\[mid\] \< item) {

\>\>\>\>return binarySearch(a, mid + 1, end, item);

\>\>\>} else {

\>\>\>\>return binarySearch(a, beg, mid - 1, item);

\>\>\>}

\>\>}

\>\>return -1;

\>}

}

Output:

Enter the item which you want to search

45

the location of the item is 5

353. **How to perform Selection Sort in Java?**

Consider the following program to perform selection sort in Java.

public class SelectionSort {

\>public static void main(String\[\] args) {

\>\>int\[\] a = {

\>\>\>10, 9, 7, 101, 23, 44, 12, 78, 34, 23

\>\>};

\>\>int i, j, k, pos, temp;

\>\>for (i = 0; i \< 10; i++) {

\>\>\>pos = smallest(a, 10, i);

\>\>\>temp = a\[i\];

\>\>\>a\[i\] = a\[pos\];

\>\>\>a\[pos\] = temp;

\>\>}

\>\>System.out.println(\"\\nprinting sorted elements\...\\n\");

\>\>for (i = 0; i \< 10; i++) {

\>\>\>System.out.println(a\[i\]);

\>\>}

\>}

\>public static int smallest(int a\[\], int n, int i) {

\>\>int small, pos, j;

\>\>small = a\[i\];

\>\>pos = i;

\>\>for (j = i + 1; j \< 10; j++) {

\>\>\>if (a\[j\] \< small) {

\>\>\>\>small = a\[j\];

\>\>\>\>pos = j;

\>\>\>}

\>\>}

\>\>return pos;

\>}

}

Output:

printing sorted elements\...

7

9

10

12

23

23

34

44

78

101

354. **How to perform Linear Search in Java?**

Consider the following program to perform Linear search in Java.

import java.util.Scanner;

public class Leniear_Search {

\>public static void main(String\[\] args) {

\>\>int\[\] arr = {

\>\>\>10, 23, 15, 8, 4, 3, 25, 30, 34, 2, 19

\>\>};

\>\>int item, flag = 0;

\>\>Scanner sc = new Scanner(System.in);

\>\>System.out.println(\"Enter Item ?\");

\>\>item = sc.nextInt();

\>\>for (int i = 0; i \< 10; i++) {

\>\>\>if (arr\[i\] == item) {

\>\>\>\>flag = i + 1;

\>\>\>\>break;

\>\>\>} else

\>\>\>\>flag = 0;

\>\>}

\>\>if (flag != 0) {

\>\>\>System.out.println(\"Item found at location\" + flag);

\>\>} else

\>\>\>System.out.println(\"Item not found\");

\>}

}

Output:

Enter Item ?

23

Item found at location 2

Enter Item ?

22

Item not found

355. **How to perform merge sort in Java?**

Consider the following program to perform merge sort in Java.

public class MyMergeSort {

\>void merge(int arr\[\], int beg, int mid, int end) {

\>\>int l = mid - beg + 1;

\>\>int r = end - mid;

\>\>intLeftArray\[\] = new int\[l\];

\>\>intRightArray\[\] = new int\[r\];

\>\>for (int i = 0; i \< l; ++i)

\>\>\>LeftArray\[i\] = arr\[beg + i\];

\>\>for (int j = 0; j \< r; ++j)

\>\>\>RightArray\[j\] = arr\[mid + 1 + j\];

\>\>int i = 0, j = 0;

\>\>int k = beg;

\>\>while (i \< l && j \< r) {

\>\>\>if (LeftArray\[i\] \<= RightArray\[j\]) {

\>\>\>\>arr\[k\] = LeftArray\[i\];

\>\>\>\>i++;

\>\>\>} else {

\>\>\>\>arr\[k\] = RightArray\[j\];

\>\>\>\>j++;

\>\>\>}

\>\>\>k++;

\>\>}

\>\>while (i \< l) {

\>\>\>arr\[k\] = LeftArray\[i\];

\>\>\>i++;

\>\>\>k++;

\>\>}

\>\>while (j \< r) {

\>\>\>arr\[k\] = RightArray\[j\];

\>\>\>j++;

\>\>\>k++;

\>\>}

\>}

\>void sort(int arr\[\], int beg, int end) {

\>\>if (beg \< end) {

\>\>\>int mid = (beg + end) / 2;

\>\>\>sort(arr, beg, mid);

\>\>\>sort(arr, mid + 1, end);

\>\>\>merge(arr, beg, mid, end);

\>\>}

\>}

\>public static void main(String args\[\]) {

\>\>intarr\[\] = {

\>\>\>90,23,101,45,65,23,67,89,34,23

\>\>};

\>\>MyMergeSort ob = new MyMergeSort();

\>\>ob.sort(arr, 0, arr.length - 1);

\>\>System.out.println(\"\\nSorted array\");

\>\>for (int i = 0; i \< arr.length; i++) {

\>\>\>System.out.println(arr\[i\] + \"\");

\>\>}

\>}

}

356. **How to perform quicksort in Java?**

Consider the following program to perform quicksort in Java.

public class QuickSort {

\>public static void main(String\[\] args) {

\>\>int i;

\>\>int\[\] arr = {

\>\>\>90, 23, 101, 45, 65, 23, 67, 89, 34, 23

\>\>};

\>\>quickSort(arr, 0, 9);

\>\>System.out.println(\"\\n The sorted array is: \\n\");

\>\>for (i = 0; i \< 10; i++)

\>\>\>System.out.println(arr\[i\]);

\>}

\>public static int partition(int a\[\], int beg, int end) {

\>\>int left, right, temp, loc, flag;

\>\>loc = left = beg;

\>\>right = end;

\>\>flag = 0;

\>\>while (flag != 1) {

\>\>\>while ((a\[loc\] \<= a\[right\]) && (loc != right))

\>\>\>\>right\--;

\>\>\>if (loc == right)

\>\>\>\>flag = 1;

\>\>\>else if (a\[loc\] \> a\[right\]) {

\>\>\>\>temp = a\[loc\];

\>\>\>\>a\[loc\] = a\[right\];

\>\>\>\>a\[right\] = temp;

\>\>\>\>loc = right;

\>\>\>}

\>\>\>if (flag != 1) {

\>\>\>\>while ((a\[loc\] \>= a\[left\]) && (loc != left))

\>\>\>\>\>left++;

\>\>\>\>if (loc == left)

\>\>\>\>\>flag = 1;

\>\>\>\>else if (a\[loc\] \< a\[left\]) {

\>\>\>\>\>temp = a\[loc\];

\>\>\>\>\>a\[loc\] = a\[left\];

\>\>\>\>\>a\[left\] = temp;

\>\>\>\>\>loc = left;

\>\>\>\>}

\>\>\>}

\>\>}

\>\>returnloc;

\>}

\>static void quickSort(int a\[\], int beg, int end) {

\>\>int loc;

\>\>if (beg \< end) {

\>\>\>loc = partition(a, beg, end);

\>\>\>quickSort(a, beg, loc - 1);

\>\>\>quickSort(a, loc + 1, end);

\>\>}

\>}

}

Output:

The sorted array is:

23

23

23

34

45

65

67

89

90

101

357. **Write a program in Java to create a doubly linked list containing
     n nodes.**

Consider the following program to create a doubly linked list containing
n nodes.

public class CountList {

\>//Represent a node of the doubly linked list

\>class Node {

\>\>int data;

\>\>Node previous;

\>\>Node next;

\>\>public Node(int data) {

\>\>\>this.data = data;

\>\>}

\>}

\>//Represent the head and tail of the doubly linked list

\>Node head, tail = null;

\>//addNode() will add a node to the list

\>public void addNode(int data) {

\>\>//Create a new node

\>\>Node newNode = new Node(data);

\>\>//If list is empty

\>\>if (head == null) {

\>\>\>//Both head and tail will point to newNode

\>\>\>head = tail = newNode;

\>\>\>//head\'s previous will point to null

\>\>\>head.previous = null;

\>\>\>//tail\'s next will point to null, as it is the last node of the
list

\>\>\>tail.next = null;

\>\>} else {

\>\>\>//newNode will be added after tail such that tail\'s next will
point to newNode

\>\>\>tail.next = newNode;

\>\>\>//newNode\'s previous will point to tail

\>\>\>newNode.previous = tail;

\>\>\>//newNode will become new tail

\>\>\>tail = newNode;

\>\>\>//As it is last node, tail\'s next will point to null

\>\>\>tail.next = null;

\>\>}

\>}

\>//countNodes() will count the nodes present in the list

\>public int countNodes() {

\>\>int counter = 0;

\>\>//Node current will point to head

\>\>Node current = head;

\>\>while (current != null) {

\>\>\>//Increment the counter by 1 for each node

\>\>\>counter++;

\>\>\>current = current.next;

\>\>}

\>\>return counter;

\>}

\>//display() will print out the elements of the list

\>public void display() {

\>\>//Node current will point to head

\>\>Node current = head;

\>\>if (head == null) {

\>\>\>System.out.println(\"List is empty\");

\>\>\>return;

\>\>}

\>\>System.out.println(\"Nodes of doubly linked list: \");

\>\>while (current != null) {

\>\>\>//Prints each node by incrementing the pointer.

\>\>\>System.out.print(current.data + \" \");

\>\>\>current = current.next;

\>\>}

\>}

\>public static void main(String\[\] args) {

\>\>CountList dList = new CountList();

\>\>//Add nodes to the list

\>\>dList.addNode(1);

\>\>dList.addNode(2);

\>\>dList.addNode(3);

\>\>dList.addNode(4);

\>\>dList.addNode(5);

\>\>//Displays the nodes present in the list

\>\>dList.display();

\>\>//Counts the nodes present in the given list

\>\>System.out.println(\"\\nCount of nodes present in the list: \" +
dList.countNodes());

\>}

}

Output:

Nodes of doubly linked list:

1 2 3 4 5

Count of nodes present in the list: 5

358. **Write a program in Java to find the maximum and minimum value
     node from a circular linked list.**

Consider the following program.

public class MinMax {

\>//Represents the node of list.

\>public class Node {

\>\>int data;

\>\>Node next;

\>\>public Node(int data) {

\>\>\>this.data = data;

\>\>}

\>}

\>//Declaring head and tail pointer as null.

\>public Node head = null;

\>public Node tail = null;

\>//This function will add the new node at the end of the list.

\>public void add(int data) {

\>\>//Create new node

\>\>Node newNode = new Node(data);

\>\>//Checks if the list is empty.

\>\>if (head == null) {

\>\>\>//If list is empty, both head and tail would point to new node

\>\>\>head = newNode;

\>\>\>tail = newNode;

\>\>\>newNode.next = head;

\>\>} else {

\>\>\>//tail will point to new node.

\>\>\>tail.next = newNode;

\>\>\>//New node will become new tail.

\>\>\>tail = newNode;

\>\>\>//Since, it is circular linked list tail will points to head.

\>\>\>tail.next = head;

\>\>}

\>}

\>//Finds out the minimum value node in the list

\>public void minNode() {

\>\>Node current = head;

\>\>//Initializing min to initial node data

\>\>int min = head.data;

\>\>if (head == null) {

\>\>\>System.out.println(\"List is empty\");

\>\>} else {

\>\>\>do {

\>\>\>\>//If current node\'s data is smaller than min

\>\>\>\>//Then replace value of min with current node\'s data

\>\>\>\>if (min \> current.data) {

\>\>\>\>\>min = current.data;

\>\>\>\>}

\>\>\>\>current = current.next;

\>\>\>} while (current != head);

\>\>\>System.out.println(\"Minimum value node in the list: \" + min);

\>\>}

\>}

\>//Finds out the maximum value node in the list

\>public void maxNode() {

\>\>Node current = head;

\>\>//Initializing max to initial node data

\>\>int max = head.data;

\>\>if (head == null) {

\>\>\>System.out.println(\"List is empty\");

\>\>} else {

\>\>\>do {

\>\>\>\>//If current node\'s data is greater than max

\>\>\>\>//Then replace value of max with current node\'s data

\>\>\>\>if (max \< current.data) {

\>\>\>\>\>max = current.data;

\>\>\>\>}

\>\>\>\>current = current.next;

\>\>\>} while (current != head);

\>\>\>System.out.println(\"Maximum value node in the list: \" + max);

\>\>}

\>}

\>public static void main(String\[\] args) {

\>\>MinMax cl = new MinMax();

\>\>//Adds data to the list

\>\>cl.add(5);

\>\>cl.add(20);

\>\>cl.add(10);

\>\>cl.add(1);

\>\>//Prints the minimum value node in the list

\>\>cl.minNode();

\>\>//Prints the maximum value node in the list

\>\>cl.maxNode();

\>}

}

Output:

Minimum value node in the list: 1

Maximum value node in the list: 20

359. **Write a program in Java to calculate the difference between the
     sum of the odd level and even level nodes of a Binary Tree.**

Consider the following program.

public class DiffOddEven {

\>//Represent a node of binary tree

\>public static class Node {

\>\>int data;

\>\>Node left;

\>\>Node right;

\>\>public Node(int data) {

\>\>\>//Assign data to the new node, set left and right children to null

\>\>\>this.data = data;

\>\>\>this.left = null;

\>\>\>this.right = null;

\>\>}

\>}

\>//Represent the root of binary tree

\>public Node root;

\>public DiffOddEven() {

\>\>root = null;

\>}

\>//difference() will calculate the difference between sum of odd and
even levels of binary tree

\>public int difference() {

\>\>int oddLevel = 0, evenLevel = 0, diffOddEven = 0;

\>\>//Variable nodesInLevel keep tracks of number of nodes in each level

\>\>int nodesInLevel = 0;

\>\>//Variable currentLevel keep track of level in binary tree

\>\>int currentLevel = 0;

\>\>//Queue will be used to keep track of nodes of tree level-wise

\>\>Queue \< Node \> queue = new LinkedList \< Node \> ();

\>\>//Check if root is null

\>\>if (root == null) {

\>\>\>System.out.println(\"Tree is empty\");

\>\>\>return 0;

\>\>} else {

\>\>\>//Add root node to queue as it represents the first level

\>\>\>queue.add(root);

\>\>\>currentLevel++;

\>\>\>while (queue.size() != 0) {

\>\>\>\>//Variable nodesInLevel will hold the size of queue i.e. number
of elements in queue

\>\>\>\>nodesInLevel = queue.size();

\>\>\>\>while (nodesInLevel \> 0) {

\>\>\>\>\>Node current = queue.remove();

\>\>\>\>\>//Checks if currentLevel is even or not.

\>\>\>\>\>if (currentLevel % 2 == 0)

\>\>\>\>\>\>//If level is even, add nodes\'s to variable evenLevel

\>\>\>\>\>\>evenLevel += current.data;

\>\>\>\>\>else

\>\>\>\>\>\>//If level is odd, add nodes\'s to variable oddLevel

\>\>\>\>\>\>oddLevel += current.data;

\>\>\>\>\>//Adds left child to queue

\>\>\>\>\>if (current.left != null)

\>\>\>\>\>\>queue.add(current.left);

\>\>\>\>\>//Adds right child to queue

\>\>\>\>\>if (current.right != null)

\>\>\>\>\>\>queue.add(current.right);

\>\>\>\>\>nodesInLevel\--;

\>\>\>\>}

\>\>\>\>currentLevel++;

\>\>\>}

\>\>\>//Calculates difference between oddLevel and evenLevel

\>\>\>diffOddEven = Math.abs(oddLevel - evenLevel);

\>\>}

\>\>return diffOddEven;

\>}

\>public static void main(String\[\] args) {

\>\>DiffOddEven bt = new DiffOddEven();

\>\>//Add nodes to the binary tree

\>\>bt.root = new Node(1);

\>\>bt.root.left = new Node(2);

\>\>bt.root.right = new Node(3);

\>\>bt.root.left.left = new Node(4);

\>\>bt.root.right.left = new Node(5);

\>\>bt.root.right.right = new Node(6);

\>\>//Display the difference between sum of odd level and even level
nodes

\>\>System.out.println(\"Difference between sum of odd level and even
level nodes: \" + bt.difference());

\>}

}

Output:

Difference between sum of odd level and even level nodes: 11

360. **What is multithreading?**

Multithreading is a process of executing multiple threads
simultaneously. Multithreading is used to obtain the multitasking. It
consumes less memory and gives the fast and efficient performance. Its
main advantages are:

-   Threads share the same address space.

-   The thread is lightweight.

-   The cost of communication between the processes is low.

361. **What is the thread?**

A thread is a lightweight subprocess. It is a separate path of execution
because each thread runs in a different stack frame. A process may
contain multiple threads. Threads share the process resources, but
still, they execute independently. In Java, all the programs will have
at least one thread which is known as the main thread. This main thread
is created by the JVM when the program starts its execution. The main
thread is used to invoke the main() of the program.

362. **Differentiate between process and thread?**

There are the following differences between the process and thread.

-   A Program in the execution is called the process whereas; A thread
    is a subset of the process

-   Processes are independent whereas threads are the subset of process.

-   Process have different address space in memory, while threads
    contain a shared address space.

-   Context switching is faster between the threads as compared to
    processes.

-   Inter-process communication is slower and expensive than
    inter-thread communication.

-   Any change in Parent process doesn\'t affect the child process
    whereas changes in parent thread can affect the child thread.

![Java
Multithreading](image71.png){width="5.604166666666667in"
height="5.979166666666667in"}

![](image72.png){width="6.5in"
height="3.9819444444444443in"}

363. **What do you understand by inter-thread communication?**

-   The process of communication between synchronized threads is termed
    as inter-thread communication.

-   Inter-thread communication is used to avoid thread polling in Java.

-   The thread is paused running in its critical section, and another
    thread is allowed to enter (or lock) in the same critical section to
    be executed.

-   It can be obtained by wait(), notify(), and notifyAll() methods.

364. **What is the purpose of wait() method in Java?**

The wait() method is provided by the Object class in Java. This method
is used for inter-thread communication in Java. The
java.lang.Object.wait() is used to pause the current thread, and wait
until another thread does not call the notify() or notifyAll() method.
Its syntax is given below.

public final void wait()

wait () method is used to make the thread to wait in the waiting pool.
When the wait () method is executed during a thread execution then
immediately the thread gives up the lock on the object and goes to the
waiting pool. Wait () method tells the thread to wait for a given amount
of time.

Then the thread will wake up after notify () (or) notify all () method
is called.

Wait() and the other above-mentioned methods do not give the lock on the
object immediately until the currently executing thread completes the
synchronized code. It is mostly used in synchronization.

Example:

public static void main(String\[\] args) {

\>Thread t = new Thread();

\>t.start();

\>Synchronized(t) {

\>\>Wait();

\>}

}

365. **Why must wait() method be called from the synchronized block?**

We must call the wait method otherwise it will throw
java.lang.IllegalMonitorStateException exception. Moreover, we need
wait() method for inter-thread communication with notify() and
notifyAll(). Therefore It must be present in the synchronized block for
the proper and correct communication.

366. **What are the advantages of multithreading?**

Multithreading programming has the following advantages:

-   Multithreading allows an application/program to be always reactive
    for input, even already running with some background tasks

-   Multithreading allows the faster execution of tasks, as threads
    execute independently.

-   Multithreading provides better utilization of cache memory as
    threads share the common memory resources.

-   Multithreading reduces the number of the required server as one
    server can execute multiple threads at a time.

367. **What are the states in the lifecycle of a Thread?**

A thread can have one of the following states during its lifetime:

-   New: In this state, a Thread class object is created using a new
    operator, but the thread is not alive. Thread doesn\'t start until
    we call the start() method.

-   Runnable: In this state, the thread is ready to run after calling
    the start() method. However, the thread is not yet selected by the
    thread scheduler.

-   Running: In this state, the thread scheduler picks the thread from
    the ready state, and the thread is running.

-   Waiting/Blocked: In this state, a thread is not running but still
    alive, or it is waiting for the other thread to finish.

-   Dead/Terminated: A thread is in terminated or dead state when the
    run() method exits.

![Java thread life cycle](image73.png){width="6.5in"
height="4.238888888888889in"}

368. **What is the difference between preemptive scheduling and time
     slicing?**

Under preemptive scheduling, the highest priority task executes until it
enters the waiting or dead states or a higher priority task comes into
existence. Under time slicing, a task executes for a predefined slice of
time and then reenters the pool of ready tasks. The scheduler then
determines which task should execute next, based on priority and other
factors.

369. **What is context switching?**

In Context switching the state of the process (or thread) is stored so
that it can be restored and execution can be resumed from the same point
later. Context switching enables the multiple processes to share the
same CPU.

370. **Differentiate between the Thread class and Runnable interface for
     creating a Thread?**

The Thread can be created by using two ways.

-   By extending the Thread class

-   By implementing the Runnable interface

However, the primary differences between both the ways are given below:

-   By extending the Thread class, we cannot extend any other class, as
    Java does not allow multiple inheritances while implementing the
    Runnable interface; we can also extend other base class(if
    required).

-   By extending the Thread class, each of thread creates the unique
    object and associates with it while implementing the Runnable
    interface; multiple threads share the same object

-   Thread class provides various inbuilt methods such as getPriority(),
    isAlive and many more while the Runnable interface provides a single
    method, i.e., run().

371. **What does join() method?**

The join() method waits for a thread to die. In other words, it causes
the currently running threads to stop executing until the thread it
joins with completes its task. Join method is overloaded in Thread class
in the following ways.

-   public void join()throws InterruptedException

-   public void join(long milliseconds)throws InterruptedException

Join () method is used to join one thread with the end of the currently
running thread.

Example:

public static void main(String\[\] args) {

\>Thread t = new Thread();

\>t.start();

\>t.join();

}

Based on the above code, the main thread has started the execution. When
it reaches the code t.start() then 'thread t' starts the own stack for
the execution. JVM switches between the main thread and 'thread t'.

Once it reaches the code t.join() then 'thread t' alone is executed and
completes its task, then only the main thread starts the execution.

It is a non-static method. The Join () method has an overloaded version.
So we can mention the time duration in join () method also ".s".

372. **Describe the purpose and working of sleep() method.**

The sleep() method in java is used to block a thread for a particular
time, which means it pause the execution of a thread for a specific
time. There are two methods of doing so.

Syntax:

-   public static void sleep(long milliseconds)throws
    InterruptedException

-   public static void sleep(long milliseconds, int nanos)throws
    InterruptedException

Working of sleep() method

When we call the sleep() method, it pauses the execution of the current
thread for the given time and gives priority to another thread(if
available). Moreover, when the waiting time completed then again
previous thread changes its state from waiting to runnable and comes in
running state, and the whole process works so on till the execution
doesn\'t complete.

373. **What is the difference between wait() and sleep() method?**

![](image74.png){width="6.5in"
height="1.1458333333333333in"}

374. **Is it possible to start a thread twice?**

No, we cannot restart the thread, as once a thread started and executed,
it goes to the Dead state. Therefore, if we try to start a thread twice,
it will give a runtimeException
\"java.lang.IllegalThreadStateException\". Consider the following
example.

public class Multithread1 extends Thread {

\>public void run() {

\>\>try {

\>\>\>System.out.println(\"thread is executing now\...\.....\");

\>\>} catch (Exception e) {}

\>}

\>public static void main(String\[\] args) {

\>\>Multithread1 m1 = new Multithread1();

\>\>m1.start();

\>\>m1.start();

\>}

}

Output

thread is executing now\...\.....

Exception in thread \"main\" java.lang.IllegalThreadStateException

\>at java.lang.Thread.start(Thread.java:708)

\>at Multithread1.main(Multithread1.java:13)

375. **Can we call the run() method instead of start()?**

Yes, calling run() method directly is valid, but it will not work as a
thread instead it will work as a normal object. There will not be
context-switching between the threads. When we call the start() method,
it internally calls the run() method, which creates a new stack for a
thread while directly calling the run() will not create a new stack.

376. **What about the daemon threads?**

The daemon threads are the low priority threads that provide the
background support and services to the user threads. Daemon thread gets
automatically terminated by the JVM if the program remains with the
daemon thread only, and all other user threads are ended/died. There are
two methods for daemon thread available in the Thread class:

-   public void setDaemon(boolean status): It used to mark the thread
    daemon thread or a user thread.

-   public boolean isDaemon(): It checks the thread is daemon or not.

377. **What is shutdown hook?**

The shutdown hook is a thread that is invoked implicitly before JVM
shuts down. So we can use it to perform clean up the resource or save
the state when JVM shuts down normally or abruptly. We can add shutdown
hook by using the following method:

public void addShutdownHook(Thread hook){}\>

Runtime r=Runtime.getRuntime();

r.addShutdownHook(new MyThread());

Some important points about shutdown hooks are :

Shutdown hooks initialized but can only be started when JVM shutdown
occurred.

Shutdown hooks are more reliable than the finalizer() because there are
very fewer chances that shutdown hooks not run.

The shutdown hook can be stopped by calling the halt(int) method of
Runtime class.

378. **When should we interrupt a thread?**

We should interrupt a thread when we want to break out the sleep or wait
state of a thread. We can interrupt a thread by calling the interrupt()
throwing the InterruptedException.

379. **What is the synchronization?**

Synchronization is the capability to control the access of multiple
threads to any shared resource. It is used:

-   To prevent thread interference.

-   To prevent consistency problem.

When the multiple threads try to do the same task, there is a
possibility of an erroneous result, hence to remove this issue, Java
uses the process of synchronization which allows only one thread to be
executed at a time. Synchronization can be achieved in three ways:

-   by the synchronized method

-   by synchronized block

-   by static synchronization

Syntax for synchronized block

synchronized(object reference expression)

\>{

\>\>//code block

\>}

![Synchronization - Java Interview Questions -
Edureka](image75.png){width="6.5in"
height="2.577777777777778in"}

380. **What is the purpose of the Synchronized block?**

The Synchronized block can be used to perform synchronization on any
specific resource of the method. Only one thread at a time can execute
on a particular resource, and all other threads which attempt to enter
the synchronized block are blocked.

-   Synchronized block is used to lock an object for any shared
    resource.

-   The scope of the synchronized block is limited to the block on
    which, it is applied. Its scope is smaller than a method.

381. **Can Java object be locked down for exclusive use by a given
     thread?**

Yes. You can lock an object by putting it in a \"synchronized\" block.
The locked object is inaccessible to any thread other than the one that
explicitly claimed it.

382. **What is static synchronization?**

If you make any static method as synchronized, the lock will be on the
class not on the object. If we use the synchronized keyword before a
method so it will lock the object (one thread can access an object at a
time) but if we use static synchronized so it will lock a class (one
thread can access a class at a time).

383. **What is the difference between notify() and notifyAll()?**

The notify() is used to unblock one waiting thread whereas notifyAll()
method is used to unblock all the threads in waiting state.

![](image76.png){width="6.5in"
height="1.0159722222222223in"}

384. **What is the deadlock?**

Deadlock is a situation in which every thread is waiting for a resource
which is held by some other waiting thread. In this situation, Neither
of the thread executes nor it gets the chance to be executed. Instead,
there exists a universal waiting state among all the threads. Deadlock
is a very complicated situation which can break our code at runtime.

385. **How to detect a deadlock condition? How can it be avoided?**

We can detect the deadlock condition by running the code on cmd and
collecting the Thread Dump, and if any deadlock is present in the code,
then a message will appear on cmd.

Ways to avoid the deadlock condition in Java:

-   Avoid Nested lock: Nested lock is the common reason for deadlock as
    deadlock occurs when we provide locks to various threads so we
    should give one lock to only one thread at some particular time.

-   Avoid unnecessary locks: we must avoid the locks which are not
    required.

-   Using thread join: Thread join helps to wait for a thread until
    another thread doesn\'t finish its execution so we can avoid
    deadlock by maximum use of join method.

386. **What is Thread Scheduler in java?**

In Java, when we create the threads, they are supervised with the help
of a Thread Scheduler, which is the part of JVM. Thread scheduler is
only responsible for deciding which thread should be executed. Thread
scheduler uses two mechanisms for scheduling the threads: Preemptive and
Time Slicing.

Java thread scheduler also works for deciding the following for a
thread:

-   It selects the priority of the thread.

-   It determines the waiting time for a thread

-   It checks the Nature of thread

387. **Does each thread have its stack in multithreaded programming?**

Yes, in multithreaded programming every thread maintains its own or
separate stack area in memory due to which every thread is independent
of each other.

388. **How is the safety of a thread achieved?**

If a method or class object can be used by multiple threads at a time
without any race condition, then the class is thread-safe. Thread safety
is used to make a program safe to use in multithreaded programming. It
can be achieved by the following ways:

-   Synchronization

-   Using Volatile keyword

-   Using a lock based mechanism

-   Use of atomic wrapper classes

389. **What is race-condition?**

A Race condition is a problem which occurs in the multithreaded
programming when various threads execute simultaneously accessing a
shared resource at the same time. The proper use of synchronization can
avoid the Race condition.

390. **What is the volatile keyword in java?**

Volatile keyword is used in multithreaded programming to achieve the
thread safety, as a change in one volatile variable is visible to all
other threads so one variable can be used by one thread at a time.

391. **What do you understand by thread pool?**

-   Java Thread pool represents a group of worker threads, which are
    waiting for the task to be allocated.

-   Threads in the thread pool are supervised by the service provider
    which pulls one thread from the pool and assign a job to it.

-   After completion of the given task, thread again came to the thread
    pool.

-   The size of the thread pool depends on the total number of threads
    kept at reserve for execution.

The advantages of the thread pool are :

-   Using a thread pool, performance can be enhanced.

-   Using a thread pool, better system stability can occur.

392. **What are the main components of concurrency API?**

Concurrency API can be developed using the class and interfaces of
java.util.Concurrent package. There are the following classes and
interfaces in java.util.Concurrent package.

-   Executor

-   FarkJoinPool

-   ExecutorService

-   ScheduledExecutorService

-   Future

-   TimeUnit(Enum)

-   CountDownLatch

-   CyclicBarrier

-   Semaphore

-   ThreadFactory

-   BlockingQueue

-   DelayQueue

-   Locks

-   Phaser

393. **What is the Executor interface in Concurrency API in Java?**

The Executor Interface provided by the package java.util.concurrent is
the simple interface used to execute the new task. The execute() method
of Executor interface is used to execute some given command. The syntax
of the execute() method is given below.

void execute(Runnable command)

Consider the following example:

public class TestThread {

\>public static void main(final String\[\] arguments) throws
InterruptedException {

\>\>Executor e = Executors.newCachedThreadPool();

\>\>e.execute(new Thread());

\>\>ThreadPoolExecutor pool = (ThreadPoolExecutor) e;

\>\>pool.shutdown();

\>}

\>static class Thread implements Runnable {

\>\>public void run() {

\>\>\>try {

\>\>\>\>Long duration = (long)(Math.random() \* 5);

\>\>\>\>System.out.println(\"Running Thread!\");

\>\>\>\>TimeUnit.SECONDS.sleep(duration);

\>\>\>\>System.out.println(\"Thread Completed\");

\>\>\>} catch (InterruptedException ex) {

\>\>\>\>ex.printStackTrace();

\>\>\>}

\>\>}

\>}

}

Output

Running Thread!

Thread Completed

394. **What is BlockingQueue?**

The java.util.concurrent.BlockingQueue is the subinterface of Queue that
supports the operations such as waiting for the space availability
before inserting a new value or waiting for the queue to become
non-empty before retrieving an element from it. Consider the following
example.

public class TestThread {

\>public static void main(final String\[\] arguments) throws
InterruptedException {

\>\>BlockingQueue \< Integer \> queue = new ArrayBlockingQueue \<
Integer \> (10);

\>\>Insert i = new Insert(queue);

\>\>Retrieve r = new Retrieve(queue);

\>\>new Thread(i).start();

\>\>new Thread(r).start();

\>\>Thread.sleep(2000);

\>}

\>static class Insert implements Runnable {

\>\>private BlockingQueue \< Integer \> queue;

\>\>public Insert(BlockingQueue queue) {

\>\>\>this.queue = queue;

\>\>}

\>\>@Override

\>\>public void run() {

\>\>\>Random random = new Random();

\>\>\>try {

\>\>\>\>int result = random.nextInt(200);

\>\>\>\>Thread.sleep(1000);

\>\>\>\>queue.put(result);

\>\>\>\>System.out.println(\"Added: \" + result);

\>\>\>\>result = random.nextInt(10);

\>\>\>\>Thread.sleep(1000);

\>\>\>\>queue.put(result);

\>\>\>\>System.out.println(\"Added: \" + result);

\>\>\>\>result = random.nextInt(50);

\>\>\>\>Thread.sleep(1000);

\>\>\>\>queue.put(result);

\>\>\>\>System.out.println(\"Added: \" + result);

\>\>\>} catch (InterruptedException e) {

\>\>\>\>e.printStackTrace();

\>\>\>}

\>\>}

\>}

\>static class Retrieve implements Runnable {

\>\>private BlockingQueue \< Integer \> queue;

\>\>public Retrieve(BlockingQueue queue) {

\>\>\>this.queue = queue;

\>\>}

\>\>@Override

\>\>public void run() {

\>\>\>try {

\>\>\>\>System.out.println(\"Removed: \" + queue.take());

\>\>\>\>System.out.println(\"Removed: \" + queue.take());

\>\>\>\>System.out.println(\"Removed: \" + queue.take());

\>\>\>} catch (InterruptedException e) {

\>\>\>\>e.printStackTrace();

\>\>\>}

\>\>}

\>}

}

Output

Added: 96

Removed: 96

Added: 8

Removed: 8

Added: 5

Removed: 5

395. **How to implement producer-consumer problem by using
     BlockingQueue?**

The producer-consumer problem can be solved by using BlockingQueue in
the following way.

public class ProducerConsumerProblem {

\>public static void main(String args\[\]) {

\>\>//Creating shared object

\>\>BlockingQueue sharedQueue = new LinkedBlockingQueue();

\>\>//Creating Producer and Consumer Thread

\>\>Thread prod = new Thread(new Producer(sharedQueue));

\>\>Thread cons = new Thread(new Consumer(sharedQueue));

\>\>//Starting producer and Consumer thread

\>\>prod.start();

\>\>cons.start();

\>}

}

//Producer Class in java

class Producer implements Runnable {

\>private final BlockingQueue sharedQueue;

\>public Producer(BlockingQueue sharedQueue) {

\>\>this.sharedQueue = sharedQueue;

\>}

\>@Override

\>public void run() {

\>\>for (int i = 0; i \< 10; i++) {

\>\>\>try {

\>\>\>\>System.out.println(\"Produced: \" + i);

\>\>\>\>sharedQueue.put(i);

\>\>\>} catch (InterruptedException ex) {

\>\>\>\>Logger.getLogger(Producer.class.getName()).log(Level.SEVERE,
null, ex);

\>\>\>}

\>\>}

\>}

}

//Consumer Class in Java

class Consumer implements Runnable {

\>private final BlockingQueue sharedQueue;

\>public Consumer(BlockingQueue sharedQueue) {

\>\>this.sharedQueue = sharedQueue;

\>}

\>@Override

\>public void run() {

\>\>while (true) {

\>\>\>try {

\>\>\>\>System.out.println(\"Consumed: \" + sharedQueue.take());

\>\>\>} catch (InterruptedException ex) {

\>\>\>\>Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE,
null, ex);

\>\>\>}

\>\>}

\>}

}

Output

Produced: 0

Produced: 1

Produced: 2

Produced: 3

Produced: 4

Produced: 5

Produced: 6

Produced: 7

Produced: 8

Produced: 9

Consumed: 0

Consumed: 1

Consumed: 2

Consumed: 3

Consumed: 4

Consumed: 5

Consumed: 6

Consumed: 7

Consumed: 8

Consumed: 9

396. **What is the difference between Java Callable interface and
     Runnable interface?**

The Callable interface and Runnable interface both are used by the
classes which wanted to execute with multiple threads. However, there
are two main differences between the both :

-   A Callable \<V\> interface can return a result, whereas the Runnable
    interface cannot return any result.

-   A Callable \<V\> interface can throw a checked exception, whereas
    the Runnable interface cannot throw checked exception.

-   A Callable \<V\> interface cannot be used before the Java 5 whereas
    the Runnable interface can be used.

397. **What is the Atomic action in Concurrency in Java?**

-   The Atomic action is the operation which can be performed in a
    single unit of a task without any interference of the other
    operations.

-   The Atomic action cannot be stopped in between the task. Once
    started it fill stop after the completion of the task only.

-   An increment operation such as a++ does not allow an atomic action.

-   All reads and writes operation for the primitive variable (except
    long and double) are the atomic operation.

-   All reads and writes operation for the volatile variable (including
    long and double) are the atomic operation.

-   The Atomic methods are available in java.util.Concurrent package.

398. **What is lock interface in Concurrency API in Java?**

The java.util.concurrent.locks.Lock interface is used as the
synchronization mechanism. It works similar to the synchronized block.
There are a few differences between the lock and synchronized block that
are given below.

-   Lock interface provides the guarantee of sequence in which the
    waiting thread will be given the access, whereas the synchronized
    block doesn\'t guarantee it.

-   Lock interface provides the option of timeout if the lock is not
    granted whereas the synchronized block doesn\'t provide that.

-   The methods of Lock interface, i.e., Lock() and Unlock() can be
    called in different methods whereas single synchronized block must
    be fully contained in a single method.

399. **Explain the ExecutorService Interface.**

The ExecutorService Interface is the subinterface of Executor interface
and adds the features to manage the lifecycle. Consider the following
example.

public class TestThread {

\>public static void main(final String\[\] arguments) throws
InterruptedException {

\>\>ExecutorService e = Executors.newSingleThreadExecutor();

\>\>try {

\>\>\>e.submit(new Thread());

\>\>\>System.out.println(\"Shutdown executor\");

\>\>\>e.shutdown();

\>\>\>e.awaitTermination(5, TimeUnit.SECONDS);

\>\>} catch (InterruptedException ex) {

\>\>\>System.err.println(\"tasks interrupted\");

\>\>} finally {

\>\>\>if (!e.isTerminated()) {

\>\>\>\>System.err.println(\"cancel non-finished tasks\");

\>\>\>}

\>\>\>e.shutdownNow();

\>\>\>System.out.println(\"shutdown finished\");

\>\>}

\>}

\>static class Task implements Runnable {

\>\>public void run() {

\>\>\>try {

\>\>\>\>Long duration = (long)(Math.random() \* 20);

\>\>\>\>System.out.println(\"Running Task!\");

\>\>\>\>TimeUnit.SECONDS.sleep(duration);

\>\>\>} catch (InterruptedException ex) {

\>\>\>\>ex.printStackTrace();

\>\>\>}

\>\>}

\>}

}

Output

Shutdown executor

shutdown finished

400. **What is the difference between Synchronous programming and
     Asynchronous programming regarding a thread?**

Synchronous programming: In Synchronous programming model, a thread is
assigned to complete a task and hence thread started working on it, and
it is only available for other tasks once it will end the assigned task.

Asynchronous Programming: In Asynchronous programming, one job can be
completed by multiple threads and hence it provides maximum usability of
the various threads.

401. **What do you understand by Callable and Future in Java?**

Java Callable interface: In Java5 callable interface was provided by the
package java.util.concurrent. It is similar to the Runnable interface
but it can return a result, and it can throw an Exception. It also
provides a run() method for execution of a thread. Java Callable can
return any object as it uses Generic.

Syntax:

public interface Callable\<V\>

Java Future interface: Java Future interface gives the result of a
concurrent process. The Callable interface returns the object of
java.util.concurrent.Future.

Java Future provides following methods for implementation.

-   cancel(boolean mayInterruptIfRunning): It is used to cancel the
    execution of the assigned task.

-   get(): It waits for the time if execution not completed and then
    retrieved the result.

-   isCancelled(): It returns the Boolean value as it returns true if
    the task was canceled before the completion.

-   isDone(): It returns true if the job is completed successfully else
    returns false.

402. **What is the difference between ScheduledExecutorService and
     ExecutorService interface?**

ExecutorServcie and ScheduledExecutorService both are the interfaces of
java.util.Concurrent package but scheduledExecutorService provides some
additional methods to execute the Runnable and Callable tasks with the
delay or every fixed time period.

403. **Define FutureTask class in Java?**

Java FutureTask class provides a base implementation of the Future
interface. The result can only be obtained if the execution of one task
is completed, and if the computation is not achieved then get method
will be blocked. If the execution is completed, then it cannot be
re-started and can\'t be canceled.

Syntax

public class FutureTask\<V\> extends Object implements
RunnableFuture\<V\>

404. **What is the Collection framework in Java?**

Collection Framework is a combination of classes and interface, which is
used to store and manipulate the data in the form of objects. It
provides various classes such as ArrayList, Vector, Stack, and HashSet,
etc. and interfaces such as List, Queue, Set, etc. for this purpose.

![FrameworkHierarchy - Java Collections -
Edureka](image77.png){width="6.5in"
height="5.288888888888889in"}

A group of objects in Java is known as collections. Java.util package
contains, along with date and time facilities, internationalization,
legacy collection classes, etc., the various classes and interfaces for
collecting. Alternatively, collections can be considered as a framework
designed for storing the objects and manipulating the design in which
the objects are stored. You can use collections to perform the following
operations on objects:

-   Deletion

-   Insertion

-   Manipulation

-   Searching

-   Sorting

Following are the various constituents of the collections framework:

-   Classes: Array List, Linked List, Lists, and Vector

-   Interfaces: Collection, List, Map, Queue, Set, Sorted Map, and
    Sorted Set

-   Maps: HashMap, HashTable, LinkedHashMap, and TreeMap

-   Queues: Priority Queue

-   Sets: Hash Set, Linked Hash Set, and Tree Set

405. **What are the main differences between array and collection?**

Array and Collection are somewhat similar regarding storing the
references of objects and manipulating the data, but they differ in many
ways. The main differences between the array and Collection are defined
below:

-   Arrays are always of fixed size, i.e., a user can not increase or
    decrease the length of the array according to their requirement or
    at runtime, but In Collection, size can be changed dynamically as
    per need.

-   Arrays can only store homogeneous or similar type objects, but in
    Collection, heterogeneous objects can be stored.

-   Arrays cannot provide the ready-made methods for user requirements
    as sorting, searching, etc. but Collection includes readymade
    methods to use.

406. **Explain various interfaces used in Collection framework?**

Collection framework implements various interfaces, Collection interface
and Map interface (java.util.Map) are the mainly used interfaces of Java
Collection Framework. List of interfaces of Collection Framework is
given below:

-   Collection interface: Collection (java.util.Collection) is the
    primary interface, and every collection must implement this
    interface.

Syntax:

> public interface Collection\<E\>extends Iterable
>
> Where \<E\> represents that this interface is of Generic type

-   List interface: List interface extends the Collection interface, and
    it is an ordered collection of objects. It contains duplicate
    elements. It also allows random access of elements.

> Syntax:
>
> public interface List\<E\> extends Collection\<E\>

-   Set interface: Set (java.util.Set) interface is a collection which
    cannot contain duplicate elements. It can only include inherited
    methods of Collection interface

> Syntax:
>
> public interface Set\<E\> extends Collection\<E\>

-   Queue interface: Queue (java.util.Queue) interface defines queue
    data structure, which stores the elements in the form FIFO (first in
    first out).

> Syntax:
>
> public interface Queue\<E\> extends Collection\<E\>

-   Dequeue interface: it is a double-ended-queue. It allows the
    insertion and removal of elements from both ends. It implants the
    properties of both Stack and queue so it can perform LIFO (Last in
    first out) stack and FIFO (first in first out) queue, operations.

> Syntax:
>
> public interface Dequeue\<E\> extends Queue\<E\>

-   Map interface: A Map (java.util.Map) represents a key, value pair
    storage of elements. Map interface does not implement the Collection
    interface. It can only contain a unique key but can have duplicate
    elements. There are two interfaces which implement Map in java that
    are Map interface and Sorted Map.

407. **What is the difference between ArrayList and Vector?**

![](image78.png){width="6.5in"
height="2.6819444444444445in"}

![](image79.png){width="6.5in"
height="0.3013888888888889in"}

![](image80.png){width="6.5in"
height="0.5277777777777778in"}

408. **What is the difference between ArrayList and LinkedList?**

![](image81.png){width="6.5in"
height="3.8513888888888888in"}

409. **What is the difference between Iterator and ListIterator?**

Iterator traverses the elements in the forward direction only whereas
ListIterator traverses the elements into forward and backward direction.

![](image82.png){width="6.5in"
height="2.7881944444444446in"}

410. **What is the difference between Iterator and Enumeration?**

![](image83.png){width="6.5in" height="2.707638888888889in"}

411. **What is the difference between List and Set?**

The List and Set both extend the collection interface. However, there
are some differences between the both which are listed below.

-   The List can contain duplicate elements whereas Set includes unique
    items.

-   The List is an ordered collection which maintains the insertion
    order whereas Set is an unordered collection which does not preserve
    the insertion order.

-   The List interface contains a single legacy class which is Vector
    class whereas Set interface does not have any legacy class.

-   The List interface can allow n number of null values whereas Set
    interface only allows a single null value.

412. **What is the difference between HashSet and TreeSet?**

The HashSet and TreeSet, both classes, implement Set interface. The
differences between the both are listed below.

-   HashSet maintains no order whereas TreeSet maintains ascending
    order.

-   HashSet impended by hash table whereas TreeSet implemented by a Tree
    structure.

-   HashSet performs faster than TreeSet.

-   HashSet is backed by HashMap whereas TreeSet is backed by TreeMap.

![](image84.png){width="6.5in" height="2.298611111111111in"}

413. **What is the difference between Set and Map?**

The differences between the Set and Map are given below.

-   Set contains values only whereas Map contains key and values both.

-   Set contains unique values whereas Map can contain unique Keys with
    duplicate values.

-   Set holds a single number of null value whereas Map can include a
    single null key with n number of null values.

414. **What is the difference between HashSet and HashMap?**

The differences between the HashSet and HashMap are listed below.

-   HashSet contains only values whereas HashMap includes the entry
    (key, value). HashSet can be iterated, but HashMap needs to convert
    into Set to be iterated.

-   HashSet implements Set interface whereas HashMap implements the Map
    interface

-   HashSet cannot have any duplicate value whereas HashMap can contain
    duplicate values with unique keys.

-   HashSet contains the only single number of null value whereas
    HashMap can hold a single null key with n number of null values.

415. **What is the difference between HashMap and TreeMap?**

The differences between the HashMap and TreeMap are given below.

-   HashMap maintains no order, but TreeMap maintains ascending order.

-   HashMap is implemented by hash table whereas TreeMap is implemented
    by a Tree structure.

-   HashMap can be sorted by Key or value whereas TreeMap can be sorted
    by Key.

-   HashMap may contain a null key with multiple null values whereas
    TreeMap cannot hold a null key but can have multiple null values.

416. **What is the difference between HashMap and Hashtable?**

![](image85.png){width="6.5in"
height="2.7041666666666666in"}

![](image86.png){width="6.5in" height="2.314583333333333in"}

417. **What is the difference between Collection and Collections?**

The differences between the Collection and Collections are given below.

-   The Collection is an interface whereas Collections is a class.

-   The Collection interface provides the standard functionality of data
    structure to List, Set, and Queue. However, Collections class is to
    sort and synchronize the collection elements.

-   The Collection interface provides the methods that can be used for
    data structure whereas Collections class provides the static methods
    which can be used for various operation on a collection.

418. **What is the difference between Comparable and Comparator?**

![](image87.png){width="6.5in"
height="2.9402777777777778in"}

419. **What do you understand by BlockingQueue?**

BlockingQueue is an interface which extends the Queue interface. It
provides concurrency in the operations like retrieval, insertion,
deletion. While retrieval of any element, it waits for the queue to be
non-empty. While storing the elements, it waits for the available space.
BlockingQueue cannot contain null elements, and implementation of
BlockingQueue is thread-safe.

Syntax:

public interface BlockingQueue\<E\> extends Queue \<E\>

420. **What is the advantage of Properties file?**

If you change the value in the properties file, you don\'t need to
recompile the java class. So, it makes the application easy to manage.
It is used to store information which is to be changed frequently.
Consider the following example.

public static void main(String\[\] args) throws Exception {

\>FileReader reader = new FileReader(\"db.properties\");

\>Properties p = new Properties();

\>p.load(reader);

\>System.out.println(p.getProperty(\"user\"));

\>System.out.println(p.getProperty(\"password\"));

}

Output

system

oracle

421. **What does the hashCode() method?**

The hashCode() method returns a hash code value (an integer number).

The hashCode() method returns the same integer number if two keys (by
calling equals() method) are identical.

However, it is possible that two hash code numbers can have different or
the same keys.

If two objects do not produce an equal result by using the equals()
method, then the hashcode() method will provide the different integer
result for both the objects.

422. **Why we override equals() method?**

The equals method is used to check whether two objects are the same or
not. It needs to be overridden if we want to check the objects based on
the property.

For example, Employee is a class that has 3 data members: id, name, and
salary. However, we want to check the equality of employee object by the
salary. Then, we need to override the equals() method.

423. **How to synchronize List, Set and Map elements?**

Yes, Collections class provides methods to make List, Set or Map
elements as synchronized:

public static List synchronizedList(List l){}

public static Set synchronizedSet(Set s){}

public static SortedSet synchronizedSortedSet(SortedSet s){}

public static Map synchronizedMap(Map m){}

public static SortedMap synchronizedSortedMap(SortedMap m){}

424. **What is the advantage of the generic collection?**

There are three main advantages of using the generic collection.

-   If we use the generic class, we don\'t need typecasting.

-   It is type-safe and checked at compile time.

-   Generic confirms the stability of the code by making it bug
    detectable at compile time.

425. **What is hash-collision in Hashtable and how it is handled in
     Java?**

Two different keys with the same hash value are known as hash-collision.
Two separate entries will be kept in a single hash bucket to avoid the
collision. There are two ways to avoid hash-collision.

-   Separate Chaining

-   Open Addressing

426. **What is the Dictionary class?**

The Dictionary class provides the capability to store key-value pairs.

427. **What is the default size of load factor in hashing based
     collection?**

The default size of load factor is 0.75. The default capacity is
computed as initial capacity \* load factor. For example, 16 \* 0.75 =
12. So, 12 is the default capacity of Map.

428. **What do you understand by fail-fast?**

The Iterator in java which immediately throws
ConcurrentmodificationException, if any structural modification occurs
in, is called as a Fail-fast iterator. Fail-fats iterator does not
require any extra space in memory.

429. **What is the difference between Array and ArrayList?**

The main differences between the Array and ArrayList are given below.

![](image88.png){width="6.5in" height="2.270138888888889in"}

![](image89.png){width="6.5in"
height="2.2243055555555555in"}

![](image90.png){width="6.5in"
height="3.8305555555555557in"}

430. **What is the difference between the length of an Array and size of
     ArrayList?**

The length of an array can be obtained using the property of length
whereas ArrayList does not support length property, but we can use
size() method to get the number of objects in the list.

Finding the length of the array

Int \[\] array = new int\[4\];

System.out.println(\"The size of the array is \" + array.length);

Finding the size of the ArrayList

ArrayList\<String\> list=new ArrayList\<String\>();\>

list.add(\"ankit\");\>

list.add(\"nippun\");

System.out.println(list.size());

431. **How to convert ArrayList to Array and Array to ArrayList?**

We can convert an Array to ArrayList by using the asList() method of
Arrays class. asList() method is the static method of Arrays class and
accepts the List object. Consider the following syntax:

Arrays.asList(item)

We can convert an ArrayList to Array using toArray() method of the
ArrayList class. Consider the following syntax to convert the ArrayList
to the List object.

List_object.toArray(new String\[List_object.size()\])

432. **How to make Java ArrayList Read-Only?**

We can obtain java ArrayList Read-only by calling the
Collections.unmodifiableCollection() method. When we define an ArrayList
as Read-only then we cannot perform any modification in the collection
through add(), remove() or set() method.

433. **How to remove duplicates from ArrayList?**

There are two ways to remove duplicates from the ArrayList.

-   Using HashSet: By using HashSet we can remove the duplicate element
    from the ArrayList, but it will not then preserve the insertion
    order.

-   Using LinkedHashSet: We can also maintain the insertion order by
    using LinkedHashSet instead of HashSet.

The Process to remove duplicate elements from ArrayList using the
LinkedHashSet:

-   Copy all the elements of ArrayList to LinkedHashSet.

-   Empty the ArrayList using clear() method, which will remove all the
    elements from the list.

-   Now copy all the elements of LinkedHashset to ArrayList.

434. **How to reverse ArrayList?**

To reverse an ArrayList, we can use reverse() method of Collections
class. Consider the following example.

public class ReverseArrayList {

\>public static void main(String\[\] args) {

\>\>List list = new ArrayList \< \> ();

\>\>list.add(10);

\>\>list.add(50);

\>\>list.add(30);

\>\>Iterator i = list.iterator();

\>\>System.out.println(\"printing the list\....\");

\>\>while (i.hasNext()) {

\>\>\>System.out.println(i.next());

\>\>}

\>\>Iterator i2 = list.iterator();

\>\>Collections.reverse(list);

\>\>System.out.println(\"printing list in reverse order\....\");

\>\>while (i2.hasNext()) {

\>\>\>System.out.println(i2.next());

\>\>}

\>}

}

Output

printing the list\....

10

50

30

printing list in reverse order\....

30

50

10

435. **How to sort ArrayList in descending order?**

To sort the ArrayList in descending order, we can use the reverseOrder
method of Collections class. Consider the following example.

public class ReverseArrayList {

\>public static void main(String\[\] args) {

\>\>List list = new ArrayList \< \> ();

\>\>list.add(10);

\>\>list.add(50);

\>\>list.add(30);

\>\>list.add(60);

\>\>list.add(20);

\>\>list.add(90);

\>\>Iterator i = list.iterator();

\>\>System.out.println(\"printing the list\....\");

\>\>while (i.hasNext()) {

\>\>\>System.out.println(i.next());

\>\>}

\>\>Comparator cmp = Collections.reverseOrder();

\>\>Collections.sort(list, cmp);

\>\>System.out.println(\"printing list in descending order\....\");

\>\>Iterator i2 = list.iterator();

\>\>while (i2.hasNext()) {

\>\>\>System.out.println(i2.next());

\>\>}

\>}

}

Output

printing the list\....

10

50

30

60

20

90

printing list in descending order\....

90

60

50

30

20

10

436. **How to synchronize ArrayList?**

We can synchronize ArrayList in two ways.

-   Using Collections.synchronizedList() method

-   Using CopyOnWriteArrayList\<T\>

437. **When to use ArrayList and LinkedList?**

LinkedLists are better to use for the update operations whereas
ArrayLists are better to use for the search operations.

438. **What is JDBC?**

JDBC is a Java API that is used to connect and execute the query to the
database. JDBC API uses JDBC drivers to connect to the database. JDBC
API can be used to access tabular data stored into any relational
database.

![JDBC (Java Database Connectivity)
](image91.png){width="4.924305555555556in"
height="2.113888888888889in"}

439. **What is JDBC Driver?**

JDBC Driver is a software component that enables Java application to
interact with the database. There are 4 types of JDBC drivers:

-   JDBC-ODBC bridge driver: The JDBC-ODBC bridge driver uses the ODBC
    driver to connect to the database. The JDBC-ODBC bridge driver
    converts JDBC method calls into the ODBC function calls. This is now
    discouraged because of the thin driver. It is easy to use and can be
    easily connected to any database.

-   Native-API driver (partially java driver): The Native API driver
    uses the client-side libraries of the database. The driver converts
    JDBC method calls into native calls of the database API. It is not
    written entirely in Java. Its performance is better than JDBC-ODBC
    bridge driver. However, the native driver must be installed on each
    client machine.

-   Network Protocol driver (fully java driver): The Network Protocol
    driver uses middleware (application server) that converts JDBC calls
    directly or indirectly into the vendor-specific database protocol.
    It is entirely written in Java. There is no requirement of the
    client-side library because of the application server that can
    perform many tasks like auditing, load balancing, logging, etc.

-   Thin driver (fully java driver): The thin driver converts JDBC calls
    directly into the vendor-specific database protocol. That is why it
    is known as the thin driver. It is entirely written in Java
    language. Its performance is better than all other drivers however
    these drivers depend upon the database.

![](image92.png){width="3.1284722222222223in"
height="3.4923611111111112in"}

440. **What are the steps to connect to the database in java?**

The following steps are used in database connectivity.

-   Registering the driver class:

The forName() method of the Class class is used to register the driver
class. This method is used to load the driver class dynamically.
Consider the following example to register OracleDriver class.

Class.forName(\"oracle.jdbc.driver.OracleDriver\");

-   Creating connection:

The getConnection() method of DriverManager class is used to establish
the connection with the database. The syntax of the getConnection()
method is given below.

-   public static Connection getConnection(String url)throws
    SQLException

-   public static Connection getConnection(String url,String name,String
    password)

throws SQLException

Consider the following example to establish the connection with the
Oracle database.

Connection con=DriverManager.getConnection(

\"jdbc:oracle:thin:@localhost:1521:xe\",\"system\",\"password\");

-   Creating the statement:

The createStatement() method of Connection interface is used to create
the Statement. The object of the Statement is responsible for executing
queries with the database.

public Statement createStatement()throws SQLException

consider the following example to create the statement object

Statement stmt=con.createStatement();

-   Executing the queries:

The executeQuery() method of Statement interface is used to execute
queries to the database. This method returns the object of ResultSet
that can be used to get all the records of a table.

Syntax of executeQuery() method is given below.

public ResultSet executeQuery(String sql)throws SQLException

Example to execute the query

ResultSet rs=stmt.executeQuery(\"select \* from emp\");

while(rs.next()){

System.out.println(rs.getInt(1)+\" \"+rs.getString(2));

}

However, to perform the insert and update operations in the database,
executeUpdate() method is used which returns the boolean value to
indicate the successful completion of the operation.

-   Closing connection:

By closing connection, object statement and ResultSet will be closed
automatically. The close() method of Connection interface is used to
close the connection.

Syntax of close() method is given below.

public void close()throws SQLException

Consider the following example to close the connection.

con.close();

441. **What are the JDBC API components?**

The java.sql package contains following interfaces and classes for JDBC
API.

Interfaces:

-   Connection: The Connection object is created by using
    getConnection() method of DriverManager class. DriverManager is the
    factory for connection.

-   Statement: The Statement object is created by using
    createStatement() method of Connection class. The Connection
    interface is the factory for Statement.

-   PreparedStatement: The PrepareStatement object is created by using
    prepareStatement() method of Connection class. It is used to execute
    the parameterized query.

-   ResultSet: The object of ResultSet maintains a cursor pointing to a
    row of a table. Initially, cursor points before the first row. The
    executeQuery() method of Statement interface returns the ResultSet
    object.

-   ResultSetMetaData: The object of ResultSetMetaData interface cotains
    the information about the data (table) such as numer of columns,
    column name, column type, etc. The getMetaData() method of ResultSet
    returns the object of ResultSetMetaData.

-   DatabaseMetaData: DatabaseMetaData interface provides methods to get
    metadata of a database such as the database product name, database
    product version, driver name, name of the total number of tables,
    the name of the total number of views, etc. The getMetaData() method
    of Connection interface returns the object of DatabaseMetaData.

-   CallableStatement: CallableStatement interface is used to call the
    stored procedures and functions. We can have business logic on the
    database through the use of stored procedures and functions that
    will make the performance better because these are precompiled. The
    prepareCall() method of Connection interface returns the instance of
    CallableStatement.

Classes:

-   DriverManager: The DriverManager class acts as an interface between
    the user and drivers. It keeps track of the drivers that are
    available and handles establishing a connection between a database
    and the appropriate driver. It contains several methods to keep the
    interaction between the user and drivers.

-   Blob: Blob stands for the binary large object. It represents a
    collection of binary data stored as a single entity in the database
    management system.

-   Clob: Clob stands for Character large object. It is a data type that
    is used by various database management systems to store character
    files. It is similar to Blob except for the difference that BLOB
    represent binary data such as images, audio and video files, etc.
    whereas Clob represents character stream data such as character
    files, etc.

-   SQLException It is an Exception class which provides information on
    database access errors.

442. **What are the JDBC statements?**

In JDBC, Statements are used to send SQL commands to the database and
receive data from the database. There are various methods provided by
JDBC statements such as execute(), executeUpdate(), executeQuery, etc.
which helps you to interact with the database.

There is three type of JDBC statements given in the following table.

![](image93.png){width="6.5in"
height="2.0729166666666665in"}

443. **What is the return type of Class.forName() method?**

The Class.forName() method returns the object of java.lang.Class object.

444. **What are the differences between Statement and PreparedStatement
     interface?**

![](image94.png){width="6.5in" height="2.482638888888889in"}

445. **How can we set null value in JDBC PreparedStatement?**

By using setNull() method of PreparedStatement interface, we can set the
null value to an index. The syntax of the method is given below.

void setNull(int parameterIndex, int sqlType) throws SQLException

446. **What are the benefits of PreparedStatement over Statement?**

The benefits of using PreparedStatement over Statement interface is
given below.

-   The PreparedStatement performs faster as compare to Statement
    because the Statement needs to be compiled everytime we run the code
    whereas the PreparedStatement compiled once and then execute only on
    runtime.

-   PreparedStatement can execute Parameterized query whereas Statement
    can only run static queries.

-   The query used in PreparedStatement is appeared to be similar every
    time. Therefore, the database can reuse the previous access plan
    whereas, Statement inline the parameters into the String, therefore,
    the query doesn\'t appear to be same everytime which prevents cache
    reusage.

447. **What are the differences between execute, executeQuery, and
     executeUpdate?**

![](image95.png){width="6.5in"
height="2.3784722222222223in"}

-   Statement execute(String query) is used to execute any SQL query and
    it returns TRUE if the result is an ResultSet such as running Select
    queries. The output is FALSE when there is no ResultSet object such
    as running Insert or Update queries. We can use getResultSet() to
    get the ResultSet and getUpdateCount() method to retrieve the update
    count.

-   Statement executeQuery(String query) is used to execute Select
    queries and returns the ResultSet. ResultSet returned is never null
    even if there are no records matching the query. When executing
    select queries we should use executeQuery method so that if someone
    tries to execute insert/update statement it will throw
    java.sql.SQLException with message "executeQuery method can not be
    used for update".

-   Statement executeUpdate(String query) is used to execute
    Insert/Update/Delete (DML) statements or DDL statements that returns
    nothing. The output is int and equals to the row count for SQL Data
    Manipulation Language (DML) statements. For DDL statements, the
    output is 0.

You should use execute() method only when you are not sure about the
type of statement else use executeQuery or executeUpdate method.

448. **What are the different types of ResultSet?**

ResultSet is categorized by the direction of the reading head and
sensitivity or insensitivity of the result provided by it. There are
three general types of ResultSet.

![](image96.png){width="6.5in"
height="1.8020833333333333in"}

449. **What are the differences between ResultSet and RowSet?**

![](image97.png){width="6.5in" height="2.957638888888889in"}

450. **How can we execute stored procedures using CallableStatement?**

Following are the steps to create and execute stored procedures. Here,
we are creating a table user420 by using a stored procedure and
inserting values into it.

-   Create the procedure in the database.

To call the stored procedure, you need to create it in the database.
Here, we are assuming that the stored procedure looks like this.

create or replace procedure \"INSERTR\"

(id IN NUMBER,

name IN VARCHAR2)

is

begin

insert into user420 values(id,name);

end;

/\>

The table structure is given below:

create table user420(id number(10), name varchar2(200));

-   Establish a network connection.

Class.forName(\"oracle.jdbc.driver.OracleDriver\");

Connection con=DriverManager.getConnection(

\"jdbc:oracle:thin:@localhost:1521:xe\",\"system\",\"oracle\");

-   Create the Object of CallableStatement.

CallableStatement stmt=con.prepareCall(\"{call insertR(?,?)}\");

-   Provide the values and execute the query by using the following
    syntax.

stmt.setInt(1,1011);

stmt.setString(2,\"Amit\");

stmt.execute();

-   Check the database; the values will be found there. However, the
    complete code will look like the following.

public class Proc {

\>public static void main(String\[\] args) throws Exception {

\>\>Class.forName(\"oracle.jdbc.driver.OracleDriver\");

\>\>Connection con = DriverManager.getConnection(

\>\>\"jdbc:oracle:thin:@localhost:1521:xe\", \"system\", \"oracle\");

\>\>CallableStatement stmt = con.prepareCall(\"{call insertR(?,?)}\");

\>\>stmt.setInt(1, 1011);

\>\>stmt.setString(2, \"Amit\");

\>\>stmt.execute();

\>\>System.out.println(\"success\");

\>}

}

451. **What is the role of the JDBC DriverManager class?**

The DriverManager class acts as an interface between user and drivers.
It keeps track of the drivers that are available and handles
establishing a connection between a database and the appropriate driver.
The DriverManager class maintains a list of Driver classes that have
registered themselves by calling the method
DriverManager.registerDriver().

452. **What are the functions of the JDBC Connection interface?**

The Connection interface maintains a session with the database. It can
be used for transaction management. It provides factory methods that
return the instance of Statement, PreparedStatement, CallableStatement,
and DatabaseMetaData.

![ConnectionInterface - Java Interview Questions -
Edureka](image98.png){width="6.5in"
height="1.2534722222222223in"}

453. **What does the JDBC ResultSet interface?**

The ResultSet object represents a row of a table. It can be used to
change the cursor pointer and get the information from the database. By
default, ResultSet object can move in the forward direction only and is
not updatable. However, we can make this object to move the forward and
backward direction by passing either TYPE_SCROLL_INSENSITIVE or
TYPE_SCROLL_SENSITIVE in createStatement(int, int) method.

454. **What does the JDBC ResultSetMetaData interface?**

The ResultSetMetaData interface returns the information of table such as
the total number of columns, column name, column type, etc.

455. **What does the JDBC DatabaseMetaData interface?**

The DatabaseMetaData interface returns the information of the database
such as username, driver name, driver version, number of tables, number
of views, etc. Consider the following example.

class Dbmd {

\>public static void main(String args\[\]) {

\>\>try {

\>\>\>Class.forName(\"oracle.jdbc.driver.OracleDriver\");

\>\>\>Connection con = DriverManager.getConnection(

\>\>\>\>\"jdbc:oracle:thin:@localhost:1521:xe\", \"system\",
\"oracle\");

\>\>\>DatabaseMetaData dbmd = con.getMetaData();

\>\>\>System.out.println(\"Driver Name: \" + dbmd.getDriverName());

\>\>\>System.out.println(\"Driver Version: \" +
dbmd.getDriverVersion());

\>\>\>System.out.println(\"UserName: \" + dbmd.getUserName());

\>\>\>System.out.println(\"Database Product Name: \" +
dbmd.getDatabaseProductName());

\>\>\>System.out.println(\"Database Product Version: \" +
dbmd.getDatabaseProductVersion());

\>\>\>con.close();

\>\>} catch (Exception e) {

\>\>\>System.out.println(e);

\>\>}

\>}

}

Output

Driver Name: Oracle JDBC Driver

Driver Version: 10.2.0.1.0XE

Database Product Name: Oracle

Database Product Version: Oracle Database 10g Express Edition Release
10.2.0.1.0 -Production

456. **Which interface is responsible for transaction management in
     JDBC?**

The Connection interface provides methods for transaction management
such as commit(), rollback() etc.

457. **What is batch processing and how to perform batch processing in
     JDBC?**

By using the batch processing technique in JDBC, we can execute multiple
queries. It makes the performance fast. The java.sql.Statement and
java.sql.PreparedStatement interfaces provide methods for batch
processing. The batch processing in JDBC requires the following steps.

-   Load the driver class

-   Create Connection

-   Create Statement

-   Add query in the batch

-   Execute the Batch

-   Close Connection

Consider the following example to perform batch processing using the
Statement interface.

class FetchRecords {

\>public static void main(String args\[\]) throws Exception {

\>\>Class.forName(\"oracle.jdbc.driver.OracleDriver\");

\>\>Connection con =
DriverManager.getConnection(\"jdbc:oracle:thin:@localhost:1521:xe\",
\"system\", \"oracle\");

\>\>con.setAutoCommit(false);

\>\>Statement stmt = con.createStatement();

\>\>stmt.addBatch(\"insert into user420 values(190,\'abhi\',40000)\");

\>\>stmt.addBatch(\"insert into user420 values(191,\'umesh\',50000)\");

\>\>stmt.executeBatch(); //executing the batch

\>\>con.commit();

\>\>con.close();

\>}

}

458. **What are CLOB and BLOB data types in JDBC?**

BLOB: Blob can be defined as the variable-length, binary large object
which is used to hold the group of Binary data such as voice, images,
and mixed media. It can hold up to 2GB data on MySQL database and 128 GB
on Oracle database. BLOB is supported by many databases such as MySQL,
Oracle, and DB2 to store the binary data (images, video, audio, and
mixed media).

CLOB: Clob can be defined as the variable-length, character-large object
which is used to hold the character-based data such as files in many
databases. It can hold up to 2 GB on MySQL database, and 128 GB on
Oracle Database. A CLOB is considered as a character string.

459. **What are the different types of lockings in JDBC?**

A lock is a certain type of software mechanism by using which, we can
restrict other users from using the data resource. There are four type
of locks given in JDBC that are described below.

-   Row and Key Locks: These type of locks are used when we update the
    rows.

-   Page Locks: These type of locks are applied to a page. They are used
    in the case, where a transaction remains in the process and is being
    updated, deleting, or inserting some data in a row of the table. The
    database server locks the entire page that contains the row. The
    page lock can be applied once by the database server.

-   Table locks: Table locks are applied to the table. It can be applied
    in two ways, i.e., shared and exclusive. Shared lock lets the other
    transactions to read the table but not update it. However, The
    exclusive lock prevents others from reading and writing the table.

-   Database locks: The Database lock is used to prevent the read and
    update access from other transactions when the database is open.

460. **How can we store and retrieve images from the database?**

By using the PreparedStatement interface, we can store and retrieve
images. Create a table which contains two columns namely NAME and PHOTO.

CREATE TABLE \"IMGTABLE\"

(\>\"NAME\" VARCHAR2(4000),

\>\"PHOTO\" BLOB

)

Consider the following example to store the image in the database.

public class InsertImage {

\>public static void main(String\[\] args) {

\>\>try {

\>\>\>Class.forName(\"oracle.jdbc.driver.OracleDriver\");

\>\>\>Connection con = DriverManager.getConnection(

\>\>\>\>\"jdbc:oracle:thin:@localhost:1521:xe\", \"system\",
\"oracle\");

\>\>\>PreparedStatement ps = con.prepareStatement(\"insert into imgtable
values(?,?)\");

\>\>\>ps.setString(1, \"sonoo\");

\>\>\>FileInputStream fin = new FileInputStream(\"d:\\\\g.jpg\");

\>\>\>ps.setBinaryStream(2, fin, fin.available());

\>\>\>int i = ps.executeUpdate();

\>\>\>System.out.println(i + \" records affected\");

\>\>\>con.close();

\>\>} catch (Exception e) {

\>\>\>e.printStackTrace();

\>\>}

\>}

}

Consider the following example to retrieve the image from the table.

public class RetrieveImage {

\>public static void main(String\[\] args) {

\>\>try {

\>\>\>Class.forName(\"oracle.jdbc.driver.OracleDriver\");

\>\>\>Connection con = DriverManager.getConnection(

\>\>\>\>\"jdbc:oracle:thin:@localhost:1521:xe\", \"system\",
\"oracle\");

\>\>\>PreparedStatement ps = con.prepareStatement(\"select \* from
imgtable\");

\>\>\>ResultSet rs = ps.executeQuery();

\>\>\>if (rs.next()) { //now on 1st row

\>\>\>\>Blob b = rs.getBlob(2); //2 means 2nd column data

\>\>\>\>byte barr\[\] = b.getBytes(1, (int) b.length()); //1 means first
image

\>\>\>\>FileOutputStream fout = new
FileOutputStream(\"d:\\\\sonoo.jpg\");

\>\>\>\>fout.write(barr);

\>\>\>\>fout.close();

\>\>\>} //end of if

\>\>\>System.out.println(\"ok\");

\>\>\>con.close();

\>\>} catch (Exception e) {

\>\>\>e.printStackTrace();

\>\>}

\>}

}

461. **How can we store the file in the Oracle database?**

The setCharacterStream() method of PreparedStatement interface is used
to set character information into the parameterIndex. For storing the
file into the database, CLOB (Character Large Object) datatype is used
in the table. For example:

CREATE TABLE \"FILETABLE\"

(\>\"ID\" NUMBER,

\>\"NAME\" CLOB

)

Java Code

public class StoreFile {

\>public static void main(String\[\] args) {

\>\>try {

\>\>\>Class.forName(\"oracle.jdbc.driver.OracleDriver\");

\>\>\>Connection con = DriverManager.getConnection(

\>\>\>\>\"jdbc:oracle:thin:@localhost:1521:xe\", \"system\",
\"oracle\");

\>\>\>PreparedStatement ps = con.prepareStatement(

\>\>\>\>\"insert into filetable values(?,?)\");

\>\>\>File f = new File(\"d:\\\\myfile.txt\");

\>\>\>FileReader fr = new FileReader(f);

\>\>\>ps.setInt(1, 101);

\>\>\>ps.setCharacterStream(2, fr, (int) f.length());

\>\>\>int i = ps.executeUpdate();

\>\>\>System.out.println(i + \" records affected\");

\>\>\>con.close();

\>\>} catch (Exception e) {

\>\>\>e.printStackTrace();

\>\>}

\>}

}

462. **How can we retrieve the file in the Oracle database?**

The getClob() method of PreparedStatement is used to get file
information from the database. Let\'s see the table structure of the
example to retrieve the file.

CREATE TABLE \"FILETABLE\"

(\>\"ID\" NUMBER,

\>\"NAME\" CLOB

)

The example to retrieve the file from the Oracle database is given
below.

public class RetrieveFile {

\>public static void main(String\[\] args) {

\>\>try {

\>\>\>Class.forName(\"oracle.jdbc.driver.OracleDriver\");

\>\>\>Connection con = DriverManager.getConnection(

\>\>\>\>\"jdbc:oracle:thin:@localhost:1521:xe\", \"system\",
\"oracle\");

\>\>\>PreparedStatement ps = con.prepareStatement(\"select \* from
filetable\");

\>\>\>ResultSet rs = ps.executeQuery();

\>\>\>rs.next(); //now on 1st row

\>\>\>Clob c = rs.getClob(2);

\>\>\>Reader r = c.getCharacterStream();

\>\>\>FileWriter fw = new FileWriter(\"d:\\\\retrivefile.txt\");

\>\>\>int i;

\>\>\>while ((i = r.read()) != -1)

\>\>\>\>fw.write((char) i);

\>\>\>fw.close();

\>\>\>con.close();

\>\>\>System.out.println(\"success\");

\>\>} catch (Exception e) {

\>\>\>e.printStackTrace();

\>\>}

\>}

}

463. **What are the differences between stored procedure and
     functions?**

The differences between stored procedures and functions are given below:

![](image99.png){width="6.5in"
height="2.3201388888888888in"}

464. **How can we maintain the integrity of a database by using JDBC?**

To maintain the integrity of a database, we need to ensure the ACID
properties. ACID properties mean Atomicity, Consistency, Isolation, and
durability. In JDBC, Connection interface provides methods like
setAutoCommit(), commit(), and rollback() which can be used to manage
transaction. Let\'s see an example of transaction management in JDBC.

class FetchRecords {

\>public static void main(String args\[\]) throws Exception {

\>\>Class.forName(\"oracle.jdbc.driver.OracleDriver\");

\>\>Connection con =
DriverManager.getConnection(\"jdbc:oracle:thin:@localhost:1521:xe\",
\"system\", \"oracle\");

\>\>con.setAutoCommit(false);

\>\>Statement stmt = con.createStatement();

\>\>stmt.executeUpdate(\"insert into user420
values(190,\'abhi\',40000)\");

\>\>stmt.executeUpdate(\"insert into user420
values(191,\'umesh\',50000)\");

\>\>con.commit();

\>\>con.close();

\>}

}

465. **What is the JDBC Rowset?**

JDBC Rowset is the wrapper of ResultSet. It holds tabular data like
ResultSet, but it is easy and flexible to use. The implementation
classes of RowSet interface are as follows:

-   JdbcRowSet

-   CachedRowSet

-   WebRowSet

-   JoinRowSet

-   FilteredRowSet

466. **What is the major difference between java.util.Date and
     java.sql.Date data type?**

The major difference between java.util.Date and java.sql.Date is that,
java.sql.Date represents date without time information whereas,
java.util.Date represents both date and time information.

467. **What does JDBC setMaxRows method do?**

The setMaxRows(int i) method limits the number of rows the database can
return by using the query. This can also be done within the query as we
can use the limit cause in MySQL.

[Top Core Java Interview Questions and Answers in 2024
(edureka.co)](https://www.edureka.co/blog/interview-questions/java-interview-questions/)

468. **Explain public static void main(String args\[\]) in Java.**

-   main() in Java is the entry point for any Java program. It is always
    written as public static void main(String\[\] args).

-   public: Public is an access modifier, which is used to specify who
    can access this method. Public means that this Method will be
    accessible by any Class.

-   static: It is a keyword in java which identifies it is class-based.
    main() is made static in Java so that it can be accessed without
    creating the instance of a Class. In case, main is not made static
    then the compiler will throw an error as main() is called by the JVM
    before any objects are made and only static methods can be directly
    invoked via the class.

-   void: It is the return type of the method. Void defines the method
    which will not return any value.

-   main: It is the name of the method which is searched by JVM as a
    starting point for an application with a particular signature only.
    It is the method where the main execution occurs.

-   String args\[\]: It is the parameter passed to the main method.

469. **Why pointers are not used in Java?**

Java doesn't use pointers because they are unsafe and increases the
complexity of the program. Since, Java is known for its simplicity of
code, adding the concept of pointers will be contradicting. Moreover,
since JVM is responsible for implicit memory allocation, thus in order
to avoid direct access to memory by the user, pointers are discouraged
in Java.

470. **What are access modifiers in Java?**

In Java, access modifiers are special keywords which are used to
restrict the access of a class, constructor, data member and method in
another class. Java supports four types of access modifiers:

-   Default

-   Private

-   Protected

-   Public

![](image100.png){width="6.5in"
height="3.379166666666667in"}

471. **Define a Java Class.**

All Java codes are defined in a Class. It has variables and methods.

Variables are attributes which define the state of a class.

Methods is a place where the exact business logic has to be done. It
contains a set of statements (or) instructions to satisfy the particular
requirement.

public class Addition { //Class name declaration

\>int a = 5; //Variable declaration

\>int b = 5;

\>public void add() { //Method declaration

\>\>int c = a + b;

\>}

}

472. **What is Object Oriented Programming?**

Object-oriented programming or popularly known as OOPs is a programming
model or approach where the programs are organized around objects rather
than logic and functions. In other words, OOP mainly focuses on the
objects that are required to be manipulated instead of logic. This
approach is ideal for the programs large and complex codes and needs to
be actively updated or maintained.

473. **What are the main concepts of OOPs in Java?**

Object-Oriented Programming or OOPs is a programming style that is
associated with concepts like:

-   Inheritance: Inheritance is a process where one class acquires the
    properties of another.

-   Encapsulation: Encapsulation in Java is a mechanism of wrapping up
    the data and code together as a single unit.

-   Abstraction: Abstraction is the methodology of hiding the
    implementation details from the user and only providing the
    functionality to the users.

-   Polymorphism: Polymorphism is the ability of a variable, function or
    object to take multiple forms.

474. **What is the difference between break and continue statements?**

![](image101.png){width="6.5in"
height="1.9083333333333334in"}

Example break:

for (int i = 0; i \< 5; i++) {

\>if (i == 3) {

\>\>break;

\>}

\>System.out.println(i);

}

Example continue:

for (int i = 0; i \< 5; i++) {

\>if (i == 2) {

\>\>continue;

\>}

\>System.out.println(i);

}

475. **Differentiate between static and non-static methods in Java.**

![](image102.png){width="6.5in" height="1.80625in"}

476. **What is constructor chaining in Java?**

In Java, constructor chaining is the process of calling one constructor
from another with respect to the current object. Constructor chaining is
possible only through legacy where a subclass constructor is responsible
for invoking the superclass' constructor first. There could be any
number of classes in the constructor chain. Constructor chaining can be
achieved in two ways:

-   Within the same class using this()

-   From base class using super()

477. **What is a Map in Java?**

In Java, Map is an interface of Util package which maps unique keys to
values. The Map interface is not a subset of the main Collection
interface and thus it behaves little different from the other collection
types. Below are a few of the characteristics of Map interface:

-   Map doesn't contain duplicate keys.

-   Each key can map at max one value.

Map cares about the unique identifier. We can map a unique key to a
specific value. It is a key/value pair. We can search a value, based on
the key. Like the set, the map also uses the "equals ( )" method to
determine whether two keys are the same or different.

Map is of following types:

-   Hash Map:

    -   Unordered and unsorted map.

    -   Hashmap is a good choice when we don't care about the order.

    -   It allows one null key and multiple null values.

Example:

Public class Fruit {

\>Public static void main(String\[\] args) {

\>\>HashMap \< Sting, String \> names = new HashMap \< String, String \>
();

\>\>names.put("key1", "cherry");

\>\>names.put("key2", "banana");

\>\>names.put("key3", "apple");

\>\>names.put("key4", "kiwi");

\>\>names.put("key1", "cherry");

\>\>System.out.println(names);

\>}

}

Output:

{key2 =banana, key1=cherry, key4 =kiwi, key3= apple}

Duplicate keys are not allowed in Map.

It doesn't maintain any insertion order and is unsorted.

-   Hash Table:

    -   Like the vector key, methods of the class are synchronized.

    -   Thread safety and therefore slows the performance.

    -   It doesn't allow anything that is null.

Example:

public class Fruit {

\>public static void main(String\[\] args) {

\>\>Hashtable \< Sting, String \> names = new Hashtable \< String,
String \> ();

\>\>names.put("key1", "cherry");

\>\>names.put("key2", "apple");

\>\>names.put("key3", "banana");

\>\>names.put("key4", "kiwi");

\>\>names.put("key2", "orange");

\>\>System.out.println(names);

\>}

}

Output:

{key2=apple, key1=cherry,key4=kiwi, key3=banana}

Duplicate keys are not allowed.

-   Linked Hash Map:

    -   Maintains insertion order.

    -   Slower than Hash map.

    -   I can expect a faster iteration.

Example:

public class Fruit {

\>public static void main(String\[\] args) {

\>\>LinkedHashMap \< Sting, String \> names = new LinkedHashMap \<
String, String \> ();

\>\>names.put("key1", "cherry");

\>\>names.put("key2", "apple");

\>\>names.put("key3", "banana");

\>\>names.put("key4", "kiwi");

\>\>names.put("key2", "orange");

\>\>System.out.println(names);

\>}

}

Output:

{key2=apple, key1=cherry,key4=kiwi, key3=banana}

Duplicate keys are not allowed.

-   TreeMap:

    -   Sorted Map.

    -   Like Tree set, we can construct a sort order with the
        constructor.

Example:

public class Fruit {

\>public static void main(String\[\] args) {

\>\>TreeMap \< Sting, String \> names = new TreeMap \< String, String \>
();

\>\>names.put("key1", "cherry");

\>\>names.put("key2", "banana");

\>\>names.put("key3", "apple");

\>\>names.put("key4", "kiwi");

\>\>names.put("key2", "orange");

\>\>System.out.println(names);

\>}

}

Output:

{key1=cherry, key2=banana, key3 =apple, key4=kiwi}

It is sorted in ascending order based on the key. Duplicate keys are not
allowed.

478. **What is Polymorphism?**

Polymorphism is briefly described as "one interface, many
implementations". Polymorphism is a characteristic of being able to
assign a different meaning or usage to something in different contexts
-- specifically, to allow an entity such as a variable, a function, or
an object to have more than one form. There are two types of
polymorphism:

-   Compile time polymorphism

-   Run time polymorphism

Compile time polymorphism is method overloading whereas Runtime time
polymorphism is done using inheritance and interface.

![](image103.png){width="5.030555555555556in"
height="3.1284722222222223in"}

479. **What is composition in Java?**

Composition is again a specialized form of Aggregation and we can call
this as a "death" relationship. It is a strong type of Aggregation.
Child object does not have their lifecycle and if parent object deletes
all child object will also be deleted. Let's take again an example of a
relationship between House and rooms. House can contain multiple rooms
there is no independent life of room and any room can not belongs to two
different houses if we delete the house room will automatically delete.

480. **What is a servlet?**

-   Java Servlet is server-side technologies to extend the capability of
    web servers by providing support for dynamic response and data
    persistence.

-   The javax.servlet and javax.servlet.http packages provide interfaces
    and classes for writing our own servlets.

-   All servlets must implement the javax.servlet.Servlet interface,
    which defines servlet lifecycle methods. When implementing a generic
    service, we can extend the GenericServlet class provided with the
    Java Servlet API. The HttpServlet class provides methods, such as
    doGet() and doPost(), for handling HTTP-specific services.

-   Most of the times, web applications are accessed using HTTP protocol
    and thats why we mostly extend HttpServlet class. Servlet API
    hierarchy is shown in below image.

![Servlet - Java Interview Questions -
Edureka](image104.png){width="3.5416666666666665in"
height="3.125in"}

481. **What are the differences between Get and Post methods?**

![](image105.png){width="6.5in"
height="2.203472222222222in"}

Get and post are two different HTTP verbs for two different actions. Get
is used for querying already available resources. Keep in mind that
using get, the request body must be empty, we can specify the query with
request parameters (query string). Post is for creating new resources.
The new object to create is mostly sent in the request body e.g. in JSON
format.

Example:

GET /items: The response will contain all available resources on this
location.

POST /items: We send a new resource in the request body, the server
might response with the URL of the newly created object, in this case
let it be /items/5.

GET /items/5: Now the response will contain the resource with an ID of
5, our newly created object.

482. **What is Request Dispatcher?**

RequestDispatcher interface is used to forward the request to another
resource that can be HTML, JSP or another servlet in same application.
We can also use this to include the content of another resource to the
response.

There are two methods defined in this interface:

-   void forward()

-   void include()

![ForwardMethod - Java Interview Questions -
Edureka](image106.png){width="6.5in"
height="2.1972222222222224in"}

![IncludeMethod - Java Interview Questions -
Edureka](image107.png){width="6.5in"
height="2.4694444444444446in"}

483. **What are the differences between forward() method and
     sendRedirect() methods?**

![](image108.png){width="6.5in"
height="1.479861111111111in"}

484. **What is the life-cycle of a servlet?**

There are 5 stages in the lifecycle of a servlet:

![LifeCycleServlet - Java Interview Questions -
Edureka](image109.png){width="3.1284722222222223in"
height="2.954861111111111in"}

-   Servlet is loaded

-   Servlet is instantiated

-   Servlet is initialized

-   Service the request

-   Servlet is destroyed

485. **How does cookies work in Servlets?**

-   Cookies are text data sent by server to the client and it gets saved
    at the client local machine.

-   Servlet API provides cookies support through
    javax.servlet.http.Cookie class that implements Serializable and
    Cloneable interfaces.

-   HttpServletRequest getCookies() method is provided to get the array
    of Cookies from request, since there is no point of adding Cookie to
    request, there are no methods to set or add cookie to request. All
    matching cookies are sent automatically every request.

-   Similarly HttpServletResponse addCookie(Cookie c) method is provided
    to attach cookie in response header, there are no getter methods for
    cookie.

486. **What are the differences between ServletContext vs
     ServletConfig?**

The difference between ServletContext and ServletConfig in Servlets JSP
is in below tabular format.

![](image110.png){width="6.5in"
height="2.9895833333333335in"}

487. **What are the different methods of session management in
     servlets?**

Session is a conversational state between client and server and it can
consists of multiple request and response between client and server.
Since HTTP and Web Server both are stateless, the only way to maintain a
session is when some unique information about the session (session id)
is passed between server and client in every request and response.

Some of the common ways of session management in servlets are:

-   User Authentication

-   HTML Hidden Field

-   Cookies

-   URL Rewriting

-   Session Management API

![SessionManagement - Java Interview Questions -
Edureka](image111.png){width="6.5in"
height="1.3069444444444445in"}

488. **Name the different modules of the Spring framework.**

Some of the important Spring Framework modules are:

-   Spring Context -- for dependency injection.

-   Spring AOP -- for aspect oriented programming.

-   Spring DAO -- for database operations using DAO pattern

-   Spring JDBC -- for JDBC and DataSource support.

-   Spring ORM -- for ORM tools support such as Hibernate

-   Spring Web Module -- for creating web applications.

-   Spring MVC -- Model-View-Controller implementation for creating web
    applications, web services etc.

![SpringFramework - Java Interview Questions -
Edureka](image112.png){width="6.5in"
height="4.7347222222222225in"}

489. **List some of the important annotations in annotation-based Spring
     configuration.**

The important annotations are:

-   \@Required

-   \@Autowired

-   \@Qualifier

-   \@Resource

-   \@PostConstruct

-   \@PreDestroy

490. **Explain Bean in Spring and List the different Scopes of Spring
     bean.**

Beans are objects that form the backbone of a Spring application. They
are managed by the Spring IoC container. In other words, a bean is an
object that is instantiated, assembled, and managed by a Spring IoC
container.

There are five Scopes defined in Spring beans.

![SpringBean - Java Interview Questions -
Edureka](image113.png){width="6.5in"
height="1.3083333333333333in"}

-   Singleton: Only one instance of the bean will be created for each
    container. This is the default scope for the spring beans. While
    using this scope, make sure spring bean doesn't have shared instance
    variables otherwise it might lead to data inconsistency issues
    because it's not thread-safe.

-   Prototype: A new instance will be created every time the bean is
    requested.

-   Request: This is same as prototype scope, however it's meant to be
    used for web applications. A new instance of the bean will be
    created for each HTTP request.

-   Session: A new bean will be created for each HTTP session by the
    container.

-   Global-session: This is used to create global session beans for
    Portlet applications.

491. **Explain the role of DispatcherServlet and
     ContextLoaderListener.**

DispatcherServlet is basically the front controller in the Spring MVC
application as it loads the spring bean configuration file and
initializes all the beans that have been configured. If annotations are
enabled, it also scans the packages to configure any bean annotated with
\@Component, \@Controller, \@Repository or \@Service annotations.

![DispatcherServlet - Java Interview Questions -
Edureka](image114.png){width="6.5in"
height="5.346527777777778in"}

ContextLoaderListener, on the other hand, is the listener to start up
and shut down the WebApplicationContext in Spring root. Some of its
important functions includes tying up the lifecycle of Application
Context to the lifecycle of the ServletContext and automating the
creation of ApplicationContext.

![ContextLoader - Java Interview Questions -
Edureka](image115.png){width="5.5in"
height="2.0909722222222222in"}

492. **What are the differences between constructor injection and setter
     injection?**

![](image116.png){width="6.5in"
height="1.6805555555555556in"}

493. **What is autowiring in Spring? What are the autowiring modes?**

Autowiring enables the programmer to inject the bean automatically. We
don't need to write explicit injection logic. Let's see the code to
inject bean using dependency injection.

-   \<bean id="emp" class="com.javatpoint.Employee" autowire="byName"
    /\>

The autowiring modes are given below:

![](image117.png){width="6.5in" height="1.2625in"}

494. **What are some of the important Spring annotations?**

-   \@Controller -- for controller classes in Spring MVC project.

-   \@RequestMapping -- for configuring URI mapping in controller
    handler methods. This is a very important annotation, so you should
    go through Spring MVC RequestMapping Annotation Examples

-   \@ResponseBody -- for sending Object as response, usually for
    sending XML or JSON data as response.

-   \@PathVariable -- for mapping dynamic values from the URI to handler
    method arguments.

-   \@Autowired -- for autowiring dependencies in spring beans.

-   \@Qualifier -- with \@Autowired annotation to avoid confusion when
    multiple instances of bean type is present.

-   \@Service -- for service classes.

-   \@Scope -- for configuring the scope of the spring bean.

-   \@Configuration, \@ComponentScan and \@Bean -- for java based
    configurations.

-   AspectJ annotations for configuring aspects and advices , \@Aspect,
    \@Before, \@After, \@Around, \@Pointcut, etc.

495. **How to integrate Spring and Hibernate Frameworks?**

We can use Spring ORM module to integrate Spring and Hibernate
frameworks if you are using Hibernate 3+ where SessionFactory provides
current session, then you should avoid using HibernateTemplate or
HibernateDaoSupport classes and better to use DAO pattern with
dependency injection for the integration.

Also, Spring ORM provides support for using Spring declarative
transaction management, so you should utilize that rather than going for
hibernate boiler-plate code for transaction management.

496. **Name the types of transaction management that Spring supports.**

Two types of transaction management are supported by Spring. They are:

-   Programmatic transaction management: In this, the transaction is
    managed with the help of programming. It provides you extreme
    flexibility, but it is very difficult to maintain.

-   Declarative transaction management: In this, transaction management
    is separated from the business code. Only annotations or XML based
    configurations are used to manage the transactions.

497. **What is Hibernate Framework?**

Object-relational mapping or ORM is the programming technique to map
application domain model objects to the relational database tables.
Hibernate is Java-based ORM tool that provides a framework for mapping
application domain objects to the relational database tables and vice
versa.

Hibernate provides a reference implementation of Java Persistence API,
that makes it a great choice as ORM tool with benefits of loose
coupling. We can use the Hibernate persistence API for CRUD operations.
Hibernate framework provide option to map plain old java objects to
traditional database tables with the use of JPA annotations as well as
XML based configuration.

Similarly, hibernate configurations are flexible and can be done from
XML configuration file as well as programmatically.

498. **What are the important benefits of using Hibernate Framework?**

Some of the important benefits of using hibernate framework are:

-   Hibernate eliminates all the boiler-plate code that comes with JDBC
    and takes care of managing resources, so we can focus on business
    logic.

-   Hibernate framework provides support for XML as well as JPA
    annotations, that makes our code implementation independent.

-   Hibernate provides a powerful query language (HQL) that is similar
    to SQL. However, HQL is fully object-oriented and understands
    concepts like inheritance, polymorphism, and association.

-   Hibernate is an open source project from Red Hat Community and used
    worldwide. This makes it a better choice than others because
    learning curve is small and there are tons of online documentation
    and help is easily available in forums.

-   Hibernate is easy to integrate with other Java EE frameworks, it's
    so popular that Spring Framework provides built-in support for
    integrating hibernate with Spring applications.

-   Hibernate supports lazy initialization using proxy objects and
    perform actual database queries only when it's required.

-   Hibernate cache helps us in getting better performance.

-   For database vendor specific feature, hibernate is suitable because
    we can also execute native sql queries.

Overall hibernate is the best choice in current market for ORM tool, it
contains all the features that you will ever need in an ORM tool.

499. **Explain Hibernate architecture.**

Hibernate has a layered architecture which helps the user to operate
without having to know the underlying APIs. Hibernate makes use of the
database and configuration data to provide persistence services (and
persistent objects) to the application. It includes many objects such as
persistent object, session factory, transaction factory, connection
factory, session, transaction etc.

![HibernateArchitecture - Java Interview Questions -
Edureka](image118.png){width="6.5in" height="4.4375in"}

The Hibernate architecture is categorized in four layers.

-   Java application layer

-   Hibernate framework layer

-   Backhand API layer

-   Database layer

500. **What are the differences between get and load methods?**

The differences between get() and load() methods are given below.

![](image119.png){width="6.5in"
height="1.6180555555555556in"}

501. **What are the advantages of Hibernate over JDBC?**

Some of the important advantages of Hibernate framework over JDBC are:

-   Hibernate removes a lot of boiler-plate code that comes with JDBC
    API, the code looks cleaner and readable.

-   Hibernate supports inheritance, associations, and collections. These
    features are not present with JDBC API.

-   Hibernate implicitly provides transaction management, in fact, most
    of the queries can't be executed outside transaction. In JDBC API,
    we need to write code for transaction management using commit and
    rollback.

-   JDBC API throws SQLException that is a checked exception, so we need
    to write a lot of try-catch block code. Most of the times it's
    redundant in every JDBC call and used for transaction management.
    Hibernate wraps JDBC exceptions and throw JDBCException or
    HibernateException un-checked exception, so we don't need to write
    code to handle it. Hibernate built-in transaction management removes
    the usage of try-catch blocks.

-   Hibernate Query Language (HQL) is more object-oriented and close to
    Java programming language. For JDBC, we need to write native SQL
    queries.

-   Hibernate supports caching that is better for performance, JDBC
    queries are not cached hence performance is low.

-   Hibernate provides option through which we can create database
    tables too, for JDBC tables must exist in the database.

-   Hibernate configuration helps us in using JDBC like connection as
    well as JNDI DataSource for the connection pool. This is a very
    important feature in enterprise application and completely missing
    in JDBC API.

-   Hibernate supports JPA annotations, so the code is independent of
    the implementation and easily replaceable with other ORM tools. JDBC
    code is very tightly coupled with the application.

502. **What are the life-cycle methods for a jsp?**

![](image120.png){width="6.5in"
height="1.8263888888888888in"}

503. **What are the JSP implicit objects?**

JSP provides 9 implicit objects by default. They are as follows:

![](image121.png){width="5.615367454068242in"
height="3.55257874015748in"}

504. **What are the differences between include directive and include
     action?**

![](image122.png){width="6.5in"
height="1.6715277777777777in"}

505. **How to disable caching on back button of the browser?**

response.setHeader(\"Cache-Control\", \"no-store\");

response.setHeader(\"Pragma\", \"no-cache\");

response.setHeader(\"Expires\", \"0\"); // Prevents caching at the proxy
server

506. **What are the different tags provided in JSTL?**

There are 5 type of JSTL tags.

-   core tags

-   sql tags

-   xml tags

-   internationalization tags

-   functions tags

507. **How to disable session in JSP?**

\<%@ page session="false" %\>

508. **How to delete a Cookie in a JSP?**

The following code explains how to delete a Cookie in a JSP:

Cookie mycook = new Cookie(\"name1\",\"value1\");

response.addCookie(mycook1);

Cookie killmycook = new Cookie(\"mycook1\",\"value1\");

killmycook . set MaxAge ( 0 );

killmycook . set Path (\"/\");

killmycook . addCookie ( killmycook 1 );

509. **Explain the jspDestroy() method.**

jspDestry() method is invoked from javax.servlet.jsp.JspPage interface
whenever a JSP page is about to be destroyed. Servlets destroy methods
can be easily overridden to perform cleanup, like when closing a
database connection.

510. **How is JSP better than Servlet technology?**

JSP is a technology on the server's side to make content generation
simple. They are document-centric, whereas servlets are programs. A Java
server page can contain fragments of Java program, which execute and
instantiate Java classes. However, they occur inside an HTML template
file. It provides the framework for the development of a Web
Application.

511. **What are the different categories of Java Design patterns?**

Java Design patterns can be broadly categorized into three main
categories: creational patterns, structural patterns, and behavioral
patterns. Let's explore each category in more detail:

-   Creational Patterns: These patterns deal with object creation
    mechanisms, providing ways to create objects in a flexible and
    reusable manner. Some common creational patterns include:

    -   Singleton: Ensures that only one instance of a class is created
        and provides a global point of access to it.

    -   Factory Method: Defines an interface for creating objects, but
        lets subclasses decide which class to instantiate.

    -   Abstract Factory: Provides an interface for creating families of
        related or dependent objects without specifying their concrete
        classes.

-   Structural Patterns: These patterns focus on the composition of
    classes and objects, defining how they can be structured to form
    larger structures while keeping the system flexible and efficient.
    Some examples of structural patterns include:

    -   Adapter: Converts the interface of a class into another
        interface that clients expect.

    -   Decorator: Dynamically adds new behaviors or responsibilities to
        an object.

    -   Composite: Treats a group of objects as a single object,
        allowing clients to treat individual objects and compositions
        uniformly.

-   Behavioral Patterns: These patterns address the interaction and
    communication between objects, defining how they collaborate and
    fulfill their responsibilities. Some common behavioral patterns are:

    -   Observer: Defines a one-to-many dependency between objects so
        that when one object changes state, all its dependents are
        notified and updated automatically.

    -   Strategy: Defines a family of algorithms, encapsulates each one,
        and makes them interchangeable at runtime.

    -   Command: Encapsulates a request as an object, allowing you to
        parameterize clients with queues, requests, and operations.

These divisions offer a methodical approach to categorize and comprehend
many Java design patterns. It is noteworthy that certain design patterns
might fall into more than one category or have variants and
combinations, and that these categories are not exclusive of one
another. Other design patterns that fall outside of these categories
include concurrency patterns and architectural patterns, both of which
are applicable to Java programming.

512. **Why should we not configure JSP standard tags in web.xml?**

We don't need to configure JSP standard tags in web.xml because when
container loads the web application and find TLD files, it automatically
configures them to be used directly in the application JSP pages. We
just need to include it in the JSP page using taglib directive.

513. **How will you use JSP EL in order to get the HTTP method name?**

Using pageContext JSP EL implicit object you can get the request object
reference and make use of the dot operator to retrieve the HTTP method
name in the JSP page. The JSP EL code for this purpose will look like
\${pageContext.request.method}.

514. **What is the difference between Error and Exception?**

An error is an irrecoverable condition occurring at runtime. Such as
OutOfMemory error. These JVM errors you cannot repair them at runtime.
Though error can be caught in the catch block but the execution of
application will come to a halt and is not recoverable.

While exceptions are conditions that occur because of bad input or human
error etc. e.g. FileNotFoundException will be thrown if the specified
file does not exist. Or a NullPointerException will take place if you
try using a null reference. In most of the cases it is possible to
recover from an exception (probably by giving the user feedback for
entering proper values etc.

515. **Will the finally block get executed when the return statement is
     written at the end of try block and catch block as shown below?**

The finally block always gets executed even when the return statement is
written at the end of the try block and the catch block. It always
executes , whether there is an exception or not. There are only a few
situations in which the finally block does not execute, such as VM
crash, power failure, software crash, etc. If you don't want to execute
the finally block, you need to call the System.exit() method explicitly
in the finally block.

516. **What are the important methods of Java Exception Class?**

Exception and all of it's subclasses doesn't provide any specific
methods and all of the methods are defined in the base class Throwable.

-   String getMessage() -- This method returns the message String of
    Throwable and the message can be provided while creating the
    exception through it's constructor.

-   String getLocalizedMessage() -- This method is provided so that
    subclasses can override it to provide locale specific message to the
    calling program. Throwable class implementation of this method
    simply use getMessage() method to return the exception message.

-   Synchronized Throwable getCause() -- This method returns the cause
    of the exception or null id the cause is unknown.

-   String toString() -- This method returns the information about
    Throwable in String format, the returned String contains the name of
    Throwable class and localized message.

-   void printStackTrace() -- This method prints the stack trace
    information to the standard error stream, this method is overloaded
    and we can pass PrintStream or PrintWriter as an argument to write
    the stack trace information to the file or stream.

517. **What is OutOfMemoryError in Java?**

OutOfMemoryError is the subclass of java.lang.Error which generally
occurs when our JVM runs out of memory.

518. **What are the different types of garbage collectors in Java?**

Garbage collection in Java a program which helps in implicit memory
management. Since in Java, using the new keyword you can create objects
dynamically, which once created will consume some memory. Once the job
is done and there are no more references left to the object, Java using
garbage collection destroys the object and relieves the memory occupied
by it. Java provides four types of garbage collectors:

-   Serial Garbage Collector

-   Parallel Garbage Collector

-   CMS Garbage Collector

-   G1 Garbage Collector

The Java programming language has four types of garbage collectors:

-   Serial Garbage Collector: Using only a single thread for garbage
    collection, the serial garbage collector works by holding all the
    application threads. It is designed especially for single-threaded
    environments. Because serial garbage collector freezes all
    application threads while performing garbage collection, it is most
    suitable for command-line programs only. For using the serial
    garbage collector, one needs to turn on the -XX:+UseSerialGC JVM
    argument.

-   Parallel Garbage Collector: Also known as the throughput collector,
    the parallel garbage collector is the default garbage collector of
    the JVM. It uses multiple threads for garbage collection, and like a
    serial garbage collector freezes all application threads during
    garbage collection.

-   CMS Garbage Collector: Short for Concurrent Mark Sweep, CMS garbage
    collector uses multiple threads for scanning the heap memory for
    marking instances for eviction, followed by sweeping the marked
    instances. There are only two scenarios when the CMS garbage
    collector holds all the application threads:

    -   When marking the referenced objects in the tenured generation
        space.

    -   If there is a change in the heap memory while performing the
        garbage collection, CMS garbage collector ensures better
        application throughput over parallel garbage collectors by using
        more CPU resources. For using the CMS garbage collector, the
        XX:+USeParNewGC JVM argument needs to be turned on.

-   G1 Garbage Collector: Used for large heap memory areas, G1 garbage
    collector works by separating the heap memory into multiple regions
    and then executing garbage collection in them in parallel. Unlike
    the CMS garbage collector that compacts the memory on STW (Stop The
    World) situations, G1 garbage collector compacts the free heap space
    right after reclaiming the memory. Also, the G1 garbage collector
    prioritizes the region with the most garbage. Turning on the
    --XX:+UseG1GC JVM argument is required for using the G1 garbage
    collector.

[Top 50+ Core Java Interview Questions and Answers (2023)
(softwaretestinghelp.com)](https://www.softwaretestinghelp.com/core-java-interview-questions/)

519. **How does Java enable high performance?**

Java uses Just In Time compiler to enable high performance. It is used
to convert the instructions into bytecodes.

520. **Name the Java IDE's?**

Eclipse and NetBeans are the IDE's of JAVA.

521. **What are the OOPs concepts?**

OOPs concepts include:

-   Inheritance

-   Encapsulation

-   Polymorphism

-   Abstraction

-   Interface

522. **What is Polymorphism?**

Polymorphism means many forms.

A single object can refer to the super-class or sub-class depending on
the reference type which is called polymorphism.

Example:

Public class Manipulation() { //Super class

\>public void add() {}

}

public class Addition extends Manipulation() { // Sub class

\>public void add() {}

\>public static void main(String args\[\]) {

\>\>Manipulation addition = new Addition(); //Manipulation is reference
type and Addition is reference type

\>\>addition.add();

\>}

}

Using the Manipulation reference type we can call the Addition class
"add()" method. This ability is known as Polymorphism. Polymorphism is
applicable for overriding and not for overloading.

523. **Explain about Public and Private access specifiers.**

Methods and instance variables are known as members.

Public:

Public members are visible in the same package as well as the outside
package that is for other packages.

![Public](image123.jpeg){width="5.719444444444444in"
height="1.757638888888889in"}

Public members of Class A are visible to Class B (same package) as well
as Class C (different packages).

Private:

Private members are visible in the same class only and not for the other
classes in the same package as well as classes in the outside packages.

![Private](image124.jpeg){width="6.166666666666667in"
height="2.0076388888888888in"}

Private members in class A are visible only in that class. It is
invisible for class B as well as class C.

524. **Difference between Default and Protected access specifiers.**

Default: Methods and variables declared in a class without any access
specifiers are called default.

![Default](image125.jpeg){width="5.863888888888889in"
height="1.8256944444444445in"}

Default members in Class A are visible to the other classes which are
inside the package and invisible to the classes which are outside the
package.

So Class A members are visible to Class B and invisible to Class C.

Protected:

![Protected](image126.jpeg){width="5.136111111111111in"
height="1.8486111111111112in"}

Protected is the same as Default but if a class extends then it is
visible even if it is outside the package.

Class A members are visible to Class B because it is inside the package.
For Class C it is invisible but if Class C extends Class A then the
members are visible to Class C even if it is outside the package.

525. **What is the meaning of Collections in Java?**

Collection is a framework that is designed to store the objects and
manipulate the design to store the objects.

Collections are used to perform the following operations:

-   Searching

-   Sorting

-   Manipulation

-   Insertion

-   Deletion

A group of objects is known as collections. All the classes and
interfaces for collecting are available in Java util package.

526. **What are all the Classes and Interfaces that are available in the
     collections?**

Given below are the Classes and Interfaces that are available in
Collections:

Interfaces:

-   Collection

-   List

-   Set

-   Map

-   Sorted Set

-   Sorted Map

-   Queue

Classes:

Lists:

-   Array List

-   Vector

-   Linked List

Sets:

-   Hash set

-   Linked Hash Set

-   Tree Set

Maps:

-   Hash Map

-   Hash Table

-   TreeMap

-   Linked Hashed Map

Queue:

-   Priority Queue

527. **What is meant by Ordered and Sorted in collections?**

Ordered: It means the values that are stored in a collection is based on
the values that are added to the collection. So we can iterate the
values from the collection in a specific order.

Sorted: Sorting mechanisms can be applied internally or externally so
that the group of objects sorted in a particular collection is based on
the properties of the objects.

528. **Explain the different lists available in the collection.**

Values added to the list are based on the index position and it is
ordered by index position. Duplicates are allowed.

The types of Lists are:

-   Array List:

    -   Fast iteration and fast Random Access.

    -   It is an ordered collection (by index) and not sorted.

    -   It implements the Random Access Interface.

Example:

public class Fruits {

\>public static void main(String\[\] args) {

\>\>ArrayList \< String \> names = new ArrayList \< String \> ();

\>\>names.add("apple");

\>\>names.add("cherry");

\>\>names.add("kiwi");

\>\>names.add("banana");

\>\>names.add("cherry");

\>\>System.out.println(names);

\>}

}

Output:

\[Apple, cherry, kiwi, banana, cherry\]

From the output, Array List maintains the insertion order and it accepts
the duplicates. But it's not sorted.

-   Vector:

    -   It is the same as Array List.

    -   Vector methods are synchronized.

    -   Thread safety.

    -   It also implements Random Access.

    -   Thread safety usually causes a performance hit.

Example:

public class Fruit {

\>public static void main(String\[\] args) {

\>\>Vector \< String \> names = new Vector \< String \> ();

\>\>names.add("cherry");

\>\>names.add("apple");

\>\>names.add("banana");

\>\>names.add("kiwi");

\>\>names.add("apple");

\>\>System.out.println("names");

\>}

}

Output:

\[cherry,apple,banana,kiwi,apple\]

Vector also maintains the insertion order and accepts the duplicates.

-   Linked List:

    -   Elements are doubly linked to one another.

    -   Performance is slower than the Array list.

    -   Good choice for insertion and deletion.

    -   In Java 5.0 it supports common queue methods peek( ), Pool ( ),
        Offer ( ) etc.

Example:

public class Fruit {

\>public static void main(String\[\] args) {

\>\>Linkedlist \< String \> names = new linkedlist \< String \> ();

\>\>names.add("banana");

\>\>names.add("cherry");

\>\>names.add("apple");

\>\>names.add("kiwi");

\>\>names.add("banana");

\>\>System.out.println(names);

\>}

}

Output:

\[ banana,cherry,apple,kiwi,banana\]

Maintains the insertion order and accepts the duplicates.

529. **Explain about Set and their types in a collection.**

Set cares about uniqueness. It doesn't allow duplications. Here "equals
( )" method is used to determine whether two objects are identical or
not.

-   Hash Set:

    -   Unordered and unsorted.

    -   Uses the hash code of the object to insert the values.

    -   Use this when the requirement is "no duplicates and don't care
        about the order".

Example:

public class Fruit {

\>public static void main(String\[\] args) {

\>\>HashSet \< String \> names = new HashSet \<= String \> ();

\>\>names.add("banana");

\>\>names.add("cherry");

\>\>names.add("apple");

\>\>names.add("kiwi");

\>\>names.add("banana");

\>\>System.out.println(names);

\>}

}

Output:

\[banana, cherry, kiwi, apple\]

It doesn't follow any insertion order. Duplicates are not allowed.

-   Linked Hash set:

    -   An ordered version of the hash set is known as Linked Hash Set.

    -   Maintains a doubly-Linked list of all the elements.

    -   Use this when an iteration order is required.

Example:

public class Fruit {

\>public static void main(String\[\] args) {

\>\>LinkedHashSet \< String \> ;

\>\>names = new LinkedHashSet \< String \> ();

\>\>names.add("banana");

\>\>names.add("cherry");

\>\>names.add("apple");

\>\>names.add("kiwi");

\>\>names.add("banana");

\>\>System.out.println(names);

\>}

}

Output:

\[banana, cherry, apple, kiwi\]

It maintains the insertion order in which they have been added to the
Set. Duplicates are not allowed.

-   Tree Set:

    -   It is one of the two sorted collections.

    -   Uses the "Read-Black" tree structure and guarantees that the
        elements will be in ascending order.

    -   We can construct a tree set with the constructor by using a
        comparable (or) comparator.

Example:

public class Fruits {

\>public static void main(String\[\] args) {

\>\>Treeset \< String \> names = new TreeSet \< String \> ();

\>\>names.add("cherry");

\>\>names.add("banana");

\>\>names.add("apple");

\>\>names.add("kiwi");

\>\>names.add("cherry");

\>\>System.out.println(names);

\>}

}

Output:

\[apple, banana, cherry, kiwi\]

TreeSet sorts the elements in ascending order. And duplicates are not
allowed.

530. **Explain the Priority Queue.**

Queue Interface

Priority Queue: Linked list class has been enhanced to implement the
queue interface. Queues can be handled with a linked list. The purpose
of a queue is "Priority-in, Priority-out".

Hence elements are ordered either naturally or according to the
comparator. The elements ordering represents their relative priority.

A priority queue, like a regular queue, is an abstract data type, but it
has a priority associated with each element contained by it.

The element with the high priority is served before the element with low
priority in a priority queue. Elements in a priority queue are ordered
either according to the comparator or naturally. The order of the
elements in a priority queue represents their relative priority.

531. **What are the types of Exceptions?**

There are two types of Exceptions. They are explained below in detail.

-   Checked Exception:

> These exceptions are checked by the compiler at the time of
> compilation. Classes that extend Throwable class except Runtime
> exception and Error are called checked Exception.
>
> Checked Exceptions must either declare the exception using throws
> keyword (or) surrounded by appropriate try/catch.

For Example, ClassNotFound Exception

-   Unchecked Exception:

> These exceptions are not checked during the compile time by the
> compiler. The compiler doesn't force to handle these exceptions. It
> includes:
>
> Arithmetic Exception
>
> ArrayIndexOutOfBounds Exception

532. **What are the advantages of Exception handling?**

The advantages of exception handling are as follows:

-   The normal flow of the execution won't be terminated if an exception
    gets handled

-   We can identify the problem by using catch declaration

533. **What are the Exception handling keywords in Java?**

Enlisted below are the three Exception Handling Keywords:

-   try:

> When a risky code is surrounded by a try block. An exception occurring
> in the try block is caught by a catch block. Try can be followed
> either by catch (or) finally (or) both. But any one of the blocks is
> mandatory.

-   catch:

> This is followed by a try block. Exceptions are caught here.

-   finally:

> This is followed either by try block (or) catch block. This block gets
> executed regardless of an exception. So generally clean up codes are
> provided here.

534. **What does the yield method of the Thread class do?**

A yield () method moves the currently running thread to a runnable state
and allows the other threads for execution. So that equal priority
threads have a chance to run. It is a static method. It doesn't release
any lock.

Yield () method moves the thread back to the Runnable state only, and
not the thread to sleep (), wait () (or) block.

Example:

public static void main(String\[\] args) {

\>Thread t = new Thread();

\>t.start();

}

public void run() {

\>Thread.yield();

}

535. **How to stop a thread in java? Explain about sleep () method in a
     thread?**

We can stop a thread by using the following thread methods:

-   Sleeping

-   Waiting

-   Blocked

Sleep: Sleep () method is used to sleep the currently executing thread
for the given amount of time. Once the thread is wake up it can move to
the runnable state. So sleep () method is used to delay the execution
for some period.

It is a static method.

Example:

Thread. Sleep (2000)

So it delays the thread to sleep 2000 milliseconds. Sleep () method
throws an uninterrupted exception, hence we need to surround the block
with try/catch.

public class ExampleThread implements Runnable {

\>public static void main(String\[\] args) {

\>\>Thread t = new Thread();

\>\>t.start();

\>}

\>public void run() {

\>\>try {

\>\>\>Thread.sleep(2000);

\>\>} catch (InterruptedException e) {}

\>}

}

-   Blocking: This method is used to put the thread in a blocked state.
    The execution resumes as soon as the condition of the blocking is
    met. For instance, the ServerSocket.accept() is a blocking method
    that listens for incoming socket connections and resumes the blocked
    thread only when a connection is made.

-   Sleeping: This method is used for delaying the execution of the
    thread for some time. A thread upon which the sleep() method is used
    is said to enter the sleep state. It enters the runnable state as
    soon as it wakes up i.e., the sleep state is finished. The time for
    which the thread needs to enter the sleep state is mentioned inside
    the braces of the sleep() method. It is a static method.

-   Waiting: Although it can be called on any Java object, the wait()
    method can only be called from a synchronized block.

536. **When to use the Runnable interface Vs Thread class in Java?**

If we need our class to extend some other classes other than the thread
then we can go with the runnable interface because in java we can extend
only one class.

If we are not going to extend any class then we can extend the thread
class.

537. **Difference between start() and run() method of thread class.**

Start() method creates a new thread and the code inside the run ()
method is executed in the new thread. If we directly called the run()
method then a new thread is not created and the currently executing
thread will continue to execute the run() method.

538. **What is the disadvantage of Synchronization?**

Synchronization is not recommended to implement all the methods. Because
if one thread accesses the synchronized code then the next thread should
have to wait. So it makes a slow performance on the other end.

539. **What is SerialVersionUID?**

Whenever an object is Serialized, the object is stamped with a version
ID number for the object class. This ID is called the SerialVersionUID.
This is used during deserialization to verify that the sender and
receiver that are compatible with the Serialization.

[Top 80 Java Interview Questions and Answers \[2023\]
(hackr.io)](https://hackr.io/blog/java-interview-questions)

540. **What are Java IDEs?**

A Java IDE is a software that allows Java developers to easily write as
well as debug Java programs. It is basically a collection of various
programming tools, accessible via a single interface, and several
helpful features, such as code completion and syntax highlighting.

Codenvy, Eclipse, and NetBeans are some of the most popular Java IDEs.

541. **Explain Typecasting.**

The concept of assigning a variable of one data type to a variable of
another data type. This is not possible for the boolean data type. There
are two types: implicit and explicit.

542. **What are the different types of typecasting?**

![types of typecasting](image127.png){width="6.5in"
height="3.658333333333333in"}

The different types of typecasting are:

-   Implicit: Storing values from a smaller data type to the larger data
    type. It is automatically done by the compiler.

-   Explicit: Storing the value of a larger data type into a smaller
    data type. This results in information loss:

-   Truncation:While converting a value from a larger data type to a
    smaller data type, the extra data will be truncated. This code
    example explains it :

> float f = 3.14f;
>
> int i = (int) f;

After execution, the variable i will contain only 3 and not the decimal
portion.

-   Out of Range:Typecasting does not allow assigning value more than
    its range; if that happens then the data is lost in such cases. This
    code example explains it:

long l = 123456789;

byte b = (byte) l; // byte is of not the same range as long so there
will be loss of data.

543. **Please explain Abstract class and Abstract method.**

An abstract class in Java is a class that can\'t be instantiated. Such a
class is typically used for providing a base for subclasses to extend as
well as implementing the abstract methods and overriding or using the
implemented methods defined in the abstract class.

To create an abstract class, it needs to be followed by the abstract
keyword. Any abstract class can have both abstract as well as
non-abstract methods. A method in Java that only has the declaration and
not implementation is known as an abstract method. Also, an abstract
method name is followed by the abstract keyword. Any concrete subclass
that extends the abstract class must provide an implementation for
abstract methods.

544. **Write suitable code examples to demonstrate the use of final,
     final, and finalize.**

Final: The final keyword is used for restricting a class, method, and
variable. A final class can\'t be inherited, a final method is disabled
from overriding, and a final variable becomes a constant i.e., its value
can\'t be changed.

classFinalVarExample {

\>publicstaticvoidmain(String args\[\]) {

\>\>final int a = 10;

\>\>a = 50; /\* Will result in an error as the value can't be changed
now\*/

\>}

}

Finally: Any code inside the final block will be executed, irrespective
of whether an exception is handled or not.

classFinallyExample {

\>publicstaticvoidmain(String args\[\]) {

\>\>try {

\>\>\>int x = 100;

\>\>} catch (Exception e) {

\>\>\>System.out.println(e);

\>\>} finally {

\>\>\>System.out.println(\"finally block is executing\");

\>\>}

\>}

}

Finalize: The finalize method performs the clean up just before the
object is garbage collected.

classFinalizeExample {

\>public void finalize() {

\>\>System.out.println(\"Finalize is called\");

\>}

\>public static void main(String args\[\]) {

\>\>FinalizeExample f1 = new FinalizeExample();

\>\>FinalizeExample f2 = new FinalizeExample();

\>\>f1 = NULL;

\>\>f2 = NULL;

\>\>System.gc();

\>}

}

545. **Please compare serialization and deserialization.**

Serialization is the process by which Java objects are converted into
the byte stream.

Deserialization is the exact opposite process of serialization where
Java objects are retrieved from the byte stream.

A Java object is serialized by writing it to an ObjectOutputStream and
deserialized by reading it from an ObjectInputStream.

546. **Explain the concept of boxing, unboxing, autoboxing, and auto
     unboxing.**

-   Boxing: The concept of putting a primitive value inside an object is
    called boxing.

-   Unboxing: Getting the primitive value from the object.

-   Autoboxing: Assigning a value directly to an integer object.

-   Auto unboxing: Getting the primitive value directly into the integer
    object.

public class BoxUnbox {

\>public static void main(String args\[\]) {

\>\>int i = 5;

\>\>Integer ii = new Integer(i); /\*Boxing\*/

\>\>Integer jj = i; /\*Unboxing\*/

\>\>int j = jj.intValue(); /\*Unboxing\*/

\>\>int k = jj; /\*AutoUnboxing\*/

\>}

}

547. **Take a look at the two code snippets below. What is the important
     difference between the two?**

i\.

class Adder {

\>Static int add(int a, int b) {

\>\>return a + b;

\>}

\>Static double add(double a, double b) {

\>\>return a + b;

\>}

\>public static void main(String args\[\]) {

\>\>System.out.println(Adder.add(11, 11));

\>\>System.out.println(Adder.add(12.3, 12.6));

\>}

}

ii\.

class Car {

\>void run() {

\>\>System.out.println("car is running");

\>}

\>Class Audi extends Car {

\>\>void run() {

\>\>\>System.out.prinltn("Audi is running safely with 100 km");

\>\>}

\>\>public static void main(String args\[\]) {

\>\>\>Car b = new Audi();

\>\>\>b.run();

\>\>}

\>}

}

Code snippet i. is an example of method overloading while the code
snippet ii. demonstrates method overriding.

548. **Write a program for string reversal without using an inbuilt
     function.**

public class Reversal {

\>public static void main(String args\[\]) {

\>\>String input = \"Java Interview\";

\>\>System.out.println(\"Given String -\> \" + \"Java Interview\");

\>\>char charArray\[\] = input.toCharArray();

\>\>System.out.println(\"Reversed String -\> \");

\>\>for (int i = charArray.length - 1; i \>= 0; i\--) {

\>\>\>System.out.print(charArray\[i\]);

\>\>}

\>\>System.out.println();

\>}

}

549. **Write a program to delete duplicates from an array.**

class RemoveDuplicates {

\>public static void main(String args\[\]) {

\>\>/\*create ArrayList with duplicate elements\*/

\>\>ArrayList duplicate = new ArrayList();

\>\>duplicate.add(5);

\>\>duplicate.add(7);

\>\>duplicate.add(1);

\>\>duplicate.add(4);

\>\>duplicate.add(1);

\>\>duplicate.add(7);

\>\>System.out.println(\"Given array: \" + duplicate);

\>\>Set \< Integer \> withoutDuplicates = new LinkedHashSet \< Integer
\> (duplicate)

\>\>duplicate.clear();

\>\>duplicate.addAll(withoutDuplicates);

\>\>System.out.println(\"Array without duplicates: \" + duplicate);

\>}

}

550. **Write a program to reverse a number.**

public class NumberReversal {

\>public static void main(String args\[\]) {

\>\>System.out.println(\"Please enter the number to be reversed\");

\>\>Scanner sc = new Scanner(System.in);

\>\>int number = sc.nextInt();

\>\>int reverse = reverse(number);

\>\>System.out.println(\"Reverse of number: \" + number + \" is \" +
reverse(number));

\>}

\>public static int reverse(int number) {

\>\>int reverse = 0;

\>\>int remainder = 0;

\>\>do {

\>\>\>remainder = number % 10;

\>\>\>reverse = reverse \* 10 + remainder;

\>\>\>number = number / 10;

\>\>} while (number \> 0);

\>\>return reverse;

\>}

}

551. **Write a program that implements binary search.**

public class Binary {

\>public static void main(String\[\] args) {

\>\>System.out.println(\"Enter total number of elements : \");

\>\>Scanner s = new Scanner(System.in);

\>\>int length = s.nextInt();

\>\>int\[\] input = newint\[length\];

\>\>System.out.printf(\"Enter %d integers\", length);

\>\>for (int i = 0; i \< length; i++) {

\>\>\>input\[i\] = s.nextInt();

\>\>}

\>\>/\* binary search requires the input array to be sorted so we must
sort the array first\*/

\>\>Arrays.sort(input);

\>\>System.out.print(\"the sorted array is: \");

\>\>for (int i = 0; i \<= length - 1; i++) {

\>\>\>System.out.println(input\[i\] + \" ,\");

\>\>}

\>\>System.out.println(\"Please enter number to be searched in sorted
array\");

\>\>int key = s.nextInt();

\>\>int index = BSearch(input, key);

\>\>if (index == -1) {

\>\>\>System.out.printf(\"Sorry, %d is not found in array %n\", key);

\>\>} else {

\>\>\>System.out.printf(\"%d is found in array at index %d %n\", key,

\>\>\>\>index);

\>\>}

\>}

\>public static int BSearch(int\[\] input, int number) {

\>\>int low = 0;

\>\>int high = input.length - 1;

\>\>while (high \>= low) {

\>\>\>int middle = (low + high) / 2;

\>\>\>if (input\[middle\] == number) {

\>\>\>\>return middle;

\>\>\>} else if (input\[middle\] \< number) {

\>\>\>\>low = middle + 1;

\>\>\>} else if (input\[middle\] \> number) {

\>\>\>\>high = middle - 1;

\>\>\>}

\>\>}

\>\>return -1;

\>}

}

552. **Write a program to check if a number is prime.**

public class Prime {

\>public static void main(String args\[\]) {

\>\>System.out.println(\"Enter the number to check: \");

\>\>Scanner sc = new Scanner(System.in);

\>\>int num = sc.nextInt();

\>\>boolean isPrime = false;

\>\>if (num != 0) {

\>\>\>isPrime = checkPrime(num);

\>\>} else {

\>\>\>System.out.println(\"Enter valid number\");

\>\>}

\>\>if (isPrime == false) {

\>\>\>System.out.println(\" NOT PRIME!!\");

\>\>} else {

\>\>\>System.out.println(\"PRIME!!\");

\>\>}

\>}

\>public static boolean checkPrime(int number) {

\>\>int sqrt = (int) Math.sqrt(number) + 1;

\>\>for (int i = 2; i \< sqrt; i++) {

\>\>\>if (number % i == 0) {

\>\>\>\>return false;

\>\>\>}

\>\>}

\>\>return true;

\>}

}

553. **Write a program to print Fibonacci series.**

public class Fibo {

\>public static void main(String args\[\]) {

\>\>System.out.println(\"Enter the number upto which Fibonacci series
should be printed \");

\>\>Scanner sc = new Scanner(System.in);

\>\>int num = sc.nextInt();

\>\>System.out.println(\"Fibonacci Series upto %d is\" + num);

\>\>for (int i = 1; i \<= num; i++) {

\>\>\>System.out.print(fib(i) + \" \");

\>\>}

\>}

\>public static int fib(int n) {

\>\>if (n == 1 \|\| n == 2) {

\>\>\>return 1;

\>\>}

\>\>return fib(n - 1) + fib(n - 2);

\>}

}

554. **Write a program to check if the given string is a palindrome.**

public class PalinDrome {

\>public static void main(String args\[\]) {

\>\>System.out.println(\"Enter the string to check\");

\>\>Scanner sc = new Scanner(System.in);

\>\>String str = sc.nextLine();

\>\>boolean isPalindrome;

\>\>isPalindrome = checkPalindrome(str);

\>\>if (str.equals(\" \")) {

\>\>\>System.out.println(\"Enter valid string\");

\>\>} else {

\>\>\>if (isPalindrome) {

\>\>\>\>System.out.println(\"PALINDROME!!\");

\>\>\>} else {

\>\>\>\>System.out.println(\"NOT A PALINDROME!!\");

\>\>\>}

\>\>}

\>}

\>public static boolean checkPalindrome(String input) {

\>\>int str_length = input.length();

\>\>int i = 0, j = str_length - 1;

\>\>while (i \< j) {

\>\>\>if (input.charAt(i) != input.charAt(j))

\>\>\>\>return false;

\>\>\>i++;

\>\>\>j\--;

\>\>}

\>\>return true;

\>}

}

555. **Write a program to print the following pattern.**

\*

\* \*

\* \* \*

\* \* \* \*

\* \* \* \* \*

Answer:

public class Pattern {

\>public static void main(String args\[\]) {

\>\>for (int i = 5; i \>= 0; i\--) {

\>\>\>System.out.println();

\>\>\>for (int j = i; j \< 5; j++) {

\>\>\>\>System.out.print(\" \* \");

\>\>\>}

\>\>}

\>\>System.out.println();

\>}

}

556. **Write a program to swap two numbers.**

public class Swap {

\>public static void main(String args\[\]) {

\>\>Scanner s = new Scanner(System.in);

\>\>System.out.println(\"Enter a number: \");

\>\>int a = s.nextInt();

\>\>System.out.println(\"Enter second number: \");

\>\>int b = s.nextInt();

\>\>System.out.println(\"Value of a and b before swapping: \" + \"a =
\" + a + \" b = \" + b);

\>\>swap(a, b);

\>}

\>public static void swap(int a, int b) {

\>\>int swap_variable;

\>\>swap_variable = a;

\>\>a = b;

\>\>b = swap_variable;

\>\>System.out.println(\"Value of a and b after swapping: \" + \"a =
\" + a + \" b = \" + b);

\>}

}

557. **Write a program to check if the given number is an Armstrong
     number.**

public class Armstrong {

\>public static void main(String args\[\]) {

\>\>Scanner s = new Scanner(System.in);

\>\>System.out.println(\"Enter a number: \");

\>\>int number = s.nextInt();

\>\>int a = number, sum = 0, num = 0;

\>\>while (a % 10 != 0) {

\>\>\>num = a % 10;

\>\>\>sum = sum + (num \* num \* num);

\>\>\>a = a / 10;

\>\>}

\>\>if (sum == number) {

\>\>\>System.out.println(\"Armstrong Number!\");

\>\>} else {

\>\>\>System.out.println(\"Not an Armstrong Number!\");

\>\>}

\>}

}

[Top 50 Java Programming Interview Questions \|
DigitalOcean](https://www.digitalocean.com/community/tutorials/java-programming-interview-questions)

558. **How do you swap two numbers without using a third variable in
     Java?**

Swapping numbers without using a third variable is a three-step process
that's better visualized in code:

b = b + a; // now b is sum of both the numbers

a = b - a; // b - a = (b + a) - a = b (a is swapped)

b = b - a; // (b + a) - b = a (b is swapped)

The following example code shows one way to implement the number swap
method:

public class SwapNumbers {

\>public static void main(String\[\] args) {

\>\>int a = 10;

\>\>int b = 20;

\>\>System.out.println(\"a is \" + a + \" and b is \" + b);

\>\>a = a + b;

\>\>b = a - b;

\>\>a = a - b;

\>\>System.out.println(\"After swapping, a is \" + a + \" and b is \" +
b);

\>}

}

The output shows that the integer values are swapped:

Output

a is 10 and b is 20

After swapping, a is 20 and b is 10

559. **Write a Java program to check if a vowel is present in a
     string.**

The following example code shows how to use a regular expression to
check whether the string contains vowels:

public class StringContainsVowels {

\>public static void main(String\[\] args) {

\>\>System.out.println(stringContainsVowels(\"Hello\")); // true

\>\>System.out.println(stringContainsVowels(\"TV\")); // false

\>}

\>public static boolean stringContainsVowels(String input) {

\>\>return input.toLowerCase().matches(\".\*\[aeiou\].\*\");

\>}

}

560. **How do you check if a list of integers contains only odd numbers
     in Java?**

You can use a for loop and check whether each element is odd:

public static boolean onlyOddNumbers(List \< Integer \> list) {

\>for (int i: list) {

\>\>if (i % 2 == 0)

\>\>\>return false;

\>}

\>return true;

}

If the list is large, you can use parallel stream for faster processing,
as shown in the following example code:

public static boolean onlyOddNumbers(List \< Integer \> list) {

\>return list

\>\>.parallelStream() // parallel stream for faster processing

\>\>.anyMatch(x - \> x % 2 != 0); // return as soon as any elements
match the condition

}

561. **How do you remove spaces from a string in Java?**

The following example code shows one way to remove spaces from a string
using with the Character.isWhitespace() method:

String removeWhiteSpaces(String input) {

\>StringBuilder output = new StringBuilder();

\>char\[\] charArray = input.toCharArray();

\>for (char c: charArray) {

\>\>if (!Character.isWhitespace(c))

\>\>\>output.append(c);

\>}

\>return output.toString();

}

562. **How do you remove leading and trailing spaces from a string in
     Java?**

The String class contains two methods to remove leading and trailing
whitespaces: trim() and strip(). The strip() method was added to the
String class in Java 11. The strip() method uses the
Character.isWhitespace() method to check if the character is a
whitespace. This method uses Unicode code points, while the trim()
method identifies any character with a codepoint value less than or
equal to U+0020 as a whitespace character.

The strip() method is the recommended way to remove whitespaces because
it uses the Unicode standard. The following example code shows how to
use the strip() method to remove whitespaces:

String s = \" abc def\\t\";

s = s.strip();

System.out.println(s);

Because String is immutable, you have to assign the strip() output to
the string.

563. **How do you sort an array in Java?**

The Arrays utility class has many overloaded sort() methods to sort
primitive and to object arrays. If you are sorting a primitive array in
the natural order, then you can use the Arrays.sort() method, as shown
in the following example:

int\[\] array = {1, 2, 3, -1, -2, 4};

Arrays.sort(array);

System.out.println(Arrays.toString(array));

However, if you want to sort an array of objects, then the object must
implement the Comparable interface. If you want to specify the sorting
criteria, then you can pass the Comparator for the sorting logic. Learn
more about Comparable and Comparator in Java.

564. **How do you create a deadlock scenario programmatically in Java?**

Deadlock is a scenario in a multi-threaded Java environment where two or
more threads are blocked forever. The deadlock situation arises with at
two or more threads. The following example code creates a deadlock
scenario:

public class ThreadDeadlock {

\>public static void main(String\[\] args) throws InterruptedException {

\>\>Object obj1 = new Object();

\>\>Object obj2 = new Object();

\>\>Object obj3 = new Object();

\>\>Thread t1 = new Thread(new SyncThread(obj1, obj2), \"t1\");

\>\>Thread t2 = new Thread(new SyncThread(obj2, obj3), \"t2\");

\>\>Thread t3 = new Thread(new SyncThread(obj3, obj1), \"t3\");

\>\>t1.start();

\>\>Thread.sleep(5000);

\>\>t2.start();

\>\>Thread.sleep(5000);

\>\>t3.start();

\>}

}

class SyncThread implements Runnable {

\>private Object obj1;

\>private Object obj2;

\>public SyncThread(Object o1, Object o2) {

\>\>this.obj1 = o1;

\>\>this.obj2 = o2;

\>}

\>@Override

\>public void run() {

\>\>String name = Thread.currentThread().getName();

\>\>System.out.println(name + \" acquiring lock on \" + obj1);

\>\>synchronized(obj1) {

\>\>\>System.out.println(name + \" acquired lock on \" + obj1);

\>\>\>work();

\>\>\>System.out.println(name + \" acquiring lock on \" + obj2);

\>\>\>synchronized(obj2) {

\>\>\>\>System.out.println(name + \" acquired lock on \" + obj2);

\>\>\>\>work();

\>\>\>}

\>\>\>System.out.println(name + \" released lock on \" + obj2);

\>\>}

\>\>System.out.println(name + \" released lock on \" + obj1);

\>\>System.out.println(name + \" finished execution.\");

\>}

\>private void work() {

\>\>try {

\>\>\>Thread.sleep(30000);

\>\>} catch (InterruptedException e) {

\>\>\>e.printStackTrace();

\>\>}

\>}

}

All three threads will be able to acquire a lock on the first object.
However, they are using shared resources and are started in such a way
that they will keep on waiting indefinitely to acquire the lock on the
second object. You can use the Java thread dump to detect the deadlocks.

565. **How can you find the factorial of an integer in Java?**

The factorial of an integer is calculated by multiplying all the numbers
from 1 to the given number:

F(n) = F(1)\*F(2)\...F(n-1)\*F(n)

The following example code shows how to use recursion to find the
factorial of an integer:

public static long factorial(long n) {

\>if (n == 1)

\>\>return 1;

\>else

\>\>return (n \* factorial(n - 1));

}

566. **How do you reverse a linked list in Java?**

LinkedList descendingIterator() returns an iterator that iterates over
the element in reverse order. The following example code shows how to
use this iterator to create a new Linked List with elements listed in
the reverse order:

LinkedList \< Integer \> ll = new LinkedList \< \> ();

ll.add(1);

ll.add(2);

ll.add(3);

System.out.println(ll);

LinkedList \< Integer \> ll1 = new LinkedList \< \> ();

ll.descendingIterator().forEachRemaining(ll1::add);

System.out.println(ll1);

567. **Write a Java program that illustrates merge sort.**

Merge sort is one of the most efficient sorting algorithms. It works on
the principle of "divide and conquer". It is based on the idea of
breaking down a list into several sub-lists until each sub-list consists
of a single element, and then merging those sub-lists in a manner that
results in a sorted list. The following example code shows one way to
use merge sort:

public class MergeSort {

\>public static void main(String\[\] args) {

\>\>int\[\] arr = { 70, 50, 30, 10, 20, 40, 60 };

\>\>int\[\] merged = mergeSort(arr, 0, arr.length - 1);

\>\>for (int val: merged) {

\>\>\>System.out.print(val + \" \");

\>\>}

\>}

\>public static int\[\] mergeTwoSortedArrays(int\[\] one, int\[\] two) {

\>\>int\[\] sorted = new int\[one.length + two.length\];

\>\>int i = 0;

\>\>int j = 0;

\>\>int k = 0;

\>\>while (i \< one.length && j \< two.length) {

\>\>\>if (one\[i\] \< two\[j\]) {

\>\>\>\>sorted\[k\] = one\[i\];

\>\>\>\>k++;

\>\>\>\>i++;

\>\>\>} else {

\>\>\>\>sorted\[k\] = two\[j\];

\>\>\>\>k++;

\>\>\>\>j++;

\>\>\>}

\>\>}

\>\>if (i == one.length) {

\>\>\>while (j \< two.length) {

\>\>\>\>sorted\[k\] = two\[j\];

\>\>\>\>k++;

\>\>\>\>j++;

\>\>\>}

\>\>}

\>\>if (j == two.length) {

\>\>\>while (i \< one.length) {

\>\>\>\>sorted\[k\] = one\[i\];

\>\>\>\>k++;

\>\>\>\>i++;

\>\>\>}

\>\>}

\>\>return sorted;

\>}

\>public static int\[\] mergeSort(int\[\] arr, int lo, int hi) {

\>\>if (lo == hi) {

\>\>\>int\[\] br = new int\[1\];

\>\>\>br\[0\] = arr\[lo\];

\>\>\>return br;

\>\>}

\>\>int mid = (lo + hi) / 2;

\>\>int\[\] fh = mergeSort(arr, lo, mid);

\>\>int\[\] sh = mergeSort(arr, mid + 1, hi);

\>\>int\[\] merged = mergeTwoSortedArrays(fh, sh);

\>\>return merged;

\>}

}

568. **Can you create a pyramid of characters in Java?**

class Pyramid {

\>public static void main(String\[\] args) {

\>\>int size = 10;

\>\>for (int i = 0; i \< size; i++) {

\>\>\>for (int j = 0; j \< size - i; j++) {

\>\>\>\>System.out.print(\" \");

\>\>\>}

\>\>\>for (int j = 0; j \< 2 \* i + 1; j++) {

\>\>\>\>System.out.print(\"#\");

\>\>\>}

\>\>\>System.out.println();

\>\>}

\>}

}

Output:

\>\> \#

\>\> \###

\>\>#####

\> \#######

\> \#########

\> \###########

\>#############

\###############

\#################

\###################

569. **Write Java program that checks if two arrays contain the same
     elements.**

To check if two arrays contain the same elements, you need to first
create a set of elements from both the arrays, and then compare the
elements in these sets to find if there is an element that is not
present in both sets. The following example code shows how to check if
two arrays only contain common elements:

public class ArraySameElements {

\>public static void main(String\[\] args) {

\>\>Integer\[\] a1 = { 1, 2, 3, 2, 1 };

\>\>Integer\[\] a2 = { 1, 2, 3 };

\>\>Integer\[\] a3 = { 1, 2, 3, 4 };

\>\>System.out.println(sameElements(a1, a2));

\>\>System.out.println(sameElements(a1, a3));

\>}

\>static boolean sameElements(Object\[\] array1, Object\[\] array2) {

\>\>Set\<Object\> uniqueElements1 = new
HashSet\<\>(Arrays.asList(array1));

\>\>Set\<Object\> uniqueElements2 = new
HashSet\<\>(Arrays.asList(array2));

\>\>// if size is different, means there will be a mismatch

\>\>if (uniqueElements1.size() != uniqueElements2.size()) return false;

\>\>for (Object obj : uniqueElements1) {

\>\>\>// element not present in both?

\>\>\>if (!uniqueElements2.contains(obj)) return false;

\>\>}

\>\>return true;

\>}

}

Output

true

false

570. **How do you get the sum of all elements in an integer array in
     Java?**

You can use a for loop to iterate over the array elements and add them
to get the final sum:

int\[\] array = { 1, 2, 3, 4, 5 };

int sum = 0;

for (int i : array)

\>sum += i;

System.out.println(sum);

571. **How do you find the second largest number in an array in Java?**

There are many ways to solve this problem. You can sort the array in
natural ascending order and take the second last value. However, sorting
is an expensive operation. You can also use two variables to find the
second largest value in a single iteration, as shown in the following
example:

private static int findSecondHighest(int\[\] array) {

\>int highest = Integer.MIN_VALUE;

\>int secondHighest = Integer.MIN_VALUE;

\>for (int i: array) {

\>\>if (i \> highest) {

\>\>\>secondHighest = highest;

\>\>\>highest = i;

\>\>} else if (i \> secondHighest) {

\>\>\>secondHighest = i;

\>\>}

\>}

\>return secondHighest;

}

572. **How do you shuffle an array in Java?**

The following example code shows how to use the Random class to generate
random index numbers and shuffle the elements:

int\[\] array = { 1, 2, 3, 4, 5, 6, 7 };

Random rand = new Random();

for (int i = 0; i \< array.length; i++) {

\>int randomIndexToSwap = rand.nextInt(array.length);

\>int temp = array\[randomIndexToSwap\];

\>array\[randomIndexToSwap\] = array\[i\];

\>array\[i\] = temp;

}

System.out.println(Arrays.toString(array));

You can run the shuffling code inside another for loop to shuffle
multiple rounds.

573. **How can you find a string in a text file in Java?**

The following example code shows how to use the Scanner class to read
the file contents line by line and then use the String contains() method
to check if the string is present in the file:

boolean findStringInFile(String filePath, String str) throws
FileNotFoundException {

\>File file = new File(filePath);

\>Scanner scanner = new Scanner(file);

\>// read the file line by line

\>while (scanner.hasNextLine()) {

\>\>String line = scanner.nextLine();

\>\>if (line.contains(str)) {

\>\>\>scanner.close();

\>\>\>return true;

\>\>}

\>}

\>scanner.close();

\>return false;

}

Note that the example code assumes that the string that you're searching
for in the file doesn't contain newline characters.

574. **How do you print a date in specific format in Java?**

The following example code shows how to use the SimpleDateFormat class
to format the date string:

String pattern = \"MM-dd-yyyy\";

SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

String date = simpleDateFormat.format(new Date());

System.out.println(date); // 06-23-2020

575. **How do you merge two lists in Java?**

The following example code shows how to use the addAll() method to merge
multiple lists in Java:

List\<String\> list1 = new ArrayList\<\>();

list1.add(\"1\");

List\<String\> list2 = new ArrayList\<\>();

list2.add(\"2\");

List\<String\> mergedList = new ArrayList\<\>(list1);

mergedList.addAll(list2);

System.out.println(mergedList); // \[1, 2\]

576. **Write a Java program that sorts HashMap by value.**

HashMap is not an ordered collection. The following example code shows
how to sort the entries based on value and store them into
LinkedHashMap, which maintains the order of insertion:

public class SortHashMapByValue {

\>public static void main(String\[\] args) {

\>\>Map \< String, Integer \> scores = new HashMap \< \> ();

\>\>scores.put(\"David\", 95);

\>\>scores.put(\"Jane\", 80);

\>\>scores.put(\"Mary\", 97);

\>\>scores.put(\"Lisa\", 78);

\>\>scores.put(\"Dino\", 65);

\>\>System.out.println(scores);

\>\>scores = sortByValue(scores);

\>\>System.out.println(scores);

\>}

\>private static Map \< String, Integer \> sortByValue(Map \< String,
Integer \> scores) {

\>\>Map \< String, Integer \> sortedByValue = new LinkedHashMap \< \>
();

\>\>// get the entry set

\>\>Set \< Entry \< String, Integer \>\> entrySet = scores.entrySet();

\>\>System.out.println(entrySet);

\>\>// create a list since the set is unordered

\>\>List \< Entry \< String, Integer \>\> entryList = new ArrayList \<
\> (entrySet);

\>\>System.out.println(entryList);

\>\>// sort the list by value

\>\>entryList.sort((x, y) - \> x.getValue().compareTo(y.getValue()));

\>\>System.out.println(entryList);

\>\>// populate the new hash map

\>\>for (Entry \< String, Integer \> e: entryList)

\>\>\>sortedByValue.put(e.getKey(), e.getValue());

\>\>return sortedByValue;

\>}

}

577. **How do you remove all occurrences of a given character from an
     input string in Java?**

The String class doesn't have a method to remove characters. The
following example code shows how to use the replace() method to create a
new string without the given character:

String str1 = \"abcdABCDabcdABCD\";

str1 = str1.replace(\"a\", \"\");

System.out.println(str1); // bcdABCDbcdABCD

String is immutable in Java. All the string manipulation methods return
a new string, which is why you need to assign it to another variable.

578. **How do you get distinct characters and their count in a string in
     Java?**

You can create the character array from the string. Then iterate over it
and create a HashMap with the character as key and their count as value.
The following example code shows how to extract and count the characters
of a string:

String str1 = \"abcdABCDabcd\";

char\[\] chars = str1.toCharArray();

Map \< Character, Integer \> charsCount = new HashMap \< \> ();

for (char c: chars) {

\>if (charsCount.containsKey(c)) {

\>\>charsCount.put(c, charsCount.get(c) + 1);

\>} else

\>\>charsCount.put(c, 1);

}

System.out.println(charsCount); // {a=2, A=1, b=2, B=1, c=2, C=1, d=2,
D=1}

579. **Can you prove that a String object in Java is immutable
     programmatically?**

The following example code shows how to prove that a String object is
immutable and the comments in the code explain each step:

String s1 = \"Java\"; // \"Java\" String created in pool and reference
assigned to s1

String s2 = s1; //s2 also has the same reference to \"Java\" in the pool

System.out.println(s1 == s2); // proof that s1 and s2 have the same
reference

s1 = \"Python\";

//s1 value got changed above, so how String is immutable?

//in the above case a new String \"Python\" got created in the pool

//s1 is now referring to the new String in the pool

//BUT, the original String \"Java\" is still unchanged and remains in
the pool

//s2 is still referring to the original String \"Java\" in the pool

// proof that s1 and s2 have different reference

System.out.println(s1 == s2);

System.out.println(s2);

// prints \"Java\" supporting the fact that original String value is
unchanged, hence String is immutable

580. **Can you write some code to showcase inheritance in Java?**

The following example code shows how to use the extends keyword to
create a subclass of the class Animal. The new class Cat inherits the
variable from the Animal class and adds more code that only belongs to
the Cat class.

class Animal {

\>String color;

}

class Cat extends Animal {

\>void meow() {

\>\>System.out.println(\"Meow\");

\>}

}

581. **How do you show a diamond problem with multiple inheritance in
     Java?**

The diamond problem occurs when a class inherits from multiple classes
and ambiguity occurs when it's unclear which method to execute from
which class. Java doesn't allow extending multiple classes to avoid the
diamond problem illustrated by the following example:

interface I {

\>void foo();

}

class A implements I {

\>public void foo() {}

}

class B implements I {

\>public void foo() {}

}

class C extends A, B { // won\'t compile

\>public void bar() {

\>\>super.foo();

\>}

}

582. **How do you illustrate a try catch example in Java?**

The following example code shows an example of try-catch:

try {

\>FileInputStream fis = new FileInputStream(\"test.txt\");

} catch (FileNotFoundException e) {

\>e.printStackTrace();

}

From Java 7 onwards, you can also catch multiple exceptions in a single
catch block, as shown in the following example. It's useful when you
have the same code in all the catch blocks.

public static void foo(int x) throws IllegalArgumentException,
NullPointerException {

\>// some code

}

public static void main(String\[\] args) {

\>try {

\>\>foo(10);

\>} catch (IllegalArgumentException \| NullPointerException e) {

\>\>System.out.println(e.getMessage());

\>}

}

583. **Write a Java program to show a NullPointerException.**

If you are calling a function on null, it will throw a
NullPointerException, as shown in the following example code:

public static void main(String\[\] args) {

\>printString(null, 3);

}

static void printString(String s, int count) {

\>for (int i = 0; i \< count; i++) {

\>\>System.out.println(s.toUpperCase()); // Exception in thread \"main\"
java.lang.NullPointerException

\>}

}

You should have null check in place for early validation, as shown in
the following example code:

static void printString(String s, int count) {

\>if (s == null) return;

\>for (int i = 0; i \< count; i++) {

\>\>System.out.println(s.toUpperCase());

\>}

}

You can also throw IllegalArgumentException based on the project
requirements.

584. **How do you create a record in Java?**

Records was added as a standard feature in Java 16. Records enable you
to create a POJO class with minimal code. Records automatically
generates hashCode(), equals(), getter methods, and toString() method
code for the class. Records are final and implicitly extend the
java.lang.Record class. The following example code shows one way to
cerate a record:

public record EmpRecord(int id, String name, long salary, Map \< String,
String \> addresses) {}

585. **How do you create text blocks in Java?**

Java 15 added the text blocks feature. You can create multiline strings
using text blocks. The multiline string has to be written inside of a
pair of triple-double quotes, as shown in the following example:

String textBlock = \"\"\"

\>\>Hi

\>\>Hello

\>\>Yes\"\"\";

It's the same as creating a string, such as \\nHi\\nHello\\nYes.

586. **Show an example of switch expressions and multi-label case
     statements in Java.**

The switch expressions were added as a standard feature in Java 14. The
following examples show switch expressions as well as multi-label case
statements:

int choice = 2;

int x =

\>switch (choice) {

\>\>case 1, 2, 3:

\>\>\>yield choice;

\>\>default:

\>\>\>yield - 1;

\>};

System.out.println(\"x = \" + x); // x = 2

You can also use lambda expressions in switch expressions.

String day = \"TH\";

String result =

\>switch (day) {

\>\>case \"M\", \"W\", \"F\" - \> \"MWF\";

\>\>case \"T\", \"TH\", \"S\" - \> \"TTS\";

\>\>default - \> {

\>\>\>if (day.isEmpty())

\>\>\>\>yield \"Please insert a valid day.\";

\>\>\>else

\>\>\>\>yield \"Looks like a Sunday.\";

\>\>}

\>};

System.out.println(result); // TTH

587. **How do you compile and run a Java class from the command line?**

This example refers to the following Java file:

public class Test {

public static void main(String args\[\]) {

\>\>System.out.println(\"Hi\");

\>}

}

You can compile it using the following command in your terminal:

javac Test.java

To run the class, use the following command in your terminal:

java Test

For the recent releases, the java command will also compile the program
if the class file is not present. If the class is in a package, such as
com.example, then it should be inside the folder com/example. The
command to compile and run is:

java com/example/Test.java

If your class requires some additional JARs to compile and run, you can
use the java -cp option. For example:

java -cp .:\~/.m2/repository/log4j/log4j/1.2.17/log4j-1.2.17.jar
com/example/Test.java

588. **How do you create an enum in Java?**

The following example code shows how to create a basic enum:

public enum ThreadStates {

\>START,

\>RUNNING,

\>WAITING,

\>DEAD;

}

ThreadStates is the enum with fixed constants fields START, RUNNING,
WAITING, and DEAD. All enums implicitly extend the java.lang.Enum class
and implement the Serializable and Comparable interfaces. Enum can have
methods also.

589. **How do you use the forEach() method in Java?**

The forEach() method provides a shortcut to perform an action on all the
elements of an iterable. The following example code shows how to iterate
over the list elements and print them:

List\<String\> list = new ArrayList\<\>();

Iterator\<String\> it = list.iterator();

while (it.hasNext()) {

\>System.out.println(it.next());

}

You can use the forEach() method with a lambda expression to reduce the
code size, as shown in the following example code:

List\<String\> list = new ArrayList\<\>();

list.forEach(System.out::print);

590. **How do you write an interface with default and static method?**

Java 8 introduced default and static methods in interfaces. This bridged
the gap between interfaces and abstract classes. The following example
code shows one way to write an interface with the default and static
method:

public interface Interface1 {

\>// regular abstract method

\>void method1(String str);

\>default void log(String str) {

\>\>System.out.println(\"I1 logging::\" + str);

\>}

\>static boolean isNull(String str) {

\>\>System.out.println(\"Interface Null Check\");

\>\>return str == null ? true : \"\".equals(str) ? true : false;

\>}

}

591. **How do you create a functional interface?**

An interface with exactly one abstract method is called a functional
interface. The major benefit of functional interfaces is that you can
use lambda expressions to instantiate them and avoid using bulky
anonymous class implementation. The \@FunctionalInterface annotation
indicates a functional interface, as shown in the following example
code:

\@FunctionalInterface

interface Foo {

\>void test();

}

592. **Show an example of using lambda expressions in Java.**

Runnable is an excellent example of a functional interface. You can use
lambda expressions to create a runnable, as shown in the following
example code:

Runnable r1 = () -\> System.out.println(\"My Runnable\");

593. **Guess the Output**

Test yourself by guessing the output of the following code snippets.

-   String s1 = \"abc\";

> String s2 = \"abc\";
>
> System.out.println(\"s1 == s2 is:\" + s1 == s2);
>
> Output
>
> false
>
> The output of the given statement is false because the + operator has
> a higher precedence than the == operator. So the given expression is
> evaluated to "s1 == s2 is:abc" == "abc", which is false.

-   String s3 = \"JournalDev\";

> int start = 1;
>
> char end = 5;
>
> System.out.println(s3.substring(start, end));
>
> Output
>
> ourn
>
> The output of the given statement is ourn. The first character is
> automatically type cast to int. Then, since the first character index
> is 0, it will start from o and print until n. Note that the String
> substring method creates a substring that begins at index start and
> extends to the character at index end - 1.

-   HashSet shortSet = new HashSet();

> for (short i = 0; i \< 100; i++) {
>
> \>shortSet.add(i);
>
> \>shortSet.remove(i - 1);
>
> }
>
> System.out.println(shortSet.size());
>
> Output
>
> 100
>
> The size of the shortSet is 100. The autoboxing feature in Java means
> that the expression i, which has the primitive type short, converts to
> a Short object. Similarly, the expression i - 1 has the primitive type
> int and is autoboxed to an Integer object. Since there is no Integer
> object in the HashSet, nothing is removed and the size is 100.

-   try {

> \>if (flag) {
>
> \>\>while (true) {}
>
> \>} else {
>
> \>\>System.exit(1);
>
> \>}
>
> } finally {
>
> \>System.out.println(\"In Finally\");
>
> }
>
> Output
>
> No output. This code results in an infinite loop if the flag is true
> and the program exists if the flag is false. The finally block will
> never be reached.

-   String str = null;

> String str1=\"abc\";
>
> System.out.println(str1.equals(\"abc\") \|\| str.equals(null));
>
> Output
>
> Exception in thread \"main\" java.lang.NullPointerException: Cannot
> invoke \"String.equals(Object)\" because \"\<local1\>\" is null
>
> The given print statement will throw a java.lang.NullPointerException
> because the OR logical operator evaluates both the literals before
> returning the result. Since str is null, the .equals() method will
> throw an exception. Its always advisable to use short-circuit logical
> operators, such as \|\| and &&, which evaluate the literal values from
> left to right. In this case, since the first literal would return
> true, it would skip the second literal evaluation.

-   String x = \"abc\";

> String y = \"abc\";
>
> x.concat(y);
>
> System.out.print(x);
>
> Output
>
> abc
>
> The x.concat(y) creates a new string but is not assigned to x, so the
> value of x is not changed.

-   public class MathTest {

> \>public void main(String\[\] args) {
>
> \>\>int x = 10 \* 10 - 10;
>
> \>\>System.out.println(x);
>
> \>}
>
> }
>
> Output
>
> Error: Main method is not static in class MathTest, please define the
> main method as:
>
> public static void main(String\[\] args)
>
> While it might seem like this question is about the order of execution
> of the mathematical operators, the question is really about noticing
> that the main method wasn't declared static.

-   public class Test {

> \>public static void main(String\[\] args) {
>
> \>\>try {
>
> \>\>\>throw new IOException(\"Hello\");
>
> \>\>} catch (IOException \| Exception e) {
>
> \>\>\>System.out.println(e.getMessage());
>
> \>\>}
>
> \>}
>
> }
>
> Output
>
> Test.java:5: error: cannot find symbol
>
> \>\>\>throw new IOException(\"Hello\");
>
> \>\>\>\>\> \^
>
> symbol: class IOException
>
> location: class Test
>
> Test.java:6: error: cannot find symbol
>
> \>\>}catch(IOException \| Exception e) {
>
> \>\>\> \^
>
> symbol: class IOException
>
> location: class Test
>
> 2 errors
>
> This code results in a compile time error. The exception IOException
> is already caught by the alternative Exception.

594. **Find 5 mistakes in the following code snippet.**

package com.digitalocean.programming-interviews;

public class String Programs {

\>static void main(String\[10\] args) {

\>\>String s = \"abc\"

\>\>System.out.println(s);

\>}

}

Answers

-   The package name can't have hyphens.

-   The class name can't have spaces.

-   The main method is not public, so it won't run.

-   The main method argument shouldn't specify the size.

-   The semicolon is missing in the string definition.

<https://javarevisited.blogspot.com/2015/10/133-java-interview-questions-answers-from-last-5-years.html>

595. **Can we make array volatile in Java?**

This is one of the tricky Java multi-threading questions you will see in
senior Java developer Interview. Yes, you can make an array volatile in
Java but only the reference which is pointing to an array, not the whole
array. What I mean, if one thread changes the reference variable to
points to another array, that will provide a volatile guarantee, but if
multiple threads are changing individual array elements they won\'t be
having happens before guarantee provided by the volatile modifier.

596. **Can volatile make a non-atomic operation to atomic?**

This another good question I love to ask on volatile, mostly as a
follow-up of the previous question. This question is also not easy to
answer because volatile is not about atomicity, but there are cases
where you can use a volatile variable to make the operation atomic.

One example I have seen is having a long field in your class. If you
know that a long field is accessed by more than one thread e.g. a
counter, a price field or anything, you better make it volatile. Why?
because reading to a long variable is not atomic in Java and done in two
steps, If one thread is writing or updating long value, it\'s possible
for another thread to see half value (fist 32-bit). While
reading/writing a volatile long or double (64 bit) is atomic.

597. **What are practical uses of volatile modifier?**

One of the practical use of the volatile variable is to make reading
double and long atomic. Both double and long are 64-bit wide and they
are read in two parts, first 32-bit first time and next 32-bit second
time, which is non-atomic but volatile double and long read is atomic in
Java.

Another use of the volatile variable is to provide a memory barrier,
just like it is used in Disruptor framework. Basically, Java Memory
model inserts a write barrier after you write to a volatile variable and
a read barrier before you read it.

Which means, if you write to volatile field then it\'s guaranteed that
any thread accessing that variable will see the value you wrote and
anything you did before doing that right into the thread is guaranteed
to have happened and any updated data values will also be visible to all
threads, because the memory barrier flushed all other writes to the
cache.

598. **What guarantee volatile variable provides?**

Volatile variables provide the guarantee about ordering and visibility
e.g. volatile assignment cannot be re-ordered with other statements but
in the absence of any synchronization instruction compiler, JVM or JIT
are free to reorder statements for better performance. volatile also
provides the happens-before guarantee which ensures changes made in one
thread is visible to others.

In some cases volatile also provide atomicity e.g. reading 64-bit data
types like long and double are not atomic but read of volatile double or
long is atomic.

599. **Which one would be easy to write? synchronization code for 10
     threads or 2 threads?**

In terms of writing code, both will be of same complexity because
synchronization code is independent of a number of threads. Choice of
synchronization though depends upon a number of threads because the
number of thread present more contention, so you go for advanced
synchronization technique e.g. lock stripping, which requires more
complex code and expertise.

600. **How do you call wait() method? using if block or loop? Why?**

wait() method should always be called in loop because it\'s possible
that until thread gets CPU to start running again the condition might
not hold, so it\'s always better to check condition in loop before
proceeding. Here is the standard idiom of using wait and notify method
in Java:

// The standard idiom for using the wait method

synchronized (obj) {

while (condition does not hold)

\> obj.wait(); // (Releases lock, and reacquires on wakeup)

\> \... // Perform action appropriate to condition

}

601. **What is false sharing in the context of multi-threading?**

false sharing is one of the well-known performance issues on multi-core
systems, where each process has its local cache. false sharing occurs
when threads on different processor modify variables that reside on same
cache line as shown in the following image:

![](image128.png){width="4.166666666666667in"
height="3.7604166666666665in"}

False sharing is very hard to detect because the thread may be accessing
completely different global variables that happen to be relatively close
together in memory. Like many concurrency issues, the primary way to
avoid false sharing is careful code review and aligning your data
structure with the size of a cache line.

602. **What is busy spin? Why should you use it?**

Busy spin is one of the technique to wait for events without releasing
CPU. It\'s often done to avoid losing data in CPU cached which is lost
if the thread is paused and resumed in some other core. So, if you are
working on low latency system where your order processing thread
currently doesn\'t have any order, instead of sleeping or calling
wait(), you can just loop and then again check the queue for new
messages.

It\'s only beneficial if you need to wait for a very small amount of
time e.g. in microseconds or nanoseconds. LMAX Disrupter framework, a
high-performance inter-thread messaging library has a
BusySpinWaitStrategy which is based on this concept and uses a busy spin
loop for EventProcessors waiting on the barrier.

603. **How do you take thread dump in Java?**

You can take a thread dump of Java application in Linux by using kill -3
PID, where PID is the process id of Java process. In Windows, you can
press Ctrl + Break. This will instruct JVM to print thread dump in
standard out or err and it could go to console or log file depending
upon your application configuration.

604. **Is Swing thread-safe?**

No, Swing is not thread-safe. You cannot update Swing components e.g.
JTable, JList or JPanel from any thread, in fact, they must be updated
from GUI or AWT thread. That\'s why swings provide invokeAndWait() and
invokeLater() method to request GUI update from any other threads.

This methods put update request in AWT threads queue and can wait till
update or return immediately for an asynchronous update.

605. **What is a thread local variable in Java?**

Thread-local variables are variables confined to a thread, its like
thread\'s own copy which is not shared between multiple threads. Java
provides a ThreadLocal class to support thread-local variables. It\'s
one of the many ways to achieve thread-safety.

Though be careful while using thread local variable in managed
environment e.g. with web servers where worker thread out lives any
application variable. Any thread local variable which is not removed
once its work is done can potentially cause a memory leak in Java
application.

606. **Write wait-notify code for producer-consumer problem?**

![How to solve Producer Consumer Problem with Wait and Notify - Thread
Example](image129.png){width="4.166666666666667in"
height="2.5972222222222223in"}

/\*\*

\* Java program to solve Producer Consumer problem using wait and notify

\* method in Java. Producer Consumer is also a popular concurrency
design pattern.

\*

\* \@author Javin Paul

\*/

public class ProducerConsumerSolution {

\>public static void main(String args\[\]) {

\>\>Vector sharedQueue = new Vector();

\>\>int size = 4;

\>\>Thread prodThread = new Thread(new Producer(sharedQueue, size),
\"Producer\");

\>\>Thread consThread = new Thread(new Consumer(sharedQueue, size),
\"Consumer\");

\>\>prodThread.start();

\>\>consThread.start();

\>}

}

class Producer implements Runnable {

\>private final Vector sharedQueue;

\>private final int SIZE;

\>public Producer(Vector sharedQueue, int size) {

\>\>this.sharedQueue = sharedQueue;

\>\>this.SIZE = size;

\>}

\>@Override

\>public void run() {

\>\>for (int i = 0; i \< 7; i++) {

\>\>\>System.out.println(\"Produced: \" + i);

\>\>\>try {

\>\>\>\>produce(i);

\>\>\>} catch (InterruptedException ex) {

\>\>\>\>Logger.getLogger(Producer.class.getName()).log(Level.SEVERE,
null, ex);

\>\>\>}

\>\>}

\>}

\>private void produce(int i) throws InterruptedException {

\>\>//wait if the queue is full

\>\>while (sharedQueue.size() == SIZE) {

\>\>\>synchronized(sharedQueue) {

\>\>\>\>System.out.println(\"The queue is full \" +
Thread.currentThread().getName() +

\>\>\>\>\>\" is waiting , size: \" + sharedQueue.size());

\>\>\>\>sharedQueue.wait();

\>\>\>}

\>\>}

\>\>//producing element and notify consumers

\>\>synchronized(sharedQueue) {

\>\>\>sharedQueue.add(i);

\>\>\>sharedQueue.notifyAll();

\>\>}

\>}

}

class Consumer implements Runnable {

\>private final Vector sharedQueue;

\>private final int SIZE;

\>public Consumer(Vector sharedQueue, int size) {

\>\>this.sharedQueue = sharedQueue;

\>\>this.SIZE = size;

\>}

\>@Override

\>public void run() {

\>\>while (true) {

\>\>\>try {

\>\>\>\>System.out.println(\"Consumed: \" + consume());

\>\>\>\>Thread.sleep(50);

\>\>\>} catch (InterruptedException ex) {

\>\>\>\>Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE,
null, ex);

\>\>\>}

\>\>}

\>}

\>private int consume() throws InterruptedException {

\>\>//wait if the queue is empty

\>\>while (sharedQueue.isEmpty()) {

\>\>\>synchronized(sharedQueue) {

\>\>\>\>System.out.println(\"The queue is empty \" +
Thread.currentThread().getName() +

\>\>\>\>\>\" is waiting , size: \" + sharedQueue.size());

\>\>\>\>sharedQueue.wait();

\>\>\>}

\>\>}

\>\>//Otherwise consume element and notify the waiting producer

\>\>synchronized(sharedQueue) {

\>\>\>sharedQueue.notifyAll();

\>\>\>return (Integer) sharedQueue.remove(0);

\>\>}

\>}

}

Output:

Produced: 0

The queue is empty Consumer is waiting, size: 0

Produced: 1

Consumed: 0

Produced: 2

Produced: 3

Produced: 4

Produced: 5

The queue is full Producer is waiting, size: 4

Consumed: 1

Produced: 6

The queue is full Producer is waiting, size: 4

Consumed: 2

Consumed: 3

Consumed: 4

Consumed: 5

Consumed: 6

The queue is empty Consumer is waiting, size: 0

607. **Write code for thread-safe Singleton in Java?**

Using enum:

public enum Singleton{

\>INSTANCE;

\>public void show(){

\>\>System.out.println(\"Singleton using Enum in Java\");

\>}

}

//You can access this Singleton as Singleton.INSTANCE and call any
method like below

Singleton.INSTANCE.show();

Using static field initialization:

public class Singleton{

\>private static final Singleton INSTANCE = new Singleton();

\>private Singleton(){ }

\>public static Singleton getInstance(){

\>\>return INSTANCE;

\>}

\>public void show(){

\>\>System.out.println(\"Singleon using static initialization in
Java\");

\>}

}

//Here is how to access this Singleton class

Singleton.getInstance().show();

608. **The difference between sleep and wait in Java?**

Though both are used to pause currently running thread, sleep() is
actually meant for short pause because it doesn\'t release lock, while
wait() is meant for conditional wait and that\'s why it release lock
which can then be acquired by another thread to change the condition on
which it is waiting.

609. **What is an immutable object? How do you create an Immutable
     object in Java?**

Immutable objects are those whose state cannot be changed once created.
Any modification will result in a new object e.g. String, Integer, and
other wrapper class. Please see the answer for step by step guide to
creating Immutable class in Java.

610. **Can we create an Immutable object, which contains a mutable
     object?**

Yes, its possible to create an Immutable object which may contain a
mutable object, you just need to be a little bit careful not to share
the reference of the mutable component, instead, you should return a
copy of it if you have to. Most common example is an Object which
contain the reference of java.util.Date object.

611. **What is the right data type to represent a price in Java?**

BigDecimal if memory is not a concern and Performance is not critical,
otherwise double with predefined precision.

612. **How do you convert bytes to String?**

You can convert bytes to the string using string constructor which
accepts byte\[\], just make sure that right character encoding otherwise
platform\'s default character encoding will be used which may or may not
be same.

613. **How do you convert bytes to long in Java?**

One method is to convert bytes to string first using the method in the
previous question, then using Long.parseLong() you can convert that
string to a long value. If the primitive type of long is required
instead of the object type, you don't have to deal with that, autoboxing
takes care of it automatically.

614. **Can we cast an int value into byte variable? what will happen if
     the value of int is larger than byte?**

Yes, we can cast but int is 32 bit long in java while byte is 8 bit long
in java so when you cast an int to byte higher 24 bits are lost and a
byte can only hold a value from -128 to 128.

615. **There are two classes B extends A and C extends B, Can we cast B
     into C e.g. C = (C) B?**

No. The reason for that is because C is a derivative of B. If we could
cast B into C then the parts of C "would be missing" from B, for
instance, if we called a method or modified a variable which exists in C
but not in B there would be nothing to call or modify. So as a result,
casting a parent class to a derivative class would result in a
compile-time error.

616. **Which class contains clone method? Cloneable or Object?**

java.lang.Cloneable is marker interface and doesn\'t contain any method
clone method is defined in the object class. It is also knowing that
clone() is a native method means it\'s implemented in C or C++ or any
other native language.

617. **Is ++ operator is thread-safe in Java?**

No it\'s not a thread safe operator because its involve multiple
instructions like reading a value, incriminating it and storing it back
into memory which can be overlapped between multiple threads.

618. **Difference between a = a + b and a += b ?**

The += operator implicitly cast the result of addition into the type of
variable used to hold the result. When you add two integral variable
e.g. variable of type byte, short, or int then they are first promoted
to int and them addition happens. If result of addition is more than
maximum value of a then a + b will give compile time error but a += b
will be ok as shown below

byte a = 127;

byte b = 127;

b = a + b; // error : cannot convert from int to byte

b += a; // ok

619. **Can I store a double value in a long variable without casting?**

No, you cannot store a double value into a long variable without casting
because the range of double is more that long and you we need to type
cast. It\'s not dificult to answer this question but many develoepr get
it wrong due to confusion on which one is bigger between double and long
in Java.

620. **What will this return 3\*0.1 == 0.3? true or false?**

This is one of the really tricky questions. Out of 100, only 5
developers answered this question and only of them have explained the
concept correctly. The short answer is false because some floating point
numbers can not be represented exactly.

621. **Which one will take more memory, an int or Integer?**

An Integer object will take more memory an Integer is the an object and
it store meta data overhead about the object and int is primitive type
so its takes less space.

622. **Can we use String in the switch case?**

Yes from Java 7 onward we can use String in switch case but it is just
syntactic sugar. Internally string hash code is used for the switch.

623. **What is the size of int in 64-bit JVM?**

The size of an int variable is constant in Java, it\'s always 32-bit
irrespective of platform. Which means the size of primitive int is same
in both 32-bit and 64-bit Java virtual machine.

624. **A difference between WeakReference and SoftReference in Java?**

Though both WeakReference and SoftReference helps garbage collector and
memory efficient, WeakReference becomes eligible for garbage collection
as soon as last strong reference is lost but SoftReference even thought
it can not prevent GC, it can delay it until JVM absolutely need memory.

625. **How do WeakHashMap works?**

WeakHashMap works like a normal HashMap but uses WeakReference for keys,
which means if the key object doesn\'t have any reference then both
key/value mapping will become eligible for garbage collection.

626. **What is -XX:+UseCompressedOops JVM option? Why use it?**

When you go migrate your Java application from 32-bit to 64-bit JVM, the
heap requirement suddenly increases, almost double, due to increasing
size of ordinary object pointer from 32 bit to 64 bit. This also
adversely affect how much data you can keep in CPU cache, which is much
smaller than memory. Since main motivation for moving to 64-bit JVM is
to specify large heap size, you can save some memory by using compressed
OOP. By using -XX:+UseCompressedOops, JVM uses 32-bit OOP instead of
64-bit OOP.

627. **How do you find if JVM is 32-bit or 64-bit from Java Program?**

You can find that by checking some system properties like
sun.arch.data.model or os.arch

628. **What is the maximum heap size of 32-bit and 64-bit JVM?**

Theoretically, the maximum heap memory you can assign to a 32-bit JVM is
2\^32 which is 4GB but practically the limit is much smaller. It also
varies between operating systems e.g. form 1.5GB in Windows to almost
3GB in Solaris. 64-bit JVM allows you to specify larger heap size,
theoretically 2\^64 which is quite large but practically you can specify
heap space up to 100GBs. There are even JVM e.g. Azul where heap space
of 1000 gigs is also possible.

629. **Explain Java Heap space and Garbage collection?**

When a Java process is started using java command, memory is allocated
to it. Part of this memory is used to create heap space, which is used
to allocate memory to objects whenever they are created in the program.
Garbage collection is the process inside JVM which reclaims memory from
dead objects for future allocation.

630. **Can you guarantee the garbage collection process?**

No, you cannot guarantee the garbage collection, though you can make a
request using System.gc() or Runtime.gc() method.

631. **How do you find memory usage from Java program? How much percent
     of the heap is used?**

You can use memory related methods from java.lang.Runtime class to get
the free memory, total memory and maximum heap memory in Java. By using
these methods, you can find out how many percents of the heap is used
and how much heap space is remaining. Runtime.freeMemory() return amount
of free memory in bytes, Runtime.totalMemory() returns total memory in
bytes and Runtime.maxMemory() returns maximum memory in bytes.

632. **What is a.hashCode() used for? How is it related to
     a.equals(b)?**

hashCode() method returns an int hash value corresponding to an object.
It\'s used in hash based collection classes e.g Hashtable, HashMap,
LinkedHashMap and so on. It\'s very tightly related to equals() method.
According to Java specification, two objects which are equal to each
other using equals() method must have same hash code.

633. **What is a compile time constant in Java? What is the risk of
     using it?**

public static final variables are also known as a compile time constant,
the public is optional there. They are replaced with actual values at
compile time because compiler know their value up-front and also knows
that it cannot be changed during run-time.

One of the problem with this is that if you happened to use a public
static final variable from some in-house or third party library and
their value changed later than your client will still be using old value
even after you deploy a new version of JARs. To avoid that, make sure
you compile your program when you upgrade dependency JAR files

634. **Difference between poll() and remove() method?**

Both poll() and remove() take out the object from the Queue but if
poll() fails then it returns null but if remove fails it throws
Exception.

635. **The difference between LinkedHashMap and PriorityQueue in Java?**

PriorityQueue guarantees that lowest or highest priority element always
remain at the head of the queue, but LinkedHashMap maintains the order
on which elements are inserted. When you iterate over a PriorityQueue,
iterator doesn\'t guarantee any order but iterator of LinkedHashMap does
guarantee the order on which elements are inserted.

636. **What is a couple of ways that you could sort a collection?**

You can either use the Sorted collection like TreeSet or TreeMap or you
can sort using the ordered collection like a list and using
Collections.sort() method.

637. **How do you print Array in Java?**

You can print an array by using the Arrays.toString() and
Arrays.deepToString() method. Since array doesn\'t implement toString()
by itself, just passing an array to System.out.println() will not print
its contents but Arrays.toString() will print each element.

638. **LinkedList in Java is doubly or singly linked list?**

It\'s a doubly linked list, you can check the code in JDK. In Eclipse,
you can use the shortcut, Ctrl + T to directly open this class in
Editor.

639. **Which kind of tree is used to implement TreeMap in Java?**

A Red Black tree is used to implement TreeMap in Java.

640. **How HashSet works internally in Java?**

HashSet is internally implemented using an HashMap. Since a Map needs
key and value, a default value is used for all keys. Similar to HashMap,
HashSet doesn\'t allow duplicate keys and only one null key, I mean you
can only store one null object in HashSet.

641. **Write code to remove elements from ArrayList while iterating?**

Key here is to check whether candidate uses ArrayList\'s remove() or
Iterator\'s remove(). Here is the sample code which uses right way to
remove elements from ArrayList while looping over and avoids
ConcurrentModificationException.

Here is the Java program to demonstrate one scenario where you get the
ConcurrentModificationException even if just one thread is modifying the
ArrayList. In this example, we are looping over ArrayList using advanced
for loop and removing selected elements, but because we are using
ArrayList\'s remove() method.

/\*\*

\* Java Program to demonstrate how to deal with

\* ConcurrentModificationException.

\* Unlike the name suggests, this error can come even if only

\* one thread is modifying the collection e.g. List.

\* It happens when you modify collection

\* while iterating over it e.g. adding new element or removing elements.

\*

\* If you want to remove elements while traversing list then

\* make sure you use Iterator\'s remove() method or not ArrayList\'s
remove()

\* method() to avoid ConcurrentModificationExcetpion.

\*

\* \@author WINDOWS 8

\*

\*/

public class ConcurrentModExceptionDemo{

\>public static void main(String args\[\]) {

\>\>List\<String\> listOfPhones = new ArrayList\<String\>(Arrays.asList(

\>\>\>\>\"iPhone 6S\", \"iPhone 6\", \"iPhone 5\", \"Samsung Galaxy 4\",

\>\>\>\> \"Lumia Nokia\"));

\>\>System.out.println(\"list of phones: \" + listOfPhones);

\>\>// Iterating and removing objects from list

\>\>// This is wrong way, will throw ConcurrentModificationException

\>\>for(String phone : listOfPhones){

\>\>\>if(phone.startsWith(\"iPhone\")){

\>\>\> // listOfPhones.remove(phone); // will throw exception

\>\>\>}

\>\>}

\>\>// The Right way, iterating elements using Iterator\'s remove()
method

\>\>for(Iterator\<String\> itr = listOfPhones.iterator();

\>\>\>\>\>\>\>\> itr.hasNext();){\>\>\>

\>\>\>String phone = itr.next();\>\>\>

\>\>\>if(phone.startsWith(\"iPhone\")){

\>\>\>\>// listOfPhones.remove(phone); // wrong again

\>\>\>\>itr.remove(); // right call

\>\>\>}

\>\>}

\>\>System.out.println(\"list after removal: \" + listOfPhones);

\>}

}

Output :

list of phones: \[iPhone 6S, iPhone 6, iPhone 5, Samsung Galaxy 4,

Lumia Nokia\]

list after removal: \[Samsung Galaxy 4, Lumia Nokia\]

If you uncomment the commented code in the first loop and second loop,
you will get the following exception:

Exception in thread \"main\" java.util.ConcurrentModificationException

at java.util.ArrayList\$Itr.checkForComodification(Unknown Source)

at java.util.ArrayList\$Itr.next(Unknown Source)

at dto.ReverseArrayInPlace.main(ReverseArrayInPlace.java:28)

because we are using ArrayList\'s remove() method. In the second
example, we have used the remove() method of Iterator and that\'s why we
are successfully able to delete selected elements from the ArrayList
without ConcurrentModificationException.

642. **Can I write my own container class and use it in the for-each
     loop?**

Yes, you can write your own container class. You need to implement the
Iterable interface if you want to loop over advanced for loop in Java,
though. If you implement Collection then you by default get that
property.

643. **What is default size of ArrayList and HashMap in Java?**

As of Java 7 now, default size of ArrayList is 10 and default capacity
of HashMap is 16, it must be power of 2. Here is code snippet from
ArrayList and HashMap class :

// from ArrayList.java JDK 1.7

private static final int DEFAULT_CAPACITY = 10;

//from HashMap.java JDK 7

static final int DEFAULT_INITIAL_CAPACITY = 1 \<\< 4; // aka 16

644. **Is it possible for two unequal objects to have the same
     hashcode?**

Yes, two unequal objects can have same hashcode that\'s why collision
happen in a hashmap.

the equal hashcode contract only says that two equal objects must have
the same hashcode it doesn\'t say anything about the unequal object.

645. **Can two equal object have the different hash code?**

No, thats not possible according to hash code contract.

646. **Can we use random numbers in the hashcode() method?**

No, because hashcode of an object should be always same.

647. **Why you need to override hashcode, when you override equals in
     Java?**

Because equals have code contract mandates to override equals and
hashcode together .since many container class like HashMap or HashSet
depends on hashcode and equals contract.

648. **What best practices you follow while writing multi-threaded code
     in Java?**

Here are couple of best practices which I follow while writing
concurrent code in Java:

-   Always name your thread, this will help in debugging.

-   minimize the scope of synchronization, instead of making whole
    method synchronized, only critical section should be synchronized.

-   prefer volatile over synchronized if you can can.

-   use higher level concurrency utilities instead of wait() and notify
    for inter thread communication e.g. BlockingQueue, CountDownLatch
    and Semaphore.

-   Prefer concurrent collection over synchronized collection in Java.
    They provide better scalability.

649. **Tell me few best practices you apply while using Collections in
     Java?**

Here are couple of best practices I follow while using Collection
classes from Java:

-   Always use the right collection e.g. if you need non-synchronized
    list then use ArrayList and not Vector.

-   Prefer concurrent collection over synchronized collection because
    they are more scalable.

-   Always use interface to a represent and access a collection e.g. use
    List to store ArrayList, Map to store HashMap and so on.

-   Use iterator to loop over collection.

-   Always use generics with collection.

650. **Can you tell us at least 5 best practice you use while using
     threads in Java?**

This is similar to the previous question and you can use the answer
given there. Particularly with thread, you should:

-   name your thread

-   keep your task and thread separate, use Runnable or Callable with
    thread pool executor.

-   use thread pool

-   use volatile to indicate compiler about ordering, visibility, and
    atomicity.

-   avoid thread local variable because incorrect use of ThreadLocal
    class in Java can create a memory leak.

651. **Name 5 IO best practices?**

IO is very important for performance of your Java application. Ideally
you should avoid IO in critical path of your application. Here are
couple of Java IO best practices you can follow:

-   Use buffered IO classes instead of reading individual bytes and
    char.

-   Use classes from NIO and NIO2

-   Always close streams in finally block or use try-with-resource
    statements.

-   use memory mapped file for faster IO.

If a Java candidate doesn\'t know about IO and NIO, especially if he has
at least 2 to 4 years of experience, he needs some reading.

652. **Name 5 JDBC best practices your follow?**

Another good Java best practices for experienced Java developer of 7 to
8 years experience. Why it\'s important? because they are the ones which
set the trend in the code and educate junior developers. There are many
best practices and you can name as per your comfort and convenience.
Here are some of the more common ones:

-   use batch statement for inserting and updating data.

-   use PreparedStatement to avoid SQL exception and better performance.

-   use database connection pool

-   access resultset using column name instead of column indexes.

-   Don\'t generate dynamic SQL by concatenating String with user input.

653. **Name couple of method overloading best practices in Java?**

Here are some best practices you can follow while overloading a method
in Java to avoid confusion with auto-boxing:

-   Don\'t overload method where one accepts int and other accepts
    Integer.

-   Don\'t overload method where number of argument is same and only
    order of argument is different.

-   Use varargs after overloaded methods has more than 5 arguments.

654. **Does SimpleDateFormat is safe to use in the multi-threaded
     program?**

No, unfortunately, DateFormat and all its implementations including
SimpleDateFormat is not thread-safe, hence should not be used in the
multi-threaded program until external thread-safety measures are applied
e.g. confining SimpleDateFormat object into a ThreadLocal variable.

If you don\'t do that, you will get an incorrect result while parsing or
formatting dates in Java. Though, for all practical date time purpose, I
highly recommend joda-time library.

655. **How do you format a date in Java? e.g. in the ddMMyyyy format?**

You can either use SimpleDateFormat class or joda-time library to format
date in Java. DateFormat class allows you to format date on many popular
formats. Please see the answer for code samples to format date into
different formats e.g. dd-MM-yyyy or ddMMyyyy
