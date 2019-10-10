package search;
import java.util.*;

public class searchHall {
	
	
	public static void main(String[] args) {
		search();
	}
	
	public static void search(){
		System.out.println("You can search by name,size,or price");
		System.out.println("Name press 1");
		System.out.println("Size press 2");
		System.out.println("Price press 3");
		
		Scanner input = new Scanner(System.in);
		Hall hallarr[] = new Hall[100];
		int choice = input.nextInt();
		
		if (choice == 1) {
			System.out.println("Enter the name");
		    String name = input.next();
		    for(int i = 0;i<hallarr.length;i++) {
		    	if(hallarr[i].getName().equals(name)) {
		    		System.out.println(hallarr[i]);
		    	}
		    	else
		    		System.out.println("Not found");
		    }
		}
		if (choice == 2) {
			System.out.println("Enter the size");
			String size = input.next();
			for(int i = 0;i<hallarr.length;i++) {
		    	if(hallarr[i].getName().equals(size)) {
		    		System.out.println(hallarr[i]);
		    	}
		    	else
		    		System.out.println("Not found");
		    }
		}
		if (choice == 3) {
			System.out.println("Enter the price");
			String price = input.next();
			for(int i = 0;i<hallarr.length;i++) {
		    	if(hallarr[i].getName().equals(price)) {
		    		System.out.println(hallarr[i]);
		    	}
		    	else
		    		System.out.println("Not found");
		    }
		}
		
	}

}
