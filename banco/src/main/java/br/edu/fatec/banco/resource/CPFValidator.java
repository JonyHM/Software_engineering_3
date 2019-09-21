package br.edu.fatec.banco.resource;

public class CPFValidator {

    public static boolean validate(String CPF) {
        CPF = CPF.length() == 13
                ? CPF.substring(1,12)
                : CPF;

        int first = calculateFirstCheckerNumber(CPF);
        int second = calculateSecondCheckerNumber(CPF);

        first = first == 10 || first == 11 ? 0 : first;
        second = second == 10 || second == 11 ? 0 : second;

        return (first == Character.getNumericValue(CPF.charAt(9)))
                && (second == Character.getNumericValue(CPF.charAt(10)));
    }

    private static int calculateFirstCheckerNumber(String CPF) {
        int amount = 0;
        int multiplier = 10;

        for (int i=0; i<9; i++) {
            amount += (Character.getNumericValue(CPF.charAt(i)) * multiplier);
            multiplier --;
        }

        int remainder = amount % 11;

        return 11 - remainder;
    }

    private static int calculateSecondCheckerNumber(String CPF) {
        int amount = 0;
        int multiplier = 11;

        for (int i=0; i<10; i++) {
            amount += (Character.getNumericValue(CPF.charAt(i)) * multiplier);
            multiplier --;
        }

        int remainder = amount % 11;

        return 11 - remainder;
    }
}
