public class Main {
    public static class FinabocciCalculator {
        public static int number = 1; //первое и второе число

        public static int calculatNumber(Integer index) {
            int[] result = new int[index];
            result[0] = number;
            result[1] = number;
            for (int i = 2; i != result.length; i++) {
                result[i] = result[i - 1] + result[i - 2];
            }
            System.out.println(result[index-1]);
            return result[index-1];
        }

        public static void main(String[] args) {
            FinabocciCalculator calculator = new FinabocciCalculator();
            calculator.calculatNumber(10);
        }
    }
}