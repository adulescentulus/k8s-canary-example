package de.networkchallenge.howto.canary.circle.svg;

import java.util.List;

public class Svg {
    private static String HEADER = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n";

    private final int width;
    private final int height;

    private final String id;
    private final List<String> info;
    private final Shape shape;

    public Svg(int width, int height, String id, Shape shape, List<String> info) {
        this.width = width;
        this.height = height;
        this.id = id;
        this.info = info;
        this.shape = shape;
    }

    public String toString() {
        return HEADER +
                "<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" height=\"" + height + "\" width=\""+ width + "\">\n" +
                shape.toXml() + "\n" +
                "  <text x=\"10\" y=\"20\" style=\"fill:black;\">file: " + id + "\n" +
                getTspan(20, 25, info) +
                "  </text></svg>";
    }

    private String getTspan(int lastY, int stepY, List<String> texts) {
        String tspans = "";
        for (String text : texts) {
            lastY = lastY + stepY;
            String line = "<tspan x=\"10\" y=\"" + lastY + "\">" + text + "</tspan>\n";
            tspans += line;
        }
        return tspans;
    }
}
