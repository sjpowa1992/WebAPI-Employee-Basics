app.controller('MainController', function($scope, $http) {

	$scope.test = function() {
		let url_string = "http://localhost:8080/frontEnd/info-employee.html"; //non cancellare altrimenti sarà errore
		let url = new URL(window.location.href); //window.location.href per cercare, altrimenti avrei messo url_string
		let myId = url.searchParams.get("myId"); //searchParams.get per cercare parametro get di myId
		console.log(myId);
		
		$http.get('http://localhost:8080/employees/' + myId).then(function(response) {
			$scope.employee = response.data;
			console.log($scope.employee);
		})
	}

	// ========================================================================

	// DELETE with Rest METHOD
	$scope.deleteEmployee = function(id) {
		var result = confirm("delete?")
		if (result == true) {
			$http.delete('http://localhost:8080/employees/delete/' + id)
				.then(function(response) {
					console.log('Employee deleted!')
				})
				.then(function(response) {
					alert('Employee deleted!')
				})
				.then(function() {
					window.location.reload();
				})
		}
	}

	// ========================================================================

	// GET all the Employees Rest METHOD

	$scope.GetAll = function() {
		$http.get('http://localhost:8080/employees').then(function(response) {
			$scope.employees = response.data;
		})
	}

	// ========================================================================

	// INSERT AN EMPLOYEE
	$scope.SaveEmployee = function(Employee) {

		//		alert(Employee.id);
		//		alert(Employee.firstName);
		//		alert(Employee.lastName);
		//		alert(Employee.email);

		$http.post('http://localhost:8080/employees/create-employee', Employee)
			.then(function(response) {
				console.log('Employee Successfully Inserted!')
			})
			.then(function(response) {
				alert("Employee Successfully Inserted")
			},
				function() {
					alert("Insert failed!")
				})

	}

	// ========================================================================

	// MODIFY AN EMPLOYEE
	$scope.EditEmployee = function(employee) {

		let url_string = "http://localhost:8080/frontEnd/edit-employee.html"; //non cancellare altrimenti sarà errore
		let url = new URL(window.location.href); //window.location.href per cercare, altrimenti avrei messo url_string
		let myId = url.searchParams.get("myId"); //searchParams.get per cercare parametro get di myId
		console.log(myId);

//		alert(myId);
//		alert(employee.firstName);
//		alert(employee.lastName);
//		alert(employee.email);

		$http.put('http://localhost:8080/employees/modify-employee/' + myId, employee)
			.then(function(response) {
				console.log('Employee Successfully Modified!')
			})
			.then(function(response) {
				alert("Employee Successfully Modified")
			},
				function() {
					alert("Modify failed!")
				})
			.then(function() {
				window.location.reload()
			})
	}

	// ========================================================================

	// DETAILS
	//	const myDiv = document.getElementById('details');
	//	myDiv.innerHTML ='the id is <strong>Boh</strong>';

	//	document.getElementById("employees");
	//	let nonsocomechiamarlo = document.querySelector('#poisivede');
	//	let content = document.querySelector('.content');
	//	
	//	nonsocomechiamarlo.addEventListener('click', (){
	//		content.innerText = employee; 
	//	})

	$scope.prova = function() {

		let url_string = "http://localhost:8080/frontEnd/edit-employee.html"; //non cancellare altrimenti sarà errore
		let url = new URL(window.location.href); //window.location.href per cercare, altrimenti avrei messo url_string
		let myId = url.searchParams.get("myId"); //searchParams.get per cercare parametro get di myId
//		console.log(myId);
//		console.log('ciao');
	}


}) // NON TOCCARE QUESTA GRAZIE