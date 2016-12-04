import java.io.*;
import java.util.ArrayList;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        File a = new File("C:\\Users\\User\\IdeaProjects\\laba_8\\text.txt");
        FileReader fileRead = new FileReader(a);
        BufferedReader bufferRoad = new BufferedReader(fileRead);
        ArrayList<Road> road = new ArrayList<>();
        String buffer = bufferRoad.readLine();
        String[] elements;
        while (buffer != null) {
            elements = buffer.split(" +");
            Road roadOne = new Road(elements[0], elements[1], Integer.valueOf(elements[2]));
            System.out.println(roadOne);
            road.add(roadOne);
            buffer = bufferRoad.readLine();
        }
        System.out.println(road);
        TreeMap<CustomKey, Road> roads = new TreeMap();
    }
}