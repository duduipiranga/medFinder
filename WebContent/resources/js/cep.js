	// Função única que fará a transação
	function getEndereco() {
			// Se o campo CEP não estiver vazio
			if($.trim($("#filtroCEP").val()) != ""){
				/* 
					Para conectar no serviço e executar o json, precisamos usar a função
					getScript do jQuery, o getScript e o dataType:"jsonp" conseguem fazer o cross-domain, os outros
					dataTypes não possibilitam esta interação entre domínios diferentes
					Estou chamando a url do serviço passando o parâmetro "formato=javascript" e o CEP digitado no formulário
					http://cep.republicavirtual.com.br/web_cep.php?formato=javascript&cep="+$("#cep").val()
				*/
				$.getScript("http://cep.republicavirtual.com.br/web_cep.php?formato=javascript&cep="+$("#filtroCEP").val(), function(){
					// o getScript dá um eval no script, então é só ler!
					//Se o resultado for igual a 1
			  		if(resultadoCEP["resultado"]){
						// troca o valor dos elementos
						$("#filtroEndereco").val(unescape(resultadoCEP["tipo_logradouro"])+" "+unescape(resultadoCEP["logradouro"]));
						$("#filtroBairro").val(unescape(resultadoCEP["bairro"]));
						//deixando readonly="readonly" os campos
						$("#filtroEndereco").attr("readonly","readonly");
						$("#filtroBairro").attr("readonly","readonly");
						//colocando o focus para o campo numero
						$("#filtroNumero").focus();
					}
				});				
			}
			
					
	}


