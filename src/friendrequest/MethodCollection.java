package friendrequest;

import java.util.ArrayList;

public class MethodCollection {

  public static ArrayList<String> stringList = new ArrayList<>();

  public MethodCollection() {

  }

  public static void main(String[] args) {

    stringList.add("aaa");
    stringList.add("aab");
    stringList.add("aba");
    stringList.add("baa");
    stringList.add("bbb");

    String searchedString = "ba";

    ArrayList<String> result = search(stringList, searchedString);

    System.out.println(result);
  }

  public static ArrayList<String> search(ArrayList<String> list, String name) {
    ArrayList<String> foundStrings = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
      String searchedObject = list.get(i);
      if (searchedObject.contains(name)) {
        foundStrings.add(searchedObject);
      }
    }
    return foundStrings;
  }

}
