//java byte steam
import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class StoreNumbers {
    public static void main(String[] args) {

        // Step 0: Check command line argument
        if (args.length != 1) {
            System.out.println("Usage: java WriteIntegersUsingStream <filename>");
            return;
        }

        String fileName = args[0];
        Scanner scanner = new Scanner(System.in);

        try {
            // Step 1: Read n
            System.out.print("Enter number of elements (n > 0): ");
            int n = scanner.nextInt();

            if (n <= 0) {
                System.out.println("Invalid input. n must be greater than 0.");
                return;
            }

            int[] arr = new int[n];

            // Step 2: Read n integers
            System.out.println("Enter " + n + " integers:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            // Step 3: Create streams (overwrite mode)
            FileOutputStream fos = new FileOutputStream(fileName);
            DataOutputStream dos = new DataOutputStream(fos);

            // Step 4: Write n
            dos.writeInt(n);

            // Step 5: Write n integers
            for (int i = 0; i < n; i++) {
                dos.writeInt(arr[i]);
            }

            // Step 6: Close streams
            dos.close();
            fos.close();

            System.out.println("Data successfully written to file: " + fileName);

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
