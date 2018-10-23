<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="paginaErro.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@include  file="validar.jsp"%>
<!DOCTYPE html>
<html lang="pt-br">


    <!-- Mirrored from wrappixel.com/demos/admin-templates/monster-admin/minimal/app-email.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 06 Oct 2018 13:06:21 GMT -->
   <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- Tell the browser to be responsive to screen width -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- Favicon icon -->
        <link rel="icon" type="image/png" sizes="16x16" href="resources/assets/images/petroLG.png">
        <title>Sistema PV | Caixa de Mensagens </title>
        <!-- Bootstrap Core CSS -->
        <link href="resources/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS  -->
        <link href="resources/minimal/css/style.css" rel="stylesheet">
        <!-- You can change the theme colors from here -->
        <link href="resources/minimal/css/colors/default-dark.css" id="theme" rel="stylesheet">
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]> 
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>-->
    
    </head>

    <body class="fix-header card-no-border">
        <!-- ============================================================== -->
        <!-- Preloader - style you can find in spinners.css -->
        <!-- ============================================================== -->
    
        <!-- ============================================================== -->
        <!-- Main wrapper - style you can find in pages.scss -->
        <!-- ============================================================== -->
        <div id="main-wrapper">
            <!-- ============================================================== -->
            <!-- Topbar header - style you can find in pages.scss -->
            <!-- ============================================================== -->
           <header class="topbar">
                <nav class="navbar top-navbar navbar-expand-md navbar-light">
                    <!-- ============================================================== -->
                    <!-- Logo -->
                    <!-- ============================================================== -->
                    <div class="navbar-header">
                        <a class="navbar-brand" href="/SPVPetromoc/entrar">
                            <b>
                                <img src="resources/assets/images/petroLG.png" alt="" class="dark-logo" />
                            </b>
                        </a>
                    </div>
                    <!-- ============================================================== -->
                    <!-- End Logo -->
                    <!-- ============================================================== -->
                    <div class="navbar-collapse">
                        <!-- ============================================================== -->
                        <!-- toggle and nav items -->
                        <!-- ============================================================== -->
                        <ul class="navbar-nav mr-auto mt-md-0 ">
                            <!-- This is  -->
                            <li class="nav-item"> <a class="nav-link nav-toggler hidden-md-up text-muted waves-effect waves-dark" href="javascript:void(0)"><i class="ti-menu"></i></a> </li>
                            <li class="nav-item"> <a class="nav-link sidebartoggler hidden-sm-down text-muted waves-effect waves-dark" href="javascript:void(0)"><i class="icon-arrow-left-circle"></i></a> </li>
                            <!-- ============================================================== -->
                            <!-- Comment -->
                            <!-- ============================================================== -->
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle text-muted text-muted waves-effect waves-dark" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="mdi mdi-message"></i>
                                    <div class="notify"> <span class="heartbit"></span> <span class="point"></span> </div>
                                </a>
                                <div class="dropdown-menu mailbox animated bounceInDown">
                                    <ul>
                                        <li>
                                            <div class="drop-title">Notificações</div>
                                        </li>
                                        <li>
                                            <div class="message-center">
                                                <!-- Message -->
                                                <a href="#">
                                                    <div class="btn btn-danger btn-circle"><i class="fa fa-link"></i></div>
                                                    <div class="mail-contnet">
                                                        <h5>Luanch Admin</h5> <span class="mail-desc">Just see the my new admin!</span> <span class="time">9:30 AM</span> </div>
                                                </a>
                                            </div>
                                        </li>
                                        <li>
                                            <a class="nav-link text-center" href="javascript:void(0);"> <strong>Check all notifications</strong> <i class="fa fa-angle-right"></i> </a>
                                        </li>
                                    </ul>
                                </div>
                            </li>
                            <!-- ============================================================== -->
                            <!-- End Comment -->
                            <!-- ============================================================== -->
                            <!-- ============================================================== -->
                            <!-- Messages -->
                            <!-- ============================================================== -->
                           
                            <!-- ============================================================== -->
                            <!-- End Messages -->
                            <!-- ============================================================== -->
                        </ul>
                        <!-- ============================================================== -->
                        <!-- User profile and search -->
                        <!-- ============================================================== -->
                        <ul class="navbar-nav my-lg-0">
                            <li class="nav-item hidden-sm-down">
                                <form class="app-search">
                                    <input type="text" class="form-control" placeholder="Pesquisar..."> <a class="srh-btn"><i class="ti-search"></i></a> </form>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle text-muted waves-effect waves-dark" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img src="resources/assets/images/users/img_padrao.png" alt="user" class="profile-pic" /></a>
                                <div class="dropdown-menu dropdown-menu-right animated flipInY">
                                    <ul class="dropdown-user">
                                        <li>
                                            <div class="dw-user-box">
                                                <div class="u-img"><img src="resources/assets/images/users/img_padrao.png" alt="user"></div> 
                                                <div class="u-text">
                                                    <h4>${usu.nome_user}</h4>
                                                    <p class="text-muted">${usu.email_user}</p><a href="#" class="btn btn-rounded btn-danger btn-sm">Ver perfil</a></div>
                                            </div>
                                        </li>
                                        <li role="separator" class="divider"></li>
                                        <li><a href="#"><i class="ti-user"></i> Meu perfil</a></li>

                                        <li><a href="/SPVPetromoc/inbox"><i class="ti-email"></i> Caixa de mensagens</a></li>
                                        <li role="separator" class="divider"></li>
                                        <li><a href="#"><i class="ti-settings"></i> Definicoes da conta</a></li>
                                        <li role="separator" class="divider"></li>
                                        <li><a href="/SPVPetromoc/logout"><i class="fa fa-power-off"></i> Sair</a></li>
                                    </ul>
                                </div>
                            </li>
                        </ul>
                    </div>
                </nav>
            </header>
            <!-- ============================================================== -->
            <!-- End Topbar header -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- Left Sidebar - style you can find in sidebar.scss  -->
            <aside class="left-sidebar">
                <!-- Sidebar scroll-->
                <div class="scroll-sidebar">
                    <!-- User profile -->
                    <div class="user-profile">
                        <!-- User profile image--> 
                        <div class="profile-img"> <img src="resources/assets/images/users/img_padrao.png" alt="user" /> </div>
                        <!-- User profile text-->
                        <div class="profile-text"> <a href="#" class="dropdown-toggle link u-dropdown" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="true">${usu.nome_user} <span class="caret"></span></a>
                            <div class="dropdown-menu animated flipInY">
                                <a href="#" class="dropdown-item"><i class="ti-user"></i> Meu perfil</a>

                                <a href="#" class="dropdown-item"><i class="ti-email"></i> Mensagens</a>
                                <div class="dropdown-divider"></div> <a href="#" class="dropdown-item"><i class="ti-settings"></i> Definicoes</a>
                                <div class="dropdown-divider"></div> <a href="#" class="dropdown-item"><i class="fa fa-power-off"></i> Sair</a>
                            </div>
                        </div>
                    </div>
                    <!-- End User profile text-->
                    <!-- Sidebar navigation-->
                    <nav class="sidebar-nav">
                        <ul id="sidebarnav">

                            <li>
                                <a class="has-arrow " href="#" aria-expanded="false"><i class="mdi mdi-email"></i><span class="hide-menu">Caixa de Requisicoes</span></a>
                                <ul aria-expanded="false" class="collapse">
                                    <li><a href="/SPVPetromoc/inbox">Requisicoes</a></li>

                                    <li><a href="/SPVPetromoc/lista-viatura">Requisitar</a></li>
                                </ul>
                            </li>
                            <li class="nav-devider"></li>

                            <li>
                                <a class="has-arrow" href="#" aria-expanded="false"><i class="mdi mdi-file"></i><span class="hide-menu">Cadastros</span></a>
                                <ul aria-expanded="false" class="collapse">
                                    <li><a href="/SPVPetromoc/form-usuario">Usuario</a></li>
                                    <li><a href="/SPVPetromoc/form-motorista">Motorista</a></li>
                                    <li><a href="/SPVPetromoc/form-viatura">Viatura</a></li>

                                </ul>
                            </li>
                            <li>
                                <a class="has-arrow " href="#" aria-expanded="false"><i class="mdi mdi-table"></i><span class="hide-menu">Listagem</span></a>
                                <ul aria-expanded="false" class="collapse">
                                    <li><a href="/SPVPetromoc/lista-usuario">Usuario</a></li>
                                    <li><a href="/SPVPetromoc/lista-motorista">Motorista</a></li>
                                    <li><a href="/SPVPetromoc/listagem">Viatura</a></li>

                                </ul>
                            </li>

                            <li class="nav-devider"></li>

                            <li>
                                <a class="js-arrow " href="/SPVPetromoc/lista-viatura"><i class="mdi mdi-book-multiple"></i>Requisicao</a>

                            </li>
                            <li>
                                <a class="js-arrow " href="/SPVPetromoc/disponivel" ><i class="mdi mdi-book-multiple"></i>Disponibilidade</a>

                            </li>
                        </ul>
                    </nav>
                    <!-- End Sidebar navigation -->
                </div>
                <!-- End Sidebar scroll-->
                <!-- Bottom points-->

                <!-- End Bottom points-->
            </aside>
            <!-- ============================================================== -->
            <!-- End Left Sidebar - style you can find in sidebar.scss  -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- Page wrapper  -->
            <!-- ============================================================== -->
            <div class="page-wrapper">
                <!-- ============================================================== -->
                <!-- Container fluid  -->
                <!-- ============================================================== -->
                <div class="container-fluid">
                    <!-- ============================================================== -->
                    <!-- Bread crumb and right sidebar toggle -->
                    <!-- ============================================================== -->

                    <!-- ============================================================== -->
                    <!-- End Bread crumb and right sidebar toggle -->
                    <!-- ============================================================== -->
                    <!-- ============================================================== -->
                    <!-- Start Page Content -->
                    <!-- ============================================================== -->
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card">
                                <div class="row">
                                    <div class="col-xlg-2 col-lg-3 col-md-4">
                                        <div class="card-body inbox-panel"><a href="#" class="btn btn-danger mb-3 p-2 btn-block waves-effect waves-light">Requisitar</a>
                                            <ul class="list-group list-group-full">
                                                <li class="list-group-item active"> <a href="javascript:void(0)"><i class="mdi mdi-gmail"></i> Requisicoes</a><span class="badge badge-success ml-auto">6</span></li>
                                                <li class="list-group-item">
                                                    <a href="javascript:void(0)"> <i class="mdi mdi-star"></i> Favorito </a>
                                                </li>
                                                <li class="list-group-item ">
                                                    <a href="javascript:void(0)"> <i class="mdi mdi-file-document-box"></i> Enviados  </a>
                                                </li>
                                                <li class="list-group-item">
                                                    <a href="javascript:void(0)"> <i class="mdi mdi-delete"></i> Lixeira </a>
                                                </li>
                                            </ul>

                                        </div>
                                    </div>
                                    <div class="col-xlg-10 col-lg-9 col-md-8">
                                        <div class="card-body">

                                            <!-- <div class="btn-group mb-2 mr-2" role="group" aria-label="Button group with nested dropdown">
                                                 <div class="btn-group" role="group">
                                                     <button id="btnGroupDrop1" type="button" class="btn btn-secondary text-dark dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="mdi mdi-folder font-18 "></i> </button>
                                                     <div class="dropdown-menu" aria-labelledby="btnGroupDrop1"> <a class="dropdown-item" href="#">Dropdown link</a> <a class="dropdown-item" href="#">Dropdown link</a> </div>
                                                 </div>
                                                 <div class="btn-group" role="group">
                                                     <button id="btnGroupDrop1" type="button" class="btn text-dark btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="mdi mdi-label font-18"></i> </button>
                                                     <div class="dropdown-menu" aria-labelledby="btnGroupDrop1"> <a class="dropdown-item" href="#">Dropdown link</a> <a class="dropdown-item" href="#">Dropdown link</a> </div>
                                                 </div>
                                             </div> -->
                                            <button type="button " class="btn btn-secondary mr-2 mb-2 text-dark"><i class="mdi mdi-reload font-18"></i></button>

                                        </div>
                                        <div class="card-body pt-0">
                                            <div class="card b-all shadow-none">
                                                <div class="inbox-center b-all table-responsive">
                                                    <table class="table table-hover no-wrap">
                                                        <tbody>
                                                           <c:forEach var="lista" items="${lista}">
                                                                <tr class="unread" >
                                                                    <td style="width:40px">
                                                                        <div class="checkbox">
                                                                            <input type="checkbox" id="checkbox0" value="check">
                                                                            <label for="checkbox0"></label>
                                                                        </div>
                                                                    </td>
                                                                    <td style="width:40px" class="hidden-xs-down"><i class="fa fa-star-o"></i></td>
                                                                    <td>${lista.usu.nome_user}</td>
                                                                    <td class="max-texts"> <a href="/SPVPetromoc/mensagem?id=${lista.cod_req}"/> Envio da requisicao da viatura ${lista.vt.marca} ${lista.vt.modelo} </td>
                                                                    <td class="hidden-xs-down"></td>
                                                                    <td class="text-right"> ${lista.data_req} </td>
                                                                </tr>
                                                            </c:forEach>
                                                            <c:forEach var="recebidos" items="${recebidos}">
                                                                <tr class="unread" >
                                                                    <td style="width:40px">
                                                                        <div class="checkbox">
                                                                            <input type="checkbox" id="checkbox0" value="check">
                                                                            <label for="checkbox0"></label>
                                                                        </div>
                                                                    </td>
                                                                    <td style="width:40px" class="hidden-xs-down"><i class="fa fa-star-o"></i></td>
                                                                    <td>${recebidos.usu.nome_user}</td>
                                                                    <td class="max-texts"> <a href="/SPVPetromoc/mensagem?id=${recebidos.cod_req}"/> Solicitacao da viatura</td>
                                                                    <td class="hidden-xs-down"></td>
                                                                    <td class="text-right"> ${recebidos.data_req} </td>
                                                                </tr>
                                                            </c:forEach>
                                                            <c:forEach var="aceites" items="${aceites}">
                                                                <tr class="unread" >
                                                                    <td style="width:40px">
                                                                        <div class="checkbox">
                                                                            <input type="checkbox" id="checkbox0" value="check">
                                                                            <label for="checkbox0"></label>
                                                                        </div>
                                                                    </td>
                                                                    <td style="width:40px" class="hidden-xs-down"><i class="fa fa-star-o"></i></td>
                                                                    <td>${aceites.usu.nome_user}</td>
                                                                    <td class="max-texts"> <a href="/SPVPetromoc/mensagem?id=${aceites.cod_req}"/> Solicitacao validada</td>
                                                                    <td class="hidden-xs-down"></td>
                                                                    <td class="text-right"> ${aceites.data_req} </td>
                                                                </tr>
                                                            </c:forEach>
                                                                     <c:forEach var="entradas" items="${entradas}">
                                                                <tr class="unread" >
                                                                    <td style="width:40px">
                                                                        <div class="checkbox">
                                                                            <input type="checkbox" id="checkbox0" value="check">
                                                                            <label for="checkbox0"></label>
                                                                        </div>
                                                                    </td>
                                                                    <td style="width:40px" class="hidden-xs-down"><i class="fa fa-star-o"></i></td>
                                                                    <td>${entradas.msgs_req[1].tipo_msg}</td>
                                                                    <td class="max-texts"> <a href="#"/> ${entradas.msgs_req[1].titulo_msg} </td>
                                                                    <td class="hidden-xs-down"></td>
                                                                    <td class="text-right"> ${entradas.msgs_req[1].data_msg} </td>
                                                                </tr>
                                                            </c:forEach>
                                                                     <c:forEach var="saidasAdmin" items="${saidasAdmin}">
                                                                <tr class="unread" >
                                                                    <td style="width:40px">
                                                                        <div class="checkbox">
                                                                            <input type="checkbox" id="checkbox0" value="check">
                                                                            <label for="checkbox0"></label>
                                                                        </div>
                                                                    </td>
                                                                    <td style="width:40px" class="hidden-xs-down"><i class="fa fa-star-o"></i></td>
                                                                    <td>${saidasAdmin.msgs_req[2].tipo_msg}</td>
                                                                    <td class="max-texts"> <a href="#"/> ${saidasAdmin.msgs_req[2].titulo_msg} </td>
                                                                    <td class="hidden-xs-down"></td>
                                                                    <td class="text-right"> ${saidasAdmin.msgs_req[2].data_msg} </td>
                                                                </tr>
                                                            </c:forEach>
                                                                     <c:forEach var="saidas" items="${saidas}">
                                                                <tr class="unread" >
                                                                    <td style="width:40px">
                                                                        <div class="checkbox">
                                                                            <input type="checkbox" id="checkbox0" value="check">
                                                                            <label for="checkbox0"></label>
                                                                        </div>
                                                                    </td>
                                                                    <td style="width:40px" class="hidden-xs-down"><i class="fa fa-star-o"></i></td>
                                                                    <td>${saidas.msgs_req[0].tipo_msg}</td>
                                                                    <td class="max-texts"> <a href="#"/> ${saidas.msgs_req[0].titulo_msg} </td>
                                                                    <td class="hidden-xs-down"></td>
                                                                    <td class="text-right"> ${saidas.msgs_req[0].data_msg} </td>
                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- ============================================================== -->
                    <!-- End PAge Content -->
                    <!-- ============================================================== -->
                    <!-- ============================================================== -->
                    <!-- Right sidebar -->
                    <!-- ============================================================== -->
                    <!-- .right-sidebar -->
                   <!-- <div class="right-sidebar">
                        <div class="slimscrollright">
                            <div class="rpanel-title"> Service Panel <span><i class="ti-close right-side-toggle"></i></span> </div>
                            <div class="r-panel-body">
                                <ul id="themecolors" class="mt-3">
                                    <li><b>With Light sidebar</b></li>
                                    <li><a href="javascript:void(0)" data-theme="default" class="default-theme">1</a></li>
                                    <li><a href="javascript:void(0)" data-theme="green" class="green-theme">2</a></li>
                                    <li><a href="javascript:void(0)" data-theme="red" class="red-theme">3</a></li>
                                    <li><a href="javascript:void(0)" data-theme="blue" class="blue-theme working">4</a></li>
                                    <li><a href="javascript:void(0)" data-theme="purple" class="purple-theme">5</a></li>
                                    <li><a href="javascript:void(0)" data-theme="megna" class="megna-theme">6</a></li>
                                    <li class="d-block mt-4"><b>With Dark sidebar</b></li>
                                    <li><a href="javascript:void(0)" data-theme="default-dark" class="default-dark-theme">7</a></li>
                                    <li><a href="javascript:void(0)" data-theme="green-dark" class="green-dark-theme">8</a></li>
                                    <li><a href="javascript:void(0)" data-theme="red-dark" class="red-dark-theme">9</a></li>
                                    <li><a href="javascript:void(0)" data-theme="blue-dark" class="blue-dark-theme">10</a></li>
                                    <li><a href="javascript:void(0)" data-theme="purple-dark" class="purple-dark-theme">11</a></li>
                                    <li><a href="javascript:void(0)" data-theme="megna-dark" class="megna-dark-theme ">12</a></li>
                                </ul>
                                <ul class="mt-3 chatonline">
                                    <li><b>Chat option</b></li>
                                    <li>
                                        <a href="javascript:void(0)"><img src="../assets/images/users/1.jpg" alt="user-img" class="img-circle"> <span>Varun Dhavan <small class="text-success">online</small></span></a>
                                    </li>
                                    <li>
                                        <a href="javascript:void(0)"><img src="../assets/images/users/2.jpg" alt="user-img" class="img-circle"> <span>Genelia Deshmukh <small class="text-warning">Away</small></span></a>
                                    </li>
                                    <li>
                                        <a href="javascript:void(0)"><img src="../assets/images/users/3.jpg" alt="user-img" class="img-circle"> <span>Ritesh Deshmukh <small class="text-danger">Busy</small></span></a>
                                    </li>
                                    <li>
                                        <a href="javascript:void(0)"><img src="../assets/images/users/4.jpg" alt="user-img" class="img-circle"> <span>Arijit Sinh <small class="text-muted">Offline</small></span></a>
                                    </li>
                                    <li>
                                        <a href="javascript:void(0)"><img src="../assets/images/users/5.jpg" alt="user-img" class="img-circle"> <span>Govinda Star <small class="text-success">online</small></span></a>
                                    </li>
                                    <li>
                                        <a href="javascript:void(0)"><img src="../assets/images/users/6.jpg" alt="user-img" class="img-circle"> <span>John Abraham<small class="text-success">online</small></span></a>
                                    </li>
                                    <li>
                                        <a href="javascript:void(0)"><img src="../assets/images/users/7.jpg" alt="user-img" class="img-circle"> <span>Hritik Roshan<small class="text-success">online</small></span></a>
                                    </li>
                                    <li>
                                        <a href="javascript:void(0)"><img src="../assets/images/users/8.jpg" alt="user-img" class="img-circle"> <span>Pwandeep rajan <small class="text-success">online</small></span></a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>-->
                    <!-- ============================================================== -->
                    <!-- End Right sidebar -->
                    <!-- ============================================================== -->
                </div>
                <!-- ============================================================== -->
                <!-- End Container fluid  -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- footer -->
                <!-- ============================================================== -->
                <footer class="footer"> © 2017 Monster Admin by wrappixel.com </footer>
                <!-- ============================================================== -->
                <!-- End footer -->
                <!-- ============================================================== -->
            </div>
            <!-- ============================================================== -->
            <!-- End Page wrapper  -->
            <!-- ============================================================== -->
        </div>
        <!-- ============================================================== -->
        <!-- End Wrapper -->
        <!-- ============================================================== -->
         <script src="resources/assets/plugins/jquery/jquery.min.js"></script>
    <!-- Bootstrap tether Core JavaScript -->
    <script src="resources/assets/plugins/bootstrap/js/popper.min.js"></script>
    <script src="resources/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
    <!-- slimscrollbar scrollbar JavaScript -->
    <script src="resources/minimal/js/jquery.slimscroll.js"></script>
    <!--Wave Effects -->
    <script src="resources/minimal/js/waves.js"></script>
    <!--Menu sidebar -->
    <script src="resources/minimal/js/sidebarmenu.js"></script>
    <!--stickey kit -->
    <script src="resources/assets/plugins/sticky-kit-master/dist/sticky-kit.min.js"></script>
    <!--Custom JavaScript -->
    <script src="resources/minimal/js/custom.min.js"></script>
    <script src="resources/minimal/js/validation.js"></script>
    <script src="resources/assets/plugins/inputmask/dist/min/jquery.inputmask.bundle.min.js"></script>
    <script src="resources/minimal/js/mask.init.js"></script>
    
     <!-- Input Mask-->
     <script src="resources/assets/plugins/inputmask/dist/min/jasny-bootstrap.min.js"></script>

      <!-- Date Picker Plugin JavaScript -->
    <script src="resources/assets/plugins/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>s
     <!-- ============================================================== -->
    <!-- Plugins for this page -->
    <!-- ============================================================== -->
    <!-- Plugin JavaScript -->
    <script src="resources/assets/plugins/moment/moment.js"></script>
    <!-- Clock Plugin JavaScript -->
    <script src="resources/assets/plugins/clockpicker/dist/jquery-clockpicker.min.js"></script>
    <!-- Color Picker Plugin JavaScript -->
    <script src="resources/assets/plugins/jquery-asColor/dist/jquery-asColor.js"></script>
    <script src="resources/assets/plugins/jquery-asGradient/dist/jquery-asGradient.js"></script>
    <script src="resources/assets/plugins/jquery-asColorPicker-master/dist/jquery-asColorPicker.min.js"></script>
    <!-- Date Picker Plugin JavaScript -->
    <script src="resources/assets/plugins/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
    <!-- Date range Plugin JavaScript -->
    <script src="resources/assets/plugins/timepicker/bootstrap-timepicker.min.js"></script>
    <script src="resources/assets/plugins/daterangepicker/daterangepicker.js"></script>
    <script src="resources/assets/plugins/moment/moment.js"></script>

    <script>
    ! function(window, document, $) {
        "use strict";
        $("input,select,textarea").not("[type=submit]").jqBootstrapValidation(), $(".skin-square input").iCheck({
            checkboxClass: "icheckbox_square-green",
            radioClass: "iradio_square-green"
        }), $(".touchspin").TouchSpin(), $(".switchBootstrap").bootstrapSwitch();
    }(window, document, jQuery);
    </script>
    <script>
    jQuery('#date-range').datepicker({
        toggleActive: true
    });
    </script>
    <!-- ============================================================== -->
    <!-- Style switcher -->
    <!-- ============================================================== -->
    <script src="resources/assets/plugins/styleswitcher/jQuery.style.switcher.js"></script>
    </body>


    <!-- Mirrored from wrappixel.com/demos/admin-templates/monster-admin/minimal/app-email.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 06 Oct 2018 13:06:21 GMT -->
</html>
