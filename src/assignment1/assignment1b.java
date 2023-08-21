package assignment1;

public class assignment1b {
    public static void main(String[] args) {
        // Declare and print original sentence.
        String Sentence = "The quick brown fox jumps over the lazy dog.";
        System.out.println(Sentence);
        
        // Print uppercase sentence.
        System.out.println(Sentence.toUpperCase());
        
        // Find and print the length of sentence.
        System.out.println(Sentence.length());
        
        // Find and print number of words.
        String [] words = Sentence.split(" ");
        System.out.println(words.length);
        
        // Determines if Sentence contains "big".
        System.out.println(Sentence.contains("big"));
        
        // Determines if sentence contains "jump".
        System.out.println(Sentence.contains("jump"));
        
        // Determines if sentence ends with a period.
        System.out.println(Sentence.endsWith("."));
        
        // Prints the first ten characters of sentence.
        System.out.println(Sentence.substring(0, 9));
        
        // Replaces spaces with underscores.
        System.out.println(Sentence.replace(" ", "_"));
    }
}