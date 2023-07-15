var datesInfo;
var pickedTime;
var perTimeRange;
var datePickedInfos = [];
var timeRangeList;
var modal2;
var modal;
var updateURL = null;
var paramDate;
var activateDate = "start";
var databaseAsset = [];

var changesHistory = [

];
// defauly url
// Make an AJAX request to the servlet
var xhr = new XMLHttpRequest();
if(updateURL != "") xhr.open('GET', ('http://localhost:8084/Vaccine_testver1/UpdateAppointment'), true);
else xhr.open('GET', (updateURL), true);

xhr.onreadystatechange = function() {
	if (xhr.readyState === XMLHttpRequest.DONE) {
		if (xhr.status === 200) {

			//Start: Array from servlet
			// Parse the JSON response
			var response = JSON.parse(xhr.responseText);

			// Access the arrays from the response object
			datesInfo = response.datesInfo.replace("[", "").replace("]", "").split(",");
			datePickedInfos = response.datePickedInfos.replace("[", "").replace("]", "").split(",");
			timeRangeList = response.timeRangeList.replace("[", "").replace("]", "").replace(/"/g, '').split(",");
			paramDate = response.paramDate.replace(/"/g, '');
			//End: Array from servlet

			const daysTag = document.querySelector(".days"),
				currentDate = document.querySelector(".current-date"),
				prevNextIcon = document.querySelectorAll(".icons span");
			let datePicked = document.getElementById("datePicked");
			var dayInfo = document.getElementById("dayInfo");

			// getting new date, current year and month
			let date = new Date(),
				currYear = date.getFullYear(),
				currMonth = paramDate.split("/")[1] ?? date.getMonth() + 1;
			// storing full name of all months in array
			const months = [
				"January",
				"February",
				"March",
				"April",
				"May",
				"June",
				"July",
				"August",
				"September",
				"October",
				"November",
				"December",
			];


			const renderCalendar = () => {
				console.log("hello");
				let firstDayofMonth = new Date(currYear, currMonth, 1).getDay() + 4, // getting first day of month
					lastDateofMonth = new Date(currYear, currMonth, 0).getDate(), // getting last date of month
					lastDayofMonth =
						new Date(currYear, currMonth, lastDateofMonth).getDay() + 4, // getting last day of month
					lastDateofLastMonth =  new Date(currYear, currMonth - 1, 0).getDate(); // getting last date of previous month
				let liTag = "";
				// for (let i = firstDayofMonth; i > 0; i--) {
				// creating li of previous month last days
				// liTag += `<li class="inactive">${lastDateofLastMonth - i + 1}</li>`;
				// }


				for (let i = 1; i <= lastDateofMonth; i++) {
					let j = 1;
					// creating li of all days of current month
					// adding active class to li if the current day, month, and year matched
					let isToday;

					if (i == paramDate.split("/")[0]) {
						isToday = "active";
						console.warn("hehe bug: " + i);
						if (activateDate == "start") {
							activateDate = i;
						}
					} else isToday = "";
					if (datesInfo[i] != undefined)
						liTag += `<li id ="month_${currMonth}date_${i}"  class="${isToday + " " + datesInfo[i].split("-")[1].replace('\"', "")
							} choosenDate">${i}</li>`;
				}




				//	for (let i = lastDayofMonth; i < 13; i++) {
				// creating li of next month first days
				//	liTag += `<li class="inactive">${i - lastDayofMonth + 1}</li>`;
				//}
				datePicked.innerText = activateDate;
				currentDate.innerText = `${months[currMonth - 1]} ${currYear}`; // passing current mon and yr as currentDate text
				daysTag.innerHTML = liTag;
			};
			function getDataChoosenDate(datePickedInfos) {
				let html = `<!-- form add time range in date -->
			<div class="addTimeRangeForm" id="addTimeRangeFormPopup">
  			    <form action="">
  			    <label for="timeRanges">Choose new time range:</label>
  			    <select id="timeRange" name="timeRangelist" form="">
   			   <option value="ex: start - end" >start-end</option>
         			${timeRangeList.map((e) => {
					return `<option value="${e}">${e}</option>`;
				})}
     			 </select>

          		</select>
          		<label for="">Vaccine ID </label><input type="text" name="vacId" id="vacId" placeholder="ex: A001"><br>
          		<label for="">Vaccine name </label><input type="text" name="vacName" id="vacName" placeholder="ex: Vaccine 1"><br>
          		<label for="">Vaccine quantity </label><input type="text" name="vacQuan" id="vacQuan" placeholder="ex: 10 slots"><br>

        		<button type="button" class ="confirmAddTimeRange" >Add</button>
       		 <button type="button" onclick="closeForm2()">Cancel</button> 
     		 </form>
 		 </div>
  			<!-- form add vaccine in time range -->

 			 <div class="addVaccineForm" id="addVaccineFormPopup">
 			 <form action="">
  			  <label for="">Vaccine ID </label><input type="text" name="vacId" id="vacId" placeholder="ex: A001"><br>
 			   <label for="">Vaccine name </label><input type="text" name="vacName" id="vacName" placeholder="ex: Vaccine 1"><br>
 			   <label for="">Vaccine quantity </label><input type="text" name="vacQuan" id="vacQuan" placeholder="ex: 10 slots"><br>
  			  <button type="button" class = "confirmAddVaccine">Confirm</button>
  			  <button type="button" class="deletebtn" onclick="closeForm()">Cancel</button>
 			 </form>
 			 </div>`;
				datePickedInfos.forEach((e) => {
					if (e) {
						let timeRange = e.split("|")[0];
						/// VC1-vaccine covid(10/20)?
						let vacList = e.split("|")[1].split("?");
						html += `
        <div class="container perTimeRange">
          <article class="article" id="timeRangeInfo">  
            <div class="col-sm-3 cusColor hF timeRange">
            <div>${timeRange.replace(/"/g, '')}
            </div> 
            </div>
            <div class="col-sm-8 mint hF timeRangeInfo"> 
      `;
						vacList.forEach((v) => {
							let vId = v.split("(")[0].split("-")[0];
							let vName = v.split("(")[0].split("-")[1];
							let vQuan = v.split("(")[1].slice(0, -1).replace(")", '');
							html += `
            <div class="perVac">
          <h7 class="vacId col-sm-6">${vId}</h7>
          <h7 class="vacName col-sm-6">${vName.length < 8 ? vName : vName.slice(0, 5) + "..."
								}</h7>
          <button class="vacEdit vacMin col-sm-3">-</button> 
          <h7 class="vacQuan col-sm-3">${vQuan}</h7> 
          <button class="vacEdit vacAdd col-sm-3">+</button> 
          <button class="vacDelete col-sm-3">🚮</button> 
      
            </div>
        `;
						});
						html += `
            </div>
            <button class="btn-addVaccine">+</button>
            <div class="col-sm-1 yellow hF deleteTimeRangeBtn">
              <button> 🚮</button>
            </div>
          </article>
        </div>
      `;
					}
				});
				html += "</div>";
				dayInfo.innerHTML = html;
			}

			function assignEventHandlers() {
				modal = document.getElementById("addVaccineFormPopup");
				// var modal = document.getElementById("addVaccineFormPopup");
				modal2 = document.getElementById("addTimeRangeFormPopup");

				let prevBtn = document.querySelector("#prev");
				prevBtn.onclick = function() {
					console.log("prev clicked");
					console.log("currmonth " + currMonth);
					paramMonth = --currMonth;
					activateDate = 1;
					let updateURL =
						"http://localhost:8084/Vaccine_testver1/UpdateAppointment?date=month_" + paramMonth + "date_" + activateDate;
					// Reload the page with the new URL
					xhr.open('GET', updateURL, true);
					xhr.send();

				}

				let nextBtn = document.querySelector("#next");
				nextBtn.onclick = function() {
					console.log("next clicked");
					console.log("currmonth " + currMonth);
					paramMonth = ++currMonth;
					activateDate = 1;
					let updateURL =
						"http://localhost:8084/Vaccine_testver1/UpdateAppointment?date=month_" + paramMonth + "date_" + activateDate;
					// Reload the page with the new URL
					xhr.open('GET', updateURL, true);
					xhr.send();

				}



				let vacEdit = document.querySelectorAll(".vacEdit");
				vacEdit.forEach((button) => {
					button.onclick = function() {
						let changeDetail = "";
						let vId;
						let time =
							button.parentElement.parentElement.previousElementSibling.innerText;
						let vacQuantity =
							button.parentElement.firstChild.nextElementSibling.nextElementSibling
								.nextElementSibling.nextElementSibling.innerText;

						if (vacQuantity != "deleted" && button.classList.contains("vacAdd")) {
							vId = button.parentElement.firstChild.nextSibling.innerText;
							console.log("add");
							// Add
							let quantityElement = button.previousElementSibling;
							let quantityText = quantityElement.innerText;
							let quantityArray = quantityText.split("/");
							let quantity = parseInt(quantityArray[1]);
							if (quantity >= 0) {
								// Change color
								quantityElement.parentElement.style.backgroundColor = "#fee100";
								quantityElement.innerText = quantityArray[0] + "/" + (quantity + 1);
								changeDetail = "(+" + quantityElement.innerText + ")";
							}
							// add to changeHistory
							changesHistory.push(`${time}|edit|${vId}${changeDetail}`);
						} else if (
							vacQuantity != "deleted" &&
							button.classList.contains("vacMin")
						) {
							vId = button.parentElement.firstChild.nextSibling.innerText;
							console.log("subtract");
							// Subtract
							let quantityElement = button.nextElementSibling;
							let quantityText = quantityElement.innerText;
							let quantityArray = quantityText.split("/");
							let quantity = parseInt(quantityArray[1]);
							let totalQuantity = parseInt(quantityArray[1]); // Get the second part of the quantity string
							// Change color
							quantityElement.parentElement.style.backgroundColor = "#fee100";
							if (quantity > quantityArray[0]) {
								quantityElement.innerText = quantityArray[0] + "/" + (quantity - 1); // Decrement the quantity value by 1
								changeDetail = "(-" + quantityElement.innerText + ")";
							}
							// add to changeHistory
							changesHistory.push(`${time}|edit|${vId}${changeDetail}`);
						}
					};
				});

				let vacDelete = document.querySelectorAll(".vacDelete");
				vacDelete.forEach((button) => {
					button.onclick = function() {
						let vacQuantity =
							button.parentElement.firstChild.nextElementSibling.nextElementSibling
								.nextElementSibling.nextElementSibling.innerText;
						let time =
							button.parentElement.parentElement.previousElementSibling.innerText;
						vId = button.parentElement.firstChild.nextSibling.innerText;
						console.log(
							"delete on: " +
							button.previousSibling.previousSibling.previousElementSibling
						);
						let closestH7 =
							button.previousSibling.previousSibling.previousElementSibling;
						closestH7.innerText = "deleted";
						// Change color
						console.log(button.parentElement);
						button.parentElement.style.backgroundColor = "coral";
						// add to changeHistory
						if (vacQuantity != "deleted")
							changesHistory.push(`${time}|delete vaccine|${vId}`);
					};
				});

				let addTimeRangeBtn = document.querySelectorAll(".addTimeRangeBtn");
				addTimeRangeBtn.forEach((button) => {
					console.log("modal2 open");
					button.onclick = function() {
						console.log("huhue");
						console.log(modal2);
						modal2.style.display = "block";
					};
				});

				let addVaccineBtn = document.querySelectorAll(".btn-addVaccine");
				addVaccineBtn.forEach((button) => {
					button.onclick = function() {

						// check not deleted 
						// change color
						if ((button.parentElement.childNodes[0].nextSibling.outerHTML != "<div class=\"col-sm-3 cusColor hF timeRange\" style=\"background-color: rgb(226, 106, 57);\">\n            <div>09:00 11:00\n            </div> \n            </div>")) {
							console.log("modal open");
							modal.style.display = "block";
							pickedTime = button.previousElementSibling.previousElementSibling;
						}
					};
				});

				let deleteTimeRangeBtn = document.querySelectorAll(".deleteTimeRangeBtn");
				deleteTimeRangeBtn.forEach((button) => {
					button.onclick = function() {

						console.log("delete time range");
						console.log(button.parentElement.childNodes[0]);
						//						console.log(button.parentElement.previousElementSibling.previousElementSibling);

						// change color
						button.parentElement.childNodes[0].nextSibling.style.backgroundColor =
							"#e26a39";
						// delete all vaccine in time range
						console.log(button.previousElementSibling.previousElementSibling.querySelectorAll(".perVac"));
						button.previousElementSibling.previousElementSibling.querySelectorAll(".perVac")
							.forEach((el) => {
								el.style.backgroundColor = "coral";
								el.querySelector(".vacQuan").innerText = "deleted"
								console.log(el)
							})
						// set quantity to delete


						// add to changeHistory
						changesHistory.push(
							`${button.parentElement.childNodes[0].nextSibling.innerText}|delete time range|All vaccine`
						);
						// modify history
						pickedTime = button.parentElement.firstChild.nextSibling;
					};
				});

				let confirmAddTimeRangeBtn = document.querySelectorAll(".confirmAddTimeRange");
				confirmAddTimeRangeBtn.forEach((button) => {
					button.onclick = function() {
						console.log("add time range clicked");
						let vacQuan = button.previousElementSibling.previousElementSibling.value;
						let vacName =
							button.previousElementSibling.previousElementSibling.previousElementSibling
								.previousElementSibling.previousElementSibling.value;
						let vacID =
							button.previousElementSibling.previousElementSibling.previousElementSibling
								.previousElementSibling.previousElementSibling.previousElementSibling
								.previousElementSibling.previousElementSibling.value;
						let timeRange =
							button.previousElementSibling.previousElementSibling.previousElementSibling.previousElementSibling.previousElementSibling.previousElementSibling.previousElementSibling.previousElementSibling.previousElementSibling.previousElementSibling.value.replace(
								"-",
								" "
							);

						modal2.style.display = "none";

						// add to changeHistory
						changesHistory.push(`${timeRange}|add time range|${vacID}(+0/${vacQuan})`);
						addTimeRange(timeRange, vacID, vacQuan, vacName);
					};
				});


				let confirmAddVaccineBtn = document.querySelectorAll(".confirmAddVaccine");
				confirmAddVaccineBtn.forEach((button) => {
					button.onclick = function() {

						let vacQuan = button.previousElementSibling.previousElementSibling.value;
						let vacName =
							button.previousElementSibling.previousElementSibling
								.previousElementSibling.previousElementSibling.previousElementSibling
								.value;
						let vacID =
							button.previousElementSibling.previousElementSibling
								.previousElementSibling.previousElementSibling.previousElementSibling
								.previousElementSibling.previousElementSibling.previousElementSibling
								.value;

						modal.style.display = "none";
						// add to changeHistory
						changesHistory.push(
							`${pickedTime.innerText}|add vaccine|${vacID}(+0/${vacQuan})`
						);
						addVaccine(vacID, vacQuan, vacName);
					};
				});

				let choosenDateBtn = document.querySelectorAll(".choosenDate");
				choosenDateBtn.forEach((chooseDate) => {

					chooseDate.onclick = function() {


						const handledTimeRanges = new Set();
						for (let i = changesHistory.length - 1; i >= 0; i--) {
							const change = changesHistory[i];
							const timeRange = change.split('|')[0];
							if (!handledTimeRanges.has(timeRange)) {
								// Handle the change in the database
								databaseAsset.push(change);
								handledTimeRanges.add(timeRange);
							}
						}

						// ! if database asset empty => popup save change? => ;
						// if database asset empty => reutrn;


						//reset change history
						changesHistory = [];
						console.log("choosen date: " + chooseDate.id);
						// reload page but change url;
						let updateURL =
							"http://localhost:8084/Vaccine_testver1/UpdateAppointment?date=" + chooseDate.id;
						// Reload the page with the new URL
						xhr.open('GET', updateURL, true);
						xhr.send();
					};
				});


				let saveChangeBtn = document.querySelector("#saveChange");
				saveChangeBtn.onclick = function() {
					const handledTimeRanges = new Set();
					// const databaseAsset = []; // Assuming you have defined the `databaseAsset` array

					for (let i = changesHistory.length - 1; i >= 0; i--) {
						const change = changesHistory[i];
						const timeRange = change.split('|')[0];

						if (!handledTimeRanges.has(timeRange)) {
							// Handle the change in the database
							databaseAsset.push(change);
							handledTimeRanges.add(timeRange);
						}
					}
					// console.log("length js: " + databaseAsset.length)

					// Send the databaseAsset array to the servlet

					let s = document.querySelector(".current-date").innerText;
					const [month, year] = s.split(" ");

					// Find the index of the month in the months array
					const monthIndex = months.indexOf(month)+1;
					
					let dateMain = year+"-"+monthIndex+"-"+activateDate;

					console.log(dateMain);
					changesHistory.push(dateMain);
					fetch('http://localhost:8084/Vaccine_testver1/ConfirmUpdateAppointment', {
						method: 'POST',
						headers: {
							'Content-Type': 'application/json'
						},
						body: JSON.stringify(changesHistory)
					})
						.then(response => {
							// Handle the response from the servlet if needed
							console.log('Request sent successfully');
							//	window.location.reload();
						})
						.catch(error => {
							// Handle any errors that occurred during the request
							console.error('Error:', error);
						});
				changesHistory=[];
				};
			}


			function addVaccine(vId, vQuan, vName) {
				// 1. get right timerange
				perTimeRange = pickedTime.nextElementSibling;

				let html = perTimeRange.innerHTML;
				html +=
					`<div class="perVac">
    			 <h7 class="vacId col-sm-6">${vId}</h7>
   				 <h7 class="vacName col-sm-6">${vName.length < 8 ? vName : vName.slice(0, 5) + "..."}</h7>
  				  <button class="vacEdit vacMin col-sm-3">-</button>
   				 <h7 class="vacQuan col-sm-3">/${vQuan}</h7>
   				 <button class="vacEdit vacAdd col-sm-3">+</button>
   				 <button class="vacDelete col-sm-3">🚮</button>
 			 </div>`;
				perTimeRange.innerHTML = html;
				assignEventHandlers();
			}


			function addTimeRange2(timeRange, vId, vQuan, vName) {
				const dayInfo = document.getElementById("dayInfo");
				const container = document.createElement("div");
				container.className = "container perTimeRange";

				const article = document.createElement("article");
				article.className = "article";
				article.id = "timeRangeInfo";

				const timeRangeDiv = document.createElement("div");
				timeRangeDiv.className = "col-sm-3 cusColor hF timeRange";
				timeRangeDiv.textContent = timeRange;

				const timeRangeInfoDiv = document.createElement("div");
				timeRangeInfoDiv.className = "col-sm-8 mint hF timeRangeInfo";

				const perVac = document.createElement("div");
				perVac.className = "perVac";

				const vacId = document.createElement("h7");
				vacId.className = "vacId col-sm-6";
				vacId.textContent = vId;

				const vacNameElement = document.createElement("h7");
				vacNameElement.className = "vacName col-sm-6";
				vacNameElement.textContent =
					vName.length < 8 ? vName : vName.slice(0, 5) + "...";

				const vacEditMinus = document.createElement("button");
				vacEditMinus.className = "vacEdit vacMin col-sm-3";
				vacEditMinus.textContent = "-";

				const vacQuanElement = document.createElement("h7");
				vacQuanElement.className = "vacQuan col-sm-3";
				vacQuanElement.textContent = `/${vQuan}`;

				const vacEditPlus = document.createElement("button");
				vacEditPlus.className = "vacEdit vacAdd col-sm-3";
				vacEditPlus.textContent = "+";

				const vacDelete = document.createElement("button");
				vacDelete.className = "vacDelete col-sm-3";
				vacDelete.textContent = "🚮";

				perVac.appendChild(vacId);
				perVac.appendChild(vacNameElement);
				perVac.appendChild(vacEditMinus);
				perVac.appendChild(vacQuanElement);
				perVac.appendChild(vacEditPlus);
				perVac.appendChild(vacDelete);

				timeRangeInfoDiv.appendChild(perVac);

				const addButton = document.createElement("button");
				addButton.className = "btn-addVaccine";
				addButton.textContent = "+";

				const yellowDiv = document.createElement("div");
				yellowDiv.className = "col-sm-1 yellow hF deleteTimeRangeBtn";

				const deleteButton = document.createElement("button");
				deleteButton.textContent = "🚮";

				yellowDiv.appendChild(deleteButton);

				article.appendChild(timeRangeDiv);
				article.appendChild(timeRangeInfoDiv);
				article.appendChild(addButton);
				article.appendChild(yellowDiv);

				container.appendChild(article);
				dayInfo.appendChild(container);
				deleteTimeRangeBtn = document.querySelectorAll(".deleteTimeRangeBtn");

				assignEventHandlers();
			}
			function addTimeRange(timeRange, vId, vQuan, vName) {
				const dayInfo = document.getElementById("dayInfo");
				const container = document.createElement("div");
				container.className = "container perTimeRange";

				html = `
				<article class="article" id="timeRangeInfo">
					<div class="col-sm-3 cusColor hF timeRange">
						<div>${timeRange}
						</div>
					</div>
					<div class="col-sm-8 mint hF timeRangeInfo">

						<div class="perVac">
							<h7 class="vacId col-sm-6">${vId}</h7>
							<h7 class="vacName col-sm-6">${vName}</h7>
							<button class="vacEdit vacMin col-sm-3">-</button>
							<h7 class="vacQuan col-sm-3">0/${vQuan}</h7>
							<button class="vacEdit vacAdd col-sm-3">+</button>
							<button class="vacDelete col-sm-3">🚮</button>
						</div>

					</div>
					<button class="btn-addVaccine">+</button>
					<div class="col-sm-1 yellow hF deleteTimeRangeBtn">
						<button> 🚮</button>
					</div>
				</article>
        </div>
        `;
				"21:00 22:00|new time range|VC5(+20)",
					container.innerHTML = html;
				dayInfo.appendChild(container);
				deleteTimeRangeBtn = document.querySelectorAll(".deleteTimeRangeBtn");


				assignEventHandlers();
			}

			// start
			renderCalendar();
			getDataChoosenDate(datePickedInfos);
			assignEventHandlers();
                	//
		}else {
			// Handle error case
			console.log('Error: ' + xhr.status);
		}
	}

};
xhr.send();






