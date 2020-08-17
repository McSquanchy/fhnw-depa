package ch.fhnw.depa.mcsquanchy;

import java.util.Set;

public class Node implements Component {
    String title;
    Set<Component> leafs;

    public Node(String title, Set<Component> leafs) {
        this.title = title;
        this.leafs = leafs;
    }

    @Override
    public String getHtml() {
        StringBuilder html = new StringBuilder();
        html.append("<h1>");
        html.append(this.title);
        html.append("</h1><ul>");
        for(Component c: this.leafs) {
            html.append("<li>");
            html.append(c.getHtml());
            html.append("</li>");
        }
        html.append("</ul>");
        return html.toString();
    }
}
