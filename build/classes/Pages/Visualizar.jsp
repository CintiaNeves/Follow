<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>Follow | Visualizar</title>

    <!-- Favicon -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Core Stylesheet -->
    <link href="style.css" rel="stylesheet">

    <!-- Responsive CSS -->
    <link href="css/responsive.css" rel="stylesheet">

	<script>
		var i = document.getElementById("txtDtNascimento");
		var j = document.getElementById("txtDtNascimento");
	</script>
</head>

<body>
    <!-- ***** Preloader Start ***** -->
    <div id="preloader">
        <div class="mosh-preloader"></div>
    </div>

    <!-- ***** Header Area Start ***** -->
    <header class="header_area">
        <div class="container-fluid h-100">
            <div class="row h-100">
                <!-- Menu Area Start -->
                <div class="col-12 h-100">
                    <div class="menu_area h-100">
                        <nav class="navbar h-100 navbar-expand-lg align-items-center">
                            <!-- Logo 
                            <a class="navbar-brand" href="index.html"><img src="img/core-img/logo.png" alt="logo"></a>-->
                            <font size="6" color="white">FOLLOW</font>
                            <!-- Menu Area -->
                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#mosh-navbar" aria-controls="mosh-navbar" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>

                            <div class="collapse navbar-collapse justify-content-end" id="mosh-navbar">
                                <ul class="navbar-nav animated" id="nav">
                                    <li class="nav-item"><a class="nav-link">Home</a></li>
                                    <li class="nav-item"><a class="nav-link" href="Teste.jsp">Matrícula</a></li>
                                    <li class="nav-item active"><a class="nav-link" href="Consulta.jsp">Consulta</a></li>
                                </ul>
                                <!-- Search Form Area Start -->
                                <div class="search-form-area animated">
                                    <form action="#" method="post">
                                        <input type="search" name="search" id="search" placeholder="Type keywords &amp; hit enter">
                                        <button type="submit" class="d-none"><img src="img/core-img/search-icon.png" alt="Search"></button>
                                    </form>
                                </div>
                                <!-- Search btn -->
                                <div class="search-button">
                                    <a href="#" id="search-btn"><img src="img/core-img/search-icon.png" alt="Search"></a>
                                </div>
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <!-- ***** Header Area End ***** -->

    <!-- ***** Breadcumb Area Start ***** -->
    <div class="mosh-breadcumb-area" style="background-image: url(img/core-img/breadcumb.png);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="bradcumbContent">
                        <h2>Visualizar</h2>
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="#">Home</a></li>
                                <li class="breadcrumb-item"><a href="#">Consulta</a></li>
                                <li class="breadcrumb-item active" aria-current="page">Visualizar</li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ***** Breadcumb Area End ***** -->

    <!-- ***** Contact Area Start ***** -->
    <section class="contact-area section_padding_100">
        <div class="container">
            <div class="row">
                <!-- Contact Form Area -->
				<form action="/Follow/Pages/servlet" method="POST">
	                <div class="col-12 col-md-8">
	                    <div class="contact-form-area">
	                    <c:forEach items="${erro}" var="msg">
	                        <label style="color:red;">${msg}</label><br/>
	                    </c:forEach>
	                    <c:forEach items="${sucesso}" var="msg">
	                        <label style="color:green;">${msg}</label><br/>
	                    </c:forEach>
	                    <br/>
	                        <h2>Dados Pessoais</h2>
	                            <input type="hidden" id="FormName" name="FormName" value="VHALUNO" />
	                            <div class="row">
	                                <div class="col-12 col-md-6">
	                                	<label>Nome:</label>
	                                    <input readonly value="${aluno.nome}" type="text" class="form-control" id="txtNome" name="txtNome" placeholder="Nome Completo">
	                                </div>
	                                <div class="col-12 col-md-6">
	                                	<label>CPF:</label>
	                                    <input readonly value="${aluno.cpf}" type="text" class="form-control" id="txtCPF" name="txtCPF" placeholder="CPF">
	                                </div>
	                                <div class="col-12 col-md-6">
	                                	<label>RG:</label>
	                                     <input readonly value="${aluno.rg}" type="text" class="form-control" id="txtRg" name="txtRg" placeholder="RG">
	                                </div>
	                                <div class="col-12 col-md-6">
	                                	<label>Data de Nascimento:</label>
	                                    <input readonly value="<fmt:formatDate value="${aluno.dataNascimento.time }"/>" type="text" class="form-control" id="txtDtNascimento" placeholder="Data de Nascimento" name="txtDataNascimento">
	                                </div>
	                                
	                                <div class="col-12 col-md-6">
	                                	<label>Gênero:</label>
	                                   <input readonly value="${aluno.sexo }" type="text" class="form-control" id="txtGenero" placeholder="Gênero" name="txtSexo">
	                                
	                                </font>
	                                </div>
	
	                            </div>
	                        <br><br>
	                        <h2>Informações de Contato</h2>
	                        <h3>Endereço</h3>
	                            <div class="row">
	                                <div class="col-12 col-md-6">
	                                	<label>Logradouro:</label>
	                                    <input readonly value="${aluno.endereco.logradouro}" type="text" class="form-control" id="txtLogradouro" name="txtLogradouro"placeholder="Logradouro">
	                                </div>
	                                <div class="col-12 col-md-6">
	                                	<label>Numero:</label>
	                                    <input readonly value="${aluno.endereco.numero}" type="text" class="form-control" id="txtNumero" name="txtNumero" placeholder="Número">
	                                </div>
	                                <div class="col-12 col-md-6">
	                                	<label>Bairro:</label>
	                                    <input readonly value="${aluno.endereco.bairro}" type="text" class="form-control" id="txtBairro" name="txtBairro"placeholder="Bairro">
	                                </div>
	                                <div class="col-12 col-md-6">
	                                	<label>Cidade:</label>
	                                    <input readonly value="${aluno.endereco.cidade.nome}" type="text" class="form-control" id="txtCidade" name="txtCidade" placeholder="Cidade">
	                                </div>
	                                <div class="col-12 col-md-6">
	                                	<label>Complemento:</label>
	                                	<c:if test="${aluno.endereco.complemento != null and aluno.endereco.complemento != ''}">
	                                    	<input readonly value="${aluno.endereco.complemento}" type="text" class="form-control" id="txtComplemento" name="txtComplemento">
	                                    </c:if>
	                                    <c:if test="${aluno.endereco.complemento == null or aluno.endereco.complemento == ''}">
	                                    	<input readonly value="" type="text" class="form-control" id="txtComplemento" name="txtComplemento">
	                                    </c:if>
	                                    
	                                </div>
	                                <div class="col-12 col-md-6">
	                                	<label>Estado:</label>
	                                    <input readonly value="${aluno.endereco.cidade.estado.nome}" type="text" class="form-control" id="txtEstado" name="txtEstado" placeholder="Estado">
	                                </div>
	                                <div class="col-12 col-md-6">
	                                	<label>CEP:</label>
	                                    <input readonly value="${aluno.endereco.cep}" type="text" class="form-control" id="txtCep" name="txtCep" placeholder="Cep">
	                                </div>
	                                </div>
	                                <div class="row">
	                                 <div class="col-12 col-md-6">
	                                	<label>Telefone:</label>
	                                    <input readonly value="${aluno.telefone.numero}" type="text" class="form-control" id="txtTelefone" name="txtTelefone" placeholder="Telefone">
	                                </div>
	                                 <div class="col-12 col-md-6">
	                                	<label>E-mail:</label>
	                                    <input readonly value="${aluno.email}" type="email" class="form-control" id="txtEmail" name="txtEmail" placeholder="E-mail">
	                                </div>
	                            </div>
	                    </div>
	                </div>
	                
	                
	                
	                <div class="col-12 col-md-8">
	                    <div class="contact-form-area">
	                        <br><br>
	                        <h2>Dados Acadêmicos</h2>
	                        <h3>Curso</h3>
	                            <div class="row">
	                                <div class="col-12 col-md-6">
	                                	<input readonly value="${aluno.curso.nomeCurso}" type="text" class="form-control" id="txtCurso" name="txtCurso" placeholder="Curso">
	                                	<label>RA:</label>
	                                    <input readonly value="${aluno.ra.id}" type="text" class="form-control" id="txtRa" name="txtRa">
	                                    <label>Data de Matrícula:</label>
	                                    <input readonly value="<fmt:formatDate value="${aluno.dataMatricula.time }"/>" type="text" class="form-control" id="txtDtMatricula" name="txtDtMatricula">	                                	
	                    			</div>
	                			</div>
	                		</div> 
                    </form>
                </div>
            </div>
        </div>
    </section>
				</form>
           	</div>
        </div>
    </section>
    <!-- ***** Contact Area End ***** -->

    
        <!-- Fotter Bottom Area -->
        <div class="footer-bottom-area">
            <div class="container h-100">
                <div class="row h-100">
                    <div class="col-12 h-100">
                        <div class="footer-bottom-content h-100 d-md-flex justify-content-between align-items-center">
                            <div class="copyright-text">
                                <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template was made by GrubeLube
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
</p>
                            </div>
                            <div class="footer-social-info">
                                <a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a>
                                <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                                <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                                <a href="#"><i class="fa fa-dribbble" aria-hidden="true"></i></a>
                                <a href="#"><i class="fa fa-behance" aria-hidden="true"></i></a>
                                <a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- ***** Footer Area End ***** -->

    <!-- jQuery-2.2.4 js -->
    <script src="js/jquery-2.2.4.min.js"></script>
    <!-- Popper js -->
    <script src="js/popper.min.js"></script>
    <!-- Bootstrap js -->
    <script src="js/bootstrap.min.js"></script>
    <!-- All Plugins js -->
    <script src="js/plugins.js"></script>
    <!-- Active js -->
    <script src="js/active.js"></script>
    <!-- Google Maps -->
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAwuyLRa1uKNtbgx6xAJVmWy-zADgegA2s"></script>
    <script src="js/map-active.js"></script>

</body>

</html>