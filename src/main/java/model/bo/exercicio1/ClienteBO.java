package model.bo.exercicio1;

import java.util.ArrayList;

import model.dao.exercicio1.ClienteDAO;
import model.dao.exercicio1.TelefoneDAO;
import model.vo.exercicio1.Cliente;

public class ClienteBO {

	private ClienteDAO dao = new ClienteDAO();

	public ArrayList<Cliente> pesquisarTodos() {
		return dao.consultarTodos();
	}
	
	public String salvar(Cliente cliente) {
		String mensagem = "";
		
		if(dao.cpfJaUtilizado(cliente.getCpf())) {
			mensagem = "CPF informado (" + cliente.getCpf() + ") já foi utilizado";
		}else {
			Cliente c  = dao.salvar(cliente);
			
			if(c.getId() > 0) {
				mensagem = "Cliente salvo com sucesso";
			}else {
				mensagem = "Erro ao salvar cliente";
			}
		}
		
		return mensagem;
	}

	public String excluirPorCpf(String cpf) {
		String msg ="";

		Cliente cliente = dao.consultarPorCpf(cpf);

		if (cliente != null) {

			TelefoneDAO telDao = new TelefoneDAO();

			if (telDao.verificarSeClienteTemTelefone(cliente.getId())) {
				msg = "Cliente possui telefone(s) cadastrados, favor primeiro desativar os telefones e assim excluir o cliente.";
			} else {

				if (dao.excluir(cliente.getId())) {
					msg = "Cliente excluído com sucesso!";
				} else {
					msg = "Não foi possível excluir o Cliente.";

				}
			}

		} else {
			msg = "Cliente não cadastrado.";

		}

		return msg;

	}


}
