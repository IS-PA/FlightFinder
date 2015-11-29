# FlightFinder


Set up proyect in eclipse


* Create Java Proyect (Java 1.8)
* Go to the *src* proyect folder.
* Execute *inside* the *src* folder: 
```bash
git clone https://github.com/IS-PA/FlightFinder .
```
* From [here](http://search.maven.org/#artifactdetails%7Ccom.google.code.gson%7Cgson%7C2.5%7Cjar) download *gson-2.5.jar* and *gson-2.5-javadoc.jar*
* In eclipse, reload the proyect (clic on the proyect, then press F5)
* Right clic in proyect folder > Properties > Java Build Path > Libraries
  * Clic *Add JARs...*
  * Search for *gson-2.5.jar* and add it.
  * Expand the *gson-2.5.jar* library with the triangle before its name. Select *Javadoc location*.
  * Clic "Edit" (With the *Javadoc location* selected). Select "javadoc in archive" > "workspace file".
  * Search for *gson-2.5-javadoc.jar* and add it. Clic *Validate...* to make sure the selected file is a valid javadoc file. Leave empty "Path within archive". 
* Make sure everithing is working: 
  * In the "com.github.ispa.flightfinder.examples" package, open *json.java* and place the cursor over *JsonObject* in the first line of *main*. If you can see the documentation, it works.
