package br.com.fiap.aula08.HMap.implementacao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import br.com.fiap.aula08.HMap.beans.RegEntSai;
import br.com.fiap.aula08.HMap.util.Input;


public class ExecutarCatracaMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RegEntSai registro = new RegEntSai(); 
		
		Map<String, Date> regEnt = new HashMap<String, Date>();
		Map<String, Date> regSai = new HashMap<String, Date>();
		
		Map<String, RegEntSai > gravaEntSai = new HashMap<String, RegEntSai >();
		
		Map<String, Date> catraca = new HashMap<String, Date>();

		DateFormat formData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		String tipo = null, cracha, fim = null;

		System.out.println("Controle de catraca");
		
		while (fim == null) {

			tipo = Input.texto("Digite <E>ntrada ou <S>aida: ");

			if (tipo.equalsIgnoreCase("E")) {
				cracha = Input.texto("Leitor cracha: ");
				if (!catraca.containsKey(cracha)) {
					Input.mensagem("Bem Vindo!  \n\t Acesso Liberado " + cracha);
					// captura data/hora de entrada no sistema
					Date dataProc = new Date();
					catraca.put(cracha, dataProc);
				} else {
					Input.mensagem("Entrada já registrada para esse crachá = " + cracha + " - "
							+ formData.format(catraca.get(cracha)) + " - Acesso bloqueado!");
				} // fim do if
			} // fim do if
			
			if (tipo.equalsIgnoreCase("S")) {
				cracha = Input.texto("Leitor cracha: ");
				if (!catraca.containsKey(cracha)) {
					Input.mensagem("Entrada NÃO registrada para esse crachá " + cracha + " - Acesso bloqueado para sair");
				} else {
					Input.mensagem("Obrigado pela visita " + cracha + " - " + formData.format(catraca.get(cracha)));
					regEnt.put(cracha, catraca.get(cracha));
					Date dataSai = new Date();
					regSai.put(cracha, dataSai);
					catraca.remove(cracha);
					
					//Inclui horário e entrada e saída na classe registro
					registro.setDataEnt(catraca.get(cracha));
					registro.setDataSai(dataSai);
					gravaEntSai.put(cracha, registro);										
					
					System.out.println("teste catraca chave = " + regEnt.keySet() + " data ent = " + formData.format(regEnt.get(cracha)) + " data sai = " + formData.format(regSai.get(cracha)));
					System.out.println("Leitura  catraca chave = " + gravaEntSai.keySet() + " data ent = " + gravaEntSai.values());
					
					fim = "x";
					
				} // fim do if
			} // fim do if

			System.out.println(catraca.entrySet());
		}
	}
}
