// Created by Warren Peterson for CST-201 1/8/2022.
//
#include <iostream>
#include <fstream>
#include "HashProject.h"

using namespace std;

int main() {

    HashTable hashTable; // Initialzes methods from HashTable
    const int MAX = 26; // Sets the size of the HashTable
    const unsigned MIN_WORD = 0; // Sets the Mimimum size of a word
    const string FILE_NAME = "text.in"; // Sets the File being parsed
    // initializes list of a specific size from the Node class
    Node* list[MAX];
    string inputWord; // string to take user input values
    int hashing; // takes value of hashed words
    // Populates Hash Table
    for (int i = 0; i < MAX; i++) {
        list[i] = nullptr;
    }
    hashing = hashTable.ReadFromFile(FILE_NAME, MAX, MIN_WORD, list);
    hashTable.displayTable(list); // Displays Hash Table

    while (true) {
        cout << "Word to search (-1 to cancel): ";
        cin >> inputWord;
        if (inputWord != "-1") {
            cout << hashTable.ValueSearch(inputWord, list, MIN_WORD, MAX) << endl;
        }
        else {
            break;
        }
    }
    return 0;
}