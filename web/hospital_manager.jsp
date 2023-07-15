<%@page import="model.Hospital"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <jsp:useBean id ="h" class="dal.HospitalDAO" scope ="session"></jsp:useBean>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
            <title>Document</title>


            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
            <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
            <!-- Nạp các tệp JavaScript của jQuery, Popper.js và Bootstrap -->
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
            <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
            <link rel="stylesheet" href="css/bootstrap-4.0.0-dist/css/bootstrap.min.css">
            <!----css3---->
            <link rel="stylesheet" href="css/custom.css">


            <!--google fonts -->

            <link rel="preconnect" href="https://fonts.googleapis.com">
            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
            <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">


            <!--google material icon-->
            <link href="https://fonts.googleapis.com/css2?family=Material+Icons" rel="stylesheet">


        </head>

        <style>
            body {
                padding-top: 0px; /* Khoảng cách giữa header và nội dung trang */
            }
            .fixed-top {
                position: fixed;
                top: 0;
                width: 100%;
            }

            td, th {
                padding: 0;
                width: 100px;
            }

            .editprofile .modal-body {
                padding-bottom: 0px;
                padding-left: 0px;
                padding-right: 0px;

            }
            .editprofile .modal-body .container.row {
                padding-left: 35px;
            }



            .editprofile .modal-footer{
                margin-top: 25px
            }
            .editprofile .modal-content{
                width: 200%;
                margin-left: -50%;
                position: absolute;

            }




            body {
                color: #566787;
                background: #f5f5f5;
                font-family: 'Varela Round', sans-serif;
                font-size: 13px;
            }
            .table-wrapper {
                background: #fff;
                padding: 20px 25px;
                margin: 30px 0;
                border-radius: 3px;
                box-shadow: 0 1px 1px rgba(0,0,0,.05);
            }
            .table-title {
                padding-bottom: 15px;
                background: #435d7d;
                color: #fff;
                padding: 16px 30px;
                margin: -20px -25px 10px;
                border-radius: 3px 3px 0 0;
            }
            .table-title h2 {
                margin: 5px 0 0;
                font-size: 24px;
            }
            .table-title .btn-group {
                float: right;
            }
            .table-title .btn {
                color: #fff;
                float: right;
                font-size: 13px;
                border: none;
                min-width: 50px;
                border-radius: 2px;
                border: none;
                outline: none !important;
                margin-left: 10px;
            }
            .table-title .btn i {
                float: left;
                font-size: 21px;
                margin-right: 5px;
            }
            .table-title .btn span {
                float: left;
                margin-top: 2px;
            }
            table.table tr th, table.table tr td {
                border-color: #e9e9e9;
                padding: 12px 15px;
                vertical-align: middle;
            }
            table.table tr th:first-child {
                width: 60px;
            }
            table.table tr th:last-child {
                width: 100px;
            }
            table.table-striped tbody tr:nth-of-type(odd) {
                background-color: #fcfcfc;
            }
            table.table-striped.table-hover tbody tr:hover {
                background: #f5f5f5;
            }
            table.table th i {
                font-size: 13px;
                margin: 0 5px;
                cursor: pointer;
            }
            table.table td:last-child i {
                opacity: 0.9;
                font-size: 22px;
                margin: 0 5px;
            }
            table.table td a {
                font-weight: bold;
                color: #566787;
                display: inline-block;
                text-decoration: none;
                outline: none !important;
            }
            table.table td a:hover {
                color: #2196F3;
            }
            table.table td a.edit {
                color: #FFC107;
            }
            table.table td a.delete {
                color: #F44336;
            }
            table.table td i {
                font-size: 19px;
            }





            /* Modal styles */

            /*            .modal .modal-header, .modal .modal-body, .modal .modal-footer {
                            padding: 20px 30px;
                        }*/
            .modal .modal-content {
                border-radius: 3px;
            }
            .modal .modal-footer {
                background: #ecf0f1;
                border-radius: 0 0 3px 3px;
            }
            .modal .modal-title {
                display: inline-block;
            }
            .modal .form-control {
                border-radius: 2px;
                box-shadow: none;
                border-color: #dddddd;
            }
            .modal textarea.form-control {
                resize: vertical;
            }
            .modal .btn {
                border-radius: 2px;
                min-width: 100px;
            }
            .modal form label {
                font-weight: normal;
            }


            /*vaccine*/
            /* Tùy chỉnh độ rộng của cột "Detail Vaccine" */
            .detail-column {
                width: 30%;
            }

            /* Ẩn nội dung dài */
            .detail-content.collapsed {
                height: 50px; /* Chiều cao khởi tạo */
                overflow: hidden;
            }

            /* Hiển thị nút "Hiển thị" và "Ẩn" */
            .toggle-button {
                cursor: pointer;
                color: blue;
                text-decoration: underline;
            }
            footer.footer {
                margin-top: 16%;
            }

        </style>


        <body>

        <c:set var="page" value="${param.page}" scope="session"/>
        <c:if test="${page<=0}">
            <c:set var="page" value="1" scope="session"/>
        </c:if>
        <c:if test="${page==null}">
            <c:set var="page" value="1" scope="session"/>
        </c:if>
        <c:if test="${not empty page}">
            <c:set var="page" value="${page}" scope="session"/>
        </c:if>
        <fmt:formatNumber type="number" var="maxpage" value="${Math.ceil(h.allHospital.size()/2)}">

        </fmt:formatNumber>
        <c:if test="${page>=maxpage}">
            <c:set var="page" value="${maxpage}" scope="session"/>
        </c:if>



        <div class="wrapper">


            <div class="body-overlay"></div>

            <!-------------------------sidebar------------>
            <!-- Sidebar  -->
            <nav id="sidebar">
                <div class="sidebar-header">
                    <h3><img src="images/logo.png" class="img-fluid" style="width:100px; border-radius:50%;" /></h3>
                </div>
                <ul class="list-unstyled components">
                    <li >
                        <a href="#" class="dashboard"><i class="material-icons">dashboard</i>
                            <span>Admin</span></a>
                    </li>



                    <li class="">
                        <a href="AdminManagerVaccine.jsp" ><i class="material-icons">date_range</i><span>Vaccine Manager</span></a>
                    </li>
                    <li class="active">
                        <a href="hospital_manager.jsp" ><i class="material-icons">date_range</i><span>Hospital Manager</span></a>
                    </li>
                    <li class="">
                        <a href="user_manager.jsp"><i class="material-icons">date_range</i><span>User Manager</span></a>
                    </li>

                    <li class="">
                        <a href="#" class="nav-link"><i class="material-icons">library_books</i><span>Calender
                            </span></a>
                    </li>


                </ul>


            </nav>




            <!--------page-content---------------->

            <div id="content">

                <!--top--navbar----design--------->

                <div class="top-navbar">
                    <div class="xp-topbar">

                        <!-- Start XP Row -->
                        <div class="row">
                            <!-- Start XP Col -->
                            <div class="col-2 col-md-1 col-lg-1 order-2 order-md-1 align-self-center">
                                <div class="xp-menubar">
                                    <span class="material-icons text-white">signal_cellular_alt
                                    </span>
                                </div>
                            </div>
                            <!-- End XP Col -->

                            <!-- Start XP Col -->
                            <div class="col-md-5 col-lg-3 order-3 order-md-2">
                                <div class="xp-searchbar">
                                    <form>
                                        <div class="input-group">
                                            <input type="search" class="form-control" placeholder="Search">
                                            <div class="input-group-append">
                                                <button class="btn" type="submit" id="button-addon2">GO</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <!-- End XP Col -->

                            <!-- Start XP Col -->
                            <div class="col-10 col-md-6 col-lg-8 order-1 order-md-3">
                                <div class="xp-profilebar text-right">
                                    <nav class="navbar p-0">
                                        <ul class="nav navbar-nav flex-row ml-auto">
                                            <li class="dropdown nav-item active">
                                                <a href="#" class="nav-link" data-toggle="dropdown">
                                                    <span class="material-icons">notifications</span>
                                                    <span class="notification">4</span>
                                                </a>
                                                <ul class="dropdown-menu">
                                                    <li>
                                                        <a href="#">You have 5 new messages</a>
                                                    </li>
                                                    <li>
                                                        <a href="#">You're now friend with Mike</a>
                                                    </li>
                                                    <li>
                                                        <a href="#">Wish Mary on her birthday!</a>
                                                    </li>
                                                    <li>
                                                        <a href="#">5 warnings in Server Console</a>
                                                    </li>

                                                </ul>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="#">
                                                    <span class="material-icons">question_answer</span>

                                                </a>
                                            </li>
                                            <li class="nav-item dropdown">
                                                <a class="nav-link" href="#" data-toggle="dropdown">
                                                    <img src="images/user_admin.jpg" style="width:40px; border-radius:50%;" />
                                                    <span class="xp-user-live"></span>
                                                </a>
                                                <ul class="dropdown-menu small-menu">
                                                    <li>
                                                        <a href="#">
                                                            <span class="material-icons">
                                                                person_outline
                                                            </span>Profile

                                                        </a>
                                                    </li>
                                                    <li>
                                                        <a href="#"><span class="material-icons">
                                                                settings
                                                            </span>Settings</a>
                                                    </li>
                                                    <li>
                                                        <a href="logoutController"><span class="material-icons">
                                                                logout</span>Logout</a>
                                                    </li>
                                                </ul>
                                            </li>
                                        </ul>


                                    </nav>

                                </div>
                            </div>
                            <!-- End XP Col -->

                        </div>
                        <!-- End XP Row -->

                    </div>
                    <div class="xp-breadcrumbbar text-center">
                        <h4 class="page-title">Manage Hospital</h4>

                    </div>

                </div>












                <div class="container">


                    <div class="table-wrapper">
                        <div class="table-title">
                            <div class="row">
                                <div class="col-sm-6">
                                    <h2>Manage <b>Hospital</b></h2>
                                </div>
                                <div class="col-sm-6">

                                    <!--                            <a href="AddVaccine.jsp "  class="btn btn-primary edit-btn"><i class="material-icons">&#xE147;</i><span>Add Vaccine</span></a> -->
                                    <!--                            <a href="#" class="btn btn-primary edit-btn" data-toggle="modal" data-target="#addVaccineModal"><i class="material-icons">&#xE147;</i><span>Add Vaccine</span></a>-->
                                    <a href="#" class="btn btn-primary edit-btn" data-toggle="modal" data-target="#addModal">
                                        <i class="material-icons">&#xE147;</i>
                                        <span>Add Hospital</span>
                                    </a>

                                </div>
                            </div>
                        </div>       


                        <!--add hospital-->

                        <div class="modal fade editprofile" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel"
                             aria-hidden="true">
                            <div class="modal-dialog modal-lg" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="editModalLabel">Add Hospital</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <!--form chỉnh sửa-->
                                        <form class="form" action="AddHospitalByAdminController" method="post"
                                              id="infor">
                                            <div class="container row">
                                                <div class="col-sm-6">
                                                    <label for="first_name">
                                                        <h6>Hospital name</h6>                                                   
                                                    </label>
                                                    <input required type="text" class="form-control"
                                                           name="name" id="first_name"
                                                           placeholder="Enter name"
                                                           />
                                                </div>
                                                <div class="col-sm-6">
                                                    <label for="email">
                                                        <h6>Email</h6>
                                                    </label>
                                                    <input required type="email" class="form-control"
                                                           name="email" id="email"
                                                           placeholder="Enter email address"
                                                           pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" 
                                                           title="Wrong format email"
                                                           />
                                                </div>

                                                <div class="col-sm-6">
                                                    <label for="hotline">
                                                        <h6>Hotline</h6>
                                                    </label>
                                                    <input pattern="[0-9]{10}" type="tel" class="form-control"
                                                           name="hotline" placeholder="Enter hotline number" 
                                                           required title="Wrong hotline number" />
                                                </div>


                                                <div class="col-sm-6">
                                                    <label for="address">
                                                        <h6>Address</h6>
                                                    </label>
                                                    <input required type="text" class="form-control"
                                                           id="location" name="address"
                                                           placeholder="Enter address" 
                                                           />

                                                </div>   
                                                <div class="col-sm-6">
                                                    <label >
                                                        <h6>Password</h6>
                                                    </label>
                                                    <input required type="password" class="form-control"
                                                           id="location" name="pass"
                                                           placeholder="Enter password" 
                                                           />

                                                </div>  
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                <button type="submit" class="btn btn-primary save-button">Save changes</button>
                                            </div>
                                        </form>
                                    </div> 
                                </div>
                            </div>
                        </div>







                        <!--add hospital-->

                        <%
                            if (session.getAttribute("addinforsucess") != null) {
                        %>
                        <script>
                            alert("<%= session.getAttribute("addinforsucess")%>");
                        </script>
                        <%
                                // Xóa session để không hiển thị lại khi người dùng tải lại trang
                                session.removeAttribute("addinforsucess");
                            }
                        %>   

                        <!--email exist-->
                        <%
                            if (session.getAttribute("existEmail") != null) {
                        %>
                        <script>
                            alert("<%= session.getAttribute("existEmail")%>");
                        </script>
                        <%
                                // Xóa session để không hiển thị lại khi người dùng tải lại trang
                                session.removeAttribute("existEmail");
                            }
                        %> 



                        <!--hotline exist-->
                        <%
                            if (session.getAttribute("existhotline") != null) {
                        %>
                        <script>
                            alert("<%= session.getAttribute("existhotline")%>");
                        </script>
                        <%
                                // Xóa session để không hiển thị lại khi người dùng tải lại trang
                                session.removeAttribute("existhotline");
                            }
                        %> 

                        <!--update infor-->
                        <%
                            if (session.getAttribute("updateinforsucess") != null) {
                        %>
                        <script>
                            alert("<%= session.getAttribute("updateinforsucess")%>");
                        </script>
                        <%
                                // Xóa session để không hiển thị lại khi người dùng tải lại trang
                                session.removeAttribute("updateinforsucess");
                            }
                        %>     

                        <!--delete infor-->

                        <%
                            if (session.getAttribute("delete") != null) {
                        %>
                        <script>
                            alert("<%= session.getAttribute("delete")%>");
                        </script>
                        <%
                                // Xóa session để không hiển thị lại khi người dùng tải lại trang
                                session.removeAttribute("delete");
                            }
                        %>     

                        <!--reset pass-->
                        <%
                            if (session.getAttribute("resetPass") != null) {
                        %>
                        <script>
                            alert("<%= session.getAttribute("resetPass")%>");
                        </script>
                        <%
                                // Xóa session để không hiển thị lại khi người dùng tải lại trang
                                session.removeAttribute("resetPass");
                            }
                        %>  

                        <div id="product-manager " class="container " >
                            <table class="table table-striped table-hover ">
                                <thead>
                                    <tr>
                                        <th>Serial</th>
                                        <th>ID</th>
                                        <th>Hospital Name</th>
                                        <th>Address</th>
                                        <th>Email</th>
                                        <th>Hotline</th>
                                        <th> Action</th>  
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${h.allHospital}" var = "i" begin="${(page-1)*10}" end="${page*10-1}" varStatus="loop">     
                                        <tr>
                                            <td>${loop.index + 1}</td>
                                            <td>${i.idBV}</td>
                                            <td>${i.name}</td>
                                            <td>${i.address}</td>
                                            <td>${i.email}</td>
                                            <td> ${i.hotline}</td>

                                            <td style="display: flex; flex-direction: row" >  
                                                <a href="#" class=" edit-btn" data-toggle="modal" data-target="#editModal${i.idBV}" >
                                                    <i class="material-icons"  title="Edit">&#xE147;</i>
                                                </a>
                                                <a href="#" class="delete" data-bs-toggle="modal" data-bs-target="#exampleModal${i.idBV}"><i class="material-icons" title="Delete">&#xE872;</i></a>
                                                <a href="#" style="color: blue" data-bs-toggle="modal" data-bs-target="#resetPass${i.idBV}"><i class="material-icons" title="Reset Password">&#xeade;  </i></a>
                                            </td>
                                        </tr>


                                        <!--reset Pass-->


                                    <div class="modal fade" id="resetPass${i.idBV}" tabindex="-1" role="dialog"
                                         aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog ">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h4 class="modal-title" id="exampleModalLabel"><i class="bi bi-trash-fill"></i>
                                                        Reset password</h4>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                            aria-label="Close">&times;</button>
                                                </div>
                                                <div class="modal-body">
                                                    <h6>Are you sure to reset password this User?</h6>
                                                </div>
                                                <div class="modal-footer">
                                                    <form action="ResetPasswordHospitalByAdminController" method="Post">
                                                        <input type="search" value="${i.idBV}" name="idUser" hidden>
                                                        <input type="search" value="${i.email}" name="email" hidden>
                                                        <!-- <input type="search" value="w" name="pid" hidden> -->
                                                        <button type="submit" class="btn btn-primary">Yes</button>
                                                        <button type="button" class="btn btn-secondary"
                                                                data-bs-dismiss="modal">No</button>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>


                                    <!--delete-->



                                    <div class="modal fade" id="exampleModal${i.idBV}" tabindex="-1" role="dialog"
                                         aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h4 class="modal-title" id="exampleModalLabel"><i class="bi bi-trash-fill"></i>
                                                        Delete</h4>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                            aria-label="Close">&times;</button>
                                                </div>
                                                <div class="modal-body">
                                                    <h6> Are you sure to delete this Hospital?</h6>
                                                </div>
                                                <div class="modal-footer">
                                                    <form action="DeleteHospitalByAdminController" method="Post">
                                                        <input type="search" value="${i.idBV}" name="idBV" hidden>
                                                        <!-- <input type="search" value="w" name="pid" hidden> -->
                                                        <button type="submit" class="btn btn-primary">Yes</button>
                                                        <button type="button" class="btn btn-secondary"
                                                                data-bs-dismiss="modal">No</button>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <!--edit-->

                                    <div class="modal fade editprofile" id="editModal${i.idBV}" tabindex="-1" role="dialog" aria-labelledby="editModalLabel"
                                         aria-hidden="true">
                                        <div class="modal-dialog modal-lg" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="editModalLabel">Edit Hospital</h5>
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body">
                                                    <!--form chỉnh sửa-->
                                                    <form class="form" action="UpdateHospitalByAdminController" method="post"
                                                          id="infor">
                                                        <input type="search" value="${i.idBV}" name="idBV" hidden>
                                                        <div class="container row">

                                                            <div class="col-sm-6">
                                                                <label for="first_name">
                                                                    <h5>Hospital name</h5>
                                                                </label>

                                                                <input required type="text" class="form-control"
                                                                       name="name" id="first_name"
                                                                       value="${i.name}" />
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <label for="email">
                                                                    <h5>Email</h5>
                                                                </label>
                                                                <input required type="email" class="form-control"
                                                                       name="email" id="email"
                                                                       value="${i.email}"/>
                                                            </div>

                                                            <div class="col-sm-6">
                                                                <label for="hotline">
                                                                    <h5>Hotline</h5>
                                                                </label>
                                                                <input required type="tel" pattern="[0-9]{10}"class="form-control"
                                                                       name="hotline" id="mobile"
                                                                       value="${i.hotline}" title="Wrong hotline number" />
                                                            </div>


                                                            <div class="col-sm-6">
                                                                <label for="address">
                                                                    <h5>Address</h5>
                                                                </label>
                                                                <input required type="text" class="form-control"
                                                                       id="location" name="address"
                                                                       value="${i.address}"/>

                                                            </div>                                                  
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                            <button type="submit" class="btn btn-primary save-button">Save changes</button>
                                                        </div>
                                                    </form>
                                                </div> 
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                                </tbody>
                            </table>                 
                        </div>
                    </div>

                    <ul class="pagination">
                        <li class="page-item disabled"><a href="hospital_manager.jsp?page=1">Previous</a></li>
                        <li class="page-item"><a href="hospital_manager.jsp?page=${page-1}" class="page-link">${page-1}</a></li>
                        <li class="page-item active"><a href="#" class="page-link"><c:out value="${page}"/></a>
                        <li class="page-item"><a href="hospital_manager.jsp?page=${page+1}" class="page-link">${page+1}</a></li>
                        <li class="page-item"><a href="hospital_manager.jsp?page=${maxpage}">Next</li>

                    </ul>
                </div>

                <!--footer-->
                <footer class="footer">
                    <div class="container-fluid">
                        <div class="footer-in">
                            <p class="mb-0">&copy 2020 Vishweb design - All Rights Reserved.</p>
                        </div>
                    </div>
                </footer>









                <script src="assets/js/managerjs.js"></script>
                <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
                <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
                <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

                </body>

                </html> 