

import java.util.Locale;
import java.util.Scanner;

import application.action.Action;
import application.action.ActionList;
import application.action.SomeActionList;
import application.action.ActionAccountsLists;
import application.action.ActionSeeAccountNumber;

import bank.BankAgency;
import bank.Account;
import bank.exception.AccountException;
import application.AccesBankAgency;

public class BankAgencyApp {

	public static void main(String argv[]) {
		BankAgency myAgency = AccesBankAgency.getBankAgency();

		ActionList<BankAgency> mainMenu = new SomeActionList<BankAgency>("1", "Menu of Tinkoff Bank (Kazan)", "Menu of Tinkoff Bank (Kazan)");

		Action<BankAgency> accountsList = new ActionAccountsLists("a", "List of all available accounts");
		Action<BankAgency> getAccountsByNumber = new ActionSeeAccountNumber("b", "Get account by a number");

		mainMenu.addAction(accountsList, 0);
		mainMenu.addAction(getAccountsByNumber, 1);

		try {
            mainMenu.execute(myAgency);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
	}
}
