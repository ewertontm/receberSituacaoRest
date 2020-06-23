package br.org.chicoh.statuscoleta;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import br.org.chicoh.statuscoleta.dto.ParametrosEntrada;
import br.org.chicoh.statuscoleta.dto.ResponseStatusColetaDTO;

@RestController
public class ReceberStatusController {

	@PostMapping("/receber-status-coleta")
	public ResponseStatusColetaDTO receberStatusColeta(
			@RequestHeader(name = "chave1", required = false) String chave1,
			@RequestHeader(name = "valor1", required = false) String valor1,
			@RequestHeader(name = "chave2", required = false) String chave2,
			@RequestHeader(name = "valor2", required = false) String valor2,
			@RequestHeader(name = "chave3", required = false) String chave3,
			@RequestHeader(name = "valor3", required = false) String valor3,
			@RequestBody ParametrosEntrada parametrosEntrada) {

		ResponseStatusColetaDTO resp = new ResponseStatusColetaDTO();

		validarChaveValor(resp, chave1, valor1, chave2, valor2, chave3, valor3);

		if (resp.getCodigo() == null || resp.getCodigo().equals(0)) {
			resp.setCodigo(200);
			resp.setDescricao(
					"Recebimento do ticket: " + parametrosEntrada.getTicket() + ", foi realizado com sucesso!");
		}

		return resp;

	}

	private void validarChaveValor(ResponseStatusColetaDTO resp, String headerChave1, String headerValor1,
			String headerChave2, String headerValor2, String headerChave3, String headerValor3) {

		if (headerChave1.equals("usuario") || headerChave1.equals("agente") || headerChave1.equals("teste")) {

			Boolean retorno = Boolean.FALSE;			
			retorno = this.validarUsuarioSenha(resp, headerChave1, headerValor1, "usuario", "senha");
			if (!retorno) {
				retorno = this.validarUsuarioSenha(resp, headerChave1, headerValor1, "agente", "12345678");
			}
			if (!retorno) {
				retorno = this.validarUsuarioSenha(resp, headerChave1, headerValor1, "teste", "teste");
			}	
		} else {
			resp.setCodigo(403);
			resp.setDescricao("Usuário não existente!");
		}
	}

	private Boolean validarUsuarioSenha(ResponseStatusColetaDTO resp, String chave, String valor, String usuario,
			String senha) {		
		if (usuario.equals(chave) && senha.equals(valor)) {
			resp.setCodigo(null);
			return Boolean.TRUE;
		} else {
			resp.setCodigo(403);
			resp.setDescricao("Usuário ou senha invalidos!");
		}
		return Boolean.FALSE;
	}

}
