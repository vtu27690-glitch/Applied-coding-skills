class Solution {
    public int[] finalPrices(int[] prices) {

        for (int i = 0; i < prices.length; i++) {

            for (int j = i + 1; j < prices.length; j++) {

                if (prices[j] <= prices[i]) {
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }

        return prices;
    }
}

Input
prices =
[8,4,6,2,3]
Output
[4,2,4,2,3]
Expected
[4,2,4,2,3]
