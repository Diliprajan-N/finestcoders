import java.util.*;

public class leetcode271 {
    Random random = new Random();

    
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }
    public Map.Entry<Boolean, List<String>> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;

        try {
            while (i < s.length()) {
                int j = i;
                while (j < s.length() && s.charAt(j) != '#') j++;

                if (j == s.length()) {
                    
                    return new AbstractMap.SimpleEntry<>(false, result);
                }

                int length = Integer.parseInt(s.substring(i, j));
                int start = j + 1, end = j + 1 + length;

                if (end > s.length()) {
                    
                    return new AbstractMap.SimpleEntry<>(false, result);
                }

                String word = s.substring(start, end);
                result.add(word);

                i = end; 
            }
        } catch (Exception e) {
        
            return new AbstractMap.SimpleEntry<>(false, result);
        }

        return new AbstractMap.SimpleEntry<>(true, result);
    }

    public List<String> transmit(List<String> strs) {
        while (true) {
            String encoded = encode(strs);

            
            String transmitted = maybeTamper(encoded);


            Map.Entry<Boolean, List<String>> res = decode(transmitted);

            if (res.getKey()) {
                
                return res.getValue();
            } else {
                
                System.out.println("Transmission tampered. Partial decoded: " + res.getValue());
            }
        }
    }

    
private String maybeTamper(String encoded) {
    if (random.nextBoolean()) {
        return encoded; 
    } else {
        
        char[] arr = encoded.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {
                arr[i] = (char) ('0' + random.nextInt(9));
                break;
            }
        }
        return new String(arr);
    }
}

// main method 
    public static void main(String[] args) {
        leetcode271 codec = new leetcode271();

         List<String> input1 = Arrays.asList("leet", "code", "love", "you");
        System.out.println("Final Output: " + codec.transmit(input1));

         List<String> input2 = Arrays.asList("we", "say", ":", "yes");
         System.out.println("Final Output: " + codec.transmit(input2));
    }
}
