/*
 * In selection sort algorithm, we search for the lowest element and arrange it to the proper location.
 * We swap the current element with the next lowest number.
 * 
 * Selection sort is good to use for small number of input elements
 * 
 * Best Case        :    O(n^2)
 * Average Case   :    O(n^2)
 * Worst Case      :    O(n^2)
 * 
 * Among simple average-case Θ(n2) algorithms, selection sort almost always outperforms bubble sort and gnome sort, but is generally outperformed by insertion sort.
 * 
 * Insertion sort's advantage is that it only scans as many elements as it needs in order to place the k + 1st element, 
 * while selection sort must scan all remaining elements to find the k + 1st element.
 * 
 * While selection sort is preferable to insertion sort in terms of number of writes (Θ(n) swaps versus Ο(n2) swaps),
 * it almost always far exceeds (and never beats) the number of writes that cycle sort makes, as cycle sort is theoretically optimal in the number of writes.
 * This can be important if writes are significantly more expensive than reads, such as with EEPROM or Flash memory, 
 * where every write lessens the lifespan of the memory.
 */
public class SelectionSort {
	private int[] numbers;

	public SelectionSort(int[] array) {
		numbers = array;
	}

	public void sort() {
		int n = numbers.length;
		for (int i = 0; i < n - 1; i++) {
			int index = i;
			for (int j = i + 1; j < n; j++) {
				if (numbers[j] < numbers[index]) {
					index = j;
				}
			}
			int temp = numbers[i];
			numbers[i] = numbers[index];
			numbers[index] = temp;
		}
	}

	public void display() {
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + "\t");
		}
		System.out.print("\n____________________________________________\n");
	}

	public static void main(String[] args) {
		int[] numbers = { 19, 8, 2, 23, 10, 1 };
		SelectionSort selection = new SelectionSort(numbers);
		selection.display();
		selection.sort();
		selection.display();
	}
}
