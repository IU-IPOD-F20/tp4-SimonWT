
package application.action;
import application.action.ActionList;
import application.action.Action;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.LinkedList;
import java.io.PrintStream;

public class SomeActionList<E> implements ActionList<E> {
    private String code;
    private String message;
    private String title;
    private List<Action<E>> actionlist;

    public SomeActionList(String code, String message, String title){
        this.code = code;
        this.message = message;
        this.title = title;
        this.actionlist = new LinkedList<Action<E>>();
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
	public boolean addAction(Action<E> ac, int index) throws IndexOutOfBoundsException{
        try{
            Action<E> current = this.actionlist.get(index);
            return false;
        }catch (Exception e){
            this.actionlist.add(index, ac);
            return true;
        } 
    };

    @Override
    public boolean removeAction(int index) throws IndexOutOfBoundsException{
        try{
            this.actionlist.remove(index);
            return true;
        }catch (Exception e){
            return false;
        } 
    };

	@Override
	public boolean removeAction(Action<E> ac){
        try{
            this.actionlist.remove(ac);
            return true;
        }catch (Exception e){
            return false;
        } 
    };

	@Override
	public String[] listOfActions(){
        String[] array = new String[this.size()];
        for (int i = 0; i < this.size(); i++) {
            array[i] = this.actionlist.get(i).actionMessage();
        }
        return array;
    };

    @Override
    public String actionMessage (){
        return this.message;
    };

    @Override
	public String actionCode (){
        return this.code;
    };

    public static void tempo(Scanner lect, PrintStream sout) {
		
		sout.print("Type any car + return to continue ... ");
        lect.next(); 
	};

    @Override
    public void execute(E e) throws Exception{
        Scanner lect = e.getScanner();
        PrintStream sout = e.getPrintStream();
        String choice ;
        while(true){
            sout.print("\n" + "Menu of " + listTitle()+"\n");
            for(Action<E> action: actionlist){
                sout.print(action.actionCode() + " - " + action.actionMessage() + "\n");
            }
            sout.print("q - Quit\n");
            sout.print("Choice -> ");
            choice = lect.next();
            choice = choice.toLowerCase();
            if(choice.charAt(0) == 'q'){
                return ;
            }else{
               for (int i = 0; i < size(); i++) {
                   if(actionlist.get(i).actionCode().equals(choice)){
                        actionlist.get(i).execute(e);
                        tempo(lect, sout);
                   }
               }
            }
        }
    };
} 