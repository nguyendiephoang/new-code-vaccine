// JavaScript code goes here
document.addEventListener("DOMContentLoaded", function () {
    // Get all the sidebar links
    var sidebarLinks = document.querySelectorAll("#sidebar .nav-link");

    // Add click event listeners to the sidebar links
    sidebarLinks.forEach(function (link) {
        link.addEventListener("click", function (event) {
            event.preventDefault();

            // Hide all sections
            var sections = document.querySelectorAll("section");
            sections.forEach(function (section) {
                section.style.display = "none";
            });

            // Show the selected section
            var target = this.getAttribute("href").substring(1);
            var targetSection = document.getElementById(target);
            targetSection.style.display = "block";
        });
    });
});