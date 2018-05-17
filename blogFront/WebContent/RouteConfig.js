var myApp=angular.module("myApp",["ngRoute","ngCookies"]);

myApp.config(function($routeProvider)  
{
	alert("Route Provider");
	console.log("inside routeProvider block");
	$routeProvider.when("/",{templateUrl:"/index.html"})
			.when("/login",{templateUrl:"views/Login.html",controller:"UserController"})
			.when("/register",{templateUrl:"views/Register.html",controller:"UserController"})
			.when("/home",{templateUrl:"views/Home.html",controller:"UserController"})
			.when('/addblog',{templateUrl:'views/blogform.html',controller:'BlogCtrl'} )
			.when('/blogsnotapproved',{	templateUrl:'views/blogsnotapproved.html',controller:'BlogCtrl'} )
			.when('/blogsapproved',{templateUrl:'views/blogsapproved.html',controller:'BlogCtrl'} )
			.when("/logout",{templateUrl:"views/Logout.html"})
			/*.when("/contactUs",{templateUrl:"template/ContactUs.html"})
			.when("/UserHome",{templateUrl:"c_user/UserHome.html"})
			.when("/blog",{templateUrl:"c_blog/Blog.html"})
			.when("/showblog",{templateUrl:"c_blog/AllApprovedBlog.html"})
			.when("/allblog",{templateUrl:"c_blog/showAllblog.html"})
			.when("/myblog",{templateUrl:"c_blog/MyBlogs.html"})
			.when("/logout",{templateUrl:"c_user/Logout.html"})*/
});

myApp.run(function($location,$rootScope,UserService,$cookieStore,NotificationService)
{console.log("i an in run function");
console.log($rootScope.loggedInUser);
if($rootScope.loggedInUser==undefined){
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
})
