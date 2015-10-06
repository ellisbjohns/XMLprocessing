import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

import java.io.FileWriter;

/**
 * Created by ejohns on 10/3/15.
 */
public class SummaryHandler extends DefaultHandler {
    String writeLocation = "/home/ejohns/"; //default location if none is given.
    int writeIndex=0;
    String displayText[] = new String[1500];
    int numberLines = 0;
    String indentation = "";
    int MAX_LINES = 1000;
    String END_TAG = "OperationsSIGACT";
    boolean addWTI_Field= false;
    boolean isSummaryField = false;
    WTI_Text WTI_text = null;

    public SummaryHandler(String uri) {
        writeLocation = uri;


    }

    public void startDocument() throws SAXException {

    }

    public void startElement(String uri, String localName,
                             String qualifiedName, Attributes attributes) throws SAXException {
        displayText[numberLines] = indentation;

        indentation += "    ";

        displayText[numberLines] += '<';
        displayText[numberLines] += qualifiedName;
        if (attributes != null) {
            int numberAttributes = attributes.getLength();
            for (int loopIndex = 0; loopIndex < numberAttributes;
                 loopIndex++) {
                displayText[numberLines] += ' ';
                displayText[numberLines] += attributes.getQName(loopIndex);
                displayText[numberLines] += "=\"";
                displayText[numberLines] += attributes.getValue(loopIndex);
                displayText[numberLines] += '"';
            }
        }
        displayText[numberLines] += '>';
        numberLines++;

        //If summary field then look through text for words of interest using LexiconSearch.  If present then add new WTI elements

        isSummaryField = qualifiedName.equals("Summary");


    }

    public void endElement(String uri, String localName,
                           String qualifiedName) {

        indentation =  (indentation.length() > 4) ? indentation.substring(0, indentation.length() - 4) : "";
        displayText[numberLines] = indentation;
        displayText[numberLines] += "</";
        displayText[numberLines] += qualifiedName;
        displayText[numberLines] += '>';
        numberLines++;

        if (addWTI_Field && isSummaryField ) try {

            startElement("", "WTI", "WTI", null);
            startElement("", "MainCharge", "MainCharge", null);
            characters(WTI_text.getMainCharge().toCharArray(), 0, WTI_text.getMainCharge().toCharArray().length);
            endElement("", "MainCharge", "MainCharge");
            startElement("", "Trigger", "Trigger", null);
            characters(WTI_text.getTrigger().toCharArray(), 0, WTI_text.getTrigger().toCharArray().length);
            endElement("", "Trigger", "Trigger");
            startElement("", "Switch", "Switch", null);
            characters(WTI_text.getSwitch().toCharArray(), 0,WTI_text.getSwitch().toCharArray().length);
            endElement("", "Switch", "Switch");
            endElement("", "WTI", "WTI");

        } catch (SAXException e) {


        }




    //check to see if MaxLines has been exceeded
    if(numberLines>MAX_LINES && qualifiedName.equals(END_TAG))

    {
        endElement("", "OperationsSIGACTReports", "OperationsSIGACTReports");
        writeXML_file(writeLocation);
        numberLines = 0;
        // displayText[] = new displayTex[]

    }

}




    public void characters(char characters[],
                           int start, int length) {
        String characterData = (new String(characters, start, length)).trim();
        if(characterData.indexOf("\n") < 0 && characterData.length() > 0) {
            displayText[numberLines] = indentation;
            displayText[numberLines] += characterData;
            numberLines++;
            if (isSummaryField)
            {
                WTI_text = LexiconSearch.match(characterData);
                addWTI_Field= WTI_text !=null;


            }
        }
    }


    public void endDocument() throws SAXException {

        }

//TODO add closing parent nodes
    public void writeXML_file(String fileName)
    {
        try {

            FileWriter filewriter = new FileWriter(fileName +"icews1out" + writeIndex + ".xml");
            for(int loopIndex = 0; loopIndex < numberLines; loopIndex++){
                filewriter.write(displayText[loopIndex].toCharArray());
                filewriter.write('\n');
                writeIndex++;
                System.out.println(displayText[loopIndex].toString());
            }
            filewriter.close();


        }
        catch (Exception e) {
            e.printStackTrace(System.err);
        }


    }

    public String[] getDisplayText() {
        return displayText;
    }




}
