class Solution {
    public String[] findWords(String[] words) {

        String row1 = "qwertyuiopQWERTYUIOP";
        String row2 = "asdfghjklASDFGHJKL";
        String row3 = "zxcvbnmZXCVBNM";

        List<String> result = new ArrayList<>();

        for (String word : words) {

            String row;

            if (row1.indexOf(word.charAt(0)) != -1) {
                row = row1;
            } else if (row2.indexOf(word.charAt(0)) != -1) {
                row = row2;
            } else {
                row = row3;
            }

            boolean valid = true;

            for (char c : word.toCharArray()) {
                if (row.indexOf(c) == -1) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }
}