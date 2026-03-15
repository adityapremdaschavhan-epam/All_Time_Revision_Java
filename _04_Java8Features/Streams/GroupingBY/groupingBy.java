package GroupingBy;

import java.util.*;
import java.util.stream.Collectors;

//1️⃣ groupingBy(classifier)
//2️⃣ groupingBy(classifier, downstream)
//3️⃣ groupingBy(classifier, mapFactory, downstream)

public class groupingBy {
// *******************************************************
	//1️⃣ groupingBy(classifier)
	public static void groupCustomerByCity(){

	// grouping by via default downstream toList();
	List<Customer> customers = List.of(
            new Customer(1, "Pune", "SAVINGS", 5000),
            new Customer(2, "Pune", "CURRENT", 20000),
            new Customer(3, "Mumbai", "SAVINGS", 15000),
            new Customer(4, "Mumbai", "SAVINGS", 8000),
            new Customer(5, "Delhi", "CURRENT", 30000)
    	);

	// Scenario1 :- Bank wants to group customers by city
	//👉 They want full customer details.

    Map<String,List<Customer>> mpp1= customers.stream().collect(Collectors.groupingBy(Customer::getCity));

    for(Map.Entry<String,List<Customer>> entry : mpp1.entrySet()){
        System.out.print(entry.getKey());
	System.out.println("->"+entry.getValue());
    }
}

// ***********************************************************
	//2️⃣ groupingBy(classifier, downstream)

	public static void getCustomerIdByCity(){
	List<Customer> customers = List.of(
            new Customer(1, "Pune", "SAVINGS", 5000),
            new Customer(2, "Pune", "CURRENT", 20000),
            new Customer(3, "Mumbai", "SAVINGS", 15000),
            new Customer(4, "Mumbai", "SAVINGS", 8000),
            new Customer(5, "Delhi", "CURRENT", 30000)
    	);
                // customer id by city
		Map<String,List<Integer>> mpp1 = customers.stream()
				.collect(Collectors.groupingBy(Customer::getCity,
						Collectors.mapping(Customer::getId,
									Collectors.toList())));
		// balance per city
		Map<String,Double> mpp2 = customers.stream()
				.collect(Collectors.groupingBy(Customer::getCity,
						Collectors.summingDouble(Customer::getBalance)));

		System.out.println("get cutomer id by city");
		for(Map.Entry<String,List<Integer>> entry : mpp1.entrySet()){
			System.out.println(entry.getKey());
			System.out.println("->"+entry.getValue());
		}
		System.out.println("get balace per city");
		for(Map.Entry<String,Double> entry : mpp2.entrySet()){
			System.out.println(entry.getKey());
			System.out.println("->"+entry.getValue());
		}

	}
 	
//***********************************************************

// ***********************************************************
	// 3️⃣ groupingBy(classifier, mapFactory, downstream)
	
     //  👉 Bank wants customers grouped by city 
  // 👉 Cities must be sorted alphabetically
  // 👉 Need custom Map implementation

  //********** Default groupingBy uses HashMap (unordered)**********

	public static void getCityByAccountType(){
		List<Customer> customers = List.of(
           			 new Customer(1, "Pune", "SAVINGS", 5000),
            			new Customer(2, "Pune", "CURRENT", 20000),
           		 	new Customer(3, "Mumbai", "SAVINGS", 15000),
           		 	new Customer(4, "Mumbai", "SAVINGS", 8000),
           		 	new Customer(5, "Delhi", "CURRENT", 30000)
    				);
	
		Map<String,List<String>> mpp1 = customers.stream()
							.collect(Collectors.groupingBy(Customer::getAccountType,TreeMap::new,Collectors
								.mapping(Customer::getCity,Collectors.toList())));

		for(Map.Entry<String,List<String>> entry : mpp1.entrySet()){
			System.out.println(entry.getKey());
			System.out.println("->"+entry.getValue());
		}
	}	 	
//***********************************************************
 	public static void main(String[] args){
		// groupCustomerByCity();
		//  getCustomerIdByCity();
		getCityByAccountType();
	}
}


class Customer {
    int id;
    String city;
    String accountType; // SAVINGS / CURRENT
    double balance;

    public Customer(int id, String city, String accountType, double balance) {
        this.id = id;
        this.city = city;
        this.accountType = accountType;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", accountType='" + accountType + '\'' +
                ", balance=" + balance +
                '}';
    }
    // getters
}