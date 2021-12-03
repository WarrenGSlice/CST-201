#pragma once

/*  * * * * * * * * * * * * *
Created by Warren Peterson
For use in CST-201 on date
12/2/2021 MAZE Project  * * *
* * * * * * * * * * * * * * */

#ifndef MYQ_H
#define MYQ_H

template <class T>
class MyQ {
public:
	class DNode {
	public:
		T val;
		DNode* next, * prev;
		DNode(T v = T()) :val(v) { next = prev = this; }
	};
	MyQ() {
		header = new DNode();
		sz = 0;
	}
	void push(T v) {
		DNode* curr = new DNode(v);
		//add to end of list
		curr->prev = header->prev;
		curr->next = header;
		header->prev->next = curr;
		header->prev = curr;
		sz++;
	}
	void pop() {
		//remove item at front of q
		DNode* curr = header->next;
		header->next = curr->next;
		curr->next->prev = header;
		delete curr;
		sz--;
	}
	bool empty()const { return sz == 0; }
	int size()const { return sz; }
	T& front() { return header->next->val; }
	T front()const { return header->next->val; }

private:
	DNode* header;
	int sz;
};

#endif