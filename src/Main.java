import java.util.Arrays;

/**
 * Home work 1.
 * @author Ievlev Andrey.
 * @version Oct 2, 2018.
 * @Link https://github.com/OLskrain/AlgorithmsHM1.git
 */

public class Main {
    public static void main(String[] args) {
        int a = 2;
        int n = 3;
        int [] list = {42,23,12,64,9,55};
        int [][] list2 = {{1,2,3},{4,5,6}};

        System.out.println("Возведение в степень(используя четность): " + binaryExponentiation(a,n));
        System.out.println("Возведение в степень (не рекурсия): " + power(a,n));
        System.out.println("Возведение в степень (рекурсия): " + powerRec(a,n));
        System.out.println("Минимальный элемент массива: " + minimumElement(list));
        System.out.println("Среднее арифметическое значение массива: " + arithmeticalMean(list));
        System.out.println("Среднее арифметическое значение двумерного массива: " + arithmeticalMean2(list2));
        System.out.println(Arrays.toString(list)); //выввод массива

    }
    //Алгоритм возведения в степень(используя четность). Сложность O(log n), так как у нас он работает по принципу "деления по полам"
    //это видно если описать метод на математические формулы:
    private static int binaryExponentiation(int a, int n) {
        if (n == 0)
            return 1;
        //если "n" - не четное, то "а" в степени "n" - это "а" в степени "n-1" умноженное на "а"
        if (n % 2 == 1)
            return binaryExponentiation(a, n-1) * a;
        else {
            //используя теорию мы знает что "а" в степени "n",если "n"-четное, можно представить как "a" в степени "n/2"
            //умноженную "a" в степени "n/2":
            int b = binaryExponentiation(a, n/2);
            return b * b;
        }
    }

    //от препода Возведение в сепень(не рекурсия). Сложность O(n)
    private static int power(int base, int sign){
        int result = 1;
        for (int i = 0; i < sign; i++) {
            result *= base;
        }
        return result;
    }

    //от препода Возведение в степень (рекурсия). Сложность O(n)
    private static int powerRec(int base, int sing){
        if (sing == 0) {
            return 1;
        }
        return powerRec(base, --sing) * base;
    }

    //Алгоритм поиска минимального значения. Сложность O(n), так как с увеличение элементов в массиве на "n" элементов
    //количество операций в цикле так же увеличится на "n" повторений
    private static int minimumElement(int[] list){
        int min = list[0];
        for (int i = 0; i < list.length; i++) {
            if(list[i] < min){
                min = list[i];
            }
        }
        return min;
    }

    //Алгоритм вычмсления среднего арифметического значения. Сложность O(n), так как с увеличение элементов в массиве на "n" элементов
    //количество операций в цикле так же увеличится на "n" повторений
    private static double arithmeticalMean(int[] list){
        double result = 0;
        for (int i = 0; i < list.length; i++) {
            result = result + list[i];
        }
        result = result / list.length;
        return result;
    }

    //Алгоритм вычмсления среднего арифметического значения. Сложность O(n в степени 2), так как
    //при прохождении одного шага в одном цикле мы перебираем значения вторым циклом. Иными словами время работы алгоритма
    //зависит от квадрата размера входного массива.
    private static double arithmeticalMean2(int[][] list2){
        double result = 0;
        for (int i = 0; i < list2.length; i++) {
            for (int j = 0; j < list2[i].length; j++) {
                result = result + list2[i][j];
            }
        }
        result = result / (list2.length * list2[0].length);
        return result;
    }
}
