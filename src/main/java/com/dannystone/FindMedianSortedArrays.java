package com.dannystone;

/**
 * Created with IntelliJ IDEA.
 * Description: 看完官方题解思路没看代码，自己写一遍.
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-shu-b/
 * 临时写的时候可以举两个例子（一个总个数奇数，一个总个数偶数）。
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2020/3/28 8:57 PM
 */
public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int m = nums1.length;
//        int n = nums2.length;
//        if (m > n) { // to ensure m<=n
//            int[] temp = nums1;
//            nums1 = nums2;
//            nums2 = temp;
//            int tmp = m;
//            m = n;
//            n = tmp;
//        }
//
//        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
//        while (iMin <= iMax) {
//            int i = (iMin + iMax) / 2;
//            int j = halfLen - i;
//            if (i < iMax && nums2[j - 1] > nums1[i]) {
//                iMin = i + 1;
//
//            }
//        }
//        //假设存在 0<=i<=m, 0<=j<=n
//        // 使得 nums1[i] <= nums2[j+1]
//        // 使得 nums2[j] <= nums1[i+1]
//        // 使得 i+j = m+n-(i+j) (总数偶数)或 i+j = m+n+1-(i+j) （总数奇数）
//        int i = 0;
//        boolean ouShuCount = (m + n) % 2 == 0;
//        int j = ouShuCount ? (m + n) / 2 - i : (m + n - 1) / 2;
//
//        while () {
//            i++;
//            j = ouShuCount ? (m + n) / 2 - i : (m + n - 1) / 2;
//        }
//
//
//        if (ouShuCount) {
//            return (nums1[i] + nums2[j]) / 2;
//        } else {
//            return Math.max(nums1[i], nums2[j]);
//        }


        int m = nums1.length;
        int n = nums2.length;
//        //因为 j=(m + n) / 2 - i 而0<=i<=m,为了避免 m>n 而出现j<0 可先做统一 m<n
        if (m > n) { // to ensure m<=n
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }

        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        //二分查找确定i的值,新体会到二分查找不一定是要找一个确定的数，也可以是找一个满足于特定条件的约束
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && nums2[j - 1] > nums1[i]) {
                iMin = i + 1; // i is too small
            } else if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax = i - 1; // i is too big
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums2[j], nums1[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 6, 7, 8, 9};
        int[] nums2 = new int[]{1, 2, 3, 4, 9, 10};
        findMedianSortedArrays(nums1, nums2);
    }
}
