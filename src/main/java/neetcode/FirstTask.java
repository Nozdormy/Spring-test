package neetcode;

import java.util.HashSet;
import java.util.Set;

public class FirstTask {
    public static void main(String[] args) {
        System.out.println(hasDuplicate(new int[]{1, 2, 4, 5}));
    }

    public static boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        // Проходим по массиву
        for (int num : nums) {
            // Если элемент уже есть в HashSet, значит, он повторяется
            if (!set.add(num)) {
                return true; // Возвращаем true, если нашли повторяющийся элемент
            }
        }
        return false;
    }
}
