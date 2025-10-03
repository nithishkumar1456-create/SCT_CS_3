import java.util.Scanner;

public class Password {

    public static void checkPasswordStrength(String pass) {
        boolean lengthError = pass.length() < 8;
        boolean lowercaseError = !pass.matches(".*[a-z].*");
        boolean uppercaseError = !pass.matches(".*[A-Z].*");
        boolean digitError = !pass.matches(".*[0-9].*");
        boolean specialCharError = !pass.matches(".*[!@#$%^&*(),.?\":{}|<>].*");

        int score = 0;
        if (!lengthError) score++;
        if (!lowercaseError) score++;
        if (!uppercaseError) score++;
        if (!digitError) score++;
        if (!specialCharError) score++;

        String strength;
        if (score == 5) {
            strength = "Your password is very strong";
        } else if (score >= 3) {
            strength = "your password is Medium , try to change!  ";
        } else {
            strength = "your password is very Weak, you must change it!";
        }

      
        System.out.println("\nPassword: " + pass);
        System.out.println("Strength: " + strength);

    
        if (lengthError) System.out.println(" Password should be at least 8 characters long.");
        if (lowercaseError) System.out.println("Add lowercase letters.");
        if (uppercaseError) System.out.println("Add uppercase letters.");
        if (digitError) System.out.println("Add digits (0-9).");
        if (specialCharError) System.out.println("Add special characters (!@#$ etc.).");
    }

   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a password to check: ");
        String pwd = sc.nextLine();
        checkPasswordStrength(pwd);
        sc.close();
    }
}
