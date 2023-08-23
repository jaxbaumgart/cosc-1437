// Assignment 2a DONE
package assignment2;
import java.util.Scanner;

public class sign {
    public static void main(String[] args) {
    // Scanner declaration.
    Scanner in = new Scanner(System.in);
    // Ask user for month.
    System.out.print("What month were you born (1-12)? >> ");
    int userMonth = in.nextInt();
    // Ask user for day.
    System.out.print("What day of the month were you born? >> ");
    int userDay = in.nextInt();
    System.out.println();
    // Output birthstone.
    String BirthstoneOutput = Birthstone(userMonth);
    System.out.println(BirthstoneOutput);
    // Output zodiac sign.
    String ZodiacOutput = ZodiacSign(userMonth, userDay);
    System.out.println(ZodiacOutput);
    }
    
    public static String Birthstone(int Month) {
        String birthstone = "";
        if (Month == 1) {
            birthstone = "Garnet";
        }
        if (Month == 2) {
            birthstone = "Amethyst";
        }
        if (Month == 3) {
            birthstone = "Aquamarine";
        }
        if (Month == 4) {
            birthstone = "Diamond";
        }
        if (Month == 5) {
            birthstone = "Emerald";
        }
        if (Month == 6) {
            birthstone = "Alexandrite";
        }
        if (Month == 7) {
            birthstone = "Ruby";
        }
        if (Month == 8) {
            birthstone = "Peridot";
        }
        if (Month == 9) {
            birthstone = "Sapphire";
        }
        if (Month == 10) {
            birthstone = "Tourmaline";
        }
        if (Month == 11) {
            birthstone = "Citrine";
        }
        if (Month == 12) {
            birthstone = "Tanzanite";
        }
        return "Your birthstone is " + birthstone + ".";
    }
    
    public static String ZodiacSign(int Month, int Day) {
        String Zodiac = "";
        if (Month == 1) {
            if (Day <= 19) {
                Zodiac = "Capricornus";
            } else {
                Zodiac = "Aquarius";
            }
        } else if (Month == 2) {
            if (Day <= 18) {
                Zodiac = "Aquarius";
            } else {
                Zodiac = "Pisces";
            }
        } else if (Month == 3) {
            if (Day <= 20) {
                Zodiac = "Pisces";
            } else {
                Zodiac = "Aries";
            }
        } else if (Month == 4) {
            if (Day <= 19) {
                Zodiac = "Aries";
            } else {
                Zodiac = "Taurus";
            }
        } else if (Month == 5) {
            if (Day <= 20) {
                Zodiac = "Taurus";
            } else {
                Zodiac = "Gemini";
            }
        } else if (Month == 6) {
            if (Day <= 22) {
                Zodiac = "Gemini";
            } else {
                Zodiac = "Cancer";
            }
        } else if (Month == 7) {
            if (Day <= 22) {
                Zodiac = "Cancer";
            } else {
                Zodiac = "Leo";
            }
        } else if (Month == 8) {
            if (Day <= 22) {
                Zodiac = "Leo";
            } else {
                Zodiac = "Virgo";
            }
        } else if (Month == 9) {
            if (Day <= 22) {
                Zodiac = "Virgo";
            } else {
                Zodiac = "Libra";
            }
        } else if (Month == 10) {
            if (Day <= 23) {
                Zodiac = "Libra";
            } else {
                Zodiac = "Scorpius";
            }
        } else if (Month == 11) {
            if (Day <= 21) {
                Zodiac = "Scorpius";
            } else {
                Zodiac = "Sagittarius";
            }
        } else if (Month == 12) {
            if (Day <= 21) {
                Zodiac = "Sagittarius";
            } else {
                Zodiac = "Capricornus";
            }
        }
        return "Your zodiac sign is " + Zodiac + ".";
    }
}
