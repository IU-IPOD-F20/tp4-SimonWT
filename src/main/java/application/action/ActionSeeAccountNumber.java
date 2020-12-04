package application.action;
import bank.BankAgency;
import bank.Account;

import java.util.Locale;
import java.util.Scanner;

public class ActionSeeAccountNumber implements Action<BankAgency>  {

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

	public void execute(BankAgency ag) throws Exception {
        Scanner lect ;
        String number;
		Account c;
        lect = new Scanner( System.in );
		lect.useLocale(Locale.US);
        System.out.print("Account Number -> ");
        number = lect.next();
        c = ag.getAccount(number);
        if (c==null) {
            System.out.println("Account non existing ...");
        } else {
            c.print();
        }
    };
}