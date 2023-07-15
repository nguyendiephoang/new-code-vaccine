<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link href="css/style_vertification.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="email-form">
    <h1>Your Verification Code</h1>
    <p>Enter this verification code within seconds:
        <span id="countdown">
            <p id="alertMess"></p>
            <p id="buttonContainer"></p>
        </span>
    </p>
    <%
        String wrongVerification = (String) request.getSession().getAttribute("wrongVerification");
        if (wrongVerification != null) {
    %>
    <div class="alert alert-warning" style="color: red"><%= wrongVerification%></div>
    <%
            // Xóa thuộc tính session để tránh hiển thị lại cảnh báo
            request.getSession().removeAttribute("wrongVerification");
        }
    %>
    <form action="vertificationEmailController" method="get">
        <input required type="text" name="verification"> <br>
        <button id="submitButton" type="submit" value="Submit">Submit</button>
    </form>
    <script>
        var countdownInterval;

        function startCountdown(seconds) {
            countdownInterval = setInterval(function () {
                // Giảm số giây
                seconds--;

                // Kiểm tra nếu đã hết thời gian
                if (seconds === 0) {
                    clearInterval(countdownInterval);
                    showFinishButton(); // Gọi hàm để hiển thị nút hoàn thành
                    document.getElementById("countdown").innerText = "";
                } else {
                    document.getElementById("countdown").innerText = seconds;
                }
            }, 1000); // Mỗi giây
        }

        function showFinishButton() {
            var submitButton = document.getElementById("submitButton");
            submitButton.setAttribute("disabled", "true");
            submitButton.style.opacity = 0.5;
            document.getElementById("alertMess").innerText = "The code has expired. Please click resend";
            var button = document.createElement("button");
            button.innerText = "Resend";
            button.addEventListener("click", handleCountdownFinish);
            document.getElementById("buttonContainer").appendChild(button);
        }

        function handleCountdownFinish() {
            var email = '<%= session.getAttribute("email")%>';
            var option = prompt('Are you sure you want to resend the verification code to ' + email + '?');
            if (option != null) {
                document.getElementById("countdown").innerText = "";
                window.location.href = 'ResendCode?option=' + option;
            }
        }

        window.onload = function () {
            startCountdown(20);
        };
    </script>
</div>
</body>
</html>