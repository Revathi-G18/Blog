var myApp=angular.module("myApp",["ngRoute"]);

myApp.config(function($routeProvider)
{
	alert("Route Provider");
	$routeProvider.when("/",{templateUrl:"/index.html"})
			.when("/login",{templateUrl:"template/Login.html"})
			.when("/register",{templateUrl:"template/Register.html"})
			.when("/aboutUs",{templateUrl:"template/AboutUs.html"})
			.when("/contactUs",{templateUrl:"template/ContactUs.html"})
});