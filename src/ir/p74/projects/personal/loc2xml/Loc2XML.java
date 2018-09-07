package ir.p74.projects.personal.loc2xml;

public class Loc2XML {
    /**
     * An array of (x,y,z)'s together with
     * XML tagging for each one.
     * @param input the location list separated by " ".
     * @return an array of <code>String</code>
     * with elements in XML format
     */
    public static String[] getArray(String input) {
        String[] locations = input.split(" ");
        int counter = 0;

        for (String str : locations) {
            if (counter == 0) {
                str = "<x>" + str + "</x>";
                counter++;
            } else if (counter == 1) {
                str = "<y>" + str + "</y>";
                counter++;
            } else {
                str = "<z>" + str + "</z>";
                counter = 0;
            }
        }

        return locations;
    }

    /**
     * Calls <code>getArray</code> and returns XML format.
     * @param input the location list separated by " ".
     * @return a <code>String</code> in XML format
     * @throws NullPointerException if one of (x,y,z) from
     * each location in the given file is missing.
     */
    public static String getXML(String input)
            throws NullPointerException {
        String[] locations = getArray(input);

        if (locations.length % 3 != 0)
            throw new NullPointerException("numbers of location elements" +
                    "is not dividable by 3.");

        String xml = "";
        int number = 0;

        xml += "<locations>";
        for (int i = 0; i < locations.length; i += 3) {
            xml += "\n\t<loc \"number=" + number + "\">";
            xml += "\n\t\t" + locations[i];
            xml += "\n\t\t" + locations[++i];
            xml += "\n\t\t" + locations[i+2];
            xml += "\n\t</loc" + number + ">";
        }
        xml += "</locations>";

        return xml;
    }
}
