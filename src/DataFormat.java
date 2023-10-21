import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DataFormat {
    private static final Scanner in = new Scanner(System.in);
    private static final String PHONE_VALID = "^[0-9]{10}$";
    private static final String EMAIL_VALID = "^[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";
    public DataFormat() {
    }
    public String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }
    public String checkInputPhone() {
        while (true) {
            try {
                int phoneCheck = Integer.parseInt(in.nextLine());
                String resultCheck = String.valueOf(phoneCheck);
                if (!resultCheck.matches(PHONE_VALID)) {
                    System.err.println("Phone number must be 10 digits");
                    System.out.print("\nPhone number: ");
                } else {
                    return resultCheck;
                }
            } catch (NumberFormatException ex) {
                System.err.println("Phone number must is number");
                System.out.print("\nPhone number: ");
            }
        }
    }
    public String InputDateCheck() {
        Date inputDate = getDateInRightFormat();
        if (inputDate != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.format(inputDate);
        } else {
            System.out.println("Date to correct format(dd/mm/yyyy)");
            System.out.println("\nDate: ");
            return null;
        }
    }
    private static Date getDateInRightFormat() {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        Date inputDate = null;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Date: ");
            String str = sc.nextLine();
            try {
                inputDate = dateFormat.parse(str);
                validInput = true;
            } catch (ParseException ex) {
                System.out.println("Date to correct format(dd/mm/yyyy)");
            }
        }
        return inputDate;
    }
    public String checkInputEmail() {
        while (true) {
            String emailCheck = checkInputString();
            if (!emailCheck.matches(EMAIL_VALID)) {
                System.err.println("Email must be correct format");
                System.out.print("\nEmail: ");
            } else {
                return emailCheck;
            }
        }
    }
    public void display() {
        System.out.println("====== Validate Program ======");
        System.out.print("Phone number: ");
        String phone = checkInputPhone();
        System.out.print("Email: ");
        String email = checkInputEmail();
        String date = InputDateCheck();
    }
}