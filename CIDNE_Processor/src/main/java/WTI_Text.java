import java.util.Random;

/**
 * Created by ejohns on 10/5/15.
 * This class randomly inserts WTI data in appropraite WTI fields.  WTI data for the fields was found in 2 sources:
 * http://taylor-hpe/public/data/dbpedia/lexicon.json and https://drive.google.com/a/ccri.com/file/d/0B8vQglyT10gBUnhDVGZLbTRwZHc/view
 *
 *
 */
public class WTI_Text
{


    private String Switch;
    private String MainCharge;
    private String Trigger;
    private String IED;

    private String[] SwitchList= new String[] {"Push Button", "Rocker Switch", "Clothes Pin", "PMR", "GSM", "Lynx", "Pie Tins", "Chemical Pencil", "Digital Watch" };
    private String[] MainChargeList = new String[]{ "Hexanitrobenzene", "Lead styphnate", "Tetranitromethane", "Potassium fulminate", "Polyvinyl nitrate", "Tetrytol", "Diethylene glycol dinitrate"};
    private String[] TriggerList = new String[]{ "Saftey fuse", "Visco fuse", "NanoFoil", "Electric match", "Fuse", "Slow match", "Thermalite", "Flash bulb", "Match Fuse"};
    Random random = new Random();

    public WTI_Text()
    {


        Switch= SwitchList[random.nextInt(SwitchList.length)];
        MainCharge = MainChargeList[random.nextInt(MainChargeList.length)];
        Trigger = TriggerList[random.nextInt(TriggerList.length)];
    }

    public String getMainCharge() {
        return MainCharge;
    }

    public String getTrigger() {
        return Trigger;
    }

    public String getSwitch() {
        return Switch;
    }






}
