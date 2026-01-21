/*
Problem Statement: Alice is a 10-year-old girl who has a sweet tooth and loves collecting
and eating various types of candies. Over time, she has gathered a collection of candies,
where each candy belongs to a specific type, such as chocolate, lollipop, gummy bear, or
hard candy. This collection is represented as an array candyType, where each element
indicates the type of a specific candy. For instance, candyType = [1, 1, 2, 2, 3, 3]
implies there are 6 candies, with three different types.
After a routine health check-up, Alice’s doctor advises her to reduce her candy intake due to
concerns about her weight and overall health. The doctor recommends that she should
consume no more than half of the total candies she owns. However, Alice loves variety and
wishes to enjoy as many different types of candies as possible within the doctor's restriction.
As a developer working on a child wellness app, your task is to implement a function that
helps Alice determine the maximum number of different candy types she can eat, given that
she is allowed to eat only half of her total candies.
Design and implement an efficient solution to support healthy and mindful eating in children.
Constraints:
n == candyType.length
2 <= n <= 10^4
n is even.
-10^5 <= candyType[i] <= 10^5
Example 1:
Input: candyType = [1,1,2,2,3,3]
Output: 3
Explanation: Alice can only eat 6 / 2 = 3 candies. Since there are only 3 types, she can eat
one of each type.
Example 2:
Input: candyType = [1,1,2,3]
Output: 2
Explanation: Alice can only eat 4 / 2 = 2 candies. Whether she eats types [1,2], [1,3], or [2,3],
she still can only eat 2 different types.
Example 3:
Input: candyType = [6,6,6,6]
Output: 1
Explanation: Alice can only eat 4 / 2 = 2 candies. Even though she can eat 2 candies, she
only has 1 type.

Input0:
1 1 2 3 5 7 8
Output0:
3
Input1:

1 2 2 4
Output1:
2
Input2:
2 6 7 1 10 1 2 4
Output2:
4

Input3:
2 6 7 1
Output3:
2
*/

import java.util.HashMap;

public class Question1 {
    public static void main(String[] args) {
        int[] candyType = {2 ,6 ,7 ,1 ,10 ,1 ,2 ,4};
        int ans = maxCandies(candyType);
        System.out.println(ans);
    }

    private static int maxCandies(int[] candyType) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i : candyType){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        int n = candyType.length;
        int type = n/2;
        int uniqueTypes = hm.size();
        return Math.min(uniqueTypes,type);

    }

}
