package basic;
/**
 * Thread 사용 방법
 * 1. Thread를 상속해서 run() 메서드를 오버라이드 한다.
 * 2. Runnable 인터페이스를 구현한 클래스를 만들고 그 클래스의 인스턴스를 Thread 클래스의 생성자에 전달*/
public class BankThread {

    // 남은 금액
    private int balance;

    public BankThread(int balance) {
        this.balance = balance;
        System.out.println("생성자 메서드");
    }

    // 입금
    /* synchronized : 동시성을 제어 하기위한 사용되는 키워드
     * 여러 스레드가 같은 동시에 같은 객체의 메서드나 코드 블록에 접근하는걸 막아 준다, 경쟁 상태와 같은 동시성 문제를 해결하는 데 도움을 준다.
     * 즉, 이 메서드는 한 번에 한 스레드만 실행될 수 있다.*/
    public synchronized void deposit(int amount) {

        System.out.println("Deposit = " + amount);
        int tempBalance = this.balance;
        try{
            Thread.sleep(1000);
        // 스레드가 대기, 휴식 중이거나 다른 방식으로 점유 중인 상태에서 활동 전, 활동 중 스레드가 중단 될 때 발생
        } catch (InterruptedException e){
            // 에러스트림에 출력?
            e.printStackTrace();
        }

        tempBalance += amount;
        this.balance = tempBalance;
        System.out.println("Deposit = " + amount);
    }

    // 출금
    public synchronized void withdraw(int amount) {
        System.out.println("withdraw = " + amount);

        int tempBalance = this.balance;
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        tempBalance -= amount;
        this.balance = tempBalance;
        System.out.println("withdraw = " + amount);

    }

    // main 메서드에서 balance를 사용하기 위해 getter 사용
    public int getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        BankThread bankT = new BankThread(1000);

        /* Runnable : 자바에서 스레드를 구현하기 위한 인터페이스
         * 스레드를 생성하려면 Runnable 인터페이스를 구현하는 클래스를 정의하고 run() 메서드를 오버라이드해 스레드가 실행할 코드를 작성해야 한다.
         * depositRunnable, withdrawRunnable은 구현 클래스
         * */
        Runnable depositRunnable = () -> {
            for(int i = 0; i < 10; i++) {
                // 100원씩 10번 증가
                bankT.deposit(100);
            }
        };

        Runnable withdrawRunnable = () -> {
            for (int i = 0; i < 10; i++){
                bankT.withdraw(100);
            }
        };

        Thread t1 = new Thread(depositRunnable);
        Thread t2 = new Thread(withdrawRunnable);

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("마지막 계좌 잔금 = " + bankT.getBalance());
    }
}

