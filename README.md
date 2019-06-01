# PDFBox GUI

## Background

I made this because every PDF tool requires purchasing before I can edit them.  
I only need to merge PDFs and extract images from PDF.  
I am most familiar with Java and the only open source Java PDF tool is [Apache PDFBox](https://pdfbox.apache.org/),  
but the easy way to use it is via the [Command Line Tools](https://pdfbox.apache.org/2.0/commandline.html).  
Hence, I made a GUI out of it with JavaFX.  
Any critic and advice is appreciated.  

## How to Use

Windows: "RUN-APPLICATION-(NATIVE).cmd".  
Non-windows: "RUN-APPLICATION-(JAR).cmd".  
or `java -jar "./Source Code/build/libs/PDFBoxGUI-0.0-SNAPSHOT.jar"`.  

## Specification

### Note

Previously, I used JDK 12, JavaFX 12, and Scene Builder 11, but resulted in many issues.  
Then, I installed JDK 8 with Scene Builder 8, which works but console shows incompatibility warning.  
Should any issue rises, feel free to report it.  

### Build Tool

[Gradle](https://gradle.org/), bundled with [IntelliJ IDEA](https://www.jetbrains.com/idea/) community edition.

### Java Version

```CMD
$ java -version
java version "1.8.0_211"
Java(TM) SE Runtime Environment (build 1.8.0_211-b12)
Java HotSpot(TM) 64-Bit Server VM (build 25.211-b12, mixed mode)
```

## Legal

All credits go to [Apache PDFBox](https://pdfbox.apache.org/).  
