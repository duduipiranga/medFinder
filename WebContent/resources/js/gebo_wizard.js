/* [ ---- Gebo Admin Panel - wizard ---- ] */

	$(document).ready(function() {
		//* simple wizard
		gebo_wizard.simple();
		//* wizard with validation
		gebo_wizard.validation();
		//* add step numbers to titles
		gebo_wizard.steps_nb();
	});

	gebo_wizard = {
		simple: function(){
			$('#simple_wizard').stepy({
				titleClick	: true,
				nextLabel:      'Next <i class="icon-chevron-right icon-white"></i>',
				backLabel:      '<i class="icon-chevron-left"></i> Back'
			});
		},
		validation: function(){
			$('#validate_wizard').stepy({
				nextLabel:      'Avan&ccedil;ar <i class="icon-chevron-right icon-white"></i>',
				backLabel:      '<i class="icon-chevron-left"></i> Voltar',
				block		: true,
				errorImage	: true,
				titleClick	: true,
				validate	: true
			});
			stepy_validation = $('#validate_wizard').validate({
				onfocusout: false,
				errorPlacement: function(error, element) {
					error.appendTo( element.closest("div.controls") );
				},
				highlight: function(element) {
					$(element).closest("div.control-group").addClass("error f_error");
					var thisStep = $(element).closest('form').prev('ul').find('.current-step');
					thisStep.addClass('error-image');
				},
				unhighlight: function(element) {
					$(element).closest("div.control-group").removeClass("error f_error");
					if(!$(element).closest('form').find('div.error').length) {
						var thisStep = $(element).closest('form').prev('ul').find('.current-step');
						thisStep.removeClass('error-image');
					};
				},
				rules: {
					'filtroNome'	: {
						required	: true,
						minlength	: 3
					},
					'filtroSobrenome'	: {
						required	: true,
						minlength	: 3
					},
					'filtroEmail'	: {
						required: true, email: true
					},
					'filtroSenha'	: {
						required	: true,
						minlength	: 6
					},
					'filtroDataNasc'	: {
						required	: true,
						minlength	: 10
					},
					'filtroCEP'	: {
						required	: true,
						minlength	: 9
					},
					'filtroEndereco'	: {
						required	: true,
						minlength	: 5
					},
					'filtroNumero'	: {
						required	: true,
						minlength	: 1
					},
					'filtroBairro'	: {
						required	: true,
						minlength	: 5
					},
					
				}, messages: {
					'filtroNome'	: { required:  'Digite seu nome',minlength: 'Minimo de 3 caracteres' },
					'filtroSobrenome'	: { required:  'Digite seu sobrenome',minlength: 'Minimo de 3 caracteres' },
					'filtroEmail'	: { required:  'Digite seu email',email: 'Por favor insira um e-mail valido' },
					'filtroSenha'	: { required:  'Digite sua senha',minlength: 'Minimo de 5 caracteres' },
					'filtroDataNasc'	: { required:  'Digite sua data de nascimento',minlength: 'Minimo de 10 caracteres' },
					'filtroCEP'	: { required:  'Digite seu CEP',minlength: 'Minimo de 9 caracteres' },
					'filtroEndereco'	: { required:  'Digite seu endereco',minlength: 'Minimo de 5 caracteres' },
					'filtroNumero'	: { required:  'Digite seu numero',minlength: 'Minimo de 1 caracteres' },
					'filtroBairro'	: { required:  'Digite seu bairro',minlength: 'Minimo de 5 caracteres' },
				},
				ignore				: ':hidden'
			});
		},
		//* add numbers to step titles
		steps_nb: function(){
			$('.stepy-titles').each(function(){
				$(this).children('li').each(function(index){
					var myIndex = index + 1
					$(this).append('<span class="stepNb">'+myIndex+'</span>');
				})
			})
		}
	};