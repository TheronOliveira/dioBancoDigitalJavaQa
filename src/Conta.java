
public abstract class Conta {

	private int agencia;
	private int conta;
	private double saldo;

	public int getAgencia() {
		return agencia;
	}

	public int getConta() {
		return conta;
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

	public void transferir(Conta origem, Conta destino, double valor) {
		if (origem.getSaldo() >= valor) {
			this.saldo -= valor;
			destino.depositar(valor);
		} else {
			System.out.println("Saldo insuficiente: " + origem.getSaldo());
		}
	}
}
