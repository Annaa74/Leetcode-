class Solution {
    public boolean isAnagram(String s, String t) {
        // slen = s.length();
        // tlen = t.length();
        // String dup = "";
        // int countAL = 0;
        // int counter = 0;
        // if(slen.equals(tlen)){
        //     for(int i = 0;i < slen ; i++){
        //         char ch = s.charAt(i);
        //         if(dup.contains(ch)){
        //             counter +=1;
        //         }
        //         else{
        //             dup = dup +ch;
        //             countAL = 1;
        //         }
        //     }
        // }
        if(s.length() != t.length()){
            return false;
        }
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0 ; i < s.length();i++){
            if (arr1[i]!= arr2[i]){
                return false;
            }
        }
        return true;

            
        
    }
}