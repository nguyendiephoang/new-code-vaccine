<%-- 
    Document   : ManagerProduct
    Created on : Dec 28, 2020, 5:19:02 PM
    FIXED
--%>
<%@page import="model.Vaccine"%>
<jsp:useBean id ="v" class="dal.VaccineDAO" scope ="session"></jsp:useBean>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Manager Vaccine By Admin</title>

        <link href="css/adminManager.css" rel="stylesheet" type="text/css"/>


        <!-- Nạp các tệp CSS của Bootstrap và Material Icons -->
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

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
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
            width: 10px;
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
            width: 60%;
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
        <fmt:formatNumber type="number" var="maxpage" value="${Math.ceil(v.allVaccine.size()/2)}">

        </fmt:formatNumber>
        <c:if test="${page>=maxpage}">
            <c:set var="page" value="${maxpage}" scope="session"/>
        </c:if>

        <!--        ----------------------------------Header----------------------------------->


        <!--------------------------------table CRUD----------------------------------->


        <div class="wrapper">


            <div class="body-overlay"></div>

            <!-------------------------sidebar------------>
            <!-- Sidebar  -->
            <nav id="sidebar">
                <div class="sidebar-header">
                    <h3><img src="images/logo.png" class="img-fluid" style="width:100px; border-radius:50%;" /></h3>
                </div>
                <ul class="list-unstyled components">
                    <li>
                        <a href="#" class="dashboard"><i class="material-icons">dashboard</i>
                            <span>Admin</span></a>
                    </li>



                    <li class="active">
                        <a href="AdminManagerVaccine.jsp" ><i class="material-icons">date_range</i><span>Vaccine Manager</span></a>
                    </li>
                    <li class="">
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


                            <div class="col-12 col-md- col-lg-12 order-1 order-md-3">
                                <div class="xp-profilebar text-right">
                                    <nav class="navbar p-0">
                                        <ul class="nav navbar-nav flex-row ml-auto">

                                            <li class="nav-item dropdown">
                                                <a class="nav-link" href="#" data-toggle="dropdown">
                                                    <i class="fas fa-user dropdown-icon"></i>

                                                </a>
                                                <ul class="dropdown-menu small-menu">

                                                  
                                                    <li>
                                                        <a href="logoutController">
                                                            <span class="material-icons">
                                                                logout</span>Logout</a>
                                                    </li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </nav>
                                </div>
                            </div>    



                        </div>    
                        <!-- End XP Row -->

                    </div>


                </div>




                <div class="container">

                    <div class="table-wrapper">
                        <div class="table-title">
                            <div class="row">
                                <div class="col-sm-6">
                                    <h2>Manage <b>Vaccine</b></h2>
                                </div>
                                <div class="col-sm-6">

                                    <!--                            <a href="AddVaccine.jsp "  class="btn btn-primary edit-btn"><i class="material-icons">&#xE147;</i><span>Add Vaccine</span></a> -->
                                    <!--                            <a href="#" class="btn btn-primary edit-btn" data-toggle="modal" data-target="#addVaccineModal"><i class="material-icons">&#xE147;</i><span>Add Vaccine</span></a>-->
                                    <a href="#" class="btn btn-primary edit-btn" data-toggle="modal" data-target="#addVaccineModal" onclick="openAddVaccineModal(event)">
                                        <i class="material-icons">&#xE147;</i>
                                        <span>Add Vaccine</span>
                                    </a>

                                </div>
                            </div>
                        </div>
                        <table class="table table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Id Vaccine</th>
                                    <th>Name Vaccine</th>
                                    <th>Detail Vaccine</th>                                 
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${v.allVaccine}" var = "o"  begin="${(page-1)*10}" end="${page*10-1}" varStatus="loop">     
                                    <tr>
                                        <td>${loop.index + 1}</td>
                                        <td>${o.idVaccine}</td>                      
                                        <td>${o.name}</td>
                                        <td>
                                            <div class="detail-content collapsed">
                                                ${o.detail}
                                            </div>
                                            <div class="toggle-button">Show</div>
                                        </td>                                                                           
                                        <td>

                                            <a href="#" data-toggle="modal" data-target="#editVaccineModal${o.idVaccine}" class="edit" ><i class="material-icons">&#xE254;</i></a>
<!--                                            <a href=#" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip"  onclick="showMess()"title="Delete">&#xE872;</i></a>-->

                                        </td>
                                    </tr>


                                    <!-- Edit Vaccine Modal -->
                                <div id="editVaccineModal${o.idVaccine}" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="editVaccineModalLabel"
                                     aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <form action="edit" method="get">
                                                <div class="modal-header">
                                                    <h4 class="modal-title" id="editVaccineModalLabel">Edit Vaccine</h4>
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>



                                                <div class="modal-body">
                                                    <div class="form-group">
                                                        <label for="edit-id">ID</label>
                                                        <input id="edit-id" value="${o.idVaccine}"  name="idVaccine" type="text" class="form-control" readonly required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="edit-name">Name</label>
                                                        <input id="edit-name" value="${o.name}"   name="name" type="text" class="form-control" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Detail vaccine</label>
                                                        <textarea  " name="detail" type="text" class="form-control" required>${o.detail} </textarea>
                                                    </div>




                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                    <input type="submit" class="btn btn-primary" value="Save changes">
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>

                                <!-- Add Vaccine Modal -->
                                <div id="addVaccineModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="addVaccineModalLabel"
                                     aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <form action="add" method="post">
                                                <div class="modal-header">
                                                    <h4 class="modal-title" id="addVaccineModalLabel">Add Vaccine</h4>
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body">

                                                    <div class="form-group">
                                                        <label for="add-name">Name</label>
                                                        <input id="add-name" name="name" type="text" class="form-control" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="add-detail">Detail vaccine</label>
                                                        <textarea id="add-detail" name="detail" class="form-control" required></textarea>
                                                    </div>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                    <input type="submit" class="btn btn-success" value="Add">
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>

                            </c:forEach>


                            </tbody>
                        </table>

                    </div>





                    <!-- Page -->
                    <ul class="pagination">
                        <li class="page-item disabled"><a href="AdminManagerVaccine.jsp?page=1">Previous</a></li>
                        <li class="page-item"><a href="AdminManagerVaccine.jsp?page=${page-1}" class="page-link">${page}</a></li>
                        <li class="page-item active"><a href="#" class="page-link"><c:out value="${page+1}"/></a>
                        <li class="page-item"><a href="AdminManagerVaccine.jsp?page=${page+1}" class="page-link">${page+2}</a></li>
                        <li class="page-item"><a href="AdminManagerVaccine.jsp?page=${maxpage}">Next</li>

                    </ul>

                </div>



                <script>
                    function  showMess(idVaccine) {
                        var option = confirm(' Are you sure want to delete this Vaccine');
                        if (option === true) {
                            window.location.href = 'delete?idVaccine=' + idVaccine;
                        }
                    }




                </script>


                <script>
                    $(document).ready(function () {
                        $('.toggle-button').click(function () {
                            var detailContent = $(this).prev('.detail-content');
                            detailContent.toggleClass('collapsed');
                            $(this).text(detailContent.hasClass('collapsed') ? 'Show' : 'Hide');
                        });
                    });
                </script>


                <!--        <script>
                            function openAddVaccineModal(event) {
                                event.preventDefault(); // Ngăn chặn hành vi mặc định khi nhấp vào liên kết
                
                             
                
                                // Kiểm tra nếu có thông báo lỗi
                                if (error) {
                                    // Hiển thị thông báo lỗi bằng alert
                                    alert(error);
                                } else {
                                    // Đóng modal nếu không có lỗi
                                    $('#addVaccineModal').modal('hide');
                                }
                            }
                        </script>-->
                <!--add hospital-->
                <%
                    if (session.getAttribute("existVaccine") != null) {
                %>
                <script>
                    alert("<%= session.getAttribute("existVaccine")%>");
                </script>
                <%
                        // Xóa session để không hiển thị lại khi người dùng tải lại trang
                        session.removeAttribute("existVaccine");
                    }
                %> 




                <!--add vaccine-->

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

                <script src="assets/js/managerjs.js"></script>
                <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
                <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
                <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>




                </body>
                </html>