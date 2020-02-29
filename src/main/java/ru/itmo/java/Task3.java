package ru.itmo.java;

import java.util.Arrays;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        try {
            int lastElement = inputArray[inputArray.length - 1];
            for (int i = inputArray.length - 2; i >= 0; i--) {
                inputArray[i + 1] = inputArray[i];
            }
            inputArray[0] = lastElement;
            return inputArray;
        } catch (Exception e) {
            return new int[0];
        }
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     * <p>
     * Если входной массив пуст или равен null - вернуть 0
     * <p>
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        try {
            int max = inputArray[0];
            for (int i = 0; i < inputArray.length; i++) {
                for (int j = i + 1; j < inputArray.length; j++) {
                    max = Math.max(max, inputArray[i] * inputArray[j]);
                }
            }
            return max;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     * <p>
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        try {
            String lowerCaseInput = input.toLowerCase();
            int numberOfAB = 0;
            for (int i = 0; i < input.length(); i++) {
                if (lowerCaseInput.charAt(i) == 'a' || lowerCaseInput.charAt(i) == 'b') {
                    numberOfAB++;
                }
            }
            return numberOfAB * 100 / input.length();
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        try {
            for (int i = 0; i < input.length() / 2; i++) {
                if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        try {
            char curentCharacter = input.charAt(0);
            int counterForCurentCharacter = 0;
            StringBuilder resultBuilder = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == curentCharacter) {
                    counterForCurentCharacter++;
                } else {
                    resultBuilder.append(curentCharacter).append(counterForCurentCharacter);
                    counterForCurentCharacter = 1;
                    curentCharacter = input.charAt(i);
                }
            }
            resultBuilder.append(curentCharacter).append(counterForCurentCharacter);
            return resultBuilder.toString();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        try {
            if (one.length() == 0)
                return false;
            char[] firstChars = one.toCharArray();
            char[] secondChars = two.toCharArray();
            Arrays.sort(firstChars);
            Arrays.sort(secondChars);
            for (int i = 0; i < firstChars.length; i++) {
                if (firstChars[i] != secondChars[i]) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        try {
            if (s.length() == 0) {
                return false;
            }
            boolean[] unique = new boolean[1 << 16];
            for (int i = 0; i < s.length(); i++) {
                if (unique[s.charAt(i)]) {
                    return false;
                }
                unique[s.charAt(i)] = true;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     * <p>
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        try {
            for (int i = 0; i < m.length; i++) {
                for (int j = i + 1; j < m[i].length; j++) {
                    int buffer = m[i][j];
                    m[i][j] = m[j][i];
                    m[j][i] = buffer;
                }
            }
            return m;
        } catch (Exception e) {
            return new int[][]{{}, {}};
        }
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     * <p>
     * Запрещается пользоваться функций join
     * <p>
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        try {
            if (separator == null) {
                separator = ' ';
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(inputStrings[0]);
            for (int i = 1; i < inputStrings.length; i++) {
                stringBuilder.append(separator).append(inputStrings[i]);
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        try {
            int counter = 0;
            for (String s : inputStrings) {
                if (s.startsWith(prefix)) {
                    counter++;
                }
            }
            return counter;
        } catch (Exception e) {
            return 0;
        }
    }
}
