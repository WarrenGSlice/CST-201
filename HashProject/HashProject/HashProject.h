// Created by Warren Peterson for CST on 1/8/2022
// Adapted from the work of Nakul Bageja
// https://github.com/nakulBageja

#pragma once
#include <cstddef>

#define SIZE 26

using namespace std;

// Node class with initialized variables
struct Node {          
    string data;
    Node* next = NULL;
};

class HashTable {

public:

    // Takes the values and assigns them a hash value
    // Division Method Hash Function
    // O (n) since it depends on the quanity of words
    unsigned int DivisionHashFunction(string value, int tableSize) {

        unsigned seedValue = 1313;
        unsigned int keyValue = 0;
        for (unsigned i = 0; i < value.length(); i++) {
            keyValue = (keyValue * seedValue) + value[i];
        }
        keyValue = keyValue % tableSize;
        return keyValue;
    }

    
    /* loops through the entire size of the array and outputs all values
     * in the case of a linked list, the loop searches for the next node to equal null*/
    // Displays the contents on the lists
    // O(n^2)
    void displayTable(Node* table[]) {
        Node* list;
        cout << "This is the Hash Table Generated from the File";
        for (int i = 0; i < SIZE; i++)
        {
            list = table[i];
            cout << i << ". ";
            while (list != nullptr)
            {
                cout << list->data << " - ";
                list = list->next;
            }
            cout << endl;
        }
    }

    // finds the value the user inputs within the linked list
    // O(n) since it depends on the quanity of words to search through
    int ValueSearch(string word, Node* table[], const unsigned int MIN_WORD, const int MAX)
    {
        string resultWord;
        unsigned int index;
        resultWord = FormatStrings(word, MIN_WORD);//make all the words consistent
        //if length of word is greater than zero
        if (resultWord.length() > MIN_WORD) { 
            //find index after hashing the word
            index = DivisionHashFunction(resultWord, MAX);
            //check index in hash table is not null
            if (table[index] != nullptr) {
                //if data is found, return the value
                if (table[index]->data == word)
                    cout << "found at index " << index << endl;
                return true;
            }
            //if linkedlist at the index is present, traverse it
            else if (table[index]->next != nullptr) {
                Node* value = table[index];
                // Loop through the hash table until the value is found
                while (value != nullptr) {
                    //if data is found, return the value
                    if (value->data == word) {
                        cout << "found at index " << index << endl;
                        return true;
                    }
                    value = value->next;
                }
            }
            //if no data at position then value is not in the array
            else if (table[index] == nullptr) {
                cout << "Not here " << endl;;
                return false;
            }
        }
    }


    // Helper Method to Read the File and Process the Values
    // Could possibly be O(n!) upper bound because of how many recursive operations occur depending
    // on the number of words it has to read. 
    // Could be O(n) lower bound if hash table is empty
    // I do not know this for sure, but this is my guess, I'd love to hear your take
    int ReadFromFile(string FILE_NAME, const int MAX, const unsigned MIN_WORD, Node* table[]) {

        ifstream myFile;
        string myWords;
        string searchedWord;
        unsigned int index;
        int values = 0;
        cout << "Project done by Warren Peterson\n\nOpening file text.in\n\n";
        myFile.open(FILE_NAME);
        // If File is not Found, Throw an Error
        if (myFile.fail()) {
            cout << " File Not Found!! Fix Your File!";
            cin.get();
            return 0;
        }
        // Loops through the words in the file and makes the consistent, hashes them, and
        // Inserts them into the hash table
        while (myFile >> myWords) {
            searchedWord = FormatStrings(myWords, MIN_WORD);//processes the words in the file
            // If the length of the word is greater than 0
            if (searchedWord.length() > MIN_WORD) {
                // hashes the words and finds the key values
                index = DivisionHashFunction(searchedWord, MAX);
                // Turns the words into integer values and stores it at the generated key
                values += Insert(index, table, searchedWord);
            }
        }
        return values;
    }

    // makes all words LowerCase, removes numbers and symbols makes all words consistent
    //O(n) time complexity depends on number of words in the file
    string FormatStrings(string word, const unsigned MIN_WORD) {

        string temp;
        unsigned position = 0;
        bool hasNumber = false;
        //if word length is less than 0
        if (word.length() <= MIN_WORD) {
            return temp;
        }
        // delete not alphabetic words great than size 0
        while (word.length() > MIN_WORD && (!isalpha(word.at(position)))) {
            word.erase(position, 1);
        }
        // if word is greater than size 0, remove apostrophies
        if (word.length() > MIN_WORD) {
            position = word.length() - 1;
            while (position >= 0 && (!isalpha(word.at(position)))) {
                word.erase(position, 1);
                position--;
            }
        }
        // Remove numbers from words
        if (word.length() > MIN_WORD) {
            for (unsigned i = 0; i < word.length(); i++) {
                if (isdigit(word.at(i))) {
                    hasNumber = true;
                }
            }
            if (hasNumber) {
                return temp;
            }
        }
        // Make all words LowerCase
        if (word.length() > MIN_WORD) {
            for (unsigned i = 0; i < word.length(); i++) {
                word.at(i) = tolower(word.at(i));
            }
            return word;
        }
        return temp;
    }

    // worst case is O(n)
    // Insert places data into the array and gives it a unique key
    // Stores words in Hash Table
    int Insert(unsigned key, Node* table[], string word) {

        Node* newNode = new Node(); //creates the node to insert words
        newNode->data = word;
        newNode->next = nullptr;
        int flag = 1;
        int sum = 0;
        //if linked list key value is null, add newnode
        if (table[key] == nullptr) {
            table[key] = newNode;
        }
        else {
            //if the value is a duplicate word then exit out
            if (table[key]->data == word) {
                return 0;
            }
            Node* previous_ptr = nullptr;
            Node* hashCode = table[key];
            bool insert = true;
            // if the value table[key] is a unique word then
            // traverse the linkedlist
            while (hashCode != nullptr){
                sum++;
                previous_ptr = hashCode; 
                hashCode = hashCode->next;
            }
            if (flag == 0) {
                return 0;
            }
            //if the word is not present then add the newnode to the linkedlist
            if (insert == true) {
                previous_ptr->next = newNode; 
            } 
        }
        return sum;
    }
};
