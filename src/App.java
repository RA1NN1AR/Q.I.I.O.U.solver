
//解一元二次不等式
import java.util.Scanner;
public class App {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("=====================================");
        System.out.println("           解一元二次不等式\n");
        System.out.println("请输入需要解开的一般式的一元二次不等式.");
        System.out.println("格式应该看起来像这样:ax^2+bx+c>=0");
        System.out.println("输入a的值.");
        Double a = in.nextDouble();
        System.out.println("输入b的值.");
        Double b = in.nextDouble();
        System.out.println("输入c的值.");
        Double c = in.nextDouble();
        System.out.println("输入不等号.");
        String ne = in.next();

        //计算△
        Double delta = b*b-4*a*c;
        System.out.println("Delta:"+delta);
        Double x1,x2;
        System.out.print("不等式的解集为:");

        if(delta>0){ 
            //方程有两个不相等的实数根
            x1=(-b+Math.sqrt(delta))/2*a;
            x2=(-b-Math.sqrt(delta))/2*a;
            switch(ne){
                case ">": case ">=":
                    if(x1<x2){ 
                        if(ne.contains("=")){
                            System.out.printf("{x|x≤%f 或 x≥%f}.%n",x1,x2);
                        }else{
                            System.out.printf("{x|x<%f 或 x>%f}.%n",x1,x2);
                        }
                    }else{
                        if(ne.contains("=")){
                            System.out.printf("{x|x≤%f 或 x≥%f}.%n",x2,x1);
                        }else{
                            System.out.printf("{x|x<%f 或 x>%f}.%n",x2,x1);
                        }
                    }
                break;

                case "<": case "<=":
                    if(x1<x2){
                        if(ne.contains("=")){
                            System.out.printf("{x|%f≤x≤%f}.%n",x1,x2);
                        }else{
                            System.out.printf("{x|%f<x<%f}.%n",x1,x2);
                        }
                    }else{
                        if(ne.contains("=")){
                            System.out.printf("{x|%f≤x≤%f}.%n",x2,x1);
                        }else{
                            System.out.printf("{x|%f<x<%f}.%n",x2,x1);
                        }
                    }
                break;

                default:
                    err();
                break;
            }
         }
        else if(delta==0){ 
            //方程有两个相等的实数根
            x1=-(b/2*a);
            switch(ne){
                case ">":
                    System.out.printf("{x|x≠%f}.%n",x1.toString());
                break;
                
                case ">=":
                    System.out.println("R.");
                break;

                case "<":
                    System.out.println("空集.");
                break;

                case "<=":
                    System.out.printf("{%f}.",-x1);
                break;

                default:
                    err();
                break;
            }
         }
        else if(delta<0){ 
            //方程没有根
            switch(ne){
                case ">": case ">=":
                    System.out.println("R.");
                break;

                case "<": case "<=":
                    System.out.println("空集.");
                break;
                
                default:
                    err();
                break;
            }
        }
        System.out.println("=====================================");
        in.close();
    }
    public static void err(){
        System.out.println("出错.");
        System.exit(0);
    }
}