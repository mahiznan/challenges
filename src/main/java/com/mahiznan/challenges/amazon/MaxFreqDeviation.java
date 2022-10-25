package com.mahiznan.challenges.amazon;

import java.util.*;

public class MaxFreqDeviation {


    static Set<String> printAllSubString(String s, Set<String> set) {
        System.out.println("Finding substring for " + s);
        if (s.length() == 0)
            return set;
        for (int i = 1; i < s.length(); i++) {
            set.add(s);
            set.add(s.substring(0, i));
            set.add(s.substring(i));
            printAllSubString(s.substring(i), set);
        }
        return set;
    }


    public static int getMaxFreqDeviation(String s) {
        Set<String> stringSet = printAllSubString(s, new HashSet<>());
        int maxDeviation = 0;
        for (String subString : stringSet) {
            Map<Character, Integer> sortedMap = new HashMap<>();
            for (char c : subString.toCharArray()) {
                if (sortedMap.containsKey(c)) {
                    Integer count = sortedMap.get(c);
                    sortedMap.put(c, count + 1);
                } else {
                    sortedMap.put(c, 1);
                }
            }

            //bdbcdacbcadbbc
            int max = Collections.max(sortedMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getValue();
            int min = Collections.min(sortedMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getValue();
            int deviation = max - min;
            if (deviation > maxDeviation) {
                maxDeviation = deviation;
            }
        }
        return maxDeviation;
    }

    public static void main(String[] args) {
        System.out.println(getMaxFreqDeviation("beaffcabaecdeadccedaadaeddbfccfdfadcfbccebdbcdbcacbeecaabfccccddbcafcffaadddaaaccdaecfebcdcdedaaceceabebfdcdfcbfdacacbdfebbefbfeacadebbfebeafcefbaebfbbeabffdbefbfddfcdaaedbefacafddffbfaffbdbcddffdeaaefdcddacdbcafcdfccccfcccffbfdfacbdefabaabcfaecababdefefccdcadbbbbdbbafbeefedeebccdadacbacbadffebcfefeedeebfcbffadefbdfadfeebdfebcaffdadefeaceacacbfbedcccabadaaddecccabfccbaedbdaadedbefbbddcabbcfdbffabcdedbbcaaffebedfaaabdcefdeffcbccfbfdadacfdfffffbdfcbabceebddcdcaddabbdfdacbbdcabecdcddceeedeccecfedadcaadaabcedcfaefcedbadafcadcbeafbbcbbecebadafdcbffedeacceeefddfdfececeecaabccdbaceceeceedfcafbadcedbecebdfffaeaaaddadecaefeebdaccaefcadebaeebbcddfafdaffcdfcdbdcdeaedbbbbfadecdecbacacffbccadfeaefcdddedbfcbabefcdcfbaabdccbfefdeefdacedafacbbfbfecedecbfacbfebfeeebfbffabdeeeebebfaabbdafaafbebefeccedebcaddebabefdebfbedeefbceaefcbfabbbabeeadbafecccabfdccbbdbeacbfababcfcebbbeceadcafadccdcdedbcbcdfecbfdcdcdddddcbeacebbdadeafabefabbcfcfdddcffbcbaeeaaeceafbebfcabddaddbebcffdefdcedaceedefdddaedaeaedacbebcedffbcfaacddfcbfcfecccfadafdcdcacfefcddaaafcabbcbadaaacaeaaefeccedaaedabdbceccedbeefbeaedbcbefbfabcfebcfcdfacafabdcaabecbbcdbbacbfcdaaffccbaffeacedabbacacdedfcbbbcdfbbaadedfaebdbdbbaccdcfaaffbdccacabdbaadbedcfabfbdffccffbbdabcbefabbeacdfeaefbbcfdadaeabafddcfcfeaaaeeddfbaffaebfeeeacffacafcadcdddecddbdf"));
    }
}