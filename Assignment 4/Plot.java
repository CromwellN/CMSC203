/*Class: CMSC203 CRN 22445
 Program: Assignment 4 Design
 Instructor: Dr.Grinberg
 Summary of Description: lets the user create a management company and add the properties managed by the company to its list.
 Due Date: 10/18/2020
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student: Cromwell Nzouakeu
*/

public class Plot {
	
	// Class Variables
	private int PlotX = 0;
	private int PlotY = 0;
	private int PlotWidth = 0;
	private int PlotDepth = 0;

	 // constructor
	public Plot() {
		PlotWidth = 1;
		PlotDepth = 1;
	}
	
	 //plot overlapping
	public boolean overlaps(Plot P) {
		// Variables
		int result=0;
		int plotX1=getX(); // start left X-coordinate 
		int plotX2=P.getX();
		int plotX3=getX() + getWidth(); // right X-coordinate end
		
		int plotY1= getY(); // start top Y-coordinate
		int plotY2=P.getY();
		int plotY3= getY() +  getDepth(); // bottom Y-coordinate end
		if (plotX1>=plotX2||plotX2<=plotX3) { 
			result = 1; 
			}
		if (plotY1>=plotY2||plotY2<=plotY3) { 
			result = 1; 
			}
		return result==0 ? false : true;
	}
	
	 // Check plot container
	public boolean encompasses(Plot P) {
		
		// Variables
		int result = 0;
		int plotX1 =  getX(); // start X coordinate (left)
		int plotX2 = P.getX();
		int plotX3 =  getX() +  getWidth(); // end X coordinate (right)
		
		int plotY1 =  getY(); // start Y coordinate (top)
		int plotY2 = P.getY();
		int plotY3 =  getY() +  getDepth(); // end Y coordinate (bottom)
		if (plotX1 +  getWidth() > plotX2) { 
			result = 1; }
		if (plotY1 +  getDepth() > plotY2) { 
			result = 1; }
		if (plotX1 >= plotX2 || plotX2 <= plotX3) { 
			result = 1; }
		if (plotY1 >= plotY2 || plotY2 <= plotY3) { 
			result = 1; }
		System.out.println("Encompasses: this.X" + plotX1 + " P.X " + plotX2);
		
		// Return
		return result == 0 ? false : true;
	}
	
	 // Constructor argument
	public Plot(int X, int Y, int Width, int Depth) {
		 PlotX = X;
		 PlotY = Y;
		 PlotWidth = Width;
		 PlotDepth = Depth;
	}
	 //Get X coordinate
	public int getX() { 
		return PlotX; }

	 //Get Y coordinate
	public int getY() { 
		return  PlotY; }

	 //Get Width
	public int getWidth() { 
		return  PlotWidth; }

	 //Get Depth
	public int getDepth() { 
		return  PlotDepth; }

	 // Set X
	public void setX(int X) { 
		 PlotX = X; }
	
	 // Set Y 
	public void setY(int Y) { 
		 PlotY = Y; }

	 // Set Width
	public void setWidth(int Width) { 
		 PlotWidth = Width; }
	
	 //Set Depth
	public void setDepth(int Depth) { 
		 PlotDepth = Depth; }

	 // Text plot
	public String toString() {
		// Variables
		String Return = "";
		// Append
		Return += "(X,Y): (" +  getX() + ", " + getY() + ")";
		Return += "\n" + "Width: " +  getWidth();
		Return += "\n" + "Depth:" +  getDepth();
		return Return ;
	}

}