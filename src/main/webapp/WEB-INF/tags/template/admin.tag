<%@attribute name="extraScripts" fragment="true"%>
<%@attribute name="extraStyles" fragment="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Controle Imóveis</title>

<!-- OLD CSS ============================= -->
<!-- bootstrap -->
<%--   <link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.min.css'/>"> --%>
<%--   <link rel="stylesheet" href="<c:url value='/assets/css/bootstrap-theme.min.css'/>"> --%>

<!-- style -->
<%--    <link rel="stylesheet" href="<c:url value='/assets/css/index.css'/>"> --%>
<%--    <link rel="stylesheet" href="<c:url value='/assets/css/forms.css'/>"> --%>
<jsp:invoke fragment="extraStyles" />


<!--     Fonts and icons     -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons" />
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />

<!-- CSS Files -->
<link href="/assets/css/bootstrap.min.css" rel="stylesheet" />
<link href="/assets/css/material-kit.css" rel="stylesheet" />

</head>

<body>

	<!-- INICIO NAV (alterar pra include)-->

	<nav class="navbar navbar-fixed-top navbar-color-on-scroll">
		<div class="container-fluid">
			<div class="navbar-header">

				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#menu" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/">Controle Imóveis</a>
			</div>

			<div class="collapse navbar-collapse" id="menu">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Menu <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="<c:url value='/cliente/form'/>"><span
									class="glyphicon glyphicon-plus-sign"></span> Add cliente</a></li>
							<li><a href="<c:url value='/cliente'/>"><span
									class="glyphicon glyphicon-menu-hamburger"></span> List cliente</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="<c:url value='/endereco/form'/>"><span
									class="glyphicon glyphicon-plus-sign"></span> Add endereco</a></li>
							<li><a href="<c:url value='/endereco'/>"><span
									class="glyphicon glyphicon-menu-hamburger"></span> List
									endereco</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="<c:url value='/bairro/form'/>"><span
									class="glyphicon glyphicon-plus-sign"></span> Add bairro</a></li>
							<li><a href="<c:url value='/bairro'/>"><span
									class="glyphicon glyphicon-menu-hamburger"></span> List bairro</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="<c:url value='/cidade/form'/>"><span
									class="glyphicon glyphicon-plus-sign"></span> Add cidade</a></li>
							<li><a href="<c:url value='/cidade'/>"><span
									class="glyphicon glyphicon-menu-hamburger"></span> List cidade</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="<c:url value='/estado/form'/>"><span
									class="glyphicon glyphicon-plus-sign"></span> Add estado</a></li>
							<li><a href="<c:url value='/estado'/>"><span
									class="glyphicon glyphicon-menu-hamburger"></span> List estado</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="<c:url value='/telefone/form'/>"><span
									class="glyphicon glyphicon-plus-sign"></span> Add telefone</a></li>
							<li><a href="<c:url value='/telefone'/>"><span
									class="glyphicon glyphicon-menu-hamburger"></span> List
									telefone</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="<c:url value='/usuario/form'/>"><span
									class="glyphicon glyphicon-plus-sign"></span> Add usuario</a></li>
							<li><a href="<c:url value='/usuario'/>"><span
									class="glyphicon glyphicon-menu-hamburger"></span> List usuario</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="<c:url value='/imovel/form'/>"><span
									class="glyphicon glyphicon-plus-sign"></span> Add imovel</a></li>
							<li><a href="<c:url value='/imovel'/>"><span
									class="glyphicon glyphicon-menu-hamburger"></span> List imovel</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="<c:url value='/tipoImovel/form'/>"><span
									class="glyphicon glyphicon-plus-sign"></span> Add tipoImovel</a></li>
							<li><a href="<c:url value='/tipoImovel'/>"><span
									class="glyphicon glyphicon-menu-hamburger"></span> List
									tipoImovel</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="<c:url value='/caracteristicaImovel/form'/>"><span
									class="glyphicon glyphicon-plus-sign"></span> Add
									caracteristicaImovel</a></li>
							<li><a href="<c:url value='/caracteristicaImovel'/>"><span
									class="glyphicon glyphicon-menu-hamburger"></span> List
									caracteristicaImovel</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="<c:url value='/atendimento/form'/>"><span
									class="glyphicon glyphicon-plus-sign"></span> Add atendimento</a></li>
							<li><a href="<c:url value='/atendimento'/>"><span
									class="glyphicon glyphicon-menu-hamburger"></span> List
									atendimento</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="<c:url value='/tipoContato/form'/>"><span
									class="glyphicon glyphicon-plus-sign"></span> Add tipoContato</a></li>
							<li><a href="<c:url value='/tipoContato'/>"><span
									class="glyphicon glyphicon-menu-hamburger"></span> List
									tipoContato</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="<c:url value='/tipoPretensao/form'/>"><span
									class="glyphicon glyphicon-plus-sign"></span> Add tipoPretensao</a></li>
							<li><a href="<c:url value='/tipoPretensao'/>"><span
									class="glyphicon glyphicon-menu-hamburger"></span> List
									tipoPretensao</a></li>
							<li role="separator" class="divider"></li>
						</ul></li>
				</ul>

			</div>
		</div>
	</nav>

	<!-- FINAL NAV -->
	<div class="wrapper">
		<div class="header header-filter"
			style="background-image: url(&quot;/assets/img/bg_city.jpg&quot;); transform: translate3d(0px, 0px, 0px);">
			<!-- 		<div class="container"> -->
			<!-- 			<div class="row"> -->
			<!-- 				<div class="col-md-8 col-md-offset-2"> -->
			<!-- 					<div class="brand"> -->
			<!-- 						<h1>CONTROLE IMÓVEIS</h1> -->
			<!-- 						<h3>Imobiliária de velocidade garantida</h3> -->
			<!-- 					</div> -->
			<!-- 				</div> -->
			<!-- 			</div> -->

		</div>
	</div>
	<jsp:doBody />
	<%-- 	<script src="<c:url value='/assets/js/jquery.min.js'/>"></script> --%>
	<%-- 	<script src="<c:url value='/assets/js/bootstrap.min.js'/>"></script> --%>
	<jsp:invoke fragment="extraScripts" />

</body>
<!--   Core JS Files   -->
<script src="/assets/js/jquery.min.js" type="text/javascript"></script>
<script src="/assets/js/jquery.mask.min.js" type="text/javascript"></script>

<!-- Mascaras para os inputs -->
<script>
	$(function() {
		$("#dataAniversario").mask('ZZ/ZZ/ZZZZ',{
		    translation: {
		        'Z': {
		          pattern: /[0-9]/, optional: false
		        }
		      }
		    });
		$("#cpf").mask("ZZZ.ZZZ.ZZZ-ZZ",{
		    translation: {
		        'Z': {
		          pattern: /[0-9]/, optional: false
		        }
		      }
		    });
		$("input[name='telefone.telefone']").mask("(ZZ)ZZZZZ-ZZZ",{
		    translation: {
		        'Z': {
		          pattern: /[0-9]/, optional: false
		        }
		      }
		    });
		$("input[name='endereco.cep']").mask("ZZZZZ-ZZZ",{
		    translation: {
		        'Z': {
		          pattern: /[0-9]/, optional: false
		        }
		      }
		    });
// 		$("#renda").mask("#.##0,00", {reverse: true});
	});
</script>

<script src="/assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/assets/js/material.min.js"></script>

<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
<script src="/assets/js/nouislider.min.js" type="text/javascript"></script>

<!--  Plugin for the Datepicker, full documentation here: http://www.eyecon.ro/bootstrap-datepicker/ -->
<script src="/assets/js/bootstrap-datepicker.js" type="text/javascript"></script>

<!-- Control Center for Material Kit: activating the ripples, parallax effects, scripts from the example pages etc -->
<script src="/assets/js/material-kit.js" type="text/javascript"></script>

<script type="text/javascript">
	$().ready(function() {
		// the body of this function is in assets/material-kit.js
		materialKit.initSliders();
		window_width = $(window).width();

		if (window_width >= 992) {
			big_image = $('.wrapper > .header');

			$(window).on('scroll', materialKitDemo.checkScrollForParallax);
		}

	});
</script>
</html>