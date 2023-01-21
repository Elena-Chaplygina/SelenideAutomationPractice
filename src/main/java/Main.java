public class Main {

    public static void main(String[] args) {
        //Переполнение при вычислении
        System.out.println("Переполнение при вычислении");
        byte varByte = 10; //-128....127 (-2^7.....(2^7)-1)
        byte varByteOverflow = (byte) (varByte * 12.8);
        System.out.println(varByteOverflow);

        short varShort = 30000;// -32768.....32767
        short varShortOverflow = (short) (varShort + 3000);
        System.out.println(varShortOverflow);

        int varInt = -2147483648; //-2147483648 ...... 2147483647
        int varIntOverflow = varInt - 2;
        System.out.println(varIntOverflow);

        long varLong = 100000000000L;//–9 223 372 036 854 775 808 ...... 9 223 372 036 854 775 807
        long varLongOverflow = varLong * 100000000;
        System.out.println(varLongOverflow);

        //Вычисления комбинаций типов данных
        System.out.println("Вычисления комбинаций типов данных");
        double varDouble =5.6565565;
        varInt= (int) (varInt+varDouble);
        System.out.println(varInt);
        varDouble=varInt+varDouble;
        System.out.println(varDouble);



    }
}
