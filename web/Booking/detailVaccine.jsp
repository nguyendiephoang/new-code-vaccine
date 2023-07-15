<%-- 
    Document   : detailVaccine
    Created on : May 22, 2023, 11:42:26 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<!doctype html>
<html lang="en">

    <!-- 06_02_single_product.html  [XR&CO'2014], Tue, 22 Oct 2019 11:56:12 GMT -->

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>06_02_single_product</title>
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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css">
        <style>
            .card {
                margin: 20px;
                padding: 20px;
                border: 1px solid #ccc;
            }

            h2 {
                margin-bottom: 20px;
            }

            .list-group-item {
                margin-bottom: 10px;
                padding: 10px;
                border: 1px solid #ccc;
            }

            .comment-header {
                display: flex;
                align-items: center;
                justify-content: space-between;
                margin-bottom: 5px;
            }

            .comment-user {
                font-weight: bold;
            }

            .comment-date {
                color: #999;
            }

            .comment-text {
                margin-bottom: 10px;
            }

            .comment-delete-btn {
                background-color: #dc3545;
                color: #fff;
                border: none;
                padding: 5px 10px;
                cursor: pointer;
            }

            .form-group {
                margin-bottom: 20px;
            }

            label {
                display: block;
                font-weight: bold;
            }

            textarea {
                width: 100%;
                height: 100px;
            }

            #submit-comment {
                margin-top: 10px;
            }

        </style>
    </head>

    <body>

        <%@include file="header.jsp"%>

        <div id="main-content" class="site-main-content">
            <div class="site-content-area">

                <div class="uni-banner-default uni-background-1">
                    <div class="container">
                        <!-- Page title -->
                        <div class="page-title">
                            <div class="page-title-inner">
                                <h1>Redufluxes</h1>
                            </div>
                        </div>
                        <!-- End page title -->

                        <!-- Breadcrumbs -->
                        <ul class="breadcrumbs">
                            <li><a href="#">home</a></li>
                            <li><a href="#">Detail</a></li>
                        </ul>
                        <!-- End breadcrumbs -->
                    </div>
                </div>

                <div  class="uni-services-body">
                    <main id="main" class="site-main">
                        <div class="uni-single-product-body">
                            <div class="container">
                                <div id="content">
                                    <div class="row">

                                        <div class="col-md-9">
                                            <div class="uni-single-product-right">
                                                <div id="product">
                                                    <div class="product-info">
                                                        <c:forEach items="${listDetailVc}" var="vaccine">
                                                            <div class="row">

                                                                <div class="col-sm-6 left image-panel">
                                                                    <div id="carousel"
                                                                         class="flexslider thumbnail_product">
                                                                        <div id="slider" class="flexslider">
                                                                            <div class="img-slide">
                                                                                <img class="filter2 animated fadeIn shop4 img-responsive"
                                                                                     src="${vaccine.image}"
                                                                                     alt="product">
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>

                                                                <div class="col-sm-6 right">
                                                                    <h1 class="product_title entry-title">${vaccine.name}
                                                                    </h1>
                                                                    <div class="description">
                                                                        <p>${vaccine.detail}</p>
                                                                    </div>

                                                                    <!-- .description -->

                                                                    <form class="cart" method="post"
                                                                          enctype="multipart/form-data">
                                                                        <div class="quantity">
                                                                            <div class="form-group">
                                                                                <label>Number:</label>
                                                                                <input type="text" class="form-control qty" id="pwd" value="50" readonly>
                                                                            </div>                                                                            
                                                                        </div>
                                                                        <button type="submit" name="add-to-cart"
                                                                                class="single_add_to_cart_button button alt"><a href="ListHosByVacController?idVaccine=${vaccine.idVaccine}">BOOKING NOW</a></button>
                                                                        <div class="clearfix"></div>
                                                                    </form>
                                                                </div>

                                                                <!-- .summary -->
                                                            </div>
                                                        </c:forEach>
                                                    </div>

                                                    <div class="woocommerce-tabs wc-tabs-wrapper">
                                                        <div class="row">
                                                            <div class="col-md-12" id="logout">
                                                                <div class="comment-tabs">
                                                                    <div class="uni-shortcode-tabs-default">
                                                                        <div class="uni-shortcode-tab-3">
                                                                            <div class="tabbable-panel">
                                                                                <section>
                                                                                    <div class="container my-5 py-5">
                                                                                        <div class="row d-flex justify-content-center">
                                                                                            <div class="col-md-12">
                                                                                                <div class="card text-dark">
                                                                                                    <h2>Comments</h2>
                                                                                                    <ul id="comment-list" class="list-group">
                                                                                                        <c:forEach items="${listCmt}" var="comment">
                                                                                                            <li class="list-group-item comment-item">
                                                                                                                <div class="comment-header">
                                                                                                                    <strong class="comment-user">${comment.userName}:</strong>
                                                                                                                    <span class="comment-date small">${comment.dateTime}</span>
                                                                                                                </div>
                                                                                                                <p class="comment-text">${comment.comment}</p>
                                                                                                                <button class="btn btn-danger comment-delete-btn" onclick="deleteComment('${comment.idComment}')">
                                                                                                                    Delete
                                                                                                                </button>
                                                                                                            </li>
                                                                                                        </c:forEach>
                                                                                                    </ul>
                                                                                                    <form id="comment-form">
                                                                                                        <div class="form-group">
                                                                                                            <label for="comment">Comment:</label>
                                                                                                            <textarea class="form-control" id="comment" name="comment" required></textarea>
                                                                                                        </div>
                                                                                                        <input type="hidden" name="idVaccine" value="${param.idVaccine}">
                                                                                                        <button type="button" id="submit-comment" class="btn btn-primary">Submit</button>
                                                                                                    </form>
                                                                                                </div>


                                                                                                <!-- jQuery -->
                                                                                                <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
                                                                                                <!-- Bootstrap JS -->
                                                                                                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
                                                                                                <script>
                                                                                                                    $(document).ready(function () {
                                                                                                                        // Handle submit button click event
                                                                                                                        $("#submit-comment").click(function () {
                                                                                                                            // Get the form data
                                                                                                                            var formData = $("#comment-form").serialize();
                                                                                                                            // Send an AJAX request to add a new comment
                                                                                                                            $.ajax({
                                                                                                                                url: "CommentController",
                                                                                                                                type: "POST",
                                                                                                                                data: formData,
                                                                                                                                success: function (response) {
                                                                                                                                    // Update the comment list with the updated comment array
                                                                                                                                    updateCommentList(response.updatedCommentList);
                                                                                                                                    // Clear the comment textarea
                                                                                                                                    $("#comment").val("");
                                                                                                                                }
                                                                                                                            });
                                                                                                                        });
                                                                                                                    });

                                                                                                                    function updateCommentList(commentArray) {
                                                                                                                        // Clear the comment list
                                                                                                                        $("#comment-list").empty();
                                                                                                                        // Iterate through the comment array and add comments to the list
                                                                                                                        for (var i = 0; i < commentArray.length; i++) {
                                                                                                                            var comment = commentArray[i];
                                                                                                                            var commentItem = "<li class='comment-item'>" +
                                                                                                                                    "<div class='comment-header'>" +
                                                                                                                                    "<strong class='comment-user'>" + comment.userName + ":</strong>" +
                                                                                                                                    "<span class='comment-date'>" + comment.dateTime + "</span>" +
                                                                                                                                    "</div>" +
                                                                                                                                    "<p class='comment-text'>" + comment.comment + "</p>" +
                                                                                                                                    "<button class='btn btn-danger comment-delete-btn' onclick='deleteComment(\"" + comment.idComment + "\")'>Delete</button>" +
                                                                                                                                    "</li>";
                                                                                                                            $("#comment-list").append(commentItem);
                                                                                                                        }
                                                                                                                    }

                                                                                                                    function deleteComment(idComment) {
                                                                                                                        // Send an AJAX request to delete the comment
                                                                                                                        $.ajax({
                                                                                                                            url: "CommentController",
                                                                                                                            type: "POST",
                                                                                                                            data: {
                                                                                                                                idComment: idComment,
                                                                                                                                action: "delete"
                                                                                                                            },
                                                                                                                            success: function (response) {
                                                                                                                                if (response.success) {
                                                                                                                                    // Remove the comment element from the UI
                                                                                                                                    $("#comment-list li").each(function () {
                                                                                                                                        if ($(this).find(".btn-danger").attr("onclick").includes(idComment)) {
                                                                                                                                            $(this).remove();
                                                                                                                                            return false; // Exit the loop
                                                                                                                                        }
                                                                                                                                    });
                                                                                                                                } else {
                                                                                                                                    // Handle error when unable to delete the comment
                                                                                                                                    toastr.error("You can't delete this comment.");
                                                                                                                                }
                                                                                                                            }
                                                                                                                        });
                                                                                                                    }
                                                                                                </script>
                                                                                                <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
                                                                                            </div>
                                                                                        </div>
                                                                                    </div>
                                                                                </section>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </main>
                </div>

            </div>
        </div>

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
</div>
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
</body>

<!-- 06_02_single_product.html  [XR&CO'2014], Tue, 22 Oct 2019 11:56:16 GMT -->

</html>