package cp317;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



public class CourseUtilities {

		/**
	     * Creates and returns a Course object from a line of string data.
	     *
	     * @param fileIn a comma-delimited line of Course data in the format
	     *             ID, Course Code, test 1, test 2, test 3, exam
	     * @return the data from line as a Course object
	     */
		public static Course readCourse(final String line, int line_count) {
		    String name = "Unknown"; //FIXME having second thoughts of adding this but, in case of error I think Empty looks better than whitespace
		    String ID = "";
		    String course_code = "";
		    
		    String test_1 = "";
		    double test_one = 0.0;
		    		
		    String test_2 = "";
		    double test_two = 0.0;
		    
		    String test_3 = "";
		    double test_three = 0.0;
		    
		    double exam_double = 0.0;
		    String exam_string = "";
		    
		    double grade = 0.0;
		    int studentID = 0;

		
		    
	    	Scanner reading = new Scanner(line);
	    	
	    	
	    	
	    	//an error catch for general format, if delimiter incorrect/wrong, will try to locate specific
	    	int comma_count = 0;
	    	boolean format_error = false;
	    	 
	    	for (int i = 0; i < line.length(); i++) {
	    	    if (line.charAt(i) == ',') {
	    	        comma_count++;
	    	    }
	    	}
	    	
	    	if (comma_count != 5) {
	    		System.out.print("Line " + line_count); // FIXME
	    		System.out.println(" Error(Course Input File): Incorrect Format of Course Input File");
	    		format_error = true;
	    	}
	 
	    	
	    	//from the start of no commas program should terminate
	    	if (comma_count == 0) {
	    		System.out.print("Line " + line_count); //FIXME
	    		System.out.println(" Error(Course Input File): Could not locate Comma as delimiter ");
	    		System.out.println("Project Testing Terminated");
	    		System.exit(0);
	    	}
	    	
	    	
	    	reading.useDelimiter("\\, "); //FIXME i added whitespace after ,
	    	
	    	
		    //Dealing with reading the Student ID and subsequent Error checks
	    	//Errors are determined as ID is not all digits or ID length is greater than standard 9
	    	if (reading.hasNext()){
		    	ID = reading.next();
		    	
		    	if (ID.length() > 9) {
		    		System.out.print("Line " + line_count); //FIXME
		    		System.out.println(" Error(Course Input File): Student ID too long");
		    		System.out.println("Project Testing Terminated");
		    		System.exit(0);
		    	}
		    	
		    	//made past length check, now checking if all numbers
		    	try
		        {
		    		studentID = Integer.parseInt(ID);
		        }
		        catch(NumberFormatException nfe)
		        {	
		        	System.out.print("Line " + line_count); //FIXME
		        	System.out.println(" Error(Course Input File): Student ID incorrect format, Should only be digits");
		        	System.out.println("Project Testing Terminated");
		    		System.exit(0);
		        }
	    	}
	    	else {
	    		System.out.print("Line " + line_count); //FIXME
	    		System.out.println(" Error(Course Input File): Could Not Read Student ID");
	    		System.out.println("Project Testing Terminated");
	    		System.exit(0);
	    	}
	    	
	    	
	    	
	    	//Now dealing with Course Code, and Subsequent Error Checks
	    	//Correct Course Code format example "AA123" 
	    	//length is 5, starts with two alphabet characters captalized, followed by three digits
	    	if (reading.hasNext()){
	    		course_code = reading.next();
	    		 		
	    		if (course_code.length() != 5) {
	    			System.out.print("Line " + line_count); //FIXME
	    			System.out.println(" Error(Course Input File): Incorrect Course Code Format");
		    		System.out.println("Project Testing Terminated");
		    		System.exit(0);	    			
	    		}
	    		//if it is correct length of 5, then checking general format (should be AA123 format type)
	    		else {
	    			for (int i = 0; i < 2; i++) {
	    				if (!(Character.isAlphabetic(course_code.charAt(i))) || !(Character.isUpperCase(course_code.charAt(i)))) {
	    					System.out.print("Line " + line_count); //FIXME
	    					System.out.println(" Error(Course Input File): Incorrect Course Code Format");
	    		    		System.out.println("Project Testing Terminated");
	    		    		System.exit(0);
	    				}
			    	}
	    			for (int i = 2; i < course_code.length(); i++) {
	    				if (!(Character.isDigit(course_code.charAt(i)))) {
	    					System.out.print("Line " + line_count); //FIXME
	    					System.out.println(" Error(Course Input File): Incorrect Course Code Format");
	    		    		System.out.println("Project Testing Terminated");
	    		    		System.exit(0);
	    				}
	    			}
	    		}		    	 	    		
	    	}
	    	else {
	    		System.out.print("Line " + line_count); //FIXME
	    		System.out.println(" Error(Course Input File): Could Not Read Course Code");
	    		System.out.println("Project Testing Terminated");
	    		System.exit(0);
	    	}
	    	
	    
	    	
	    	
	    	//Now dealing with Tests/Exams input and subsequent Error Checks
	    	//Correct input would be
	    	//confirm is digit (or parse double specific), is not <= 0 and not >=100, only 4 tests
	    	
	    	if (reading.hasNext()){
		    	test_1 = reading.next();
		    	try
		        {
		    		test_one = Double.parseDouble(test_1);
		        }
		        catch(NumberFormatException nfe)
		        {
		        	System.out.print("Line " + line_count); //FIXME
		        	System.out.println(" Error(Course Input File): Test One input should only be digits");
		        	System.out.println("Project Testing Terminated");
		    		System.exit(0);
		        }
		    	if (test_one > 100) {
		    		System.out.print("Line " + line_count); //FIXME
		    		System.out.println(" Error(Course Input File): Test One can not be greater than 100%");
		    		System.out.println("Project Testing Terminated");
		    		System.exit(0);
		    	}
		    	if (test_one < 0) {
		    		System.out.print("Line " + line_count); //FIXME
		    		System.out.println(" Error(Course Input File): Test One can not be less than 0%");
		    		System.out.println("Project Testing Terminated");
		    		System.exit(0);
		    	}
	    	}
	    	else {
	    		System.out.print("Line " + line_count); //FIXME
	    		System.out.println(" Error(Course Input File): Could Not Read Test One");
	    		System.out.println("Project Testing Terminated");
	    		System.exit(0);
	    	}
	    	
	    	
	    	//another error check to see if there is something to read
	    	if (reading.hasNext()){
		    	test_2 = reading.next();
		    	try
		        {
		    		test_two = Double.parseDouble(test_2);
		        }
		        catch(NumberFormatException nfe)
		        {
		        	System.out.print("Line " + line_count); //FIXME
		        	System.out.println(" Error(Course Input File): Test Two input should only be digits");
		        	System.out.println("Project Testing Terminated");
		    		System.exit(0);
		        }
		    	if (test_two > 100) {
		    		System.out.print("Line " + line_count); //FIXME
		    		System.out.println(" Error(Course Input File): Test Two can not be greater than 100%");
		    		System.out.println("Project Testing Terminated");
		    		System.exit(0);
		    	}
		    	if (test_two < 0) {
		    		System.out.print("Line " + line_count); //FIXME
		    		System.out.println(" Error(Course Input File): Test Two can not be less than 0%");
		    		System.out.println("Project Testing Terminated");
		    		System.exit(0);
		    	}
	    	}
	    	else {
	    		System.out.print("Line " + line_count); //FIXME
	    		System.out.println(" Error(Course Input File): Could Not Read Test Two");
	    		System.out.println("Project Testing Terminated");
	    		System.exit(0);
	    	}
	    	
	    	
	    	
	    	//another error check
	    	if (reading.hasNext()){
		    	test_3 = reading.next();
		    	try
		        {
		    		test_three = Double.parseDouble(test_3);
		        }
		        catch(NumberFormatException nfe)
		        {
		        	System.out.print("Line " + line_count); //FIXME
		        	System.out.println(" Error: Test Three input should only be digits");
		        	System.out.println("Project Testing Terminated");
		    		System.exit(0);
		        }
		    	if (test_three > 100) {
		    		System.out.print("Line " + line_count); //FIXME
		    		System.out.println(" Error: Test Three can not be greater than 100%");
		    		System.out.println("Project Testing Terminated");
		    		System.exit(0);
		    	}
		    	if (test_three < 0) {
		    		System.out.print("Line " + line_count); //FIXME
		    		System.out.println(" Error: Test Three can not be less than 0%");
		    		System.out.println("Project Testing Terminated");
		    		System.exit(0);
		    	}
	    	}
	    	else {
	    		System.out.print("Line " + line_count); //FIXME
	    		System.out.println(" Error: Could Not Read Test Three");
	    		System.out.println("Project Testing Terminated");
	    		System.exit(0);
	    	}
	    	
	    	
	    	
	    	//another error check
	    	if (reading.hasNext()){
		    	exam_string = reading.next();
		    	try
		        {
		    		exam_double = Double.parseDouble(exam_string);
		        }
		        catch(NumberFormatException nfe)
		        {
		        	System.out.print("Line " + line_count); //FIXME
		        	System.out.println(" Error: Exam input should only be digits");
		        	System.out.println("Project Testing Terminated");
		    		System.exit(0);
		        }
		    	if (exam_double > 100) {
		    		System.out.print("Line " + line_count); //FIXME
		    		System.out.println(" Error: Exam can not be greater than 100%");
		    		System.out.println("Project Testing Terminated");
		    		System.exit(0);
		    	}
		    	if (exam_double < 0) {
		    		System.out.print("Line " + line_count); //FIXME
		    		System.out.println(" Error: Exam can not be less than 0%");
		    		System.out.println("Project Testing Terminated");
		    		System.exit(0);
		    	}
	    	}
	    	else {
	    		System.out.print("Line " + line_count); //FIXME
	    		System.out.println(" Error: Could Not Read Exam");
	    		System.out.println("Project Testing Terminated");
	    		System.exit(0);
	    	}

	    	
	    	//dealing with error case of too many tests/tokens in file, if more than standard file then program terminates
	    	if (reading.hasNext()) {
	    		String temp_error = reading.next();
	    		 try {
	    			 //testing for specifics of extra test score (double)
	    			 Double.parseDouble(temp_error);
	    			 System.out.print("Line " + line_count); //FIXME
	    			 System.out.println(" Error: Student has too many tests");
	    			 System.out.println("Project Testing Terminated");
	    		     System.exit(0);
	    		    } 
	    		 catch (NumberFormatException nfe) {
	    			 //if it is not a double, it not an extra test input and back to more generic error handling
	    			 System.out.print("Line " + line_count); //FIXME
	    			 System.out.println(" Error: Too many values to read");
	    			 System.out.println("Project Testing Terminated");
	    			 System.exit(0);
	    		    }
	    		System.exit(0);
	    	}
	    	
	    	
	    	
	 
		    reading.close();
		    
		    //file formatting error was determined by wrong count of commas
		    //this is just an extra fail safe check 
			if (format_error == true) {
		   		System.exit(0);
		   	}
		   	
			
			//if made it to here without termination, everything should be satisfactory
			
			
			grade = gradeCalculation(test_one, test_two, test_three, exam_double);
			
			
			
		   	
			Course read_student = new Course(); 
			read_student.setCourseCode(course_code); 
			read_student.setGrade(grade); // 
			read_student.setID(studentID); //
			read_student.setName(name); // 
	

		   	
		   	return read_student;
	    }
		
		/**
	     * Reads a file of Course strings into a list of Course objects.
	     *
	     * @param fileIn a Scanner of a course data file in the format
	     *               ID, Course Code, test 1, test 2, test 3, exam
	     * @return a list of courses
	     */
	    public static ArrayList<Course> readCourses(final Scanner fileIn) {
	    	Course temp_course = null;	
	    	ArrayList<Course> all_courses = new ArrayList<Course>();
	    	int line_count = 1; // FIXME testing this
	    	
	    	
	    	while (fileIn.hasNextLine()) {
	    		temp_course = readCourse(fileIn.nextLine(), line_count);    		
	    		all_courses.add(temp_course);
	    		line_count++;
	    	}

		return all_courses;
	    }
	    
	    /**
	     * Writes the contents of a list of Course Objects to a PrintStream.
	     *
	     * @param Courses a list of Course objects
	     * @param ps    the PrintStream to write to
	     */
	    public static void writeCourses(final ArrayList<Course> Courses, PrintStream ps) {
	    	
	    	//FIXME new sorting test
	    	ArrayList<Course> sortedList = sortCourseOutput(Courses);
	    	int i;
	    	int size = sortedList.size();
	    	Course temp_course = null;
	    	
	    	for (i = 0; i < size; i++) {
	    		temp_course = sortedList.get(i);
	    		temp_course.write(ps);
	    	}
	    	
	    	
	    	
	    	
	    return;

	    }
	    
	    
	    
	    
	    
	    /**
	     * reads a name from a line of string data.
	     *
	     * @param line a comma-delimited line of student name data in the format
	     *             ID, Name
	     * @param list of Course objects   
	     *          
	     *
	     */
	    public static void readName (final String line, final ArrayList<Course> course, int line_count) {
		    String name = "";
		    String ID = "";
		    int studentID = 0;
		    
		   
	       
	    	
		    Scanner reading = new Scanner(line);
		    
		    //an error catch for general format, if delimiter incorrect/wrong, will try to locate specific
	    	int comma_count = 0;
	    	//boolean format_error = false; FIXME do i need this? think
	    	 
	    	for (int i = 0; i < line.length(); i++) {
	    	    if (line.charAt(i) == ',') {
	    	        comma_count++;
	    	    }
	    	}
	    	
	    	if (comma_count != 1) {
	    		System.out.print("Line " + line_count + " "); // FIXME
	    		System.out.println("Error(Name Input File): Incorrect Format of Name Input File");
	    		//format_error = true; FIXME do i need this? think
	    	}
	 
	    	
	    	//from the start of no commas program should terminate
	    	if (comma_count == 0) {
	    		System.out.print("Line " + line_count + " "); // FIXME
	    		System.out.println("Error(Name Input File): Could not locate Comma as delimiter ");
	    		System.out.println("Project Testing Terminated");
	    		System.exit(0);
	    	}
	    	
		    
		   	reading.useDelimiter("\\, ");  //FIXME add whitespace after comma
			
		   	if (reading.hasNext()){
		   		ID = reading.next();
		   		if (ID.length() > 9) {
		   			System.out.print("Line " + line_count + " "); // FIXME
		    		System.out.println("Error(Name Input File): Student ID too long");
		    		System.out.println("Project Testing Terminated");
		    		System.exit(0);
		    	}
		    	
		    	//made past length check, now checking if all numbers
		    	try
		        {
		    		studentID = Integer.parseInt(ID);
		        }
		        catch(NumberFormatException nfe)
		        {
		        	System.out.print("Line " + line_count + " "); // FIXME
		        	System.out.println("Error(Name Input File): Student ID incorrect format, Should only be digits");
		        	System.out.println("Project Testing Terminated");
		    		System.exit(0);
		        }
		   	}
		   	else {
		   		System.out.print("Line " + line_count + " "); // FIXME
	    		System.out.println("Error(Name Input File): Could Not Read Student ID");
	    		System.out.println("Project Testing Terminated");
	    		System.exit(0);
	    	}
		   	
		   	
		   	//not sure for error checks because names can vary, but will assume only alphabetical characters?
		   	//and i guess for the sake of this project also assume only English Alphabet
		   	//and 20 character length as project requirements
		   	if (reading.hasNext()){
		   		name = reading.next();
		   		if(name.length() > 20) {
		   			System.out.print("Line " + line_count + " "); // FIXME
					System.out.println("Error(Name Input File): Sorry Name is too Long");
		    		System.out.println("Project Testing Terminated");
		    		System.exit(0);
					//FIXME
		   		}
		   		else if(name.length() == 0) {
		   			System.out.print("Line " + line_count + " "); // FIXME
					System.out.println("Error(Name Input File): No Name to be read");
		    		System.out.println("Project Testing Terminated");
		    		System.exit(0);
					//FIXME
		   		}
		   		for (int i = 0; i < name.length(); i++) {
    				if (!(Character.isAlphabetic(name.charAt(i)))) {
    					//need this also for whitespaces, as program takes first and last name as one string
    					if (name.charAt(i) != ' ') {
    					System.out.print("Line " + line_count + " "); // FIXME
    					System.out.println("Error(Name Input File): Only accepts Alphabetic characters of English language");
    		    		System.out.println("Project Testing Terminated");
    		    		System.exit(0);
    					}
    				}
    			}
		   	}
		    	
		    
		   	if (reading.hasNext()){
		   		System.out.print("Line " + line_count + " "); // FIXME
		   		System.out.println("Error(Name Input File): Too Much Info in file");
	    		System.out.println("Project Testing Terminated");
	    		System.exit(0);
		   	}
		    		
		    reading.close();
		    	
		    matchID(course, studentID, name);
		    	
		 
		    return; 
		    	
	}
	    	
	    	
	    	
	    	
	    	
	    	

    
	    
	    
	    /**
	     * Reads a file of name strings into a list of Course objects.
	     *
	     * @param fileIn a Scanner of a Student/Course data file in the format
	     *               name|origin|isVegetarian|calories
	     * @param courses a list of Course objects
	     *      
	     * 
	     */
	    public static ArrayList<Course> readNames(final Scanner fileIn, final ArrayList<Course> courses) {
	    	//int line_count = 0; // FIXME testing this
	    	int line_count = 1; // FIXME testing this
	    	
	    	while (fileIn.hasNextLine()) {
	    		readName(fileIn.nextLine(), courses, line_count);
	    		line_count++;
	    	}
	    	

		return courses;
	    }
	    
	    
	    /**
	     * Matches the ID and writes the name on that Course Object
	     *
	     * @param Courses a list of Course objects
	     * @param temp_ID    the temporary ID that is trying to match
	     * @param name the name to set to the matching ID 
	     */
	    public static void matchID(final ArrayList<Course> Courses, int temp_ID, String name) {

	    	int i;
	    	int size = Courses.size();
	    	Course temp_course = null;
	    	
	    	
	    	
	    	for (i = 0; i < size; i++) {
	    		temp_course = Courses.get(i);
	    		if (temp_course.getID() == temp_ID) { 
	    			temp_course.setName(name);
	    		}
	    	}
	    	
	    	
	    	
	    	
	    return;
	    }
	    
	    
	    /**
	     * Grade Calculation
	     *
	     * @param test_one test 1 mark
	     * @param test_two test 2 mark
	     * @param test_three test 3 mark
	     * @param exam_double exam mark
	     * 
	     * @return overall_grade the students grade after graduation
	     */
	    public static double gradeCalculation(double test_one, double test_two, double test_three, double exam_double) {
	    
	    	double overall_grade = (test_one * 0.2) + (test_two * 0.2) + (test_three * 0.2) + (exam_double * 0.4);
		
	    return overall_grade;
	    }
	    
	    /**
	     * Grade Calculation
	     *
	     * @param ArrayList<Course> unsorted array list
	     * 
	     * @return ArrayList<Course> sorted array list
	     */
	    public static ArrayList<Course> sortCourseOutput(ArrayList<Course> courses) {
	    
	    	
	    	
	    	Collections.sort(courses);
	    	
		
	    return courses;
	    }
}


