# Stronghold
This is Crimson Robotics Team 2526's Official FIRST Stronghold robot code.

## Basic Gradle commands

Gradle is a tool that handles dependencies (libraries) and provides other functionality on your local workspace.  You don't need to manually download anything at all to build and run this project (including Gradle) - it is all handled by Gradle.

On Windows, use `gradlew` command (batch file), on Mac or Linux use `./gradlew` command (shell script).  You can combine tasks, like `gradlew clean build` and they will run in order.

 * `gradlew tasks` lists all the things that you can do with the `gradlew` command.
 * `gradlew eclipse` will generate all the necessary files for Eclipse.  You can then import it into Eclipse as "existing project" and have everything work out of the box.
 * `gradlew build` will build your Robot Code
 * `gradlew deploy` will build and deploy your code to the RoboRIO
 
 See https://github.com/Open-RIO/GradleRIO for more details on RoboRIO tasks.