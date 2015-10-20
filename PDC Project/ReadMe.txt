------------------------------------------------------------------------------
README
------------------------------------------------------------------------------

TABLE OF CONTENTS
*************************
1. How to compile and run the program
2. Dependencies
3. Tests

------------------------------------------------------------------------------
1. How to compile run the program

In order to run the program, you need to open up the project in netbeans.
Make sure you go to 'Services', expand 'Databases', right click 'Java DB' and
select 'Start Server'.

After this, go to 'Projects', select the project and press 'Run Project' (F6).

The game should now be running.
------------------------------------------------------------------------------
2. Dependencies

In order to compile, the following libraries need to be imported:
- JDK 1.8
- derbyclient.jar
- derby.jar

To test the program, you will also need to have JUnit 4 installed.
------------------------------------------------------------------------------
3. Tests

As mentioned above, you need JUnit 4 installed in order to run the tests.

The test classes are:

- PlayerTest
- ItemTest
- EnemyTest
- ChallengeTest
- ChallengeFactoryTest