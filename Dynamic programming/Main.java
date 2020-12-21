import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int V = 6;
        int N = 4;
        int[] weights = {5, 6, 10, 9};
        int[] values = {200, 66, 100, 72};
        int total = ZeroOnePack(V, N, weights, values);
        System.out.println(total);
        int[] array = {1, 5, 6};
        System.out.println(WaysToSum(7, array));
    }

    public static int ZeroOnePack(int V, int N, int[] weights, int[] values){
        int[][] map = new int[N+1][V+1];
        for(int i = 1; i <= N; i++){
            int weight = weights[i-1];
            int value = values[i-1];
            for(int j = 1; j <= V; j++){
                if(j - weight < 0 ){
                    map[i][j] = map[i-1][j];
                    continue;
                }
                map[i][j] = Math.max(map[i-1][j], map[i-1][j-weight] + value);
            }
        }
        return map[N][V];
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
}
