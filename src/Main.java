import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static ArrayList<String> generateKeys(ArrayList<Road> arrayList) {
        ArrayList<String> rezArrayList = new ArrayList<>();
        for (Road road : arrayList
                ) {
            if (checkDublicates(rezArrayList, road.getCityStart()))
                rezArrayList.add(road.getCityStart());
            if (checkDublicates(rezArrayList, road.getCityFinish()))
                rezArrayList.add(road.getCityFinish());
        }
        return rezArrayList;
    }

    public static boolean checkDublicates(ArrayList<String> arrayList, String string) {
        for (String str : arrayList
                ) {
            if (string.equals(str))
                return false;
        }
        return true;
    }

    public static TreeMap<String, ArrayList<Road>> createTreeMap(ArrayList<String> keys, ArrayList<Road> roads) {
        TreeMap<String, ArrayList<Road>> rezult = new TreeMap<>();
        for (String str :
                keys) {
            rezult.put(str, findRoad(str, roads));

        }
        return rezult;
    }

    public static ArrayList<Road> findRoad(String string, ArrayList<Road> roads) {
        ArrayList<Road> roads1 = new ArrayList<>();
        for (Road road :
                roads) {
            if (string.equals(road.getCityFinish()) || string.equals(road.getCityStart()))
                roads1.add(road);
        }
        return roads1;
    }

    public static int findRoad(String start, String finish, TreeMap<String, ArrayList<Road>> roads) {
        int rez=0;
        ArrayList<String> cityes=new ArrayList<>();
        for (Map.Entry<String, ArrayList<Road>> entry : roads.entrySet()) {
            if (finish.equals(entry.getKey())) {
                for (Road road : entry.getValue()) {
                    if(start.equals(road.getCityStart())||start.equals(road.getCityFinish()))
                        return road.getLength();
                    if (finish.equals(road.getCityStart())&&checkDublicates(cityes,finish)) {
                        rez+=findRoad(start, road.getCityFinish(), roads);
                        cityes.add(finish);
                        rez+=road.getLength();
                        return rez;
                    }
                    if (finish.equals(road.getCityFinish())&&checkDublicates(cityes,finish)) {
                        rez+=findRoad(start, road.getCityStart(), roads);
                        cityes.add(finish);
                        rez+=road.getLength();
                        return rez;
                    }
                }
            }
        }
        return rez;
    }

    public static void main(String[] args) throws IOException {
        File a = new File("C:\\Users\\maks6\\IdeaProjects\\laba_8\\text.txt");
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
        ArrayList<String> keys = generateKeys(road);
        System.out.println(keys);
        TreeMap<String, ArrayList<Road>> roads;
        roads = createTreeMap(keys, road);
        System.out.println(roads);
        System.out.println(findRoad("Minsk","Mogilev",roads));
    }
}