<%-- 
    Document   : schedule
    Created on : Jun 11, 2023, 7:41:46 PM
    Author     : DELL VOSTRO 5510
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

    <!-- 03_01_services.html  [XR&CO'2014], Tue, 22 Oct 2019 11:55:26 GMT -->

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Booking</title>
        <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png" />
        <link rel="stylesheet" href="plugin/bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="plugin/bootstrap/css/bootstrap-theme.css">
        <link rel="stylesheet" href="fonts/poppins/poppins.css">
        <link rel="stylesheet"
              href="plugin/fonts/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="plugin/jquery-ui/jquery-ui.min.css">
        <link rel="stylesheet" href="plugin/process-bar/tox-progress.css">
        <link rel="stylesheet" href="plugin/owl-carouse/owl.carousel.min.css">
        <link rel="stylesheet"
              href="plugin/owl-carouse/owl.theme.default.min.css">
        <link rel="stylesheet" href="plugin/animsition/css/animate.css">
        <link rel="stylesheet" href="plugin/jquery-ui/jquery-ui.min.css">
        <link rel="stylesheet" href="plugin/mediaelement/mediaelementplayer.css">
        <link rel="stylesheet"
              href="plugin/datetimepicker/bootstrap-datepicker3.css">
        <link rel="stylesheet"
              href="plugin/datetimepicker/bootstrap-datetimepicker.min.css">
        <link rel="stylesheet" href="plugin/lightgallery/lightgallery.css">
        <link rel="stylesheet" href="css/style.css">
        <!-- Import thư viện Toastr -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
        <style>
            label {
                display: block;
            }
        </style>
    </head>

    <body>

        <div class="uni-gallery">
            <div id="wrapper-container" class="site-wrapper-container">


                <div id="main-content" class="site-main-content">
                    <section class="site-content-area">

                        <div class="uni-services-body">

                            <!--DEPARTMENT, TESTIMONIAL, OPNING HOURES-->
                            <div class="uni-services-de-test-hours">
                                <div class="container">
                                    <div class="row">

                                        <!--OPENING HOURS AND BOOK APPOINTMENT-->
                                        <div class="uni-home-opening-book">
                                            <div class="container">
                                                <div class="uni-home-opening-book-content">
                                                    <div class="row">
                                                        <div class="col-md-4">
                                                            <div class="uni-services-opinging-hours">
                                                                <div class="uni-services-opinging-hours-title">
                                                                    <div class="icon">
                                                                        <i class="fa fa-clock-o" aria-hidden="true"></i>
                                                                    </div>
                                                                    <h4>Opening Hours</h4>
                                                                </div>
                                                                <div class="uni-services-opinging-hours-content">
                                                                    <form action="#">
                                                                        <div class="row">
                                                                            <table class="table">
                                                                                <tr>
                                                                                    <td>Date</td>
                                                                                    <td>Time Range</td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td>
                                                                                        <div class="radio">
                                                                                            <label>
                                                                                                <div id="dateButtons"></div>
                                                                                            </label>
                                                                                        </div>
                                                                                    </td>
                                                                                    <td>
                                                                                        <div class="radio">
                                                                                            <label>
                                                                                                <div id="timeRangesContainer"></div>
                                                                                            </label>
                                                                                        </div>
                                                                                    </td>
                                                                                </tr>
                                                                            </table>
                                                                        </div>
                                                                    </form>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-8">
                                                            <div class="uni-single-department-appointment-form">
                                                                <div class="uni-home-title">
                                                                    <h3>Booking Table</h3>
                                                                    <div class="uni-underline"></div>
                                                                </div>

                                                                <form action="makeAppointmentController" method="post">
                                                                    <div class="row">
                                                                        <% String nameVaccine = request.getParameter("nameVaccine"); %>
                                                                        <% String nameHospital = request.getParameter("nameHospital");%>
                                                                        <p>${result}<p>
                                                                        <div class="input-group form-group">
                                                                            <span class="input-group-addon"><i class="fa fa-eyedropper" aria-hidden="true"></i></span>
                                                                            <input type="text" class="form-control" name="nameVaccine" value="<%=nameVaccine%>" readonly>
                                                                        </div>
                                                                        <div class="input-group form-group">
                                                                            <span class="input-group-addon"><i class="fa fa-hospital-o" aria-hidden="true"></i></span>
                                                                            <input type="text" class="form-control" name="nameHospital" value="<%=nameHospital%>" readonly>
                                                                        </div>
                                                                        <div class="input-group form-group">
                                                                            <span class="input-group-addon"><i class="fa fa-user" aria-hidden="true"></i></span>
                                                                            <input type="text" class="form-control" name="name" value="" placeholder="Your name">
                                                                        </div>
                                                                        <div class="input-group form-group">
                                                                            <span class="input-group-addon"><i class="fa fa-phone" aria-hidden="true"></i></span>
                                                                            <input type="tel" class="form-control" name="phone" value="" placeholder="Phone number">
                                                                        </div>
                                                                        <div class="input-group form-group">
                                                                            <span class="input-group-addon"><i class="fa fa-envelope" aria-hidden="true"></i></span>
                                                                            <input type="email" class="form-control" name="email" value="" placeholder="Email">
                                                                        </div>
                                                                        <div class="input-group form-group">
                                                                            <div class="input-group-addon"><i class="fa fa-calendar" aria-hidden="true"></i></div>
                                                                            <input type="text" class="form-control" id="selectedDateTime" name="selectedDateTime" readonly>
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <input type="submit" value="Book Now" class="btn btn-primary" onclick="return validateQuantity();">
                                                                        </div>
                                                                    </div>
                                                                </form>
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

                    </section>
                </div>


            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

        <script>
// Lấy thông tin về ngày từ thuộc tính 'dateInfo'
                                                                                var dateInfo = '<%= session.getAttribute("dateInfo")%>';

// Mảng chứa các ngày và các time range tương ứng
                                                                                var dates = [];
                                                                                var timeRanges = [];

// Regex pattern để tìm kiếm ngày và time range trong chuỗi 'dateInfo'
                                                                                var regex = /(\d{4}-\d{2}-\d{2})\|\[(.*?)\]/g;
                                                                                var match;

// Lặp qua tất cả các kết quả match trong chuỗi 'dateInfo'
                                                                                while ((match = regex.exec(dateInfo)) !== null) {
                                                                                    var date = match[1];
                                                                                    var timeRangeString = match[2];

                                                                                    // Thêm ngày vào mảng 'dates'
                                                                                    dates.push(date);

                                                                                    // Mảng chứa các time range cho ngày hiện tại
                                                                                    var timeRangesData = [];

                                                                                    // Regex pattern để tìm kiếm các trường thông tin trong chuỗi 'timeRangeString'
                                                                                    var timeRangeRegex = /TimeRange\{id=(\d+), startTime=(\d+:\d+:\d+), endTime=(\d+:\d+:\d+), quantity=(\d+), quantityCA=(\d+)\}/g;
                                                                                    var timeRangeMatch;

                                                                                    // Lặp qua tất cả các kết quả match trong chuỗi 'timeRangeString'
                                                                                    while ((timeRangeMatch = timeRangeRegex.exec(timeRangeString)) !== null) {
                                                                                        var id = timeRangeMatch[1];
                                                                                        var startTime = timeRangeMatch[2];
                                                                                        var endTime = timeRangeMatch[3];
                                                                                        var quantity = timeRangeMatch[4];
                                                                                        var quantityCA = timeRangeMatch[5];

                                                                                        // Tạo đối tượng time range và thêm vào mảng 'timeRangesData'
                                                                                        var timeRange = {
                                                                                            id: id,
                                                                                            startTime: startTime,
                                                                                            endTime: endTime,
                                                                                            quantity: quantity,
                                                                                            quantityCA: quantityCA
                                                                                        };
                                                                                        timeRangesData.push(timeRange);
                                                                                    }

                                                                                    // Thêm mảng 'timeRangesData' vào mảng 'timeRanges'
                                                                                    timeRanges.push(timeRangesData);
                                                                                }

                                                                                var dateButtonsContainer = document.getElementById("dateButtons");
                                                                                var timeRangesContainer = document.getElementById("timeRangesContainer");
                                                                                var selectedDateTime = document.getElementById("selectedDateTime");

// Tạo các nút chọn ngày
                                                                                for (var j = 0; j < dates.length; j++) {
                                                                                    var dateButton = document.createElement("input");
                                                                                    dateButton.type = "radio";
                                                                                    dateButton.name = "date";
                                                                                    dateButton.value = j;
                                                                                    dateButton.id = "dateButton" + j;
                                                                                    dateButton.addEventListener("click", showTimeRanges);

                                                                                    var label = document.createElement("label");
                                                                                    label.htmlFor = "dateButton" + j;
                                                                                    label.textContent = dates[j];

                                                                                    dateButtonsContainer.appendChild(dateButton);
                                                                                    dateButtonsContainer.appendChild(label);
                                                                                }

                                                                                /**
                                                                                 * Xử lý sự kiện khi chọn một ngày
                                                                                 */
                                                                                function showTimeRanges() {
                                                                                    var selectedDateIndex = parseInt(this.value);

                                                                                    // Xóa các timeRangeContainers đã tồn tại
                                                                                    while (timeRangesContainer.firstChild) {
                                                                                        timeRangesContainer.firstChild.remove();
                                                                                    }

                                                                                    // Lấy danh sách các time range của ngày đã chọn
                                                                                    var selectedTimeRanges = timeRanges[selectedDateIndex];

                                                                                    // Hiển thị danh sách các time range
                                                                                    for (var l = 0; l < selectedTimeRanges.length; l++) {
                                                                                        var timeRange = selectedTimeRanges[l];

                                                                                        var timeRangeContainerId = "timeRangeContainer" + l;
                                                                                        var timeRangeContainer = document.getElementById(timeRangeContainerId);

                                                                                        // Nếu không có timeRangeContainer, tạo mới và thêm vào timeRangesContainer
                                                                                        if (!timeRangeContainer) {
                                                                                            timeRangeContainer = document.createElement("div");
                                                                                            timeRangeContainer.id = timeRangeContainerId;
                                                                                            timeRangeContainer.classList.add("timeRangeContainer");

                                                                                            var timeRangeRadio = document.createElement("input");
                                                                                            timeRangeRadio.type = "radio";
                                                                                            timeRangeRadio.name = "timeRange";
                                                                                            timeRangeRadio.value = l;
                                                                                            timeRangeRadio.id = "timeRangeRadio" + l;

                                                                                            var startTimeLabel = document.createElement("span");
                                                                                            startTimeLabel.textContent = timeRange.startTime.slice(0, 8);

                                                                                            var dashLabel = document.createElement("span");
                                                                                            dashLabel.textContent = " - ";

                                                                                            var endTimeLabel = document.createElement("span");
                                                                                            endTimeLabel.textContent = timeRange.endTime.slice(0, 8);

                                                                                            var quantityLabel = document.createElement("span");
                                                                                            quantityLabel.textContent = "Quantity: " + timeRange.quantity;

                                                                                            var quantityCALabel = document.createElement("span");
                                                                                            quantityCALabel.textContent = "Quantity CA: " + timeRange.quantityCA;

                                                                                            timeRangeContainer.appendChild(timeRangeRadio);
                                                                                            timeRangeContainer.appendChild(startTimeLabel);
                                                                                            timeRangeContainer.appendChild(dashLabel);
                                                                                            timeRangeContainer.appendChild(endTimeLabel);
                                                                                            timeRangeContainer.appendChild(quantityLabel);
                                                                                            timeRangeContainer.appendChild(quantityCALabel);

                                                                                            timeRangesContainer.appendChild(timeRangeContainer);
                                                                                        }

                                                                                        timeRangeContainer.style.display = "block";
                                                                                        timeRangeContainer.addEventListener("click", showSelectedDateTime);
                                                                                    }
                                                                                }

                                                                                /**
                                                                                 * Xử lý sự kiện khi chọn một timeRange
                                                                                 */
                                                                                function showSelectedDateTime() {
                                                                                    var selectedDateIndex = parseInt(document.querySelector('input[name="date"]:checked').value);
                                                                                    var selectedTimeRangeIndex = parseInt(document.querySelector('input[name="timeRange"]:checked').value);
                                                                                    var selectedDate = dates[selectedDateIndex];
                                                                                    var selectedTimeRange = timeRanges[selectedDateIndex][selectedTimeRangeIndex];
                                                                                    var selectedDateTimeInput = document.getElementById("selectedDateTime");
                                                                                    selectedDateTimeInput.value = "Date: " + selectedDate + ", " + "Time Range: " + selectedTimeRange.startTime + " - " + selectedTimeRange.endTime;
                                                                                }

        </script>
    </body>
    <script>
        // Xử lý hiển thị thông báo lỗi
        var error = '<%= request.getParameter("error")%>';
        if (error) {
            toastr.error(error);
        }
    </script>
</html>
