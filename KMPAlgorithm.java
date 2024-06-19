/*
 *      ASSIGNMENT 2 (KMP Algorithm)
 * 
 * MEMBER 1: ANDYCLOS A/L BOON MEE (22300738)
 * MEMBER 2: MUHAMMAD EZZAT HAZIQ BIN ELHAN (22300604)
 * MEMBER 3: KAM WENG XUAN (22300683)
 * MEMBER 4: LOH WEI TING (22300549)
 * 
 */

public class KMPAlgorithm
{
    public static String findKMP(char[] text, char[] pattern)
    {
        int n = text.length;        // length of the text
        int m = pattern.length;     // length of the pattern

        if (m == 0)
        {
            return "The pattern is empty: " + 0;        // if the pattern is empty, return 0
        }

        int[] fail = computeFailKMP(pattern);           // compute the failure function

        System.out.println("Total Space: " + fail.length * Integer.BYTES + " bytes");       // print the total space used by the failure function

        int j = 0;      // index for the text
        int k = 0;      // index for the pattern

        while (j < n)    // while the index for the text is less than the length of the text
        {
            if (text[j] == pattern[k])      // if the character in the text matches the character in the pattern
            {
                if (k == m -1)              // if the index for the pattern is equal to the length of the pattern - 1
                {
                    int index = j - m + 1;      // calculate the index where the pattern is found
                    return "Pattern found at index " + index;           // return the index where the pattern is found
                }
                
                j++;        // increment the index for the text
                k++;        // increment the index for the pattern
            }

            else if (k > 0)     // if the index for the pattern is greater than 0
            {
                k = fail[k - 1];        // set the index for the pattern to the value of the failure function at index k - 1
            }

            else            // if the index for the pattern is 0
            {
                j++;        // increment the index for the text
            }
        }

        return "No match found: " + -1;     // if the pattern is not found, return -1
    }

    private static int[] computeFailKMP(char[] pattern)     // function to compute the failure function
    {
        int m = pattern.length;     // length of the pattern

        int[] fail = new int[m];        // create an array to store the failure function

        int j = 1;      // index for the pattern
        int k = 0;      // index for the pattern

        while (j < m)       // while the index for the pattern is less than the length of the pattern
        {
            if (pattern[j] == pattern[k])   // if the character in the pattern matches the character in the pattern
            {
                fail[j] = k + 1;        // set the value of the failure function at index j to k + 1
                j++;                    // increment the index for the pattern
                k++;                    
            }

            else if (k > 0)             // if the index for the pattern is greater than 0
            {
                k = fail[k - 1];        // set the index for the pattern to the value of the failure function at index k - 1
            }

            else                        // if the index for the pattern is 0
            {
                j++;                    // increment the index for the pattern
            }
        }

        return fail;            // return the failure function
    }

    public static void main(String[] args) 
    {
        String text = "ctjfszswabtufcgrughcvadzpqlxoacdfroislogjolemzonavzfwkaxeirxxrldqgzkkndtksdcvfnpnetmmytiwoshqymmtgaionqwofwawyjdpunxdmolundenewsugacosbgoluqoprtlgooxqqbfuscutbxsdcmppexaysbnkcjurmtdqbiwnfnabvbnmmtptqnnghstyinlpmhcyamkqkclhaqqnwntikwwkwaoorgigppipsboljipsimxpkydiophrsytgtjxnphoicemkuvyusjyemunogrlwxkcldyduzcbdfeqdsksqchgkprdnyosgearokzbuopwwvobkrzjsafoobovxpejyylrodiqzxhksjnsvaxkdndurdupbykuqunruiwdhuhuubugxjmbgwwjpkypjzieflmexnxgswoheelsqafnweyidggtonwmjkauvvqxxauzqpudvgsxxkkedvxvhvoozijyayacvdumvqlimokqdcivjffeszhflldlhzlrbrhazdaxhyxkpfzmehksqfeverzybgkrmatlwxlwoztqcmlfezlwfjpimlrxmpuzbwcrqynvibckystmaweaprbbkoiispugiccvecfdahblftglbpetxolnhnnvyatlzqhlzzoygtrxtboxrbddfwwmpbdqggqfcwdzxuxlesjyxpkccioxslflhdfqixkyekwvncwpbsforhrjexrjiulafsrwzkhakxqwhdzpaetoqjlgebnbocfbxtdesngcrmuquulhmpcfgkpyfaqmumcoqyaljzfivocgqfmmffxbewxmndicjrrdgiltthulvierylolocvdwcwzkwhszgblzibplbderqschwyqbhnirmyrwqwomuahxvuhrjmjdkckrcrormfkijzjwwwrcmzhbamqbynvrhxxhpcwrewfkpbulodhooijfiwlswcaauegrwlmlhzsphrrixbveyeorjppsesfudbnyelywcnpgxlajmxdfmkxdmaouarhcytezeuxbupgmxsjthzcccicfmqowhgimmizepytabhkboobolfrfellvnzafpdeznojzvwtqwgaludeussluksozkirhpisosmizualpaevyhiipmuzuhlkqkcwnwkdisfteyornucyeqbnbmtibzirjcczpcmtxuvlmlgznlchpuhckqtuaaejmphuagbpzszoabbcspgldnmmlicmxazaimrkkhgkdiltctnhheztsqobbfiimpoxkazawsmfcougqynluoxfwecuuynezjlphrttjgacstgayblxykhyeqfcdwaqqrmaddozcaqckrhdkgseekeocdtntikpmqkypuzuzvbtbezjqvbvysjrqqudbujtcbolitpzkuiskkigzcditgvwpmkwgaptzkiobnlakmbtufrnrapsbkidkfxgyvbtworchdkowltjicdvaoatztgbglokngwdqaokvqehuyuygnkkmllksnbqhxjfkmmzihdxaqomqxjbdexwbavkykvycxgtgokvjeexskvqenyvfprwnljlizqdtpteydpznzbugwmskjovgtfubnkmkrnpqypjcvmkxfnqpsjjbposhdvjlzafkzwipnlhrvrwjlwdhnnhampqgqybutcqmqvsxwfukzhzhamgwovzbtndjqbpxamzkvzueplggbfginjhuqppfsohgxztycktdksukbseomujwfpffdkxnrstjpkgybabmfrtekdhcrqhkykawxkufiajssggrunrlgvnhtnqjddmrmxhhwgnutbfktwtdaopzfbiuyvcqpxnwjulgexwpmybcrasciqujgteqwgvrttaweqmloooxnzvgvgoqnbwwugvszpywahpuuhcrwdzysrkkdpmfigwgirfzixhhgzxxwcqsmgsfetaemrujikuxulqtojhoagbjiwltepaaztfqjsvzfotoyoqzdmzdrdqwknzhkvnyckllaqsjdtoyjcfirzigfzspzjvojxydlkfqwgbzstgcjqbkzcjffywhnfadqrkeiiqzskpxxzshwhodxwsynkchbmfqxbqsxjtsddglhukjuoktimuhaoffrultuvwrfctrkmdrktldtyntsrbwjvlcyyptpsdajxujgiboomqsxuzmshxcztczcsxivrmgcaemffrqpjnkgwbfdpdjoxrslrznbhgtrpuknfyvpdtorlkwazcwbnuhexnvwtwvssnmetnnpybpnvlyulcylrrpvxycxnjucfsxqpiweygkcuxqdpokkelockfkegsmpmnnnuvpfhjgiivrkaltkzkweriwkzzwysklwqvsmoamqenpohlcndbxrowctuurszvsqlnoqnxfgifvxtwqypiprjwmkchjtxzlxnzkhrqjhrnduoeuajyckqbcuaizilpyxqvpospnptsqutontnrrlpmkpfaukxxdwqqcsikzzgqcrhyijxznqomvcsdfwekfeipdygacohaicihxflbgicpcgxlqoujtrtmnjiycrxmuxjrlmjhepmibmssfjlbhbkzqtvyiaawmamrqunrwwdukjorwrfvbinsmhnmnmlxrlxjwlzoodkbractwwrkciyagqrfzoacxzpqfixykordauxoymskdpfzyyyuwaibrlfrirqhhgmvkaxqhxoljqlyfafszcmnlhqeprgrecxwmmesjwiucaddkuskouzryvujvlfxrgzeuygrkwuhwttnbppllzfilhrcjtgnmkuhqtwgrdtwfuwazmbualcbyntfjsskfngldapopyrgvfkhpmcnbhfwimblgzpexmsoqwgcetwdidjvcolbabuheuxuquhydcchrygwuqmvixshrsihnjptyileskedrvrqjzudlmjwsbghkukuxjrwxuahfrlhslggmdpfqwxouesrazsvntyzrmamyxobqjtyxosgrvlpxhmiumccrxzaghcfkxnxwyusgurpaoczjbsoglezjpsfpnlvhntfzmwovvondwbcsncexysadvhxupfnwyfzwnhnkbrmjrwhtxwsejmjxaeorobbpqmcbdnaugqsfoksbtgkwrrmpkzguloaigycdamkplqkrdsqbsjvsvdjnmjixpwefacnvterykkfwtxdwnbkevbehpyihpnffltijejeaahlvzikmuookeamqswydbgvkrirghkojniwffgkphqyzzjczaerauydygwgynqyaibumirvegfrliwwroxxmorgzguhpngvkjfjknmvgqlhnohfrrnrwyjhmnqdbrpijkgdqsbfuwinglbmwyancppkgxcwponjnwzwcwilbvaiwdgbaoddcyybapcldfugdndpgtvwtrutenzqznkcfirymwmfetlazkwgrhplxnmgdsagysrjkusvdfdhjqtfvruqyayxnclunakccbsfdimrqrpmmgeptqfsywpvesyowwkdzsyyvztwdjbdblkfvbrudwzypygcokzidsninzjzbmerwkfwcohvgqkbiqeinaftkkoofkpakbqmorbfxalrypmprajpctfmzhbwfqzvfivuukbbiucnajlfgzvfyrjkkufxcunjgtqofuztbtnsewzkfupcosjfhzxuqqdugjbcgxnvpbvqxhggcfrkkmgigaaotvisjehniximdcylhjbciuqcmuymchatfsukfwsckxgvxxfdzgcebyretwijvouqgvopsdcxtjspckkwesbkuxwqogzoniqvhqucactixdmmnhtrdycpeouqfoaazdccenwuvaoaifaycfpuuytnlyrnxzghncgdhilmkmvtcfoqwkwzriufachsngrsepmbzxvynlwxgvcdrfbazkcjulmrvmnaidkoubpcomcjdbjjcnituqilgrcdfggxbalotgtybsxduntrlhhfqpuctnshdvpjfpekyvhebmddaxphbdzptowcfypuudzzooarufzcormrsgkytcqzxzfmdjpxvbzqvsxsuawzgpsyfqicbbtsdsujuafreljqnarwcnrspbhqfrgqlbfiwcpsubprvkladkoudhiwahlbrytnonwtfklicavozzupysqqknrgvriqqlhqokgycrxpihpqhsudrljgrtfztbayrmmrmegrnoxlzmdkmnqutmtqqaeadsumcoafycwtebcazjnoabkwivevjtokwdskifkoyaxyywfvoodzgayfinabbdduajgdyaxuvfnltuttiwyhuesfzgyrajoqyrgqidrubleivutjtbtmrnmnxqulyuznvtgnguoykewnbzyqckhgwxeatocjhabvteumlipuunisipmgsrmpwemjhvkjwkczfdxhwedtwzqfvnwciixhfwxgajewoprjkcejfmjjusmxlarwewoqrcvfugfddswqodbthgezeivfpmiqlhxfzgbbdxmbhqruzxqastuofbwamsvnzfhkkylucmkyvrbajkyqcdswivgfbhrzrvkdzydtmumminjwfnkwmulxxxivqkquaciwgcpdclkkxwazhtkpafeebcmibusblkpouzsqpocxsucpcoifcimwjafsifjansodblgnwldwvvtbwazfucyocveofqaogkolshqjdcrnmotszsjqgwgjbzkbzaosvifnovgvqlzrvyoienzbgzzdqqqssyhspwmudsbzbcdhkeetyoqlnraoxjldexogzhmkqlhbdkklvendktvxtnafiofeataqcyeddimlxszqjnbzrxqgejdhsgqjtcikmgkbvithvriidgglkjafpyedrllagemvngrpwlbyzzdbimhuqxlidukfhhjamplibpqmnipdxzsipkbkvylhfkssfiijbphsrkqdxgadopvcdeetxdtynww";
        String pattern = "sfudbnyelywcnpgxlajmxdfmkxdmaouarhcytezeuxbupgmxsj";
        
        char[] text_arr = text.toCharArray();                           // text to search
        char[] pattern_arr = pattern.toCharArray();                     // pattern to search for
        long startTime = System.currentTimeMillis();                    // start the timer
        System.out.println(findKMP(text_arr, pattern_arr));             // print the result
        long endTime = System.currentTimeMillis();                      // end the timer
        long elapsed = endTime - startTime;                             // calculate the time taken to run the algorithm
        System.out.println("Text Size: " + text_arr.length);
        System.out.println("Pattern Size: " + pattern_arr.length);
        System.out.println("Elapsed time: " + elapsed + " ms");         // print the time taken to run the algorithm
    }
}