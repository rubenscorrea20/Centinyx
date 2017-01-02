package centinyx.enums;

public enum TipoPedidoEnum {
	ESCALA_MENSAL("Escala Mensal"),
	ESCALA_DIARIA("Escala Diaria"); 
	
	String pedidoString;
	
	@Override
	public String toString() {
		return pedidoString;
	}
	
	private TipoPedidoEnum(String pedidoString) {
		this.pedidoString = pedidoString;
	}
}