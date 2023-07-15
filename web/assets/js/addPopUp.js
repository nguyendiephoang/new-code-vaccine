/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */
var modal = document.getElementById("addVaccineFormPopup");


// var modal = document.getElementById("addVaccineFormPopup");
var modal2 = document.getElementById("addTimeRangeFormPopup");


// JavaScript code to open and close the add vaccine form popup
function openForm(t) {
  console.log("open form");
  modal.style.display = "block";
  pickedTime = t.previousElementSibling.previousElementSibling;
}


function closeForm() {
  modal.style.display = "none";
}


// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
};


function openForm2() {
  modal2.style.display = "block";
}


function closeForm2() {
  modal2.style.display = "none";
}


// When the user clicks anywhere outside of the modal2, close it
window.onclick = function (event) {
  if (event.target == modal2) {
    modal2.style.display = "none";
  }
};


