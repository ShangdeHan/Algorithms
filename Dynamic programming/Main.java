import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int x = 0;
    public static int y = 0;
    public static void main(String[] args) {
        int[] a = {2, -1, 8, -1, 6};
        int[][] b = {{1, 5}, {-5, -5}, {0, 4}, {-1, -1}, {4, 5}, {-5, -3}, {-2, 1}, {-2, -5}, {0, 5}, {0, -1}};
        System.out.println(robotSim(a, b));
    }
//////////////////////////

    public static int robotSim(int[] commands, int[][] obstacles) {
        int angle = 0;
        for(int i = 0; i < commands.length; i++){
            if(commands[i] == -2)angle -= 1;
            else if(commands[i] == -1)angle += 1;
            else{
                if(Math.abs(angle) % 4 == 0){//up
                    if(ob(1, y, commands[i], obstacles))y += commands[i];
                }else if(angle == 1 || ((angle / 2) % 2 == 0 && angle % 2 == 1)){//right
                    if(ob(0, x, commands[i], obstacles))x += commands[i];
                }else if(angle == -1 || ((angle / 2) % 2 == 0 && angle % 2 == -1)){//left
                    if(ob(0, x, -commands[i], obstacles))y -= commands[i];
                }else if(Math.abs(angle) % 2 == 0){//down
                    if(ob(1, y, -commands[i], obstacles))x -= commands[i];
                }
            }
        }
        return (int)(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public static boolean ob(int string, int current, int update, int[][] obstacles){//string == 0 if it is x.
        for(int j = 0; j < obstacles.length; j++){
            if(x == obstacles[j][0]){
                if(string == 1){
                    if(current < obstacles[j][1] && update > 0 && current + update >= obstacles[j][1]){
                        y = obstacles[j][1] -1;
                        return false;
                    }
                    if(current > obstacles[j][1] && update < 0 && current + update <= obstacles[j][1]){
                        y = obstacles[j][1] +1;
                        return false;
                    }
                }
            }
            if(y == obstacles[j][1]){
                if(string == 0){
                    if(current < obstacles[j][0] && update > 0 && current + update >= obstacles[j][0]){
                        x = obstacles[j][0] -1;
                        return false;
                    }
                    if(current > obstacles[j][0] && update < 0 && current + update <= obstacles[j][0]){
                        x = obstacles[j][0] +1;
                        return false;
                    }
                }
            }
        }
        return true;
    }
    ////////////////////////////

    public static int ZeroOnePack(int W, int N, int[] weights, int[] values){
        int[][] map = new int[N+1][W+1];
        for(int i = 1; i <= N; i++){
            int weight = weights[i-1];
            int value = values[i-1];
            for(int j = 0; j <= W; j++){
                if(j - weight < 0 ){
                    map[i][j] = map[i-1][j];
                    continue;
                }
                map[i][j] = Math.max(map[i-1][j], map[i-1][j-weight] + value);
            }
        }
        return map[N][W];
    }

    public static int WaysToSum(int N, int[] array){
        int[] count = new int[N+1];
        count[0] = 1;
        for(int i = 1; i<=N; i++){
            for(int j = 0; j < array.length; j++){
                if(i >= array[j]){
                    count[i] = count[i] + count[i-array[j]];
                }
            }
        }
        return count[N];
    }

    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s ? 0 : subsetstwo494(nums, (s + sum) /2);
    }

    public int subsets494(int[] nums, int T){
        int[][] dp = new int[nums.length+1][T+1];
        dp[0][0] = 1;
        for(int i = 1; i <=nums.length; i++){
            for(int j = 0; j<=T; j++){
                if(j < nums[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][T];
    }

    public int subsetstwo494(int[] nums, int T){
        int[] dp = new int[T+1];
        dp[0] = 1;
        for(int n : nums){
            for(int i = T; i >= n; i--){
                dp[i] += dp[i - n];
            }
        }
        return dp[T];
    }

//416. Partition Equal Subset Sum
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int i = 0; i < nums.length; i++){
            total += nums[i];
        }
        return subsets416(nums, total/2);
    }

    public boolean subsets416(int[] nums, int t){
        boolean[][] dp = new boolean[nums.length+1][t+1];
        dp[0][0] = true;
        for(int i = 1; i <= nums.length; i++){
            dp[i][0] = true;
        }
        for(int i = 1; i <= nums.length; i++){
            for(int j = 1; j <= t; j++){
                if(j >= nums[i-1])
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i-1]];
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[nums.length][t];
    }

    public boolean subsetstwo416(int[] nums, int t){
        boolean[] dp = new boolean[t+1];
        dp[0] = true;
        for(int num : nums){
            for(int i = t; i > 0 ; i--){
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[t];
    }
}
