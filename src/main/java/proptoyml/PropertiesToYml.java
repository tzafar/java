package proptoyml;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PropertiesToYml {
    private static List<Property> props;

    public static void main(String... args) {
        String fileName = "src/application.props";
        Path path = Paths.get(fileName);
        System.out.println(path.getFileName());
        System.out.println(path.toString());
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> lines = stream.filter(m -> !m.startsWith("#")).filter(m -> m.trim().length() > 0)
                    .collect(Collectors.toList());

            for (String line : lines) {
                injectLine(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = 10;
    }

    private static void injectLine(String line) {
        if (props == null) {
            props = new ArrayList<>();
        }
        String[] items = line.split("\\.");
        int level = 0;
        for (String item : items) {
            placeItem(item, level);
            level++;
        }
    }

    private static void placeItem(String item, int level) {
        if (level == 0) {
            if (props.stream().map(m ->m.getKey()).collect(Collectors.toList()).contains(item)) {
                return;
            } else {
                Property property = new Property();
                property.setKey(item.replace("=",":"));
                props.add(property);
            }
        } else if (level == 1) {
            for(Property property : props){
                if (property.getDescendant().stream().map(m ->m.getKey()).collect(Collectors.toList()).contains(item)) {
                    return;
                } else {
                    Property p = new Property();
                    p.setKey(item.replace("=",":"));
                    property.getDescendant().add(p);
                }
            }


        }

    }

}
