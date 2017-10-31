import java.util.Scanner;
//
public class Test3M {
            
    private Test3M() { /* Class does not define a type of object. */}
    
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
        
        // Load input values into the list.
        final LinkedList list = new Solution();
        loadList(scanner, list);
        
        scanner.close();
        
        // Print list.
        System.out.println("List: "+list);
        // Execute method and print result.
        int result = ((Solution)list).sumEven();
        System.out.println("The sum of the even numbers is "+result+".");
    }
}