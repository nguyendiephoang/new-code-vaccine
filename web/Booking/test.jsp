<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Date Info</title>
</head>
<body>
    <h1>Date Information:</h1>
    <ul id="dateInfoList"></ul>

    <script>
        var dateInfo = '<%= session.getAttribute("dateInfo") %>';
        console.log(dateInfo);

        if (dateInfo && dateInfo.length > 0) {
            dateInfo = dateInfo.replace(/\[|\]/g, "");
            var dateInfoArr = dateInfo.split(',');

            dateInfoArr.forEach(function (info) {
                var parts = info.split("|");
                var date = parts[0];
                var timeRangeInfo = parts[1];

                var dateItem = document.createElement("li");
                dateItem.innerText = date;
                document.getElementById("dateInfoList").appendChild(dateItem);

                if (timeRangeInfo) {
                    var timeRanges = timeRangeInfo.split("],");
                    timeRanges.forEach(function (timeRange) {
                        timeRange = timeRange.replace("]", "");

                        var timeRangeItem = document.createElement("li");

                        var timeRangeData = timeRange.split(",");
                        if (timeRangeData.length >= 4) {
                            var timeRangeId = timeRangeData[0].split("=")[1];
                            var startTime = timeRangeData[1].split("=")[1];
                            var endTime = timeRangeData[2].split("=")[1];
                            
                            var quantity = "";
                            var quantityCA = "";
                            for (var i = 3; i < timeRangeData.length; i++) {
                                var data = timeRangeData[i].split("|");
                                if (data.length === 2) {
                                    var key = data[0].split("=")[0];
                                    var value = data[0].split("=")[1];
                                    if (key === "quantity") {
                                        quantity = value;
                                    } else if (key === "quantityCA") {
                                        quantityCA = value;
                                    }
                                }
                            }

                            var timeRangeText = "TimeRange id: " + timeRangeId + "\n";
                            timeRangeText += "startTime: " + startTime + "\n";
                            timeRangeText += "endTime: " + endTime + "\n";
                            timeRangeText += "quantity: " + quantity + "\n";
                            timeRangeText += "quantityCA: " + quantityCA;

                            timeRangeItem.innerText = timeRangeText;
                            document.getElementById("dateInfoList").appendChild(timeRangeItem);
                        }
                    });
                }
            });
        } else {
            var errorMessage = document.createElement("li");
            errorMessage.innerText = "No date information available.";
            document.getElementById("dateInfoList").appendChild(errorMessage);
        }
    </script>
</body>
</html>
