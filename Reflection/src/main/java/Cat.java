import java.lang.reflect.Field;
import java.util.Scanner;

public class Cat extends Animal {

    public static void main(String[] args) throws IllegalAccessException {

        Cat cat = new Cat();
        interactDirectly(cat, "Marsik", "Sphinx", "Male");
        printInfo(cat);
        interactWithReflection(cat, "Maya", "Domestic", "Female");
        printInfo(cat);
    }

    private static void printInfo(Cat cat) {
        System.out.printf(cat.getName() + "," + cat.getGender() + "," + cat.getBreed());

    }

    private static void interactDirectly(Cat cat, String name, String breed, String gender) {
        cat.setName(name);
        cat.setBreed(breed);
        cat.setGender(gender);
    }

    private static void interactWithReflection(Cat cat,String name, String breed, String gender) throws IllegalAccessException {
        Class<? extends Cat> rClass = cat.getClass();
        for (Field field : rClass.getDeclaredFields()) {
            if ("name".equals(field.getName())) {
                field.setAccessible(true);
                Object oldValue = field.get(cat);
                field.set(cat, name);
                System.out.printf("Replaced the old value %s with the new %s %n", oldValue, name);
            }
            if ("breed".equals(field.getName())) {
                field.setAccessible(true);
                Object oldValue = field.get(cat);
                field.set(cat, breed);
                System.out.printf("Replaced the old value %s with the new %s %n", oldValue, breed);
            }
            if ("gender".equals(field.getName())) {
                field.setAccessible(true);
                Object oldValue = field.get(cat);
                field.set(cat, gender);
                System.out.printf("Replaced the old value %s with the new %s %n", oldValue, gender);
            }
        }
    }
}