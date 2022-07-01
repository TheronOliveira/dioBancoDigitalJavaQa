
public abstract class Conta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	private Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = AGENCIA_PADRAO;
		this.numeroConta = SEQUENCIAL++;
		this.saldo = 0;
		this.cliente = cliente;
	}

	private int agencia;
	private int numeroConta;
	private double saldo;

	public int getAgencia() {
		return agencia;
	}

	public int getConta() {
		return numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void sacar(double valor) {
		if (valor >= getSaldo()) {
			this.saldo -= valor;
		}
	}

	public void depositar(double valor) {
		this.saldo += valor;
	}

	public void transferir(Conta destino, double valor) {
		if (this.getSaldo() >= valor) {
			this.sacar(valor);
			destino.depositar(valor);
		} else {
			System.out.println("Saldo insuficiente: " + this.getSaldo());
		}
	}
	
	public void getExtrato() {
		System.out.println("Cliente: " + cliente.getNome());
		System.out.println("Agência: " + this.getAgencia());
		System.out.println("Conta: " + this.getConta());
		System.out.println("Saldo: " + this.getSaldo());
	}
}
