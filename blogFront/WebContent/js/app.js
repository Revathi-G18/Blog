var myApp=angular.module('myApp',['ngRoute','ngCookies'])
myApp.config(function($routeProvider){
	console.log("inside routeProvider block");
	$routeProvider
	.when("/login",{templateUrl:"views/Login.html",controller:"UserController"})
	.when("/register",{templateUrl:"views/Register.html",controller:"UserController"})
	.when("/home",{templateUrl:"views/Home.html",controller:"UserController"})
	.when('/edituserprofile',{templateUrl:'views/edituserprofile.html',	controller:'UserController'} )
	.when('/addjob',{templateUrl:'views/jobform.html',controller:'JobController'} )
	.when('/alljobs',{templateUrl:'views/joblist.html',controller:'JobController'} )
	.when('/getjob/:id',{templateUrl:'views/jobdetail.html',controller:'JobController'} )
	.when('/addblog',{templateUrl:'views/blogform.html',controller:'BlogCtrl'} )
	.when('/blogsnotapproved',{	templateUrl:'views/blogsnotapproved.html',controller:'BlogCtrl'} )
	.when('/blogsapproved',{templateUrl:'views/blogsapproved.html',controller:'BlogCtrl'} )
	.when('/suggestedusers',{templateUrl:'views/suggestedusers.html',controller:'FriendCtrl'} )
	.when('/pendingrequests',{templateUrl:'views/pendingrequests.html',controller:'FriendCtrl'} )
	.when('/friends',{templateUrl:'views/friendsList.html',controller:'FriendCtrl'} )
	.when("/logout",{templateUrl:"views/Logout.html"})
	})
	
myApp.run(function($location,$rootScope,UserService,$cookieStore,NotificationService)
{console.log("i an in run function");
console.log($rootScope.loggedInUser);
if($rootScope.loggedInUser==undefined){ 
	console.log("hello user");
	$rootScope.loggedInUser=$cookieStore.get('currentuser');
}
$rootScope.logout=function()
{
	console.log("logout function")
	delete $rootScope.loggedInUser;
	$cookieStore.remove('currentuser')
	UserService.logout().then(
			function(response){
				console.log("Loggout successfully..")
		
		$rootScope.message="Successfully Loggedout.."
			$location.path('/login');
	},function(response){
		console.log(response.status)
		
	})
}
function getNotificationsNotViewed(){
	NotificationService.getNotificationsNotViewed().then(
			function(response){
		$rootScope.notifications=response.data
		$rootScope.notificationCount=$rootScope.notifications.length
	},function(response){
		$rootScope.error=response.data
		if(response.status==401)
			$location.path('/login');
	})
}
getNotificationsNotViewed();

})
