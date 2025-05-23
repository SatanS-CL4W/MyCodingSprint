class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 2;

        while(low <= high) {
            int mid = low + (high - low)/2;

            if(arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            else if(arr[mid - 1] < arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }            
        }

        return -1;
    }
}