// SPDX-License-Identifier: MIT
pragma solidity ^0.8.17;

contract SimpleBank {
    struct ClientAccount {
        int clientId; // Keep Client ID
        address clientAddress; // Keep Client Address
        uint clientBalanceInEther; // Keep Client Ether balance
    }

    ClientAccount[] clients; // Array of all client maintain information
    int clientCounter;
    address payable manager; // Payable function to receive ether. Address is a 20-byte hash address/public key.

    modifier onlyManager() {
        require(msg.sender == manager, "Only manager can call this!");
        _;
    }

    modifier onlyClients() {
        bool isClient = false;
        for (uint i = 0; i < clients.length; i++) {
            if (clients[i].clientAddress == msg.sender) {
                isClient = true;
                break;
            }
        }
        require(isClient, "Only clients can call this!");
        _;
    }

    constructor() {
        clientCounter = 0; // Initially set client join contract ID to 0
    }

    receive() external payable {} // Allows the smart contract to receive ether

    function setManager(address managerAddress) public returns (string memory) {
        manager = payable(managerAddress);
        return "";
    }

    function joinAsClient() public payable returns (string memory) {
        clients.push(ClientAccount(clientCounter++, msg.sender, address(msg.sender).balance));
        return "";
    }

    function deposit() public payable onlyClients {
        payable(address(this)).transfer(msg.value);
    }

    function withdraw(uint amount) public payable onlyClients {
        payable(msg.sender).transfer(amount * 1 ether);
    }

    function sendInterest() public payable onlyManager {
        for (uint i = 0; i < clients.length; i++) {
            address initialAddress = clients[i].clientAddress;
            payable(initialAddress).transfer(1 ether);
        }
    }

    function getContractBalance() public view returns (uint) {
        return address(this).balance;
    }
}

