<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Test de JQuery</title>
		<script type="text/javascript" src='<c:url value="/js/jquery-1.8.2.js" />'></script>
		<script type="text/javascript">
			//funcion de animar
			function animar() {
				$("#divAnimado").animate({left:"+=200px"}, "slow");
				//uso el callback para generar animación ininterrumpida
				$("#divAnimado").animate({left:"-=200px"}, "slow", animar);
			}
			
			//Espero que cargue la página
			$(function(){
				//Esconder los escondibles
				$(".escondible").click(
					function() {
						$(this).hide();
					}
				)
				//Mostrar y ocultar el escondible
				$("#toggle1").click(
					function() {
						$(".escondible").toggle("slow");
					}
				);
				//mover el div
				$("#animation").click(animar);
				//detener div
				$("#botonParar").click(
					function() {
						$("#divAnimado").clearQueue();
						$("#divAnimado").stop();
					}
				);
				$("#ajaxButton").click(
					function() {
						var id = $("#somethingId").val();
						$.ajax({
							url : '<c:url value="/services/get/" />'+id,
							type : "GET",
							dataType : "json",
							contentType : "application/json;charset=UTF-8",
							beforeSend : function() {
								$("#respuestaAjax").html("Sending...");
							},
							success : function(result, status, xhr){
								aux = "El something con id <u>";
								aux +=  result.something.id;
								aux +=  "</u> y valor <u>";
								aux +=  result.something.value;
								aux +=  "</u>";
								$("#respuestaAjax").html(aux);
							},
							error : function(jqXHR, textStatus, errorThrown) {
								var errorHtml = "An error ocurred <br/>";
								errorHtml += "Status: " + textStatus + "<br/>";
								errorHtml += "Reason: <pre>" + errorThrown + "</pre> <br/>";
								$("#respuestaAjax").html(errorHtml);
							}
						});
					}
				);
				
				$("#ajaxPostButton").click(
						function() {
							var value = $("#somethingValue").val();
							var something = {}
							something.value = value
							$.ajax({
								url : '<c:url value="/services/createSomethingAjax" />',
								type : "POST",
								data:  JSON.stringify(something),
								dataType : "json",
								contentType : "application/json;charset=UTF-8",
								beforeSend : function() {
									$("#respuestaPostAjax").html("Sending create...");
								},
								success : function(result, status, xhr){
									aux = "Creado el something con id <u>";
									aux +=  result.something.id;
									aux +=  "</u> y valor <u>";
									aux +=  result.something.value;
									aux +=  "</u>";
									$("#respuestaPostAjax").html(aux);
								},
								error : function(jqXHR, textStatus, errorThrown) {
									var errorHtml = "An error ocurred <br/>";
									errorHtml += "Status: " + textStatus + "<br/>";
									errorHtml += "Reason: <pre>" + errorThrown + "</pre> <br/>";
									$("#respuestaPostAjax").html(errorHtml);
								}
							});
						}
					);
			}); 
		</script>
	</head>
	<body>
		<h1>JQuery</h1>
		<p class="escondible">Me pueden esconder</p>
		<input type="button" id="toggle1" value="Toggle" />
		<br/>
		<input type="button" id="animation" value="A mover el div sin parar!" /> 
		<input type="button" id="botonParar" value="Parar el div" />
		<br/>
		<div id="divAnimado" style="background-color: green; height: 20px; width: 20px; position:absolute">&nbsp;</div>
		<br/>
		<h2>AJAX</h2>
		<input type="text" id="somethingId" value="3" /><br/>
		<input type="button" id="ajaxButton" value="Find Something" /><br/>
		<div id="respuestaAjax">Sin respuesta</div>
		<br/>
		<br/>
		<h2>Post de creación por AJAX</h2>
		<input type="text" id="somethingValue" value="Un valor" /><br/>
		<input type="button" id="ajaxPostButton" value="Crear Something" /><br/>
		<div id="respuestaPostAjax">Sin respuesta</div>
	</body>
</html>