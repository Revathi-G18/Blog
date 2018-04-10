var myApp=angular.module("myApp",["ngRoute"]);

myApp.config(function($routeProvider)
{
	alert("Route Provider");
	$routeProvider.when("/",{templateUrl:"/index.html"})
			.when("/login",{templateUrl:"template/Login.html"})
			.when("/register",{templateUrl:"template/Register.html"})
			.when("/aboutUs",{templateUrl:"template/AboutUs.html"})
			.when("/contactUs",{templateUrl:"template/ContactUs.html"})
			.when("/UserHome",{templateUrl:"c_user/UserHome.html"})
			.when("/blog",{templateUrl:"c_blog/Blog.html"})
			.when("/showblog",{templateUrl:"c_blog/AllApprovedBlog.html"})
			.when("/allblog",{templateUrl:"c_blog/showAllblog.html"})
			.when("/myblog",{templateUrl:"c_blog/MyBlogs.html"})
			.when("/logout",{templateUrl:"c_user/Logout.html"})
});

myApp.run(function($rootScope,$cookieStore)
{console.log("i an in run function");
console.log($rootScope.currentUser);
if($rootScope.currentUser==undfined){
	$rootScope.currentUser=$cookieStore.get('userDetails');
}
});