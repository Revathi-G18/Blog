myApp.factory('BlogService',function($http){
	var BASE_URL="http://localhost:8085/blogMiddle"
		var blogService={}
	blogService.addBlog=function(blog){
		console.log(blog)
		return $http.post(BASE_URL+"/addblogpost", blog)
	}
	blogService.getBlogsWaitingForApproval=function(){
		return $http.get(BASE_URL+"/getblogs/"+0)
		
	}
	blogService.getBlogsApproved=function(){
		return $http.get(BASE_URL+"/getblogs/"+1)
		
	}
	return blogService;
})