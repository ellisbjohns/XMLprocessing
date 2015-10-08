import java.util.Random;

/**
 * Created by ejohns on 10/4/15.
 */
public class LexiconSearch {

    private static String[] Lexicon = new String[]{"nuclear talks", "379th air expeditionary wing" , "laser-guided bomb" , "m16" , "male suicide bombers" , "najibullah zazi" , "palestinian rocket attacks on israel" , "paveway" , "precision bombing" , " rdx " , "rocket-propelled grenade launchers" , "silicon" , "torpedo" , "carbon dioxide" , "carcass" , "carpet bombing" , "dirty bomb" , "female suicide bombers" , "plastic explosive" , " tatb " , "tonite" , "water gel explosive" , "alice" , "bazooka" , "bicycle bomb" , "charcoal" , "detection dog" , "dynamite" , "fragmentation grenades" , "explosive belt" , "firearm" , "metal detector" , "pipe bomb" , "gas explosion" , " anfo " , " azon " , "daisy cutter" , "detonators" , "fragmentation grenade" , "guided bombs" , "humam khalil abu-mulal al-balawi" , "limbo" , "guided bomb" , "mine action" , "heavy bomber" , "phosphorus" , "amatol" , "anti-tank mines" , "boga" , "firecracker" , "booby trap" , "grenade launchers" , "aerial bombing" , "controlled explosion" , "time bomb" , "barbed wire" , "controlled mines" , "bomb disposal" , "salute" , "boron" , "detonator" , "rpg-7" , "sensitivity" , "rifle grenade" , "sticky bomb" , "anti-tank mine" , "unexploded ordnance" , "grenade launcher" , "car bombs" , "fragmentation" , "artillery shells" , "spice" , "minol" , "flare" , "gunpowder" , "land mines" , "explosive material" , "cluster bombs" , "rocket launcher" , "hand grenades" , " yasin " , "aerial bomb" , "ammonium nitrate" , " mrud " , "land mine" , "rocket-propelled grenades" , "improvised explosive devices" , "ptab" , "hand grenade" , "suicide bombing" , "artillery" , " mara " , "iron" , "rocket-propelled grenade" , "bombardment" , "ammunition" , "grenades" , " boar " , "improvised explosive device" , "car bomb" , "bombs" , "suicide bombers" , "fuse" , "strength" , "bombing" , "shell" , "alac" , "rocket" , "suicide attack" , "bomber" , "gun" , " bat " , " ram " , "bomb"} ;
    /*
    This method with take in a character summary and if a word is found that is located in Taylor's lexicon (i.e. Lexicon string)
     then it adds WTI text to the WTI XML fields

     */

    public static WTI_Text match(String chars)

    {

        //loop through the Lexicon and if a match is found then build the xml to be returned
        for(int LexIndex = 0; LexIndex < Lexicon.length; LexIndex++){
            if (chars.contains(Lexicon[LexIndex]))
            {
            return new WTI_Text();


            }
        }

        return null;




    }




}
