import java.util.*;
class main{
	static Scanner input = new Scanner(System.in);
	static String[] cred = {"Malka", "123"};
	static String[][]Supplier =new String[0][2];
	static String[] itemCat =new String[0];
	static String[][] addItem =new String[0][6];
	
public static void UpdateItemCategory() {
	
 System.out.println();
    System.out.println("\t\t====================================");
    System.out.println("\t\t\t  Update Item Category     ");
    System.out.println("\t\t====================================");
    System.out.println();
     boolean x=false;
	 System.out.print("Enter the category to update: ");
    String categoryToupdate = input.next();
    
    for(int i=0;i<itemCat.length;i++){
		if(categoryToupdate.equals(itemCat[i])){
			x=true;
		 System.out.print("Enter your new category name : ");
		 String NewName=input.next();
		 itemCat[i]=NewName;
		  System.out.print("Updated Successfully! Do you want to update another category?(y/n) : ");
            String answer = input.next();

            switch (answer) {
                case "y":
                clearConsole();
                    UpdateItemCategory();
                    break;
                case "n":
                clearConsole();
                    ManageItemCategories();
                    break;
                default:
                    System.out.println("No Option.");
                    break;
            }
		}
	}
	if(!x){
		System.out.println("can't find supplier id.try again!");
		
	}
}

public static void DeleteItemCategory() {
   clearConsole();
    System.out.println();
    System.out.println("\t\t====================================");
    System.out.println("\t\t\t  DELETE Item Category     ");
    System.out.println("\t\t====================================");
    System.out.println();

    boolean itemFound = false;
    int index = -1;

    System.out.print("Enter the category to delete: ");
    String categoryToDelete = input.next();

    for (int i = 0; i < itemCat.length; i++) {
        if (categoryToDelete.equals(itemCat[i])) {
            itemFound = true;
            index = i;
            break;
        }
    }

    if (itemFound) {
        String[] temp = new String[itemCat.length - 1];

        for (int i = 0, j = 0; i < itemCat.length; i++) {
            if (i != index) {
                temp[j++] = itemCat[i];
            }
        }

        itemCat = temp;

        System.out.println("Category deleted successfully!");

        System.out.print("Do you want to delete another category? (y/n): ");
        String confirmation = input.next();

        switch (confirmation) {
            case "y":
                clearConsole();
                DeleteItemCategory();
                break;
            case "n":
               clearConsole();
                ManageItemCategories();
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    } else {
        System.out.println("Category not found.");
        ManageItemCategories();
    }
}

public static void AddNewItemCategory(){
	clearConsole();
		
		Scanner input=new Scanner(System.in);
		
		System.out.println("          =============================================================");
		System.out.println("          |                   ADD ITEM CATEGORIES                     |");
		System.out.println("          =============================================================");
		System.out.println();


		
		boolean Equals=false;
        do{
		System.out.print("Enter the new item category: ");
		String ItemCat=input.nextLine();

        for (int i = 0; i <itemCat.length; i++){
		Equals=ItemCat.equals(itemCat[i]);
	
	
		if(Equals){
			System.out.println("Item category has already exists. Try another category");
			break;
			}
		}
		if(!Equals){
			CatGrow();
			
			itemCat[itemCat.length-1]=ItemCat;
			 
			 System.out.print("Added successfully!.");
              break;  
              
			  }		
			
			}while(!Equals);
			
		System.out.print("Do you want to Add another Category (y/n): ");
		String option = input.nextLine();

		switch (option) {
			case "y":
			clearConsole();
				AddNewItemCategory();
				break;
			case "n":
			clearConsole();
				ManageItemCategories();
				break;
			default:
			
				System.out.println("No Option.");
			homePage(cred);
             
		    }
		}
		
    public static void CatGrow(){
		String[] temp = new String[itemCat.length + 1];
		for (int i = 0; i < itemCat.length; i++) {
        temp[i] = itemCat[i];
		}
		itemCat = temp;
	}
public static void RankItemsPerUnitPrice (){
	
	
}	 
	 
public static void ViewItems(){
	
}	 
	 
public static void  GetItemsSupplierWise(){
	System.out.println();
	System.out.println("            =============================================================");
	System.out.println("                           Get Items Supplier Wise                    ");
		System.out.println("            =============================================================");
		System.out.println();
		
		boolean x =false;
		System.out.print("Enter your supplier id : ");
		String num=input.next();
		for(int i=0;i<Supplier.length;i++){
		if(num.equals(Supplier[i][0])){
			System.out.println("Supplier Name: "+Supplier[i][1]);
			x=true;
			break;
		}
	}
			
	
	
}
public static void AddItem() {
	clearConsole();
	System.out.println("          =============================================================");
		System.out.println("                             ADD ITEM                      ");
		System.out.println("          =============================================================");
		System.out.println();
        if (itemCat.length == 0 || itemCat[0] == null) {
            System.out.println("OOPS! It seems that you don't have any item category in the System.");
            System.out.print("Do you want to add a new item category?(y/n):");
            String option = input.next();

            switch (option) {
                case "y":
                    clearConsole();
                    AddNewItemCategory();
                    break;
                case "n":
                    clearConsole();
                   StokeManage();
                    break;
                default:
                   clearConsole();
                    System.out.println("No Option.");
                   break;
            }
        } else if (Supplier.length == 0 || Supplier[0] == null) {
            System.out.println("OOPS! It seems that you don't have Suppliers in the System.");
            System.out.print("Do you want to add a new Supplier category?(y/n): ");
            String option = input.next();

            switch (option) {
                case "y":
                    clearConsole();
                    AddSupplier();
                    break;
                case "n":
                    clearConsole();
                    StokeManage();
                    break;
                default:
                   clearConsole();
                    System.out.println("No Option.");
                    break;
            }
        }

        System.out.print("Input Item Code: ");
        String code = input.next();

		boolean itemExists = false;

		for (int i = 0; i < addItem.length; i++) {
			if (code.equals(addItem[i][5])) {
				itemExists = true;
				System.out.println("Item code already exists. Try another Item code!");
				break;
			}
		}

		if (!itemExists) {
			displaySuppliers();

			System.out.print("Enter the supplier number: ");
			int suNum = input.nextInt();
			input.nextLine();

		   if (suNum >= 1 && suNum <= Supplier.length) {
		
				addItem = Arrays.copyOf(addItem, addItem.length + 1);
		
				addItem[addItem.length - 1] = new String[6];
				
				addItem[addItem.length - 1][5] = code;
			
				addItem[addItem.length - 1][0] = Supplier[suNum - 1][0];
			} else {
				System.out.println("Invalid supplier number.");
				return;
			}

			displayCategories();

			System.out.print("Enter the category number: ");
			int catNum = input.nextInt();
			input.nextLine();

         if (catNum >= 1 && catNum <= itemCat.length) {
				addItem[addItem.length - 1][1] = itemCat[catNum - 1];
			} else {
				System.out.println("Invalid category number.");
				return;
			}

			System.out.print("Description: ");
			String Des = input.next();

			System.out.print("Unit price: ");
			String uPrice = input.next();
            int UnitPrice = Integer.parseInt(uPrice);
            
			System.out.print("Qty on hand: ");
			String Qty = input.next();

			// Assign the item details
			addItem[addItem.length - 1][2] = Des;
			
			
			addItem[addItem.length - 1][3] = String.valueOf(UnitPrice);
			addItem[addItem.length - 1][4] = Qty;

			System.out.println("Item added successfully!");
		}
		    System.out.print("Do you want to Add another Item (y/n): ");
			
	
			String option = input.next();
			switch (option) {
				case "y":
				clearConsole();
					AddItem();
					break;
				case "n":
				clearConsole();
					StokeManage();
					break;
				default:
				clearConsole();
					System.out.println("No Option.");
					break;
				 
           }	
		}

    public static void displaySuppliers() {
        System.out.printf("----------------------------------------------%n");
        System.out.printf("| %4s      | %-8s      | %-10s     |%n", " NO", " CODE ", "NAME");
        System.out.printf("----------------------------------------------%n");

        for (int i = 0; i < Supplier.length; i++) {
            System.out.printf("| %4s      | %-8s      | %-10s     |%n", (i + 1), Supplier[i][0], Supplier[i][1]);
            System.out.printf("----------------------------------------------%n");
        }
    }

    public static void displayCategories() {
        System.out.printf("------------------------%n");
        System.out.printf("| %4s   | %-10s  |%n", " NO", "CATEGORY");
        System.out.printf("------------------------%n");

        for (int i = 0; i < itemCat.length; i++) {
            System.out.printf("| %4s   | %-10s  |%n", (i + 1), itemCat[i]);
            System.out.printf("------------------------%n");
        }
    }

    public static void itemGrow() {
        String[][] temp = new String[addItem.length + 1][3];

        for (int i = 0; i < addItem.length; i++) {
            temp[i] = addItem[i];
        }

        addItem = temp;
    }
public static void ManageItemCategories(){

	 System.out.println();
			 System.out.println("\t\t====================================");
			 System.out.println("\t\t\t  Manage Item Categories     ");
			 System.out.println("\t\t====================================");
		     System.out.println();
		      System.out.println("[1] Add New Item Category          [2] Delete Item Category ");
			 System.out.println("[3] Update Items Category           [4] Stock Management ");
		     
		     System.out.print("Enter an option to continue > ");
			 int num =input.nextInt();
			  
			  switch(num){
			 
			 case 1 :
			 clearConsole();
			 AddNewItemCategory();
			 break;
			 case 2 :
			 clearConsole();
			 DeleteItemCategory();
			 break;
			 case 3 :
			 clearConsole();
			 UpdateItemCategory();
			 break;
			 case 4 :
			 clearConsole();
			 StokeManage();
			 break;
			 default:
			 System.out.println("Not Option");
			 break;
		 }
}
public static void StokeManage(){
	clearConsole();
		      System.out.println();
			 System.out.println("\t\t====================================");
			 System.out.println("\t\t\t  STOCK MANAGEMENT    ");
			 System.out.println("\t\t====================================");
		     System.out.println();
		     
		     System.out.println("[1] Manage Item Categories       [2] Add Item ");
			 System.out.println("[3] Get Items Supplier Wise      [4] View Items ");
			 System.out.println("[5] Rank Items Per Unit Price    [6] Home Page");
			 System.out.println();
			System.out.print("Enter an option to continue > ");
			 int num =input.nextInt();
			 switch(num){
			 
			 case 1 :
			 clearConsole();
			 ManageItemCategories();
			break;
			 case 2 :
			
			 AddItem();
			 break;
			 case 3 :
			 clearConsole();
			 GetItemsSupplierWise();
			 break;
			 case 4 :
			 clearConsole();
			 ViewItems();
			 case 5 :
			 clearConsole();
			 RankItemsPerUnitPrice ();
			 break;
			 case 6 :
			 clearConsole();
			 homePage(cred);
			 break;
			 default :
			 System.out.println("Not Option");
			 break;
		 }
}

public static void SearchSupplier(){
	clearConsole();
	 System.out.println("          =============================================================");
    System.out.println("                               SEARCH SUPPLIER                     ");
    System.out.println("          =============================================================");
       System.out.println();
    System.out.print("Supplier ID : ");
    String id=input.next();
    boolean supplierFound = false;
    for(int i=0;i<Supplier.length;i++){
		if(id.equals(Supplier[i][0])){
			 supplierFound = true;
			      System.out.println("Supplier Name : "+Supplier[i][1]);
			      break;
			  }
		  }
		  if(!supplierFound){
			System.out.println("can't find supplier id.try again!");
	}
			     
			      System.out.print("added successfully! Do you want to add another find(y/n)? ");
				String answer =input.next();
				switch(answer){
					case "y" : 
					clearConsole();
					SearchSupplier();
					break;
					case "n" :
					clearConsole();
					supplierManage();
					break;
					default :
					System.out.println("No Option");
					
					break;
				}	
}
public static void ViewSupplier(){
	clearConsole();
	 System.out.println("          =============================================================");
    System.out.println("                               VIEW SUPPLIER                     ");
    System.out.println("          =============================================================");
    System.out.println();
     
    System.out.println("------------------------------");
    System.out.printf("| %-10s | %-10s|%n","SUPPLIER ID","SUPPLIER NAME");
    System.out.println("------------------------------");
    for(int i=0;i<Supplier.length;i++){
    System.out.printf("| %-12s | %-12s|%n",Supplier[i][0],Supplier[i][1]);
   
	}
    System.out.printf("------------------------------");
    System.out.println();
     System.out.print(" DO you want to go supplier manage page(y/n)? ");
     String answer=input.next();
     switch(answer){
		 case "y" :
		 clearConsole();
		 supplierManage();
		 break;
		 case "n" :
		 clearConsole();
		System.out.println("Exiting the system. Goodbye!");
                System.exit(0);
		 break;
		 default :
		 System.out.println("No Option");
		 supplierManage();
		 break;
		 
	 }
    
}
public static void DeleteSupplier() {
    clearConsole();
    System.out.println("          =============================================================");
    System.out.println("                               DELETE SUPPLIER                     ");
    System.out.println("          =============================================================");
    boolean supplierFound = false;
    int index = -1;
    System.out.print("Enter Supplier ID : ");
    String id = input.next();

    for (int i = 0; i < Supplier.length; i++) {
        if (id.equals(Supplier[i][0])) {
            supplierFound = true;
            index = i;
            break;
        }
    }

    if (supplierFound) {
        String[][] temp = new String[Supplier.length - 1][2];

        for (int i = 0, j = 0; i < Supplier.length; i++) {
            if (i != index) {
                temp[j][0] = Supplier[i][0];
                temp[j][1] = Supplier[i][1];
                j++;
            }
        }

        Supplier = temp;

        System.out.println("Supplier deleted successfully!");

        System.out.print("Do you want to delete another supplier? (y/n): ");
        String confirmation = input.next();

        switch (confirmation) {
            case "y":
                clearConsole();
                DeleteSupplier();
                break;
            case "n":
              clearConsole();
                supplierManage();
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    } else {
        System.out.println("Supplier not found.");
        supplierManage();
    }
}

public static void UpdateSupplier() {
    clearConsole();
    System.out.println("          =============================================================");
    System.out.println("                               UPDATE SUPPLIER                     ");
    System.out.println("          =============================================================");
    System.out.println();
    System.out.print("Supplier Id : ");
    String id = input.next();

    boolean supplierFound = false;

    for (int i = 0; i < Supplier.length; i++) {
        if (id.equals(Supplier[i][0])) {
            supplierFound = true;
            System.out.println(Supplier[i][1]);
            System.out.print("Enter the new supplier name : ");
            String newName = input.next();
            Supplier[i][1] = newName;
            System.out.print("Updated Successfully! Do you want to update another supplier?(y/n) : ");
            String answer = input.next();

            switch (answer) {
                case "y":
                    clearConsole();
                    UpdateSupplier();
                    return;  // Move the return statement here
                case "n":
                    clearConsole();
                    supplierManage();
                    return;  // Move the return statement here
                default:
                    System.out.println("No Option.");
                    break;
            }
        }
    }

    if (!supplierFound) {
        System.out.println("Can't find supplier id. Try again!");
    }
}


public static void AddSupplier() {
	clearConsole();
		Scanner input = new Scanner(System.in);

		System.out.println("          =============================================================");
		System.out.println("                                   ADD SUPPLIER                        ");
		System.out.println("          =============================================================");
		System.out.println();

		boolean uniqueId = false;

		do {
			System.out.print("Input Supplier ID: ");
			String ID = input.next();

			for (int i = 0; i < Supplier.length; i++) {
				uniqueId = ID.equals(Supplier[i][0]);
                 
				if (uniqueId) {
					System.out.println("Supplier ID already exists. Try another supplier ID!");
				    System.out.println();
				    break;
				    
				}
			}

			if (!(uniqueId)) {
				System.out.print("Input Supplier NAME: ");
				String NAME = input.next();
				System.out.println();
				grow();

				Supplier[Supplier.length - 1][0] = ID;
				Supplier[Supplier.length - 1][1] = NAME;

				System.out.println("Supplier added successfully!");
				break;
			}

		} while (!uniqueId);
		

		System.out.print("Do you want to Add another Supplier (y/n): ");
		String option = input.next();

		switch (option) {
			case "y":
			clearConsole();
				AddSupplier();
				break;
			case "n":
			clearConsole();
			supplierManage();
				break;
			default:
			
				System.out.println("No Option.");
			homePage(cred);
			break;

		}
	}

	public static void grow() {
		String[][] temp = new String[Supplier.length + 1][2];
		for (int i = 0; i < Supplier.length; i++) {
			temp[i] = Supplier[i];
		}
		Supplier = temp;
	}	
	
	public static void supplierManage(){
		      System.out.println();
			 System.out.println("\t\t====================================");
			 System.out.println("\t\t\t  SUPPLIER MANAGE    ");
			 System.out.println("\t\t====================================");
		     System.out.println();
		     
		     System.out.println("[1] Add Supplier       [2] Update Supplier ");
			 System.out.println("[3] Delete Supplier    [4] View Supplier ");
			 System.out.println("[5] Search Supplier    [6] Home Page");
			 System.out.println();
			System.out.print("Enter an option to continue > ");
			 int num =input.nextInt();
			 switch(num){
			 
			 case 1 :
			 AddSupplier();
			break;
			 case 2 :
			 UpdateSupplier();
			 break;
			 case 3 :
			 DeleteSupplier();
			 break;
			 case 4 :
			 ViewSupplier();
			 case 5 :
			 SearchSupplier();
			 break;
			 case 6 :
			 homePage(cred);
			 break;
		 }
			 
	 }
	public static void logOut(String[] cred){ 
        System.out.println("Logout successful. Credentials reset to default.");
        loginPage();
	}
	
	public static void homePage(String[] cred){
			 clearConsole();
			 System.out.println();
			 System.out.println("\t\t============================================");
			 System.out.println("\t\t   WELCOME TO IJSE STOCK MANAGEMENT STSTEM     ");
			 System.out.println("\t\t============================================");
			
			 System.out.println("[1] Chage the Credentials      [2] Supplier Manage");
			 System.out.println("[3] Stock Manage               [4] Log out");
			 System.out.println("[5] Exit the system");
			 System.out.println();
			 System.out.print("Enter an option to continue > ");
			 int num =input.nextInt();
			 System.out.println();
			 switch(num){
				 case 1 :
				         while (true) {
                    System.out.print("Please enter the user name to verify it's you: ");
                    String name = input.next();

                    if (name.equals(cred[0])) {
                        System.out.println("HEY " + name);
                        System.out.println();
                        System.out.print("Enter your current password : ");
                        String pw = input.next();

                        if (pw.equals(cred[1])) {
                            System.out.println("Verification successful.");
                            
                            
                            System.out.print("Enter the new user name: ");
                           String  newNAME = input.next();
                            cred[0] = newNAME;

                            System.out.print("Enter the new password: ");
                          String  newPW = input.next();
                            cred[1] = newPW;
                            
                            System.out.println("Credentials updated successfully.");
                           
                            break;
                        } else {
                            System.out.println("Incorrect password. Try again.");
                        }
                    } else {
                        System.out.println("Invalid user name. Try again!");
                    }
                }
                break;
				 case 2 :
				clearConsole();
				 supplierManage();
				 
				 break;
				 
				 case 3 : 
				 clearConsole();
				 StokeManage();
				 break;
				 case 4 :
				 clearConsole();
				 logOut(cred);
				 break;
				 case 5 :
				 clearConsole();
				 System.out.println("Exiting the system. Goodbye!");
                 System.exit(0);
                break;
                default:
                System.out.println("Invalid option. Please try again.");
				 
			 }
			
	}
	public static void loginPage() {
			 System.out.println("\t\t\t====================");
			 System.out.println("\t\t\t     LOGIN PAGE     ");
			 System.out.println("\t\t\t====================");
	while(true){
		System.out.print("user name: ");
		String userName = input.next();
		
	    if(userName.equals(cred[0])){
		while(true){
			System.out.print("password: ");
		String pw = input.next();
		if(pw.equals(cred[1])){
			
			 homePage( cred);
			 break;
		}else{
			System.out.println("password is incorrect.please try again!");
			
		}
	}
		
		}	else{
			System.out.println("user name is invalid.please try again!");
		}	
	
	}
	
 
}
private final static void clearConsole() {
final String os = System.getProperty("os.name");
try {
if (os.equals("Linux")) {
System.out.print("\033\143");
} else if (os.equals("Windows")) {
new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
} else {
System.out.print("\033[H\033[2J");
System.out.flush();
}
} catch (final Exception e) {
//handle the exception
System.err.println(e.getMessage());
}
}
	
	public static void main(String args[]) {
		loginPage();
		homePage(cred);
	}
}
