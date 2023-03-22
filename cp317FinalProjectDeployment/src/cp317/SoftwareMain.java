package cp317;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;




public class SoftwareMain {
	
	public static void main(final String[] args){
		
	
		
		System.out.println("CP317 Project Tests\n");
		
		//opening scanner to read keyboard
		Scanner keyboard = new Scanner(System.in);
		boolean textCheck = false;
		
		//Getting the user to enter the Course file name
		System.out.println("Enter Course Input File Name (by default searches for .txt file type only) : ");
		String course_filename = userInputsFileString(keyboard);
		// check to make sure user enters .txt correctly
		textCheck = isTextFile(course_filename);
		if (textCheck == false) {
			course_filename = addTxt(course_filename);
		}
		System.out.println("Searching for: " + course_filename + "\n");
		
		
		//Getting user to enter Student Name File, Will automatically be txt file
		System.out.println("Enter Student's Name Input File Name( by default searches for .txt file type only): ");
		String students_filename = userInputsFileString(keyboard);
		// check to make sure user enters .txt correctly
		textCheck = isTextFile(students_filename);
		if (textCheck == false) {
			students_filename = addTxt(students_filename);
		}
        System.out.println("Searching for: " + students_filename + "\n");
		
		
		//Getting user to enter their desired output filename
		System.out.println("Enter desired file output name (automatically output a .txt file): ");
		String output_filename = userInputsFileString(keyboard);
		// check to make sure user enters .txt correctly
		textCheck = isTextFile(output_filename);
		if (textCheck == false) {
			output_filename = addTxt(output_filename);
		}
        System.out.println("Will output to: " + output_filename + "\n");
		
		//closing the keyboard as no more info is needed from user		
		keyboard.close();
									
		
	
		//testing reading CourseFile
		ArrayList<Course> studentsCourse = testStudentCourse(course_filename);
		//testing reading NameFile
		ArrayList<Course> studentsCourseFull = testStudentName(studentsCourse, students_filename);
		//Outputting Course Object array to user desired output file
		testFileOutput(output_filename, studentsCourseFull);
			
		
		
		
		
		
		System.out.println("Project Success");
		
		return;
	}

	

	
	
	public static ArrayList<Course> testStudentCourse(String input_filename) {

		ArrayList<Course> tempCourse = null;
		
		try {
			final File file = new File(input_filename);
		    Scanner fileIn = new Scanner(file);
		    tempCourse = CourseUtilities.readCourses(fileIn);
		    fileIn.close();
		} catch (FileNotFoundException e1) {
		    // TODO Auto-generated catch block
		    //e1.printStackTrace();
			System.out.println("Error: Course Input File \"" + input_filename + "\" Not Found \n");
			System.out.println("Project Testing Terminated");
    		System.exit(0);
			
		}
		
	    
	   
		return tempCourse;

	    
	}
	
	
	
	public static ArrayList<Course> testStudentName(ArrayList<Course> courses, String filename_input) {//public static void testStudentName(ArrayList<Course> courses) {
		if (courses == null) {
			System.out.println("Error: Array is Null can not iterate");
			System.out.println("Project Testing Terminated");
    		System.exit(0);
		}
		ArrayList<Course> tempCourses = null;
		
		try {
			final File file = new File(filename_input);
		    Scanner fileIn = new Scanner(file);
		    tempCourses = CourseUtilities.readNames(fileIn, courses);
		    fileIn.close();
		} catch (FileNotFoundException e1) {
		    // TODO Auto-generated catch block
		    System.out.println("Error: Student Name input File \"" + filename_input + "\" Not Found \n");
		    System.out.println("Project Testing Terminated");
    		System.exit(0);
		}
		
		return tempCourses;
		

	}
	
	public static void testFileOutput (String output_filename, ArrayList<Course> studentsCourseFull) {
		if (studentsCourseFull == null) {
			System.out.println("Error: Can not outpute null Array");
			System.out.println("Project Testing Terminated");
    		System.exit(0);
		}
		
		
		
		try {
		    File outFile = new File(output_filename);
		    PrintStream ps = new PrintStream(outFile);
		    CourseUtilities.writeCourses(studentsCourseFull, ps);
		    ps.close();
		} catch (FileNotFoundException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		
		return;
	}
	/*
	 * getting user to input file names for reading/ or for output
	 */
	public static String userInputsFileString(Scanner keyboard) {
		//Scanner keyboard = new Scanner(System.in);
		
		
		String users_filename = keyboard.nextLine();
	    
		//keyboard.close();
		
		return users_filename;
		
	
	}

	/*
	 * Check to make sure user input is a text file
	 */
	public static boolean isTextFile(String filename) {
		boolean file_check = false;
		
		if (filename.charAt(filename.length() - 1) == 't') {
		    	if (filename.charAt(filename.length() - 2) == 'x') {
		    		if (filename.charAt(filename.length() - 3) == 't') {
		    			if (filename.charAt(filename.length() - 4) == '.') {
		    				file_check = true;
		        	    }
		    		}
	    	}	   	
	    }
	    
		
		return file_check;
		
	
	}
	
	/*
	 * add .txt to end of user keyboard inputted filename
	 */
	public static String addTxt(String filename) {
		filename = filename + ".txt";
		
		return filename;
		
	
	}
}

