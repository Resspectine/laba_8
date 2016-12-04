public class CustomKey extends Road implements Comparable {
    private int key;

    CustomKey() {
        this.key = 0;
    }

    CustomKey(int key) {
        this.key = key;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
