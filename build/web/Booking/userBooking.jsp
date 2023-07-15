<%-- 
    Document   : user_profile
    Created on : Jun 11, 2023, 3:16:26 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>02_05_gallery</title>
        <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png" />
        <link rel="stylesheet" href="plugin/bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="plugin/bootstrap/css/bootstrap-theme.css">
        <link rel="stylesheet" href="fonts/poppins/poppins.css">
        <link rel="stylesheet" href="plugin/fonts/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="plugin/jquery-ui/jquery-ui.min.css">
        <link rel="stylesheet" href="plugin/process-bar/tox-progress.css">
        <link rel="stylesheet" href="plugin/owl-carouse/owl.carousel.min.css">
        <link rel="stylesheet" href="plugin/owl-carouse/owl.theme.default.min.css">
        <link rel="stylesheet" href="plugin/animsition/css/animate.css">
        <link rel="stylesheet" href="plugin/jquery-ui/jquery-ui.min.css">
        <link rel="stylesheet" href="plugin/mediaelement/mediaelementplayer.css">
        <link rel="stylesheet" href="plugin/datetimepicker/bootstrap-datepicker3.css">
        <link rel="stylesheet" href="plugin/datetimepicker/bootstrap-datetimepicker.min.css">
        <link rel="stylesheet" href="plugin/lightgallery/lightgallery.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css">

        <style>
            /* Custom CSS */
            .product-table {
                width: 100%;
            }

            .product-table th,
            .product-table td {
                padding: 8px;
                text-align: left;
                border-bottom: 1px solid #ddd;
            }

            .product-table th {
                background-color: #f2f2f2;
            }
        </style>

        <!-- Thêm liên kết Bootstrap CSS vào phần head của trang -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>

    <body>

        <!--load page-->
        <div class="load-page">
            <div class="sk-wave">
                <div class="sk-rect sk-rect1"></div>
                <div class="sk-rect sk-rect2"></div>
                <div class="sk-rect sk-rect3"></div>
                <div class="sk-rect sk-rect4"></div>
                <div class="sk-rect sk-rect5"></div>
            </div>
        </div>



        <!-- Mobile nav -->
        <nav class="visible-sm visible-xs mobile-menu-container mobile-nav">
            <div class="menu-mobile-nav navbar-toggle">
                <span class="icon-bar"><i class="fa fa-bars" aria-hidden="true"></i></span>
            </div>
            <div id="cssmenu" class="animated">
                <div class="uni-icons-close"><i class="fa fa-times" aria-hidden="true"></i></div>
                <ul class="nav navbar-nav animated">
                    <li><a href="index.jsp">Home</a></li>
                    <li class="has-sub"><a href='#'>List Vaccine</a>
                        <ul>
                            <li><a href="list_of_vaccine.html">List Vaccine</a></li>
                            <li><a href="detail_vaccine.html">Detail Vaccine</a></li>
                        </ul>
                    </li>
                    <li><a href="03_01_services.html">Booking Schedules</a></li>
                    <li class="has-sub"><a href="#">Departments</a>
                        <ul>
                            <li><a href="04_01_departments.html">Departments</a></li>
                            <li><a href="04_02_single_department.html">Single
                                    Departments</a></li>
                        </ul>
                    </li>
                    <li class="has-sub hover-element"><a href='#'>Shortcode</a></li>
                </ul>
                <div class="clearfix"></div>
            </div>
        </nav>
        <!-- End mobile menu -->

        <div class="uni-gallery">
            <div id="wrapper-container" class="site-wrapper-container">
                <header>
                    <div class="uni-medicare-header sticky-menu">
                        <div class="container">
                            <div class="uni-medicare-header-main">
                                <div class="row">
                                    <div class="col-md-2">
                                        <!--LOGO-->
                                        <div class="wrapper-logo">
                                            <a class="logo-default" href="#"><img src="images/logo.png" alt=""
                                                                                  class="img-responsive"></a>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div> 

                                    <div class="col-md-10">
                                        <!--MENU TEXT-->
                                        <div class="uni-main-menu">
                                            <nav class="main-navigation uni-menu-text">
                                                <div class="cssmenu">
                                                    <ul>
                                                        <li><a href="/Vaccine_testver1/newHome1.jsp">Home</a></li>
                                                        <li class="has-sub"><a href='#'>List Vaccine</a>
                                                            <ul>
                                                                <li><a href="list_of_vaccine.html">List Vaccine</a></li>
                                                                <li><a href="detail_vaccine.html">Detail Vaccine</a></li>
                                                            </ul>
                                                        </li>
                                                        <li><a href="03_01_services.html">Booking Schedules</a></li>
                                                        <li class="has-sub"><a href="#">Departments</a>
                                                            <ul>
                                                                <li><a href="04_01_departments.html">Departments</a></li>
                                                                <li><a href="04_02_single_department.html">Single
                                                                        Departments</a></li>
                                                            </ul>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </nav>
                                        </div>

                                        <!--SEARCH AND APPOINTMENT-->
                                        <div class="uni-search-appointment">
                                            <ul>
                                                <li class="un-btn-search">
                                                    <i class="fa fa-search" aria-hidden="true"></i>
                                                </li>
                                                <li class="uni-btn-appointment">
                                                    <a href="#">Appointment</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>

                                <!--FORM SEARCH-->
                                <div class="uni-form-search-header">
                                    <div class="box-search-header collapse" id="box-search-header">
                                        <div class="uni-input-group">
                                            <input type="text" name="key" placeholder="Search" class="form-control">
                                            <button class="uni-btn btn-search">
                                                <i class="fa fa-long-arrow-right" aria-hidden="true"></i>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </header>

                <div id="main-content" class="site-main-content">
                    <section class="site-content-area">

                        <div class="uni-banner-default uni-background-1">
                            <div class="container">
                                <!-- Page title -->
                                <div class="page-title">
                                    <div class="page-title-inner">
                                        <h1>user profile</h1>
                                    </div>
                                </div>
                                <!-- End page title -->
                            </div>
                        </div>

                        <!--profile  -->
                        <div class="uni-gallery-body">
                            <div class="container">
                                <section class="user-profile">
                                    <div class="container">
                                        <div class="row">
                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <div class="text-center">
                                                        <ul>
                                                            <li>
                                                                <img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png"
                                                                     class="avatar img-circle img-thumbnail" alt="avatar" />
                                                            </li>
                                                            <li class="bg-primary" style="margin: 12px; padding: 20px;">
                                                                <a href="/Vaccine_testver1/UserProfileController" style="color: white;">Overview</a>
                                                            </li>
                                                            <li class="bg-info" style="margin: 12px; padding: 20px; background-color: #337ab7;">
                                                                <a href="#2a" data-toggle="tab" style="color: white;">Booking history</a>
                                                            </li>
                                                        </ul>
                                                    </div>

                                                </div>
                                                <!--/col-3-->
                                                <div class="col-sm-9">
                                                    <div class="tab-content">
                                                        <div class="tab-content clearfix">
                                                            <div class="tab-pane active" id="1a">
                                                                <!--form change profile-->
                                                                <h3>Booking Schedule</h3>
                                                                <br><br>
                                                                <div class="table-responsive">
                                                                    <table class="table">
                                                                        <thead>
                                                                            <tr>
                                                                                <th>#</th>
                                                                                <th>Name</th>
                                                                                <th>Gender</th>
                                                                                <th>Vaccine Name</th>
                                                                                <th>Date</th>
                                                                                <th>Status</th>
                                                                                <th>Time</th>
                                                                                <th>Action</th>
                                                                            </tr>
                                                                        </thead>
                                                                        <tbody>
                                                                            <c:forEach items="${appointments}" var="appointment" varStatus="loop">
                                                                                <tr>
                                                                                    <td>${loop.index + 1}</td>
                                                                                    <td>${appointment.username}</td>
                                                                                    <td>
                                                                                        <c:choose>
                                                                                            <c:when test="${appointment.gender == '0'}">
                                                                                                Female
                                                                                            </c:when>
                                                                                            <c:otherwise>
                                                                                                Male
                                                                                            </c:otherwise>
                                                                                        </c:choose>
                                                                                    </td>
                                                                                    <td>${appointment.vaccineName}</td>
                                                                                    <td>${appointment.date}</td>
                                                                                    <td>Process</td>
                                                                                    <td><span>${appointment.startAt}</span> - ${appointment.endAt}</td>
                                                                                    <td>
                                                                                        <button class="btn btn-danger" onclick="showConfirmationPopup('${appointment.idAppointment}')">Delete ${appointment.idAppointment}</button>
                                                                                    </td>
                                                                                </tr>
                                                                            </c:forEach>
                                                                        </tbody>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                            <div class="tab-pane" id="2a">

                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>

                                                <!-- Confirmation Popup -->
                                                <div id="confirmationPopup" class="modal fade">
                                                    <div class="modal-dialog modal-dialog-centered">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h4 class="modal-title">Confirmation</h4>
                                                            </div>
                                                            <div class="modal-body">
                                                                <p>Are you sure you want to delete this item?</p>
                                                            </div>
                                                            <div class="modal-footer">
                                                                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                                                                <button id="confirmDelete" type="button" class="btn btn-danger">Confirm</button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>

                                                <!--                                                <input type="hidden" id="commentIdInput" />-->
                                                <!--/col-9-->
                                            </div>
                                            <!--/row-->
                                        </div>
                                    </div>
                                </section>
                            </div>
                        </div>



                    </section>
                </div>




                <!--change pass-->

                <div class="uni-gallery-body">
                    <div class="container">
                        <section class="user-profile">
                            <div class="container">
                                <div class="row">
                                    <div class="row">
                                        <div class="col-sm-3">


                                        </div>
                                        <!--/col-3-->
                                        <div class="col-sm-9">
                                            <div class="tab-content">
                                                <div class="tab-content clearfix">
                                                    <div class="tab-pane" id="1a">
                                                        <h3 class="my-4">Change Password</h3>

                                                        <div class="tab-pane active" id="2a">
                                                            <h3>We use the class nav-pills instead of nav-tabs which
                                                                automatically creates a background color for the tab
                                                            </h3>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!--/tab-content-->
                                            </div>
                                            <!--/col-9-->
                                        </div>
                                        <!--/row-->
                                    </div>
                                </div>
                        </section>
                    </div>
                </div>



                </section>
            </div>







            <!--footer-->

            <footer class="site-footer footer-default">
                <div class="footer-main-content">
                    <div class="container">
                        <div class="row">
                            <div class="footer-main-content-elements">
                                <div class="footer-main-content-element col-md-3 col-sm-6">
                                    <aside class="widget">
                                        <div class="widget-title uni-uppercase"><a href="#"><img
                                                    src="images/logowhite.png" alt="" class="img-responsive"></a></div>
                                        <div class="widget-content">
                                            <p>
                                                Pellentesque habitant morbi tristique senectus et netus et malesuada
                                                fame ac
                                                turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget.
                                            </p>
                                            <div class="uni-info-contact">
                                                <ul>
                                                    <li> <i class="fa fa-map-marker" aria-hidden="true"></i> 45 Queen's
                                                        Park Rd, Brighton, UK</li>
                                                    <li><i class="fa fa-phone" aria-hidden="true"></i> (094) 123 4567 -
                                                        (094) 123 4568</li>
                                                    <li><i class="fa fa-envelope-o" aria-hidden="true"></i>
                                                        medicareplus@domain.com</li>
                                                </ul>
                                            </div>
                                        </div>
                                    </aside>
                                </div>
                                <div class="footer-main-content-element col-md-3 col-sm-6">
                                    <aside class="widget">
                                        <h3 class="widget-title uni-uppercase">quick links</h3>
                                        <div class="widget-content">
                                            <div class="uni-quick-link">
                                                <ul>
                                                    <li><a href="#"><span>+</span> Home</a></li>
                                                    <li><a href="#"><span>+</span> about</a></li>
                                                    <li><a href="#"><span>+</span> services</a></li>
                                                    <li><a href="#"><span>+</span> timetable</a></li>
                                                    <li><a href="#"><span>+</span> blog</a></li>
                                                    <li><a href="#"><span>+</span> contact</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </aside>
                                </div>
                                <div class="footer-main-content-element col-md-3 col-sm-6">
                                    <aside class="widget">
                                        <h3 class="widget-title uni-uppercase">latest posts</h3>
                                        <div class="widget-content">
                                            <div class="uni-footer-latest-post">
                                                <ul>
                                                    <li>
                                                        <h4><a href="#">Lorem ipsum dolor sit amet, consectetuer</a>
                                                        </h4>
                                                        <span class="time">june 12, 2017</span>
                                                    </li>
                                                    <li>
                                                        <h4><a href="#">Aliquam tincidunt mauris eu risus amet</a></h4>
                                                        <span class="time">june 12, 2017</span>
                                                    </li>
                                                    <li>
                                                        <h4><a href="#">Morbi in sem quis dui placerat ornare column</a>
                                                        </h4>
                                                        <span class="time">june 12, 2017</span>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </aside>
                                </div>
                                <div class="footer-main-content-element col-md-3 col-sm-6">
                                    <aside class="widget">
                                        <h3 class="widget-title uni-uppercase">News<span>letter</span></h3>
                                        <div class="widget-content">
                                            <div class="uni-footer-newletter">
                                                <div class="input-group">
                                                    <input type="email" class="form-control"
                                                           placeholder="Enter your email">
                                                    <button class="btn btn-sub" type="submit">subscribe</button>
                                                </div>
                                                <div class="uni-social">
                                                    <h4>Follow us</h4>
                                                    <ul>
                                                        <li><a href="#"><i class="fa fa-facebook"
                                                                           aria-hidden="true"></i></a></li>
                                                        <li><a href="#"><i class="fa fa-twitter"
                                                                           aria-hidden="true"></i></a></li>
                                                        <li><a href="#"><i class="fa fa-google-plus"
                                                                           aria-hidden="true"></i></a></li>
                                                        <li><a href="#"><i class="fa fa-youtube-play"
                                                                           aria-hidden="true"></i></a></li>
                                                        <li><a href="#"><i class="fa fa-instagram"
                                                                           aria-hidden="true"></i></a></li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </aside>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="copyright-area">
                    <div class="container">
                        <div class="copyright-content">
                            <div class="row">
                                <div class="col-sm-6">
                                    <p class="copyright-text"><a href="templateshub.net">Templateshub</a></p>
                                </div>
                                <div class="col-sm-6">
                                    <ul class="copyright-menu">
                                        <li><a href="#">Term Of Use</a></li>
                                        <li><a href="#">Privacy Policy</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </footer>
        </div>
    <script src="path/to/jquery.sticky.js"></script>
    <script src="plugin/jquery/jquery-2.0.2.min.js"></script>
    <script src="plugin/jquery-ui/jquery-ui.min.js"></script>
    <script src="plugin/bootstrap/js/bootstrap.js"></script>
    <script src="plugin/process-bar/tox-progress.js"></script>
    <script src="plugin/waypoint/jquery.waypoints.min.js"></script>
    <script src="plugin/counterup/jquery.counterup.min.js"></script>
    <script src="plugin/owl-carouse/owl.carousel.min.js"></script>
    <script src="plugin/jquery-ui/jquery-ui.min.js"></script>
    <script src="plugin/mediaelement/mediaelement-and-player.js"></script>
    <script src="plugin/masonry/masonry.pkgd.min.js"></script>
    <script src="plugin/datetimepicker/moment.min.js"></script>
    <script src="plugin/datetimepicker/bootstrap-datepicker.min.js"></script>
    <script src="plugin/datetimepicker/bootstrap-datepicker.tr.min.js"></script>
    <script src="plugin/datetimepicker/bootstrap-datetimepicker.js"></script>
    <script src="plugin/datetimepicker/bootstrap-datetimepicker.fr.js"></script>

    <script src="plugin/lightgallery/picturefill.min.js"></script>
    <script src="plugin/lightgallery/lightgallery.js"></script>
    <script src="plugin/lightgallery/lg-pager.js"></script>
    <script src="plugin/lightgallery/lg-autoplay.js"></script>
    <script src="plugin/lightgallery/lg-fullscreen.js"></script>
    <script src="plugin/lightgallery/lg-zoom.js"></script>
    <script src="plugin/lightgallery/lg-hash.js"></script>
    <script src="plugin/lightgallery/lg-share.js"></script>
    <script src="plugin/sticky/jquery.sticky.js"></script>
    <script src="path/to/jquery.min.js"></script>
    <script src="path/to/sticky-library.js"></script>
    <script src="path/to/your-script.js"></script>

    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>   
    <script src="test.js"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script>
                                                                                            function showConfirmationPopup(a) {
                                                                                                    console.log(a)
                                                                                                    $("#confirmationPopup").modal("show");
                                                                                                }
                                                                                                
                                                                                        
                                                                                            $(document).ready(function () {
                                                                                                var appointmentIdToDelete = "";

                                                                                                // Xử lý sự kiện nhấp vào nút "Delete"
                                                                                                $(".btn-danger").click(function () {
                                                                                                    appointmentIdToDelete = $(this).data("appointment-id");
//                                                                                                    showConfirmationPopup();
                                                                                                });

                                                                                                // Xử lý sự kiện nhấp vào nút "Confirm" trong popup
                                                                                                $("#confirmDelete").click(function () {
                                                                                           
                                                                                                    deleteAppointment(appointmentIdToDelete);
                                                                                                    $("#confirmationPopup").modal("hide");
                                                                                                });

                                                                                                // Hàm hiển thị popup xác nhận
                                                                                                function showConfirmationPopup(a) {
                                                                                                    console.log(a)
                                                                                                    $("#confirmationPopup").modal("show");
                                                                                                }

                                                                                                // Hàm xóa appointment và gửi giá trị lên trang servlet
                                                                                                function deleteAppointment(appointmentId) {
                                                                                                    console.log(appointmentId); // In ra giá trị idAppointment
                                                                                                    $.ajax({
                                                                                                        url: "UserManagerController",
                                                                                                        type: "POST",
                                                                                                        data: {idAppointment: appointmentId},
                                                                                                        success: function (response) {
                                                                                                            console.log("Appointment deleted successfully");
                                                                                                            // Xử lý phản hồi từ servlet (nếu cần)
                                                                                                            toastr.success("Cancel this Appointment success.");
                                                                                                        },
                                                                                                        error: function (xhr, status, error) {
                                                                                                            console.error("Error sending appointment ID to servlet:", error);
                                                                                                            toastr.error("Can't cancel this Appointment.");
                                                                                                        }
                                                                                                    });
                                                                                                }
                                                                                            });
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
    <script src="js/main.js"></script>
</body>

</html>