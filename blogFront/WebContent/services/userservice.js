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
	
	userService.login=function(userdetail)
	{   console.log('userservice-->login') 
		console.log(userdetail)
		return $http.post(BASE_URL +"/login", userdetail)
	}
	userService.logout=function()
	{
		console.log("b4 logged out...")

		return $http.put(BASE_URL +"/logout")
		console.log("logged out...")
	}
	userService.getUser=function(){
		console.log("in getuser of user service")
		return $http.get(BASE_URL +"/getuser")
	}
	userService.updateUser=function(userdetail){
		console.log(userdetail)
		console.log($http.put(BASE_URL +"/updateUser",userdetail))
		return $http.put(BASE_URL +"/updateUser",userdetail)
	}
	userService.searchUser=function(userdetail){
		console.log("searchuser..")
		return $http.get(BASE_URL +"/searchuser/"+user)
	}
	return userService;
})