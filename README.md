# Word chain with Gemini CLI
This is my first complete Java project for the final assignment of Object Oriented Programming (PRO192), FPT University

This project is a 1vs1 word-connecting game between you and AI (Gemini) or with the available dictionary, integrated with a system to save points after each software startup/shutdown

## Author
Nguyen Hoai An - nghoaian161@gmail.com

## Usage
You need to setup the *server* folder on hosting or localhost to run with PHP

Change the Gemini API key at *server/server.php* (line 41) variable *$geminiKey*

Change the server address at *src/main/Server.java* (line 16) variable *serverURL*

Then build the .jar (the command that runs after depends on the project name, it doesn't have to be release.jar and is usually in the *dist* folder for NetBeans)

### Dependencies
- PHP 7.x.x - 8.x.x (recommended 8.0.3)
- Java (TM) SE Runtime Environment (build 1.8.0)

### Executing program
```bash
java -jar release.jar
```