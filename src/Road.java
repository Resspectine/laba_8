public class Road {
    public String cityStart;
    public String cityFinish;
    int length;

    Road() {
        cityFinish = "";
        cityStart = "";
        length = 0;
    }

    Road(String cityFinish, String cityStart, int length) {
        this.cityStart = cityStart;
        this.cityFinish = cityFinish;
        this.length = length;
    }

    public void setCityStart(String cityStart) {
        this.cityStart = cityStart;
    }

    public void setCityFinish(String cityFinish) {
        this.cityFinish = cityFinish;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getCityStart() {
        return this.cityStart;
    }

    public String getCityFinish() {
        return this.cityFinish;
    }

    public int getLength() {
        return this.length;
    }

    @Override
    public String toString() {
        return cityStart + " " + cityFinish + " " + length;
    }
}
