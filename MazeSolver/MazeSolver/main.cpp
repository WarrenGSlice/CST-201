/*  * * * * * * * * * * * * *
Created by Warren Peterson
For use in CST-201 on date
12/2/2021 MAZE Project  * * *
* * * * * * * * * * * * * * */

#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include "MazeCell.h"
#include "MyStack.h"
#include "MyQ.h"

using namespace std;

#define NORTH 0
#define EAST 1
#define SOUTH 2
#define WEST 3
#define DONE 4
#define SUCCESS 10
#define FAILURE 20

//depthFirst header
void depthFirst(MazeCell start, MazeCell end);

//checks for validity of position
bool isValid(int r, int c);

//# rows and cols in the maze
int rows, cols;
//pointer to the grid (2-d array of ints)
int** grid;
//pointer to the maze cells (2-d array of MazeCell objects)
MazeCell** cells;

//this function should find a path through the maze
//if found, output the path from start to end
//if not path exists, output a message stating so

void depthFirst(MazeCell start, MazeCell end) {
    // Gets the initial row and column
    int row = start.getRow();
    int col = start.getCol();

    // creates a stack object of the MazeCell type and then we fill them with cells
    MyStack<MazeCell> stk;
    stk.push(cells[row][col]);

    // while we haven't reached the end
    while (grid[row][col] != 4) {
        grid[row][col] = 0;
        // Does a Depth First check of the cells in all directions
        // searching for the path from start to end
        //WEST
        if (((row,col - 1) >= 0) && (grid[row][col - 1] != 0)) {
            col--;
            stk.push(cells[row][col]);
        }
        // EAST
        else if (((row,col + 1) <= 5) && grid[row][col + 1] != 0) {
            col++;
            stk.push(cells[row][col]);
        }
        // SOUTH
        else if (((row + 1) <= 3) && grid[row + 1][col] != 0) {
            row++;
            stk.push(cells[row][col]);
        }
        // NORTH
        else if (((row - 1) >= 0) && grid[row - 1][col] != 0) {
            row--;
            stk.push(cells[row][col]);
        }
        // If it can't go any further, it pops the head to backtrace on step
        else {
            if (!stk.empty()) {
                stk.pop();
                MazeCell temp = stk.top();
                col = temp.getCol();
                row = temp.getRow();
            }
        }
    }

    // Iterate through the stack path and output that path
    if (!stk.empty()) {
        cout << "Maze Path: ";
        while (!stk.empty()) {
            cout << stk.top() << " ";
            stk.pop();
        }
    }
    // If else there is no solution
    else { cout << "No Exit" << endl; }
}

//return true if pos is on grid and represents an open cell
bool isValid(int r, int c) {
    if (r >= 0 && r < rows && c >= 0 && c < cols) {
        if (grid[r][c] != 0) {
            //anything but 0 is valid
            return true;
        }
        else {
            cout << "invalid location " << r << "," << c << endl;
        }
    }
    return false;
}

int main() {

    //create the Maze from the file
    ifstream fin("maze.in");
    if (!fin) {
        cout << "File not found\n";
        exit(2);
    }

    //read in the rows and cols
    fin >> rows >> cols;

    //create the maze rows
    grid = new int* [rows];

    //add each column
    for (int i = 0; i < rows; i++)
        grid[i] = new int[cols];

    //read in the data from the file to populate
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            fin >> grid[i][j];
        }
    }

    //look at it
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (grid[i][j] == 3)
                cout << "S" << " ";
            else if (grid[i][j] == 4)
                cout << "E" << " ";
            else
                cout << grid[i][j] << " ";
        }
        cout << endl;
    }

    //make a 2-d array of cells
    cells = new MazeCell * [rows];
    for (int i = 0; i < rows; i++) {
        cells[i] = new MazeCell[cols];
    }

    //all MazeCell in the cells grid has a default init
    //only update those cells that are not walls

    MazeCell start, end;

    //iterate over the grid
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (grid[i][j] != 0) {
                cells[i][j].setCoordinates(i, j);
                //look for the start and end cells
                if (grid[i][j] == 3)
                    start = cells[i][j];
                if (grid[i][j] == 4)
                    end = cells[i][j];

            }

        }
    }

    //testing
    cout << "start: " << start << " end: " << end << endl;

    //solve it!
    depthFirst(start, end);


    return 0;
}



