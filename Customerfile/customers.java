package Customerfile;
import java.lang.*;
import java.io.*;
import java.util.Scanner;
import Interface.*;

public class customers implements ICustomers{
	customer customerList[] = new customer[1000];
	static int customerCount = 0;
	
	public customers(){
		
		try{
			File file = new File("Data\\customer_data.txt"); 
			Scanner sc = new Scanner(file);
				while(sc.hasNext()){
					String line1 = sc.nextLine();  
					String line2 = sc.nextLine();  
					String line3 = sc.nextLine();  
					String line4 = sc.nextLine();  
					
					
					customer c = new customer(line1,line2,line3);
					customerList[customerCount] = c; customerCount++;
					System.out.println(customerCount+"#########################");
				}
			sc.close();  		
		}catch(Exception ex){
			System.out.println("File not found.");
			return;
		}
	}
	
	public int customerExists(String email){
		int index = -1; 
		for(int i=0;i<customerCount;i++){
			if(customerList[i].getEmail().equals(email)){
				index = i; 
				break;
			}
		}
		return index; 
	}
	
	public customer checkCredentials(int index, String pass){
		if((customerList[index].getPassword().equals(pass))){
			return customerList[index]; 
		}else{return null;}        
	}
	
	public customer getCustomer(int index){
		return customerList[index];
	}
	
	public void addCustomer(customer c){
		
		customerList[customerCount] = c;
		customerCount++;
		
		
		String customerDetails=c.getEmail() + "\n" + c.getPassword() + "\n"+
						   c.getPhone() + "\n" + "\n";
		try{
			FileWriter fw = new FileWriter("Data\\customer_data.txt",true);
			fw.write(customerDetails);
			fw.close();
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
	
}