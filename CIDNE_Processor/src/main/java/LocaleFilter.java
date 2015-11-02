/**
 * Created by ejohns on 10/19/15.
 */
public class LocaleFilter{

//this method will take in the max and min of long and lat as well as the appropriate fields.  If location
    //fits the parameters then it will return a bolean deliniating if the location is w/in the bounds



    public LocaleFilter()
    {

    }


    public static boolean matchLat(double minLat, double maxLat, String charData)

    {
        double Lat= Double.valueOf(charData);

            if (Lat >= minLat && Lat <= maxLat )
            {
                return true;

            }
        else return false;



    }

    public static boolean matchLon(double minLon, double maxLon, String charData)

    {
        double Lon= Double.valueOf(charData);

        if (Lon >= minLon && Lon <= maxLon )
        {
            return true;

        }
        else return false;





    }




}
