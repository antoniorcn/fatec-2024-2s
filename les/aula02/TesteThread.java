class Job implements Runnable { 
    private String nome = "Job";
    public Job(String nome) { 
        this.nome = nome;
    }

    public void run() { 
        while (true) { 
            System.out.println("(" + this.nome + ") executando...");
            try { 
                Thread.sleep(1000); 
            } catch (InterruptedException e) { 
                e.printStackTrace();
            }
            
        }
    }
}
public class TesteThread {
    public static void main(String[] args) {
        Job j1 = new Job("A");
        Job j2 = new Job("B");
        Thread t1 = new Thread( j1 );
        Thread t2 = new Thread( j2 );

        t1.start();
        t2.start();
    }
}
