package tutorial.javari;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import org.json.JSONObject;

import tutorial.javari.animal.Animal;
import tutorial.javari.animal.Condition;
import tutorial.javari.animal.Gender;

public class JavariBackend {

    private final AtomicInteger counter = new AtomicInteger();
    private HashMap<Integer, Animal> animals = new HashMap<>();

    public JavariBackend() {
        Scanner scanner;
        try {
            scanner = new Scanner(
                    new FileReader("tutorial-9/src/main/java/tutorial/javari/animals_records.csv"));
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                initJavariHelper(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int animalCount() {
        return animals.size();
    }

    public ArrayList<Animal> wholeZoo() {
        return new ArrayList<>(animals.values());
    }

    public Animal getAnimal(Integer id) {
        return animals.get(id);
    }

    public boolean idExists(Integer id) {
        return animals.keySet().contains(id);
    }

    private void initJavariHelper(String line) {
        String[] split = line.split(",");
        Animal newAnimal = new Animal(counter.incrementAndGet(), split[0], split[1],
                Gender.parseGender(split[2]), Double.parseDouble(split[3]),
                Double.parseDouble(split[4]), Condition.parseCondition(split[5]));
        animals.put(newAnimal.getId(), newAnimal);
    }

    public Animal removeAnimal(Integer id) {
        Animal target = animals.get(id);
        animals.remove(id);
        return target;
    }

    public Animal addAnimal(String input) {
        JSONObject json = new JSONObject(input);
        Animal animal = new Animal(counter.incrementAndGet(), json.getString("type"),
                json.getString("name"), Gender.parseGender(json.getString("gender")),
                json.getDouble("length"), json.getDouble("weight"),
                Condition.parseCondition(json.getString("condition")));
        return animal;
    }
}
