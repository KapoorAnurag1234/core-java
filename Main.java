import java.util.Scanner;
class Main {
    public static void main(String[] args){
      int age;

      age = 27;
      // Variable can be reassigned but cant be redeclare in java
      age = 28;

      System.out.println("I am Anurag and my age is " + age + " Thank you");

       // final keyword is used to fix a value, so that value cant be reassign again. 
      final int fixedAge = 32;
      System.out.println("My fixed age is" + fixedAge);

      // if we dont assign value at the time of declaration, we can assign the value. 

      final int newFixedAge;
      newFixedAge = 34;

        String literalString1 = "abc";
        String literalString2 = "abc";

        // JVM will always create a new string pool, for these kind of assignment.
        String objectString1 = new String("abc");
        String objectString2 = new String("abc");

        System.out.println(literalString1 == literalString2);  //true
        System.out.println(objectString1 == objectString2);    // false
        // Since abc was already in the string pool, the literalString2 variable reuses that. In case of the object strings however, both of them are different entities.
    
        Scanner scanner = new Scanner(System.in);

        System.out.print("What's your name? ");
        String name = scanner.nextLine();

        System.out.printf("So %s. How old are you? ", name);
        int age1 = scanner.nextInt();

        System.out.printf("Cool! %d is a good age to start programming.", age1);

        scanner.close();

    }
}