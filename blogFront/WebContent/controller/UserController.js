myApp.controller('UserController',function($scope,$rootScope,$location,UserService,$cookieStore){
	$scope.registerUser=function(){
		alert('Entering Usercontroller in frontend ' + $scope.userdetail)
		console.log('entering usercontroller in frontend' +$scope.userdetail)
		
		UserService.registerUser($scope.userdetail).then(
				function(response){					
					alert('Registered Successfully....please login again..')
					$location.path('/login')
								},function(response){
									console.log(response)
									console.log("error")
										/*alert('Registered Successfully....please login again..')
										$location.path('/login')*/
									$scope.error=response.data
								})
	}
	$scope.login=function(userdetail){
		console.log('Usercontroller-->login')
		console.log($scope.userdetail)
		UserService.login($scope.userdetail).then(
				function(response) {
			$rootScope.loggedInUser=response.data
			console.log($rootScope.loggedInUser)
			console.log("name")
			$cookieStore.put('currentuser',response.data)
			$location.path('/home') 
			},function(response){
				console.log('error')
			$scope.error=response.data
			$location.path('/login')
		})
	}
	if($rootScope.loggedInUser!=undefined){
		UserService.getUser().then(
		function(response){
			$scope.user=response.data
		},
		function(response){
			if(response.status==401)
				$location.path('/login');
		})
	}
	$scope.updateUser=function(userdetail){
		console.log("in update user")
		UserService.updateUser(userdetail).then(
		function(response){
			alert('updated user profile successfully....')
			$rootScope.loggedInUser=response.data
			$cookieStore.put('loggedInUser',response.data)
			$location.path('/home');
		},function(response){
			console.log("error")
			if(response.status==401)
				$location.path('/login');
			else
				$scope.error=response.data
		})
	}
	$rootScope.searchUser=function(user){
		console.log(user)
		UserService.searchUser(user).then(function(){
			console.log(users)
			$scope.users=response.data
		},function(response){
			$scope.error=response.data
			$location.path('/login')
		})
	}
})