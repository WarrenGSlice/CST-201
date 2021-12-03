#pragma once
/*  * * * * * * * * * * * * *
Created by Warren Peterson
For use in CST-201 on date
12/2/2021 MAZE Project  * * * 
* * * * * * * * * * * * * * */

#ifndef MYSTACK_H
#define MYSTACK_H

/*
 * Template Node class
 * Creates nodes used in the stack
 */
template<class T>
struct Node {
    T data;
    Node(T v) {
        data = v;
        next = nullptr;
    }
    struct Node* next;
};

/*
 * Template stack class
 * creates the basic functions of a stack
 */
template<class T>
class MyStack {
private:
    Node<T>* head;
    Node<T>* tail;

    int length;

public:
    MyStack() : head(nullptr), tail(nullptr), length(0) {}

    virtual void push(T);
    virtual void pop();

    virtual bool empty() const { 
        return length == 0; 
    }
    virtual int size() const { 
        return length; 
    }

    virtual T& top() { return head->data; }

};
// Push method adds a new element to the top of the Stack
template<class T>
void MyStack<T>::push(T val) {
    Node<T>* n_node = new Node<T>(val);

    n_node->next = head;
    head = n_node;
    Node<T>* temp = head;

    while (temp->next != nullptr) { temp = temp->next; }
    tail = temp;

    length++;
}
// Pop method Removes the element at the top of the Stack
template<class T>
void MyStack<T>::pop() {
    if (empty()) return;

    Node<T>* temp = head;
    head = temp->next == nullptr ? nullptr : temp->next;

    if (tail == temp) { tail = head; };
    delete temp;

    length--;
};

#endif //MYSTACK_H