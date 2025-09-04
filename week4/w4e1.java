package week4;

class PrintNums extends Thread{
    boolean even;
    int start,end;

    public PrintNums(boolean even, int start, int end) {
        this.even = even;
        this.start = start;
        this.end = end;
    }
    @Override
    public void run(){
        if(even){
            for(int i = start;i <= end; i++){
                if(i%2==0){
                    System.out.print(i + " ");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        else{
            for(int i = start;i <= end; i++){
                if(i%2!=0){
                    System.out.print(i + " ");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}

public class w4e1 {
    public static void main(String[] args) {     
        PrintNums printEvenNums = new PrintNums(true,1,10);     
        PrintNums printOddNums = new PrintNums(false,1,10);
        // System.out.println("Started");
        printEvenNums.start();
        printOddNums.start();
    }
}
