package ch06.ex05;
/**
 * Colorオブジェクトを返すために定数固有メソッドを使用することを推奨しない
 * */
public enum TrafficLightColor {
    BLUE("BLUE"){
        Color getColor(){return color;}
    },
    YELLOW("YELLOW"){
        Color getColor(){return color;}
    },
    RED("RED"){
        Color getColor(){return color;}
    },
    ;

    Color color;
    TrafficLightColor(String value) {
        color = new Color(value);
    }

    abstract Color getColor();
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
