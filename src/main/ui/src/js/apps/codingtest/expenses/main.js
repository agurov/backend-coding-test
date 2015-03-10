"use strict";

/******************************************************************************************

Tasks main

******************************************************************************************/

require("./expenses-controller.js");

var app = angular.module("expenses.controllers", [
	"expenses.controller", "restangular"
]);

app.config(["$routeProvider", "RestangularProvider", function($routeProvider, RestangularProvider) {
    RestangularProvider.setBaseUrl("/api");

	// Labour analysis routes
	$routeProvider.when("/expenses", { templateUrl: "expenses-content.html" });
	
	$routeProvider.otherwise({redirectTo: "/expenses"});
}]);

app.run(["$rootScope", function($rootScope) {
	// Add app button
	$rootScope.appSections = $rootScope.appSections || [];
	$rootScope.appSections.push({ title: "Expenses", image: "static/img/icon-generic.png", app: "expenses" });
	
	// Configure tab sections
    var tabSections = [
        { title: "Expenses", app: "expenses" },
        { title: "Version", app: "version" }
    ];

	$rootScope.tabSections = $rootScope.tabSections || {};
	$rootScope.tabSections.expenses = tabSections;
    $rootScope.tabSections.version = tabSections;
}]);
