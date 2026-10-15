
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];

        // If both colors are the same, no changes are needed
        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);

        return image;
    }

    private void dfs(int[][] image, int r, int c,
                     int originalColor, int color) {

        int m = image.length;
        int n = image[0].length;

        // Check boundaries and original color
        if (r < 0 || r >= m || c < 0 || c >= n
                || image[r][c] != originalColor) {
            return;
        }

        // Change the pixel color
        image[r][c] = color;

        // Visit four adjacent pixels
        dfs(image, r - 1, c, originalColor, color); // Up
        dfs(image, r + 1, c, originalColor, color); // Down
        dfs(image, r, c - 1, originalColor, color); // Left
        dfs(image, r, c + 1, originalColor, color); // Right
    }
}
