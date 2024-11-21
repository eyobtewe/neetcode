package two_pointers;

public class MaxWaterContainer {
    public static void main(String[] args) {
        int[] heights = {1, 7, 2, 5, 4, 7, 3, 6};
        System.out.println(maxArea(heights));
    }

    public static int maxArea(int[] heights) {

        int area = 0;
        int left = 0, right = heights.length - 1;

        while ( left < right ) {
            int tempArea = (right - left) * Math.min(heights[right], heights[left]);

            area = Math.max(area, tempArea);

            if ( heights[right] > heights[left] ) {
                left++;
            } else {
                right--;
            }
        }


        return area;
    }
}
