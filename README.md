This is a Maven/POM based java project.
The user interface is HTML5 compliant page, which has an url input field(diabled), a number field which can accept values ranging from 0 to 500 and a submit button. User can use spinner or directly input the value.
Backend is Spring web based module which parses the incomming request.
When the user submits the form, the control goes to the controller and input parameters are determined.
The url which is http://terriblytinytales.com/test.txt is loaded through a third party HTML parsing library JSoup. Contents are loaded, splitted with whitespace character(\s), creates a set of unique words, frequecy of each word is determined and stored in a HashMap. 
HashMap is sorted with values in descending order and stored in another HashMap and from the sorted HashMap, the top N values are returned to the user.
No Java code is used on JSP page, for this JSTL is used.

List of libraries
1) Java 1.8 
2) Spring Framework Libraries 4.3.13
3) JSTL 1.2.1
4) JSoup 1.11.2
5) taglibs 1.1.2
