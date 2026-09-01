class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {

        int[] diff = new int[n + 2];
        for (int[] booking : bookings) {

            int start = booking[0];
            int end = booking[1];
            int seats = booking[2];

            diff[start] += seats;
            diff[end + 1] -= seats;
        }

       
        int[] answer = new int[n];
        int current = 0;

        for (int i = 1; i <= n; i++) {

            current += diff[i];

            answer[i - 1] = current;
        }

        return answer;
    }
}