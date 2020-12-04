package application;

import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

import bank.BankAgency;
import bank.Account;
import bank.exception.ABAccountAlreadyExistingException;
import bank.exception.ABNullAccountException;

public class ApplicationContextBankAgency {
    private Scanner scanner;
    private PrintStream printStream;
    private BankAgency bankAgency;

    private static ApplicationContextBankAgency instance;

    private ApplicationContextBankAgency(){
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        setScanner(scanner);
        setPrintStream(new PrintStream(System.out));
        bankAgency = createBankAgency();
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setPrintStream(PrintStream printStream) {
        this.printStream = printStream;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public PrintStream getPrintStream() {
        return printStream;
    }

    public static ApplicationContextBankAgency getInstance() {
        if (instance == null){
            instance = new ApplicationContextBankAgency();
        }
        return instance;
    }

    public BankAgency getBankAgency () {
		return this.bankAgency;
    }
    
    private BankAgency createBankAgency() {
        // To be done : load it from file
		// Not yet implemented, just a stub
		
		BankAgency ag = new BankAgency("In progress", "Innopolis");
		
		try {
			ag.addAccount(new Account("010101", "Durand"));
			ag.addAccount(new Account("010102", "Durand"));
			
			ag.addAccount(new Account("050501", "Leon"));
			ag.addAccount(new Account("050502", "Leon"));
			ag.addAccount(new Account("050503", "Leon"));			
			ag.addAccount(new Account("090904", "Zeste"));
			ag.addAccount(new Account("090905", "Zeste"));
			
		} catch (ABNullAccountException e) {
			throw new RuntimeException();
		} catch (ABAccountAlreadyExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ag;
    }

}
