#include <stdio.h>
#include <math.h>

int main(){
    void err(int code);
    printf("=====================================\n");
    printf("           解一元二次不等式\n\n");
    printf("请输入需要解开的一般式的一元二次不等式.\n");
    printf("格式应该看起来像这样:ax^2+bx+c>=0\n");
    printf("输入a,b,c的值,以逗号分隔:");
    double a,b,c;
    scanf("%f,%f,%f",&a,&b,&c);
    printf("\n输入对应数字的不等号:");
    printf("1:> 2:< 3:≥ 4:≤");
    int ne;
    scanf("%d",&ne);

    double delta = b*b-4*a*c;
    printf("\nDelta:%f\n",&delta);
    double x1,x2;
    printf("不等式的解集为:");

    if(delta>0){
        x1=(-b+sqrt(delta))/2*a;
        x2=(-b-sqrt(delta))/2*a;
        switch (ne){
            case 1:case 3:
                if(x1<x2){
                    if(ne==3){
                        printf("{x|x≤%f 或 x≥%f}.%n",&x1,&x2);
                    }else{
                        printf("{x|x<%f 或 x>%f}.%n",&x1,&x2);
                    }
                }else{
                    if(ne==3){
                        printf("{x|x≤%f 或 x≥%f}.%n",&x2,&x1);
                    }else{
                        printf("{x|x<%f 或 x>%f}.%n",&x2,&x1);
                    }
                }
            break;

            case 2: case 4:
                    if(x1<x2){
                        if(ne==4){
                            printf("{x|%f≤x≤%f}.%n",&x1,&x2);
                        }else{
                            printf("{x|%f<x<%f}.%n",&x1,&x2);
                        }
                    }else{
                        if(ne==4){
                            printf("{x|%f≤x≤%f}.%n",&x2,&x1);
                        }else{
                            printf("{x|%f<x<%f}.%n",&x2,&x1);
                        }
                    }
                break;
                
                default:
                    err(1);
                break;

        }

    }else if (delta==0){
        //方程有两个相等的实数根
            x1=-(b/2*a);
            switch(ne){
                case 1:
                    printf("{x|x≠%f}.%n",&x1);
                break;
                
                case 3:
                    printf("R.");
                break;

                case 2:
                    printf("空集.");
                break;

                case 4:
                    x1*=-1;
                    printf("{%f}.",&x1);
                    x1*=-1;
                break;

                default:
                    err(1);
                break;
            }
    }else if (delta<0){
        switch (ne){
            case 1: case 3:
                printf("R.");
            break;

            case 2: case 4:
                printf("空集.");
            break;

            default:
                err(1);
            break;
        }
    }
    printf("\n====================================="); 
    return 0;
}
void err(int code){
    switch (code)
    {
    case 0:
        printf("错误:a不能为0.");
        break;
    case 1:
        printf("出错.");
        break;
    }
}