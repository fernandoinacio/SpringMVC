<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="paginaErro.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@include  file="validar.jsp"%>
<!DOCTYPE html>
<html lang="pt-br">
    <!-- Mirrored from wrappixel.com/demos/admin-templates/monster-admin/minimal/table-footable.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 06 Oct 2018 13:10:43 GMT -->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- Tell the browser to be responsive to screen width -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- Favicon icon -->
        <link rel="icon" type="image/png" sizes="16x16" href="resources/assets/images/petroLG.png">
        <title>Sistema PV | Lista Viaturas </title>

        <link href="resources/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="resources/assets/plugins/datatables/media/css/dataTables.bootstrap4.css">
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
                    <!-- Column -->
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Disponibilidade de viaturas</h4>

                            <div class="alert alert-info alert-dismissible fade show" role="alert">
                                <strong>${mensagem}</strong>
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>

                            <div class="m-b-20">
                                <button type="button" class="btn btn-info" data-page-size="10">10</button>
                                <button type="button" class="btn btn-info" data-page-size="20">20</button>
                                <button type="button" class="btn btn-info" data-page-size="30">30</button>
                            </div>
                            <div class="table-responsive">
                                <table id="demo-foo-pagination" class="table table-bordered toggle-arrow-tiny" data-sorting="true" data-paging="true" data-paging-size="5">
                                    <thead>
                                        <tr>
                                            <th data-toggle="true"> Marca </th>
                                            <th> Modelo </th>
                                            <th data-hide="phone"> Tipo de Conbustivel</th>
                                            <th data-hide="all"> Nᵒ de Ocupantes </th>
                                            <th></th>
                                            <th></th>
                                        </tr>
                                        
                                    </thead>
                                    <tbody>
                                        <c:forEach var="lista" items="${lista}">
                                            <tr>
                                                <td>${lista.marca}</td>
                                                <td>${lista.modelo}</td>
                                                <td>${lista.tipo_combustivel}</td>
                                                <td>${lista.nr_assentos}</td>
                                                <td><a href="/SPVPetromoc/remover-viatura?id=${lista.cod_vt}">Remover</a></td>
                                                <td><a href="/SPVPetromoc/editar-viatura?id=${lista.cod_vt}">Editar</a></td>
                                            </tr>
                                        </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!-- Column -->

                    <!-- Start Popup Model -->
                    <!--  <div class="modal fade" id="editor-modal" tabindex="-1" role="dialog" aria-labelledby="editor-title">
                          <div class="modal-dialog" role="document">
                              <form class="modal-content form-horizontal" id="editor">
                                  <div class="modal-header">
                                      <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                                      <h4 class="modal-title" id="editor-title">Add Row</h4>
                                  </div>
                                  <div class="modal-body">
                                      <div class="form-group required">
                                          <label for="firstName" class="col-sm-3 control-label">First Name</label>
                                          <div class="col-sm-9">
                                              <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First Name" required>
                                          </div>
                                      </div>
                                      <div class="form-group required">
                                          <label for="lastName" class="col-sm-3 control-label">Last Name</label>
                                          <div class="col-sm-9">
                                              <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last Name" required>
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label for="jobTitle" class="col-sm-3 control-label">Job Title</label>
                                          <div class="col-sm-9">
                                              <input type="text" class="form-control" id="jobTitle" name="jobTitle" placeholder="Job Title">
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label for="dob" class="col-sm-3 control-label">Date of Birth</label>
                                          <div class="col-sm-9">
                                              <input type="date" class="form-control" id="dob" name="dob" placeholder="Date of Birth">
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label for="status" class="col-sm-3 control-label">Status</label>
                                          <div class="col-sm-9">
                                              <input type="text" class="form-control" id="status" name="status" placeholder="Status Here" required>
                                          </div>
                                      </div>
                                  </div>
                                  <div class="modal-footer">
                                      <button type="submit" class="btn btn-primary">Save changes</button>
                                      <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                                  </div>
                              </form>
                          </div>
                      </div> -->
                    <!-- End Popup Model -->
                </div>
            </div>
        </div>
    </div>
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
    <script src="resources/assets/plugins/moment/moment.js" type="text/javascript"></script>
    <script src="resources/assets/plugins/footable/js/footable.min.js"></script>
    <!--FooTable init-->
    <script src="resources/minimal/js/footable-init.js"></script>
    <!-- ============================================================== -->
    <!-- Style switcher -->
    <!-- ============================================================== -->
    <script src="resources/assets/plugins/styleswitcher/jQuery.style.switcher.js"></script>
</body>


<!-- Mirrored from wrappixel.com/demos/admin-templates/monster-admin/minimal/table-footable.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 06 Oct 2018 13:10:43 GMT -->
</html>
