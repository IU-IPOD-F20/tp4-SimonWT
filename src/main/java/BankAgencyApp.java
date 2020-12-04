

import java.util.Locale;
import java.util.Scanner;

import application.action.Action;
import application.action.ActionList;
import application.actionlist.GenericActionList;
import application.action.ActionAccountsLists;
import application.action.ActionSeeAccountNumber;

import bank.BankAgency;
import bank.Account;
import bank.exception.AccountException;
import application.AccesBankAgency;

public class BankAgencyApp {

	public static void main(String argv[]) {
		BankAgency myAgency = AccesBankAgency.getBankAgency();

		ActionList mainMenu = new GenericActionList("1", "Menu of Tinkoff Bank (Kazan)", "Menu of Tinkoff Bank (Kazan)");

		Action accountsList = new ActionAccountsLists("a", "List of all available accounts");
		Action getAccountsByNumber = new ActionSeeAccountNumber("b", "Get account by a number");

		mainMenu.addAction(accountsList);
		mainMenu.addAction(getAccountsByNumber);

		try {
            mainMenu.execute(myAgency);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
	}
}
