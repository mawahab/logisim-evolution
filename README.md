logisim-evolution with fsm library
=================
This repository is a fork from the official logisim-evolution repository (see official repository for more information) and host an early version of the tool with support for editing/analyzing and simulating Finite State Machines. 

## How to install this version of logisim-evolution
You can find an already compiled **stable** version of the code [here](http://www.irisa.fr/cosi/HOMEPAGE/Derrien/logisim/logisim-evolution.jar). [updated on may 22nd, 2017]

To execute it, click on the downloaded file or type in a console
```bash
java -jar logisim-evolution.jar
```

You can also compile it by yourself by cloning the repository on your local machine. Once this is done, enter the directory and execute
```bash
ant run
```
This also creates locally a .jar file, which needs to be fixed due to some library issue. To do so you must run the following command in the project folder containing the jar file.
```
zip -d logisim-evolution.jar 'META-INF/*.SF' 'META-INF/*.RSA' 'META-INF/*SF'
```

This jar can be distributed and used on other machines.

## Use the FSM editor

* The tool menu contains an entry named FSM Tools, with the Finite State Machine component available for instanciation in the design.

* The default instanciation corresponds to an example FSM with two states S0,S1, one input A, and one output X. The FSM transition diagram can be viewed and modified within a graphical editor which is opened by clicking on the Content attribute.

<img src="doc/en/html/guide/fsm/Screenshot.jpg" width="50%" height="50%" />    

The editor is in beta stage, it supports adding/editing/moving/copying/deleting elements through a context menu (use right click to make it appear). Elements can be selected (left click) and moved to make the diagram more readable.

* Commands (outputs) value are specified using boolean expressions involving constants ("0","1"), inputs, and boolean operators (+=OR,.=AND,/=NOT,"1"= true,"0=false). The expression is analyzed for correctness  by the editor.

* Transition predicates are also specified using boolean expression, which involves only input and boolean operators (i.e constants "0" and "1" are not allowed). In addition, it is also possible to use a "default" predicate which is evaluated to true when all other transition predicates for a given state are evaluated to false.  

In addition to syntactic analysis, the editor also checks that transitions from a given state have all their predicates mutually exclusive to guarantee the the fSM is deterministic. This is achieved using the jdd library, which we use to perform a simple boolean SAT check.


## Missing/untested features

* The current version also support VHDL generation although the correctness of generated VHDL was not fully tested yet.

* The editor does not fully supports input/outputs with wordlength greater than one, especially for SAT checks

* [FIXED] <del>Checker does not verify that all states have different binary codes, not that code size (in # bits) is consistent with the number of state on the FSM<del>.
 

## Editing logisim-evolution in Eclipse
To import directly logisim-evolution in Eclipse, you can use Eclipse's import wizard:

*Import -> git project -> [put the connection details] -> New project -> Java project from Ant*

You will, however, encounter a problem when you will try to execute the code. In particular, an exception *ExceptionInInitializerError* will be thrown. To solve this, execute the *eclipse_fix.sh* script in the program's directory, or go in the *bin/* subdirectory and create links to the following directories available in the program's directory
* *boards_model*
* *javax*
* *libs*
* *resources*
* *doc*

