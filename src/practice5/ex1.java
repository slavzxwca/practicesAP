package practice5;

public class ex1 {
    public static void main(String[] args){
        double a = 3.4;
        double b = 1.1;
        double c = 9;

        double x = a * Math.pow(Math.E, b * c) * Math.cos(b);
        double y = 0.315 * Math.sqrt((a * Math.pow(c, 3)) / b);

        System.out.println("x = " + x);
        System.out.println("y = " + y);


    }
}



