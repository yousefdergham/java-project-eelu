# Booking System Documentation

## Overview

This document provides instructions on how to set up and run the Booking System project. This JavaFX application allows users to manage bookings with a simple GUI and stores the data in a SQLite database.

## Prerequisites

To run this project, you will need:

- Java JDK 11 or later
- Maven 3.6.0 or later

## Installation

### Windows

1. **Install Java JDK:**

   - Download the JDK from [Oracle's website](https://www.oracle.com/java/technologies/javase-downloads.html).
   - Run the installer and follow the instructions.
   - Set the JAVA_HOME environment variable and update the PATH variable.

2. **Install Maven:**
   - Download Maven from [Apache Maven Project](https://maven.apache.org/download.cgi).
   - Extract the archive to a directory, e.g., `C:\apache-maven`.
   - Set the M2_HOME and MAVEN_HOME environment variables to point to the Maven folder.
   - Update the PATH variable to include the Maven `bin` directory.

### Linux

1. **Install Java JDK:**

   - Use a package manager to install Java. For example, on Ubuntu:
     ```
     sudo apt update
     sudo apt install openjdk-11-jdk
     ```
   - Set JAVA_HOME in your shell configuration file (e.g., `.bashrc`):
     ```
     export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
     export PATH=$PATH:$JAVA_HOME/bin
     ```

2. **Install Maven:**
   - Use a package manager to install Maven. For example, on Ubuntu:
     ```
     sudo apt update
     sudo apt install maven
     ```

## Configuration

No additional configuration is needed to run the project as all dependencies are managed by Maven.

## Running the Project

To run the project, follow these steps:

1. **Clone the repository or download the source code:**

   ```
   cd [project-directory]
   ```

2. **Build the project:**

   ```
   mvn clean install
   ```

3. **Run the application:**
   ```
   mvn javafx:run
   ```

## Testing

To run the tests included in the project:

```
mvn test
```
