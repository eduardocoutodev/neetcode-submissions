class Solution {
    private final String DELIMITER = "#";
    public String encode(List<String> strs) {
        /// Para hello world
        /// #5HELLO#6XD
        var sb = new StringBuilder();
        for(var string: strs){
            sb.append(string.length());
            sb.append(DELIMITER);
            sb.append(string);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        var results = new ArrayList<String>();
        System.out.println(str);
        var currentIndex = 0;
        while(currentIndex < str.length()){

            var sizeOfStringToParse = new StringBuilder();
            while(str.charAt(currentIndex) != '#'){
                sizeOfStringToParse.append(str.charAt(currentIndex));
                currentIndex++;
            }
            
            currentIndex++; // Skip # char
            int stringSize = Integer.parseInt(sizeOfStringToParse.toString());
            
            var stringToAdd = new StringBuilder();

            for(int i = currentIndex; i < currentIndex + stringSize; i++){
                stringToAdd.append(str.charAt(i));
            }

            results.add(stringToAdd.toString());
            // plus one to skip to delimeter char
            currentIndex += stringSize;
        }

        return results;
    }
}
