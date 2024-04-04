import java.util.Scanner;

public class MaxSumPath {
    public static int maxSumPath(int[] arr1, int[] arr2) {
        int sum1 = 0, sum2 = 0, maxSum = 0;
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                sum1 += arr1[i++];
            } else if (arr1[i] > arr2[j]) {
                sum2 += arr2[j++];
            } else {
                maxSum += Math.max(sum1, sum2) + arr1[i];
                sum1 = sum2 = 0;
                i++;
                j++;
            }
        }
        while (i < arr1.length) {
            sum1 += arr1[i++];
        }
        while (j < arr2.length) {
            sum2 += arr2[j++];
        }
        maxSum += Math.max(sum1, sum2);
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the first array: ");
        int n1 = scanner.nextInt();
        int[] arr1 = new int[n1];
        System.out.println("Enter elements of the first array:");
        for (int i = 0; i < n1; i++) {
            arr1[i] = scanner.nextInt();
        }

        System.out.print("Enter the size of the second array: ");
        int n2 = scanner.nextInt();
        int[] arr2 = new int[n2];
        System.out.println("Enter elements of the second array:");
        for (int i = 0; i < n2; i++) {
            arr2[i] = scanner.nextInt();
        }
        System.out.println("Maximum sum path: " + maxSumPath(arr1, arr2));
        scanner.close();
    }
}