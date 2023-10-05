# PicapMicroserviceArchetype
Pasos para crear unn proyecto a aprtir de este arquetipo
1. Descargar el proyecto y ejecutar el comando mvn clean install
2. Dentro de una carpeta vacia ejecutar el siguiente comando mvn archetype:generate -Dfilter="PICAPMicroserviceArchetype" -DarchetypeCatalog=local
3. siga el siguiente ejemplo para diligenciar los parametros solicitados

E:\Micro1>mvn archetype:generate -Dfilter="PICAPMicroserviceArchetype" -DarchetypeCatalog=local
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------< org.apache.maven:standalone-pom >-------------------
[INFO] Building Maven Stub Project (No POM) 1
[INFO] --------------------------------[ pom ]---------------------------------
[INFO]
[INFO] >>> maven-archetype-plugin:3.2.1:generate (default-cli) > generate-sources @ standalone-pom >>>
[INFO]
[INFO] <<< maven-archetype-plugin:3.2.1:generate (default-cli) < generate-sources @ standalone-pom <<<
[INFO]
[INFO]
[INFO] --- maven-archetype-plugin:3.2.1:generate (default-cli) @ standalone-pom ---
[INFO] Generating project in Interactive mode
[INFO] No archetype defined. Using maven-archetype-quickstart (org.apache.maven.archetypes:maven-archetype-quickstart:1.0)
Choose archetype:
1: local -> co.com.picap.archetype:PICAPMicroserviceArchetype (Estructura base Arquitectura RUNT 2.0 Spring Boot)
Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): : 1
Define value for property 'groupId': co.com.picap
Define value for property 'artifactId': NombreMS
Define value for property 'version' 1.0-SNAPSHOT: : 1.0.0
Define value for property 'package' co.com.picap: : (enter)
Define value for property 'ArtifactIdCamel' NombreMS: : (enter)
Define value for property 'ArtifactLowerCase' nombrems: :(enter)
Confirm properties configuration:
groupId: co.com.picap
artifactId: NombreMS
version: 1.0.0
package: co.com.picap
ArtifactIdCamel: NombreMS
ArtifactLowerCase: nombrems
 Y: : (enter)
[INFO] ----------------------------------------------------------------------------
[INFO] Using following parameters for creating project from Archetype: PICAPMicroserviceArchetype:1.5.0
[INFO] ----------------------------------------------------------------------------
[INFO] Parameter: groupId, Value: co.com.picap
[INFO] Parameter: artifactId, Value: NombreMS
[INFO] Parameter: version, Value: 1.0.0
[INFO] Parameter: package, Value: co.com.picap
[INFO] Parameter: packageInPathFormat, Value: co/com/picap
[INFO] Parameter: ArtifactLowerCase, Value: nombrems
[INFO] Parameter: package, Value: co.com.picap
[INFO] Parameter: groupId, Value: co.com.picap
[INFO] Parameter: ArtifactIdCamel, Value: NombreMS
[INFO] Parameter: artifactId, Value: NombreMS
[INFO] Parameter: version, Value: 1.0.0
[INFO] Project created from Archetype in dir: E:\Micro1\NombreMS
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  02:06 min
[INFO] Finished at: 2023-10-04T09:41:19-05:00
[INFO] ------------------------------------------------------------------------
4. Ingrese a la carpeta donde ejecuto el comando y abra el proyecto en su ide de preferencia, ejecute mvn clean install para confirmar que el proyecto fue creado exitosamente.
