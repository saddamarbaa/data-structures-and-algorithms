/** @format */

class Person {
	constructor(firstName, lastName, age) {
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.friends = [];
	}

	// Get Name of the new person created
	getName() {
		return 'Hello,' + ' ' + this.firstName + ' ' + this.lastName + '!';
	}

	// Create a new Friend
	createFriend(firstName, lastName, age) {
		let friend = new Person(firstName, lastName, age);
		this.friends.push(friend);
	}

	// List all Friends
	listAllFriends() {
		console.log('Friends List::' + '\n');
		if (this.friends.length !== 0)
			for (let i = 0; i < this.friends.length; i++) {
				console.log(
					this['firstName'] +
						' ' +
						" 's Friend: " +
						' ' +
						this.friends[i]['firstName'] +
						' ' +
						this.friends[i]['lastName'] +
						' ' +
						this.friends[i]['age'] +
						'\n',
				);
			}
	}

	// Read Friend's Information by LastName
	readFriend(lastName) {
		for (let i = 0; i < this.friends.length; i++) {
			if (this.friends[i].lastName === lastName) {
				return this.friends[i].firstName + ' ' + this.friends[i].lastName;
			}
		}
		return 'Friend does not exists!';
	}

	// Update Friend Information
	updateFriend(currentLastname, newFirstName, newLastName, newAge) {
		for (let i = 0; i < this.friends.length; i++) {
			if (this.friends[i].lastName === currentLastname) {
				this.friends[i].firstName = newFirstName;
				this.friends[i].lastName = newLastName;
				this.friends[i].age = newAge;
				return (
					this.friends[i].firstName +
					' ' +
					this.friends[i].lastName +
					' ' +
					this.friends[i].age
				);
			}
		}
		return 'Friend does not exists!';
	}

	//Delete a Friend by LastName
	deleteFriend(lastName) {
		for (let i = 0; i < this.friends.length; i++) {
			if (this.friends[i].lastName === lastName) {
				this.friends.splice(i, 1);
				return 'After Deletion:: ';
			}
		}
		return 'Friend does not exists';
	}
}

//Execution of all the functions

//Create a person1 object of Class Person
let person1 = new Person('Archana', 'Potnis', 30);
let person2 = new Person('Tina', 'Legere', 25);

console.log(person2.getName());

//Add Friends with Unique LastName
person1.createFriend('Naz', 'Dumanskyy', 25);
person1.createFriend('Rafaq', 'Qazi', 34);
person1.createFriend('Daniel', 'Davis', 35);
person1.createFriend('Jessy', 'K', 30);

person2.createFriend('Naz', 'Dumanskyy', 25);

//List All Friends added
//person1.listAllFriends();

person2.listAllFriends();

//Search Friends by LastName
console.log('Search by LastName::');
console.log(person1.firstName + "'s friend:: " + person1.readFriend('Davis'));

//Edit Friend's Information
console.log("Edit Friend's Information:: ");
console.log(person1.updateFriend('K', 'Jessy', 'K', 30));

// Delete a friend by LastName
console.log('Delete a Friend by a LastName::');
console.log(person1.deleteFriend('Dumanskyy'));
person1.listAllFriends();
