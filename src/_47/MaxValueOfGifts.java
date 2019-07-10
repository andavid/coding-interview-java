package _47;

public class MaxValueOfGifts {
  /**
   * 在一个m*n的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于0）。
   * 从左上角开始拿礼物，每次向右或向下移动一格，直到右下角结束。
   * 给定一个棋盘，求拿到礼物的最大价值。
   *
   * dp[i][j] = data[i][j] + max(dp[i][j+1],dp[i+1][j])
   */
  public static int getMaxVaule(int[][] data) {
    if (data == null || data.length == 0 || data[0].length == 0) {
      return 0;
    }

    int rowMax = data.length;
    int colMax = data[0].length;
    int[][] dp = new int[rowMax + 2][colMax + 2];

    for (int row = rowMax; row > 0; row--) {
      for (int col = colMax; col > 0; col--) {
        dp[row][col] = data[row - 1][col - 1] + Math.max(dp[row][col + 1], dp[row + 1][col]);
      }
    }

    return dp[1][1];
  }

  public static void main(String[] args) {
    int[][] data = {
        {1,10,3,8},
        {12,2,9,6},
        {5,7,4,11},
        {3,7,16,5}
    };
    System.out.println(getMaxVaule(data));
  }
}
