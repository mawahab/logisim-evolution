logisim-evolution with fsm library

=================
This repository is a fork from the official logisim-evolution repository (see official repository for more information) and host an early version of the tool with support for editing/analyzing and simulating Finite State Machines plus several other minor features listed below :

- Support for DE0-CV board from Terasic
- Keypad IO device (currently only for simulation)
- Dual ported register file component

## How to install this version of logisim-evolution
You can find the latest version of the tool [here](http://www.irisa.fr/cosi/HOMEPAGE/Derrien/logisim/logisim-evolution.jar). [updated on may 31st, 2017]

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

# The logisim FSM editor

* The tool menu contains an entry named FSM Tools, with the Finite State Machine component available as a building block.

* By default, the menu instanciates a 4-state example FSM which demonstrates most of the features available in the tool. The FSM transition diagram can be viewed and modified within a graphical editor which is opened by clicking on the Content attribute.

<img src="doc/en/html/guide/fsm/Screenshot.jpg" width="50%" height="50%" />    

The editor is in advanced beta stage, it supports adding/editing/moving/copying/deleting elements through a context menu (use right click to make it appear). Elements can be selected (left click) and moved to make the diagram more readable.

* Commands (outputs) value are specified using boolean expressions involving bitvector constants ("0101","1"), inputs (with range selection aka A[2:0]), boolean operators (+=OR,.=AND,/=NOT,"1"= true,"0=false ), comparison (==,/=) and concatenation ({A,"0"}). The expression is analyzed for correctness  by the editor.

* Transition predicates are also specified using boolean expressions, which must evaluate as a single bit vector. In addition, it is also possible to use a "default" predicate which is evaluated to true when all other transition predicates for a given state are evaluated to false.  

In addition to syntactic analysis, the editor also checks that transitions from a given state have all their predicates mutually exclusive to guarantee the the fSM is deterministic. This is achieved using the jdd library, which we use to perform a simple boolean SAT check.


## Missing/untested features

* [FIXED] <del>The current version also support VHDL generation although the correctness of generated VHDL was not fully tested yet<del>.

* [MOSTLY FIXED] <del>The editor does not fully supports input/outputs with wordlength greater than one, especially for SAT checks<del>

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

