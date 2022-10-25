package com.mahiznan.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

class alphanumeric {
    public String name;
    public int count;

    alphanumeric(String name, int count) {
        this.name = name;
        this.count = count;
    }
}


public class EarthQuakeAndPaintShop {
    static alphanumeric[] sortedStrings(int N, String[] A) {
        ArrayList<alphanumeric> result = new ArrayList<>();
        Arrays.sort(A);
        alphanumeric prev = new alphanumeric(A[0], 1);
        int pos = 0;
        result.add(prev);
        for (int i = 1; i < A.length; i++) {
            if (Objects.equals(A[i], prev.name)) {
                prev.count++;
                result.remove(pos);
                result.add(prev);
            } else {
                alphanumeric temp = new alphanumeric(A[i], 1);
                result.add(temp);
                pos++;
                prev = temp;
            }
        }

        alphanumeric[] arr = new alphanumeric[result.size()];
        arr = result.toArray(arr);
        return arr;

    }

    public static void main(String[] args) {
//        String[] A = {"2234597891 zmxvvxbcij 8800654113 jihgfedcba",
//                "1234567891 abcdefghij 9876543219 jihgfedcba",
//                "2234597891 zmxvvxbcij 8800654113 jihgfedcba"};

        String[] A = {
                "8704585113 uspkgpolzs 3317590307 sbsczetcsv", "5953428928 daoujpjzrr 4166994734 doyqubuohj", "0846192059 ivrthlhoxi 7398461926 ayrzipjjlb",
                "3012910664 epgagvipvr 0122870722 gbjiyuxtjy", "7725705947 vlerqututf 7848967422 wapjzwhzry", "4687970779 dtzyhxqyhe 6884481161 dmunjpmpxg",
                "5953428928 daoujpjzrr 4166994734 doyqubuohj", "5513605796 meticdfxnz 0225081969 yjccexbckh", "2361997240 gekwyabbed 2639614702 oownjiavwx",
                "5953428928 daoujpjzrr 4166994734 doyqubuohj", "5953428928 daoujpjzrr 4166994734 doyqubuohj", "5513605796 meticdfxnz 0225081969 yjccexbckh",
                "5510881581 kprcncyvdn 0717402498 hxwoezdqga", "4687970779 dtzyhxqyhe 6884481161 dmunjpmpxg", "4809434928 ntuoziteuz 5964824375 wxycovqjxp",
                "5885206952 bulcxvxsbx 1022500083 gnkdsbwada", "5953428928 daoujpjzrr 4166994734 doyqubuohj", "2348370834 uxhehsfxum 0461015159 boahbykbmm",
                "4687970779 dtzyhxqyhe 6884481161 dmunjpmpxg", "6849709046 jsattfxkxb 5802741607 byuepdlvnn", "5510881581 kprcncyvdn 0717402498 hxwoezdqga",
                "5885206952 bulcxvxsbx 1022500083 gnkdsbwada", "7303874637 xhyzqosngr 0206095447 kotyavazsr", "0001975886 ksyrqohmhr 8704614331 ivyerdalxc",
                "9311537605 cqtxcqvgyb 8540242228 hkywreiqwx", "8006760538 akzkwcbtvi 7899662783 wckclixgfl", "8711091784 jsoubzfdxs 8030131564 gaanctesro",
                "2506105966 gtgzlgxpwr 9343613590 bcfernaglw", "7901717434 ifcpmfuxtk 8017335439 utoxqnxchu",
                "2348370834 uxhehsfxum 0461015159 boahbykbmm", "9384478141 hmbjrzoxfy 7184470226 qabfqqsevm", "3189436528 clsrdpqull 6784545696 xnmgunhdla",
                "2588477812 poherxvoki 1931709093 bymzatptvq", "1664744141 wamkuqpkbo 7646282229 uusruolmme", "7725705947 vlerqututf 7848967422 wapjzwhzry",
                "2724363650 aaqpdtkbkj 0058491146 jsfnvwhsar", "8601567418 hupzimgmba 3005112685 trskctyfuc", "6620156306 scqfjhecyj 0242544482 qffwsurzpx",
                "7303874637 xhyzqosngr 0206095447 kotyavazsr", "2234567484 jiduytkmcm 8183973968 bfsvtybrck", "9989971469 zinqirwwsn 1903369533 spxqykcwcr",
                "5319336209 gtprmtuyqc 5389640812 ehjoiifmib", "2506105966 gtgzlgxpwr 9343613590 bcfernaglw", "3709045668 hvcdmgzjde 9154731870 ufmhcdsmyq",
                "7303874637 xhyzqosngr 0206095447 kotyavazsr", "2255674548 hvfqdslpax 7873376721 tjstpbaiip", "4687970779 dtzyhxqyhe 6884481161 dmunjpmpxg",
                "2209909774 lhzcmipytl 3200869167 pxglosaflw", "9491982391 msoewxxiyu 9056123751 xhkqpzbmkj"
        };
        alphanumeric[] result = sortedStrings(A.length, A);
        System.out.println(result);

    }
}
