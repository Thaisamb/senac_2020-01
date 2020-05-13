package controller.exercicio1;

import java.util.ArrayList;

import model.bo.exercicio1.ClienteBO;
import model.vo.exercicio1.Cliente;
import model.vo.exercicio1.Endereco;

public class ClienteController {

	private static final int TAMANHO_MINIMO_CAMPO_NOME = 1;
	private static final int TAMANHO_MAXIMO_CAMPO_NOME = 50;

	private static final int TAMANHO_MINIMO_CAMPO_SOBRENOME = 1;
	private static final int TAMANHO_MAXIMO_CAMPO_SOBRENOME = 100;


	private ClienteBO bo = new ClienteBO();

	public ArrayList<Cliente> listarTodosOsClientes() {
		return bo.pesquisarTodos();
	}

	public String salvar(String nome, String sobrenome, String cpf, Endereco endereco) {

		String msg = "";

		if (endereco != null) {

			msg = verificarCampo("Nome", nome, TAMANHO_MINIMO_CAMPO_NOME, TAMANHO_MAXIMO_CAMPO_NOME);
			msg += verificarCampo("Sobrenome", sobrenome, TAMANHO_MINIMO_CAMPO_SOBRENOME, TAMANHO_MAXIMO_CAMPO_SOBRENOME);
			if(cpf.equals("   .   .   -  ") || cpf.length() <14) {
				msg+= "O campo CPF deve possuir 11 n�meros.";
			};

		} else {
			msg = "Informe um endere�o.";
		}

		if (msg.isEmpty()) {
			Cliente cliente = new Cliente(nome, sobrenome, cpf, null, endereco);
			msg =bo.salvar(cliente);
		}
		return msg;
	}

	public String excluirPorCpf(String cpf) {
		String msg = "";

		if(cpf.equals("   .   .   -  ") || cpf.length() <14) {
			msg = "O campo CPF deve possuir 11 n�meros.";
		}else {
			msg = bo.excluirPorCpf(cpf);
		}
		return msg;

	}
	
	private String verificarCampo(String nomeDoCampo, String valor, int tamanhoMinimo, int tamanhoMaximo) {
		String msgValidacao = "";

		if (valor.length() < tamanhoMinimo || valor.length() > tamanhoMaximo) {
			msgValidacao = nomeDoCampo + " deve possuir pelo menos " + tamanhoMinimo + " e no m�ximo " + tamanhoMaximo
					+ " caracteres \n";
		}
		return msgValidacao;
	}



}
