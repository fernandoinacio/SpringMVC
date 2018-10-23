<%-- 
    Document   : requesicoes
    Created on : 2/out/2018, 18:23:37
    Author     : Nando Cortez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="paginaErro.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@include  file="validar.jsp"%>

<!DOCTYPE html>
<html lang="pt-br">


    <!-- Mirrored from wrappixel.com/demos/admin-templates/monster-admin/minimal/form-validation.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 06 Oct 2018 13:09:31 GMT -->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- Tell the browser to be responsive to screen width -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- Favicon icon -->
        <link rel="icon" type="image/png" sizes="16x16" href="resources/assets/images/petroLG.png">

        <title>Sistema PV | Requesicao </title>
        <!-- Bootstrap Core CSS -->
        <link href="resources/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS  -->
        <link href="resources/minimal/css/style.css" rel="stylesheet">
        <!-- You can change the theme colors from here -->
        <link href="resources/minimal/css/colors/default-dark.css" id="theme" rel="stylesheet">

        <link href="resources/assets/plugins/timepicker/bootstrap-timepicker.min.css" rel="stylesheet">
        <link href="resources/assets/plugins/daterangepicker/daterangepicker.css" rel="stylesheet">
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]> 
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script> -->

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
            <!-- Left Sidebar - style you can find in sidebar.scss  -->
            <!-- ============================================================== -->
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


                            <li class="nav-devider"></li>

                            <li>
                                <a class="js-arrow " href="/SPVPetromoc/lista-viatura"><i class="mdi mdi-book-multiple"></i>Requisicao</a>

                            </li>
                            <li>
                                <a class="js-arrow " href="/SPVPetromoc/lista-viatura" ><i class="mdi mdi-book-multiple"></i>Disponibilidade</a>

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
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">
                                    <h4 class="card-title">Formulario de Requisicao</h4>
                                    <div class="alert alert-info alert-dismissible fade show" role="alert">
                                        <strong>${mensagem}</strong>
                                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <form class="mt-5" action="requisitar" method="post" novalidate>

                                        <div class="row">
                                            <div class="col-md-6">              
                                                <div class="example">
                                                    <div class="form-group">

                                                        <label>Data de partida/Regresso </label>
                                                        <div class="input-daterange input-group" id="date-range">
                                                            <input type="text" class="form-control" name="data_partida" required data-validation-required-message="Preencha o campo" />
                                                            <div class="input-group-append">
                                                                <span class="input-group-text bg-info b-0 text-white">Ate</span>
                                                            </div>
                                                            <input type="text" class="form-control" name="data_retorno" required data-validation-required-message="Preencha o campo" /> 

                                                        </div>
                                                    </div>

                                                </div>
                                            </div>

                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Destino </label>
                                                    <div class="controls">
                                                        <input type="text" name="prov_destino" class="form-control" required data-validation-required-message="Preencha o campo" placeholder="Especifice o seu destino..."> </div>

                                                </div>
                                            </div>


                                        </div>
                                        <div class="mb-2">
                                            <label class="custom-control custom-checkbox">
                                                <input name="motorista" type="checkbox" class="custom-control-input" value="Pedido de motorista">
                                                <span class="custom-control-label">Requisita com motorista</span>
                                            </label>
                                        </div> <br/>

                                        <div class="row">


                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Motivo da viagem</label>
                                                    <div class="controls">
                                                        <textarea name="motivo" class="form-control" rows="4" required data-validation-required-message="Preencha o campo"></textarea> </div>
                                                </div>
                                            </div>

                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Observacoes</label>
                                                    <div class="controls">
                                                        <textarea name="obs_req" class="form-control" rows="4" required data-validation-required-message="Preencha o campo"></textarea> </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="text-xs-right">
                                            <button type="submit" class="btn btn-info">Enviar</button>
                                            <button type="reset" class="btn btn-inverse">Cancel</button>
                                        </div>
                                    </form>
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
                <footer class="footer"> © 2018 Valdemiro Senda. O Programador </footer>
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
        <!-- ============================================================== -->
        <!-- All Jquery -->
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
            !function (window, document, $) {
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
        <script type="text/javascript"  src="resources/assets/plugins/styleswitcher/jQuery.style.switcher.js"></script>
    </body>


    <!-- Mirrored from wrappixel.com/demos/admin-templates/monster-admin/minimal/form-validation.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 06 Oct 2018 13:09:32 GMT -->
</html>
