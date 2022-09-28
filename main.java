package Java2_Assignment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Scanner;


public class main {
    static StringBuilder str1 = new StringBuilder();


    public static void cases(Bank User, int c) {
        LocalDateTime time = LocalDateTime.now();
        Scanner sc = new Scanner(System.in);
        log_Maker(User.get_Details(c));
        System.out.println(User.get_Details(c));
        System.out.println("Want to Withdraw press Y || y");
        int x = sc.next().charAt(0);
        if (x == 'y' || x == 'Y') {
            System.out.println("EnterAmount You want to deduct");
            log_Maker("Deduction @" + "time :" + time);
            int f = sc.nextInt();
            log_Maker(Integer.toString(f));
            log_Maker("\n" + User.withrdaw(f));
            log_Maker("\n Amount AVAILABLE :" + User.Amount);
        } else
            System.exit(0);
    }

    public static void Display() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Bank ACCOUNT Type 1 for Saving  2 for Current");
        int c = sc.nextInt();
        System.out.println("press 1 for sbi_roi details \n " + "press 2 for boi_roi details \n" + "press 3 for icici_roi details \n");
        int ch = sc.nextInt();

        switch (ch) {
            case 1: {
                Bank b = new SBI(12211, "sumit", 2000);
                cases(b, c);
            }
            break;
            case 2: {
                Bank b = new BOI(12211, "sumit", 2000);
                cases(b, c);
            }

            break;
            case 3: {
                Bank b = new ICICI(12211, "sumit", 2000);
                cases(b, c);
            }
            break;
            default:
                System.out.println("Error");
                break;
        }

    }

    public static void log_Maker(String str) {
        str1.append(str);
        try {

            BufferedWriter fw = new BufferedWriter(new FileWriter("log.txt"));

            for (int i = 0; i < str1.length(); i++)
                fw.write(str1.charAt(i));
            fw.close();

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void main(String[] args) {
        Display();
    }
}