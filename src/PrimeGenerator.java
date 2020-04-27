/**
 * 이 클래스는 사용자가 지정환 최대값까지의 소수를 생성한다.
 * 사용한 알고리즘은 에라토스테네스의 체다.
 * 2부터 시작하는 정수 배열을 받는다.
 * 지워지지 않은 첫 번째 정수를 찾아 그 배수를 모두 지운다.
 * 이것을 배열에 더 이상의 배수가 없을 때 까지 계속한다.
 */

public class PrimeGenerator {
    private static boolean[] crossedOut;
    private static int[] result;

    public static int[] generatorPrimes(int maxValue) {
        if (maxValue < 2)
            return new int[0];
        else {
            uncrossIntegersUpTo(maxValue);
            crossOutMultiples();
            putuncrossedIntegersIntoResult();
            return result;
        }
    }

    private static void uncrossIntegersUpTo(int maxValue) {
        crossedOut = new boolean[maxValue +1];
        for (int i = 2; i < crossedOut.length; i++)
            crossedOut[i] = false;
    }

    private static void crossOutMultiples() {
        int limit = determineIterationLimit();
        for (int i = 2; i <= limit ; i++)
            if (notCrossed(i))
               crossOutMultiplesOf(i);
    }

    private static int determineIterationLimit() {
        // 배열에 있는 모든 배수는 배열 크기의 제곱근 보다 작거나 같은 소인수를 갖는다.
        // 그러므로 소인수보다 큰 숫자의 배수는 지울 필요가 없다.
        double iterationLimit = Math.sqrt(crossedOut.length);
        return (int) iterationLimit;
    }

    private static void crossOutMultiplesOf(int i) {
        for (int multiple = 2 * i; multiple < crossedOut.length; multiple += i)
            crossedOut[multiple] = true;
    }

    private static boolean notCrossed(int i) {
        return crossedOut[i] == false;
    }

    private static void putuncrossedIntegersIntoResult() {
        result = new int[numberOfUncrossedIntegers()];
        for (int j = 0, i = 2; i < crossedOut.length; i++)
            if (notCrossed(i))
                result[j++] = i;
    }

    private static int numberOfUncrossedIntegers() {
        int count = 0;
        for (int i = 2; i < crossedOut.length; i++)
            if (notCrossed(i))
                count++;

        return count;
    }
}
