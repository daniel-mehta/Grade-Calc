package cp317;

import java.io.PrintStream;


public class Course implements Comparable<Course> {
	private String course_code = null;
	private String student_name = null; 
	private double course_mark = 0.0;
	private int student_ID = 0;

	
	 Course (String course_code, int student_ID, double course_mark, String student_name) {
		// TODO Auto-generated constructor stub
		super();
		this.course_code = course_code;
		this.student_ID = student_ID;
		this.course_mark = course_mark;
		this.student_name = student_name;
		
		return;
	}
	 Course () {
			// FIXME this is a test constructor
			super();
			
			return;
		}
	 /**
	     * Getter for name attribute.
	     *
	     * @return name
	     */
	    public String getName() {

	    	String copy_name = this.student_name;

		return copy_name;
	    }
	    /**
	     * Getter for name attribute.
	     *
	     * @return name
	     */
	    public Boolean hasName() {
	    	Boolean contains_name = false;
	    	
	    	if (this.student_name != null) {
	    		contains_name = true;
	    	}

		return contains_name;
	    }
	    /**
	     * Setter for name attribute.
	     *
	     *@param name  in string to set as 
	     */
	    public void setName(String name) {

	    	this.student_name = name;

		return;
	    }
	    
	    
	    /**
	     * Setter for course code attribute.
	     *
	     *@param course code  in string to set as 
	     */
	    public void setCourseCode(String course_code) {

	    	this.course_code = course_code;

		return;
	    }
	    
	    /**
	     * Setter for the students overall mark attribute.
	     *
	     *@param mark  the students overall grade in double 
	     */
	    public void setGrade(double mark) {

	    	this.course_mark = mark;

		return;
	    }
	    
	    /**
	     * Setter for students id.
	     *
	     *@param id_number  int version of students id 
	     */
	    public void setID(int id_number) {

	    	this.student_ID = id_number;

		return;
	    }
	    
	    /**
	     * Getter for ID attribute.
	     *
	     * @return ID
	     */
	    public int getID() {

	    	int copy_ID = this.student_ID;

		return copy_ID;
	    }
		
	    /*
	     * (non-Javadoc)
	     *
	     * @see java.lang.Object//toString() Creates a formatted string of Student data.
	     */
	    /**
	     * Returns a string version of a course object in the form:
		   <pre>
		   Name:       name
		   StudentID:     origin string
		   </pre>
		   @return a string version of the course object
	     */
	    @Override
	    public String toString() {

	    	String course_output = "";
	    	
	    	course_output = "Student ID:" + this.student_ID + "\n";
			course_output = course_output + "Name:" + this.student_name + "\n";
			course_output = course_output + "Course:" + this.course_code + "\n";
			course_output = course_output + "Final Mark:" + this.course_mark + "\n";



		return course_output;

	    }
	    
	    
		  /**
	     * Writes a single line of Course object data to an open PrintStream.
	     * 
	     *
	     * @param ps The PrintStream to write to.
	     */
		public void write(PrintStream ps) {
			ps.print(this.student_ID);
			ps.print("|");
			ps.print(this.student_name);
			ps.print("|");
			ps.print(this.course_code);
			ps.print("|");
			ps.printf("%.1f", this.course_mark);
	    	ps.print("\n");
			
		}
		/**
	     * overriding the compareTo Function
	     * 
	     *
	     * @param otherCourse other Course Object to compare to.
	     */
		@Override
		public int compareTo(Course otherCourse) {
			return Integer.compare(getID(), otherCourse.getID());
	    }
	
	
}

	
	


