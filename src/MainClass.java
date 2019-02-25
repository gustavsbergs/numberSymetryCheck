import java.util.Scanner;
public class MainClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Input lower range:");
        Integer lowerRange = input.nextInt();
        input.reset();

        System.out.println("Input upper range:");
        Integer upperRange = input.nextInt();
        input.reset();


        if(lowerRange<upperRange){
           Integer[] numbersToCheck = createArrayOfNumbersToCheck(lowerRange, upperRange);
           Integer[] result1 = checkForSymmetry(numbersToCheck);
           Integer[] result2 = checkForSymmetryOfSquare(result1);

           for(int i = 0; i<result2.length; i++){
               if(result2[i] != null) {
                   System.out.println("Symmetrical number: " + result2[i]);
               }
           }
        }
    }

    private static Integer[] createArrayOfNumbersToCheck(Integer lowerRange, Integer upperRange){
        Integer[] neededNumbers = new Integer[(upperRange-lowerRange) + 1];
        int index = 0;
        for(int i = lowerRange; i<= upperRange; i++ ){
            neededNumbers[index] = i;
            index++;
        }
        return neededNumbers;
    }

    private static Integer[] checkForSymmetry(Integer[] integers){
        Integer[] result = new Integer[integers.length];
        for(int i = 0; i<integers.length; i++){
            Integer integerToCompare = integers[i];
            String integerToReverse = integerToCompare.toString();
            String reversedInteger = "";

            for(int f = integerToReverse.length() - 1; f>=0; f--){
                reversedInteger = reversedInteger + integerToReverse.charAt(f);
            }
            if(reversedInteger.equals(integerToReverse) && reversedInteger.length() > 1){
                result[i] = integerToCompare;

            }
        }
        return result;
    }
    private static Integer[] checkForSymmetryOfSquare(Integer[] integers){
        Integer[] result = new Integer[integers.length];
        for(int i = 0; i<integers.length; i++){
            if(integers[i] != null) {
                Integer integerToCompare = integers[i] * integers[i];
                String integerToReverse = integerToCompare.toString();
                String reversedInteger = "";

                for (int f = integerToReverse.length() - 1; f >= 0; f--) {
                    reversedInteger = reversedInteger + integerToReverse.charAt(f);
                }
                if (reversedInteger.equals(integerToReverse) && reversedInteger.length() > 1) {
                    result[i] = integers[i];

                }
            }
    }
        return result;
    }
}
