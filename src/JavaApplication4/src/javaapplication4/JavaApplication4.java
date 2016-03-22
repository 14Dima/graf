
package javaapplication4;
import java.util.Scanner; 
/**
 *
 * @author Белка
 */
public class JavaApplication4 {
   
    public static int[] j=new int[100];        
    public static int[] i=new int[100];
    public static int f(int n){
        if(i[n]!=0){//эта вершина уже посещалась?
            if(i[n]==2){//она посещалась на этом проходе?
                System.out.print(n);
                return n;//передаем номер замыкающей вершины
            }
            return -1;//эта вершина посещалась ранее
        }else{
            i[n]=2;//отмечаем, что в _данном_ проходе эта вершина посещалась
            int h;
            if(j[n]!=0){//зависит ли данная сущность от кого-либо
                h=f( j[n]);//продолжаем проход
            }else{
                h=-1;
            }
            i[n]=1;//отмечаем раннее посещенные в поиках циклов вершины
            if(h!=-1){//мы находимся внутри цикла?
                System.out.print(" ");
                System.out.print(n);
                if(h==n){//мы находимся в замыкающей вершине?
                    System.out.println();
                    h=-1;
                }
            }
            return h;
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in); // создаём объект класса Scanner        
        
        
        int k=0;
        while(sc.hasNextInt()){
            if(sc.hasNextInt()) {
                int m = sc.nextInt();
                if(sc.hasNextInt()) {
                  j[m] = sc.nextInt();                  
                }
                if(m>k){
                    k=m;
                }
            }else{
                break;
            }         
        }
        for(int m=0;m<=k;m++){
            if(i[m]==0){//эта вершина уже посещалась алгоритмом?
                f(m);//посетить
            }
        }
    }   
}

