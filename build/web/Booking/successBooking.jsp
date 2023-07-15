<%-- 
    Document   : successBooking
    Created on : Jul 12, 2023, 4:55:03 AM
    Author     : DELL VOSTRO 5510
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Payment successful</title>
        <style>
            *,
            *:after,
            *:before {
                box-sizing: border-box;
                font-family: Sans-Serif;
            }

            .tick {
                display: inline-block;
                transform: rotate(45deg);
                height: 36px;
                width: 18px;
                border-bottom: solid 3px #2196f3;
                border-right: solid 3px #2196f3;
                margin-bottom: 8px;
            }

            .tick-container {
                padding: 20px;
                border-radius: 100px;
                height: 56px;
                width: 56px;
                display: inline-flex;
                justify-content: center;
                align-items: center;
                background: #fff;
                margin-bottom: 12px;
            }

            body {
                background: white;
                margin: 0;
                background: #1693f6d6;
                text-align: center;
            }

            .heading {
                font-size: 1.5rem;
                display: flex;
                align-items: center;
                flex-direction: column;
                margin-bottom: 32px;
            }

            .container {
                color: #fff;
                margin: auto;
                padding: 32px 16px 16px;
            }

            .text-container {
                line-height: 1.8em;
            }

            .primary-button {
                color: #2196f3;
                background-color: #fff;
                padding: 12px 16px;
                display: inline-block;
                margin-top: 32px;
                border-radius: 6px;
                text-decoration: none;
                text-transform: uppercase;
            }


            .tick {
                position: relative;
                width: 150px;
                height: 150px;
                overflow: hidden;
                border-radius: 50%;
                transform: scale(0.8);
                /*   zoom: 2; */
            }

            .circle {
                position: absolute;
                border-radius: 50%;
            }

            .light {
                background-color: #c7e8d6;
                animation: scaleAnimation 1.2s;
                width: 100%;
                height: 100%;
            }
            @keyframes scaleAnimation {
                0% {
                    transform: scale(0);
                }
                15% {
                    transform: scale(1);
                }
                100% {
                    transform: scale(1);
                }
            }

            .dark {
                background-color: #20A15C;
                height: 100%;
                width: 100%;
                animation: fillAnimation 1.2s;
            }

            @keyframes fillAnimation {
                0% {
                    left: -100%;
                }
                15%{
                    left: -100%;
                }
                40% {
                    left: 0%;
                }
                100% {
                    left: 0%;
                }
            }

            .check-path{
                overflow: hidden;
            }

            .check_mark_main{
                position: absolute;
                left: 50%;
                top: 45%;
                transform: translate(-50%, -50%);
            }
            .svg-rec{
                position: relative;
                width: 100px;
                height: 100px;
            }
            .checkmark{
                transform: rotate(45deg) scale(1.05);
                height: 100px;
                width: 100px;
                margin-top: -35px;
                margin-left: -26px;
                stroke-dasharray: 100px, 160px;
                animation: success-tick 1.2s forwards;
            }

            @keyframes success-tick {
                0% {
                    stroke-dashoffset: 100px;
                }
                26%{
                    stroke-dashoffset: 100px;
                }
                100% {
                    stroke-dashoffset: 10px;
                }
            }

            .clipper{
                position: absolute;
                height: 36px;
                width: 70px;
                top: 0;
                transform: rotate(-45deg);
                border-radius: 8px 0;
                left: 15%;
                top: 30%;
                overflow: hidden;
                /*   background: rgba(0,0,0,0.3); */
            }
            .checkmark__path_traverser{
                fill: none;
                stroke: rgba(32, 161, 92, 0.5);
                stroke-dasharray: 20,1000;
                stroke-width: 6;
                stroke-linecap: round;
                animation: highlight-tick 1.2s 0.2s infinite forwards;
            }
            .checkmark__path_traverser2{
                fill: none;
                stroke: white;
                stroke-dasharray: 20,1000;
                stroke-width: 6;
                stroke-linecap: round;
                animation: highlight-tick 1.2s 0.3s infinite forwards;
            }

            @keyframes highlight-tick {
                0% {
                    stroke-dashoffset: 20px;
                }
                22%{
                    stroke-dashoffset: 20px;
                }
                85%{
                    stroke-dashoffset: -30px;
                }
                100% {
                    stroke-dashoffset: -45px;
                }
            }

        </style>
    </head>
    <body style="font-family: sans-serif;">
        <div class="container">

            <div id="animationContainer" class="tick">
                <div class="circle light"></div>
                <div class="circle dark"></div>
                <div class="check_mark_main">
                    <div class="svg-rec">
                        <div class="clipper">
                            <svg class="checkmark" viewBox="0 0 52 52">
                            <path class="checkmark__path" stroke-width="6" fill="none" stroke="white" d="m14 27 10.9 10.9 23.2-23.2"/>
                            <path class="checkmark__path_traverser" d="m14 27 10.9 10.9 23.2-23.2"/>
                            <path class="checkmark__path_traverser2" d="m14 27 10.9 10.9 23.2-23.2"/>
                            </svg>
                        </div>
                    </div>
                </div>
            </div>

            <div class="text-container">
                <h2><b>Your booking is successful</b></h2>
                <br>
                <div>
                    <p>You will be logged out of all the devices except this one.</p>
                </div>
                <div>
                    <p id="countdown"></p>
                </div>
                <div>
                    <p>Click the button below if you are not redirected to the website.</p>
                </div>
                <a class="primary-button" href="http://localhost:8080/Vaccine_testver1/ListVaccineController">Back to Vaccine list</a>
                <a class="primary-button" href="http://localhost:8080/Vaccine_testver1/UserManagerController">View your booking appointment</a>
            </div>
        </div>
        <script>
            var redirectUrl = 'http://localhost:8080/Vaccine_testver1/ListVaccineController';
            var time = 60; 

            var countdownElement = document.getElementById("countdown");

            function countdown() {
                countdownElement.innerHTML = "You will be redirected to the Home in " + time + " seconds.";

                if (time > 0) {
                    time--;
                    setTimeout(countdown, 1000); // Đếm ngược sau mỗi giây (1000ms)
                } else {
                    window.location = redirectUrl; // Chuyển hướng khi thời gian đếm ngược kết thúc
                }
            }

            countdown();
        </script>
    </body>
</html>
