package leetcode33searchrotatedsortedarray;

public class LeetCode33SearchRotatedSortedArray {

    public static void main(String[] args) {
        int[] v = {};
        int i = search(v, 1);
        System.out.println(i);
    }

    // Search for target in rotated sorted array nums. Return index if found, -1 otherwise.
    public static int search(int[] nums, int target) {
        if( nums.length == 0 )
            return -1;
        
        int left = 0;                // Leftmost possible index of target.
        int right = nums.length - 1; // Rightmost possible index of target.

        while ( left < right - 1 ) {
            int mid = ( left + right ) / 2;   // Midpoint of left and right.

            if ( nums[mid] < nums[right] ) {  // Check if mid is to the right of smallest entry.

                if ( nums[left] > nums[right] && nums[left] <= target ) {
                    right = mid - 1;          // Check if a rotation was actually done, and if
                    continue;                 // target lies to left of mid.
                }

            } else {                          // Case where mid is to left of smallest entry.

                if ( target <= nums[right] ) {
                    left = mid + 1;           // Check if target lies to right of mid. 
                    continue;
                }
            }
            if ( nums[mid] < target )         // If we have not hit a "continue" at this point then
                left = mid + 1;               // we may proceed as in ordinary binary search.
            else
                right = mid;
        }
        if( nums[left] == target )    //Check if target actually appears. 
            return left;
        if( nums[right] == target )
            return right;
        return -1;
    }
}
