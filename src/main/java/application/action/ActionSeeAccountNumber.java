package application.action;
import bank.BankAgency;
import bank.Account;

import java.util.Locale;
import java.util.Scanner;
import java.io.PrintStream;

import application.ApplicationContextBankAgency;

public class ActionSeeAccountNumber implements Action<ApplicationContextBankAgency>  {

    private String code;
    private String message;

    public ActionSeeAccountNumber(String code, String message){
        this.code = code;
        this.message= message;
    }
	
	public String actionMessage (){
        return message;
    };

	public String actionCode (){
        return code;
    };

	public void execute(ApplicationContextBankAgency e) throws Exception {
        Scanner lect ;
        PrintStream sout;
        String number;
		Account c;
        lect = e.getScanner();
        sout = e.getPrintStream();
        sout.print("Account Number -> ");
        // System.out.print("Account Number -> ");
        number = lect.next();
        c = e.getBankAgency().getAccount(number);
        if (c==null) {
            System.out.println("Account non existing ...");
        } else {
            c.print();
        }
    };
}