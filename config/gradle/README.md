#HOWTO

To use Gradle configuration files defined here import the uppermost file from the hierarchy that serves you the best.
Place the import in the first line.
 
_e.g.:_ `apply from: "${rootProject.projectDir.path}/config/gradle/java/spring_cloud/spring_cloud.gradle"`

**Note:** Using absolute path is a must here as Gradle injects just the plain text of the file.

##Content
Gradle configurations are in a structured way that represents inheritance between them.
Every folder contains a single gradle file and multiple folders.

e.g.: Base -> Java -> Spring

Code quality rules were redistributed in a simpler structure under `config/quality`. 
