package questionBank1;

// import
import java.util.*;
import java.util.Collections;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;


// library java.lang
@FunctionalInterface
interface Printer{
	void print();
}

@FunctionalInterface
interface Calculate{
	int CalculateSquare(int n);
}


public class q1{

	//2) Sort a list of employees by salary using Lambda.
	static void sortEmployee(List<Employee> empList){
		Collections.sort(empList,(a,b)-> {
			return a.getSalary()-b.getSalary();
		} );
		empList.forEach(emp -> System.out.println(emp));
	}



	

	// main 
	static void main(){
// ---------------------------------------------------------------------------------------------------------------------------
		// input
		List<Employee> empList = new ArrayList<>(
				List.of(
						new Employee("emp1", 30000, "testing"),
						new Employee("emp2", 40000, "development"),
						new Employee("emp3", 35000, "HR")
				)
		);

// ---------------------------------------------------------------------------------------------------------------------------
		// 1) Write a lambda expression that prints “Hello Java” using a functional interface.
		Printer p1 = () -> System.out.println("hello world");
		p1.print();


		//2) Sort a list of employees by salary using Lambda.
 		//  sortEmployee(empList);

		// 3) Create a functional interface to calculate the square of a number using lambda.
		Calculate calculate = n -> n*n;
		System.out.println(calculate.CalculateSquare(10));

		// 4) From a list of numbers, print even numbers using Streams.
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6,8,10);
		Predicate<Integer> isEvenn = n-> n%2==0;
		System.out.println(nums.stream().filter(isEvenn).toList());

		// 5) Find average salary of employees using Streams.
		System.out.println(empList.stream().mapToInt(emp->emp.getSalary()).average().orElse(0));

		// 6) Rewrite this lambda using Method Reference.
		// list.forEach(x -> System.out.println(x));
		empList.stream().map(e->e.getSalary()).forEach(System.out::print);

		// 7)
	}
}



// notes
/*
	// inputs

		// easy initialisation
		// immutable list -> no add remove update
		List<Employee> empList = List.of(
			new("emp1",30000,"testing")
		);

		// modifiable list -> size constant (can update element but no add ,remove)
		List<Employee> empList = Arrays.asList(
			 new("emmp1",30000,"testing")

		);


		// mutable list arraylist constructure copies all list element into arralist where we can (add, remove, update) element
		// and also we are acheving easy intialisation

		List<Employee> empList = new ArrayList<>(
				List.of(
						new Employee("emp1", 30000, "testing"),
						new Employee("emp2", 40000, "development"),
						new Employee("emp3", 35000, "HR")
				)
		);

 */

