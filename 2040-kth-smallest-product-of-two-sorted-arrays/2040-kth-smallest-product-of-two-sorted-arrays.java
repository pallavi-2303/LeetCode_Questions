class Solution {
    public long findCount(int[] nums1, int[] nums2, long midProduct) {
        long countProduct = 0;
        int n = nums2.length;
        //we will search for nums1 how many productvwe can form with nums2 2 if we have product less than equal to given product 
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] >= 0) {
                int l = 0;
                int r = n - 1;
                int m = -1;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    long product = (long)nums2[mid] * nums1[i];
                    if (product <= midProduct) {
                        m = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                countProduct += (m + 1);
            } else {
                //if nums1 is negative 
                int l = 0;
                int r = n - 1;
                int m = n;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    long product = (long)nums1[i] * nums2[mid];
                    if (product <= midProduct) {
                        m = mid;
                        r = mid - 1;
                        ;
                    } else {
                        l = mid + 1;
                    }
                }
                countProduct += (n - m);
            }
        }
        return countProduct;
    }

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        // we need kth smallest to find kth smallest we will try for every possible value of K
        long left = -1_000_000_0000L; // -1e10
        long right = 1_000_000_0000L;//1e10
        long result = 0;
        //apply binary search 
        while (left <= right) {
            long mid = left + ((right - left) >> 1);
            long countEquals = findCount(nums1, nums2, mid);
            if (countEquals >= k) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;

    }
}