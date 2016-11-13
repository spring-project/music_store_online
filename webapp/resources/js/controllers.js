var cartApp = angular.module("cartApp", []);

cartApp.controller("cartCtrl", function($scope, $http) {
	var cartUrl = '/MusicStoreOnline/rest/carts/';
	var cartOne = cartUrl + 'cartId'; 
	var cartAdd = cartUrl + 'insert/';
	var cartDel = cartUrl + 'remove/';
	
	$scope.refreshCart = function(cartId) {
		$http.get(cartUrl + cartId).success(function (data){
			$scope.cart = data;
			console.log("Data: ", data);
		});
	}
	
	$scope.clearCart = function() {
		console.log("cartApp.clearCart");
		$http.delete(cartUrl + $scope.cartId).success(function (data){
			$scope.refreshCart($scope.cartId);
		});
	}
	
	$scope.addToCart = function(productId) {
		console.clear();
		$http.put(cartAdd + productId).success(function (data){
//			var cartId = $http.get(cartOne);
			$scope.refreshCart($scope.cartId);
			alert("Product was added to cart");
		});
	}
	
	$scope.removeFromCart = function(productId) {
		console.log("cartApp.removeFromCart");
		$http.put(cartDel + productId).success(function (data){
//			var cartId = $http.get(cartOne);
			$scope.refreshCart($scope.cartId);
			alert("Product was removed from cart");
		});
	}
	
	$scope.initCart = function(cartId) {
		$scope.cartId = cartId;
		$scope.refreshCart(cartId);
		console.log("cartApp.initCart");
	}
	
});