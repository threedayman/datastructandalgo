package stock;

public class Profit {

    public static void main(String[] args) {
        System.out.println(cal(5,0.2));
        System.out.println(calAll(5,0.04));
    }

    //每年x的增长率，n年后的结果
    public static double cal(int n,double x){
        double result=1.0;
        for(int i=1;i<n;i++){
            result *=(1+x);
            System.out.printf("第%d年，结果是%f",i+1,result);
        }
        System.out.println();
        return result;
    }
    //每年x的增长率，n年的所有增长
    public static double calAll(int n,double x){
        double result=1.0;
        for(int i=1;i<n;i++){
            result += result*(1+x);
            System.out.printf("第%d年，总结果是%f",i+1,result);
        }
        System.out.println();
        return result;
    }
}
