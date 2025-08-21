import java.lang.*;
import Customerfile.*;
import GUI.*;
public class Run{
	public static void main(String[] args){
		customers cs = new customers();
		login lg = new login(cs);
		lg.setVisible(true);
	}
}