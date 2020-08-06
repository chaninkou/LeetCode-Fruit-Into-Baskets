package leetcode904;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] tree = {1,2,1,4,3,4,4,5};
		
		System.out.println("Tree: " + Arrays.toString(tree));
		
		FindMaxFruitCountFunction solution = new FindMaxFruitCountFunction();
		
		System.out.println("Solution: " + solution.totalFruit(tree));
	}
}
