package priv.dong.algorithm.bases;

public class commonDivisor {
	
	public static void main(String[] args) {
		System.out.println(gcd(14,4));
	}
	
	/**
	 * 欧里几德算法 求最大公约数
	 * @param p
	 * @param q
	 * @return
	 */
	public static int gcd(int p, int q){
		if (q == 0) return p;
		int r = p % q;
		return gcd(q,r);
	}

}
