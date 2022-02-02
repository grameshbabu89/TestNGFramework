warning: LF will be replaced by CRLF in .gitignore.
The file will have its original line endings in your working directory
warning: LF will be replaced by CRLF in src/main/java/com/cmsService/testng/api/base/ProjectSpecificMethods.java.
The file will have its original line endings in your working directory
[1mdiff --git a/.gitignore b/.gitignore[m
[1mindex 3592437..fc558c5 100644[m
[1m--- a/.gitignore[m
[1m+++ b/.gitignore[m
[36m@@ -34,4 +34,4 @@[m [mbuild/[m
 /config.json[m
 /mocked-file-path[m
 /simulationModel-*.json[m
[31m-[m
[32m+[m[32m/reports/[m
[1mdiff --git a/config.properties b/config.properties[m
[1mindex c98c8e7..b4ecc47 100644[m
[1m--- a/config.properties[m
[1m+++ b/config.properties[m
[36m@@ -1,2 +1,2 @@[m
 url=http://localhost:8102/club/1.0.0/cms/bonus/audit/ui/index.html[m
[31m-browser=chrome[m
\ No newline at end of file[m
[32m+[m[32m#browser=chrome[m
\ No newline at end of file[m
[1mdiff --git a/data/TC002.xlsx b/data/TC002.xlsx[m
[1mdeleted file mode 100644[m
[1mindex 9c004c5..0000000[m
Binary files a/data/TC002.xlsx and /dev/null differ
[1mdiff --git a/data/TC003.xlsx b/data/TC003.xlsx[m
[1mdeleted file mode 100644[m
[1mindex f47b1f3..0000000[m
Binary files a/data/TC003.xlsx and /dev/null differ
[1mdiff --git a/data/TC004.xlsx b/data/TC004.xlsx[m
[1mdeleted file mode 100644[m
[1mindex 0ebea78..0000000[m
Binary files a/data/TC004.xlsx and /dev/null differ
[1mdiff --git a/data/TC005.xlsx b/data/TC005.xlsx[m
[1mdeleted file mode 100644[m
[1mindex c0eb1e2..0000000[m
Binary files a/data/TC005.xlsx and /dev/null differ
[1mdiff --git a/data/TC006.xlsx b/data/TC006.xlsx[m
[1mdeleted file mode 100644[m
[1mindex 4f3a1da..0000000[m
Binary files a/data/TC006.xlsx and /dev/null differ
[1mdiff --git a/data/TC007.xlsx b/data/TC007.xlsx[m
[1mdeleted file mode 100644[m
[1mindex eea4921..0000000[m
Binary files a/data/TC007.xlsx and /dev/null differ
[1mdiff --git a/pom.xml b/pom.xml[m
[1mindex 5861715..771f0df 100644[m
[1m--- a/pom.xml[m
[1m+++ b/pom.xml[m
[36m@@ -4,7 +4,14 @@[m
 	<modelVersion>4.0.0</modelVersion>[m
 	<groupId>org.advantage.club</groupId>[m
 	<artifactId>advClubSel</artifactId>[m
[31m-	<version>1.2.1</version>[m
[32m+[m	[32m<version>1.0.0</version>[m
[32m+[m[41m	[m
[32m+[m	[32m <properties>[m
[32m+[m[41m    [m	[32m<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>[m
[32m+[m[41m    [m	[32m<selenium.version>4.0.0-alpha-4</selenium.version>[m
[32m+[m[41m    [m	[32m<htmlunit.version>2.51.0</htmlunit.version>[m
[32m+[m[41m    	[m
[32m+[m[41m  [m	[32m</properties>[m
 	<dependencies>[m
 		<dependency>[m
 			<groupId>com.aventstack</groupId>[m
[36m@@ -14,7 +21,7 @@[m
 		<dependency>[m
 			<groupId>org.seleniumhq.selenium</groupId>[m
 			<artifactId>selenium-java</artifactId>[m
[31m-			<version>4.0.0-alpha-4</version>[m
[32m+[m			[32m<version>${selenium.version}</version>[m
 		</dependency>[m
 		<dependency>[m
 			<groupId>junit</groupId>[m
[36m@@ -56,6 +63,24 @@[m
 			<artifactId>cucumber-testng</artifactId>[m
 			<version>6.10.0</version>[m
 		</dependency>[m
[32m+[m		[32m <dependency>[m
[32m+[m[41m      [m		[32m<groupId>net.sourceforge.htmlunit</groupId>[m
[32m+[m[41m      [m		[32m<artifactId>htmlunit</artifactId>[m
[32m+[m[41m      [m		[32m<version>${htmlunit.version}</version>[m
[32m+[m[41m    [m	[32m</dependency>[m
[32m+[m[41m    [m	[32m<!-- https://mvnrepository.com/artifact/org.json/json -->[m
[32m+[m		[32m<dependency>[m
[32m+[m[41m    [m		[32m<groupId>org.json</groupId>[m
[32m+[m[41m    [m		[32m<artifactId>json</artifactId>[m
[32m+[m[41m    [m		[32m<version>20210307</version>[m
[32m+[m		[32m</dependency>[m
[32m+[m		[32m<!-- https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple -->[m
[32m+[m		[32m<dependency>[m
[32m+[m[41m    [m		[32m<groupId>com.googlecode.json-simple</groupId>[m
[32m+[m[41m    [m		[32m<artifactId>json-simple</artifactId>[m
[32m+[m[41m    [m		[32m<version>1.1.1</version>[m
[32m+[m		[32m</dependency>[m
[32m+[m[41m		[m
 	</dependencies>[m
 	<build>[m
 		<pluginManagement>[m
[1mdiff --git a/reports/result.html b/reports/result.html[m
[1mindex 904b517..6ac70d3 100644[m
[1m--- a/reports/result.html[m
[1m+