
//variaveis globais
var propriedades, dadosPropriedades, divCNPJ, laboratorios, btnSalvarDados, btnCancelar;

function formatarData(dataParam) 
{
	var dt = new Date();
	var horario = dt.getHours()+":"+dt.getMinutes()+":"+dt.getSeconds();
	var data = dataParam;
	data = data.substr(6,4)+"-"+data.substr(3,2)+"-"+data.substr(0,2);
	return data+" "+horario;
}


//metodo para carregar o combo 'propriedades'
function loadPropriedades() 
{		
	propriedades.length = 0;
	fetch('http://localhost:8080/propriedades/')
	.catch(err => alert("Erro ao ler os dados (Propriedades)"))
	.then(response => response.json())
	.then(dados => {		
		if (dados == null) 
			alert("Erro ao ler os dados (Propriedades)");
		else {
			dadosPropriedades = dados;
			propriedades.add(new Option("", ""));
			dados.forEach(function(item, pos) {
				propriedades.add(new Option(item.nome, item.id));
			})
			loadLaboratorios();
		}
	})
}
	
	
//metodo para exibir o snackbar
function snackBar(mensagem="", cor="green") {
 	var x = document.getElementById("snackbar");
  x.className = cor == "red"? "show_error" : "show_success";  
  document.getElementById("mensagemSnack").innerHTML = mensagem;
  setTimeout(function(){ 
  	x.className = x.className.replace("show", ""); 
  }, 3000);
}
	
	
//metodo para carregar o combo 'laboratorios'
function loadLaboratorios() 
{		
	laboratorios.length = 0;
	fetch('http://localhost:8080/laboratorios/')
	.catch(err => alert("Erro ao ler os dados (Laboratórios)"))
	.then(response => response.json())
	.then(dados => {		
		if (dados == null) 
			alert("Erro ao ler os dados (Laboratórios)");
		else {
			laboratorios.add(new Option("", ""));
			dados.forEach(function(item, pos) {
				laboratorios.add(new Option(item.nome, item.id));
			})
			loadDadosEdicao();
		}
	})
}


//document ready jQuery para carregar objetos gerais da tela
$(document).ready(function() {			  				
	//carregar calendario jQuery
	$('.datepicker').datepicker({ format: "dd/mm/yyyy" });	
	
	//metodo para contagem de caracteres no elemento (input, textarea)
	$(".contador").on("keyup blur", function(){
	  el = $(this);  
	  var max = el.attr("maxlength");
	  var length = (el.val() != "")? el.val().length : 0;
	  var counter = (length > 0)? max-length : 0;
	  if( counter >= max)
	  	return false;  
	  el.parent().find(".contador_"+el.attr("id")).text(counter+"/"+max);
	});
	
		//carregar combo 'propriedades' e 'laboratorios'
	divCNPJ = document.getElementById("divCNPJ");
	propriedades = document.getElementById("propriedades");
	laboratorios = document.getElementById("laboratorios");
	loadPropriedades();	

	//listener para salvar dados
	btnSalvarDados = document.getElementById("btnSalvarDados");
	btnSalvarDados.addEventListener("click", function() {
		salvarDados();
	})
	
	//listener para cancelar 
	btnCancelar = document.getElementById("btnCancelar");
	btnCancelar.addEventListener("click", function() {
		location.href="/";
	})
	
	//listener do combo 'propriedades'
	propriedades.addEventListener("change", function() 
	{
		var tempCNPJ = "";
		divCNPJ.innerHTML = "";
		if (this.value != "") {
			dadosPropriedades.forEach((item) => {
				if (item.id == this.value) {
					tempCNPJ = item.cnpj;
					tempCNPJ = tempCNPJ.substr(0, 2)+"."+tempCNPJ.substr(2, 3)+"."+tempCNPJ.substr(5, 3)+
										 "/"+tempCNPJ.substr(8, 4)+"-"+tempCNPJ.substr(12, 2);
					return false;
				}
				divCNPJ.innerHTML = "CNPJ: "+tempCNPJ;
			})
		}
	})	
});
