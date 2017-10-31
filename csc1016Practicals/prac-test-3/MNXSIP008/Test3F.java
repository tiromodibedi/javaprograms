import java.util.Scanner;
//
public class Test3F {
            
    private Test3F() { /* Class does not define a type of object. */}
    
    private static void loadList(final Scanner scanner, final LinkedList list) {
        if (scanner.hasNextInt()) {
            final int value = scanner.nextInt();
            loadList(scanner, list);
            list.add(value);
        }
    }
    
    public static void main(final String[] args) {
        
        // Create a scanner that processes a single line of input.
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) { scanner = new Scanner(scanner.nextLine());}
        
        // First value is the test argument to be used in the method.
        final int  testArg = scanner.nextInt();
        // Rest of the values form the list.
        final LinkedList list = new Solution();
        loadList(scanner, list);
        
        scanner.close();
        
        // Print list.
        System.out.println("List: "+list);
        // Execute method and print result.
        System.out.print("The number of values that are a factor of "+testArg+" is ");
        final int num = ((Solution)list).numFactorsOf(testArg);
        System.out.println(num+".");
    }
}
