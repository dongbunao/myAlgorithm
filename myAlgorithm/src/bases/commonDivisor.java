package bases;
/**
 * 
    * @ClassName: commonDivisor  
    * @Description: TODO 求两个数的最大公约数 
    * @author dongxiao  
    * @date 2018年4月3日  
    *
 */
public class commonDivisor {
	
	public static void main(String[] args) {
		System.out.println(gcd(14,4));
	}
	
	
	public static int gcd(int p, int q){
		if (q == 0) return p;
		int r = p % q;
		return gcd(q,r);
	}

}
