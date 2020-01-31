import java.util.regex.*;
public class stringCalculator {
    static String regex = "[\\d\\-]+";
    static String RegSquareBracket = "[/]{2}(\\[).+(])(\\[).+(])";
    static String delimiterBracket = "(?<=\\[).+?(?=\\])";
    public static void main(String[] args)  {

        System.out.println(stringCalculator.add("-1,2,-3,4"));
    }
    public static int add(String input)throws IllegalArgumentException{
        int sum = 0;
        String results = "";
        if(input.isEmpty()){
            return sum;
        }
        if(!Character.isDigit(input.charAt(input.length()-1))){
            throw new RuntimeException("Error: invalid input");
        }
        else if(input.startsWith(" ")){
            throw new RuntimeException("Error: invalid input");
            }
        else if(Character.isDigit(input.charAt(0))&& input.contains("//")){
            throw new RuntimeException("Error: invalid input");
        }
          else if(Pattern.compile(RegSquareBracket).matcher(input.split("\n")[0]).matches()) {
            String []output = input.split("\n");
            Pattern p = Pattern.compile(delimiterBracket);
            Matcher match = p.matcher(output[0]);
            while (match.find()) {
                output[1] = output[1].replace(match.group(),",");
            }
            String []result = output[1].split(",");
            for(String a: result){
                sum += Integer.parseInt(a);
            }
          }
        else if(input.startsWith("//")) {
            input = input.replace(input.substring(2, input.indexOf("\n")), ",");
            Pattern pa = Pattern.compile(regex);
            Matcher mat = pa.matcher(input);
            while (mat.find()) {
                if (Integer.parseInt(mat.group()) >= 1000) {
                    continue;
                } else {
                    sum += Integer.parseInt(mat.group());
                }
            }
        }

        else if(input.contains("")){
            Pattern p = Pattern.compile(regex);
            Matcher match = p.matcher(input);

            while(match.find()){
                if(Integer.parseInt(match.group())<0){
                  results += match.group()+ ",";
                  if(Integer.parseInt(match.group())>=1000);
                  continue;
                }else {
                    sum += Integer.parseInt(match.group());
                }

                if(Math.abs(Integer.parseInt(match.group()))==Integer.parseInt(input.substring(input.length() - 1)) &&!results.equals("")){
                   try {
                       throw new IllegalArgumentException(results);
                   }catch (IllegalArgumentException e){
                       throw new IllegalArgumentException("ERROR: negatives not allowed "+results.substring(0,results.length()-1));
                   }
                }

            }
        }
        return sum;
    }
}
