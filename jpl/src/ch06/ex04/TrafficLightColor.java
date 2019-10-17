package ch06.ex04;

public enum TrafficLightColor {
    BLUE("BLUE"),
    YELLOW("YELLOW"),
    RED("RED"),
    ;

    Color color;
    TrafficLightColor(String value) {
        color = new Color(value);
    }

    public Color getColor() {
        return color;
    }
}

class Color {
    String color;
    Color(String color){
        this.color = color;
    }

    public  String toString() {
        return this.color;
    }
}
