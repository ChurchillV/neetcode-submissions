class Solution {
    // O(log(m+n)) solution
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        int totalSize = size1 + size2;

        if(size2 < size1) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tmp = size1;
            size1 = size2;
            size2 = tmp;
        }

        int right = size1;
        int left = 0;

        while(left <= right) {
            int mid1 = (right + left) / 2;
            int mid2 = (totalSize + 1) / 2 - mid1;

            int left1 = (mid1 > 0) ? nums1[mid1-1] : Integer.MIN_VALUE;
            int right1 = (mid1 < size1) ? nums1[mid1] : Integer.MAX_VALUE ;

            int left2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int right2 = (mid2 < size2) ? nums2[mid2] : Integer.MAX_VALUE;

            if(left1 <= right2 && left2 <= right1) {
                return (totalSize % 2 == 0) 
                ? (Math.max(left1, left2) + Math.min(right1, right2))/ 2.0 
                : Math.max(left1, left2);
            } else if(left1 > right2){
                right = mid1 - 1;
            } else {
                left = mid1 + 1;
            }
        }

        return -1;
    }
}
