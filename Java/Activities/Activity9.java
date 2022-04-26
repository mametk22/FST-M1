package activities;
import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {

        ArrayList<String> myList = new ArrayList<String>();

        myList.add("pink");
        myList.add("yellow");
        myList.add("black");

        myList.add(3, "gray");
        myList.add(1, "white");

        System.out.println("Print All the Objects:");
        for(String s:myList){
            System.out.println(s);
        }

        System.out.println("3rd element in the list is: " + myList.get(2));
        System.out.println("Is yellow is in list: " + myList.contains("yellow"));
        System.out.println("Size of ArrayList: " + myList.size());

        myList.remove("gray");

        System.out.println("New Size of ArrayList: " + myList.size());
    }
}

