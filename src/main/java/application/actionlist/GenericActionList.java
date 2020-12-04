
package application.actionlist;
import application.action.ActionList;
import application.action.Action;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.LinkedList;

import bank.BankAgency;

public class GenericActionList implements ActionList<BankAgency> {
    private String code;
    private String message;
    private String title;
    private List<Action<BankAgency>> actionlist;

    public GenericActionList(String code, String message, String title){
        this.code = code;
        this.message = message;
        this.title = title;
        this.actionlist = new LinkedList<Action<BankAgency>>();
    }

    @Override
    public String listTitle(){
        return this.title;
    };

    @Override
	public int size(){
        return actionlist.size();
    };

    @Override
	public boolean addAction(Action<BankAgency> ac){
        return this.actionlist.add(ac);
    };

    @Override
    public String actionMessage (){
        return this.message;
    };

    @Override
	public String actionCode (){
        return this.code;
    };

    public static void tempo() {
		Scanner lect ;

		lect = new Scanner (System.in );

		System.out.print("Type any car + return to continue ... ");
        lect.next(); 
	};

    @Override
    public void execute(BankAgency ag) throws Exception{
        Scanner lect ;
        String choice ;
        lect = new Scanner( System.in );
        lect.useLocale(Locale.US);
        while(true){
            System.out.print("\n" + "Menu of " + listTitle()+"\n");
            for(Action<BankAgency> action: actionlist){
                System.out.print(action.actionCode() + " - " + action.actionMessage() + "\n");
            }
            System.out.print("q - Quit\n");
            System.out.print("Choice -> ");
            choice = lect.next();
            choice = choice.toLowerCase();
            if(choice.charAt(0) == 'q'){
                return ;
            }else{
               for (int i = 0; i < size(); i++) {
                   if(actionlist.get(i).actionCode().equals(choice)){
                        actionlist.get(i).execute(ag);
                        tempo();
                   }
               }
            }
        }
    };
}