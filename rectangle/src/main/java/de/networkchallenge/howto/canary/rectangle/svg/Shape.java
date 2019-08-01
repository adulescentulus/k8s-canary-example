package de.networkchallenge.howto.canary.rectangle.svg;

public enum Shape {
    RECTANGLE("<rect width=\"200\" height=\"100\" style=\"fill:green;\" />"),
    CIRCLE("<circle cx=\"50\" cy=\"50\" r=\"40\" stroke=\"green\" stroke-width=\"3\" fill=\"green\" />");

    private final String xml;

    Shape(String xml) {
        this.xml = xml;
    }

    public String toXml() {
        return xml;
    }
}
