# KotlinExtensions





To get a Git project into your build:


# gradle
Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

 ```
  allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
Step 2. Add the dependency

```
dependencies {
	        implementation 'com.github.cwaliimran:KotlinExtensions:Tag'
     	}
```



# maven

Step 1. Add the JitPack repository to your build file
```
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
  ```
Step 2. Add the dependency

```
<dependency>
	    <groupId>com.github.cwaliimran</groupId>
	    <artifactId>KotlinExtensions</artifactId>
	    <version>Tag</version>
	</dependency>
  ```
  
  
  
  
# sbt

  Step 1. Add the JitPack repository to your build file
Add it in your build.sbt at the end of resolvers:

 ```
    resolvers += "jitpack" at "https://jitpack.io"    
 ```
Step 2. Add the dependency

```
	libraryDependencies += "com.github.cwaliimran" % "KotlinExtensions" % "Tag"	
```
  
  
# leiningen
  Step 1. Add the JitPack repository to your build file

Add it in your project.clj at the end of repositories:

```
    :repositories [["jitpack" "https://jitpack.io"]]
``` 
    
Step 2. Add the dependency

```
	:dependencies [[com.github.cwaliimran/KotlinExtensions "Tag"]]	
```
