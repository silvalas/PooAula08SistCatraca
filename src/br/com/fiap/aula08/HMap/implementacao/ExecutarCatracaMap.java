package br.com.fiap.aula08.HMap.implementacao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import br.com.fiap.aula08.HMap.beans.RegEntSai;
import br.com.fiap.aula08.HMap.util.Input;


public class ExecutarCatracaMap {

	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RegEntSai registro = new RegEntSai(); 
		
		Map<String, RegEntSai > gravaEntSai = new HashMap<String, RegEntSai >();
		
		Map<String, Date> catraca = new HashMap<String, Date>();

		DateFormat formData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		String tipo = null, cracha, fim = null;

		System.out.println("Controle de catraca");
		
		while (fim == null) {

			tipo = Input.texto("Digite <E>ntrada, <S>aida ou <R>elat�rio do dia: ");

			if (tipo.equalsIgnoreCase("E")) {
				cracha = Input.texto("Leitor cracha: ");
				if (!catraca.containsKey(cracha)) {
					Input.mensagem("Bem Vindo!  \n\t Acesso Liberado " + cracha);
					// captura data/hora de entrada no sistema
					Date dataProc = new Date();
					catraca.put(cracha, dataProc);
				} else {
					Input.mensagem("Entrada j� registrada para esse crach� = " + cracha + " - "
							+ formData.format(catraca.get(cracha)) + " - Acesso bloqueado!");
				} // fim do if
			} // fim do if
			
			if (tipo.equalsIgnoreCase("S")) {
				cracha = Input.texto("Leitor cracha: ");
				if (!catraca.containsKey(cracha)) {
					Input.mensagem("Entrada N�O registrada para esse crach� " + cracha + " - Acesso bloqueado para sair");
				} else {
					Input.mensagem("Obrigado pela visita " + cracha + " - " + formData.format(catraca.get(cracha)));
					
					//Inclui hor�rio e entrada e sa�da na lista/classe registro
					registro.setNumCracha(cracha);
					registro.setDataEnt(catraca.get(cracha));
					Date dataSai = new Date();
					registro.setDataSai(dataSai);
					gravaEntSai.put(cracha, registro);	
					
					System.out.println("gravaEntSai Cracha = " + registro.getNumCracha() +
									   " data ent = " + formData.format((registro.getDataEnt())) +
									   " data sai = " + formData.format((registro.getDataSai())));

					//Retira hor�rio de entrada na lista catraca, ap�s inclus�o de dados na lista gravaEntSai
					catraca.remove(cracha);
				} // fim do if
			} // fim do if
			
			if (tipo.equalsIgnoreCase("R")) {

				for (Map.Entry item: gravaEntSai.entrySet()) {
					RegEntSai teste = new RegEntSai();
					String teste1 = (String) item.getKey();
					teste = (RegEntSai) gravaEntSai.get(teste1);
					//teste = (RegEntSai) item.getValue();
				
					System.out.println("Crach� 1 = " + item.getKey() + " / crach� 2 = " + teste.getNumCracha() + 
									   " data ent = " + formData.format(teste.getDataEnt()) +
									   " data sai = " + formData.format(teste.getDataSai()));
	
				} // fim do for 
				
				fim = "x";
			} // fim do if

			System.out.println(catraca.entrySet());
		}
	}
}
