package neetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Task3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5,}, 22)));
    }

    public static int[] twoSum(int[] nums, int target) {
        // Создаем HashMap для хранения значений и их индексов
        Map<Integer, Integer> map = new HashMap<>();

        // Проходим по массиву
        for (int i = 0; i < nums.length; i++) {
            // Вычисляем разницу между целью и текущим элементом
            int complement = target - nums[i];

            // Проверяем, есть ли эта разница в HashMap
            if (map.containsKey(complement)) {
                // Если да, возвращаем индексы
                return new int[] { map.get(complement), i };
            }

            // Если нет, добавляем текущий элемент в HashMap
            map.put(nums[i], i);
        }

        // Если решение не найдено, возвращаем пустой массив
        throw new IllegalArgumentException("No two sum solution");
    }
}
