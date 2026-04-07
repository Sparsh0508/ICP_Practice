import java.util.*;

public class SegmentTree {

    static long[] tree;
    static long[] lazyA;
    static long[] lazyD;
    static int MOD = 100_000_000_7;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        tree = new long[4*n];
        lazyA = new long[4*n];
        lazyD = new long[4*n];

        build(arr,1,0,n-1);

        int q = sc.nextInt();
        long ans = 0;

        while(q-- > 0){

            int type = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();

            if(type==2){
                ans = (ans + query(1,0,n-1,l,r)) % MOD;
            }
            else{
                long base = query(1,0,n-1,l,l);
                update(1,0,n-1,l,r,base,l);
            }
        }

        System.out.println(ans);
    }

    static void build(int[] arr,int node,int l,int r){

        if(l==r){
            tree[node]=arr[l];
            return;
        }

        int mid=(l+r)/2;

        build(arr,node*2,l,mid);
        build(arr,node*2+1,mid+1,r);

        tree[node]=(tree[node*2]+tree[node*2+1])%MOD;
    }

    static void push(int node,int l,int r){

        if(lazyA[node]==0 && lazyD[node]==0) return;

        int len=r-l+1;
        long a=lazyA[node];
        long d=lazyD[node];

        long sum = (len * ((2*a + (len-1)*d)%MOD) /2) %MOD;
        tree[node] = sum;

        if(l!=r){

            int mid=(l+r)/2;

            lazyA[node*2] = a;
            lazyD[node*2] = d;

            lazyA[node*2+1] = (a + (mid-l+1)*d)%MOD;
            lazyD[node*2+1] = d;
        }

        lazyA[node]=0;
        lazyD[node]=0;
    }

    static void update(int node,int l,int r,int ql,int qr,long base,int startL){

        push(node,l,r);

        if(r<ql || l>qr) return;

        if(ql<=l && r<=qr){

            long start = ((l-startL+1)*base)%MOD;

            lazyA[node]=start;
            lazyD[node]=base;

            push(node,l,r);
            return;
        }

        int mid=(l+r)/2;

        update(node*2,l,mid,ql,qr,base,startL);
        update(node*2+1,mid+1,r,ql,qr,base,startL);

        tree[node]=(tree[node*2]+tree[node*2+1])%MOD;
    }

    static long query(int node,int l,int r,int ql,int qr){

        push(node,l,r);

        if(r<ql || l>qr) return 0;

        if(ql<=l && r<=qr)
            return tree[node];

        int mid=(l+r)/2;

        return (query(node*2,l,mid,ql,qr)
                +query(node*2+1,mid+1,r,ql,qr))%MOD;
    }
}