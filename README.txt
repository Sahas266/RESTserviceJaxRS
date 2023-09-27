Sample RESTful service using JAX-RS & JERSY


01. Installed Softwares
		a. eclipse v4.28.0
		b. maven - apache-maven-3.9.3
		c. Java - 11.0.20
		d. PostMan
		e. Maven dependencies
				jaxb-api - v2.3.1
				javax.ws.rs-api - v2.1
				jersey-media-jaxb v2.27
				jackson-core v2.13.3
		f. apache tomcat v8.5				
		
02. Creating a project using maven archetype
	mvn archetype:generate -DarchetypeGroupId=org.glassfish.jersey.archetypes -DarchetypeArtifactId=jersey-quickstart-webapp -DarchetypeVersion=2.27
		C:\Users\Administrator\Desktop\Sahas\proj>mvn archetype:generate -DarchetypeGroupId=org.glassfish.jersey.archetypes -DarchetypeArtifactId=jersey-quickstart-webapp -DarchetypeVersion=2.27
		[INFO] Scanning for projects...
		[INFO]
		[INFO] ------------------< org.apache.maven:standalone-pom >-------------------
		[INFO] Building Maven Stub Project (No POM) 1
		[INFO] --------------------------------[ pom ]---------------------------------
		[INFO]
		[INFO] >>> archetype:3.2.1:generate (default-cli) > generate-sources @ standalone-pom >>>
		[INFO]
		[INFO] <<< archetype:3.2.1:generate (default-cli) < generate-sources @ standalone-pom <<<
		[INFO]
		[INFO]
		[INFO] --- archetype:3.2.1:generate (default-cli) @ standalone-pom ---
		[INFO] Generating project in Interactive mode
		[INFO] Archetype repository not defined. Using the one from [org.glassfish.jersey.archetypes:jersey-quickstart-webapp:3.1.3] found in catalog remote
		Define value for property 'groupId': com.sahas.resources
		Define value for property 'artifactId': studentmanagement
		Define value for property 'version' 1.0-SNAPSHOT: : 1.0-SNAPSHOT
		Define value for property 'package' com.sahas.resources: :
		Confirm properties configuration:
		groupId: com.sahas.resources
		artifactId: studentmanagement
		version: 1.0-SNAPSHOT
		package: com.sahas.resources
		 Y: : Y
		[INFO] ----------------------------------------------------------------------------
		[INFO] Using following parameters for creating project from Old (1.x) Archetype: jersey-quickstart-webapp:2.27
		[INFO] ----------------------------------------------------------------------------
		[INFO] Parameter: basedir, Value: C:\Users\Administrator\Desktop\Sahas\proj
		[INFO] Parameter: package, Value: com.sahas.resources
		[INFO] Parameter: groupId, Value: com.sahas.resources
		[INFO] Parameter: artifactId, Value: studentmanagement
		[INFO] Parameter: packageName, Value: com.sahas.resources
		[INFO] Parameter: version, Value: 1.0-SNAPSHOT
		[INFO] project created from Old (1.x) Archetype in dir: C:\Users\Administrator\Desktop\Sahas\proj\studentmanagement
		[INFO] ------------------------------------------------------------------------
		[INFO] BUILD SUCCESS
		[INFO] ------------------------------------------------------------------------
		[INFO] Total time:  01:45 min
		[INFO] Finished at: 2023-09-25T17:08:47Z
		[INFO] ------------------------------------------------------------------------