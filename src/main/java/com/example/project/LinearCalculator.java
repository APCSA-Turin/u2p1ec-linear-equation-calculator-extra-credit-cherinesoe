package com.example.project;
public class LinearCalculator{
    //FOR EXTRA CREDIT 
    //you should copy and paste all of your code from the LinearCalculator class
    // but NOT printInfo(). Please update it below
    //INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2)
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String coord1, String coord2){ // <--add 2 string parameters to this constructor
        //searches for the index of the comma within the first String
        int idx1 = coord1.indexOf(",");
        //singles out the numbers within the first String and converts them to an integer
        x1 = Integer.parseInt(coord1.substring(1, idx1));
        y1 = Integer.parseInt(coord1.substring(idx1 + 1, coord1.length() - 1));

        //searches for the index of the comma within the second String
        int idx2 = coord2.indexOf(",");
        //singles out the numbers within the second String and converts them to an integer
        x2 = Integer.parseInt(coord2.substring(1, idx2));
        y2 = Integer.parseInt(coord2.substring(idx2 + 1, coord2.length() - 1));
    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){return x1;}
    public int getY1(){return y1;}
    public int getX2(){return x2;}
    public int getY2(){return y2;}
    //sets new value to corresponding x or y
    public void setX1(int newX1){
        x1 = newX1;
    }
    public void setY1(int newY1){
        y1 = newY1;
    }
    public void setX2(int newX2){
        x2 = newX2;
    }
    public void setY2(int newY2){
        y2 = newY2;
    }

    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        //calculates distance using the distance formula
        double dist = Math.sqrt(Math.pow(x2 - x1,2) + Math.pow(y2 - y1, 2));
        dist = roundedToHundredth(dist);
        return dist;
    }
    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
        if (slope() == -999.99) {
            return -999.99;
        }
        //calculates y intercept by inputting a point and subtracting slope times the x value
        double yInt = y1 - slope() * x1;
        //rounds y intercept to nearest hundredth
        yInt = roundedToHundredth(yInt);
        return yInt;
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        if ((x2 - x1) == 0) {
            return -999.99;
        }
        //calculates slope based on change in y and x
        double slope = ((double) y2 - y1) / ((double) x2 - x1);
        slope = roundedToHundredth(slope);
        return slope;
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        //checks if slope is equal to -999.99 and returns undefined if it is
        if (slope() ==  -999.99) {
            return "undefined";
        }
        if (slope() == 0) {
            return "y=" + yInt();
        }
        if (yInt() == 0) {
            return "y=" + slope() + "x";
        }
        if (yInt() < 0) {
            return "y=" + slope() + "x" + yInt();
        }
        return "y=" + slope() + "x+" + yInt();
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        double rounded = Math.round(x * 100.0) / 100.0;
        return rounded;
    }


    //You will need to concatenate to the string 
    //the results from findSymmetry() and Midpoint()
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1  + ")";
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
        str += "\n" + findSymmetry();
        str += "\n" + Midpoint();
 
        return str;
    }

    //findSymmetry()-> returns a string 
    //the method should determine if there is symmetry between the two points
    // there should be  4 return statements 
    // return "Symmetric about the x-axis";
    // return "Symmetric about the y-axis";
    //return "Symmetric about the origin";
    //return "No symmetry";
    public String findSymmetry(){
        if (x1 == x2 && Math.abs(y1) == Math.abs(y2)) {
            return "Symmetric about the x-axis";
        } else if (y1 == y2 && Math.abs(x1) == Math.abs(x2)) {
            return "Symmetric about the y-axis";
        } else if (Math.abs(x1) == Math.abs(x2) && Math.abs(y1) == Math.abs(y2)) {
            return "Symmetric about the origin";
        }
        return "No symmetry";
    }

    //Midpoint()->return a string 
    //the method should calculate the midpoint between the two points
    //it should return "The midpoint of this line is: (0,0)";
    public String Midpoint(){
        double midX = (x2 + x1) / 2;
        double midY = (y2 + y1) / 2;
        return "The midpoint of this line is: (" + midX + "," + midY + ")";
    }

}



