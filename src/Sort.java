public class Sort {

	public static int partition(int[] arr, int l, int r) {
		int pivot = arr[l];
		while (l < r) {
			while (l < r && pivot <= arr[r])
				r--;
			if (l < r) {
				arr[l] = arr[r];
				l++;
			}
			while (l < r && pivot > arr[l])
				l++;
			if (l < r) {
				arr[r] = arr[l];
				r--;
			}
		}
		arr[l] = pivot;
		return l;
	}

	public static void quickSort(int[] arr, int l, int r) {
		if (l < r) {
			int pos = partition(arr, l, r);
			quickSort(arr, l, pos - 1);
			quickSort(arr, pos + 1, r);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 4, 3, 2, 5 ,0,1};
		quickSort(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
}
