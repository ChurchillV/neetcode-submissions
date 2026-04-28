class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Size = nums1.length;
        int nums2Size = nums2.length;
        int totalSize = nums1Size + nums2Size;
        int[] arr = new int[totalSize];

        int ptr1 = 0;
        int ptr2 = 0;
        int index = 0;

        while(index < totalSize) {
            int n1 = (ptr1 < nums1Size) ? nums1[ptr1] : Integer.MAX_VALUE;
            int n2 = (ptr2 < nums2Size) ? nums2[ptr2] : Integer.MAX_VALUE;

            if(n1 < n2) {
                arr[index] = n1;
                ptr1++;
            } else {
                arr[index] = n2;
                ptr2++;
            }

            index++;
        }

        
        double mid = (totalSize % 2) == 0 ? ((double) (arr[totalSize/2] + arr[totalSize/2 - 1]) / 2) : (double) arr[totalSize/2];
        return mid;
    }

}
