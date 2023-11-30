package DoublyLists;
public class Main {
    public static void main(String[] args) {
        Integer[] numbers = {12, 15, 23, 486, 5345};
        String [] string = {"белый", "синий", "красный", "сиреневый", "оранжевый"};

        DoublyList<String> listString = new DoublyList<>();
        listString.addArrayList(string);
        DoublyList<Integer> listInt = new DoublyList<>();
        listInt.addArrayList(numbers);

        listInt.printAll();
        listString.printAll();

        listInt.printBack();

        listString.checkIfEmpty();
        listString.extractAndDeleteFromBeginning();
        listString.printAll();
        listString.extractFromEnd();
        listString.extractAndDeleteFromEnd();
        listString.printAll();


    }

}

