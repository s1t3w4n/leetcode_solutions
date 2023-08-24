import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left-justified, and no extra space is inserted between words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 *
 *
 * Example 1:
 *
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Example 2:
 *
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified because it contains only one word.
 * Example 3:
 *
 * Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 300
 * 1 <= words[i].length <= 20
 * words[i] consists of only English letters and symbols.
 * 1 <= maxWidth <= 100
 * words[i].length <= maxWidth
 */
class Solution {
    @SuppressWarnings("ConstantConditions")
    public static void main(String[] args) {
        System.out.println(new Solution().fullJustify((String[]) Arrays.asList("This", "is", "an", "example", "of", "text", "justification.").toArray(), 16));
        System.out.println(new Solution().fullJustify((String[]) Arrays.asList("What","must","be","acknowledgment","shall","be").toArray(), 16));
        System.out.println(new Solution().fullJustify((String[]) Arrays.asList("Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do").toArray(), 20));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int len = -1 , count = -1, start = 0;

        for(int i=0;i<words.length;i++){
            if(len+words[i].length()+1<=maxWidth){
                len += words[i].length()+1;
                count++;
            }
            else{
                addLine(words,start,i-1,len,count,maxWidth,result,false);
                start = i;
                i--;
                len = -1;
                count= -1;
            }
        }
        addLine(words,start,words.length-1,len,count,maxWidth,result,true);
        return result;
    }

    public void addLine(String[] words,int start, int end, int len, int count, int maxWidth, List<String> result,boolean isLast){
        int spaces = maxWidth-len;
        spaces += count;
        int same = isLast || (count==0)? 0 : spaces/count;
        int extra = isLast || (count==0)? count : spaces%count;
        int trail = isLast || (count==0) ? maxWidth-len : 0;
        StringBuilder line = new StringBuilder();
        while(start<=end){
            line.append(words[start]);
            for(int k=0;k<same && start!=end;k++)
                line.append(' ');

            if(extra>0){
                line.append(' ');
                extra--;
            }
            start++;
        }
        while(trail>0){
            line.append(' ');
            trail--;
        }
        result.add(line.toString());
    }
}