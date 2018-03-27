package priv.dong.algorithm.bases;
/*
 * 
    * @ClassName: jiujiu  
    * @Description: TODO(99乘法表的顺序和倒序输出测试)  
    * @author dongxiao  
    * @date 2018年3月27日  
    *
 */
public class jiujiu {
	
	/*
	 * 顺序输出
	 */
	public static void shuxu(){
		for(int i=1; i<10; i++){
			for(int j=1; j<i+1; j++){
				System.out.print(i+"*"+j+"="+i*j+"  ");
			}
			System.out.println();
		}
	}
	
	/*
	 * 逆序输出
	 */
	public static void nixu(){
		for(int i=9; i>0; i--){
			for(int j=i; j>0; j--){
				System.out.print(i+"*"+j+"="+i*j+"  ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		
		shuxu();
		System.out.println("-----------------------------");
		nixu();
		
	}

}
