// Esse exercício simula uma conta de banco.

public class Conta {

    // Atributos
    private String tipoConta;
    private String donoConta;
    private float saldo;
    private boolean status;


    // Método Construtor
    public Conta(){
        this.setSaldo(0);
        this.setStatus(false);
    }


    // Getters and Setters
    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getDonoConta() {
        return donoConta;
    }

    public void setDonoConta(String donoConta) {
        this.donoConta = donoConta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
    

    // Métodos especiais
    public void abrirConta(String tipo, String dono){

        // Verificação do tipo da conta. CC para Corrente, CP para poupança
        if (!tipo.equals("CC") && !tipo.equals("CP")) {
            System.out.println("Tipo de conta invalido. Use 'CC' para Conta Corrente ou 'CP' para Conta Poupanca.");
            this.setDonoConta(dono);

        } else {
            this.setTipoConta(tipo);
            this.setDonoConta(dono);
            this.setStatus(true);

            // Abrindo uma CC, o cliente ganha R$50 de bônus. Abrindo uma CP, ganha R$150.
            if (tipo.equals("CC")){
                this.setSaldo(50);
            } else {
                this.setSaldo(150);;
            }

            System.out.println("Conta aberta com sucesso!");
        }
        
    }


    public void fecharConta(){

        if (this.status == true){
            if (this.getSaldo() > 0){
                System.out.println("Nao sera possivel realizar o fechamento da conta. Antes, saque todo o saldo disponivel.");
            } else if (this.saldo < 0){
                System.out.println("Nao sera possivel realizar o fechamento da conta enquanto possuir um debito.");
            } else {
                System.out.println("Conta fechada com sucesso!");
                this.status = false;
            }
        } else {
            System.out.println("A conta ja esta fechada.");
        }
        
    }


    public void depositar(float valor){
        if (this.status){
            this.setSaldo(this.getSaldo() + valor);
            } else {
                System.out.println("Nao sera possivel depositar valores. A conta esta fechada.");
            }

        }
    

    public void sacar(float valor){
        if (this.status){
            if (this.getSaldo() >= valor){
                this.setSaldo(this.getSaldo() - valor);
                System.out.println("Valor sacado com sucesso!");
            } else {
                System.out.println("Saldo insuficiente.");
            }
        } else {
            System.out.println("Impossivel realizar o saque! A conta esta fechada.");
        }

    }


    public void pagarMensalidade(){
        int v = 0;

        if (this.getTipoConta().equals("CC")){
            v = 12;
        } else {
            v = 20;
        }

        if (this.status){
            this.setSaldo(this.getSaldo() - v);
            System.out.println("Mensalidade paga com sucesso!");
        } else {
            System.out.println("Impossivel pagar a mensalidade! A conta esta fechada.");
        }
    }



    public void statusConta(){
        System.out.println("----------------------");
        System.out.println("Dono: " + this.getDonoConta());
        System.out.println("Tipo de conta: " + this.getTipoConta());
        System.out.println("Saldo: R$" + this.getSaldo());
        if (this.status){
            System.out.println("A conta esta aberta.");
        } else {
            System.out.println("A conta esta fechada.");
        }
        System.out.println("\n");
    }

}
