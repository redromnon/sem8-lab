// SPDX-License-Identifier: MIT
pragma solidity  ^0.8.17;

contract Ass3 {
    function sayHelloWorld() public pure returns (string memory) {
        return "Hello World";
    }

    string [] public animals;

    function addAnimal(string memory _name) public{

        animals.push(_name);

    }

    function getAnimalCount() public view returns (uint) {
        return animals.length;
    }

    function getAnimalNames() public view returns (string[] memory) {
        return animals;
    }
}
