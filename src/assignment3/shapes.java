// Assignment 3a DONE
package assignment3;
import java.util.*;

public class shapes {
    public static void main(String[] args) {
        // Declare scanner.
        Scanner in = new Scanner(System.in);

        // Ask user for pyramid height.
        System.out.print("Input pyramid width (meters) >> ");
        double pyramidWidth = in.nextDouble();
        // Ask user for pyramid length.
        System.out.print("Input pyramid height (meters) >> ");
        double pyramidHeight = in.nextDouble();
        System.out.println();

        // Declare instance of pyramid.
        Pyramid pyramid1 = new Pyramid(pyramidWidth, pyramidHeight);

        // Print pyramid volume.
        System.out.println("Pyramid volume is " + pyramid1.getVolume() + " cubic meters.");
        // Print pyramid surface area.
        System.out.println("Pyramid surface area is " + pyramid1.getSurfaceArea() + " square meters.");
        System.out.println();

        // Ask user for cone radius.
        System.out.print("Input cone radius (meters) >> ");
        double coneRadius = in.nextDouble();
        // Ask user for cone height.
        System.out.print("Input cone height (meters) >> ");
        double coneHeight = in.nextDouble();
        System.out.println();

        // Declare instance of cone.
        Cone cone1 = new Cone(coneRadius, coneHeight);

        // Print cone volume.
        System.out.println("Cone volume is " + cone1.getVolume() + " cubic meters.");
        // Print cone surface area.
        System.out.println("Cone surface area is " + cone1.getSurfaceArea() + " square meters.");
    }
}

class Pyramid {
    // Variables
    public double Width;
    public double Height;

    // Constructor
    public Pyramid (double W, double H){
        Width = W;
        Height = H;
    }

    // Volume method
    double getVolume() {
        return Math.pow(Width, 2) * (Height / 3);
    }

    // Surface area method
    double getSurfaceArea() {
        return Math.pow(Width, 2) + 2 * Width * Math.sqrt(Math.pow(Width, 2) / 4 + Math.pow(Height, 2));
    }
}

class Cone {
    // Variables
    public double Radius;
    public double Height;

    // Constructor
    public Cone(double R, double H) {
        Radius = R;
        Height = H;
    }

    // Volume method
    double getVolume() {
        return Math.PI * Math.pow(Radius, 2) * (Height / 3);
    }

    // Surface area method
    double getSurfaceArea() {
        return Math.PI * Radius * (Radius + Math.sqrt(Math.pow(Height, 2) + Math.pow(Radius, 2)));
    }
}