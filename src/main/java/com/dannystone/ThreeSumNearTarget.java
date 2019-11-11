package com.dannystone;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2019/11/11 10:24 PM
 */
public class ThreeSumNearTarget {
    public static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            //排序
            for(int i=0;i<nums.length-1;i++){
                for(int j=i+1;j<nums.length;j++){
                    if(nums[i]>nums[j]){
                        int temp=nums[j];
                        nums[j]=nums[i];
                        nums[i]=temp;
                    }
                }
            }

            //最近值可以取一个初始化的值，最终总会收拢
            int nearSum=nums[0]+nums[1]+nums[2];
            for(int i=0;i<nums.length-2;i++){
                //这样子不对，应该是两两比较
//                for(int j=i;j<i+windowWidth;j++){
//                    tempSum+=nums[j];
//                }
                //双指针
                int l=i+1,r=nums.length-1;
                while (l<r){
                    int sum= nums[i] + nums[l] + nums[r];
                    if(Math.abs(target-sum)-Math.abs(target-nearSum)<0){
                        nearSum = sum;
                    }
                    //逼近 收拢
                    if(sum<target){
                        l++;
                    }else if(sum>target){
                        r--;
                    }else{
                        return sum;
                    }

                }

            }
            return nearSum;
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{0,2,1,-3};

        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(nums, 1));

    }
}
