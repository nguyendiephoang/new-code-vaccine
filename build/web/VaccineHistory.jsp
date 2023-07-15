
<%-- 
    Document   : History
    Created on : Jun 7, 2023, 10:40:25 PM
    Author     : HUNTER
FIXED
--%>


<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>History Vaccine</title>
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
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/pop-up.css">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/hospital.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"><link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    </head>

    <body>
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
                                                        <li><a href="newHome1.jsp">Home</a></li>
                                                        <li class="has-sub"><a href='#'>List Vaccine</a>
                                                            <ul>
                                                                <li><a href="list_of_vaccine.html">List Vaccine</a></li>
                                                                <li><a href="detail_vaccine.html">Detail Vaccine</a></li>
                                                            </ul>
                                                        </li>
                                                        <li><a href="03_01_services.html">Booking Schedules</a></li>
                                                        <li class="has-sub"><a href="#">Hospital</a>
                                                            <ul>
                                                                <li><a href="HospitalController ">List of hospital information</a></li>

                                                            </ul>
                                                        </li>

                                                    </ul>
                                                </div>
                                            </nav>
                                        </div>

                                        <!--Menu for user-->
                                        <div class="uni-search-appointment">
                                            <ul>
                                                <!--                                                <li class="un-btn-search">
                                                                                                    <i class="fa fa-search" aria-hidden="true"></i>
                                                                                                </li>-->
                                                <li class="uni-btn-appointment dropdown">
                                                    <a class="dropdown-toggle" href="#" role="button" id="user-dropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                        <i class="fas fa-user dropdown-icon"></i> Hello 
                                                    </a>
                                                    <div class="dropdown-menu" aria-labelledby="user-dropdown">
                                                        <a class="dropdown-item" href="UserProfileController"><i class="fas fa-user"></i> Profile</a>
                                                        <a class="dropdown-item" href="VaccineHistoryController"><i class="fas fa-history"></i> History</a>
                                                        <a class="dropdown-item" href="#"><i class="fas fa-cog"></i> Settings</a>
                                                        <a class="dropdown-item" href="logoutController"><i class="fas fa-sign-out-alt"></i> Logout</a>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>

                                <!--FORM SEARCH-->
                                <!--                                <div class="uni-form-search-header">
                                                                    <div class="box-search-header collapse" id="box-search-header">
                                                                        <div class="uni-input-group">
                                                                            <input type="text" name="key" placeholder="Search" class="form-control">
                                                                            <button class="uni-btn btn-search">
                                                                                <i class="fa fa-long-arrow-right" aria-hidden="true"></i>
                                                                            </button>
                                                                        </div>
                                                                    </div>
                                                                </div>-->
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
                                        <h1>History Vaccine</h1>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- HTML code and product table -->
                        <div class="uni-gallery-body">
                            <div class="container">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered">
                                        <thead class="thead-dark">
                                            <tr>

                                                <th>Username</th>
                                                <th>Gender</th>
                                                <th>Hospital</th>
                                                <th>Date</th>
                                                <th>Vaccine</th>
                                                <th>Price</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${History}" var="history">
                                                <tr>
                                                    <td>${history.userName}</td>
                                                    <td>
                                                        <c:choose>
                                                            <c:when test="${history.gender eq 'false'}">Male</c:when>
                                                            <c:when test="${history.gender eq 'true'}">Female</c:when>
                                                            <c:otherwise>Unknown</c:otherwise>
                                                        </c:choose>
                                                    </td>
                                                    <td>${history.nameVaccine}</td>
                                                    <td>${history.date}</td>
                                                    <td>${history.nameHospital}</td>
                                                    <td>${history.price}</td>
                                                </tr>
                                            </c:forEach>


                                            <!-- Add more rows as needed -->
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        
                        
                        
                    </section>
                </div>

                </section>
            </div>


        </div>
        <footer class="site-footer footer-default ">
            <div class="footer-main-content">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-6">
                            <aside class="widget">
                                <h3 class="widget-title uni-uppercase">CONTACT</h3>
                                <div class="widget-content">
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


                        <div class="col-sm-6">
                            <aside class="widget">
                                <h3 class="widget-title uni-uppercase">Introduction</h3>
                                <div class="widget-content">
                                    <div class="uni-info-contact">
                                        <p>Our website provides vaccination services from many hospitals across the country.
                                        </p>
                                    </div>
                                </div>
                            </aside>
                        </div>


                    </div>
                </div>
            </div>

        </footer>






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

        <script src="js/main.js"></script>
        <script src="js/script.js"></script>
    </body>

</html>