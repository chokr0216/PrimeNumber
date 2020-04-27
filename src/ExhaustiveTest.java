public class ExhaustiveTest {
    public  void testExhaustive() {
        for (int i = 2; i < 500; i++) //2부터 500까지 숫자들이 소수인지를 확인
            verifyPrimeList(PrimeGenerator.generatorPrimes(i));
    }

    private  void verifyPrimeList(int[] list) {
        for (int i = 0; i <  list.length; i++)
            verifyPrime(list[i]);
    }

    //해당 수가 소수인지를 확인하고 출력함
    private  void verifyPrime(int n) {
        boolean isPrime = true; //n이 소수인지 아닌지?
        for (int factor = 2; factor < n; factor++)
            if (n % factor ==0)
                isPrime = false; //한번이라도 나뉘면 소수가 아님

        if(isPrime)
            System.out.println(n+" ");
    }
}