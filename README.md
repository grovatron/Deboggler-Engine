# Deboggler Engine
A library for constructing customizable solutions to Boggle grids.
## Getting Started
### Prerequisites
- [JDK 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
- [Maven](https://maven.apache.org/download.cgi)
### Build
- Git clone or download a zip of the project
- Run the following command from the root directory of the project: ```mvn clean install```
### Use
If you plan on using the Deboggler Engine in a Maven project, add the following coordinates to your POM file:
```
<groupId>com.grovatron</groupId>
<artifactId>deboggler-engine</artifactId>
<version>0.1.0</version>
```
Otherwise add the ```deboggler-engine-0.1.0.jar``` found in the /target directory to the class-path of your project.
## How to use
### Building the Deboggler
The ```Deboggler``` consists of the following components:
- ```Dictionary```: Responsible for validating prefixes and potential words found while searching the grid of ```Letter``` objects.
- ```WordConstructor```: Responsible for building ```Word``` objects from a valid combination of ```Letter``` objects. Depends on the following component:
  - ```WordPointCalculator```: Responsible for generating the point value of a ```Word``` object.
- ```WordSet```: Responsible for storing the ```Word``` objects found while searching the ```Letter``` grid.
#### Building a ```Dictionary```
To build a ```Dictionary```object, first create an instance of the ```DictionaryConstructor``` corresponding to the type of
```Dictionary``` you wish to use:
```java
DictionaryConstructor dictionaryConstructor = new TrieDictionaryConstructor();
```
Next pass an ```InputStream``` of the file that contains your dictionary:
```java
InputStream inputStream = new FileInputStream(new File("/dictionary-file.txt"));
Dictionary dictionary = dictionaryConstructor.buildDictionary(inputStream);
```
#### Building a ```WordConstructor```
First create a ```WordPointCalculator``` that will score words using the desired scoring system. For instance, if you wish to use the Boggle With Friends scoring system:
```java
WordPointCalculator wordPointCalculator = new WithFriendsWordPointCalculator();
```
Pass the ```WordPointCalculator``` to the ```WordConstructor```'s constructor:
```java
WordConstructor wordConstructor = new WordConstructor(wordPointCalculator);
```
#### Building a ```WordSet```
Simply create a ```WordSet``` of the type you desire to use:
```java
WordSet wordSet = new HashMapWordSet();
```
#### Putting It All Together
Once we have all the required components, simply pass them to the constructor of the ```Deboggler``` along with an ```int``` value,
```minLength```, that specifies the minimum length of a valid word. For instance, Boggle With Friends requires a word to be at least
two letters long (excluding the words "I" and "a").
```java
int minLength = 2;
Deboggler deboggler = new Deboggler(dictionary, wordConstructor, wordSet, minLength);
```
### Using the Deboggler
With a fully constructed ```Deboggler`` object, generating a ```Word``` list is as simple as passing the ```Letter``` grid to the method,
```getWordList```:
```java
// letterGrid is a Letter[][] object
List<Word> wordList = deboggler.getWordList(letterGrid);
```
To see examples of the ```Deboggler``` in action, check out:
- [OriginalDebogglerExample.java](https://github.com/grovatron/Deboggler-Engine/blob/master/src/main/java/examples/OriginalDebogglerExample.java)
- [WithFriendsDebogglerExample.java](https://github.com/grovatron/Deboggler-Engine/blob/master/src/main/java/examples/WithFriendsDebogglerExample.java)
