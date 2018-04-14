var myApp=angular.module('myApp',['ngRoute','ngCookies'])
myApp.config(function($routeProvider){
	$routeProvider
	.when('/register',{
		templateUrl:'views/Register.html',
		controller:'UserController'
	})
	.when('/login',{
		templateUrl:'views/Login.html',
		controller:'UserController'
	} )})