//First Approach 
class Solution {
    public int countPrimes(int n) {
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    boolean isPrime(int num) {
        if (num <= 1) return false;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}


//Second Approach
class Solution {
    public int countPrimes(int n) {
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    boolean isPrime(int num) {
    if (num <= 1) return false;

    for (int i = 2; i * i <= num; i++) {
        if (num % i == 0) {
            return false;
        }
    }
    return true;
}

}

//Third Approach
class Solution {
    public int countPrimes(int n) {
        if(n==1 || n==0){
            return 0;
        }
        boolean[] flag = new boolean[n+1];
        int cnt = 0;
        for(int i = 2 ;i <n;i++){
            if(flag[i]) continue;
            cnt++;
            for(int j = 2*i;j<n;j+=i){
                flag[j] = true;
            }

        }
        return cnt;
    }
}
