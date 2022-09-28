package Java2_Assignment;

class InsufficientAmountException extends Exception {
    public InsufficientAmountException(String message) {
        super(message);
    }
}

public class Bank {
    long Account_No;
    String Account_name;

    enum AccountType {
        Saving, Current
    }

    int ROI;
    long Amount;

    void setAccountname(String Accname) {
        this.Account_name = Accname;
    }

    void getROI() {
        System.out.println(this.ROI);
    }

    void getAccName() {
        System.out.println(this.Account_name);
    }


    String withrdaw(int wd) {

        try {
            if (this.Amount >= wd) {
                this.Amount = this.Amount - wd;
                return ("sucess check_log.txt \n");
            } else {
                throw new InsufficientAmountException("Exception");
            }
        } catch (InsufficientAmountException e) {
            return ("InsufficientAmountException Can't Deduct ");
        }

    }

    Bank(long accounNo, String accountname, long amount) {
        this.Account_No = accounNo;
        this.Account_name = accountname;
        this.Amount = amount;
    }


    String get_Details(int c) {
        String Actype = "";
        if (c == 1)
            Actype = String.valueOf(AccountType.Saving);
        else {
            Actype = String.valueOf(AccountType.Current);
        }
        return ("AccountName:" + this.Account_name + "\n" + "AccountNo :" + this.Account_No + "\n" + "Amount:" + this.Amount + "\n" + "AccountType:" + Actype + "\n" + "Rate of Interest :" + ROI + "\n");
    }
}

class BOI extends Bank {
    BOI(long accounNo, String accountname, long amount) {
        super(accounNo, accountname, amount);
        this.ROI = 12;
        System.out.println("BOI");
    }

}

class ICICI extends Bank {

    ICICI(long accounNo, String accountname, long amount) {
        super(accounNo, accountname, amount);
        this.ROI = 10;
        System.out.println("ICICI");
    }

}

class SBI extends Bank {
    SBI(long accounNo, String accountname, long amount) {
        super(accounNo, accountname, amount);
        this.ROI = 15;
        System.out.println("SBI");
    }

}