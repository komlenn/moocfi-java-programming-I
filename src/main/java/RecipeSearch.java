
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Paths;

public class RecipeSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        System.out.print("Files to read: ");
        String userFile = scanner.nextLine();

        System.out.println("");

        System.out.println("Commands:");
        System.out.println("list - list the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient");

        try (Scanner scan = new Scanner(Paths.get(userFile))){

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                list.add(line);

                if (line.isEmpty()) {
                    continue;
                }
            }

            while (true) {
                System.out.println("");
                System.out.print("Enter command: ");
                String userComand = scanner.nextLine();


                if (userComand.equals("stop")) {
                    break;
                }
                
                if (userComand.equals("list")) {
                    System.out.println("Recipes:");

                    String meal = list.get(0);
                    int time = Integer.valueOf(list.get(1));

                    System.out.println(meal + ", cooking time: " + time);
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).isEmpty()) {
                            meal = list.get(i + 1);
                            time = Integer.valueOf(list.get(i + 2));

                            System.out.println(meal + ", cooking time: " + time);
                        }
                    }

                }

                if (userComand.equals("find name")) {
                    System.out.print("Searched word: ");
                    String userInput = scanner.nextLine();

                    System.out.println("");

                    System.out.println("Recipes: ");

                    String meal = list.get(0);
                    int time = Integer.valueOf(list.get(1));

                    if (list.get(0).contains(userInput)) {
                        System.out.println(meal + ", cooking time: " + time);
                    }

                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).isEmpty()) {
                            meal = list.get(i + 1);
                            time = Integer.valueOf(list.get(i + 2));

                            if (meal.contains(userInput)) {
                                System.out.println(meal + ", cooking time: " + time);
                            }
                        }
                    }   
                }

                if (userComand.equals("find cooking time")) {
                    System.out.print("Max cooking time: ");
                    int userInput = Integer.valueOf(scanner.nextLine());

                    System.out.println("");

                    System.out.println("Recipes: ");

                    String meal = list.get(0);
                    int time = Integer.valueOf(list.get(1));

                    if (time <= userInput) {
                        System.out.println(meal + ", cooking time: " + time);
                    }

                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).isEmpty()) {
                            meal = list.get(i + 1);
                            time = Integer.valueOf(list.get(i + 2));

                            if (time <= userInput) {
                                System.out.println(meal + ", cooking time: " + time);
                            }
                        }
                    }   
                }

                if (userComand.equals("find ingredient")) {
                    System.out.print("Ingredient: ");
                    String userInput = scanner.nextLine();

                    System.out.println("");

                    System.out.println("Recipes:");

                    String meal = list.get(0);
                    int time = Integer.valueOf(list.get(1));

                    for (int i = 2; i < list.indexOf("") + 1; i++) {
                        if (list.get(i).equals(userInput)) {
                            System.out.println(list.get(0) + ", cooking time: " + list.get(1));
                        }
                    }

                    for (int i = 0; i < list.size(); i ++) {
                        if (list.get(i).isEmpty()) {
                            meal = list.get(i + 1);
                            time = Integer.valueOf(list.get(i + 2));

                            int nextEmptyIndex = list.size();
                            for (int j = i + 3; j < list.size(); j++) {
                                if (list.get(j).isEmpty()) {
                                    nextEmptyIndex = j;
                                    break;
                                }
                            }

                            for (int k = i + 3; k < nextEmptyIndex; k++) {
                                if (list.get(k).equals(userInput)) {
                                    System.out.println(meal + ", cooking time: " + time);
                                }
                            }

                            i = nextEmptyIndex - 1;
                        }
                    }
                    
                }
            }

            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
