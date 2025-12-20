class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //since the array is sorted we can use merge sort aproch to find the median elements
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int ele1 = -1;
        int ele2 = -1;
        int idx1 = n / 2;
        int idx2 = n / 2 - 1;
        int idx = 0;
        int i = 0;
        int j = 0;
        while (i < n1 && j < n2) {
            if (nums1[i] <= nums2[j]) {
                if (idx == idx1) {
                    ele1 = nums1[i];
                }
                if (idx == idx2) {
                    ele2 = nums1[i];
                }
                i++;
                idx++;
            } else {
                if (idx == idx1) {
                    ele1 = nums2[j];
                }
                if (idx == idx2) {
                    ele2 = nums2[j];
                }
                j++;
                idx++;
            }
        }
        while (i < n1) {
            if (ele1 != -1 && ele2 != -1)
                break;
            if (idx == idx1) {
                ele1 = nums1[i];
            }
            if (idx == idx2) {
                ele2 = nums1[i];
            }
            idx++;
            i++;
        }
        while (j < n2) {
            if (ele1 != -1 && ele2 != -1)
                break;
            if (idx == idx1) {
                ele1 = nums2[j];
            }
            if (idx == idx2) {
                ele2 = nums2[j];
            }
            idx++;
            j++;
        }
        return n%2==1 ? ele1 :(ele1+ele2)/2.0;
    }
}