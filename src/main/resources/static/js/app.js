var myModule = angular.module("myApp",["ngRoute"])

myModule.config(function($routeProvider) {
	debugger;
			  $routeProvider
			  .when("/", {
			    templateUrl : "home.html",
			    controller : "indexController"
			  })
			  .when("/add", {
			    templateUrl : "add.html",
			    controller : "indexController"
			  })
			   .when("/update", {
				templateUrl : "update.html",
			    controller : "indexController"
			  })
			   .when("/delete", {
			    templateUrl : "delete.html",
			    controller : "indexController"
			  })
			  .otherwise({
				  redirecTo : "/"
			  });
			  
			});

myModule.controller("indexController",function($scope,$http){
	$scope.nameOfButton = "Search Customer";
	
	$scope.validate = function(){
		if(customer.no == "" || customer.no == undefined ||customer.firstName == null || customer.firstName == undefined || customer.lastName == null || customer.lastName == undefined || customer.designation == null || customer.designation == undefined){
			return false;
		}
		return true;
	}
		

		
	$scope.getAllEmployees = function(){
		debugger;
		$http({
			  method: 'GET',
			  url: 'http://localhost:8080/customer',
			  header : {'Content-Type': 'application/json' }
			}).then(function successCallback(response) {
					$scope.employeesList = response.data;
			  }, function errorCallback(response) {
				  console.log("No customer found");
			 });
		}
	
	
	$scope.addCustomer = function(customer){
		debugger;
		$http({
			  method: 'POST',
			  url: 'http://localhost:8080/customer',
			  data : {'id' : customer.no,'firstName' : customer.firstName, 'lastName' : customer.lastName, 'designation' : customer.designation }
			}).then(function successCallback(response) {
				$scope.showAlert = true;
				if(response.data[0] == "success"){
					$scope.addMessage = "Customer added successfully";
					$scope.messageClassForAdd = "alert alert-success";
				}else{
					$scope.addMessage = "Some error occured while saving customer!";
					$scope.messageClassForAdd = "alert alert-danger";
				}
			  }, function errorCallback(response) {
				  $scope.showAlert = true;
				  $scope.addMessage = "Some error occured while saving customer!";
				  $scope.messageClassForAdd = "alert alert-danger";
			 });
	}
	
	$scope.deleteCustomer = function(customer){
		$http({
			  method: 'DELETE',
			  url: 'http://localhost:8080/customer/'+customer.no,
			  header : {'Content-Type': 'application/json' }
			}).then(function successCallback(response) {
				$scope.messageClass = "alert alert-success";
				$scope.showAlertForDelete = true;
				if(response.data[0] == "success"){
					$scope.deleteMessage = "Customer removed successfully";
				}else{
					$scope.deleteMessage = "Some error occured while deleteing customer!";
				}
			  }, function errorCallback(response) {
				  $scope.messageClass = "alert alert-danger";
				  $scope.showAlertForDelete = true;
				  $scope.deleteMessage = "No Customer found!";
			 });
		
	}
})