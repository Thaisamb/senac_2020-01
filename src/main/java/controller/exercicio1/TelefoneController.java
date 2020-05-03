package controller.exercicio1;

import java.util.ArrayList;

import model.bo.exercicio1.TelefoneBO;
import model.vo.exercicio1.Cliente;
import model.vo.exercicio1.Telefone;

public class TelefoneController {

	private TelefoneBO bo = new TelefoneBO();

	private int MIN_DIGITOS_CODIGO_PAIS = 2;
	private int MIN_DIGITOS_DDD = 2;
	private int MIN_DIGITOS_NUMERO = 8;

	public String salvar(Cliente cliente, String codPais, String ddd, String num, boolean movel) {

		String msg = "";

		msg = validarCampos(codPais, "'Código do país'", MIN_DIGITOS_CODIGO_PAIS);
		msg += validarCampos(ddd, "'DDD'", MIN_DIGITOS_DDD);
		msg += validarCampos(num, "'Número'", MIN_DIGITOS_NUMERO);

		if (msg.isEmpty()) {

			Telefone novoTelefone = new Telefone();
			novoTelefone.setDono(cliente);
			novoTelefone.setCodigoPais(codPais);
			novoTelefone.setDdd(ddd);
			novoTelefone.setNumero(num);
			novoTelefone.setMovel(movel);

			if (cliente.getId() > 0) {
				novoTelefone.setAtivo(true);
			} else {
				novoTelefone.setAtivo(false);
			}

			msg = bo.salvar(novoTelefone);

		}

		return msg;
	}

	private String validarCampos(String num, String nomeCampo, int minDigitos) {
		String mensagem = "";

		if (num.trim().length() < minDigitos) {
			mensagem += "Informe pelo menos " + minDigitos + " dígitos para o " + nomeCampo + ".\n";
		}
		try {
			Integer.parseInt(num);
		} catch (NumberFormatException ex) {
			mensagem += "Preencher o campo " + nomeCampo + " apenas com números.\n ";
		}
		return mensagem;

	}

	public ArrayList<Telefone> listarTodos() {

		ArrayList<Telefone> lista = new ArrayList<Telefone>();

		return lista = bo.listarTodos();

	}

}
