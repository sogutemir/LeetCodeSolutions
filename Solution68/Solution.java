class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int index = 0;

        while (index < n) {
            int totalChars = words[index].length();
            int last = index + 1;

            while (last < n) {
                if (totalChars + 1 + words[last].length() > maxWidth) break;
                totalChars += 1 + words[last].length();
                last++;
            }

            StringBuilder sb = new StringBuilder();
            sb.append(words[index]);
            int numWordsInLine = last - index;
            int numSpaces = maxWidth - totalChars + (numWordsInLine - 1);

            if (last == n || numWordsInLine == 1) {

                for (int i = index + 1; i < last; i++) {
                    sb.append(' ');
                    sb.append(words[i]);
                }
                while (sb.length() < maxWidth) {
                    sb.append(' ');
                }
            } else {

                int spacesPerGap = numSpaces / (numWordsInLine - 1);
                int extraSpaces = numSpaces % (numWordsInLine - 1);

                for (int i = index + 1; i < last; i++) {
                    for (int s = 0; s <= (i - index <= extraSpaces ? spacesPerGap : spacesPerGap - 1); s++) {
                        sb.append(' ');
                    }
                    sb.append(words[i]);
                }
            }
            
            result.add(sb.toString());
            index = last;
        }

        return result;
    }
}
