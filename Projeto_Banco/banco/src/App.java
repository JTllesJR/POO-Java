public class App {
    public static void main(String[] args) throws Exception {
        Conta c1 = new Conta();
        c1.abrirConta("CP", "Joao");
        c1.depositar(50);
        c1.sacar(100);
        c1.statusConta();

        Conta c2 = new Conta();
        c2.statusConta();
    }
}
