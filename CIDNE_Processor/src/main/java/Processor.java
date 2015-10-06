import javax.xml.parsers.*;

import java.io.File;



/**
 * Created by ejohns on 10/3/15.
 */

public class Processor {
    public static void main(String[] args) {
        String filename = "/home/ejohns/icews1.xml";
        String writeLocation = "/home/ejohns/xmlRecords/";




            try {
                File inputFile = new File(filename);
                SAXParserFactory factory =
                        SAXParserFactory.newInstance();
                SummaryHandler Handler = new SummaryHandler(writeLocation);
                SAXParser saxParser = factory.newSAXParser();
                saxParser.parse(inputFile, Handler);

                Handler.writeXML_file(writeLocation); //this is here to write out any remaining xml data

                }
            catch (Exception e) {
                e.printStackTrace(System.err);
            }
    }






    }








