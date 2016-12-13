package centinyx.logic;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DataCriacao {
	
	public static Timestamp dataAtual = new Timestamp(System.currentTimeMillis());

	public static String geraDataHorario(){
		
		String dataCorreta = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dataAtual);
		return dataCorreta;
	}
}
