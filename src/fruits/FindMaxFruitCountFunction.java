package fruits;

import java.util.HashMap;

public class FindMaxFruitCountFunction {
	public int totalFruit(int[] tree) {
		if (tree == null || tree.length == 0) {
			return 0;
		}

		// Key is each unique fruits, value is the last index that was seen
		HashMap<Integer, Integer> map = new HashMap<>();

		// Sliding windowing method
		int i = 0;
		int j = 0;
		int max = 1;

		// j will continue to move until the end
		while (j < tree.length) {
			// If its still within the range or 2 unique fruits
			if (map.size() <= 2) {
				map.put(tree[j], j);
				j++;
			}

			// Remove the fruit when we have more than 2 fruits in our map
			if (map.size() > 2) {
				// given: tree[i] < tree.length
				int min = tree.length - 1;

				// Get the least index from hashmap
				for (int value : map.values()) {
					min = Math.min(min, value);
				}

				// i pointer will now move to the next element
				i = min + 1;

				// Remove the last fruit seen completely
				map.remove(tree[min]);
			}

			// j - i will always be the current max size of the window
			max = Math.max(max, j - i);
		}

		return max;
	}

	public int totalFruit1(int[] tree) {
		// Default value as -1
		int lastFruit = -1;
		int secondLastFruit = -1;
		
		int lastFruitsCount = 0;
		int currentMax = 0;
		int max = 0;

		for (int fruit : tree) {
			if (fruit == lastFruit || fruit == secondLastFruit) { // increase the max if it is still within the rule
				currentMax++;
			} else {
				// If we found new fruit
				currentMax = lastFruitsCount + 1;
			}

			// lastFruitsCount will be the number of continue count from element previous
			if (fruit == lastFruit) {
				lastFruitsCount++;
			} else {
				lastFruitsCount = 1;
			}

			// If we found new fruit, update them now
			if (fruit != lastFruit) {
				secondLastFruit = lastFruit;
				lastFruit = fruit;
			}

			max = Math.max(max, currentMax);
		}

		return max;
	}
}
