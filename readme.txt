TeamBlue

First project for MacEwan Universities introduction to AI course, CMPT 355 Fall 2016. 

You are given:  
 - a set of n^2 + 1 large disks stamped with 1, 2 , 3 , or 4.  
 - a set of n^2 smaller disks, of which n are stamped with 1, n are stamped with 2, n are stamped with 3, and
finally n are stamped with n.

You have won the game when all of the same small disks stamped with 1 are next to each other, followed by all
small disks stamp with 2, and so on, and finally followed by an uncovered large disk. Remember they are placed
in a circle.

The program can be compiled using the Makefile. Simply running the command make will compile the program into a binary called ABPuzzle. 

The program can also be run from the Makefile. This is done by using the command "make run arg=x" where x is the number of disks you wish to play with (n^2 + 1). This was added to the makefile to hide the flags used to restrict the memory used at runime. If memory use is not a concern, you can run the program as "java ABPuzzle x" where x is once again the number of disks used in the game (n^2 + 1).

The Makefile also has a clean operation, where it removes all files ending in ".class" in the current directory. Please use with caution if there are other .class files in the directory you have compiled in. 
