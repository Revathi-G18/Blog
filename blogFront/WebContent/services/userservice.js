myApp.factory('UserService',function($http)
{
	var BASE_URL="http://localhost:8085/blogMiddle"
	var userService={}
	userService.registerUser=function(userdetail)
	{
		console.log(userdetail)
		console.log("in user service")	
		console.log($http.post(BASE_URL+ "/registeruser", userdetail))
		return $http.post(BASE_URL+ "/registeruser", userdetail)
		
	}
	
	userService.login=function(user)
	{   console.log('userservice-->login') 
		console.log(user)
		return $http.post(BASE_URL +"/login", user)
	}
	return userService;
})