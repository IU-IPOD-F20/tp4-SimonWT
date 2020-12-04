package application.action;
import bank.BankAgency;
import application.ApplicationContextBankAgency;

public class ActionAccountsLists implements Action<ApplicationContextBankAgency>  {

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

	public void execute(ApplicationContextBankAgency ag) throws Exception {
        ag.getBankAgency().print();
    };
}