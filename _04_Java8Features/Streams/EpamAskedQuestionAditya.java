//package StreamsJava;
//
//
//import java.util.*;
//import java.math.BigDecimal;
//import java.math.RoundingMode;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//class SampleNormalizer {
//
//    /**
//     * Normalizes the given BigDecimal value.
//     * Rules (Sample Logic):
//     * 1. Returns null if value is greater than 100
//     * 2. Scales value to 2 decimal places
//     * 3. Divides value by 10 to normalize
//     */
//    public BigDecimal normalize(BigDecimal value) {
//        if (value == null) {
//            return null;
//        }
//        // Example condition where normalization fails
//        if (value.compareTo(BigDecimal.valueOf(40)) > 0) {
//            return null;
//        }
//        // Normalize value
//        return value
//                .divide(BigDecimal.TEN, 2, RoundingMode.HALF_UP);
//    }
//}
//
//class Solution1{
//    public static Stream<BigDecimal> preprocess(Stream<BigDecimal> input) {
//
//        SampleNormalizer normalizer = new SampleNormalizer();
//
//        Stream<BigDecimal> result = input;
//
//
//                // TODO Step 1: Remove null values
//            result =   input.filter(Objects::nonNull);
//                // TODO Step 2: Remove negative values
//             result = result.filter(n->n.compareTo(BigDecimal.ZERO) > 0);
//                // TODO Step 3: Create tuples of 3 elements
//         result = result.collect(Collectors.toSet());
//
//
//                // TODO Step 4: Remove incomplete tuples
//
//                // TODO Step 5: Calculate average of each tuple
//
//                // TODO Step 6: Remove tuples with average > 30
//
//                // TODO Step 7: Normalize each element using SampleNormalizer
//
//                // TODO Step 8: Remove null values returned by normalizer
//
//                // TODO Step 9: Return Stream<BigDecimal>
//
//        return result;
//
//    }
//}
//
//
//public class EpamAskedQuestionAditya {
//    public static void main(String[] args) {
//
//        // Sample Input
//        List<BigDecimal> inputList = Arrays.asList(
//                new BigDecimal("10"),
//                new BigDecimal("14"),
//                new BigDecimal("15"),
//                new BigDecimal("18"),
//                new BigDecimal("0"),
//                null,
//                new BigDecimal("-5"),
//                new BigDecimal("120")
//        );
//
//        // Convert List to Stream
//        Stream<BigDecimal> inputStream = inputList.stream();
//
//        // Call preprocess method
//        Stream<BigDecimal> result = Solution1.preprocess(inputStream);
//
//        // Print Output
//        result.forEach(System.out::println);
//    }
//
//}
