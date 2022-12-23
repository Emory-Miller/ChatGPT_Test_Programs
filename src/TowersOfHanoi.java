public class TowersOfHanoi {
    public static void solve(int n, String source, String dest, String temp) {
        if (n == 1) {
            System.out.println("Move disc 1 from " + source + " to " + dest);
        } else {
            solve(n - 1, source, temp, dest);
            System.out.println("Move disc " + n + " from " + source + " to " + dest);
            solve(n - 1, temp, dest, source);
        }
    }

    public static void main(String[] args) {
        int n = 100; // Number of discs
        solve(n, "A", "C", "B");
    }
}
