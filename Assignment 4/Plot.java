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
   private int x;
   private int y;
   private int width;
   private int depth;
 
   // No-arg constructor with a default Plot with set x, y, width, and depth
   public Plot(){
       this.x = 0;
       this.y = 0;
       this.width = 1;
       this.depth = 1;
   }
   
   // Constructor,a new Plot using the information of the Plot passed to it.
   public Plot(Plot p){
       this.x = p.x;
       this.y = p.y;
       this.width = p.width;
       this.depth = p.depth;
   }
   
   // Constructs a new object with x, y, width, and depth
   public Plot(int x, int y, int width, int depth){
       this.x = x;
       this.y = y;
       this.width = width;
       this.depth = depth;
   }
   
   //plot overlaps and return true if it overlaps, otherwise false
   public boolean overlaps(Plot plot) {
       return x < plot.x + plot.width && x + width > plot.x && y < plot.y + plot.depth && y + depth > plot.y;
   }
   
 // checks plot container and return true if plot encompasses the parameter. otherwise false
   public boolean encompasses(Plot plot) {
	   // Variables
       boolean encompass = false;
       double rightX = x + width;
       double bottomY = y + depth;
       double newRightX = plot.getX()+plot.getWidth();
       double newBottomY = plot.getY() + plot.getDepth();
       if (this.x<=plot.getX() && plot.getX()<=rightX && this.y<=plot.getY() && plot.getY()<=bottomY
               && this.x<=rightX && newRightX<=rightX
               && this.y<=newBottomY && newBottomY<=bottomY) {
           encompass = true;
       }
       // Return
       return encompass;
   }
 
   //Get X coordinate and return x
   public int getX(){
       return x;
   }
   
   // Set x
   public void setX(int x){
       this.x = x;
   }
   
    // Get Y coordinate and return y
   public int getY(){
       return y;
   }
   
   // Set Y 
   public void setY(int y){
       this.y = y;
   }
   
   // Get width and return width
   public int getWidth(){
       return width;
   }
   
   // Set Width
   public void setWidth(int width){
       this.width = width;
   }
   
   // Get depth and return depth
   public int getDepth(){
       return depth;
   }
   
   // Set Depth
   public void setDepth(int depth){
       this.depth = depth;
   }
   
   // Text plot and return string
   public String toString(){
       return "Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth;
   }
}