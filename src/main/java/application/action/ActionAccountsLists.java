package application.action;
import bank.BankAgency;

public class ActionAccountsLists implements Action  {

    private String code;
    private String message;

    public ActionAccountsLists(String code, String message){
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
        ag.print();
    };
}