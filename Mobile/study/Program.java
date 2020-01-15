package pp;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        PersonGenerate personGenerate = new PersonGenerate();
        List<Person> personsList = personGenerate.generateListOfPersons(13);

        for(Person person : personsList){
            System.out.println(person);
        }
    }
}