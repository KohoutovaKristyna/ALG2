/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

/**
 *
 * @author kristyna kohoutova
 */
public class Recursion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(fac(4));
        System.out.println(facR(4));
        System.out.println(mystery(3,11));
        
        int[] a = {23,45,21,34};
        System.out.println(fm(a,4));
        System.out.println(fm1(a,0,3));
    }
    
    //factorial iterativne 4! = 1*2*3*4
    public static int fac(int n){
        int fac = 1;
        for (int i = 2; i <= n; i++) {
            fac = fac*i;
        }
        return fac;
    }
    
    public static int facR(int n){
        if(n<= 1){
            return 1;
        }else{
            return n*facR(n-1);
        }
    }
    public static int mystery(int a, int b){
        if(b==0) return 0;
        if(b%2 ==0) return mystery(a+a,b/2);
        return mystery (a+a,b/2)+a;
    }
    
    public static int fm(int[] a, int n){
        if(n==1){
            return a[0];
        }
        return Math.max(a[n-1], fm(a, n-1));
    }
    
    public static int fm1(int[] a, int from, int to){
        if(from >= to){
            return a[from];
        }
        int half = (from + to)/2;
        int left = fm1(a, from, half);
        int right = fm1(a, half+1, to);
        if(left >= right){
            return left;
        }
        else{
            return right;
        }
    }
    
}
/*
mystery(3,11)
return mystery(6,5)+3
return mystery(12,2)+6
return mystery(24,1)
return mystery(48,0)+24 
return 0

24+6+3 = 33

*/