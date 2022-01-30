package br.edu.mcesar.core;

public class CoreConstants {

	public static TIMEOUTS DEFAULT_TIMEOUT = CoreConstants.TIMEOUTS.xl;

	private CoreConstants() {
	}

	public enum TIMEOUTS {
		xxs(1000), xs(2000), s(5000), m(10000), l(25000), xl(50000), xxl(75000), xxxl(200000), xxxxl(300000), xxxxxl(400000),
		tenMinutes(600000),;

		private final int valor;

		TIMEOUTS(int valorOpcao) {
			valor = valorOpcao;
		}

		public int getValor() {
			return valor;
		}
	}
}
